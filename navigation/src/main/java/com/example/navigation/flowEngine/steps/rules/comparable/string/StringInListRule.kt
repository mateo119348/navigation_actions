package com.example.navigation.flowEngine.steps.rules.comparable.string

import com.example.navigation.flowEngine.steps.rules.comparable.ComparableRule
import com.example.navigation.flowEngine.steps.flowState.FlowState

class StringInListRule : ComparableRule() {
    var values: List<String>? = null

    override fun evaluate(flowState: FlowState): Boolean {
        return values!!.contains(getValue(flowState) as String?)
    }
}