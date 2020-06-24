package com.example.navigation.stepsEngine.field

import com.example.navigation.stepsEngine.payment.FlowState

class CardTagField : Field() {
    override operator fun get(flowState: FlowState): String? {
        val tag = flowState.card.tag
        return tag?.name
    }

    override fun getId(): String {
        return FieldName.CARD_TAG
    }

    override operator fun set(flowState: FlowState, value: Any?) {}
}