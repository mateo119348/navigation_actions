package com.example.navigation.stepsEngine.configuration;

import com.example.navigation.stepsEngine.enums.Acquirer;
import com.example.navigation.stepsEngine.enums.PaymentMethodId;

import java.util.List;

public class PaymentMethodsByAcquirer {

    private PaymentMethodId paymentMethodId;
    private List<Acquirer> acquirers;

    public PaymentMethodId getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(PaymentMethodId paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public List<Acquirer> getAcquirers() {
        return acquirers;
    }

    public void setAcquirers(List<Acquirer> acquirers) {
        this.acquirers = acquirers;
    }

}
