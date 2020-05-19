package com.example.navigation.stepsEngine.field;

import com.example.navigation.stepsEngine.enums.Type;
import com.example.navigation.stepsEngine.payment.FlowState;

public class CardTypeField extends Field {

    @Override
    public String get(FlowState flowState) {
        final Type type = flowState.getCard().getType();
        if (type == null) {
            return null;
        } else {
            return type.name();
        }
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public void set(FlowState flowState, Object value) {

    }

}
