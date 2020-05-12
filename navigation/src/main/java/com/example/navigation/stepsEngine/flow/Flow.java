package com.example.navigation.stepsEngine.flow;

import com.example.navigation.stepsEngine.enums.OperationType;
import com.example.navigation.stepsEngine.flow.rules.actionValidation.ActionValidation;
import com.example.navigation.stepsEngine.payment.FlowState;

import java.util.LinkedList;
import java.util.List;

public class Flow {

    private OperationType operationType;
    private LinkedList<Step> steps;
    private List<ActionValidation> validations;

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public List<ActionValidation> getValidations() {
        return validations;
    }

    public LinkedList<Step> getSteps() {
        return steps;
    }

    public void setSteps(LinkedList<Step> steps) {
        this.steps = steps;
    }

    //TODO: Ver bien como ir para atrás, esto así YA ANDA, pero puede quedar mejor...
    public Step getNext(final FlowState flowState) {
        Step step = steps.poll();
        while (step != null && !step.mustExecute(flowState)) {
            step = steps.poll();
        }
        if (step == null) {
            throw new IllegalStateException("You shouldn't be here... Check your code!!!");
        }
        return step;
    }

}
