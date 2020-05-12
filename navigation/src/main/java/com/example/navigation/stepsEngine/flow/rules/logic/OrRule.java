package com.example.navigation.stepsEngine.flow.rules.logic;

import com.example.navigation.stepsEngine.field.FlowStateField;
import com.example.navigation.stepsEngine.flow.rules.base.Rule;
import com.example.navigation.stepsEngine.flow.rules.base.RuleIdentifiers;
import com.example.navigation.stepsEngine.payment.FlowState;

public class OrRule extends LogicRule {

    @Override
    public boolean evaluate(final FlowState flowState) {
        if (getRules().size() < 2) {
            throw new IllegalArgumentException(String.format("%s rule must have at least two sub rules", RuleIdentifiers.OR));
        }
        for (Rule subRule : getRules()) {
            if (subRule.evaluate(flowState)) {
                return true;
            }
        }
        return false;
    }



}
