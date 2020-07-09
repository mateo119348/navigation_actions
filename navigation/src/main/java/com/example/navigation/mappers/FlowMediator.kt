package com.example.navigation.mappers

import com.example.navigation.action.Action
import com.example.navigation.action.RuleAction

interface FlowMediator : Cloneable{
    fun startAction(action: RuleAction)
    fun addAction(action: Action)
    fun containsAction(action: RuleAction) : Boolean
    public override fun clone(): FlowMediator
}