package br.com.solidsign.validation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** Information about the signature policy declared in the signature (if any). */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SignaturePolicyDTO {
    /** Policy URI (SPURI). For ICP-Brasil: http://politicas.icpbrasil.gov.br/pa-... */
    private String spuri;
    /** Policy OID (e.g. 2.16.76.1.7.1.1.2.3 for AD-RT). */
    private String oid;
    private String defaultHashAlg;
    /** Whether the embedded policy hash matches the downloaded policy document. */
    private Boolean hashValidMatch;

    public String getSpuri()           { return spuri; }
    public void setSpuri(String v)           { this.spuri = v; }
    public String getOid()             { return oid; }
    public void setOid(String v)             { this.oid = v; }
    public String getDefaultHashAlg()  { return defaultHashAlg; }
    public void setDefaultHashAlg(String v)  { this.defaultHashAlg = v; }
    public Boolean getHashValidMatch() { return hashValidMatch; }
    public void setHashValidMatch(Boolean v) { this.hashValidMatch = v; }
}

