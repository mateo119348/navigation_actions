package com.example.navigation.stepsEngine.payment.card;

public class FinishTransaction {

    private String secondGenEMVData;
    private String issuerScriptsResults;

    public String getSecondGenEMVData() {
        return secondGenEMVData;
    }

    public void setSecondGenEMVData(String secondGenEMVData) {
        this.secondGenEMVData = secondGenEMVData;
    }

    public String getIssuerScriptsResults() {
        return issuerScriptsResults;
    }

    public void setIssuerScriptsResults(String issuerScriptsResults) {
        this.issuerScriptsResults = issuerScriptsResults;
    }

}
