package com.example.navigation.stepsEngine.flow.rules.comparable.string;

import com.example.navigation.stepsEngine.flow.rules.comparable.ComparableRule;
import com.example.navigation.stepsEngine.payment.PointPayment;

public class StringContainsRule extends ComparableRule {

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean evaluate(PointPayment pointPayment) {
        return ((String) getFieldManager().get(pointPayment)).contains(value);
    }

}
