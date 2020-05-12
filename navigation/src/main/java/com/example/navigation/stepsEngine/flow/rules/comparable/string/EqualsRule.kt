package com.example.navigation.stepsEngine.flow.rules.comparable.string

import com.example.navigation.stepsEngine.field.FlowStateField
import com.example.navigation.stepsEngine.flow.rules.comparable.ComparableRule
import com.example.navigation.stepsEngine.payment.FlowState

class EqualsRule : ComparableRule() {
    private var value: String? = null

    override fun getValue(): String {
        return value!!
    }

    fun setValue(value: String?) {
        this.value = value
    }

    override fun evaluate(flowState: FlowState): Boolean {
        when (ruleClass) {
            Boolean.javaClass ->  field[flowState] as Boolean == value as Boolean
            String.javaClass -> field[flowState] as String == value
            Double.javaClass -> field[flowState] as Double == value!! as Double
            Int.javaClass -> field[flowState] as Int == value!! as Int
        }

        return true
    }
}