package br.com.solidsign.validation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Map;

/** PDF document information dictionary extracted from the validated document. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InfoDocMetadataDTO {
    private String title;
    private String author;
    private String subject;
    private String keywords;
    private String creator;
    private String producer;
    private String creationDate;
    private String modDate;
    /** Custom (non-standard) PDF metadata entries, including OID-keyed fields (e.g. Brazilian medical prescriptions). */
    private Map<String, String> customEntries;

    public String getTitle()       { return title; }
    public void setTitle(String v)       { this.title = v; }
    public String getAuthor()      { return author; }
    public void setAuthor(String v)      { this.author = v; }
    public String getSubject()     { return subject; }
    public void setSubject(String v)     { this.subject = v; }
    public String getKeywords()    { return keywords; }
    public void setKeywords(String v)    { this.keywords = v; }
    public String getCreator()     { return creator; }
    public void setCreator(String v)     { this.creator = v; }
    public String getProducer()    { return producer; }
    public void setProducer(String v)    { this.producer = v; }
    public String getCreationDate(){ return creationDate; }
    public void setCreationDate(String v){ this.creationDate = v; }
    public String getModDate()     { return modDate; }
    public void setModDate(String v)     { this.modDate = v; }
    public Map<String, String> getCustomEntries() { return customEntries; }
    public void setCustomEntries(Map<String, String> v) { this.customEntries = v; }
}

