package com.example.navigation.stepsEngine.flow.rules.comparable;


import com.example.navigation.stepsEngine.field.FlowStateField;
import com.example.navigation.stepsEngine.flow.rules.base.Rule;

import java.lang.reflect.Type;

public abstract class ComparableRule extends Rule {

//    private FieldManager fieldManager;
//
//    public FieldManager getFieldManager() {
//        return fieldManager;
//    }
//
//    public void setFieldManager(FieldManager fieldManager) {
//        this.fieldManager = fieldManager;
//    }


    FlowStateField field;
    String value;
    String valueType;

    public boolean isNot() {
        return not;
    }

    boolean not;


    public String getFieldName() {
        return field.getFieldName();
    }

    public String getValue() {
        return value;
    }

    public String getValueType() {
        return valueType;
    }

    public FlowStateField getField(){
        return field;
    }


    public Type getRuleClass(){
        if (getValueType().equals("bool"))
            return Boolean.class;
        else if (getValueType().equals("string"))
             return String.class;
        else if (getValueType().equals("decimal"))
            return Double.class;
        else if (getValueType().equals("int"))
            return Integer.class;
        else
            throw new IllegalStateException(String.format("Error in value_type. Check your json!!!"));
    }


}
