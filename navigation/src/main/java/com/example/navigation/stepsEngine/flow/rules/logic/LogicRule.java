package com.example.navigation.stepsEngine.flow.rules.logic;

import com.example.navigation.stepsEngine.flow.rules.base.Rule;

import java.util.List;

public abstract class LogicRule extends Rule {

    private List<Rule> rules;

    public List<Rule> getRules() {
        return rules;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }


    public String getFieldName() {
        throw new IllegalArgumentException("LogicRule must not have a related field name");
    }

}
