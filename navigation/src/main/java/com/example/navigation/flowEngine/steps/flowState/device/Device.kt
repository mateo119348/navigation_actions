package com.example.navigation.flowEngine.steps.flowState.device

import com.example.navigation.flowEngine.steps.enums.ConnectionScheme
import com.example.navigation.flowEngine.steps.enums.DeviceType
import com.example.navigation.flowEngine.steps.enums.EncryptionAlgorithm
import com.example.navigation.flowEngine.steps.enums.KeyManagementScheme

class Device {
    var type: DeviceType? = null
    var connectionScheme: ConnectionScheme? = null
    var trackKeyManagementScheme: List<KeyManagementScheme>? = null
    var trackEncryptionAlgorithm: EncryptionAlgorithm? = null

}