package com.example.navigation.stepsEngine.field;

import com.example.navigation.stepsEngine.payment.PointPayment;

public class PaymentStatusFieldManager extends FieldManager {

    @Override
    public String get(PointPayment pointPayment) {
        return pointPayment.getPaymentStatus().toUpperCase();
    }

}
