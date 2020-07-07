package com.example.navigation.stepsEngine.field

import android.os.Parcelable
import com.example.navigation.stepsEngine.payment.FlowState
import kotlinx.android.parcel.Parcelize

abstract class Field(var id: FieldId) : Parcelable{
    
    abstract fun get(flowState: FlowState): Any?
    abstract fun set(flowState: FlowState, value: Any?)
    open fun initState(flowState: FlowState){
        set(flowState, null)
    }
    



    
}