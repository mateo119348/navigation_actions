package com.example.navigation.stepsEngine.flow.rules.base;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.example.navigation.stepsEngine.flow.rules.comparable.*;
import com.example.navigation.stepsEngine.flow.rules.comparable.string.*;
import com.example.navigation.stepsEngine.flow.rules.logic.AndRule;
import com.example.navigation.stepsEngine.flow.rules.logic.NotRule;
import com.example.navigation.stepsEngine.flow.rules.logic.OrRule;
import com.example.navigation.stepsEngine.payment.PointPayment;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = AndRule.class, name = RuleIdentifiers.AND),
        @JsonSubTypes.Type(value = NotRule.class, name = RuleIdentifiers.NOT),
        @JsonSubTypes.Type(value = OrRule.class, name = RuleIdentifiers.OR),
        @JsonSubTypes.Type(value = NullRule.class, name = RuleIdentifiers.NULL),
        @JsonSubTypes.Type(value = StringEqualsRule.class, name = RuleIdentifiers.STRING_EQUALS),
        @JsonSubTypes.Type(value = IsGreaterThanRule.class, name = RuleIdentifiers.IS_GREATER_THAN),
        @JsonSubTypes.Type(value = IsLowerEqualThanRule.class, name = RuleIdentifiers.IS_LOWER_EQUAL_THAN)
        @JsonSubTypes.Type(value = StringContainsRule.class, name = RuleIdentifiers.STRING_CONTAINS),
        @JsonSubTypes.Type(value = StringEmptyRule.class, name = RuleIdentifiers.STRING_EMPTY),
        @JsonSubTypes.Type(value = StringIsContainedRule.class, name = RuleIdentifiers.STRING_IS_CONTAINED),
        @JsonSubTypes.Type(value = StringInListRule.class, name = RuleIdentifiers.STRING_IN_LIST),
        @JsonSubTypes.Type(value = BooleanEqualsRule.class, name = RuleIdentifiers.BOOLEAN_EQUALS)})
public abstract class Rule {

    /**
     * Evaluates this rule and any sub rule contained in it
     *
     * @param pointPayment the current payment information. Must NOT be <code>null</code>.
     * @return The result of the evaluation
     */
    public abstract boolean evaluate(final PointPayment pointPayment);

    public abstract String getFieldName();
}
