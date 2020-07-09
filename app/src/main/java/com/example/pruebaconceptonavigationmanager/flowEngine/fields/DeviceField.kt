package com.example.pruebaconceptonavigationmanager.flowEngine.fields

import com.example.navigation.stepsEngine.field.Field
import com.example.navigation.stepsEngine.field.FieldId
import com.example.navigation.stepsEngine.payment.FlowState
import com.example.navigation.stepsEngine.payment.device.Device
import kotlinx.android.parcel.Parcelize

@Parcelize
class DeviceField ( val field: FieldId) : Field (field)  {
    override operator fun get(flowState: FlowState): Device? {
        return flowState.pos.device
    }



    override operator fun set(flowState: FlowState, value: Any?) {}
}