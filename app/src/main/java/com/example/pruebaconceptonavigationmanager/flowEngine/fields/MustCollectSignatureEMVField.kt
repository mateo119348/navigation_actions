package com.example.pruebaconceptonavigationmanager.flowEngine.fields

import com.example.navigation.stepsEngine.field.Field
import com.example.navigation.stepsEngine.field.FieldId
import com.example.navigation.stepsEngine.payment.FlowState
import kotlinx.android.parcel.Parcelize

@Parcelize
class MustCollectSignatureEMVField(val field: FieldId) : Field(field) {

    override operator fun get(flowState: FlowState): Boolean? {
        return flowState.card.isMustCollectSignatureEMV
    }


    override operator fun set(flowState: FlowState, value: Any?) {}
}