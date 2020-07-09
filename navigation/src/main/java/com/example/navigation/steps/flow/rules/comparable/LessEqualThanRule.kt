package com.example.navigation.steps.flow.rules.comparable

import com.example.navigation.steps.payment.FlowState
import java.math.BigDecimal

class LessEqualThanRule : ComparableRule() {
    lateinit var count: BigDecimal

    override fun evaluate(flowState: FlowState): Boolean {
        return getValue(flowState) != null && getValue(flowState) as BigDecimal <= count
    }
}