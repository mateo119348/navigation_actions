package com.example.navigation.stepsEngine.flow

import com.example.navigation.action.RuleAction
import com.example.navigation.stepsEngine.enums.StepIdentifier
import com.example.navigation.stepsEngine.field.Field
import com.example.navigation.stepsEngine.flow.rules.base.Rule
import com.example.navigation.stepsEngine.flow.rules.base.RuleIdentifiers
import com.example.navigation.stepsEngine.flow.rules.comparable.NullRule
import com.example.navigation.stepsEngine.flow.rules.logic.OrRule
import com.example.navigation.stepsEngine.payment.FlowState
import kotlin.math.absoluteValue

class Step {
    lateinit var stepIdentifier: StepIdentifier
        private set
    var requiredFields: List<String>? = null
        private set
    var optionalFields: List<String>? = null
        private set
    var rule: Rule? = null
        private set
        get() {
            field ?: run {
                field = generateNullRules()
            }
            return field
        }



    var actions: List<RuleAction> = ArrayList()

    var wasExecuted: Boolean = false


    fun mustExecute(flowState: FlowState): Boolean {
        return rule == null || rule!!.evaluate(flowState)
    }

    val isFinalStep: Boolean
        get() = stepIdentifier == StepIdentifier.END

    override fun toString(): String {
        return requiredFields!!.plus(optionalFields!!).sorted().joinToString()
    }

    fun requiredFieldsToString(): String {
        return requiredFields!!.sorted().joinToString()
    }

    fun optionalFieldsToString(): String {
        return optionalFields!!.sorted().joinToString()
    }

    private fun generateNullRules(): Rule? {
        var orRule = OrRule()
        orRule.rules = ArrayList()
        if (requiredFields != null && requiredFields!!.isNotEmpty()) {
            requiredFields?.forEach { it ->
                orRule.rules.add(NullRule(it))
            }
        }

        return when (orRule.rules.size) {
            1 -> orRule.rules[0]
            0 -> throw IllegalArgumentException(String.format(" The %s step must have at least one required field or rule", stepIdentifier.name))
            else -> orRule
        }
    }

    fun getNextAction(currentRuleAction: RuleAction?): RuleAction? {
        return if (currentRuleAction == null) {
            actions.first()
        } else {
            var index = actions.indexOf(currentRuleAction)
            index++
            return if (index == actions.size) {
                null
            } else
                actions[index]
        }
    }

    fun previousAction(currentRuleAction: RuleAction?): RuleAction? {
        var index = actions.indexOf(currentRuleAction)
        return if (index == 0 )
            null
        else {
            index--
            actions[index]
        }
    }

    fun getLastAction(): RuleAction {
        return actions.last()
    }


}