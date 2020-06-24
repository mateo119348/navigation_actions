package com.example.navigation.stepsEngine.configuration

import com.example.navigation.stepsEngine.configuration.specific.AcquirerSpecificConfiguration
import com.example.navigation.stepsEngine.configuration.table.Table
import com.example.navigation.stepsEngine.enums.ConnectionScheme
import com.example.navigation.stepsEngine.enums.DeviceType
import com.example.navigation.stepsEngine.enums.EncryptionAlgorithm
import com.example.navigation.stepsEngine.enums.KeyManagementScheme

class Configuration {
    var version: Long? = null
    var type: DeviceType? = null
    var table: Table? = null
    var connectionScheme: ConnectionScheme? = null
    var trackKeyManagementSchemes: List<KeyManagementScheme>? = null
    var trackEncryptionAlgorithm: EncryptionAlgorithm? = null
    var acquirerSpecificConfigurations: List<AcquirerSpecificConfiguration>? = null

}