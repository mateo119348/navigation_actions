package com.example.navigation.stepsEngine.field

import com.example.navigation.stepsEngine.enums.CardType
import com.example.navigation.stepsEngine.payment.FlowState

class CardTypeField : Field() {
    override operator fun get(flowState: FlowState): String? {
        val type = flowState.card.cardType
        return type?.name
    }

    override fun getId(): String {
        return FieldName.CARD_TYPE
    }

    override operator fun set(flowState: FlowState, value: Any?) {
        flowState.card.cardType = value as CardType
    }
}