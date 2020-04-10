package com.example.pruebaconceptonavigationmanager.calculator;

import android.content.Context;

public class CalculatorModel  {

    PaymentFlowState paymentFlowState;
    Context context;

    public CalculatorModel(PaymentFlowState paymentFlowState, Context context) {
        this.paymentFlowState = paymentFlowState;
        this.context = context;
    }


}
