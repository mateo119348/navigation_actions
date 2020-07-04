package com.example.navigation.stepsEngine.field

import com.example.navigation.stepsEngine.payment.FlowState
import kotlinx.android.parcel.Parcelize

@Parcelize
class PinTypeField : Field() {
    override operator fun get(flowState: FlowState): String? {
        return flowState.card.pin.pinType?.name
    }

    override fun getId(): String {
        return FieldName.PIN_TYPE
    }

    override operator fun set(flowState: FlowState, value: Any?) {}
}