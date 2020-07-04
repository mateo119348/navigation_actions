package com.example.navigation.action

import com.example.navigation.stepsEngine.field.Field

class RuleAction {
    var id: String? = null
    private var fields: ArrayList<String>? = null
    private var fieldsImpl: ArrayList<Field>? = null

    fun getFields(): ArrayList<Field>?{
        if (fieldsImpl == null) {
            fieldsImpl = ArrayList()
            fields?.forEach {
                fieldsImpl!!.add(Field.getFlowStateField(it)!!)
            }
        }
        return fieldsImpl;
    }

    fun containsField(field: String): Boolean{
        return fields!!.contains(field)
    }

    override fun toString(): String {
        return fields!!.sorted().joinToString()
    }
}