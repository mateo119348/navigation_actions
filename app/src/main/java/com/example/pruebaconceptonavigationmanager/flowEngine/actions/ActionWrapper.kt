package com.example.pruebaconceptonavigationmanager.flowEngine.actions

import android.os.Parcelable
import com.example.navigation.flowEngine.actions.Action
import com.example.navigation.flowEngine.actions.ActionId
import com.example.navigation.flowEngine.steps.field.Field
import kotlinx.android.parcel.Parcelize

@Parcelize
class ActionWrapper(val actionId: ActionId,
    val fields: List<Field>?,
    val activityClass: Class<out Action>? = null,
    val deepLink: String? = null) : Parcelable {

}

