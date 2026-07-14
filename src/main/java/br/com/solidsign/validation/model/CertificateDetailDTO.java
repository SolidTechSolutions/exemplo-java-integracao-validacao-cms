package br.com.solidsign.validation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.OffsetDateTime;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CertificateDetailDTO {
    private String certificateId;
    /** Overall certificate status (e.g. PASSED, INDETERMINATE, FAILED). */
    private String certificateStatus;
    private String certificateSubStatus;
    /** Certificate type as classified by SolidSign (e.g. QUALIFIED, ICP-BRASIL). */
    private String certificateType;
    private String subjectName;
    private String commonName;
    private String email;
    private String issuerName;
    private String serialNumber;
    private OffsetDateTime notBefore;
    private OffsetDateTime notAfter;
    private String organization;
    private String encryptionAlgo;
    private Boolean selfSigned;
    private List<DssVerifyMessageDTO> errors;
    private List<DssVerifyMessageDTO> warnings;
    private List<DssVerifyMessageDTO> infos;

    public String getCertificateId()       { return certificateId; }
    public void setCertificateId(String v)       { this.certificateId = v; }
    public String getCertificateStatus()   { return certificateStatus; }
    public void setCertificateStatus(String v)   { this.certificateStatus = v; }
    public String getCertificateSubStatus(){ return certificateSubStatus; }
    public void setCertificateSubStatus(String v){ this.certificateSubStatus = v; }
    public String getCertificateType()     { return certificateType; }
    public void setCertificateType(String v)     { this.certificateType = v; }
    public String getSubjectName()         { return subjectName; }
    public void setSubjectName(String v)         { this.subjectName = v; }
    public String getCommonName()          { return commonName; }
    public void setCommonName(String v)          { this.commonName = v; }
    public String getEmail()               { return email; }
    public void setEmail(String v)               { this.email = v; }
    public String getIssuerName()          { return issuerName; }
    public void setIssuerName(String v)          { this.issuerName = v; }
    public String getSerialNumber()        { return serialNumber; }
    public void setSerialNumber(String v)        { this.serialNumber = v; }
    public OffsetDateTime getNotBefore()   { return notBefore; }
    public void setNotBefore(OffsetDateTime v)   { this.notBefore = v; }
    public OffsetDateTime getNotAfter()    { return notAfter; }
    public void setNotAfter(OffsetDateTime v)    { this.notAfter = v; }
    public String getOrganization()        { return organization; }
    public void setOrganization(String v)        { this.organization = v; }
    public String getEncryptionAlgo()      { return encryptionAlgo; }
    public void setEncryptionAlgo(String v)      { this.encryptionAlgo = v; }
    public Boolean getSelfSigned()         { return selfSigned; }
    public void setSelfSigned(Boolean v)         { this.selfSigned = v; }
    public List<DssVerifyMessageDTO> getErrors()   { return errors; }
    public void setErrors(List<DssVerifyMessageDTO> v)   { this.errors = v; }
    public List<DssVerifyMessageDTO> getWarnings() { return warnings; }
    public void setWarnings(List<DssVerifyMessageDTO> v) { this.warnings = v; }
    public List<DssVerifyMessageDTO> getInfos()    { return infos; }
    public void setInfos(List<DssVerifyMessageDTO> v)    { this.infos = v; }
}

