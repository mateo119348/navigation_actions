package com.example.navigation.stepsEngine.field

import com.example.navigation.stepsEngine.payment.FlowState

class TaxSelectionField : Field() {
    override operator fun get(flowState: FlowState): String? {
        return flowState.taxId
    }

    override fun getId(): String {
        return FieldName.TAX
    }

    override operator fun set(flowState: FlowState, value: Any?) {}
}