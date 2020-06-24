package com.example.navigation.action

import android.util.ArrayMap

class RuleAction {
    var id: String? = null
    var fields: ArrayList<String>? = null


    override fun toString(): String {
        return fields!!.sorted().joinToString()
    }
}