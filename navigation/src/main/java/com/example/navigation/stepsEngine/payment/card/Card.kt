package com.example.navigation.stepsEngine.payment.card

import com.example.navigation.stepsEngine.enums.PinType
import com.example.navigation.stepsEngine.enums.Tag
import com.example.navigation.stepsEngine.enums.Type

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
    var type: Type? = null
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