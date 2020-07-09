package com.example.navigation.action

class RuleAction: Cloneable {
    lateinit var id: String
    var fields: ArrayList<String>? = null



    fun containsField(field: String): Boolean{
        return fields!!.contains(field)
    }

    override fun toString(): String {
        return fields!!.sorted().joinToString()
    }

    public override fun clone(): RuleAction {
        val copy = RuleAction()
        copy.id = id
        copy.fields = fields
        return copy
    }
}