package com.example.pruebaconceptonavigationmanager.installments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.navigation.action.Action
import com.example.navigation.stepsEngine.field.AmountField
import com.example.navigation.stepsEngine.field.CartField
import com.example.navigation.stepsEngine.field.Field
import com.example.navigation.stepsEngine.field.InstallmentsField
import com.example.navigation.stepsEngine.flow.rules.actionValidation.ActionValidation
import com.example.navigation.stepsEngine.payment.FlowState
import com.example.pruebaconceptonavigationmanager.R
import com.example.pruebaconceptonavigationmanager.actions.ActionAbstractActivity
import com.example.pruebaconceptonavigationmanager.actions.ActionName
import java.util.*

class InstallmentsActivity :  ActionAbstractActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_installments)
    }

    override val name: String
        get() = ActionName.INSTALLMENTS

    override var fields = ArrayList<Field>()
        get()  {    field.add(InstallmentsField())
                    return field }


    override fun resolveUnfullfiledRule(unfulfilledRule: ActionValidation) {
        TODO("Not yet implemented")
    }




    override fun execute(newFields: List<Field>) {
        TODO("Not yet implemented")
    }


}