package com.example.pruebaconceptonavigationmanager.actions;

import android.content.Context;

import com.example.navigation.action.Action;
import com.example.navigation.action.ActionMapper;
import com.example.navigation.action.Field;
import com.example.navigation.action.RuleAction;
import com.example.pruebaconceptonavigationmanager.calculator.CalculatorActivity;
import com.example.pruebaconceptonavigationmanager.chooser.ChooserActivity;
import com.example.pruebaconceptonavigationmanager.description.DescriptionActivity;
import com.example.pruebaconceptonavigationmanager.installments.InstallmentsActivity;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.List;

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


    /**
     * Inicia una instancia de Action a partir de un deep link
     * @param action nodo que representa un action del json
     * @param params
     */
    @Override
    public void executeAction(RuleAction action, Object... params) {

        String name = action.getName();

        String deepLink = getDeepLink(name);

        initAction(deepLink, params);

    }
    /**
     * Sobre una Action ya activa, ejecuta en base a nuevos fields requeridos por otro step
     * @param action  Action activa (pantalla)
     * @param params
     */
    @Override
    public void executeNextField(Action action, Object... params) {

        String actionName = action.getName();

        action.execute((List<Field>)params[0]);


    }

    private String getDeepLink(String actionName){
        //TODO: Buscar el deep link asociado
        return "";
    }

    private void initAction(String deepLink, Object...params){
       //TODO: intsanciar con deep link
    }


}
