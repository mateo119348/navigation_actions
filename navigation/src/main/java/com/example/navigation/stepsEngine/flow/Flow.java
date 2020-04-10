package com.example.navigation.stepsEngine.flow;

import com.example.navigation.stepsEngine.enums.OperationType;
import com.example.navigation.stepsEngine.payment.PointPayment;

import java.util.LinkedList;

public class Flow {

    private OperationType operationType;
    private LinkedList<Step> steps;

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public LinkedList<Step> getSteps() {
        return steps;
    }

    public void setSteps(LinkedList<Step> steps) {
        this.steps = steps;
    }

    //TODO: Ver bien como ir para atrás, esto así YA ANDA, pero puede quedar mejor...
    public Step getNext(final PointPayment pointPayment) {
        Step step = steps.poll();
        while (step != null && !step.mustExecute(pointPayment)) {
            step = steps.poll();
        }
        if (step == null) {
            throw new IllegalStateException("You shouldn't be here... Check your code!!!");
        }
        return step;
    }

}
