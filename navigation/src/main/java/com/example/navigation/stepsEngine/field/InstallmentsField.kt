package com.example.navigation.stepsEngine.field

import com.example.navigation.stepsEngine.payment.FlowState
import kotlinx.android.parcel.Parcelize

@Parcelize
class InstallmentsField : Field() {
    override operator fun get(flowState: FlowState): Int? {
        return flowState.installments
    }

    override fun getId(): String {
        return FieldName.INSTALLMENTS
    }

    override operator fun set(flowState: FlowState, value: Any?) {}
}