package com.example.navigation.stepsEngine.flow.rules.actionValidation

import com.example.navigation.stepsEngine.flow.rules.base.Rule
import com.example.navigation.stepsEngine.payment.FlowState

class ActionValidation {
    lateinit var id: Codes
        private set
    lateinit var field: String
        private set
    lateinit var rule: Rule
        private set

    fun evaluate(paymentFlowState: FlowState) : Boolean{
        return rule.evaluate(paymentFlowState)
    }

    enum class Codes {
        AMOUNT_OUT_OF_RANGE, DESCRIPTION_TOO_LARGE, CARD_TYPE_IS_NULL
    }

}