package com.example.navigation.stepsEngine.field

import com.example.navigation.stepsEngine.payment.FlowState
import kotlinx.android.parcel.Parcelize

@Parcelize
class PaymentStatusField : Field() {
    override operator fun get(flowState: FlowState): String? {
        return flowState.paymentStatus?.toUpperCase()
    }

    override fun getId(): String {
        return FieldName.PAYMENT_STATUS
    }

    override operator fun set(flowState: FlowState, value: Any?) {}
}