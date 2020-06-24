package com.example.navigation.stepsEngine.field

import com.example.navigation.stepsEngine.payment.FlowState
import com.example.navigation.stepsEngine.payment.device.Device

class DeviceField : Field() {
    override operator fun get(flowState: FlowState): Device? {
        return flowState.pos.device
    }

    override fun getId(): String {
        return FieldName.DEVICE
    }

    override operator fun set(flowState: FlowState, value: Any?) {}
}