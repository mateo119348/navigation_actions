package com.example.pruebaconceptonavigationmanager.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import com.example.navigation.action.FlowManager
import com.example.navigation.stepsEngine.field.*
import com.example.navigation.stepsEngine.flow.rules.actionValidation.ActionValidation
import com.example.navigation.stepsEngine.flow.rules.actionValidation.ActionValidationsId
import com.example.navigation.stepsEngine.payment.FlowState
import com.example.pruebaconceptonavigationmanager.R
import com.example.pruebaconceptonavigationmanager.actions.ActionAbstractActivity
import com.example.pruebaconceptonavigationmanager.actions.ActionName
import kotlinx.android.synthetic.main.activity_calculator.*

class CalculatorActivity : ActionAbstractActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        button.setOnClickListener {
            confirmInputs()
        }
    }


    override fun getName(): String {
        return ActionName.CALCULATOR
    }



    override fun getFields(): List<Field>? {
        fields?: run {
            fields = ArrayList()
            fields!!.add(AmountField())
            fields!!.add(CartField())
            fields!!.add(DescriptionField())
        }

        return fields
    }

    override fun resolveUnfullfiledRule(unfulfilledRule: ActionValidation) {
        when(unfulfilledRule.id){

            ActionValidationsId.AMOUNT_OUT_OF_RANGE -> {
                Toast.makeText(applicationContext, "El monto no esta en el rango", Toast.LENGTH_LONG).show()}
        }


    }



    override fun backStepState(fields: List<Field>, paymentFlowState: FlowState) {

    }

    private fun confirmInputs(){
        setFields(FieldName.AMOUNT, 23L)
        FlowManager.instance!!.next(this)
    }

}