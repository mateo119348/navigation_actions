package com.example.navigation.stepsEngine.flow.rules.logic;

import com.example.navigation.stepsEngine.flow.rules.base.RuleIdentifiers;
import com.example.navigation.stepsEngine.payment.PointPayment;

public class NotRule extends LogicRule {

    @Override
    public boolean evaluate(final PointPayment pointPayment) {
        if (getSubRules().size() != 1) {
            throw new IllegalArgumentException(String.format("%s rule must have one and only one sub rules", RuleIdentifiers.NOT));
        }
        return !getSubRules().get(0).evaluate(pointPayment);
    }

    @Override
    public String getFieldName() {
        return getSubRules().get(0).getFieldName();
    }

}
