package com.example.navigation.stepsEngine.flow.rules.comparable

import com.example.navigation.action.FlowManager
import com.example.navigation.stepsEngine.field.Field
import com.example.navigation.stepsEngine.flow.rules.base.Rule
import com.example.navigation.stepsEngine.payment.FlowState

abstract class ComparableRule : Rule() {

    protected open var field: String? = null
    open lateinit var value: String
    var valueType: String? = null
    var isNot = false
    private var fieldValue: Field? = null


    private fun getField(): Field? {
        if (fieldValue == null)
            fieldValue = FlowManager.getField(field!!)
        return fieldValue;
    }

    fun getValue(flowState: FlowState): Any? {

        val value = getField()!!.get(flowState)
        if (this !is NullRule)
            checkNotNull(value) { String.format("the %s field must not be null", getField()!!.id)}
        return value
    }

}