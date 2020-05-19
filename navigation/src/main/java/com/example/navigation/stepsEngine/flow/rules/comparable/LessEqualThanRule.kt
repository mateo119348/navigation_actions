package com.example.navigation.stepsEngine.flow.rules.comparable

import com.example.navigation.stepsEngine.payment.FlowState

class LessEqualThanRule : ComparableRule() {
    var count: Long? = null

    override fun evaluate(flowState: FlowState): Boolean {
        return getValue(flowState) != null && getValue(flowState) as Long <= count!!
    }
}