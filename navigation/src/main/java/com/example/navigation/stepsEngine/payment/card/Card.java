package com.example.navigation.stepsEngine.payment.card;

import com.example.navigation.stepsEngine.enums.PinType;
import com.example.navigation.stepsEngine.enums.Tag;
import com.example.navigation.stepsEngine.enums.Type;

public class Card {

    private String encryptedTrack1;
    private String encryptedTrack2;
    private String encryptedTrack1KeySerialNumber;
    private String encryptedTrack2KeySerialNumber;
    private Pin pin;
    private String cardHolderName;
    private String securityCode;
    private boolean fallback;
    private String firstGenEMVData;
    private FinishTransaction finishTransaction;
    private String panSequenceNumber;
    private boolean mustCollectSignatureEMV;
    private Tag tag;
    private Type type;
    private String cardTokenId;
    private Long issuer;
    private String firstSixDigits;
    private String lastFourDigits;
    private String serviceCode;
    private String cvv;

    public Card(){
        final Pin pin = new Pin();
        pin.setPinType(PinType.NONE);
        this.pin = pin;
    }

    public String getEncryptedTrack1() {
        return encryptedTrack1;
    }

    public void setEncryptedTrack1(String encryptedTrack1) {
        this.encryptedTrack1 = encryptedTrack1;
    }

    public String getEncryptedTrack2() {
        return encryptedTrack2;
    }

    public void setEncryptedTrack2(String encryptedTrack2) {
        this.encryptedTrack2 = encryptedTrack2;
    }

    public String getEncryptedTrack1KeySerialNumber() {
        return encryptedTrack1KeySerialNumber;
    }

    public void setEncryptedTrack1KeySerialNumber(String encryptedTrack1KeySerialNumber) {
        this.encryptedTrack1KeySerialNumber = encryptedTrack1KeySerialNumber;
    }

    public String getEncryptedTrack2KeySerialNumber() {
        return encryptedTrack2KeySerialNumber;
    }

    public void setEncryptedTrack2KeySerialNumber(String encryptedTrack2KeySerialNumber) {
        this.encryptedTrack2KeySerialNumber = encryptedTrack2KeySerialNumber;
    }

    public Pin getPin() {
        return pin;
    }

    public void setPin(Pin pin) {
        this.pin = pin;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public boolean isFallback() {
        return fallback;
    }

    public void setFallback(boolean fallback) {
        this.fallback = fallback;
    }

    public String getFirstGenEMVData() {
        return firstGenEMVData;
    }

    public void setFirstGenEMVData(String firstGenEMVData) {
        this.firstGenEMVData = firstGenEMVData;
    }

    public FinishTransaction getFinishTransaction() {
        return finishTransaction;
    }

    public void setFinishTransaction(FinishTransaction finishTransaction) {
        this.finishTransaction = finishTransaction;
    }

    public String getPanSequenceNumber() {
        return panSequenceNumber;
    }

    public void setPanSequenceNumber(String panSequenceNumber) {
        this.panSequenceNumber = panSequenceNumber;
    }

    public boolean isMustCollectSignatureEMV() {
        return mustCollectSignatureEMV;
    }

    public void setMustCollectSignatureEMV(boolean mustCollectSignatureEMV) {
        this.mustCollectSignatureEMV = mustCollectSignatureEMV;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getCardTokenId() {
        return cardTokenId;
    }

    public void setCardTokenId(String cardTokenId) {
        this.cardTokenId = cardTokenId;
    }

    public Long getIssuer() {
        return issuer;
    }

    public void setIssuer(Long issuer) {
        this.issuer = issuer;
    }

    public String getFirstSixDigits() {
        return firstSixDigits;
    }

    public void setFirstSixDigits(String firstSixDigits) {
        this.firstSixDigits = firstSixDigits;
    }

    public String getLastFourDigits() {
        return lastFourDigits;
    }

    public void setLastFourDigits(String lastFourDigits) {
        this.lastFourDigits = lastFourDigits;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getCvv() {
        return cvv;
    }
}
