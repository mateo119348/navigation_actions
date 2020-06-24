package com.example.navigation.stepsEngine.field

import com.example.navigation.stepsEngine.payment.FlowState

class ReservationEmailField : Field() {
    override operator fun get(flowState: FlowState): String? {
        return flowState.reservation.reservationEmail
    }

    override fun getId(): String {
        return FieldName.RESERVATION_EMAIL
    }

    override operator fun set(flowState: FlowState, value: Any?) {}
}