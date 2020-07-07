package com.example.pruebaconceptonavigationmanager.flow.fields

import com.example.navigation.stepsEngine.field.Field
import com.example.navigation.stepsEngine.field.FieldId
import com.example.navigation.stepsEngine.payment.FlowState
import kotlinx.android.parcel.Parcelize

@Parcelize
class AccountTypeField(val field: FieldId) : Field(field) {

    override operator fun get(flowState: FlowState): String? {
        val accountType = flowState.accountType
        return accountType?.name
    }

    override operator fun set(flowState: FlowState, value: Any?) {

    }
}