package com.example.navigation.action


import com.example.navigation.stepsEngine.field.Field
import com.example.navigation.stepsEngine.field.FieldId
import com.example.navigation.stepsEngine.flow.rules.actionValidation.ActionValidation

//TODO: poner en otro lado
const val BUNDLE_ACTION_HEADER = "action_header"

interface Action {

    val name: ActionId
    val fields: List<Field>?
    fun setField(idField: FieldId, value: Any?)
    fun getField(idField: FieldId): Field

    /**
     * Debe ser llamado cuando no se esta cumpliendo una @ActionValidation
     * Cada implementacion debe conocer las rules que maneja y resolver que hacer (hacer una accion, mostrar error, etc)
     * @param unfulfilledRule ActionValidation que no se está cumpliendo
     */
    fun resolveUnfulfilledRule(unfulfilledRule: ActionValidation)


    fun execute()
}