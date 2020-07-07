package com.example.pruebaconceptonavigationmanager.flow.fields

import com.example.navigation.stepsEngine.enums.Tag
import com.example.navigation.stepsEngine.field.Field
import com.example.navigation.stepsEngine.field.FieldId
import com.example.navigation.stepsEngine.payment.FlowState
import kotlinx.android.parcel.Parcelize

@Parcelize
class CardTagField(val field: FieldId) : Field(field) {

    override operator fun get(flowState: FlowState): String? {
        val tag = flowState.card.tag
        return tag?.name
    }

    override operator fun set(flowState: FlowState, value: Any?) {
        flowState.card.tag = value as Tag?
    }
}