package br.com.solidsign.validation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/** Validation report for a single signed document. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ValidationResponseDTO {
    /**
     * Overall validation conclusion for the document.
     * Values: TOTAL_PASSED | PASSED | INDETERMINATE | FAILED
     */
    private String globalIndication;
    private int qtyOfSignatures;
    /** PDF/A conformance level (e.g. 1B, 2A, 3B). Null if the document is not PDF/A compliant. */
    private String pdfAProfile;
    private List<String> pdfAValidationErrors;
    /** Per-signature validation details. */
    private List<SignatureDetailDTO> signatures;
    /** PDF information dictionary metadata (null for non-PDF documents). */
    private InfoDocMetadataDTO documentMetadata;

    public String getGlobalIndication()    { return globalIndication; }
    public void setGlobalIndication(String v)    { this.globalIndication = v; }
    public int getQtyOfSignatures()        { return qtyOfSignatures; }
    public void setQtyOfSignatures(int v)        { this.qtyOfSignatures = v; }
    public String getPdfAProfile()         { return pdfAProfile; }
    public void setPdfAProfile(String v)         { this.pdfAProfile = v; }
    public List<String> getPdfAValidationErrors() { return pdfAValidationErrors; }
    public void setPdfAValidationErrors(List<String> v) { this.pdfAValidationErrors = v; }
    public List<SignatureDetailDTO> getSignatures() { return signatures; }
    public void setSignatures(List<SignatureDetailDTO> v)   { this.signatures = v; }
    public InfoDocMetadataDTO getDocumentMetadata() { return documentMetadata; }
    public void setDocumentMetadata(InfoDocMetadataDTO v)   { this.documentMetadata = v; }
}

