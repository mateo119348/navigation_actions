package com.example.navigation.stepsEngine.field;

import com.example.navigation.stepsEngine.payment.FlowState;

public class PinTypeField extends FlowStateField {

    @Override
    public String get(FlowState flowState) {
        return flowState.getCard().getPin().getPinType().name();
    }

    @Override
    public String getFieldName() {
        return null;
    }

}
