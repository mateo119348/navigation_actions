package com.example.navigation.stepsEngine.flow.rules.comparable.string;

import com.example.navigation.stepsEngine.flow.rules.comparable.ComparableRule;
import com.example.navigation.stepsEngine.payment.PointPayment;

public class StringEmptyRule extends ComparableRule {

    @Override
    public boolean evaluate(PointPayment pointPayment) {
        return ((String) getFieldManager().get(pointPayment)).isEmpty();
    }

}
