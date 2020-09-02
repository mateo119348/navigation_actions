package com.example.pruebaconceptonavigationmanager.flowEngine.fields

import com.example.navigation.flowEngine.steps.field.Field
import com.example.navigation.flowEngine.steps.field.FieldId
import com.example.navigation.flowEngine.steps.flowState.FlowState
import kotlinx.android.parcel.Parcelize

@Parcelize
class IsReservationField ( val field: FieldId) : Field (field)  {

    override operator fun get(flowState: FlowState): Boolean? {
        return flowState.reservation.isReservation
    }

    override operator fun set(flowState: FlowState, value: Any?) {}
}