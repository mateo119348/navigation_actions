package com.example.navigation.stepsEngine.field;

import com.example.navigation.stepsEngine.payment.FlowState;

public class TaxSelectionField extends FlowStateField {

    @Override
    public String get(FlowState flowState) {
        return flowState.getTaxId();
    }

    @Override
    public String getFieldName() {
        return null;
    }

}
