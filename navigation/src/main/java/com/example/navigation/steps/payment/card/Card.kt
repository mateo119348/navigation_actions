package com.example.navigation.steps.payment.card

import com.example.navigation.steps.enums.PinType
import com.example.navigation.steps.enums.Tag
import com.example.navigation.steps.enums.CardType

class Card {
    var encryptedTrack1: String? = null
    var encryptedTrack2: String? = null
    var encryptedTrack1KeySerialNumber: String? = null
    var encryptedTrack2KeySerialNumber: String? = null
    var pin: Pin
    var cardHolderName: String? = null
    var securityCode: String? = null
    var isFallback = false
    var firstGenEMVData: String? = null
    var finishTransaction: FinishTransaction? = null
    var panSequenceNumber: String? = null
    var isMustCollectSignatureEMV = false
    var tag: Tag? = null
    var cardType: CardType? = null
    var cardTokenId: String? = null
    var issuer: Long? = null
    var firstSixDigits: String? = null
    var lastFourDigits: String? = null
    var serviceCode: String? = null
    val cvv: String? = null

    init {
        val pin = Pin()
        pin.pinType = PinType.NONE
        this.pin = pin
    }
}