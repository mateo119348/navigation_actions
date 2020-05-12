package com.example.pruebaconceptonavigationmanager.posSelector;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.navigation.stepsEngine.flow.rules.base.Rule;
import com.example.navigation.stepsEngine.payment.FlowState;
import com.example.pruebaconceptonavigationmanager.R;
import com.example.navigation.action.Action;
import com.example.navigation.action.Field;

import java.util.List;

public class PosSelectorActivity extends AppCompatActivity implements Action {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pos_selector);
    }


    @Override
    public void execute(List<Field> newFields) {

    }

    @Override
    public String getName() {
        return "POS_SELECTOR";
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
    public void backStepState(List<Field> fields, FlowState paymentFlowState) {

    }
}
