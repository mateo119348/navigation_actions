package com.example.pruebaconceptonavigationmanager.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.navigation.action.*
import com.example.navigation.stepsEngine.field.Field
import com.example.navigation.stepsEngine.field.FieldId
import com.example.pruebaconceptonavigationmanager.flowEngine.ActionHeader

abstract class ActionAbstractActivity: AppCompatActivity(), Action {


    override val fields: List<Field>?
        get() = actionHeader?.fields

    override val name: ActionId
        get() = actionHeader!!.actionId


    private var actionHeader: ActionHeader? = null
        get() {
            field ?: run {
                field = intent.getParcelableExtra(BUNDLE_ACTION_HEADER)
            }
            return field
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        actionHeader = intent.getParcelableExtra(BUNDLE_ACTION_HEADER)
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

    override fun getField(idField: FieldId): Field {
        return FlowManager.i?.getField(idField)!!
    }


    override fun onBackPressed() {
        FlowManager.i?.back(this)
        super.onBackPressed()
    }

    open fun addAction(action: Action){
        FlowManager.i?.addAction(action)
    }

    override fun execute() {}



}
