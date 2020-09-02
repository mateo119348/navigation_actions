package com.example.pruebaconceptonavigationmanager.flowEngine.fields

import com.example.navigation.flowEngine.steps.field.FieldId
import kotlinx.android.parcel.Parcelize

@Parcelize
enum class Fields: FieldId {
    ACQUIRER,
    DESCRIPTION,
    PAYMENT_METHOD_ID,
    PIN_TYPE,
    INSTALLMENTS,
    SERVICE_CODE,
    DEVICE,
    IS_DEVICE_CONNECTED,
    IS_RESERVATION,
    RESERVATION_EMAIL,
    DEVICE_TYPE,
    MUST_COLLECT_SIGNATURE_EMV,
    TAX,
    PAYMENT_STATUS,
    AMOUNT,
    ACCOUNT_TYPE,
    CARD_TYPE,
    CARD_TAG,
    CART;

    override fun id(): String {
        return this.name
    }
}