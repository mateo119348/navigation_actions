package com.example.pruebaconceptonavigationmanager.activities.calculator.mla

import android.widget.Toast
import com.example.navigation.action.FlowManager
import com.example.navigation.stepsEngine.field.*
import com.example.navigation.stepsEngine.flow.rules.actionValidation.ActionValidation
import com.example.pruebaconceptonavigationmanager.R
import com.example.pruebaconceptonavigationmanager.activities.calculator.CalculatorActivity
import com.example.pruebaconceptonavigationmanager.activities.calculator.CalculatorPresenter
import com.example.pruebaconceptonavigationmanager.flow.FieldIdImpl
import kotlinx.android.synthetic.main.activity_calculator.*
import kotlinx.android.synthetic.main.activity_payment_description.*
import java.math.BigDecimal

class CalculatorActivityMLA : CalculatorActivity() {



    override var presenter: CalculatorPresenter = CalculatorPresenterMLA()

    override fun getLayoutResource(): Int {
        return R.layout.activity_calculator_mla
    }


    override fun confirmInputs() {
        setField(FieldIdImpl.AMOUNT, BigDecimal(txtAmount.text.toString()))
        setField(FieldIdImpl.DESCRIPTION, txtDescription.text.toString())
        FlowManager.i!!.next(this)
    }

    override fun resolveUnfullfiledRule(unfulfilledRule: ActionValidation) {
        super.resolveUnfullfiledRule(unfulfilledRule)

        when (unfulfilledRule.id) {
            ActionValidation.Codes.DESCRIPTION_TOO_LARGE -> {
                Toast.makeText(applicationContext, "La descripcion es muy larga", Toast.LENGTH_LONG).show()
            }
            else -> {throw IllegalStateException("Revisar los codigos de error:  falta mapeo para ${unfulfilledRule.id}")}
        }

    }
}