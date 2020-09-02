package com.example.navigation.flowEngine.steps.rules.comparable

import com.example.navigation.flowEngine.steps.field.Field
import com.example.navigation.flowEngine.steps.rules.base.Rule
import com.example.navigation.flowEngine.steps.flowState.FlowState

abstract class ComparableRule : Rule() {

    protected open lateinit var field: String
    open lateinit var value: String
    var valueType: String? = null
    var isNot = false
    private var fieldValue: Field? = null


    private fun getField(flowState: FlowState): Field? {
        if (fieldValue == null)
            fieldValue = flowState.getField(field)
        return fieldValue
    }

    fun getValue(flowState: FlowState): Any? {
        val value = getField(flowState)!!.get(flowState)
        if (this !is NullRule)
            checkNotNull(value) { String.format("the %s field must not be null", getField(flowState)!!.id)}
        return value
    }

}