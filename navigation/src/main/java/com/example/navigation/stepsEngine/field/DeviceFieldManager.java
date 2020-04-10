package com.example.navigation.stepsEngine.field;

import com.example.navigation.stepsEngine.payment.PointPayment;
import com.example.navigation.stepsEngine.payment.device.Device;

public class DeviceFieldManager extends FieldManager {

    @Override
    public Device get(PointPayment pointPayment) {
        return pointPayment.getPos().getDevice();
    }

}
