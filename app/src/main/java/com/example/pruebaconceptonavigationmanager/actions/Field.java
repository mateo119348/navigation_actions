package com.example.pruebaconceptonavigationmanager.actions;

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
