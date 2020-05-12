package com.example.navigation.stepsEngine.flow.rules.logic;

import com.example.navigation.stepsEngine.field.FlowStateField;
import com.example.navigation.stepsEngine.flow.rules.base.RuleIdentifiers;
import com.example.navigation.stepsEngine.payment.FlowState;

public class NotRule extends LogicRule {

    @Override
    public boolean evaluate(final FlowState flowState) {
        if (getRules().size() != 1) {
            throw new IllegalArgumentException(String.format("%s rule must have one and only one sub rules", RuleIdentifiers.NOT));
        }
        return !getRules().get(0).evaluate(flowState);
    }

    @Override
    public String getFieldName() {
        return null;
    }

}
