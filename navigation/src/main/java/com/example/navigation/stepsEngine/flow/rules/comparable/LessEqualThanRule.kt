package com.example.navigation.stepsEngine.flow.rules.comparable

import com.example.navigation.stepsEngine.payment.FlowState
import java.math.BigDecimal

class LessEqualThanRule : ComparableRule() {
    lateinit var count: BigDecimal

    override fun evaluate(flowState: FlowState): Boolean {
        return getValue(flowState) != null && getValue(flowState) as BigDecimal <= count!!
    }
}