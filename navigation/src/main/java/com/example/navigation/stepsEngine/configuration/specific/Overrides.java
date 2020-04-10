package com.example.navigation.stepsEngine.configuration.specific;

public class Overrides {

    private String aid;
    private boolean swipeEnabled;
    private boolean chipEnabled;
    private boolean nfcEnabled;
    private String terminalCapabilities;
    private String additionalTerminalCapabilities;

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public boolean isSwipeEnabled() {
        return swipeEnabled;
    }

    public void setSwipeEnabled(boolean swipeEnabled) {
        this.swipeEnabled = swipeEnabled;
    }

    public boolean isChipEnabled() {
        return chipEnabled;
    }

    public void setChipEnabled(boolean chipEnabled) {
        this.chipEnabled = chipEnabled;
    }

    public boolean isNfcEnabled() {
        return nfcEnabled;
    }

    public void setNfcEnabled(boolean nfcEnabled) {
        this.nfcEnabled = nfcEnabled;
    }

    public String getTerminalCapabilities() {
        return terminalCapabilities;
    }

    public void setTerminalCapabilities(String terminalCapabilities) {
        this.terminalCapabilities = terminalCapabilities;
    }

    public String getAdditionalTerminalCapabilities() {
        return additionalTerminalCapabilities;
    }

    public void setAdditionalTerminalCapabilities(String additionalTerminalCapabilities) {
        this.additionalTerminalCapabilities = additionalTerminalCapabilities;
    }

}
