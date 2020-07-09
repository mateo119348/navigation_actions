package com.example.navigation.steps.flow.rules.comparable.string

import com.example.navigation.steps.flow.rules.comparable.ComparableRule
import com.example.navigation.steps.payment.FlowState

class StringEmptyRule : ComparableRule() {
    override fun evaluate(flowState: FlowState): Boolean {
        return (getValue(flowState) as String?)!!.isEmpty()
    }
}