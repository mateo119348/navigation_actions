package com.example.navigation.stepsEngine.field

import com.example.navigation.stepsEngine.payment.FlowState

class IsReservationField : Field() {
    override operator fun get(flowState: FlowState): Boolean? {
        return flowState.reservation.isReservation
    }

    override fun getId(): String {
        return FieldName.IS_RESERVATION
    }

    override operator fun set(flowState: FlowState, value: Any?) {}
}