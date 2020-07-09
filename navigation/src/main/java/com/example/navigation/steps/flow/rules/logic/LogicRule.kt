package com.example.navigation.steps.flow.rules.logic

import com.example.navigation.steps.flow.rules.base.Rule

abstract class LogicRule : Rule() {
    var rules = ArrayList<Rule>()

    open val fieldName: String?
        get() {
            throw IllegalArgumentException("LogicRule must not have a related field name")
        }
}