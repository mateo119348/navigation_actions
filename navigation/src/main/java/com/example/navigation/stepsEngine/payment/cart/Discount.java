package com.example.navigation.stepsEngine.payment.cart;

import java.math.BigDecimal;

public class Discount {

    private BigDecimal value = BigDecimal.ZERO;
    private String type = PERCENTAGE;
    private BigDecimal discountedAmount = BigDecimal.ZERO;

    public static final String PERCENTAGE = "percentage";
    public static final String AMOUNT = "amount";

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getDiscountedAmount() {
        return discountedAmount;
    }

    public void setDiscountedAmount(BigDecimal discountedAmount) {
        this.discountedAmount = discountedAmount;
    }

}
