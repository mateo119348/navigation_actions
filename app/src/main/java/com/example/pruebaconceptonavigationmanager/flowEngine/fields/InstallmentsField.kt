package com.example.pruebaconceptonavigationmanager.flowEngine.fields

import com.example.navigation.flowEngine.steps.field.Field
import com.example.navigation.flowEngine.steps.field.FieldId
import com.example.navigation.flowEngine.steps.flowState.FlowState
import kotlinx.android.parcel.Parcelize

@Parcelize
class InstallmentsField ( val field: FieldId) : Field (field)  {
    override operator fun get(flowState: FlowState): Int? {
        return flowState.installments
    }

    override operator fun set(flowState: FlowState, value: Any?) {}
}