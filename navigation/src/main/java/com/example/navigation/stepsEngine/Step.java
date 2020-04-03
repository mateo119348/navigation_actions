package com.example.navigation.stepsEngine;

import java.util.List;

public class Step {
    private StepIdentifier stepIdentifier;
    private List<String> requiredFields;
    private List<String> optionalFields;
    private Rule rule;

    public StepIdentifier getStepIdentifier() {
        return stepIdentifier;
    }

    public List<String> getRequiredFields() {
        return requiredFields;
    }

    public List<String> getOptionalFields() {
        return optionalFields;
    }

    public Rule getRule() {
        return rule;
    }
}
