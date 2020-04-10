package com.example.navigation.stepsEngine.flow.rules.logic;

import com.example.navigation.stepsEngine.flow.rules.base.Rule;

import java.util.List;

public abstract class LogicRule extends Rule {

    private List<Rule> subRules;

    public List<Rule> getSubRules() {
        return subRules;
    }

    public void setSubRules(List<Rule> subRules) {
        this.subRules = subRules;
    }

    @Override
    public String getFieldName() {
        throw new IllegalArgumentException("LogicRule must not have a related field name");
    }

}
