package com.example.navigation.stepsEngine.payment.card;

import com.example.navigation.stepsEngine.enums.PinType;

public class Pin {

    private String encryptedBlock;
    private String keySerialNumber;
    private PinType pinType;

    public String getEncryptedBlock() {
        return encryptedBlock;
    }

    public void setEncryptedBlock(String encryptedBlock) {
        this.encryptedBlock = encryptedBlock;
    }

    public String getKeySerialNumber() {
        return keySerialNumber;
    }

    public void setKeySerialNumber(String keySerialNumber) {
        this.keySerialNumber = keySerialNumber;
    }

    public PinType getPinType() {
        return pinType;
    }

    public void setPinType(PinType pinType) {
        this.pinType = pinType;
    }

}

