package com.example.pruebaconceptonavigationmanager.description

import android.os.Bundle
import android.widget.Toast
import com.example.navigation.action.FlowManager
import com.example.navigation.stepsEngine.field.DescriptionField
import com.example.navigation.stepsEngine.field.Field
import com.example.navigation.stepsEngine.field.FieldName
import com.example.navigation.stepsEngine.flow.rules.actionValidation.ActionValidation
import com.example.navigation.stepsEngine.payment.FlowState
import com.example.pruebaconceptonavigationmanager.R
import com.example.pruebaconceptonavigationmanager.actions.ActionAbstractActivity
import com.example.pruebaconceptonavigationmanager.actions.ActionName
import kotlinx.android.synthetic.main.activity_payment_description.*
import java.math.BigDecimal

class DescriptionActivity : ActionAbstractActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_description)

        button.setOnClickListener {
            confirmInputs()
        }
    }

    private fun confirmInputs() {
        setFields(FieldName.DESCRIPTION, txtDescription.text.toString())

        FlowManager.i!!.next(this)
    }

    override val name: String
        get() = ActionName.DESCRIPTION
    override var fields = ArrayList<Field>()
        get()  {field.add(DescriptionField())
                return field}


    override fun resolveUnfullfiledRule(unfulfilledRule: ActionValidation) {
        when(unfulfilledRule.id){
            ActionValidation.DESCRIPTION_TOO_LARGE -> {
                Toast.makeText(applicationContext, "Descripcion demasiado larga", Toast.LENGTH_LONG).show()}
        }

    }

    override fun backStepState(fields: List<Field>, paymentFlowState: FlowState) {
        TODO("Not yet implemented")
    }
}