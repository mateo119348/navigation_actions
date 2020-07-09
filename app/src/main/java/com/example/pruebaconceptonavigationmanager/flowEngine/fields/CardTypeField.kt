package com.example.pruebaconceptonavigationmanager.flowEngine.fields

import com.example.navigation.stepsEngine.enums.CardType
import com.example.navigation.stepsEngine.field.Field
import com.example.navigation.stepsEngine.field.FieldId
import com.example.navigation.stepsEngine.payment.FlowState
import kotlinx.android.parcel.Parcelize

@Parcelize
class CardTypeField(val field: FieldId) : Field(field) {

    override operator fun get(flowState: FlowState): String? {
        val type = flowState.card.cardType
        return type?.name
    }

    override operator fun set(flowState: FlowState, value: Any?) {
        flowState.card.cardType = value as CardType?
    }
}