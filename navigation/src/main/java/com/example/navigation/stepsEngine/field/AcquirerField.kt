package com.example.navigation.stepsEngine.field

import com.example.navigation.stepsEngine.payment.FlowState
import kotlinx.android.parcel.Parcelize

@Parcelize
class AcquirerField : Field() {
    override operator fun get(flowState: FlowState): String? {
        val acquirer = flowState.acquirer
        return acquirer?.name
    }

    override fun getId(): String {
        return FieldName.ACQUIRER
    }

    override operator fun set(flowState: FlowState, value: Any?) {}
}