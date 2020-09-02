package com.example.pruebaconceptonavigationmanager.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.navigation.flowEngine.FlowManager.Companion.i
import com.example.navigation.flowEngine.Flow
import com.example.navigation.flowEngine.steps.flowState.FlowState
import com.example.pruebaconceptonavigationmanager.R
import com.example.pruebaconceptonavigationmanager.flowEngine.FlowMediatorImpl
import com.example.pruebaconceptonavigationmanager.flowEngine.actions.mappers.ActionsMapperBase
import com.example.pruebaconceptonavigationmanager.flowEngine.fields.mappers.FieldMapperBase
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategy


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupFlowManager()
    }


    private fun setupFlowManager(){

        val mapper = ObjectMapper()
        mapper.propertyNamingStrategy = PropertyNamingStrategy.SNAKE_CASE

        try {
            val inputStreamSteps = assets.open("flows/MLB.json")
            val flow = mapper.readValue(inputStreamSteps, Flow::class.java)
            inputStreamSteps.close()

            val fieldMapper = FieldMapperBase()
            val flowState = FlowState(fieldMapper)
            val actionHeaderMapper = ActionsMapperBase()
            val flowMediator = FlowMediatorImpl(applicationContext, fieldMapper, actionHeaderMapper)
            i!!.startFlow(flowMediator, flow, flowState)
        } catch (ex: Exception) {
            Log.e("Error", ex.message, ex.cause)
        }
    }
}
