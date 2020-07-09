package com.example.navigation.flowEngine.steps.flowState

import com.example.navigation.flowEngine.steps.enums.PaymentMethodId

class PaymentMethodWrapper {
    var paymentMethodId: PaymentMethodId? = null
    var paymentMethods: List<PaymentMethod>? = null

    //TODO: Verificar si en colombia se pide el issuer...
    var issuerId: Long? = null

}