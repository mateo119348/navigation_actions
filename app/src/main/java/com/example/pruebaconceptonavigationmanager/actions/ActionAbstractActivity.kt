package com.example.pruebaconceptonavigationmanager.actions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.navigation.action.Action
import com.example.navigation.action.FlowManager
import com.example.navigation.stepsEngine.field.Field
import com.example.navigation.stepsEngine.payment.FlowState

abstract class ActionAbstractActivity() : AppCompatActivity(), Action {


    override fun setFields(idField: String, value: Any?) {
        val flowState = FlowManager.i?.paymentFlowState

        var field = getField(idField)

        field.set(flowState!!, value)
    }

    private fun getField(idField : String) : Field {
        return fields.first {  it.getId() == idField}
    }

    override fun execute(newFields: List<Field>) {
        TODO("Not yet implemented")
    }

    override fun backStepState() {
        FlowManager.i?.back(fields)
    }

    override fun onBackPressed() {
        backStepState()
        super.onBackPressed()
    }
}
