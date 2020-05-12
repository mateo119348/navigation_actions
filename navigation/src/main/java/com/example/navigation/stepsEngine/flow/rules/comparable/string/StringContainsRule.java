package com.example.navigation.stepsEngine.flow.rules.comparable.string;

import com.example.navigation.stepsEngine.flow.rules.comparable.ComparableRule;
import com.example.navigation.stepsEngine.payment.FlowState;

public class StringContainsRule extends ComparableRule {

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean evaluate(FlowState flowState) {
        return ((String) getField().get(flowState)).contains(value);
    }

}
