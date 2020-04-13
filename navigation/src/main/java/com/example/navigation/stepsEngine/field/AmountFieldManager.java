package com.example.navigation.stepsEngine.field;

import com.example.navigation.stepsEngine.payment.PointPayment;

import java.math.BigDecimal;

public class AmountFieldManager extends FieldManager {

    @Override
    public BigDecimal get(PointPayment pointPayment) {
        return pointPayment.getAmount();
    }

    @Override
    public String getFieldName() {
        return null;
    }

}
