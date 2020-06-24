package com.example.navigation.stepsEngine.flow

import com.example.navigation.stepsEngine.enums.OperationType
import com.example.navigation.stepsEngine.flow.rules.actionValidation.ActionValidation
import com.example.navigation.stepsEngine.payment.FlowState
import java.util.*

class Flow {
    lateinit var operationType: OperationType
    lateinit var steps: LinkedList<Step>
    lateinit var validations: List<ActionValidation>

    //TODO: Ver bien como ir para atrás, esto así YA ANDA, pero puede quedar mejor...
    fun getNext(flowState: FlowState): Step {
        var step = steps.poll()
        while (step != null && !step.mustExecute(flowState)) {
            step = steps.poll()
        }
        checkNotNull(step) { "You shouldn't be here... Check your code!!!" }
        return step
    }
}