package com.example.navigation.stepsEngine.field

import com.example.navigation.stepsEngine.payment.FlowState
import com.example.navigation.stepsEngine.payment.cart.Cart
import kotlinx.android.parcel.Parcelize

@Parcelize
class CartField : Field() {

    override fun getId(): String {
        return FieldName.CART
    }

    override fun get(flowState: FlowState): Any? {
        return flowState.cart
    }

    override fun set(flowState: FlowState, value: Any?) {
        flowState.cart = value as Cart
    }
}