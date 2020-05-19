package com.example.navigation.stepsEngine.flow.rules.comparable.string;

import com.example.navigation.stepsEngine.flow.rules.comparable.ComparableRule;
import com.example.navigation.stepsEngine.payment.FlowState;

public class StringContainsRule extends ComparableRule {

    @Override
    public boolean evaluate(FlowState flowState) {
        return ((String) getValue(flowState)).contains(getValue());
    }

}
