package com.example.pruebaconceptonavigationmanager.calculator;

import android.content.Context;

import com.example.navigation.stepsEngine.payment.FlowState;

public class CalculatorModel  {

    FlowState paymentFlowState;
    Context context;

    public CalculatorModel(FlowState paymentFlowState, Context context) {
        this.paymentFlowState = paymentFlowState;
        this.context = context;
    }


}
