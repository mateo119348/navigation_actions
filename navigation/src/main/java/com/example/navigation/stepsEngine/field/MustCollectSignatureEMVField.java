package com.example.navigation.stepsEngine.field;

import com.example.navigation.stepsEngine.payment.FlowState;

public class MustCollectSignatureEMVField extends FlowStateField {

    @Override
    public Boolean get(FlowState flowState) {
        return flowState.getCard().isMustCollectSignatureEMV();
    }

    @Override
    public String getFieldName() {
        return null;
    }

}
