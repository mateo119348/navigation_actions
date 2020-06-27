package com.example.pruebaconceptonavigationmanager.posSelector

import android.os.Bundle
import com.example.navigation.stepsEngine.field.Field
import com.example.navigation.stepsEngine.flow.rules.actionValidation.ActionValidation
import com.example.navigation.stepsEngine.payment.FlowState
import com.example.pruebaconceptonavigationmanager.R
import com.example.pruebaconceptonavigationmanager.actions.ActionAbstractActivity
import com.example.pruebaconceptonavigationmanager.actions.ActionName

class PosSelectorActivity : ActionAbstractActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pos_selector)
    }

    override val name: String
        get() = ActionName.POS_SELECTOR
    override var fields =  ArrayList<Field>()
        get () {return field}


    override fun resolveUnfullfiledRule(unfulfilledRule: ActionValidation) {

    }


}