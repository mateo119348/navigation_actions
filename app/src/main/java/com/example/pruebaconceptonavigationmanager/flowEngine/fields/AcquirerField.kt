package com.example.pruebaconceptonavigationmanager.flowEngine.fields

import com.example.navigation.steps.enums.Acquirer
import com.example.navigation.steps.field.Field
import com.example.navigation.steps.field.FieldId
import com.example.navigation.steps.payment.FlowState
import kotlinx.android.parcel.Parcelize

@Parcelize
class AcquirerField ( val field: FieldId) : Field (field) {


    override operator fun get(flowState: FlowState): String? {
        val acquirer = flowState.acquirer
        return acquirer?.name
    }

    override operator fun set(flowState: FlowState, value: Any?) {
        flowState.acquirer = value as Acquirer
    }
}