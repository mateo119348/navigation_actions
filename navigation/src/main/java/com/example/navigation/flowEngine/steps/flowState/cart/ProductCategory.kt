package com.example.navigation.flowEngine.steps.flowState.cart

class ProductCategory {
    var sellerId: String? = null
    var color = "#FF00B1EA"
    var name: String? = null
    var id: Long = 0
    var index = 0
    var products: List<Product> = emptyList()
    var productsIds = emptyList<Long>()

}