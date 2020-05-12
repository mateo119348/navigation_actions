package com.example.navigation.action

import com.example.navigation.stepsEngine.flow.Flow
import com.example.navigation.stepsEngine.flow.Step
import com.example.navigation.stepsEngine.flow.rules.base.Rule
import com.example.navigation.stepsEngine.flow.rules.comparable.ComparableRule
import com.example.navigation.stepsEngine.flow.rules.logic.LogicRule
import com.example.navigation.stepsEngine.payment.FlowState
import kotlin.collections.ArrayList

class FlowManager {
    private lateinit var paymentFlowState: FlowState
    private var currentActions: List<RuleAction>? = null
    private var currentAction: RuleAction? = null
    private var currentStep: Step? = null
    private var flow: Flow? = null
    private var actions: List<RuleAction>? = null
    private var currentActionIndex = 0
    private var actionMapper: ActionMapper? = null

    /**
     *
     * @param attributes
     * @return
     */
    private fun getCurrentSubRules(attributes: List<Field>, currentRule: Rule): List<Rule> {
        val retval: MutableList<Rule> = ArrayList()
        if (currentRule is LogicRule) {
            for (subRule in currentRule.rules) {
                retval.addAll(getCurrentSubRules(attributes, subRule))
            }
        } else if (currentRule is ComparableRule) {
            for (attribute in attributes) {
                if (attribute.getId() == currentRule.fieldName) {
                    retval.add(currentRule)
                }
            }
        }
        return retval
    }

    private fun validateAll(mCurrentAction: Action, currentRule: Rule): Boolean {

        //Si la regla del Step es del tipo AND (debo hacer que no cumpla al menos una sub rule para salir del step)
        //Estas se evaluan en el ultimo action. Ante la primera que cumple, muestro el error
//        if (currentRule instanceof AndRule) {
//            if (isLastAction() && currentRule.evaluate(paymentFlowState)) {
//                for (Rule subRule : ((AndRule)currentRule).getRules()) {
//                    if (subRule.evaluate(paymentFlowState)) {
//                        mCurrentAction.resolveUnfullfiledRule(subRule);
//                        return false;
//                    }
//                }
//            }
//        }
        //Si la regla del Step es del tipo OR (debo hacer que no cumpla ninguna sub rule para salir del step)
        //Ante la primer subRule que este cumpliendo, tengo que resolver el error.
        //Al final de cada action que tenga algun field involucrado en el rule del step, debo evaluar
//        else if (currentRule instanceof OrRule) {
//            List<Rule> currentRules = getCurrentSubRules(mCurrentAction.getFields(), currentRule);
//
//            for (Rule subRule : currentRules) {
//                if (subRule.evaluate(paymentFlowState)) {
//                    mCurrentAction.resolveUnfullfiledRule(subRule);
//                    return false;
//                }
//            }
//        } else if (currentRule instanceof NotRule){
//            for (Field attribute :mCurrentAction.getFields()) {
//                if (currentRule.getFieldName().equals(attribute.getName()) && !currentRule.evaluate(paymentFlowState)){
//                    mCurrentAction.resolveUnfullfiledRule(((NotRule) currentRule).getRules().get(0));
//                    return false;
//                }
//            }
//        } else {
//
//        }
        return true
    }

    private val isLastAction: Boolean
        private get() = currentActionIndex == getCurrentActions()!!.size - 1

    /**
     * Se intstancia el flow correspondiente al tipo de operacion, inicializa el json
     * ActionMapper: es donde se crean las instancias de las actions con lo necesario para implementar en android
     */
    fun startFlow(actionMapper: ActionMapper?, flow: Flow?, paymentFlowState: FlowState, actions: List<RuleAction>?) {
        run {
            this.actions = actions
            this.flow = flow
            this.actionMapper = actionMapper
            this.paymentFlowState = paymentFlowState
            executeNextStep(null)
        }
    }

    /**
     * Validacion de reglas que pertenecen a campos especificados en List<Field> fields (no se evalua toda la rule aca)
     * @param mCurrentAction accion actual, que en caso de no cumplir con la/s regla/s sabe como resolverla
     * @param fields campos a validar
     * @return
    </Field> */
    fun validate(mCurrentAction: Action, fields: List<Field>): Boolean {
        run {
            val currentRule = getCurrentStep()!!.rule
            upadatePaymentFlowState(fields, paymentFlowState)
            val currentRules = getCurrentSubRules(fields, currentRule!!)
            for (subRule in currentRules) {
                if (subRule.evaluate(paymentFlowState)) {
                    mCurrentAction.resolveUnfullfiledRule(subRule)
                    return false
                }
            }
            return true
        }
    }

    /**
     * Se evalua si la action cumple o no las reglas para pasar al siguiente action o step.
     * Se actualizan todos los campos que resuelve la action actual para luego evaluar la regla de forma parcial (si no es el ultimo action del step)
     * o total si ya no tengo mas acciones por cumplir y requiero pasar al proximo step
     * @param mCurrentAction
     */
    fun next(mCurrentAction: Action) {
        run {
            val currentRule = getCurrentStep()!!.rule

            //Actualuizo el paymentFlowState con los fields que cargue en la action a evaluar
            upadatePaymentFlowState(mCurrentAction.fields, paymentFlowState)
            if (validateAll(mCurrentAction, currentRule!!)) {
                executeNext(mCurrentAction)
            }
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


        var candidates : List<RuleAction>?

        candidates = actions?.filter {
            it.toString().contains(currentStep?.requiredFieldsToString()!!)
        }


        if (candidates!!.isEmpty()) {
            candidates  = actions?.filter { action : RuleAction ->
                currentStep?.requiredFields?.forEach{ field ->
                    if (action?.fields!!.containsKey(field)) {
                        return@filter true
                    }
                }
                false
            }
        } else if (candidates!!.size > 1){
            candidates = candidates?.filter { it2 ->
                it2.toString().contains(currentStep?.optionalFieldsToString()!!)
            }
        }


        return candidates!!
    }
    /**
     * Chequea si existe una proxima Action dentro de las acciones del Step actual
     * Si no es asi, se evalua la rule del step (se deberia cumplir )
     */
    private fun executeNext(mCurrentAction: Action) {
        if (!isLastAction) {
            currentActionIndex++
            currentAction = null
            executeAction(getCurrentAction())
        } else if (!getCurrentStep()!!.mustExecute(paymentFlowState)) {
            executeNextStep(mCurrentAction)
        } else {
            throw IllegalStateException("Revisar las rules, se tendrian que haber cumplido las validaciones")
        }
    }

    private fun executeNextStep(mCurrentAction: Action?) {
        initStep()
        if (mCurrentAction != null && getCurrentAction()!!.id == mCurrentAction.name) {
            executeNextField(mCurrentAction)
        } else {
            executeAction(getCurrentAction())
        }
    }

    private fun initStep() {
        currentStep = null
        currentActions = null
        currentAction = null
        currentActionIndex = 0
    }

    private fun executeAction(action: RuleAction?) {
        actionMapper!!.executeAction(action, getCurrentStep()!!.requiredFields, getCurrentStep()!!.optionalFields)
    }

    private fun executeNextField(action: Action) {
        actionMapper!!.executeNextField(action, getCurrentStep()!!.requiredFields, getCurrentStep()!!.optionalFields)
    }

    private fun upadatePaymentFlowState(field: List<Field>, paymentFlowState: FlowState?) {
        //TODO: implementar: tomar los valores de cada field y actualizarlos al paymentFlowState
    }

    private fun getCurrentStep(): Step? {
        if (currentStep == null) {
            currentStep = flow!!.getNext(paymentFlowState)
        }
        return currentStep
    }

    private fun getCurrentActions(): List<RuleAction>? {
        if (currentActions == null) {
            currentActions = getStepActions(getCurrentStep()!!)
        }
        return currentActions
    }

    private fun getCurrentAction(): RuleAction? {
        if (currentAction == null) {
            currentAction = getCurrentActions()!![currentActionIndex]
        }
        return currentAction
    }

    companion object {
        //private Context context;
        @JvmStatic
        var instance: FlowManager? = null
            get() {
                if (field == null) {
                    field = FlowManager()
                }
                return field
            }
            private set

    }
}