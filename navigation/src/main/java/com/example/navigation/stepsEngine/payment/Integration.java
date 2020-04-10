package com.example.navigation.stepsEngine.payment;

import com.example.navigation.stepsEngine.enums.IntegrationType;

public class Integration {

    private Long paymentAttempt;
    private Long sponsorId;
    private Long notificationURL;
    private IntegrationType integrationType;

    public Long getPaymentAttempt() {
        return paymentAttempt;
    }

    public void setPaymentAttempt(Long paymentAttempt) {
        this.paymentAttempt = paymentAttempt;
    }

    public Long getSponsorId() {
        return sponsorId;
    }

    public void setSponsorId(Long sponsorId) {
        this.sponsorId = sponsorId;
    }

    public Long getNotificationURL() {
        return notificationURL;
    }

    public void setNotificationURL(Long notificationURL) {
        this.notificationURL = notificationURL;
    }

    public IntegrationType getIntegrationType() {
        return integrationType;
    }

    public void setIntegrationType(IntegrationType integrationType) {
        this.integrationType = integrationType;
    }

}
