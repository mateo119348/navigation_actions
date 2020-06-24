package com.example.navigation.stepsEngine.flow.rules.logic

import com.example.navigation.stepsEngine.flow.rules.base.RuleIdentifiers
import com.example.navigation.stepsEngine.payment.FlowState

class NotRule : LogicRule() {
    override fun evaluate(flowState: FlowState): Boolean {
        require(rules!!.size == 1) { String.format("%s rule must have one and only one sub rules", RuleIdentifiers.NOT) }
        return !rules!![0].evaluate(flowState)
    }

    override val fieldName: String?
        get() = null
}