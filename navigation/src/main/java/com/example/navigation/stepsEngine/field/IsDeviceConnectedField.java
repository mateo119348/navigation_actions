package com.example.navigation.stepsEngine.field;

import com.example.navigation.stepsEngine.payment.FlowState;

public class IsDeviceConnectedField extends FlowStateField {

    @Override
    public Boolean get(FlowState flowState) {
        return flowState.getPos().isConnected();
    }

    @Override
    public String getFieldName() {
        return null;
    }

}
