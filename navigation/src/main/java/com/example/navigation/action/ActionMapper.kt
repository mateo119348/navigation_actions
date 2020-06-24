package com.example.navigation.action

interface ActionMapper {
    fun executeAction(action: RuleAction, vararg params: Any?)
    fun executeNextField(action: Action, vararg params: Any?)
}