package com.example.navigation;

import android.content.Context;
import android.content.Intent;


public abstract class NavigationDestination {

    public abstract Intent getDestination(Context context, Object... params);
}
