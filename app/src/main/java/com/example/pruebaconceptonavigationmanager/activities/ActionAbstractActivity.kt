package com.example.pruebaconceptonavigationmanager.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.navigation.action.*
import com.example.navigation.stepsEngine.field.Field
import com.example.navigation.stepsEngine.field.FieldId
import com.example.pruebaconceptonavigationmanager.flowEngine.actions.ActionWrapper
import com.example.pruebaconceptonavigationmanager.flowEngine.FlowMediatorImpl.Companion.BUNDLE_ACTION_WRAPPER

abstract class ActionAbstractActivity: AppCompatActivity(), Action {


    override val fields: List<Field>?
        get() = actionWrapper?.fields

    override val name: ActionId
        get() = actionWrapper!!.actionId


    private var actionWrapper: ActionWrapper? = null
        get() {
            field ?: run {
                field = intent.getParcelableExtra(BUNDLE_ACTION_WRAPPER)
            }
            return field
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        actionWrapper = intent.getParcelableExtra(BUNDLE_ACTION_WRAPPER)
        super.onCreate(savedInstanceState)
    }


    override fun setField(fieldId: FieldId, value: Any?) {
        val field = fields!!.firstOrNull() { it.id.id() == fieldId.id() }

        field?.let {
            FlowManager.i?.setField(fieldId, value)
        } ?: run {
            throw IllegalStateException("Can not set the field ${fieldId.id()} because don't exist in current action")
        }
    }

    override fun getField(fieldId: FieldId): Field {
        return FlowManager.i?.getField(fieldId)!!
    }


    override fun onBackPressed() {
        FlowManager.i?.goBack(this)
        super.onBackPressed()
    }

    open fun addAction(action: Action){
        FlowManager.i?.addAction(action)
    }

    override fun execute() {}


}
