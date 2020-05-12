package com.example.navigation.stepsEngine.field;

import com.example.navigation.stepsEngine.payment.FlowState;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.math.BigDecimal;

@JsonTypeName("AMOUNT")
public class AmountField extends FlowStateField {

    @Override
    public BigDecimal get(FlowState flowState) {
        return flowState.getAmount();
    }

    @Override
    public String getFieldName() {
        return null;
    }

}
