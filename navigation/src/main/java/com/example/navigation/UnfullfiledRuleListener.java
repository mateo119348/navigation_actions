package com.example.navigation;

import com.example.navigation.action.Action;
import com.example.navigation.action.Field;
import com.example.navigation.stepsEngine.flow.rules.base.Rule;

import java.util.Map;

public interface UnfullfiledRuleListener {
     Map<String, Field> getFields();
     void resolveUnfullfiledRule(Rule unfulfilledRule);
}
