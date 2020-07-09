package com.example.navigation.flowEngine.steps.rules.comparable

import com.example.navigation.flowEngine.steps.flowState.FlowState

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