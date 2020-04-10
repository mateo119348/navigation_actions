package com.example.navigation.stepsEngine.field;

import com.example.navigation.stepsEngine.payment.PointPayment;

public class DeviceTypeFieldManager extends FieldManager {

    @Override
    public String get(PointPayment pointPayment) {
        return pointPayment.getPos().getDevice().getType().name();
    }

}
