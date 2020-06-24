package com.example.navigation.stepsEngine.field

import com.example.navigation.stepsEngine.payment.FlowState

class AccountTypeField : Field() {
    override operator fun get(flowState: FlowState): String? {
        val accountType = flowState.accountType
        return accountType?.name
    }

    override fun getId(): String {
        return FieldName.ACCOUNT_TYPE
    }

    override operator fun set(flowState: FlowState, value: Any?) {

    }
}