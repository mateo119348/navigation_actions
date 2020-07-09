package com.example.navigation.steps.flow.rules.comparable.string

import com.example.navigation.steps.flow.rules.comparable.ComparableRule
import com.example.navigation.steps.payment.FlowState

class StringLeesThan : ComparableRule() {

    var count: Int = 0

    override fun evaluate(flowState: FlowState): Boolean {
        val stringToCompare = (getValue(flowState) as String)
        return stringToCompare.length < count
    }
}