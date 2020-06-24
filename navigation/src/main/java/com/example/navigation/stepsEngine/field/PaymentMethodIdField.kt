package com.example.navigation.stepsEngine.field

import com.example.navigation.stepsEngine.payment.FlowState

class PaymentMethodIdField : Field() {
    override operator fun get(flowState: FlowState): String? {
        return flowState.paymentMethodWrapper.paymentMethodId?.name
    }

    override fun getId(): String {
        return FieldName.PAYMENT_METHOD_ID
    }

    override operator fun set(flowState: FlowState, value: Any?) {}
}