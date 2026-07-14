package br.com.solidsign.validation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/** Long-Term Validation (LTV) result embedded in the signature. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LTMessagesDTO {
    private String ltMessagesId;
    /** Signature format (e.g. CAdES, PAdES). */
    private String format;
    /** Overall LTV indication: PASSED, INDETERMINATE or FAILED. */
    private String indication;
    private String subIndication;
    private List<DssVerifyMessageDTO> errors;
    private List<DssVerifyMessageDTO> warnings;
    private List<DssVerifyMessageDTO> infos;

    public String getLtMessagesId() { return ltMessagesId; }
    public void setLtMessagesId(String v) { this.ltMessagesId = v; }
    public String getFormat()       { return format; }
    public void setFormat(String v)       { this.format = v; }
    public String getIndication()   { return indication; }
    public void setIndication(String v)   { this.indication = v; }
    public String getSubIndication(){ return subIndication; }
    public void setSubIndication(String v){ this.subIndication = v; }
    public List<DssVerifyMessageDTO> getErrors()   { return errors; }
    public void setErrors(List<DssVerifyMessageDTO> v)   { this.errors = v; }
    public List<DssVerifyMessageDTO> getWarnings() { return warnings; }
    public void setWarnings(List<DssVerifyMessageDTO> v) { this.warnings = v; }
    public List<DssVerifyMessageDTO> getInfos()    { return infos; }
    public void setInfos(List<DssVerifyMessageDTO> v)    { this.infos = v; }
}

