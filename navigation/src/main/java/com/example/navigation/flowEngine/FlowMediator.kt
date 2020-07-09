package com.example.navigation.flowEngine

import com.example.navigation.action.Action
import com.example.navigation.action.RuleAction

interface FlowMediator : Cloneable{
    fun executeAction(action: RuleAction)
    fun addAction(action: Action)
    fun getAction(action: RuleAction?): Action?
    public override fun clone(): FlowMediator
}