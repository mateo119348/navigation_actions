package com.example.navigation.stepsEngine.flow.rules.comparable

import com.example.navigation.stepsEngine.field.Field
import com.example.navigation.stepsEngine.field.Field.Companion.getFlowStateField
import com.example.navigation.stepsEngine.flow.rules.base.Rule
import com.example.navigation.stepsEngine.payment.FlowState
import java.lang.reflect.Type

abstract class ComparableRule : Rule() {

    var field: String? = null
    var value: String? = null
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

    val ruleClass: () -> Class<out Any>
        get() = {
            when(valueType){
                ValueTypes.BOOL -> Boolean::class.java
                ValueTypes.DECIMAL -> Double::class.java
                ValueTypes.INT -> Int::class.java
                else -> String::class.java
            }
        }

//            if (valueType == "bool") Boolean::class.java
//        else if (valueType == "string") String::class.java
//        else if (valueType == "decimal") Double::class.java
//        else if (valueType == "int") Int::class.java
//        else throw IllegalStateException(String.format("Error in value_type. Check your json!!!"))
}