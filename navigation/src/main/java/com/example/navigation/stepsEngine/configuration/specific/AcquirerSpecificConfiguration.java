package com.example.navigation.stepsEngine.configuration.specific;

import com.example.navigation.stepsEngine.enums.Acquirer;

import java.util.List;

public class AcquirerSpecificConfiguration {

    private Acquirer acquirer;
    private List<Overrides> overrides;

    public Acquirer getAcquirer() {
        return acquirer;
    }

    public void setAcquirer(Acquirer acquirer) {
        this.acquirer = acquirer;
    }

    public List<Overrides> getOverrides() {
        return overrides;
    }

    public void setOverrides(List<Overrides> overrides) {
        this.overrides = overrides;
    }

}
