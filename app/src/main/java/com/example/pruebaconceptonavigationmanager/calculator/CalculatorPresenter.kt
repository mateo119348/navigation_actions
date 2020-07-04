package com.example.pruebaconceptonavigationmanager.calculator

import com.example.navigation.stepsEngine.field.AmountField
import com.example.navigation.stepsEngine.field.CartField
import com.example.navigation.stepsEngine.field.Field

open class CalculatorPresenter {



    open var fields = ArrayList<Field>()
        get() {
            if (field.isEmpty()) {
                field.add(AmountField())
                field.add(CartField())
            }
            return field
        }
}