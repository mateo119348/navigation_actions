package com.example.navigation.mappers

import android.os.Parcelable
import com.example.navigation.stepsEngine.field.Field
import com.example.navigation.stepsEngine.field.FieldId
import com.example.navigation.stepsEngine.payment.FlowState

interface FieldMapper : Parcelable{
    fun getField(fieldId: String): Field
    fun getFields(fields: List<String>?): List<Field>
}