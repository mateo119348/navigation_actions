package com.example.pruebaconceptonavigationmanager.flowEngine.fields

import com.example.navigation.steps.field.Field
import com.example.navigation.steps.field.FieldId
import com.example.navigation.steps.payment.FlowState
import kotlinx.android.parcel.Parcelize

@Parcelize
class PinTypeField ( val field: FieldId) : Field (field)  {
    override operator fun get(flowState: FlowState): String? {
        return flowState.card.pin.pinType?.name
    }

    override operator fun set(flowState: FlowState, value: Any?) {}
}