package com.example.navigation.action;

public interface ActionMapper {

    void executeAction(RuleAction action, Object...params);

    void executeNextField(Action action, Object... params);
}
