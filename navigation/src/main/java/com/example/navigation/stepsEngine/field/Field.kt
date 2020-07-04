package com.example.navigation.stepsEngine.field

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import com.example.navigation.stepsEngine.payment.FlowState



import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo

//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "id")
//@JsonSubTypes(
//        JsonSubTypes.Type(value = AcquirerField::class, name = FieldName.ACQUIRER),
//        JsonSubTypes.Type(value = PaymentMethodIdField::class, name = FieldName.PAYMENT_METHOD_ID),
//        JsonSubTypes.Type(value = PinTypeField::class, name = FieldName.PIN_TYPE),
//        JsonSubTypes.Type(value = InstallmentsField::class, name = FieldName.INSTALLMENTS),
//        JsonSubTypes.Type(value = ServiceCodeField::class, name = FieldName.SERVICE_CODE),
//        JsonSubTypes.Type(value = DeviceField::class, name = FieldName.DEVICE),
//        JsonSubTypes.Type(value = IsDeviceConnectedField::class, name = FieldName.IS_DEVICE_CONNECTED),
//        JsonSubTypes.Type(value = IsReservationField::class, name = FieldName.IS_RESERVATION),
//        JsonSubTypes.Type(value = ReservationEmailField::class, name = FieldName.RESERVATION_EMAIL),
//        JsonSubTypes.Type(value = DeviceTypeField::class, name = FieldName.DEVICE_TYPE),
//        JsonSubTypes.Type(value = MustCollectSignatureEMVField::class, name = FieldName.MUST_COLLECT_SIGNATURE_EMV),
//        JsonSubTypes.Type(value = TaxSelectionField::class, name = FieldName.TAX),
//        JsonSubTypes.Type(value = PaymentStatusField::class, name = FieldName.PAYMENT_STATUS),
//        JsonSubTypes.Type(value = AmountField::class, name = FieldName.AMOUNT),
//        JsonSubTypes.Type(value = AccountTypeField::class, name = FieldName.ACCOUNT_TYPE),
//        JsonSubTypes.Type(value = CardTypeField::class, name = FieldName.CARD_TYPE),
//        JsonSubTypes.Type(value = CardTagField::class, name = FieldName.CARD_TAG))


abstract class Field : Parcelable{
    abstract fun get(flowState: FlowState): Any?
    abstract fun getId(): String
    abstract fun set(flowState: FlowState, value: Any?)

    companion object {
        @JvmStatic
        fun getFlowStateField(field : String): Field? {
            return when (field!!){
                FieldName.ACQUIRER -> AcquirerField()
                FieldName.DESCRIPTION -> DescriptionField()
                FieldName.PAYMENT_METHOD_ID -> PaymentMethodIdField()
                FieldName.PIN_TYPE -> PinTypeField()
                FieldName.INSTALLMENTS -> InstallmentsField()
                FieldName.SERVICE_CODE -> ServiceCodeField()
                FieldName.DEVICE -> DeviceField()
                FieldName.IS_DEVICE_CONNECTED -> IsDeviceConnectedField()
                FieldName.IS_RESERVATION -> IsReservationField()
                FieldName.RESERVATION_EMAIL -> ReservationEmailField()
                FieldName.DEVICE_TYPE -> DeviceTypeField()
                FieldName.MUST_COLLECT_SIGNATURE_EMV -> MustCollectSignatureEMVField()
                FieldName.TAX -> TaxSelectionField()
                FieldName.PAYMENT_STATUS -> PaymentStatusField()
                FieldName.AMOUNT -> AmountField()
                FieldName.ACCOUNT_TYPE -> AccountTypeField()
                FieldName.CARD_TYPE -> CardTypeField()
                FieldName.CARD_TAG -> CardTagField()
                FieldName.CART -> CartField()
                else -> { throw IllegalStateException("Revisar los fields: key de field inexistente o falta mapeo para $field")}
            }
        }
    }
}