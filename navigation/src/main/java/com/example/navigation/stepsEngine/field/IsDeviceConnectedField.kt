package com.example.navigation.stepsEngine.field

import com.example.navigation.stepsEngine.payment.FlowState

class IsDeviceConnectedField : Field() {
    override operator fun get(flowState: FlowState): Boolean? {
        return flowState.pos.isConnected
    }

    override fun getId(): String {
        return FieldName.IS_DEVICE_CONNECTED
    }

    override operator fun set(flowState: FlowState, value: Any?) {}
}