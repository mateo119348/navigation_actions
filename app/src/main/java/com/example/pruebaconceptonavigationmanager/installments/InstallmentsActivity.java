package com.example.pruebaconceptonavigationmanager.installments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import com.example.navigation.stepsEngine.payment.PointPayment;
import com.example.pruebaconceptonavigationmanager.actions.Action;
import com.example.pruebaconceptonavigationmanager.actions.Field;
import com.example.navigation.stepsEngine.flow.rules.base.Rule;
import com.example.pruebaconceptonavigationmanager.R;
import com.example.pruebaconceptonavigationmanager.calculator.Actions.AmountField;
import com.example.pruebaconceptonavigationmanager.calculator.Actions.DescriptionField;

import java.util.ArrayList;
import java.util.List;

public class InstallmentsActivity extends AppCompatActivity implements Action {


    List<Field> fields;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_installments);
    }

    @Override
    public void execute(Context context, Object... params) {

    }

    @Override
    public String getName() {
        return "CALCULATOR";
    }

    @Override
    public List<Field> getFields() {
        if (fields == null) {
            fields = new ArrayList<>();

            fields.add(new AmountField());
            fields.add(new DescriptionField());
        }
        return fields;
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
