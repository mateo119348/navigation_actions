package com.example.pruebaconceptonavigationmanager.activities.posSelector

import android.os.Bundle
import com.example.navigation.stepsEngine.field.Field
import com.example.navigation.stepsEngine.flow.rules.actionValidation.ActionValidation
import com.example.pruebaconceptonavigationmanager.R
import com.example.pruebaconceptonavigationmanager.activities.ActionAbstractActivity

class PosSelectorActivity : ActionAbstractActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pos_selector)
    }


    override fun resolveUnfullfiledRule(unfulfilledRule: ActionValidation) {

    }

    override fun executeFields(newFields: List<Field>?) {
        TODO("Not yet implemented")
    }
}