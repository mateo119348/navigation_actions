package com.example.navigation.stepsEngine.flow.rules.comparable;

        import com.example.navigation.stepsEngine.payment.FlowState;

public class GreaterThanRule extends ComparableRule {

    private Long count;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public boolean evaluate(FlowState flowState) {
        return (Long) getField().get(flowState) > count;
    }

}
