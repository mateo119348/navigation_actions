package com.example.pruebaconceptonavigationmanager.calculator;

import android.content.Context;
import android.content.Intent;

import com.example.navigation.Navigable;
import com.example.navigation.NavigationDestination;
import com.example.navigation.NavigationValidation;
import com.example.navigation.PaymentFlowState;
import com.example.pruebaconceptonavigationmanager.calculator.navigation.validations.CheckAmountValidation;
import com.example.pruebaconceptonavigationmanager.calculator.navigation.validations.CalculatorNavVal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculatorModel  {

    PaymentFlowState paymentFlowState;
    Context context;

    public CalculatorModel(PaymentFlowState paymentFlowState, Context context) {
        this.paymentFlowState = paymentFlowState;
        this.context = context;
    }


}
