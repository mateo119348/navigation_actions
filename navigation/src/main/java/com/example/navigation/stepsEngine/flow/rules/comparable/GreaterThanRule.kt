package com.example.navigation.stepsEngine.flow.rules.comparable

import com.example.navigation.stepsEngine.payment.FlowState
import java.math.BigDecimal

class GreaterThanRule : ComparableRule() {
    lateinit var count: BigDecimal

    override fun evaluate(flowState: FlowState): Boolean {
        var value = getValue(flowState)
        return  (value as BigDecimal) > count
    }
}