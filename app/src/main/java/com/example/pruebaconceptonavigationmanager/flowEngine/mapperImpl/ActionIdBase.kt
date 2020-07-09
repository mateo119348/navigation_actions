package com.example.pruebaconceptonavigationmanager.flowEngine.mapperImpl

import com.example.navigation.action.ActionId
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize

@Suppress("PLUGIN_WARNING")
@Parcelize
enum class ActionIdBase() : ActionId {
    CALCULATOR("mercadopago://calculator"),
    DESCRIPTION("mercadopago://description"),
    CHOOSER("mercadopago://chooser"),
    INSTALLMENTS("mercadopago://installments"),
    POS_SELECTOR("mercadopago://pos_selector");


    @IgnoredOnParcel
    var deepLink: String? = null

    constructor(deepLinkArg: String?) : this() {
        deepLink = deepLinkArg
    }

    override fun id(): String {
        return this.name
    }

}

