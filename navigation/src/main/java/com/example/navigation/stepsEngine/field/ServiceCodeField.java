package com.example.navigation.stepsEngine.field;

import com.example.navigation.stepsEngine.payment.FlowState;

public class ServiceCodeField extends FlowStateField {

    @Override
    public String get(FlowState flowState) {
        return flowState.getCard().getServiceCode();
    }

    @Override
    public String getFieldName() {
        return null;
    }

}
