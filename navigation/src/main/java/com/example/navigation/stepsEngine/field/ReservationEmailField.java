package com.example.navigation.stepsEngine.field;

import com.example.navigation.stepsEngine.payment.FlowState;

public class ReservationEmailField extends FlowStateField {

    @Override
    public String get(FlowState flowState) {
        return flowState.getReservation().getReservationEmail();
    }

    @Override
    public String getFieldName() {
        return null;
    }

}
