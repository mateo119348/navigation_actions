package com.example.navigation.stepsEngine.field;

import com.example.navigation.stepsEngine.payment.FlowState;

public class IsReservationField extends FlowStateField {

    @Override
    public Boolean get(FlowState flowState) {
        return flowState.getReservation().isReservation();
    }

    @Override
    public String getFieldName() {
        return null;
    }

}
