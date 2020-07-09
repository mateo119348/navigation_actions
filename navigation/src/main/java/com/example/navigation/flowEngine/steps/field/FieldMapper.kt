package com.example.navigation.flowEngine.steps.field

import android.os.Parcelable

interface FieldMapper : Parcelable{
    fun getField(fieldId: String): Field
    fun getFields(fields: List<String>?): List<Field>
}