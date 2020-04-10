package com.example.navigation.stepsEngine.payment.device;

import com.example.navigation.stepsEngine.enums.ConnectionScheme;
import com.example.navigation.stepsEngine.enums.DeviceType;
import com.example.navigation.stepsEngine.enums.EncryptionAlgorithm;
import com.example.navigation.stepsEngine.enums.KeyManagementScheme;

import java.util.List;

public class Device {

    private DeviceType type;
    private ConnectionScheme connectionScheme;
    private List<KeyManagementScheme> trackKeyManagementScheme;
    private EncryptionAlgorithm trackEncryptionAlgorithm;

    public DeviceType getType() {
        return type;
    }

    public void setType(DeviceType type) {
        this.type = type;
    }

    public ConnectionScheme getConnectionScheme() {
        return connectionScheme;
    }

    public void setConnectionScheme(ConnectionScheme connectionScheme) {
        this.connectionScheme = connectionScheme;
    }

    public List<KeyManagementScheme> getTrackKeyManagementScheme() {
        return trackKeyManagementScheme;
    }

    public void setTrackKeyManagementScheme(List<KeyManagementScheme> trackKeyManagementScheme) {
        this.trackKeyManagementScheme = trackKeyManagementScheme;
    }

    public EncryptionAlgorithm getTrackEncryptionAlgorithm() {
        return trackEncryptionAlgorithm;
    }

    public void setTrackEncryptionAlgorithm(EncryptionAlgorithm trackEncryptionAlgorithm) {
        this.trackEncryptionAlgorithm = trackEncryptionAlgorithm;
    }

}
