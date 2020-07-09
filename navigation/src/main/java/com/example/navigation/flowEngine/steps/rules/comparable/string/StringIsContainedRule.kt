package com.example.navigation.flowEngine.steps.rules.comparable.string

import com.example.navigation.flowEngine.steps.rules.comparable.ComparableRule
import com.example.navigation.flowEngine.steps.flowState.FlowState

class StringIsContainedRule : ComparableRule() {
    var start: Int? = null
    var end: Int? = null

    override fun evaluate(flowState: FlowState): Boolean {
        val from = if (start == null) 0 else start!!
        val string = getValue(flowState) as String?
        val to = if (end == null) string!!.length else end!!
        val s = string!!.substring(from, to)
        return value.contains(s)
    }
}