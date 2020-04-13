package com.example.pruebaconceptonavigationmanager.actions;

import android.content.Context;

import com.example.navigation.action.Action;
import com.example.navigation.action.ActionMapper;
import com.example.pruebaconceptonavigationmanager.calculator.CalculatorActivity;
import com.example.pruebaconceptonavigationmanager.chooser.ChooserActivity;
import com.example.pruebaconceptonavigationmanager.description.DescriptionActivity;
import com.example.pruebaconceptonavigationmanager.installments.InstallmentsActivity;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "name")
//@JsonSubTypes({
//        @JsonSubTypes.Type(value = CalculatorActivity.class, name = "CALCULATOR"),
//        @JsonSubTypes.Type(value = DescriptionActivity.class, name = "CALCULATOR"),
//        @JsonSubTypes.Type(value = ChooserActivity.class, name = "CHOOSER"),
//        @JsonSubTypes.Type(value = InstallmentsActivity.class, name = "INSTALLMENTS")})
public class ActionMapperImpl implements ActionMapper {

    Context context;

    public ActionMapperImpl(Context context) {
        this.context = context;
    }

    private void initActionMapper(){
        //TODO: cargar mapper con json
    }


    @Override
    public void executeAction(Action action, Object... params) {

        String actionName = action.getName();


    }


}
