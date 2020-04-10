package com.example.navigation.stepsEngine.field;

import com.example.navigation.stepsEngine.payment.PointPayment;

public class InstallmentsFieldManager extends FieldManager {

    @Override
    public Integer get(PointPayment pointPayment) {
        return pointPayment.getInstallments();
    }

}
