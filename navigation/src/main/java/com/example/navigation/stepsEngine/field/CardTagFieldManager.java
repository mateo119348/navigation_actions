package com.example.navigation.stepsEngine.field;

import com.example.navigation.stepsEngine.enums.Tag;
import com.example.navigation.stepsEngine.payment.PointPayment;

public class CardTagFieldManager extends FieldManager {

    @Override
    public String get(PointPayment pointPayment) {
        final Tag tag = pointPayment.getCard().getTag();
        if (tag == null) {
            return null;
        } else {
            return tag.name();
        }
    }

}
