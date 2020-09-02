package com.example.navigation.flowEngine

import com.example.navigation.flowEngine.actions.RuleAction
import com.example.navigation.flowEngine.steps.enums.OperationType
import com.example.navigation.flowEngine.steps.Step
import com.example.navigation.flowEngine.validations.ActionValidation
import com.example.navigation.flowEngine.steps.flowState.FlowState

class Flow {
    lateinit var operationType: OperationType
    lateinit var steps: List<Step>
    lateinit var validations: List<ActionValidation>
    lateinit var actions: List<RuleAction>

    fun getNext(flowState: FlowState): Step {

        var step: Step? = null
        run loop@{
            steps.forEach {
                if (it.mustExecute(flowState)) {
                    step = it
                    it.wasExecuted = true
                    return@loop
                }
            }
        }
        //step = steps.takeWhile { it.mustExecute(flowState)}.first()

        checkNotNull(step) { "You shouldn't be here... Check your code!!!" }
        return step!!
    }

    /**
     * 1- Como estoy buscando el step anterior al actual, el step actual lo dejo de marcar como ejecutado
     * (lo quiero sacar del stack. Solo marco como ejecutado cuando avanzo sobre los steps)
     * 2-busco hacia atras cual fue el ultimo ejecutado y lo devuelvo
     *
     */
    fun getPreviousStep(currentStep: Step): Step {
        var index = steps.indexOf(currentStep)

        var step = steps[index]
        step.wasExecuted = false

        while (!step.wasExecuted) {
            index--
            step = steps[index]
        }

        return step
    }
}