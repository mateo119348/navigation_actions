package com.example.pruebaconceptonavigationmanager.flow

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.example.navigation.action.Action
import com.example.navigation.action.BUNDLE_ACTION_WRAPPER
import com.example.navigation.mappers.ActionMapper
import com.example.navigation.action.RuleAction
import com.example.navigation.stepsEngine.field.Field
import com.example.navigation.mappers.FieldMapper
import com.example.pruebaconceptonavigationmanager.flow.ActionIdImpl.CALCULATOR
import com.example.pruebaconceptonavigationmanager.flow.ActionIdImpl.CHOOSER
import com.example.pruebaconceptonavigationmanager.flow.ActionIdImpl.DESCRIPTION
import com.example.pruebaconceptonavigationmanager.flow.ActionIdImpl.INSTALLMENTS
import com.example.pruebaconceptonavigationmanager.flow.ActionIdImpl.POS_SELECTOR


class ActionMapperImpl(private var context: Context, private var fieldMapper: FieldMapper) : ActionMapper {

    private val INTERNAL = "INTERNAL"

    /**
     * Inicia una instancia de Action a partir de un deep link
     * @param action nodo que representa un action del json
     * @param params
     */
    override fun startAction(action: RuleAction) {
        initAction(getActionWrapper(action))
    }

    /**
     * Sobre una Action ya activa, ejecuta en base a nuevos fields requeridos por otro step
     * @param action  Action activa (pantalla)
     * @param params
     */
    override fun executeNextField(action: Action, fields: List<Field>?) {
        action.executeFields(fields)
    }


    private fun initAction(actionWrapper: ActionWrapper) {
        val uri = Uri.parse(actionWrapper.deepLink)
        val intent = Intent(Intent.ACTION_VIEW).setPackage(context.packageName).putExtra(INTERNAL, true)
        intent.data = uri
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        intent.putExtra(BUNDLE_ACTION_WRAPPER, actionWrapper)
        context.startActivity(intent)
    }

    private fun getActionWrapper(ruleAction: RuleAction): ActionWrapper {
        return when (ruleAction.id) {
            CALCULATOR.name -> ActionWrapper(CALCULATOR, CALCULATOR.deepLink, ruleAction.fields, fieldMapper)
            CHOOSER.name -> ActionWrapper(CHOOSER, CHOOSER.deepLink, ruleAction.fields, fieldMapper)
            POS_SELECTOR.name -> ActionWrapper(POS_SELECTOR, POS_SELECTOR.deepLink, ruleAction.fields, fieldMapper)
            INSTALLMENTS.name -> ActionWrapper(INSTALLMENTS, INSTALLMENTS.deepLink, ruleAction.fields, fieldMapper)
            DESCRIPTION.name -> ActionWrapper(DESCRIPTION, DESCRIPTION.deepLink, ruleAction.fields, fieldMapper)
            else ->
                throw IllegalStateException("Check your actions: doesn't exist the key in mapping ${ruleAction.id}")
        }
    }


}