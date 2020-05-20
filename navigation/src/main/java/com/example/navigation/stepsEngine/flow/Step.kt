package com.example.navigation.stepsEngine.flow

import com.example.navigation.stepsEngine.enums.StepIdentifier
import com.example.navigation.stepsEngine.field.Field
import com.example.navigation.stepsEngine.flow.rules.base.Rule
import com.example.navigation.stepsEngine.payment.FlowState

class Step {
    var stepIdentifier: StepIdentifier? = null
        private set
    var requiredFields: List<String>? = null
        private set
    var optionalFields: List<String>? = null
        private set
    var rule: Rule? = null
        private set
        //TODO: terminar de implementar
        get() { rule?:run {  rule =  generateNullRules()}
            return rule}

    fun mustExecute(flowState: FlowState?): Boolean {
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
        var retval : Rule? = null
        if (requiredFields != null && requiredFields!!.isNotEmpty()) {
            requiredFields?.forEach {
                Field.getFlowStateField(it, false)?.run {
                    //retval.add()
                }

            }
        }

        return retval;
    }

}