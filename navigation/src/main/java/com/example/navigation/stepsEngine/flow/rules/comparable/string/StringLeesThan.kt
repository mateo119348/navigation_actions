package com.example.navigation.stepsEngine.flow.rules.comparable.string

import com.example.navigation.stepsEngine.flow.rules.comparable.ComparableRule
import com.example.navigation.stepsEngine.payment.FlowState
import java.math.BigDecimal

class StringLeesThan : ComparableRule() {

    var count: Int = 0

    override fun evaluate(flowState: FlowState): Boolean {
        return getValue(flowState) != null && (getValue(flowState) as String).length < count
    }
}