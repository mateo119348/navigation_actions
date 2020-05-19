package com.example.navigation.stepsEngine.field;

import com.example.navigation.stepsEngine.enums.Tag;
import com.example.navigation.stepsEngine.payment.FlowState;

public class CardTagField extends Field {

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
    public String getId() {
        return null;
    }

    @Override
    public void set(FlowState flowState, Object value) {

    }

}
