package com.example.navigation.steps.flow.rules.comparable

import com.example.navigation.steps.payment.FlowState

class NullRule() : ComparableRule() {

    constructor(mField: String) : this() {
       field = mField
    }
    override fun evaluate(flowState: FlowState): Boolean {
        return if (isNot)
            getValue(flowState) != null
        else
            getValue(flowState) == null
    }
}