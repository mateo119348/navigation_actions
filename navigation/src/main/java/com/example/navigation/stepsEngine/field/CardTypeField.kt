package com.example.navigation.stepsEngine.field

import com.example.navigation.stepsEngine.payment.FlowState

class CardTypeField : Field() {
    override operator fun get(flowState: FlowState): String? {
        val type = flowState.card.type
        return type?.name
    }

    override fun getId(): String {
        return FieldName.CARD_TYPE
    }

    override operator fun set(flowState: FlowState, value: Any?) {}
}