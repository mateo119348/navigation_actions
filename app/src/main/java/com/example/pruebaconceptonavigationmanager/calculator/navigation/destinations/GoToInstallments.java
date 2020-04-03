package com.example.pruebaconceptonavigationmanager.calculator.navigation.destinations;

import android.content.Context;
import android.content.Intent;

import com.example.navigation.NavigationDestination;
import com.example.pruebaconceptonavigationmanager.installments.InstallmentsActivity;

public class GoToInstallments extends NavigationDestination {

    @Override
    public Intent getDestination(Context context, Object... params) {
        return new Intent(context, InstallmentsActivity.class);
    }


}
