package com.example.navigation.stepsEngine.payment.cart

import java.util.*

class Product {
    var id: Long? = null
    var itemId: String? = null
    var title: String? = null
    var price: Double? = null
    var reservationCurrency: String? = null
    var fullPrice: Double? = null
    var description: String? = null
    var thumbnail: String? = null
    var secureThumbnail: String? = null
    var pictureUrl: String? = null
    var pictureSecureUrl: String? = null
    var pictureSize: String? = null
    var initials: String? = null
    var color = "#FFA1DFF3"
    var sellerId: String? = null
    var siteId: String? = null
    var currencyId: String? = null
    var dateCreated: Date? = null
    var lastUpdate: Date? = null
    var quantity: Int? = null
    var categoryId: Long? = null
    var category: ProductCategory? = null
    var variants: List<ProductVariant> = ArrayList()
    var isSelected = false
    var variantSelected: ProductVariant? = null

}