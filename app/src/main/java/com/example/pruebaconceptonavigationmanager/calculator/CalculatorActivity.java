package com.example.pruebaconceptonavigationmanager.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.navigation.action.ActionMapper;
import com.example.navigation.action.FlowManager;
import com.example.navigation.action.RuleAction;
import com.example.navigation.stepsEngine.flow.Flow;
import com.example.navigation.stepsEngine.payment.FlowState;
import com.example.navigation.action.Action;
import com.example.navigation.stepsEngine.flow.rules.base.Rule;
import com.example.pruebaconceptonavigationmanager.R;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import com.fasterxml.jackson.core.type.TypeReference;

import java.io.InputStream;
import java.util.List;

public class CalculatorActivity extends AppCompatActivity implements Action {

    Flow flow;
    List<RuleAction> actions;
    FlowManager flowManager;
    ActionMapper actionMapper;
    FlowState flowState;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);



    }

    @Override
    public void execute(List<com.example.navigation.action.Field> newFields) {



    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public List<com.example.navigation.action.Field> getFields() {
        return null;
    }

    @Override
    public void resolveUnfullfiledRule(Rule unfulfilledRule) {

    }

    @Override
    public void setField(String idField, Object value) {

    }

    @Override
    public void backStepState(List<com.example.navigation.action.Field> fields, FlowState paymentFlowState) {

    }
}
