package com.example.navigation.stepsEngine.field;

import com.example.navigation.stepsEngine.enums.Type;
import com.example.navigation.stepsEngine.payment.FlowState;

public class CardTypeField extends FlowStateField {

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
    public String getFieldName() {
        return null;
    }

}
