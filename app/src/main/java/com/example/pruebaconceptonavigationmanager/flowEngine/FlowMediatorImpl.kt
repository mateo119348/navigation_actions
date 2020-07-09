package com.example.pruebaconceptonavigationmanager.flowEngine

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.example.navigation.action.Action
import com.example.navigation.action.BUNDLE_ACTION_HEADER
import com.example.navigation.action.FlowManager
import com.example.navigation.mappers.FlowMediator
import com.example.navigation.action.RuleAction
import com.example.navigation.mappers.FieldMapper
import com.example.pruebaconceptonavigationmanager.flowEngine.mapperImpl.ActionHeaderMapperBase


class FlowMediatorImpl(private var context: Context, private val fieldMapper: FieldMapper, private val actionHeaderMapperBase: ActionHeaderMapperBase) : FlowMediator {

    private val INTERNAL = "INTERNAL"

    private var actions = ArrayList<Action>()

    /**
     * Inicia una instancia de Action a partir de un deep link
     * @param action nodo que representa un action del json
     * @param params
     */
    override fun startAction(action: RuleAction) {
        initAction(actionHeaderMapperBase.getActionHeader(action, fieldMapper))
    }

    override fun addAction(action: Action) {
        actions.add(action)
    }

    override fun containsAction(action: RuleAction): Boolean {
        return actions.any { it.name.id() == action.id }
    }

    private fun initAction(actionHeader: ActionHeader) {
        if (actionHeader.deepLink != null) {
            actions.clear()
            val intent = Intent(Intent.ACTION_VIEW).setPackage(context.packageName).putExtra(INTERNAL, true)
            intent.data = Uri.parse(actionHeader.deepLink)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            intent.putExtra(BUNDLE_ACTION_HEADER, actionHeader)
            context.startActivity(intent)
        } else {
            val action = actions.firstOrNull { it.name ==  actionHeader.actionId}
            action?. let {
                it.execute()
            } ?: run {
                throw IllegalStateException("Check your actions: the action ${actionHeader.actionId.id()} is not in the current context")
            }
        }

    }

    override fun clone(): FlowMediator {
        var copy = FlowMediatorImpl(context, fieldMapper, actionHeaderMapperBase)
        copy.actions = actions
        return copy
    }




}