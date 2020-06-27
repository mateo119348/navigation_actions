package com.example.pruebaconceptonavigationmanager.chooser

import android.os.Bundle
import android.widget.Toast
import com.example.navigation.action.FlowManager
import com.example.navigation.stepsEngine.enums.CardType
import com.example.navigation.stepsEngine.field.*
import com.example.navigation.stepsEngine.flow.rules.actionValidation.ActionValidation
import com.example.pruebaconceptonavigationmanager.R
import com.example.pruebaconceptonavigationmanager.actions.ActionAbstractActivity
import com.example.pruebaconceptonavigationmanager.actions.ActionName
import kotlinx.android.synthetic.main.activity_chooser.*

class ChooserActivity : ActionAbstractActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chooser)

        btnCreditCard.setOnClickListener { selectCreditCard() }
        btnContinue.setOnClickListener { continuePaymenty() }
    }

    private fun continuePaymenty() {
        FlowManager.i!!.next(this)
    }

    private fun selectCreditCard() {
        setFields(FieldName.CARD_TYPE, CardType.CREDIT_CARD)
    }

    override val name: String
        get() = ActionName.CHOOSER

    override var fields = ArrayList<Field>()
        get() {
            if (field.isEmpty()) {
                field.add(CardTypeField())
            }
            return field
        }


    override fun resolveUnfullfiledRule(unfulfilledRule: ActionValidation) {
        when (unfulfilledRule.id) {
            ActionValidation.Codes.CARD_TYPE_IS_NULL -> {
                Toast.makeText(applicationContext, "No se ha seleccionado tipo de tarjeta", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun execute(newFields: List<Field>) {}


}