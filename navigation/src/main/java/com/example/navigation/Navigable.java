package com.example.navigation;

import com.example.navigation.action.Field;

import java.util.List;

public abstract class Navigable {

    public abstract String getNavigationId();
    public abstract List<String> getStepIdentifiers();
    public abstract int getSequence();
    public abstract List<Field> getAttrinutesValues();
    public abstract List<NavigationValidation> getValidations();
    public abstract List<NavigationDestination> getNavigationDestinations();

}
