package com.example.pruebaconceptonavigationmanager.chooser

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.navigation.action.Action
import com.example.navigation.stepsEngine.field.Field
import com.example.navigation.stepsEngine.flow.rules.actionValidation.ActionValidation
import com.example.navigation.stepsEngine.payment.FlowState
import com.example.pruebaconceptonavigationmanager.R
import com.example.pruebaconceptonavigationmanager.actions.ActionAbstractActivity

class ChooserActivity : ActionAbstractActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chooser)
    }

    override val name: String
        get() = "CARD_TYPE"

    override var fields = ArrayList<Field>()
        get() = ArrayList<Field>()


    override fun resolveUnfullfiledRule(unfulfilledRule: ActionValidation) {}
    override fun execute(newFields: List<Field>) {}
    override fun backStepState(fields: List<Field>, paymentFlowState: FlowState) {}
}