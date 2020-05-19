package com.example.navigation.stepsEngine.field;

import com.example.navigation.stepsEngine.payment.FlowState;

public class IsReservationField extends Field {

    @Override
    public Boolean get(FlowState flowState) {
        return flowState.getReservation().isReservation();
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public void set(FlowState flowState, Object value) {

    }

}
