package com.example.navigation.stepsEngine.field

import com.example.navigation.stepsEngine.payment.FlowState

class DeviceTypeField : Field() {
    override operator fun get(flowState: FlowState): String? {
        return flowState.pos.device?.type?.name
    }

    override fun getId(): String {
        return FieldName.DEVICE_TYPE
    }

    override operator fun set(flowState: FlowState, value: Any?) {}
}