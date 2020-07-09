package com.example.navigation.flowEngine.steps.rules.comparable.string

import com.example.navigation.flowEngine.steps.rules.comparable.ComparableRule
import com.example.navigation.flowEngine.steps.flowState.FlowState

class StringContainsRule : ComparableRule() {
    override fun evaluate(flowState: FlowState): Boolean {
        return (getValue(flowState) as String?)!!.contains(value)
    }
}