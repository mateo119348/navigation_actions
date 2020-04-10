package com.example.navigation.stepsEngine.field;

import com.example.navigation.stepsEngine.enums.AccountType;
import com.example.navigation.stepsEngine.payment.PointPayment;

public class AccountTypeFieldManager extends FieldManager {

    @Override
    public String get(PointPayment pointPayment) {
        final AccountType accountType = pointPayment.getAccountType();
        if (accountType == null) {
            return null;
        } else {
            return accountType.name();
        }
    }

}
