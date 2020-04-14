package com.example.navigation.stepsEngine.flow;

import com.example.navigation.action.Field;
import com.example.navigation.stepsEngine.enums.StepIdentifier;
import com.example.navigation.stepsEngine.flow.rules.base.Rule;
import com.example.navigation.stepsEngine.payment.PointPayment;

import java.util.List;

public class Step {

    private StepIdentifier stepIdentifier;
    private List<Field> requiredFields;
    private List<Field> optionalFields;
    private Rule rule;

    public StepIdentifier getStepIdentifier() {
        return stepIdentifier;
    }

    public void setStepIdentifier(StepIdentifier stepIdentifier) {
        this.stepIdentifier = stepIdentifier;
    }

    public List<Field> getRequiredFields() {
        return requiredFields;
    }

    public List<Field> getOptionalFields() {
        return optionalFields;
    }

    public void setOptionalFields(List<Field> optionalFields) {
        this.optionalFields = optionalFields;
    }

    public void setRequiredFields(List<Field> requiredFields) {
        this.requiredFields = requiredFields;
    }

    public Rule getRule() {
        return rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }

    public boolean mustExecute(final PointPayment pointPayment) {
        return rule == null || rule.evaluate(pointPayment);
    }

    public Boolean isFinalStep() {
        return stepIdentifier == StepIdentifier.END;
    }

}
