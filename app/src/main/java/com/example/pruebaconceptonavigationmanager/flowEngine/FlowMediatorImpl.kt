package com.example.pruebaconceptonavigationmanager.flowEngine

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.net.Uri
import com.example.navigation.flowEngine.actions.Action
import com.example.navigation.flowEngine.FlowMediator
import com.example.navigation.flowEngine.actions.RuleAction
import com.example.navigation.flowEngine.steps.field.FieldMapper
import com.example.pruebaconceptonavigationmanager.flowEngine.actions.ActionWrapper
import com.example.pruebaconceptonavigationmanager.flowEngine.actions.mappers.ActionsMapperBase


class FlowMediatorImpl(private var context: Context,
    private val fieldMapper: FieldMapper,
    private val actionsMapperBase: ActionsMapperBase) : FlowMediator {

    private val INTERNAL = "INTERNAL"

    private var actions = ArrayList<Action>()

    /**
     * Inicia una instancia de Action a partir de un deep link
     * @param action nodo que representa un action del json
     */
    override fun executeAction(action: RuleAction) {
        val actionWrapper = actionsMapperBase.getActionWrapper(action, fieldMapper)

        actionWrapper.let {
            if (it.deepLink != null || it.activityClass != null) {
                executeActivityAction(it)
            } else {
                executeAction(it)
            }
        }

    }

    override fun addAction(action: Action) {
        actions.add(action)
    }

    override fun getAction(action: RuleAction?): Action? {
        return actions.firstOrNull() { it.name.id() == action?.id }
    }


    private fun executeAction(actionWrapper: ActionWrapper) {
        val action = actions.firstOrNull { it.name == actionWrapper.actionId }
        action?.execute() ?: run {
            throw IllegalStateException("Check your actions: the action ${actionWrapper.actionId.id()} " +
                "is not in the current context")
        }
    }

    private fun executeActivityAction(actionWrapper: ActionWrapper) {
        actionWrapper.let {
            actions.clear()
            val intent = Intent(Intent.ACTION_VIEW).setPackage(context.packageName).putExtra(INTERNAL, true)

            if (it.activityClass != null) {
                intent.component = ComponentName(context, it.activityClass)
            } else {
                intent.data = Uri.parse(it.deepLink)
            }

            intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            intent.putExtra(BUNDLE_ACTION_WRAPPER, it)
            context.startActivity(intent)
        }
    }

    override fun clone(): FlowMediator {
        val copy = FlowMediatorImpl(context, fieldMapper, actionsMapperBase)
        copy.actions = actions

        return copy
    }

    //TODO: ver de mover a otro lado
    companion object {
        const val BUNDLE_ACTION_WRAPPER = "action_wrapper"
    }


}