package com.example.navigation.action


import com.example.navigation.stepsEngine.field.Field
import com.example.navigation.stepsEngine.field.FieldId
import com.example.navigation.stepsEngine.flow.rules.actionValidation.ActionValidation

//TODO: poner en otro lado
const val BUNDLE_ACTION_WRAPPER = "action_wrapper"

interface Action {

    val name: ActionId
    val fields: ArrayList<Field>?
    fun setField(idField: FieldId, value: Any?)
    fun getField(idField: FieldId): Field

    /**
     * Executa un determinado fluje dependiendo de los campos que le son solicitados,
     * ya que la misma accion puede servir a mas de un step
     * @param newFields
     */
    fun executeFields(newFields: List<Field>?)

    /**
     * Debe ser llamado cuando no se esta cumpliendo una @ActionValidation
     * Cada implementacion debe conocer las rules que maneja y resolver que hacer (hacer una accion, mostrar error, etc)
     * @param unfulfilledRule ActionValidation que no se está cumpliendo
     */
    fun resolveUnfullfiledRule(unfulfilledRule: ActionValidation)

    /**
     * Al hacer back sobre una pantalla, aqui se deben resetear los campos afectados en esta action
     */
    fun backStepState()
}