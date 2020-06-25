package com.example.pruebaconceptonavigationmanager.chooser

import android.os.Bundle
import com.example.navigation.action.FlowManager
import com.example.navigation.stepsEngine.enums.CardType
import com.example.navigation.stepsEngine.field.*
import com.example.navigation.stepsEngine.flow.rules.actionValidation.ActionValidation
import com.example.navigation.stepsEngine.payment.FlowState
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
        get()  {    field.add(CardTypeField())
                    return field }


    override fun resolveUnfullfiledRule(unfulfilledRule: ActionValidation) {}
    override fun execute(newFields: List<Field>) {}


}