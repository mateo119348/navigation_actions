package com.example.navigation.stepsEngine.flow.rules.comparable.string;

import com.example.navigation.stepsEngine.flow.rules.comparable.ComparableRule;
import com.example.navigation.stepsEngine.payment.FlowState;

public class StringIsContainedRule extends ComparableRule {

    private String value;
    private Integer start;
    private Integer end;

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    @Override
    public boolean evaluate(FlowState flowState) {
        int from = start == null ? 0 : start;
        final String string = (String) getValue(flowState);
        int to = end == null ? string.length() : end;
        final String s = string.substring(from, to);
        return value.contains(s);
    }

}
