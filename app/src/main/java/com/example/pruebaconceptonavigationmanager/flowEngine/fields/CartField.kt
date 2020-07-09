package com.example.pruebaconceptonavigationmanager.flowEngine.fields

import com.example.navigation.stepsEngine.field.Field
import com.example.navigation.stepsEngine.field.FieldId
import com.example.navigation.stepsEngine.payment.FlowState
import com.example.navigation.stepsEngine.payment.cart.Cart
import kotlinx.android.parcel.Parcelize

@Parcelize
class CartField(val field: FieldId) : Field(field)  {

    override fun get(flowState: FlowState): Any? {
        return flowState.cart
    }

    override fun set(flowState: FlowState, value: Any?) {
        flowState.cart = value as Cart
    }

    override fun initState(flowState: FlowState) {
        flowState.cart = Cart()
    }
}