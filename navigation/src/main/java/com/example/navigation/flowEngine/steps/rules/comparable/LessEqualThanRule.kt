package com.example.navigation.flowEngine.steps.rules.comparable

import com.example.navigation.flowEngine.steps.flowState.FlowState
import java.math.BigDecimal

class LessEqualThanRule : ComparableRule() {
    lateinit var count: BigDecimal

    override fun evaluate(flowState: FlowState): Boolean {
        return getValue(flowState) != null && getValue(flowState) as BigDecimal <= count
    }
}