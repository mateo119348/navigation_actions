package com.example.navigation.action;

import com.example.navigation.stepsEngine.flow.rules.base.Rule;
import com.example.navigation.stepsEngine.payment.PointPayment;

import java.util.List;

public interface Action {
    String getName();
    List<Field> getFields();
    void resolveUnfullfiledRule(Rule unfulfilledRule);
    void setField (String idField, Object value);
    void backStepState(List<Field> fields, PointPayment paymentFlowState);
}
