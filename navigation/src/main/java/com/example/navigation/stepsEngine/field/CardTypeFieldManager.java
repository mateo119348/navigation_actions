package com.example.navigation.stepsEngine.field;

import com.example.navigation.stepsEngine.enums.Type;
import com.example.navigation.stepsEngine.payment.PointPayment;

public class CardTypeFieldManager extends FieldManager {

    @Override
    public String get(PointPayment pointPayment) {
        final Type type = pointPayment.getCard().getType();
        if (type == null) {
            return null;
        } else {
            return type.name();
        }
    }

}
