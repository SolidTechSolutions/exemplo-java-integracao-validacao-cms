package br.com.solidsign.validation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.OffsetDateTime;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TimestampDetailDTO {
    private int timestampIndex;
    private String timestampId;
    /** Timestamp type (e.g. SIGNATURE_TIMESTAMP, ARCHIVE_TIMESTAMP). */
    private String type;
    /** Validation indication: PASSED, INDETERMINATE or FAILED. */
    private String indication;
    private String subIndication;
    private Boolean validCertificate;
    private Boolean validAsymetricCryptography;
    private Boolean validSignatureAcceptance;
    private Boolean dataIntact;
    private OffsetDateTime productionTime;
    private OffsetDateTime validUntil;
    private CertificateDetailDTO signingCertificateValidation;
    private List<DssVerifyMessageDTO> timestampErrors;
    private List<DssVerifyMessageDTO> timestampWarnings;
    private List<DssVerifyMessageDTO> timestampInfos;

    public int getTimestampIndex()      { return timestampIndex; }
    public void setTimestampIndex(int v)      { this.timestampIndex = v; }
    public String getTimestampId()      { return timestampId; }
    public void setTimestampId(String v)      { this.timestampId = v; }
    public String getType()             { return type; }
    public void setType(String v)             { this.type = v; }
    public String getIndication()       { return indication; }
    public void setIndication(String v)       { this.indication = v; }
    public String getSubIndication()    { return subIndication; }
    public void setSubIndication(String v)    { this.subIndication = v; }
    public Boolean getValidCertificate() { return validCertificate; }
    public void setValidCertificate(Boolean v){ this.validCertificate = v; }
    public Boolean getValidAsymetricCryptography() { return validAsymetricCryptography; }
    public void setValidAsymetricCryptography(Boolean v) { this.validAsymetricCryptography = v; }
    public Boolean getValidSignatureAcceptance() { return validSignatureAcceptance; }
    public void setValidSignatureAcceptance(Boolean v) { this.validSignatureAcceptance = v; }
    public Boolean getDataIntact()      { return dataIntact; }
    public void setDataIntact(Boolean v)      { this.dataIntact = v; }
    public OffsetDateTime getProductionTime() { return productionTime; }
    public void setProductionTime(OffsetDateTime v) { this.productionTime = v; }
    public OffsetDateTime getValidUntil()     { return validUntil; }
    public void setValidUntil(OffsetDateTime v)     { this.validUntil = v; }
    public CertificateDetailDTO getSigningCertificateValidation() { return signingCertificateValidation; }
    public void setSigningCertificateValidation(CertificateDetailDTO v) { this.signingCertificateValidation = v; }
    public List<DssVerifyMessageDTO> getTimestampErrors()   { return timestampErrors; }
    public void setTimestampErrors(List<DssVerifyMessageDTO> v)   { this.timestampErrors = v; }
    public List<DssVerifyMessageDTO> getTimestampWarnings() { return timestampWarnings; }
    public void setTimestampWarnings(List<DssVerifyMessageDTO> v) { this.timestampWarnings = v; }
    public List<DssVerifyMessageDTO> getTimestampInfos()    { return timestampInfos; }
    public void setTimestampInfos(List<DssVerifyMessageDTO> v)    { this.timestampInfos = v; }
}

