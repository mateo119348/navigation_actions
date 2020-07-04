package com.example.navigation.stepsEngine.field

import com.example.navigation.stepsEngine.payment.FlowState
import kotlinx.android.parcel.Parcelize

@Parcelize
class ServiceCodeField : Field() {
    override operator fun get(flowState: FlowState): String? {
        return flowState.card.serviceCode
    }

    override fun getId(): String {
        return FieldName.SERVICE_CODE
    }

    override operator fun set(flowState: FlowState, value: Any?) {}
}