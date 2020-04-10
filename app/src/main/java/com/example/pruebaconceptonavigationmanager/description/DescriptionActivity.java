package com.example.pruebaconceptonavigationmanager.description;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import com.example.navigation.stepsEngine.flow.rules.base.Rule;
import com.example.navigation.stepsEngine.payment.PointPayment;
import com.example.pruebaconceptonavigationmanager.R;
import com.example.pruebaconceptonavigationmanager.actions.Action;
import com.example.pruebaconceptonavigationmanager.actions.Field;

import java.util.List;

public class DescriptionActivity extends AppCompatActivity implements Action {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_description);
    }

    @Override
    public void execute(Context context, Object... params) {

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
