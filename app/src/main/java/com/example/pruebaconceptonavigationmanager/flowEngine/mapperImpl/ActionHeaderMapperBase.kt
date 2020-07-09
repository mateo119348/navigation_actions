package com.example.pruebaconceptonavigationmanager.flowEngine.mapperImpl
import com.example.navigation.action.RuleAction
import com.example.navigation.mappers.FieldMapper
import com.example.navigation.stepsEngine.field.Field
import com.example.pruebaconceptonavigationmanager.flowEngine.ActionHeader
import com.example.pruebaconceptonavigationmanager.flowEngine.mapperImpl.ActionIdBase.CALCULATOR
import com.example.pruebaconceptonavigationmanager.flowEngine.mapperImpl.ActionIdBase.CHOOSER
import com.example.pruebaconceptonavigationmanager.flowEngine.mapperImpl.ActionIdBase.DESCRIPTION
import com.example.pruebaconceptonavigationmanager.flowEngine.mapperImpl.ActionIdBase.INSTALLMENTS
import com.example.pruebaconceptonavigationmanager.flowEngine.mapperImpl.ActionIdBase.POS_SELECTOR

class ActionHeaderMapperBase {

    fun getActionHeader(ruleAction: RuleAction, fieldMapper: FieldMapper): ActionHeader {

        val fields = fieldMapper.getFields(ruleAction.fields)

        var action = when (ruleAction.id) {
            CALCULATOR.name -> CALCULATOR
            CHOOSER.name -> CHOOSER
            POS_SELECTOR.name -> POS_SELECTOR
            INSTALLMENTS.name -> INSTALLMENTS
            DESCRIPTION.name -> DESCRIPTION
            else ->
                throw IllegalStateException("Check your actions: doesn't exist the key in mapping ${ruleAction.id}")
        }

        return ActionHeader(action, fields, action.deepLink)
    }
}