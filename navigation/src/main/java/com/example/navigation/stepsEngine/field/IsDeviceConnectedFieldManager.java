package com.example.navigation.stepsEngine.field;

import com.example.navigation.stepsEngine.payment.PointPayment;

public class IsDeviceConnectedFieldManager extends FieldManager {

    @Override
    public Boolean get(PointPayment pointPayment) {
        return pointPayment.getPos().isConnected();
    }

}
