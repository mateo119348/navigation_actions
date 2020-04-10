package com.example.navigation.stepsEngine.flow.rules.comparable;

import com.example.navigation.stepsEngine.field.FieldManager;
import com.example.navigation.stepsEngine.flow.rules.base.Rule;

public abstract class ComparableRule extends Rule {

    private FieldManager fieldManager;

    public FieldManager getFieldManager() {
        return fieldManager;
    }

    public void setFieldManager(FieldManager fieldManager) {
        this.fieldManager = fieldManager;
    }

    @Override
    public String getFieldName() {
        return getFieldManager().getFieldName();
    }

}
