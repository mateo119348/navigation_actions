package com.example.navigation.stepsEngine.payment.device

import com.example.navigation.stepsEngine.enums.ConnectionScheme
import com.example.navigation.stepsEngine.enums.DeviceType
import com.example.navigation.stepsEngine.enums.EncryptionAlgorithm
import com.example.navigation.stepsEngine.enums.KeyManagementScheme

class Device {
    var type: DeviceType? = null
    var connectionScheme: ConnectionScheme? = null
    var trackKeyManagementScheme: List<KeyManagementScheme>? = null
    var trackEncryptionAlgorithm: EncryptionAlgorithm? = null

}