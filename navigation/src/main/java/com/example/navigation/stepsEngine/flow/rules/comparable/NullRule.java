package com.example.navigation.stepsEngine.flow.rules.comparable;

import com.example.navigation.stepsEngine.payment.PointPayment;

public class NullRule extends ComparableRule {

    @Override
    public boolean evaluate(PointPayment pointPayment) {
        return getFieldManager().get(pointPayment) == null;
    }

}
