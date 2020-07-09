package com.example.navigation.steps.flow.rules.comparable

import com.example.navigation.steps.field.Field
import com.example.navigation.steps.flow.rules.base.Rule
import com.example.navigation.steps.payment.FlowState

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