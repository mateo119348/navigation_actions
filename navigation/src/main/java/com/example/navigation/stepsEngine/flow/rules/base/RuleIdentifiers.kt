package com.example.navigation.stepsEngine.flow.rules.base

interface RuleIdentifiers {
    companion object {
        const val AND = "AND"
        const val NOT = "NOT"
        const val OR = "OR"
        const val NULL = "NULL"
        const val EQUALS = "EQUALS"
        const val GREATER_THAN = "GREATER_THAN"
        const val LESS_EQUAL_THAN = "LESS_EQUAL_THAN"
        const val STRING_CONTAINS = "STRING_CONTAINS"
        const val STRING_IS_CONTAINED = "STRING_IS_CONTAINED"
        const val STRING_IN_LIST = "STRING_IN_LIST"
        const val STRING_LEES_THAN = "STRING_LEES_THAN"
    }
}