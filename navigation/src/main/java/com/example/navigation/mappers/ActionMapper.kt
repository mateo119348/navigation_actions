package com.example.navigation.mappers

import com.example.navigation.action.Action
import com.example.navigation.action.ActionId
import com.example.navigation.action.RuleAction
import com.example.navigation.stepsEngine.field.Field

interface ActionMapper {
    fun startAction(action: RuleAction)
    fun executeNextField(action: Action, fields: List<Field>?)

}