package com.example.navigation.stepsEngine.flow.rules.comparable.string;

import com.example.navigation.stepsEngine.flow.rules.comparable.ComparableRule;
import com.example.navigation.stepsEngine.payment.PointPayment;

import java.util.List;

public class StringInListRule extends ComparableRule {

    private List<String> values;

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> strings) {
        this.values = strings;
    }

    @Override
    public boolean evaluate(PointPayment pointPayment) {
        return values.contains((String) getFieldManager().get(pointPayment));
    }

}