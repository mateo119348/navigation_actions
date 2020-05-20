package com.example.pruebaconceptonavigationmanager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.navigation.action.FlowManager
import com.example.navigation.action.FlowManager.Companion.i
import com.example.navigation.action.RuleAction
import com.example.navigation.stepsEngine.flow.Flow
import com.example.navigation.stepsEngine.payment.FlowState
import com.example.pruebaconceptonavigationmanager.actions.ActionMapperImpl
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategy


class MainActivity : AppCompatActivity() {

    private lateinit var flow: Flow
    private lateinit var actions: List<RuleAction>
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
            val inputStreamSteps = assets.open("steps/MLB.json")
            val inputStreamActions = assets.open("stepActions/MLB.json")
            flow = mapper.readValue(inputStreamSteps, Flow::class.java)
            actions = mapper.readValue(inputStreamActions, object : TypeReference<List<RuleAction?>?>() {})
            inputStreamSteps.close()
            inputStreamActions.close()
            actionMapper = ActionMapperImpl(applicationContext)
            i!!.startFlow(actionMapper, flow, flowState!!, actions)
        } catch (ex: Exception) {
            var i = 0
        }
    }
}