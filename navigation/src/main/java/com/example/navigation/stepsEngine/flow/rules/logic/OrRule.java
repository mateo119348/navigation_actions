package com.example.navigation.stepsEngine.flow.rules.logic;

import com.example.navigation.stepsEngine.flow.rules.base.Rule;
import com.example.navigation.stepsEngine.flow.rules.base.RuleIdentifiers;
import com.example.navigation.stepsEngine.payment.PointPayment;

public class OrRule extends LogicRule {

    @Override
    public boolean evaluate(final PointPayment pointPayment) {
        if (getSubRules().size() < 2) {
            throw new IllegalArgumentException(String.format("%s rule must have at least two sub rules", RuleIdentifiers.OR));
        }
        for (Rule subRule : getSubRules()) {
            if (subRule.evaluate(pointPayment)) {
                return true;
            }
        }
        return false;
    }



}
