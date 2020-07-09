package com.example.pruebaconceptonavigationmanager.flowEngine.fields

import com.example.navigation.steps.enums.Tag
import com.example.navigation.steps.field.Field
import com.example.navigation.steps.field.FieldId
import com.example.navigation.steps.payment.FlowState
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