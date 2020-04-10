package com.example.navigation.stepsEngine.flow.rules.comparable;

        import com.example.navigation.stepsEngine.payment.PointPayment;

public class BooleanEqualsRule extends ComparableRule {

    private Boolean aBoolean;

    public Boolean getaBoolean() {
        return aBoolean;
    }

    public void setaBoolean(Boolean aBoolean) {
        this.aBoolean = aBoolean;
    }

    @Override
    public boolean evaluate(PointPayment pointPayment) {
        return getFieldManager().get(pointPayment).equals(aBoolean);
    }

}
