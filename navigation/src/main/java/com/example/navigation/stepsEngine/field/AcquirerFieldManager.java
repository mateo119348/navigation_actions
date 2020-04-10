package com.example.navigation.stepsEngine.field;

import com.example.navigation.stepsEngine.enums.Acquirer;
import com.example.navigation.stepsEngine.payment.PointPayment;

public class AcquirerFieldManager extends FieldManager {

    @Override
    public String get(PointPayment pointPayment) {
        final Acquirer acquirer = pointPayment.getAcquirer();
        if (acquirer == null) {
            return null;
        } else {
            return acquirer.name();
        }
    }

}
