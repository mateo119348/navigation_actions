package com.example.navigation.stepsEngine.flow.rules.comparable.string

import com.example.navigation.stepsEngine.flow.rules.comparable.ComparableRule
import com.example.navigation.stepsEngine.payment.FlowState

class StringEmptyRule : ComparableRule() {
    override fun evaluate(flowState: FlowState): Boolean {
        return (getValue(flowState) as String?)!!.isEmpty()
    }
}