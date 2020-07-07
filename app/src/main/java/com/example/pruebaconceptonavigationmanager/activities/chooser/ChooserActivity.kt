package com.example.pruebaconceptonavigationmanager.activities.chooser

import android.os.Bundle
import android.widget.Toast
import com.example.navigation.action.ActionId
import com.example.navigation.action.FlowManager
import com.example.navigation.stepsEngine.enums.CardType
import com.example.navigation.stepsEngine.field.*
import com.example.navigation.stepsEngine.flow.rules.actionValidation.ActionValidation
import com.example.pruebaconceptonavigationmanager.R
import com.example.pruebaconceptonavigationmanager.activities.ActionAbstractActivity
import com.example.pruebaconceptonavigationmanager.flow.FieldIdImpl
import kotlinx.android.synthetic.main.activity_chooser.*

class ChooserActivity : ActionAbstractActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chooser)

        btnCreditCard.setOnClickListener { selectCreditCard() }
        btnDebitCard.setOnClickListener { selectDebitCard() }
        btnVoucher.setOnClickListener { selectVoucherCard() }
        btnQR.setOnClickListener { selectQR() }
    }

    private fun continuePayment() {
        FlowManager.i!!.next(this)
    }

    private fun selectCreditCard() {
        setTypeCard(CardType.CREDIT_CARD)
        continuePayment()
    }

    private fun selectDebitCard() {
        setTypeCard(CardType.DEBIT_CARD)
        continuePayment()
    }

    private fun selectVoucherCard() {
        setTypeCard(CardType.VOUCHER_CARD)
        continuePayment()
    }

    private fun selectQR() {
        setTypeCard(CardType.QR)
        continuePayment()
    }

    fun setTypeCard(cardType: CardType) {
        setField(FieldIdImpl.CARD_TYPE, cardType)
    }




    override fun resolveUnfullfiledRule(unfulfilledRule: ActionValidation) {
        when (unfulfilledRule.id) {
            ActionValidation.Codes.CARD_TYPE_IS_NULL -> {
                Toast.makeText(applicationContext, "No se ha seleccionado tipo de tarjeta", Toast.LENGTH_LONG).show()
            }
            else -> {throw IllegalStateException("Revisar los codigos de error:  falta mapeo para ${unfulfilledRule.id}")}
        }
    }

    override fun executeFields(newFields: List<Field>?) {
        TODO("Not yet implemented")
    }


}