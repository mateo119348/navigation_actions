package com.example.navigation.stepsEngine.flow.rules.comparable

import com.example.navigation.stepsEngine.payment.FlowState

class NullRule() : ComparableRule() {

    constructor(mField: String) : this() {
       field = mField
    }
    override fun evaluate(flowState: FlowState): Boolean {
        return getValue(flowState) == null
    }
}