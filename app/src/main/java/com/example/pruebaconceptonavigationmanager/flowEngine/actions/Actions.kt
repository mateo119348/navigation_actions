package com.example.pruebaconceptonavigationmanager.flowEngine.actions

import com.example.navigation.flowEngine.actions.ActionId
import kotlinx.android.parcel.Parcelize


@Parcelize
enum class Actions : ActionId {
    CALCULATOR,
    DESCRIPTION,
    CHOOSER,
    INSTALLMENTS,
    POS_SELECTOR;

    override fun id(): String {
        return this.name
    }

}

