package com.example.pruebaconceptonavigationmanager.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.navigation.stepsEngine.payment.PointPayment;
import com.example.navigation.action.Action;
import com.example.navigation.action.Field;
import com.example.navigation.stepsEngine.flow.rules.base.Rule;
import com.example.pruebaconceptonavigationmanager.R;

import java.util.List;

public class CalculatorActivity extends AppCompatActivity implements Action {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void execute(Object... params) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public List<Field> getFields() {
        return null;
    }

    @Override
    public void resolveUnfullfiledRule(Rule unfulfilledRule) {

    }

    @Override
    public void setField(String idField, Object value) {

    }

    @Override
    public void backStepState(List<Field> fields, PointPayment paymentFlowState) {

    }
}
