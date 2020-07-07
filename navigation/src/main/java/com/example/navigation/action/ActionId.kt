package com.example.navigation.action

import android.os.Parcelable

interface ActionId : Parcelable {
    fun id(): String
}