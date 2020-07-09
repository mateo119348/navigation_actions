package com.example.pruebaconceptonavigationmanager.flowEngine.fields

import com.example.navigation.steps.field.Field
import com.example.navigation.steps.field.FieldId
import com.example.navigation.steps.payment.FlowState
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