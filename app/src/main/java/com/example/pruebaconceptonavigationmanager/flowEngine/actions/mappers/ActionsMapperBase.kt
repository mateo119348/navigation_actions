package com.example.pruebaconceptonavigationmanager.flowEngine.actions.mappers

import com.example.navigation.action.RuleAction
import com.example.navigation.mappers.FieldMapper
import com.example.pruebaconceptonavigationmanager.activities.calculator.CalculatorActivity
import com.example.pruebaconceptonavigationmanager.activities.chooser.ChooserActivity
import com.example.pruebaconceptonavigationmanager.activities.description.DescriptionActivity
import com.example.pruebaconceptonavigationmanager.activities.installments.InstallmentsActivity
import com.example.pruebaconceptonavigationmanager.activities.posSelector.PosSelectorActivity
import com.example.pruebaconceptonavigationmanager.flowEngine.actions.ActionWrapper
import com.example.pruebaconceptonavigationmanager.flowEngine.actions.Actions.CALCULATOR
import com.example.pruebaconceptonavigationmanager.flowEngine.actions.Actions.CHOOSER
import com.example.pruebaconceptonavigationmanager.flowEngine.actions.Actions.DESCRIPTION
import com.example.pruebaconceptonavigationmanager.flowEngine.actions.Actions.INSTALLMENTS
import com.example.pruebaconceptonavigationmanager.flowEngine.actions.Actions.POS_SELECTOR

class ActionsMapperBase {

    fun getActionWrapper(ruleAction: RuleAction, fieldMapper: FieldMapper): ActionWrapper {

        val fields = fieldMapper.getFields(ruleAction.fields)

        return when (ruleAction.id) {
            CALCULATOR.name -> ActionWrapper(CALCULATOR, fields, CalculatorActivity::class.java)
            CHOOSER.name -> ActionWrapper(CHOOSER, fields, ChooserActivity::class.java)
            POS_SELECTOR.name -> ActionWrapper(POS_SELECTOR, fields, PosSelectorActivity::class.java)
            INSTALLMENTS.name -> ActionWrapper(INSTALLMENTS, fields, InstallmentsActivity::class.java)
            DESCRIPTION.name -> ActionWrapper(DESCRIPTION, fields, DescriptionActivity::class.java)
            else ->
                throw IllegalStateException("Check your actions: doesn't exist the key in mapping ${ruleAction.id}")
        }
    }
}