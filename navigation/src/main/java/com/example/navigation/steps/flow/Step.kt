package com.example.navigation.steps.flow

import com.example.navigation.action.RuleAction
import com.example.navigation.steps.field.FieldMapper
import com.example.navigation.steps.enums.StepIdentifier
import com.example.navigation.steps.flow.rules.base.Rule
import com.example.navigation.steps.flow.rules.comparable.NullRule
import com.example.navigation.steps.flow.rules.logic.OrRule
import com.example.navigation.steps.payment.FlowState

class Step: Cloneable{
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


    lateinit var fieldMapper: FieldMapper

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
        val orRule = OrRule()
        orRule.rules = ArrayList()
        if (requiredFields != null && requiredFields!!.isNotEmpty()) {
            requiredFields?.forEach { it ->
                val nullRule = NullRule(it)
                orRule.rules.add(nullRule)
            }
        }

        return when (orRule.rules.size) {
            1 -> orRule.rules[0]
            0 -> throw IllegalArgumentException(String.format(" The %s step must have at least one required field or rule", stepIdentifier.name))
            else -> orRule
        }
    }

    /**
     * Busco la siguiente accion despues de la que recibe por parametro, si no hay mas, devuelvo null
     */
    fun getNextAction(currentRuleAction: RuleAction?): RuleAction? {
        var index = actions.indexOf(currentRuleAction)
        index++
        return actions.getOrNull(index)
    }

    fun getFistAction(): RuleAction {
        return actions.first()
    }

    fun previousAction(currentRuleAction: RuleAction?): RuleAction? {
        var index = actions.indexOf(currentRuleAction)
        index--
        return actions.getOrNull(index)
    }

    fun getLastAction(): RuleAction {
        return actions.last()
    }

    public override fun clone(): Step {
        val copy = Step()
        copy.stepIdentifier = stepIdentifier
        copy.requiredFields = requiredFields
        copy.optionalFields = optionalFields
        copy.rule = rule
        return copy
    }


}