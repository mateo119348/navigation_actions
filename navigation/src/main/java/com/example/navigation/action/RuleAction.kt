package com.example.navigation.action

import android.util.ArrayMap

class RuleAction {
    var id: String? = null
    var fields: ArrayMap<String, Object>? = null


    override fun toString(): String {
        return fields!!.keys.sorted().joinToString()
    }
}