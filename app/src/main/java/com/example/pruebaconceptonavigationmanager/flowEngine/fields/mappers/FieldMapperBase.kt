package com.example.pruebaconceptonavigationmanager.flowEngine.fields.mappers

import com.example.navigation.flowEngine.steps.field.Field
import com.example.navigation.flowEngine.steps.field.FieldMapper
import com.example.pruebaconceptonavigationmanager.flowEngine.fields.*
import com.example.pruebaconceptonavigationmanager.flowEngine.fields.Fields.ACQUIRER
import com.example.pruebaconceptonavigationmanager.flowEngine.fields.Fields.DESCRIPTION
import com.example.pruebaconceptonavigationmanager.flowEngine.fields.Fields.PAYMENT_METHOD_ID
import com.example.pruebaconceptonavigationmanager.flowEngine.fields.Fields.PIN_TYPE
import com.example.pruebaconceptonavigationmanager.flowEngine.fields.Fields.INSTALLMENTS
import com.example.pruebaconceptonavigationmanager.flowEngine.fields.Fields.SERVICE_CODE
import com.example.pruebaconceptonavigationmanager.flowEngine.fields.Fields.DEVICE
import com.example.pruebaconceptonavigationmanager.flowEngine.fields.Fields.IS_DEVICE_CONNECTED
import com.example.pruebaconceptonavigationmanager.flowEngine.fields.Fields.IS_RESERVATION
import com.example.pruebaconceptonavigationmanager.flowEngine.fields.Fields.RESERVATION_EMAIL
import com.example.pruebaconceptonavigationmanager.flowEngine.fields.Fields.DEVICE_TYPE
import com.example.pruebaconceptonavigationmanager.flowEngine.fields.Fields.MUST_COLLECT_SIGNATURE_EMV
import com.example.pruebaconceptonavigationmanager.flowEngine.fields.Fields.TAX
import com.example.pruebaconceptonavigationmanager.flowEngine.fields.Fields.PAYMENT_STATUS
import com.example.pruebaconceptonavigationmanager.flowEngine.fields.Fields.AMOUNT
import com.example.pruebaconceptonavigationmanager.flowEngine.fields.Fields.ACCOUNT_TYPE
import com.example.pruebaconceptonavigationmanager.flowEngine.fields.Fields.CARD_TAG
import com.example.pruebaconceptonavigationmanager.flowEngine.fields.Fields.CARD_TYPE
import com.example.pruebaconceptonavigationmanager.flowEngine.fields.Fields.CART
import kotlinx.android.parcel.Parcelize

@Parcelize
class FieldMapperBase : FieldMapper {

    override fun getField(fieldId: String): Field {
        return when (fieldId) {

            ACQUIRER.name -> AcquirerField(ACQUIRER)
            DESCRIPTION.name -> DescriptionField(DESCRIPTION)
            PAYMENT_METHOD_ID.name -> PaymentMethodIdField(PAYMENT_METHOD_ID)
            PIN_TYPE.name -> PinTypeField(PIN_TYPE)
            INSTALLMENTS.name -> InstallmentsField(INSTALLMENTS)
            SERVICE_CODE.name -> ServiceCodeField(SERVICE_CODE)
            DEVICE.name -> DeviceField(DEVICE)
            IS_DEVICE_CONNECTED.name -> IsDeviceConnectedField(IS_DEVICE_CONNECTED)
            IS_RESERVATION.name -> IsReservationField(IS_RESERVATION)
            RESERVATION_EMAIL.name -> ReservationEmailField(RESERVATION_EMAIL)
            DEVICE_TYPE.name -> DeviceTypeField(DEVICE)
            MUST_COLLECT_SIGNATURE_EMV.name -> MustCollectSignatureEMVField(MUST_COLLECT_SIGNATURE_EMV)
            TAX.name -> TaxSelectionField(TAX)
            PAYMENT_STATUS.name -> PaymentStatusField(PAYMENT_STATUS)
            AMOUNT.name -> AmountField(AMOUNT)
            ACCOUNT_TYPE.name -> AccountTypeField(ACCOUNT_TYPE)
            CARD_TYPE.name -> CardTypeField(CARD_TYPE)
            CARD_TAG.name -> CardTagField(CARD_TAG)
            CART.name -> CartField(CART)
            else -> {
                throw IllegalStateException("Revisar los fields: key de field inexistente o falta mapeo para $fieldId")
            }
        }
    }

    override fun getFields(fields: List<String>?): List<Field> {
        val result = ArrayList<Field>()
        fields?.forEach {
            result.add(getField(it))
        }
        return result
    }
}