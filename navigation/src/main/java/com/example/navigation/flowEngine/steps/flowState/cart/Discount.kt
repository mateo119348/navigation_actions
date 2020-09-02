package com.example.navigation.flowEngine.steps.flowState.cart

import java.math.BigDecimal

class Discount {
    var value = BigDecimal.ZERO
    var type = PERCENTAGE
    var discountedAmount = BigDecimal.ZERO

    companion object {
        const val PERCENTAGE = "percentage"
        const val AMOUNT = "amount"
    }
}