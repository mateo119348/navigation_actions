package com.example.pruebaconceptonavigationmanager.flow.fields

import com.example.navigation.stepsEngine.field.Field
import com.example.navigation.stepsEngine.field.FieldId
import com.example.navigation.stepsEngine.payment.FlowState
import kotlinx.android.parcel.Parcelize
import java.math.BigDecimal

@Parcelize
class AmountField (val field: FieldId) : Field(field)  {

    override fun get(flowState: FlowState): Any? {
        return flowState.amount
    }

    override fun set(flowState: FlowState, value: Any?) {
        flowState.amount = value as BigDecimal?
    }

}