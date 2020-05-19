package com.example.pruebaconceptonavigationmanager.installments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.navigation.action.Action
import com.example.navigation.stepsEngine.field.Field
import com.example.navigation.stepsEngine.flow.rules.actionValidation.ActionValidation
import com.example.navigation.stepsEngine.payment.FlowState
import com.example.pruebaconceptonavigationmanager.R
import java.util.*

class InstallmentsActivity : AppCompatActivity(), Action {
    private  var fields: List<Field>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_installments)
    }

    override fun getName(): String {
        return "CALCULATOR"
    }

    override fun getFields(): List<Field>? {
        if (fields == null) {
            fields = ArrayList()
        }
        return fields
    }

    override fun backStepState(fields: MutableList<Field>?, paymentFlowState: FlowState?) {
        TODO("Not yet implemented")
    }

    override fun resolveUnfullfiledRule(unfulfilledRule: ActionValidation?) {
        TODO("Not yet implemented")
    }

    override fun setFields(idField: String?, value: Any?) {
        TODO("Not yet implemented")
    }

    override fun execute(newFields: MutableList<Field>?) {
        TODO("Not yet implemented")
    }


}