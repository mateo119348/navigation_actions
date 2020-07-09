package com.example.navigation;


import com.example.navigation.flowEngine.steps.field.Field;
import com.example.navigation.flowEngine.steps.rules.base.Rule;

import java.util.Map;

public interface UnfullfiledRuleListener {
     Map<String, Field> getFields();
     void resolveUnfullfiledRule(Rule unfulfilledRule);
}
