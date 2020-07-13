package com.example.navigation.flowEngine

import android.util.Log
import com.example.navigation.flowEngine.actions.Action
import com.example.navigation.flowEngine.actions.FunctionAction
import com.example.navigation.flowEngine.actions.RuleAction
import com.example.navigation.flowEngine.actions.ScreenAction
import com.example.navigation.flowEngine.steps.field.Field
import com.example.navigation.flowEngine.steps.field.FieldId
import com.example.navigation.flowEngine.steps.Step
import com.example.navigation.flowEngine.steps.flowState.FlowState

class FlowManager {
    lateinit var flowState: FlowState private set
    private lateinit var flowMediator: FlowMediator
    private lateinit var flow: Flow
    private var currentAction = RuleAction()
    private var currentStep = Step()

    /**
     * Se intstancia el flow correspondiente al tipo de operacion, inicializa el json
     * @param flowMediator: contiene el mappeo de las instancias que representan las actions (Activities)
     * @param flow: entidad que representa el json de los steps y actions
     * @param paymentFlowState: contiene el estado actual del pago
     */
    fun startFlow(flowMediator: FlowMediator, flow: Flow, paymentFlowState: FlowState) {
        this.flow = flow
        this.flowMediator = flowMediator
        this.flowState = paymentFlowState

        executeNextStep()
    }

    /**
     * Modifica el valor de un determinado field del FlowState
     */
    fun setField(field: FieldId, value: Any?) {
        getField(field).set(flowState, value)
    }

    /**
     * Retorna el valor de un determinado field del FlowState
     */
    fun getField(field: FieldId): Field {
        return flowState.getField(field.id())
    }

    /**
     * Validacion de un field especifico: se busca sobre las validations que coincidan
     * con el campo requerido
     * @param currentAction accion actual, que en caso de no cumplir con la/s regla/s sabe como resolverla
     * @param idField campo a validar
     * @return
    </Field> */
    private fun validate(currentAction: Action, idField: FieldId): Boolean {
        val validations = flow.validations.filter { it.field == idField.id() }

        validations.forEach {
            if (!it.rule.evaluate(flowState)) {
                currentAction.resolveUnfulfilledRule(it)
                return false
            }
        }

        return true
    }

    /**
     * Ir al siguiente action o step: primero se validan todos los campos de la action actual
     * @param mCurrentAction
     */
    fun next(mCurrentAction: Action) {
        try {
            if (validateAll(mCurrentAction)) {
                executeNext()
            }
        } catch (ex: Exception) {
            Log.e("Error", ex.message, ex.cause)
        }
    }

    /**
     * 1-Deshago los cambios sobre los campos que haya afectado el action actual (resetFields)
     * 2-Busco action previa a la actual, y si es una function action, continuo buscando
     * la previa hasta encontrar una Screen action. Mientras busco, reinicio los campos
     * de esas function actions
     * 3-Cuando no se encontro una function action (termina el while), y previousRuleAction es null,
     * entonces no tengo mas actions para este step y vuelvo al step anterior, en su ultima action
     * si previousRuleAction no es null, es decir que hay una screen action encontrada,
     * la establezco como la actual
     */
    fun goBack(currentScreenAction: ScreenAction) {
        //1-
        resetFields(currentScreenAction)

        //2-
        var previousRuleAction = currentStep.previousAction(currentAction)
        var previousFunctionAction = flowMediator.getAction(previousRuleAction)

        while (previousFunctionAction != null) {
            resetFields(previousFunctionAction)
            previousRuleAction = currentStep.previousAction(previousRuleAction)
            previousFunctionAction = flowMediator.getAction(previousRuleAction)
        }

        //3-
        if (previousRuleAction == null) {
            currentStep = flow.getPreviousStep(currentStep)
            currentAction = currentStep.getLastAction()

        } else {
            currentAction = previousRuleAction
        }

    }

    /**
     * Agrego una Function Action al stack para ser ejecutada en el step actual
     */
    fun addAction(action: FunctionAction) {
        flowMediator.addAction(action)
    }

    private fun validateAll(mCurrentAction: Action): Boolean {
        mCurrentAction.fields?.forEach {
            if (!validate(mCurrentAction, it.id))
                return false
        }

        return true
    }

    private fun resetFields(action: Action) {
        action.fields?.forEach {
            it.initState(flowState)
        }
    }

    /**
     * Para el step actual busco cual/es es/son la/s action/s que satisface los campos requeridos
     */
    private fun getStepActions(step: Step): List<RuleAction> {

        var candidates: List<RuleAction>?

        candidates = flow.actions.filter {
            toString().contains(step.requiredFieldsToString())
        }


        if (candidates.isEmpty()) {
            candidates = flow.actions.filter { action ->
                step.requiredFields?.forEach {
                    if (action.containsField(it)) {
                        return@filter true
                    }
                }
                false
            }
        } else if (candidates.size > 1) {
            candidates = candidates.filter {
                toString().contains(step.optionalFieldsToString())
            }
        }

        //TODO: si no tiene ninguna accion asociada con ningun campo requerido, buscar una accion asociada
        // al identificador del step
        require(candidates.isNotEmpty()) {
            String.format("the %s step has no any action associated. " +
                "Check steps and actions", currentStep.stepIdentifier.name)
        }


        return candidates
    }

    /**
     * Chequea si existe una proxima Action dentro de las acciones del Step actual
     * Si no es asi, se evalua la rule del step (se deberia cumplir ) y avanza al siguiente step
     */
    private fun executeNext() {
        val nextAction = currentStep.getNextAction(currentAction)
        if (nextAction != null) {
            currentAction = nextAction
            startAction(currentAction)
        } else if (!currentStep.mustExecute(flowState)) {
            executeNextStep()
        } else {
            throw IllegalStateException("Revisar las rules y validations de salida, " +
                "se tendrian que haber cumplido las validaciones")
        }
    }

    /**
     * Busca el siguiente step, establece sus actions y establece la primera
     */
    private fun executeNextStep() {
        currentStep = flow.getNext(flowState)
        currentStep.actions = getStepActions(currentStep)
        currentAction = currentStep.getFistAction()

        startAction(currentAction)
    }

    private fun startAction(action: RuleAction) {
        flowMediator.executeAction(action)
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