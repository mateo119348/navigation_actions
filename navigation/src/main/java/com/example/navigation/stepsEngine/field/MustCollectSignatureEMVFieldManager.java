package com.example.navigation.stepsEngine.field;

import com.example.navigation.stepsEngine.payment.PointPayment;

public class MustCollectSignatureEMVFieldManager extends FieldManager {

    @Override
    public Boolean get(PointPayment pointPayment) {
        return pointPayment.getCard().isMustCollectSignatureEMV();
    }

}
