package com.example.pruebaconceptonavigationmanager.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.navigation.action.*
import com.example.navigation.stepsEngine.field.Field
import com.example.navigation.stepsEngine.field.FieldId
import com.example.pruebaconceptonavigationmanager.flow.ActionWrapper

abstract class ActionAbstractActivity() : AppCompatActivity(), Action {


    override val fields: ArrayList<Field>?
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


    override fun setField(idField: FieldId, value: Any?) {
        FlowManager.i?.setField(getField(idField), value)
    }

    override fun getField(idField: FieldId): Field {
        return fields!!.first { it.id.id() == idField.id() }
    }

    override fun executeFields(newFields: List<Field>?) {

    }

    override fun backStepState() {
        FlowManager.i?.back(this)
    }

    override fun onBackPressed() {
        backStepState()
        super.onBackPressed()
    }


}
