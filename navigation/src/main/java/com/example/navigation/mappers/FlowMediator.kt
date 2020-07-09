package com.example.navigation.mappers

import com.example.navigation.action.Action
import com.example.navigation.action.RuleAction
import com.example.navigation.stepsEngine.field.Field

interface FlowMediator : Cloneable{
    fun startAction(action: RuleAction)
    //fun executeNextField(action: Action, fields: List<String>?)
    fun addAction(action: Action)
    fun containsAction(action: RuleAction) : Boolean
    public override fun clone(): FlowMediator
}