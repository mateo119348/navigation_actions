package com.example.navigation.stepsEngine.flow.rules.comparable;

import com.example.navigation.stepsEngine.payment.FlowState;

public class NullRule extends ComparableRule {

    @Override
    public boolean evaluate(FlowState flowState) {
        return getField().get(flowState) == null;
    }

}
