package com.example.navigation.stepsEngine.flow;

import com.example.navigation.stepsEngine.flow.rules.base.Rule;

import java.util.List;

public class Field {

    String id;
    String type;
    List<Rule> rules;

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public List<Rule> getRules() {
        return rules;
    }
}
