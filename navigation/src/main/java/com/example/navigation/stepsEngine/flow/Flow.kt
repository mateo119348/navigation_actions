package com.example.navigation.stepsEngine.flow

import com.example.navigation.stepsEngine.enums.OperationType
import com.example.navigation.stepsEngine.flow.rules.actionValidation.ActionValidation
import com.example.navigation.stepsEngine.payment.FlowState
import java.util.*

class Flow {
    lateinit var operationType: OperationType
    lateinit var steps: List<Step>
    lateinit var validations: List<ActionValidation>

    fun getNext(flowState: FlowState): Step {

        var step: Step? = null
        run loop@{
        steps.forEach {
            if (it.mustExecute(flowState)) {
                step = it
                return@loop
                }
            }
        }
        //step = steps.takeWhile { it.mustExecute(flowState)}.first()

        checkNotNull(step) { "You shouldn't be here... Check your code!!!" }
        return step!!
    }
}