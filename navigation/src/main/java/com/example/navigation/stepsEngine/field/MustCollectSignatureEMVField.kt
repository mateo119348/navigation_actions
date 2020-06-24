package com.example.navigation.stepsEngine.field

import com.example.navigation.stepsEngine.payment.FlowState

class MustCollectSignatureEMVField : Field() {
    override operator fun get(flowState: FlowState): Boolean? {
        return flowState.card.isMustCollectSignatureEMV
    }

    override fun getId(): String {
        return FieldName.MUST_COLLECT_SIGNATURE_EMV
    }

    override operator fun set(flowState: FlowState, value: Any?) {}
}