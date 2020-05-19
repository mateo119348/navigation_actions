package com.example.navigation.stepsEngine.field;

import com.example.navigation.stepsEngine.payment.FlowState;

public class TaxSelectionField extends Field {

    @Override
    public String get(FlowState flowState) {
        return flowState.getTaxId();
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public void set(FlowState flowState, Object value) {

    }

}
