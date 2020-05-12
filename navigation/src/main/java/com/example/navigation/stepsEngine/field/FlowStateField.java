package com.example.navigation.stepsEngine.field;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.example.navigation.stepsEngine.payment.FlowState;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "id")
@JsonSubTypes({
        @JsonSubTypes.Type(value = AcquirerField.class, name = FieldName.ACQUIRER),
        @JsonSubTypes.Type(value = PaymentMethodIdField.class, name = FieldName.PAYMENT_METHOD_ID),
        @JsonSubTypes.Type(value = PinTypeField.class, name = FieldName.PIN_TYPE),
        @JsonSubTypes.Type(value = InstallmentsField.class, name = FieldName.INSTALLMENTS),
        @JsonSubTypes.Type(value = ServiceCodeField.class, name = FieldName.SERVICE_CODE),
        @JsonSubTypes.Type(value = DeviceField.class, name = FieldName.DEVICE),
        @JsonSubTypes.Type(value = IsDeviceConnectedField.class, name = FieldName.IS_DEVICE_CONNECTED),
        @JsonSubTypes.Type(value = IsReservationField.class, name = FieldName.IS_RESERVATION),
        @JsonSubTypes.Type(value = ReservationEmailField.class, name = FieldName.RESERVATION_EMAIL),
        @JsonSubTypes.Type(value = DeviceTypeField.class, name = FieldName.DEVICE_TYPE),
        @JsonSubTypes.Type(value = MustCollectSignatureEMVField.class, name = FieldName.MUST_COLLECT_SIGNATURE_EMV),
        @JsonSubTypes.Type(value = TaxSelectionField.class, name = FieldName.TAX),
        @JsonSubTypes.Type(value = PaymentStatusField.class, name = FieldName.PAYMENT_STATUS),
        @JsonSubTypes.Type(value = AmountField.class, name = FieldName.AMOUNT),
        @JsonSubTypes.Type(value = AccountTypeField.class, name = FieldName.ACCOUNT_TYPE),
        @JsonSubTypes.Type(value = CardTypeField.class, name = FieldName.CARD_TYPE),
        @JsonSubTypes.Type(value = CardTagField.class, name = FieldName.CARD_TAG)})
public abstract class FlowStateField {

    public abstract Object get(final FlowState flowState);

    public abstract String getFieldName();

}
