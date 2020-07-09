package com.example.navigation.flowEngine.actions

import android.os.Parcelable

interface ActionId : Parcelable {
    fun id(): String
}