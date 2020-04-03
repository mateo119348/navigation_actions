package com.example.navigation;

import android.content.Context;
import android.content.Intent;

import java.util.Map;

public abstract class NavigationValidation {

    public abstract Intent validate(Context context, Map<String, NavigationDestination> destinations, PaymentFlowState paymentFlowState, Object... params);
}
