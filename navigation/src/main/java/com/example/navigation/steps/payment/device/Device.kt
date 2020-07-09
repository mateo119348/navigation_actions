package com.example.navigation.steps.payment.device

import com.example.navigation.steps.enums.ConnectionScheme
import com.example.navigation.steps.enums.DeviceType
import com.example.navigation.steps.enums.EncryptionAlgorithm
import com.example.navigation.steps.enums.KeyManagementScheme

class Device {
    var type: DeviceType? = null
    var connectionScheme: ConnectionScheme? = null
    var trackKeyManagementScheme: List<KeyManagementScheme>? = null
    var trackEncryptionAlgorithm: EncryptionAlgorithm? = null

}