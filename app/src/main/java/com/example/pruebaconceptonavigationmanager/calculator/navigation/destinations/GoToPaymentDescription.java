package com.example.pruebaconceptonavigationmanager.calculator.navigation.destinations;

import android.content.Context;
import android.content.Intent;

import com.example.navigation.NavigationDestination;
import com.example.pruebaconceptonavigationmanager.description.DescriptionActivity;

public class GoToPaymentDescription extends NavigationDestination {
    @Override
    public Intent getDestination(Context context, Object... params) {
        return new Intent(context, DescriptionActivity.class);
    }
}
