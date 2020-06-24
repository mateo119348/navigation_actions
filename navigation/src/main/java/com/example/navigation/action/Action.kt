package com.example.navigation.action

import com.example.navigation.stepsEngine.field.Field
import com.example.navigation.stepsEngine.flow.rules.actionValidation.ActionValidation
import com.example.navigation.stepsEngine.payment.FlowState

interface Action {
    val name: String
    var fields: ArrayList<Field>
    fun setFields(idField: String, value: Any?)

    /**
     * Executa un determinado fluje dependiendo de los campos que le son solicitados,
     * ya que la misma accion puede servir a mas de un step
     * @param newFields
     */
    fun execute(newFields: List<Field>)

    /**
     * Debe ser llamado cuando no se esta cumpliendo una rule
     * Cada implementacion debe conocer las rules que maneja y resolver que hacer (hacer una accion, mostrar error, etc)
     * @param unfulfilledRule
     */
    fun resolveUnfullfiledRule(unfulfilledRule: ActionValidation)

    /**
     * AL hacer back sobre una pantalla, aqui se deben resetear los campos afectados en esta action
     * @param fields
     * @param paymentFlowState
     */
    fun backStepState(fields: List<Field>, paymentFlowState: FlowState)
}