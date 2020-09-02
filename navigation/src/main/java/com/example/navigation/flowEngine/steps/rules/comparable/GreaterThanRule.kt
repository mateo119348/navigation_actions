package com.example.navigation.flowEngine.steps.rules.comparable

import com.example.navigation.flowEngine.steps.flowState.FlowState
import java.math.BigDecimal

class GreaterThanRule : ComparableRule() {
    private lateinit var count: BigDecimal

    override fun evaluate(flowState: FlowState): Boolean {
        val value = getValue(flowState)
        return  (value as BigDecimal) > count
    }
}