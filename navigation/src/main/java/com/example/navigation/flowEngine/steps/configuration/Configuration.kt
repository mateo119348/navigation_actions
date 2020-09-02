package com.example.navigation.flowEngine.steps.configuration

import com.example.navigation.flowEngine.steps.configuration.specific.AcquirerSpecificConfiguration
import com.example.navigation.flowEngine.steps.configuration.table.Table
import com.example.navigation.flowEngine.steps.enums.ConnectionScheme
import com.example.navigation.flowEngine.steps.enums.DeviceType
import com.example.navigation.flowEngine.steps.enums.EncryptionAlgorithm
import com.example.navigation.flowEngine.steps.enums.KeyManagementScheme

class Configuration {
    var version: Long? = null
    var type: DeviceType? = null
    var table: Table? = null
    var connectionScheme: ConnectionScheme? = null
    var trackKeyManagementSchemes: List<KeyManagementScheme>? = null
    var trackEncryptionAlgorithm: EncryptionAlgorithm? = null
    var acquirerSpecificConfigurations: List<AcquirerSpecificConfiguration>? = null

}