package com.example.navigation.stepsEngine.flow.rules.comparable;

        import com.example.navigation.stepsEngine.payment.PointPayment;

public class IsGreaterThanRule extends ComparableRule {

    private Long count;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public boolean evaluate(PointPayment pointPayment) {
        return (Long) getFieldManager().get(pointPayment) > count;
    }

}
