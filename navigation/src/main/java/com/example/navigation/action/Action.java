package com.example.navigation.action;

import com.example.navigation.stepsEngine.flow.rules.base.Rule;
import com.example.navigation.stepsEngine.payment.PointPayment;

import java.util.List;

public interface Action {


    String getName();
    List<Field> getFields();
    void setField (String idField, Object value);


    /**
     * Executa un determinado fluje dependiendo de los campos que le son solicitados,
     * ya que la misma accion puede servir a mas de un step
     * @param newFields
     */
    void execute(List<Field> newFields);
    /**
     * Debe ser llamado cuando no se esta cumpliendo una rule
     * Cada implementacion debe conocer las rules que maneja y resolver que hacer (hacer una accion, mostrar error, etc)
     * @param unfulfilledRule
     */
    void resolveUnfullfiledRule(Rule unfulfilledRule);
    /**
     * AL hacer back sobre una pantalla, aqui se deben resetear los campos afectados en esta action
     * @param fields
     * @param paymentFlowState
     */
    void backStepState(List<Field> fields, PointPayment paymentFlowState);
}
