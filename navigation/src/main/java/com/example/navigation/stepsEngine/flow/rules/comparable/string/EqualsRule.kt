package com.example.navigation.stepsEngine.flow.rules.comparable.string

import com.example.navigation.stepsEngine.flow.rules.comparable.ComparableRule
import com.example.navigation.stepsEngine.payment.FlowState

class EqualsRule : ComparableRule() {


    override fun evaluate(flowState: FlowState): Boolean {
        when (ruleClass) {
            Boolean.javaClass ->  getValue(flowState) as Boolean == value as Boolean
            String.javaClass -> getValue(flowState) as String == value
            Double.javaClass -> getValue(flowState) as Double == value!! as Double
            Int.javaClass -> getValue(flowState) as Int == value!! as Int
        }

        return true
    }
}