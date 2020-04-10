package com.example.navigation.stepsEngine.configuration.table;

import java.util.List;

public class Table {

    private String version;
    private List<ApplicationIdentifier> applicationIdentifiers;
    private List<CertificateAuthorityPublicKey> certificateAuthorityPublicKeys;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<ApplicationIdentifier> getApplicationIdentifiers() {
        return applicationIdentifiers;
    }

    public void setApplicationIdentifiers(List<ApplicationIdentifier> applicationIdentifiers) {
        this.applicationIdentifiers = applicationIdentifiers;
    }

    public List<CertificateAuthorityPublicKey> getCertificateAuthorityPublicKeys() {
        return certificateAuthorityPublicKeys;
    }

    public void setCertificateAuthorityPublicKeys(List<CertificateAuthorityPublicKey> certificateAuthorityPublicKeys) {
        this.certificateAuthorityPublicKeys = certificateAuthorityPublicKeys;
    }

}
