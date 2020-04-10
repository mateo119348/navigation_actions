package com.example.navigation.stepsEngine.payment;

import com.example.navigation.stepsEngine.enums.PaymentMethodId;

import java.util.List;

public class PaymentMethodWrapper {

    private PaymentMethodId paymentMethodId;
    private List<PaymentMethod> paymentMethods;
    //TODO: Verificar si en colombia se pide el issuer...
    private Long issuerId;

    public PaymentMethodId getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(PaymentMethodId paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public List<PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(List<PaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public Long getIssuerId() {
        return issuerId;
    }

    public void setIssuerId(Long issuerId) {
        this.issuerId = issuerId;
    }

}
