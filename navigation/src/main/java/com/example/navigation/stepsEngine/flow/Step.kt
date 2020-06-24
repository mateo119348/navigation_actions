package com.example.navigation.stepsEngine.flow

import com.example.navigation.stepsEngine.enums.StepIdentifier
import com.example.navigation.stepsEngine.field.Field
import com.example.navigation.stepsEngine.flow.rules.base.Rule
import com.example.navigation.stepsEngine.flow.rules.comparable.NullRule
import com.example.navigation.stepsEngine.flow.rules.logic.OrRule
import com.example.navigation.stepsEngine.payment.FlowState

class Step {
    lateinit var stepIdentifier: StepIdentifier
        private set
    var requiredFields: List<String>? = null
        private set
    var optionalFields: List<String>? = null
        private set
    var rule: Rule? = null
        private set
        //TODO: terminar de implementar
        get() { field?:run {
            field =  generateNullRules()}
            return field
        }

    fun mustExecute(flowState: FlowState): Boolean {
        return rule == null || rule!!.evaluate(flowState)
    }

    val isFinalStep: Boolean
        get() = stepIdentifier == StepIdentifier.END

    override fun toString(): String {
        return requiredFields!!.plus(optionalFields!!).sorted().joinToString()
    }

    fun requiredFieldsToString () : String {
        return requiredFields!!.sorted().joinToString()
    }

    fun optionalFieldsToString () : String {
        return optionalFields!!.sorted().joinToString()
    }

    //TODO: terminar de implementar
    private fun generateNullRules() : Rule?{
        var orRule = OrRule()
        orRule.rules = ArrayList()
        if (requiredFields != null && requiredFields!!.isNotEmpty()) {
            requiredFields?.forEach { it ->
                Field.getFlowStateField(it)?.let { field ->
                    orRule.rules.add(NullRule(field.getId()))
                }

            }
        }
        return orRule;
    }

}