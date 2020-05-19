package com.example.navigation.stepsEngine.field;

import com.example.navigation.stepsEngine.payment.FlowState;

public class IsDeviceConnectedField extends Field {

    @Override
    public Boolean get(FlowState flowState) {
        return flowState.getPos().isConnected();
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public void set(FlowState flowState, Object value) {

    }

}
