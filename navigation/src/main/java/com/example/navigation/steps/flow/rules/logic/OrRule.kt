package com.example.navigation.steps.flow.rules.logic

import com.example.navigation.steps.flow.rules.base.RuleIdentifiers
import com.example.navigation.steps.payment.FlowState

class OrRule : LogicRule() {
    override fun evaluate(flowState: FlowState): Boolean {
        require(rules.size >= 2) { String.format("%s rule must have at least two sub rules", RuleIdentifiers.OR) }
        for (subRule in rules) {
            if (subRule.evaluate(flowState)) {
                return true
            }
        }
        return false
    }
}