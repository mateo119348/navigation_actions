package com.example.navigation.stepsEngine.payment

import com.example.navigation.stepsEngine.enums.AccountType
import com.example.navigation.stepsEngine.enums.Acquirer
import com.example.navigation.stepsEngine.enums.FinancingFee
import com.example.navigation.stepsEngine.enums.SiteId
import com.example.navigation.stepsEngine.payment.card.Card
import com.example.navigation.stepsEngine.payment.cart.Cart
import com.example.navigation.stepsEngine.payment.device.Pos
import java.math.BigDecimal

class FlowState {
    var cart: Cart
    var pos: Pos
    var card: Card
    var amount: BigDecimal? = null
    var description: String? = null
    var buyerIdentification: Identification
    var paymentMethodWrapper: PaymentMethodWrapper
    var installments: Int? = null
    var financingFee: FinancingFee? = null
    var pointTransactionId: String? = null
    var location: Location
    var storePos: StorePos
    var accountType: AccountType? = null
    var taxId: String? = null
    var acquirer: Acquirer? = null
    var paymentStatus: String? = null
    var integration: Integration
    var siteId: SiteId? = null
    var reservation: Reservation
    var signature: Signature? = null

    init {
        card = Card()
        paymentMethodWrapper = PaymentMethodWrapper()
        pos = Pos()
        buyerIdentification = Identification()
        integration = Integration()
        storePos = StorePos()
        location = Location()
        cart = Cart()
        reservation = Reservation()
    }
}