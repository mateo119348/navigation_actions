package com.example.navigation.flowEngine

import com.example.navigation.flowEngine.actions.FunctionAction
import com.example.navigation.flowEngine.actions.RuleAction

interface FlowMediator : Cloneable{
    fun executeAction(action: RuleAction)
    fun addAction(action: FunctionAction)
    fun getAction(action: RuleAction?): FunctionAction?
    public override fun clone(): FlowMediator
}