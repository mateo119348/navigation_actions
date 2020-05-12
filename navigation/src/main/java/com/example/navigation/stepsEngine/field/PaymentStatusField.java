package com.example.navigation.stepsEngine.field;

import com.example.navigation.stepsEngine.payment.FlowState;

public class PaymentStatusField extends FlowStateField {

    @Override
    public String get(FlowState flowState) {
        return flowState.getPaymentStatus().toUpperCase();
    }

    @Override
    public String getFieldName() {
        return null;
    }

}
