package com.example.navigation;


import com.example.navigation.steps.field.Field;
import com.example.navigation.steps.flow.rules.base.Rule;

import java.util.Map;

public interface UnfullfiledRuleListener {
     Map<String, Field> getFields();
     void resolveUnfullfiledRule(Rule unfulfilledRule);
}
