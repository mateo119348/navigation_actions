package com.example.pruebaconceptonavigationmanager.activities.installments

import android.os.Bundle
import com.example.navigation.flowEngine.validations.ActionValidation
import com.example.pruebaconceptonavigationmanager.R
import com.example.pruebaconceptonavigationmanager.activities.ActionAbstractActivity

class InstallmentsActivity : ActionAbstractActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_installments)
    }


    override fun resolveUnfulfilledRule(unfulfilledRule: ActionValidation) {
        TODO("Not yet implemented")
    }



}