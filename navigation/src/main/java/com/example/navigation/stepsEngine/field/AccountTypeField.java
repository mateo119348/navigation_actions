package com.example.navigation.stepsEngine.field;

import com.example.navigation.stepsEngine.enums.AccountType;
import com.example.navigation.stepsEngine.payment.FlowState;

public class AccountTypeField extends FlowStateField {

    @Override
    public String get(FlowState flowState) {
        final AccountType accountType = flowState.getAccountType();
        if (accountType == null) {
            return null;
        } else {
            return accountType.name();
        }
    }

    @Override
    public String getFieldName() {
        return null;
    }

}
