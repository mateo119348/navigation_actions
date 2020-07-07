package com.example.pruebaconceptonavigationmanager.flow

import android.os.Parcelable
import com.example.navigation.action.ActionId
import com.example.navigation.mappers.FieldMapper
import com.example.navigation.stepsEngine.field.Field
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ActionWrapper( val actionId: ActionId, val deepLink: String, private val fieldsStr: List<String>?, private val fieldMapper: FieldMapper) : Parcelable {


    @IgnoredOnParcel
    var fields: ArrayList<Field>? = null
     get() {
         field?: run {
             field = ArrayList()
             fieldsStr?.forEach {
                 field!!.add(fieldMapper.getField(it))
             }
         }
         return field
     }
}