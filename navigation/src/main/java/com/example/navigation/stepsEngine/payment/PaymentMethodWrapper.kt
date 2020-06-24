package com.example.navigation.stepsEngine.payment

import com.example.navigation.stepsEngine.enums.PaymentMethodId

class PaymentMethodWrapper {
    var paymentMethodId: PaymentMethodId? = null
    var paymentMethods: List<PaymentMethod>? = null

    //TODO: Verificar si en colombia se pide el issuer...
    var issuerId: Long? = null

}