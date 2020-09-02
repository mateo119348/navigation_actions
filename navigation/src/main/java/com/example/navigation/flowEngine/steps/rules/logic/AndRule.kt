package com.example.navigation.flowEngine.steps.rules.logic

import com.example.navigation.flowEngine.steps.rules.base.RuleIdentifiers
import com.example.navigation.flowEngine.steps.flowState.FlowState

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