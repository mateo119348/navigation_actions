package com.example.navigation.stepsEngine.field;

import com.example.navigation.stepsEngine.enums.Acquirer;
import com.example.navigation.stepsEngine.payment.FlowState;

public class AcquirerField extends FlowStateField {

    @Override
    public String get(FlowState flowState) {
        final Acquirer acquirer = flowState.getAcquirer();
        if (acquirer == null) {
            return null;
        } else {
            return acquirer.name();
        }
    }

    @Override
    public String getFieldName() {
        return null;
    }

}
