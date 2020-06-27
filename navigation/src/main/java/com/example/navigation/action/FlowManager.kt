package com.example.navigation.action

import android.util.Log
import com.example.navigation.stepsEngine.field.Field
import com.example.navigation.stepsEngine.flow.Flow
import com.example.navigation.stepsEngine.flow.Step
import com.example.navigation.stepsEngine.payment.FlowState

class FlowManager {
    lateinit var paymentFlowState: FlowState private set
    private lateinit var actionMapper: ActionMapper
    private lateinit var flow: Flow
    private lateinit var currentAction: RuleAction

    private var currentStep = Step()
        set(value) {
            field = value
            field.actions = getStepActions(field)
            currentAction = field.getNextAction(null)!!
        }
    private lateinit var actions: List<RuleAction>


    private fun validateAll(mCurrentAction: Action): Boolean {
        mCurrentAction.fields.forEach {
            if (!validate(mCurrentAction, it.getId()))
                return false
        }

        return true
    }

    /**
     * Se intstancia el flow correspondiente al tipo de operacion, inicializa el json
     * ActionMapper: es donde se crean las instancias de las actions con lo necesario para implementar en android
     */
    fun startFlow(actionMapper: ActionMapper, flow: Flow, paymentFlowState: FlowState, actions: List<RuleAction>) {
        this.actions = actions
        this.flow = flow
        this.actionMapper = actionMapper
        this.paymentFlowState = paymentFlowState
        executeFirstStep()
    }

    /**
     * Validacion de reglas que pertenecen a campos especificados en List<Field> fields (no se evalua toda la rule aca)
     * @param currentAction accion actual, que en caso de no cumplir con la/s regla/s sabe como resolverla
     * @param fields campos a validar
     * @return
    </Field> */
    private fun validate(currentAction: Action, idField: String): Boolean {
        val validations = flow.validations.filter { it -> it.field == idField }

        validations.forEach {
            if (!it.rule.evaluate(paymentFlowState)) {
                currentAction.resolveUnfullfiledRule(it)
                return false
            }
        }

        return true
    }

    /**
     * Se evalua si la action cumple o no las reglas para pasar al siguiente action o step.
     * Se actualizan todos los campos que resuelve la action actual para luego evaluar la regla de forma parcial (si no es el ultimo action del step)
     * o total si ya no tengo mas acciones por cumplir y requiero pasar al proximo step
     * @param mCurrentAction
     */
    fun next(mCurrentAction: Action) {
        try {
            if (validateAll(mCurrentAction)) {
                executeNext(mCurrentAction)
            }
        } catch (ex: Exception) {
            Log.e("Error", ex.message, ex.cause)
        }
    }

    /**
     * 1-deshago los cambios sobre los campos que haya afectado el action actual (la pantalla actual
     * 2-Busco si existe una accion previa a la actual
     * 3-Si existe, vuelvo a esa accion, sino, busco el step anterior al actual y su ultima accion
     *
     */
    fun back(mCurrentAction: Action) {
        mCurrentAction.fields.forEach {
            //TODO: analizar bien si alcanza con volver a null el valor
            it.set(paymentFlowState, null)
        }
        val previousAction = currentStep.previousAction(currentAction)
        if (previousAction == null) {
            currentStep = flow.getPreviousStep(currentStep)
            currentAction = currentStep.getLastAction()

        } else {
            currentAction = previousAction
        }
    }


    /**
     * Se busca el mejor listado de acciones que satisfagan el step actual. Debemos tener en cuenta las siguientes precondiciones:
     *
     * 1 - No pueden haber dos acciones activas que satisfagan exactamente los mismos fields (requeridos + opcionales).
     * Si quisiéramos por ejemplo hacer un A/B testing de dos pantallas distintas que hagan lo mismo, en el endpoint de acciones
     * le deberían llegar a los distintos usuarios la acción que queramos que se ejecute.
     * 2 - Dentro de un step, si es satisfecho por varias acciones, el orden de ejecución de las acciones estará dado
     * por el orden relativo de las acciones.
     *
     * La política apunta a resolver el step en la menor cantidad posible de acciones, abarcando todos los fields requeridos
     * y la mayor cantidad posible de opcionales. Dicho esto, se toman las siguientes prioridades:
     *
     * 1- Si hay una acción que matchee todos los fields requeridos, se toma esa acción.
     * 2- Si hay una acción que matchea más fields requeridos que otra, entonces gana esa acción.
     * Ej: acción 1 matchea A y B, y acción 2 solo matchea B, entonces gana acción 1.
     * 3- Si hay dos acciones que matchean los mismos fields requeridos, se toma entonces la que matchee más fields opcionales.
     */
    private fun getStepActions(step: Step): List<RuleAction> {


        var candidates: List<RuleAction>?

        candidates = actions.filter {
            toString().contains(step.requiredFieldsToString()!!)
        }


        if (candidates!!.isEmpty()) {
            candidates = actions.filter { action ->
                step.requiredFields?.forEach {
                    if (action?.fields!!.contains(it)) {
                        return@filter true
                    }
                }
                false
            }
        } else if (candidates!!.size > 1) {
            candidates = candidates?.filter {
                toString().contains(step.optionalFieldsToString()!!)
            }
        }

        //TODO: si no tiene ninguna accion asociada con ningun campo requerido, buscar una accion sociada al identificador del step
        require(candidates!!.isNotEmpty()) { String.format("the %s step has no any action associated. Check steps and actions", currentStep.stepIdentifier.name) }


        return candidates!!
    }

    /**
     * Chequea si existe una proxima Action dentro de las acciones del Step actual
     * Si no es asi, se evalua la rule del step (se deberia cumplir )
     */
    private fun executeNext(mCurrentAction: Action) {

        val nextAction = currentStep.getNextAction(currentAction)
        if (nextAction != null) {
            currentAction = nextAction
            executeAction(currentAction!!)
        } else if (!currentStep.mustExecute(paymentFlowState)) {
            executeNextStep(mCurrentAction)
        } else {
            throw IllegalStateException("Revisar las rules y validations de salida, se tendrian que haber cumplido las validaciones")
        }
    }

    private fun executeNextStep(mCurrentAction: Action) {
        currentStep = flow!!.getNext(paymentFlowState)

        if (currentAction!!.id == mCurrentAction.name) {
            executeNextField(mCurrentAction)
        } else {
            executeAction(currentAction!!)
        }
    }

    private fun executeFirstStep() {
        currentStep = flow!!.getNext(paymentFlowState)

        executeAction(currentAction!!)
    }

    private fun executeAction(action: RuleAction) {
        //TODO: evaluar que partametros son necesarions pasar a la accion
        actionMapper!!.executeAction(action, currentStep.requiredFields, currentStep.optionalFields)
    }

    private fun executeNextField(action: Action) {
        //TODO: evaluar que partametros son necesarions pasar a la accion
        actionMapper!!.executeNextField(action, currentStep.requiredFields, currentStep.optionalFields)
    }


    companion object {
        @JvmStatic
        var i: FlowManager? = null
            get() {
                if (field == null) {
                    field = FlowManager()
                }
                return field
            }
            private set

    }
}