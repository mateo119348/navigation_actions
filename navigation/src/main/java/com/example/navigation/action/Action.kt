package com.example.navigation.action


import com.example.navigation.stepsEngine.field.Field
import com.example.navigation.stepsEngine.field.FieldId
import com.example.navigation.stepsEngine.flow.rules.actionValidation.ActionValidation


interface Action {

    val name: ActionId
    val fields: List<Field>?
    fun setField(fieldId: FieldId, value: Any?)
    fun getField(fieldId: FieldId): Field

    /**
     * Debe ser llamado cuando no se esta cumpliendo una @ActionValidation
     * Cada implementacion debe conocer las rules que maneja y resolver que hacer (hacer una accion, mostrar error, etc)
     * @param unfulfilledRule ActionValidation que no se está cumpliendo
     */
    fun resolveUnfulfilledRule(unfulfilledRule: ActionValidation)


    fun execute()
}