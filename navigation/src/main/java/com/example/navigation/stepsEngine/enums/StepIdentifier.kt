package com.example.navigation.stepsEngine.enums

enum class StepIdentifier {
    AMOUNT, CARD_TYPE, INSTALLMENTS, DESCRIPTION, RESERVATION, ACCOUNT_TYPE, CARD_INFORMATION, ISSUER, BUYER_IDENTIFICATION, CVV, SIGN, POS_SELECTION, TAX_SELECTION, FINALIZE_CARD, ADVICE, CONNECT, DISCONNECT, END, ASK_PIN_WHEN_SWIPE //STORE_POS en caso que se desee agregar acá, esto para mí es algo previo y compartido estre módulos, pero tampoco estaría mal meterlo
    //FINANCING_FEE, para cuándo se implemente pago a pago
}