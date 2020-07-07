package com.example.pruebaconceptonavigationmanager.flow

import com.example.navigation.action.ActionId
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize

@Suppress("PLUGIN_WARNING")
@Parcelize
enum class ActionIdImpl() : ActionId {
    CALCULATOR("mercadopago://calculator"),
    DESCRIPTION("mercadopago://description"),
    CHOOSER("mercadopago://chooser"),
    INSTALLMENTS("mercadopago://installments"),
    POS_SELECTOR("mercadopago://pos_selector");


    @IgnoredOnParcel
    lateinit var deepLink: String

    constructor(deepLinkArg: String) : this() {
        deepLink = deepLinkArg
    }

    override fun id(): String {
        return this.name
    }

}

