package com.example.navigation.action;

public abstract class Field {

    Object value;

    public abstract String getName();

    public Object getValue() {
        return value;
    }

    public void setValue(Object value){
        this.value = value;
    }
}
