package com.example.pruebaconceptonavigationmanager.calculator.mla

import com.example.navigation.stepsEngine.field.AmountField
import com.example.navigation.stepsEngine.field.CartField
import com.example.navigation.stepsEngine.field.DescriptionField
import com.example.navigation.stepsEngine.field.Field
import com.example.pruebaconceptonavigationmanager.calculator.CalculatorPresenter

class CalculatorPresenterMLA : CalculatorPresenter() {

    override var fields = ArrayList<Field>()
        get() {
            if (field.isEmpty()) {
                field.add(AmountField())
                field.add(DescriptionField())
                field.add(CartField())
            }
            return field
        }
}