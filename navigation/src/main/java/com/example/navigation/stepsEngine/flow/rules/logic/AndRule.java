package com.example.navigation.stepsEngine.flow.rules.logic;

import com.example.navigation.stepsEngine.flow.rules.base.Rule;
import com.example.navigation.stepsEngine.flow.rules.base.RuleIdentifiers;
import com.example.navigation.stepsEngine.payment.PointPayment;

public class AndRule extends LogicRule {

    @Override
    public boolean evaluate(final PointPayment pointPayment) {
        if (getSubRules().size() < 2) {
            throw new IllegalArgumentException(String.format("%s rule must have at least two sub rules", RuleIdentifiers.AND));
        }
        for (Rule subRule : getSubRules()) {
            if (!subRule.evaluate(pointPayment)) {
                return false;
            }
        }
        return true;
    }

}
