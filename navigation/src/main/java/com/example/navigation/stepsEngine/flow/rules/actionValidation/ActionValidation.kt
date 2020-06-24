package com.example.navigation.stepsEngine.flow.rules.actionValidation

import com.example.navigation.stepsEngine.flow.rules.base.Rule
import com.example.navigation.stepsEngine.payment.FlowState

class ActionValidation {
    lateinit var id: String
        private set
    lateinit var field: String
        private set
    lateinit var rule: Rule
        private set

    fun evaluate(paymentFlowState: FlowState) : Boolean{
        return rule.evaluate(paymentFlowState)
    }

    companion object {
        const val AMOUNT_OUT_OF_RANGE = "AMOUNT_OUT_OF_RANGE"
        const val DESCRIPTION_TOO_LARGE = "DESCRIPTION_TOO_LARGE"

    }

}