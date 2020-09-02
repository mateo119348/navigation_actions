package com.example.navigation.flowEngine.steps.rules.comparable.string

import com.example.navigation.flowEngine.steps.rules.comparable.ComparableRule
import com.example.navigation.flowEngine.steps.rules.comparable.ValueTypes
import com.example.navigation.flowEngine.steps.flowState.FlowState
import java.math.BigDecimal

class EqualsRule : ComparableRule() {


    override fun evaluate(flowState: FlowState): Boolean {
        return when (valueType) {
            ValueTypes.BOOL ->  getValue(flowState) as Boolean == value.toBoolean()
            ValueTypes.STRING -> getValue(flowState) as String == value
            ValueTypes.DECIMAL -> getValue(flowState) as BigDecimal == value.toBigDecimal()
            else -> getValue(flowState) as Int == value.toInt()
        }
    }
}