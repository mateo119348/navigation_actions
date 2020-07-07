package com.example.pruebaconceptonavigationmanager.flow.fields

import com.example.navigation.stepsEngine.field.Field
import com.example.navigation.stepsEngine.field.FieldId
import com.example.navigation.stepsEngine.payment.FlowState
import kotlinx.android.parcel.Parcelize

@Parcelize
class InstallmentsField ( val field: FieldId) : Field (field)  {
    override operator fun get(flowState: FlowState): Int? {
        return flowState.installments
    }

    override operator fun set(flowState: FlowState, value: Any?) {}
}