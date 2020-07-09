package com.example.pruebaconceptonavigationmanager.activities.calculator

import android.os.Bundle
import android.widget.Toast
import com.example.navigation.action.FlowManager
import com.example.navigation.stepsEngine.flow.rules.actionValidation.ActionValidation
import com.example.pruebaconceptonavigationmanager.R
import com.example.pruebaconceptonavigationmanager.activities.ActionAbstractActivity
import com.example.pruebaconceptonavigationmanager.flowEngine.mapperImpl.FieldIdImpl
import kotlinx.android.synthetic.main.activity_calculator.*
import java.math.BigDecimal

open class CalculatorActivity : ActionAbstractActivity() {


    open var presenter = CalculatorPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResource())
        setup()

    }

    protected open fun getLayoutResource(): Int {
        return R.layout.activity_calculator
    }

    private fun setup() {
        button.setOnClickListener {
            confirmInputs()
        }
    }




    override fun resolveUnfulfilledRule(unfulfilledRule: ActionValidation) {
        when (unfulfilledRule.id) {

            ActionValidation.Codes.AMOUNT_OUT_OF_RANGE -> {
                Toast.makeText(applicationContext, "El monto no esta en el rango", Toast.LENGTH_LONG).show()
            }
            else -> {throw IllegalStateException("Revisar los codigos de error:  falta mapeo para ${unfulfilledRule.id}")}
        }


    }


    protected open fun confirmInputs() {
        setField(FieldIdImpl.AMOUNT, BigDecimal(txtAmount.text.toString()))
        FlowManager.i!!.next(this)
    }

}