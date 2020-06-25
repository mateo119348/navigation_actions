package com.example.navigation.stepsEngine.flow.rules.comparable

import com.example.navigation.stepsEngine.field.Field
import com.example.navigation.stepsEngine.field.Field.Companion.getFlowStateField
import com.example.navigation.stepsEngine.flow.rules.base.Rule
import com.example.navigation.stepsEngine.payment.FlowState
import java.lang.reflect.Type
import java.math.BigDecimal

abstract class ComparableRule : Rule() {

    open var field: String? = null
    open lateinit var value: String
    var valueType: String? = null
    var isNot = false
    private var fieldValue : Field? = null


    private fun getField() : Field? {
        if (fieldValue == null)
            fieldValue = getFlowStateField(field!!)!!
        return fieldValue;
    }

    fun getValue(flowState : FlowState) : Any?{
        return getField()!!.get(flowState)
    }

}