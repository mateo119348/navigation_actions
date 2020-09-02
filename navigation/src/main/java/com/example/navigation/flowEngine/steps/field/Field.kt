package com.example.navigation.flowEngine.steps.field

import android.os.Parcelable
import com.example.navigation.flowEngine.steps.flowState.FlowState

abstract class Field(var id: FieldId) : Parcelable{
    
    abstract fun get(flowState: FlowState): Any?
    abstract fun set(flowState: FlowState, value: Any?)
    open fun initState(flowState: FlowState){
        set(flowState, null)
    }
    



    
}