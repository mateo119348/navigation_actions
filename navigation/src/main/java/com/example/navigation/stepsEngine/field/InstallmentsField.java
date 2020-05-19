package com.example.navigation.stepsEngine.field;

import com.example.navigation.stepsEngine.payment.FlowState;

public class InstallmentsField extends Field {

    @Override
    public Integer get(FlowState flowState) {
        return flowState.getInstallments();
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public void set(FlowState flowState, Object value) {

    }

}
