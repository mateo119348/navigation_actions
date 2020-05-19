package com.example.navigation.stepsEngine.field;

import com.example.navigation.stepsEngine.payment.FlowState;
import com.example.navigation.stepsEngine.payment.device.Device;

public class DeviceField extends Field {

    @Override
    public Device get(FlowState flowState) {
        return flowState.getPos().getDevice();
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public void set(FlowState flowState, Object value) {

    }

}
