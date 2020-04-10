package com.example.pruebaconceptonavigationmanager.chooser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import com.example.pruebaconceptonavigationmanager.actions.Action;
import com.example.pruebaconceptonavigationmanager.actions.Field;
import com.example.navigation.stepsEngine.flow.rules.base.Rule;
import com.example.pruebaconceptonavigationmanager.R;

import java.util.List;

public class ChooserActivity extends AppCompatActivity implements Action {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooser);
    }

    @Override
    public void execute(Context context, Object... params) {

    }

    @Override
    public String getName() {
        return "CARD_TYPE";
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
}
