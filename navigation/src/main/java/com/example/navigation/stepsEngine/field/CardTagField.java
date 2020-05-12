package com.example.navigation.stepsEngine.field;

import com.example.navigation.stepsEngine.enums.Tag;
import com.example.navigation.stepsEngine.payment.FlowState;

public class CardTagField extends FlowStateField {

    @Override
    public String get(FlowState flowState) {
        final Tag tag = flowState.getCard().getTag();
        if (tag == null) {
            return null;
        } else {
            return tag.name();
        }
    }

    @Override
    public String getFieldName() {
        return null;
    }

}
