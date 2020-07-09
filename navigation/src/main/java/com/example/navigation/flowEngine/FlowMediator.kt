package com.example.navigation.flowEngine

import com.example.navigation.flowEngine.actions.Action
import com.example.navigation.flowEngine.actions.RuleAction

interface FlowMediator : Cloneable{
    fun executeAction(action: RuleAction)
    fun addAction(action: Action)
    fun getAction(action: RuleAction?): Action?
    public override fun clone(): FlowMediator
}