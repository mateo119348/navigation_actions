package com.example.pruebaconceptonavigationmanager.flowEngine.fields

import com.example.navigation.steps.field.Field
import com.example.navigation.steps.field.FieldId
import com.example.navigation.steps.payment.FlowState
import kotlinx.android.parcel.Parcelize

@Parcelize
class DescriptionField( val field: FieldId) : Field (field)  {

    override fun get(flowState: FlowState): String? {
        return flowState.description
    }

    override fun set(flowState: FlowState, value: Any?) {
        flowState.description = value as String?
    }

    override fun initState(flowState: FlowState) {
        flowState.description = ""
    }
}