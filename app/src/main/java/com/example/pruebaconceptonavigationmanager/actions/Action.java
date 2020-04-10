package com.example.pruebaconceptonavigationmanager.actions;

import android.content.Context;

import com.example.navigation.stepsEngine.flow.rules.base.Rule;
import com.example.pruebaconceptonavigationmanager.calculator.CalculatorActivity;
import com.example.pruebaconceptonavigationmanager.chooser.ChooserActivity;
import com.example.pruebaconceptonavigationmanager.description.DescriptionActivity;
import com.example.pruebaconceptonavigationmanager.installments.InstallmentsActivity;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.List;
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "name")
@JsonSubTypes({
        @JsonSubTypes.Type(value = CalculatorActivity.class, name = "CALCULATOR"),
        @JsonSubTypes.Type(value = DescriptionActivity.class, name = "CALCULATOR"),
        @JsonSubTypes.Type(value = ChooserActivity.class, name = "CHOOSER"),
        @JsonSubTypes.Type(value = InstallmentsActivity.class, name = "INSTALLMENTS")})
public interface Action {
    void execute(Context context, Object...params);
    String getName();
    List<Field> getFields();
    void resolveUnfullfiledRule(Rule unfulfilledRule);
    void setField (String idField, Object value);
}
