package com.example.navigation.action

import android.util.Log
import com.example.navigation.mappers.ActionMapper
import com.example.navigation.stepsEngine.field.Field
import com.example.navigation.stepsEngine.field.FieldId
import com.example.navigation.mappers.FieldMapper
import com.example.navigation.stepsEngine.flow.Flow
import com.example.navigation.stepsEngine.flow.Step
import com.example.navigation.stepsEngine.payment.FlowState

class FlowManager {
    lateinit var paymentFlowState: FlowState private set
    private lateinit var actionMapper: ActionMapper
    private lateinit var fieldMapper: FieldMapper
    private lateinit var flow: Flow
    private var currentAction = RuleAction()

    private var currentStep = Step()
        set(value) {
            field = value
            field.actions = getStepActions(field)
            currentAction = field.getNextAction(null)!!
        }


    private fun validateAll(mCurrentAction: Action): Boolean {
        mCurrentAction.fields?.forEach {
            if (!validate(mCurrentAction, it.id))
                return false
        }

        return true
    }

    /**
     * Se intstancia el flow correspondiente al tipo de operacion, inicializa el json
     * @param actionMapper: contiene el mappeo de las instancias que representan las actions (Activities)
     * @param flow: entidad que representa el json de los steps y actions
     * @param paymentFlowState: contiene el estado actual del pago
     */
    fun startFlow(actionMapper: ActionMapper, flow: Flow, paymentFlowState: FlowState, fieldMapper: FieldMapper) {
        this.fieldMapper = fieldMapper
        this.flow = flow
        this.actionMapper = actionMapper
        this.paymentFlowState = paymentFlowState
        executeFirstStep()
    }

    /**
     * Este metodo es llamado por la action para modificar los valores de FlowState
     */
    fun setField(field: Field, value: Any?) {
        field.set(paymentFlowState, value)
    }

    /**
     * Validacion de un field especifico: se busca sobre las validaciones de salida las que coincidan con el campo requerido
     * @param currentAction accion actual, que en caso de no cumplir con la/s regla/s sabe como resolverla
     * @param idField campo a validar
     * @return
    </Field> */
    private fun validate(currentAction: Action, idField: FieldId): Boolean {
        val validations = flow.validations.filter { it -> it.field == idField.id()}

        validations.forEach {
            if (!it.rule.evaluate(paymentFlowState)) {
                currentAction.resolveUnfullfiledRule(it)
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
        mCurrentAction.fields?.forEach {
            it.initState(paymentFlowState)
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

        //TODO: si no tiene ninguna accion asociada con ningun campo requerido, buscar una accion asociada al identificador del step
        require(candidates.isNotEmpty()) { String.format("the %s step has no any action associated. Check steps and actions", currentStep.stepIdentifier.name) }


        return candidates
    }

    /**
     * Chequea si existe una proxima Action dentro de las acciones del Step actual
     * Si no es asi, se evalua la rule del step (se deberia cumplir ) y avanza al siguiente step
     */
    private fun executeNext(mCurrentAction: Action) {

        val nextAction = currentStep.getNextAction(currentAction)
        if (nextAction != null) {
            currentAction = nextAction
            startAction(currentAction)
        } else if (!currentStep.mustExecute(paymentFlowState)) {
            executeNextStep(mCurrentAction)
        } else {
            throw IllegalStateException("Revisar las rules y validations de salida, se tendrian que haber cumplido las validaciones")
        }
    }

    /**
     * Busca el siguiente step a ejecutar
     * Si la primera action del nuevo step actual coincide con la ultima action del step anterior (mCurrentAction),
     * entonces sobre esa misma action (mCurrentAction), ejecuta los campos requeridos por el currentStep, sino ejecuta la currentAction
     */
    private fun executeNextStep(mCurrentAction: Action) {
        currentStep = flow.getNext(paymentFlowState, fieldMapper)

        if (currentAction.id == mCurrentAction.name.id()) {
            executeNextField(mCurrentAction)
        } else {
            startAction(currentAction)
        }
    }

    private fun executeFirstStep() {
        currentStep = flow.getNext(paymentFlowState, fieldMapper)

        startAction(currentAction)
    }

    private fun startAction(action: RuleAction) {
        actionMapper.startAction(action)
    }

    private fun executeNextField(action: Action) {
        //TODO: Evaluar si es necesario pasar tambien los campos opcionales llegado el caso
        actionMapper.executeNextField(action, getFields(currentStep.requiredFields))
    }

    private fun getFields(fieldsStr: List<String>?) : List<Field>? {
        val fields = ArrayList<Field>()
        fieldsStr?.forEach {
            fields.add(fieldMapper.getField(it))
        }
        return fields
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

        fun getField(fieldId: String): Field {
            return i?.fieldMapper?.getField(fieldId)!!
        }
    }
}