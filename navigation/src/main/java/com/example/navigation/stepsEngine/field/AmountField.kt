package com.example.navigation.stepsEngine.field

import com.example.navigation.stepsEngine.payment.FlowState
import kotlinx.android.parcel.Parcelize
import java.math.BigDecimal

@Parcelize
class AmountField() : Field() {


    override fun getId(): String {
        return FieldName.AMOUNT
    }

    override fun get(flowState: FlowState): Any? {
        return flowState.amount
    }

    override fun set(flowState: FlowState, value: Any?) {
        flowState.amount = value as BigDecimal
    }

}