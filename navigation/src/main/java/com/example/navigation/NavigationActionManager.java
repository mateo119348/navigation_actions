package com.example.navigation;

import com.example.navigation.action.Attr;
import com.example.navigation.stepsEngine.Rule;

import java.util.List;

public abstract class NavigationActionManager {


    public abstract String resolveAction(Rule rule, List<Attr> attributes);
}
