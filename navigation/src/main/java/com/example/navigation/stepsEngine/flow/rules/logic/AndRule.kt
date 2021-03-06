package com.example.navigation.stepsEngine.flow.rules.logic

import com.example.navigation.stepsEngine.flow.rules.base.RuleIdentifiers
import com.example.navigation.stepsEngine.payment.FlowState

class AndRule : LogicRule() {
    override fun evaluate(flowState: FlowState): Boolean {
        require(rules.size >= 2) { String.format("%s rule must have at least two sub rules", RuleIdentifiers.AND) }
        for (subRule in rules) {
            if (!subRule.evaluate(flowState)) {
                return false
            }
        }
        return true
    }
}