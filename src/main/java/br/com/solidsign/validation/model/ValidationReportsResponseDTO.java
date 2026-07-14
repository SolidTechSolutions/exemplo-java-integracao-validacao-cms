package br.com.solidsign.validation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/** Aggregated validation result for a batch of one or more signed documents. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ValidationReportsResponseDTO {
    private int documentCount;
    /** Per-document validation report list. One entry per submitted signed file. */
    private List<ValidationResponseDTO> documentValidations;

    public int getDocumentCount()                  { return documentCount; }
    public void setDocumentCount(int v)                  { this.documentCount = v; }
    public List<ValidationResponseDTO> getDocumentValidations() { return documentValidations; }
    public void setDocumentValidations(List<ValidationResponseDTO> v) { this.documentValidations = v; }
}

