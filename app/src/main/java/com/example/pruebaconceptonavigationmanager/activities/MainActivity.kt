package com.example.pruebaconceptonavigationmanager.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.navigation.action.FlowManager.Companion.i
import com.example.navigation.stepsEngine.flow.Flow
import com.example.navigation.stepsEngine.payment.FlowState
import com.example.pruebaconceptonavigationmanager.R
import com.example.pruebaconceptonavigationmanager.flowEngine.FlowMediatorImpl
import com.example.pruebaconceptonavigationmanager.flowEngine.mapperImpl.ActionHeaderMapperBase
import com.example.pruebaconceptonavigationmanager.flowEngine.mapperImpl.FieldMapperBase
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
            val actionHeaderMapper = ActionHeaderMapperBase()
            val flowMediator = FlowMediatorImpl(applicationContext, fieldMapper, actionHeaderMapper)
            i!!.startFlow(flowMediator, flow, flowState)
        } catch (ex: Exception) {
            Log.e("Error", ex.message, ex.cause)
        }
    }
}
