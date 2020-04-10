package com.example.navigation.stepsEngine.configuration;

import com.example.navigation.stepsEngine.configuration.specific.AcquirerSpecificConfiguration;
import com.example.navigation.stepsEngine.configuration.table.Table;
import com.example.navigation.stepsEngine.enums.ConnectionScheme;
import com.example.navigation.stepsEngine.enums.DeviceType;
import com.example.navigation.stepsEngine.enums.EncryptionAlgorithm;
import com.example.navigation.stepsEngine.enums.KeyManagementScheme;

import java.util.List;

public class Configuration {

    private Long version;
    private DeviceType type;
    private Table table;
    private ConnectionScheme connectionScheme;
    private List<KeyManagementScheme> trackKeyManagementSchemes;
    private EncryptionAlgorithm trackEncryptionAlgorithm;
    private List<AcquirerSpecificConfiguration> acquirerSpecificConfigurations;

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public DeviceType getType() {
        return type;
    }

    public void setType(DeviceType type) {
        this.type = type;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public ConnectionScheme getConnectionScheme() {
        return connectionScheme;
    }

    public void setConnectionScheme(ConnectionScheme connectionScheme) {
        this.connectionScheme = connectionScheme;
    }

    public List<KeyManagementScheme> getTrackKeyManagementSchemes() {
        return trackKeyManagementSchemes;
    }

    public void setTrackKeyManagementSchemes(List<KeyManagementScheme> trackKeyManagementSchemes) {
        this.trackKeyManagementSchemes = trackKeyManagementSchemes;
    }

    public EncryptionAlgorithm getTrackEncryptionAlgorithm() {
        return trackEncryptionAlgorithm;
    }

    public void setTrackEncryptionAlgorithm(EncryptionAlgorithm trackEncryptionAlgorithm) {
        this.trackEncryptionAlgorithm = trackEncryptionAlgorithm;
    }

    public List<AcquirerSpecificConfiguration> getAcquirerSpecificConfigurations() {
        return acquirerSpecificConfigurations;
    }

    public void setAcquirerSpecificConfigurations(List<AcquirerSpecificConfiguration> acquirerSpecificConfigurations) {
        this.acquirerSpecificConfigurations = acquirerSpecificConfigurations;
    }

}
