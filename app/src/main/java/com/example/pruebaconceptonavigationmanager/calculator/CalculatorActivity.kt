package com.example.pruebaconceptonavigationmanager.calculator

import android.os.Bundle
import android.widget.Toast
import com.example.navigation.action.FlowManager
import com.example.navigation.stepsEngine.field.*
import com.example.navigation.stepsEngine.flow.rules.actionValidation.ActionValidation
import com.example.navigation.stepsEngine.payment.FlowState
import com.example.pruebaconceptonavigationmanager.R
import com.example.pruebaconceptonavigationmanager.actions.ActionAbstractActivity
import com.example.pruebaconceptonavigationmanager.actions.ActionName
import kotlinx.android.synthetic.main.activity_calculator.*
import java.math.BigDecimal

class CalculatorActivity : ActionAbstractActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        button.setOnClickListener {
            confirmInputs()
        }
    }


    override val name: String
        get() = ActionName.CALCULATOR

    override var fields = ArrayList<Field>()
        get() {
            if (field.isEmpty()) {
                field.add(AmountField())
                field.add(CartField())
            }
            return field
        }


    override fun resolveUnfullfiledRule(unfulfilledRule: ActionValidation) {
        when (unfulfilledRule.id) {

            ActionValidation.Codes.AMOUNT_OUT_OF_RANGE -> {
                Toast.makeText(applicationContext, "El monto no esta en el rango", Toast.LENGTH_LONG).show()
            }
        }


    }


    private fun confirmInputs() {
        setFields(FieldName.AMOUNT, BigDecimal(txtAmount.text.toString()))
        //FlowManager.i?.validate(this, FieldName.AMOUNT)
        FlowManager.i!!.next(this)
    }

}