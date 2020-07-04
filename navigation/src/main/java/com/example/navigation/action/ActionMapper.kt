package com.example.navigation.action

interface ActionMapper {
    fun startAction(action: RuleAction)
    fun executeNextField(action: Action, vararg params: Any?)
}