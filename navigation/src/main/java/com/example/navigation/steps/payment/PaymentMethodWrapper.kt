package com.example.navigation.steps.payment

import com.example.navigation.steps.enums.PaymentMethodId

class PaymentMethodWrapper {
    var paymentMethodId: PaymentMethodId? = null
    var paymentMethods: List<PaymentMethod>? = null

    //TODO: Verificar si en colombia se pide el issuer...
    var issuerId: Long? = null

}