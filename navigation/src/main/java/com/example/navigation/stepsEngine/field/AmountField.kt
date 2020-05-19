package com.example.navigation.stepsEngine.field

import com.example.navigation.stepsEngine.payment.FlowState
import java.math.BigDecimal

class AmountField : Field() {


    override fun getId(): String {
        return FieldName.AMOUNT
    }

    override fun get(flowState: FlowState): Any? {
        return flowState.amount
    }

    override fun set(flowState: FlowState, value: Any?) {
        flowState.amount = value as Long?
    }

}