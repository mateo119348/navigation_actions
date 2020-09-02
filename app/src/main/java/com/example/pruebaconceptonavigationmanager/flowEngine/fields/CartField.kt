package com.example.pruebaconceptonavigationmanager.flowEngine.fields

import com.example.navigation.flowEngine.steps.field.Field
import com.example.navigation.flowEngine.steps.field.FieldId
import com.example.navigation.flowEngine.steps.flowState.FlowState
import com.example.navigation.flowEngine.steps.flowState.cart.Cart
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