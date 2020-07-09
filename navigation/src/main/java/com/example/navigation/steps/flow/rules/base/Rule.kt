package com.example.navigation.steps.flow.rules.base

import com.example.navigation.steps.flow.rules.comparable.GreaterThanRule
import com.example.navigation.steps.flow.rules.comparable.LessEqualThanRule
import com.example.navigation.steps.flow.rules.comparable.NullRule
import com.example.navigation.steps.flow.rules.comparable.string.*
import com.example.navigation.steps.flow.rules.logic.AndRule
import com.example.navigation.steps.flow.rules.logic.NotRule
import com.example.navigation.steps.flow.rules.logic.OrRule
import com.example.navigation.steps.payment.FlowState
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes(  JsonSubTypes.Type(value = AndRule::class, name = RuleIdentifiers.AND),
                JsonSubTypes.Type(value = NotRule::class, name = RuleIdentifiers.NOT),
                JsonSubTypes.Type(value = OrRule::class, name = RuleIdentifiers.OR),
                JsonSubTypes.Type(value = NullRule::class, name = RuleIdentifiers.NULL),
                JsonSubTypes.Type(value = EqualsRule::class, name = RuleIdentifiers.EQUALS),
                JsonSubTypes.Type(value = GreaterThanRule::class, name = RuleIdentifiers.GREATER_THAN),
                JsonSubTypes.Type(value = LessEqualThanRule::class, name = RuleIdentifiers.LESS_EQUAL_THAN),
                JsonSubTypes.Type(value = StringContainsRule::class, name = RuleIdentifiers.STRING_CONTAINS),
                JsonSubTypes.Type(value = StringIsContainedRule::class, name = RuleIdentifiers.STRING_IS_CONTAINED),
                JsonSubTypes.Type(value = StringInListRule::class, name = RuleIdentifiers.STRING_IN_LIST),
                JsonSubTypes.Type(value = StringLeesThan::class, name = RuleIdentifiers.STRING_LEES_THAN))
abstract class Rule {
    /**
     * Evaluates this rule and any sub rule contained in it
     *
     * @param flowState the current payment information. Must NOT be `null`.
     * @return The result of the evaluation
     */

    abstract fun evaluate(flowState: FlowState): Boolean
}