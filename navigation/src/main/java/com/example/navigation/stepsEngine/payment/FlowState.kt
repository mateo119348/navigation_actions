package com.example.navigation.stepsEngine.payment

import com.example.navigation.mappers.FieldMapper
import com.example.navigation.stepsEngine.enums.AccountType
import com.example.navigation.stepsEngine.enums.Acquirer
import com.example.navigation.stepsEngine.enums.FinancingFee
import com.example.navigation.stepsEngine.enums.SiteId
import com.example.navigation.stepsEngine.field.Field
import com.example.navigation.stepsEngine.payment.card.Card
import com.example.navigation.stepsEngine.payment.cart.Cart
import com.example.navigation.stepsEngine.payment.device.Pos
import java.math.BigDecimal


class FlowState (private val fieldMapper: FieldMapper): Cloneable {
    var cart: Cart = Cart()
    var pos: Pos = Pos()
    var card: Card = Card()
    var amount: BigDecimal? = null
    var description: String? = null
    var buyerIdentification: Identification = Identification()
    var paymentMethodWrapper: PaymentMethodWrapper = PaymentMethodWrapper()
    var installments: Int? = null
    var financingFee: FinancingFee? = null
    var pointTransactionId: String? = null
    var location: Location = Location()
    var storePos: StorePos = StorePos()
    var accountType: AccountType? = null
    var taxId: String? = null
    var acquirer: Acquirer? = null
    var paymentStatus: String? = null
    var integration: Integration = Integration()
    var siteId: SiteId? = null
    var reservation: Reservation = Reservation()
    var signature: Signature? = null

    fun getField(field: String): Field {
        return fieldMapper.getField(field)
    }

    public override fun clone(): FlowState {
        val copy = FlowState(fieldMapper)
        copy.cart = cart
        copy.pos = pos
        copy.card = card
        copy.amount = amount
        copy.description = description
        copy.buyerIdentification = buyerIdentification
        copy.paymentMethodWrapper = paymentMethodWrapper
        copy.installments = installments
        copy.financingFee = financingFee
        copy.pointTransactionId = pointTransactionId
        copy.location = location
        copy.storePos = storePos
        copy.accountType = accountType
        copy.taxId = taxId
        copy.acquirer = acquirer
        copy.paymentStatus = paymentStatus
        copy.integration = integration
        copy.siteId = siteId
        copy.reservation = reservation
        copy.signature = signature
        return copy
    }

}