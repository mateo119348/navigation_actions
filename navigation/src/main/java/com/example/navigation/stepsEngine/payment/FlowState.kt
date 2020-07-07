package com.example.navigation.stepsEngine.payment

import android.os.Parcelable
import com.example.navigation.stepsEngine.enums.AccountType
import com.example.navigation.stepsEngine.enums.Acquirer
import com.example.navigation.stepsEngine.enums.FinancingFee
import com.example.navigation.stepsEngine.enums.SiteId
import com.example.navigation.stepsEngine.payment.card.Card
import com.example.navigation.stepsEngine.payment.cart.Cart
import com.example.navigation.stepsEngine.payment.device.Pos
import kotlinx.android.parcel.Parcelize
import java.math.BigDecimal


class FlowState {
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

}