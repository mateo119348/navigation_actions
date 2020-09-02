package com.example.navigation.flowEngine.steps.rules.comparable.string

import com.example.navigation.flowEngine.steps.rules.comparable.ComparableRule
import com.example.navigation.flowEngine.steps.flowState.FlowState

class StringLeesThan : ComparableRule() {

    var count: Int = 0

    override fun evaluate(flowState: FlowState): Boolean {
        val stringToCompare = (getValue(flowState) as String)
        return stringToCompare.length < count
    }
}