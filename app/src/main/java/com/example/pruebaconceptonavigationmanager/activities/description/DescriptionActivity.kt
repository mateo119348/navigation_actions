package com.example.pruebaconceptonavigationmanager.activities.description

import android.os.Bundle
import android.widget.Toast
import com.example.navigation.flowEngine.FlowManager
import com.example.navigation.steps.flow.rules.actionValidation.ActionValidation
import com.example.pruebaconceptonavigationmanager.R
import com.example.pruebaconceptonavigationmanager.activities.ActionAbstractActivity
import com.example.pruebaconceptonavigationmanager.flowEngine.fields.Fields
import kotlinx.android.synthetic.main.activity_payment_description.*

class DescriptionActivity : ActionAbstractActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_description)

        button.setOnClickListener {
            confirmInputs()
        }
    }

    private fun confirmInputs() {
        setField(Fields.DESCRIPTION, txtDescription.text.toString())

        FlowManager.i!!.next(this)
    }


    override fun resolveUnfulfilledRule(unfulfilledRule: ActionValidation) {
        when (unfulfilledRule.id) {
            ActionValidation.Codes.DESCRIPTION_TOO_LARGE -> {
                Toast.makeText(applicationContext, "Descripcion demasiado larga", Toast.LENGTH_LONG).show()
            }
            else -> {throw IllegalStateException("Revisar los codigos de error:  " +
                "falta mapeo para ${unfulfilledRule.id}")}
        }

    }


}