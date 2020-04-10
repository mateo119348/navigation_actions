package com.example.navigation.stepsEngine.field;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.example.navigation.stepsEngine.payment.PointPayment;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "comparable_field_name")
@JsonSubTypes({
        @JsonSubTypes.Type(value = AcquirerFieldManager.class, name = FieldName.ACQUIRER),
        @JsonSubTypes.Type(value = PaymentMethodIdFieldManager.class, name = FieldName.PAYMENT_METHOD_ID),
        @JsonSubTypes.Type(value = PinTypeFieldManager.class, name = FieldName.PIN_TYPE),
        @JsonSubTypes.Type(value = InstallmentsFieldManager.class, name = FieldName.INSTALLMENTS),
        @JsonSubTypes.Type(value = ServiceCodeFieldManager.class, name = FieldName.SERVICE_CODE),
        @JsonSubTypes.Type(value = DeviceFieldManager.class, name = FieldName.DEVICE),
        @JsonSubTypes.Type(value = IsDeviceConnectedFieldManager.class, name = FieldName.IS_DEVICE_CONNECTED),
        @JsonSubTypes.Type(value = IsReservationFieldManager.class, name = FieldName.IS_RESERVATION),
        @JsonSubTypes.Type(value = ReservationEmailFieldManager.class, name = FieldName.RESERVATION_EMAIL),
        @JsonSubTypes.Type(value = DeviceTypeFieldManager.class, name = FieldName.DEVICE_TYPE),
        @JsonSubTypes.Type(value = MustCollectSignatureEMVFieldManager.class, name = FieldName.MUST_COLLECT_SIGNATURE_EMV),
        @JsonSubTypes.Type(value = TaxSelectionFieldManager.class, name = FieldName.TAX),
        @JsonSubTypes.Type(value = PaymentStatusFieldManager.class, name = FieldName.PAYMENT_STATUS),
        @JsonSubTypes.Type(value = AmountFieldManager.class, name = FieldName.AMOUNT),
        @JsonSubTypes.Type(value = AccountTypeFieldManager.class, name = FieldName.ACCOUNT_TYPE),
        @JsonSubTypes.Type(value = CardTypeFieldManager.class, name = FieldName.CARD_TYPE),
        @JsonSubTypes.Type(value = CardTagFieldManager.class, name = FieldName.CARD_TAG)})
public abstract class FieldManager {

    public abstract Object get(final PointPayment pointPayment);

    public abstract String getFieldName();

}
