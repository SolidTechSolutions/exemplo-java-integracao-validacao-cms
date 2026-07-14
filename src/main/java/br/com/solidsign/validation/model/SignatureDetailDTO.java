package br.com.solidsign.validation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.OffsetDateTime;
import java.util.List;

/** Detailed validation result for a single digital signature within a document. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SignatureDetailDTO {
    /** Zero-based position of this signature in the document. */
    private int signatureIndex;
    private String signatureId;
    /**
     * Overall cryptographic validation result.
     * Values: TOTAL_PASSED | PASSED | INDETERMINATE | FAILED
     */
    private String indication;
    /** Reason for INDETERMINATE or FAILED (e.g. NO_CERTIFICATE_CHAIN_FOUND). */
    private String subIndication;
    /** ICP-Brasil / ETSI compliance profile (e.g. AD-RB, AD-RT, PAdES-LT). */
    private String complianceProfile;
    /** QUALIFICADA (ICP-Brasil) or AVANCADA. */
    private String signatureType;
    /** INTERNATIONAL | ETSI | PBAD */
    private String signatureStandard;
    /** AD-RB | AD-RT | AD-RC | AD-RA | AD-RV (only when signatureType = QUALIFICADA). */
    private String icpBrasilProfile;
    private OffsetDateTime signingTime;
    /** Whether the signed content has not been tampered with. */
    private Boolean dataIntact;
    private Boolean validCertificate;
    private Boolean validAsymetricCryptography;
    private Boolean validSignatureAcceptance;
    private Boolean signaturePolicyImplied;
    private String signatureAlgorithm;
    private String digestAlgorithm;
    /** PDF: /Reason entry in the signature dictionary. */
    private String reason;
    /** PDF: /Location entry in the signature dictionary. */
    private String location;
    /** PDF: /ContactInfo entry in the signature dictionary. */
    private String contactInfo;
    /** PDF: /Filter entry (e.g. Adobe.PPKLite). */
    private String filter;
    /** PDF: /SubFilter entry (e.g. ETSI.CAdES.detached). */
    private String subFilter;
    private SignaturePolicyDTO signaturePolicyInformation;
    private CertificateDetailDTO signingCertificateValidation;
    private List<CertificateDetailDTO> chainCertificatesValidation;
    private List<TimestampDetailDTO> timestamps;
    private LTMessagesDTO longTermValidation;
    private List<DssVerifyMessageDTO> signatureErrors;
    private List<DssVerifyMessageDTO> signatureWarnings;
    private List<DssVerifyMessageDTO> signatureInfos;

    public int getSignatureIndex()          { return signatureIndex; }
    public void setSignatureIndex(int v)          { this.signatureIndex = v; }
    public String getSignatureId()          { return signatureId; }
    public void setSignatureId(String v)          { this.signatureId = v; }
    public String getIndication()           { return indication; }
    public void setIndication(String v)           { this.indication = v; }
    public String getSubIndication()        { return subIndication; }
    public void setSubIndication(String v)        { this.subIndication = v; }
    public String getComplianceProfile()    { return complianceProfile; }
    public void setComplianceProfile(String v)    { this.complianceProfile = v; }
    public String getSignatureType()        { return signatureType; }
    public void setSignatureType(String v)        { this.signatureType = v; }
    public String getSignatureStandard()    { return signatureStandard; }
    public void setSignatureStandard(String v)    { this.signatureStandard = v; }
    public String getIcpBrasilProfile()     { return icpBrasilProfile; }
    public void setIcpBrasilProfile(String v)     { this.icpBrasilProfile = v; }
    public OffsetDateTime getSigningTime()  { return signingTime; }
    public void setSigningTime(OffsetDateTime v)  { this.signingTime = v; }
    public Boolean getDataIntact()          { return dataIntact; }
    public void setDataIntact(Boolean v)          { this.dataIntact = v; }
    public Boolean getValidCertificate()    { return validCertificate; }
    public void setValidCertificate(Boolean v)    { this.validCertificate = v; }
    public Boolean getValidAsymetricCryptography() { return validAsymetricCryptography; }
    public void setValidAsymetricCryptography(Boolean v) { this.validAsymetricCryptography = v; }
    public Boolean getValidSignatureAcceptance()   { return validSignatureAcceptance; }
    public void setValidSignatureAcceptance(Boolean v)   { this.validSignatureAcceptance = v; }
    public Boolean getSignaturePolicyImplied() { return signaturePolicyImplied; }
    public void setSignaturePolicyImplied(Boolean v) { this.signaturePolicyImplied = v; }
    public String getSignatureAlgorithm()   { return signatureAlgorithm; }
    public void setSignatureAlgorithm(String v)   { this.signatureAlgorithm = v; }
    public String getDigestAlgorithm()      { return digestAlgorithm; }
    public void setDigestAlgorithm(String v)      { this.digestAlgorithm = v; }
    public String getReason()               { return reason; }
    public void setReason(String v)               { this.reason = v; }
    public String getLocation()             { return location; }
    public void setLocation(String v)             { this.location = v; }
    public String getContactInfo()          { return contactInfo; }
    public void setContactInfo(String v)          { this.contactInfo = v; }
    public String getFilter()               { return filter; }
    public void setFilter(String v)               { this.filter = v; }
    public String getSubFilter()            { return subFilter; }
    public void setSubFilter(String v)            { this.subFilter = v; }
    public SignaturePolicyDTO getSignaturePolicyInformation() { return signaturePolicyInformation; }
    public void setSignaturePolicyInformation(SignaturePolicyDTO v) { this.signaturePolicyInformation = v; }
    public CertificateDetailDTO getSigningCertificateValidation() { return signingCertificateValidation; }
    public void setSigningCertificateValidation(CertificateDetailDTO v) { this.signingCertificateValidation = v; }
    public List<CertificateDetailDTO> getChainCertificatesValidation() { return chainCertificatesValidation; }
    public void setChainCertificatesValidation(List<CertificateDetailDTO> v) { this.chainCertificatesValidation = v; }
    public List<TimestampDetailDTO> getTimestamps() { return timestamps; }
    public void setTimestamps(List<TimestampDetailDTO> v)   { this.timestamps = v; }
    public LTMessagesDTO getLongTermValidation() { return longTermValidation; }
    public void setLongTermValidation(LTMessagesDTO v) { this.longTermValidation = v; }
    public List<DssVerifyMessageDTO> getSignatureErrors()   { return signatureErrors; }
    public void setSignatureErrors(List<DssVerifyMessageDTO> v)   { this.signatureErrors = v; }
    public List<DssVerifyMessageDTO> getSignatureWarnings() { return signatureWarnings; }
    public void setSignatureWarnings(List<DssVerifyMessageDTO> v) { this.signatureWarnings = v; }
    public List<DssVerifyMessageDTO> getSignatureInfos()    { return signatureInfos; }
    public void setSignatureInfos(List<DssVerifyMessageDTO> v)    { this.signatureInfos = v; }
}

