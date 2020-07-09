package com.example.navigation.steps.payment.cart

import java.util.*


class Cart {
    var id: Long? = null
    var rawAmount = 0.0
    var rawFullPriceAmount = 0.0
    var sellerId: String? = null
    var currencyId: String? = null
    var dateCreated: Date? = null
    var lastUpdated: Date? = null
    var paymentId: String? = null
    var paymentStatus: String? = null
    var products: List<Product>? = null
    var discount: Discount? = null

}