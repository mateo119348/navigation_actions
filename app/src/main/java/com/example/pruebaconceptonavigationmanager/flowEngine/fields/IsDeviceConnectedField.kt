package com.example.pruebaconceptonavigationmanager.flowEngine.fields

import com.example.navigation.steps.field.Field
import com.example.navigation.steps.field.FieldId
import com.example.navigation.steps.payment.FlowState
import kotlinx.android.parcel.Parcelize

@Parcelize
class IsDeviceConnectedField ( val field: FieldId) : Field (field)  {

    override operator fun get(flowState: FlowState): Boolean? {
        return flowState.pos.isConnected
    }

    override operator fun set(flowState: FlowState, value: Any?) {}
}