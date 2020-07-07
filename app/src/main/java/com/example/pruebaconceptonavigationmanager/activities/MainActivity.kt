package com.example.pruebaconceptonavigationmanager.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.navigation.action.FlowManager.Companion.i
import com.example.navigation.stepsEngine.flow.Flow
import com.example.navigation.stepsEngine.payment.FlowState
import com.example.pruebaconceptonavigationmanager.R
import com.example.pruebaconceptonavigationmanager.flow.ActionMapperImpl
import com.example.pruebaconceptonavigationmanager.flow.mapperImpl.FieldMapperImpl
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategy


class MainActivity : AppCompatActivity() {

    private lateinit var flow: Flow
    private lateinit var actionMapper: ActionMapperImpl
    private var flowState: FlowState = FlowState()


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
            flow = mapper.readValue(inputStreamSteps, Flow::class.java)
            inputStreamSteps.close()
            actionMapper = ActionMapperImpl(applicationContext, FieldMapperImpl())
            i!!.startFlow(actionMapper, flow, flowState, FieldMapperImpl())
        } catch (ex: Exception) {
            Log.e("Error", ex.message, ex.cause)
        }
    }
}
