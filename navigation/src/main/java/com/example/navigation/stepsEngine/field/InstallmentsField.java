package com.example.navigation.stepsEngine.field;

import com.example.navigation.stepsEngine.payment.FlowState;

public class InstallmentsField extends FlowStateField {

    @Override
    public Integer get(FlowState flowState) {
        return flowState.getInstallments();
    }

    @Override
    public String getFieldName() {
        return null;
    }

}
