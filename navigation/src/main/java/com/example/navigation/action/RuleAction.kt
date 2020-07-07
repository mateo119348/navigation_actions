package com.example.navigation.action

import com.example.navigation.stepsEngine.field.Field
import com.example.navigation.mappers.FieldMapper

class RuleAction {
    var id: String? = null
    var fields: ArrayList<String>? = null



    fun containsField(field: String): Boolean{
        return fields!!.contains(field)
    }

    override fun toString(): String {
        return fields!!.sorted().joinToString()
    }
}