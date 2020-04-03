package com.example.pruebaconceptonavigationmanager.calculator.navigation.destinations;

import com.example.navigation.NavigationDestination;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = GoToInstallments.class, name = CalculatorNavDest.INSTALLMENTS),
        @JsonSubTypes.Type(value = GoToPaymentDescription.class, name = CalculatorNavDest.PAYMENT_DESCRIPTION),
        @JsonSubTypes.Type(value = GoToPaymentMethods.class, name = CalculatorNavDest.PAYMENT_METHODS)})

public class CalculatorNavDest {
    public static final String INSTALLMENTS = "INSTALLMENTS";
    public static final String PAYMENT_METHODS = "PAYMENT_METHODS";
    public static final String PAYMENT_DESCRIPTION = "PAYMENT_DESCRIPTION";
}
