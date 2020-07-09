package com.example.navigation.steps.flow.rules.comparable.string

import com.example.navigation.steps.flow.rules.comparable.ComparableRule
import com.example.navigation.steps.payment.FlowState

class StringInListRule : ComparableRule() {
    var values: List<String>? = null

    override fun evaluate(flowState: FlowState): Boolean {
        return values!!.contains(getValue(flowState) as String?)
    }
}