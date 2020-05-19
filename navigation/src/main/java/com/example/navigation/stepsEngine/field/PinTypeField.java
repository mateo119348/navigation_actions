package com.example.navigation.stepsEngine.field;

import com.example.navigation.stepsEngine.payment.FlowState;

public class PinTypeField extends Field {

    @Override
    public String get(FlowState flowState) {
        return flowState.getCard().getPin().getPinType().name();
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public void set(FlowState flowState, Object value) {

    }

}
