package com.example.navigation.steps.flow.rules.comparable

import com.example.navigation.steps.payment.FlowState
import java.math.BigDecimal

class GreaterThanRule : ComparableRule() {
    private lateinit var count: BigDecimal

    override fun evaluate(flowState: FlowState): Boolean {
        val value = getValue(flowState)
        return  (value as BigDecimal) > count
    }
}