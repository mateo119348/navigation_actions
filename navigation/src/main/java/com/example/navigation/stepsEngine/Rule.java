package com.example.navigation.stepsEngine;

import com.example.navigation.PaymentFlowState;

public abstract class Rule {

    public abstract String getRuleException();
    public abstract boolean evaluate(final PaymentFlowState pointPayment);
}
