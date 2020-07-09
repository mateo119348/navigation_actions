package com.example.pruebaconceptonavigationmanager.flowEngine.fields

import com.example.navigation.flowEngine.steps.field.Field
import com.example.navigation.flowEngine.steps.field.FieldId
import com.example.navigation.flowEngine.steps.flowState.FlowState
import kotlinx.android.parcel.Parcelize

@Parcelize
class TaxSelectionField(val field: FieldId) : Field(field)  {
    override operator fun get(flowState: FlowState): String? {
        return flowState.taxId
    }


    override operator fun set(flowState: FlowState, value: Any?) {}
}