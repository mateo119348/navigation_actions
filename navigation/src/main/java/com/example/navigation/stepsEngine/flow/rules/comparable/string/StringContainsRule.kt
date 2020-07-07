package com.example.navigation.stepsEngine.flow.rules.comparable.string

import com.example.navigation.stepsEngine.flow.rules.comparable.ComparableRule
import com.example.navigation.stepsEngine.payment.FlowState

class StringContainsRule : ComparableRule() {
    override fun evaluate(flowState: FlowState): Boolean {
        return (getValue(flowState) as String?)!!.contains(value)
    }
}