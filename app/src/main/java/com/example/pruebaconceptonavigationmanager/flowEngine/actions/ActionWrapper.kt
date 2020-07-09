package com.example.pruebaconceptonavigationmanager.flowEngine.actions

import android.os.Parcelable
import com.example.navigation.action.Action
import com.example.navigation.action.ActionId
import com.example.navigation.stepsEngine.field.Field
import kotlinx.android.parcel.Parcelize

@Parcelize
class ActionWrapper(val actionId: ActionId,
    val fields: List<Field>?,
    val activityClass: Class<out Action>? = null,
    val deepLink: String? = null) : Parcelable {

}

