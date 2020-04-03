package com.example.pruebaconceptonavigationmanager.calculator.navigation.validations;

import android.content.Context;
import android.content.Intent;

import com.example.navigation.NavigationDestination;
import com.example.navigation.NavigationValidation;
import com.example.navigation.PaymentFlowState;
import com.example.pruebaconceptonavigationmanager.calculator.navigation.destinations.CalculatorNavDest;

import java.util.Map;

public class CheckAmountValidation extends NavigationValidation {

    @Override
    public Intent validate(Context context, Map<String, NavigationDestination> destinations, PaymentFlowState paymentFlowState, Object... params) {

        if (paymentFlowState.getAmount() > 10)
            return destinations.get(CalculatorNavDest.INSTALLMENTS).getDestination(context, params);
        else
            return destinations.get(CalculatorNavDest.PAYMENT_METHODS).getDestination(context, params);
    }
}
