package com.example.pruebaconceptonavigationmanager.flowEngine

import android.os.Parcelable
import com.example.navigation.action.Action
import com.example.navigation.action.ActionId
import com.example.navigation.stepsEngine.field.Field
import kotlinx.android.parcel.Parcelize

@Parcelize
class ActionHeader(val actionId: ActionId,
    val fields: List<Field>?,
    val deepLink: String? = null,
    val activityClass: Class<Action>? = null) : Parcelable {

}