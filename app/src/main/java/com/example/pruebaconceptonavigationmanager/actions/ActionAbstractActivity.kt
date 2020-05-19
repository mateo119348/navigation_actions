package com.example.pruebaconceptonavigationmanager.actions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.navigation.action.Action
import com.example.navigation.action.FlowManager
import com.example.navigation.stepsEngine.field.Field

abstract class ActionAbstractActivity : AppCompatActivity(), Action {

    protected var fields : ArrayList<Field>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun setFields(idField: String, value: Any) {
        val flowState = FlowManager.instance?.paymentFlowState

        var field = getFields()!!.first {  it.getId() == idField }

        field.set(flowState!!, value)
    }

    override fun execute(newFields: MutableList<Field>?) {
        TODO("Not yet implemented")
    }
}
