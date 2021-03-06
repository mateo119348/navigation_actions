package com.example.navigation.stepsEngine.field

import com.example.navigation.stepsEngine.payment.FlowState
import kotlinx.android.parcel.Parcelize

@Parcelize
class DescriptionField : Field() {
    override fun getId(): String {
        return FieldName.DESCRIPTION
    }

    override fun get(flowState: FlowState): String? {
        return flowState.description
    }

    override fun set(flowState: FlowState, value: Any?) {
        flowState.description = value as String?
    }
}