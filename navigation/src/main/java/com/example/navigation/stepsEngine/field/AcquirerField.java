package com.example.navigation.stepsEngine.field;

import com.example.navigation.stepsEngine.enums.Acquirer;
import com.example.navigation.stepsEngine.payment.FlowState;

public class AcquirerField extends Field {

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
    public String getId() {
        return null;
    }

    @Override
    public void set(FlowState flowState, Object value) {

    }

}
