package com.example.pruebaconceptonavigationmanager.flowEngine.fields

import com.example.navigation.stepsEngine.field.Field
import com.example.navigation.stepsEngine.field.FieldId
import com.example.navigation.stepsEngine.payment.FlowState
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