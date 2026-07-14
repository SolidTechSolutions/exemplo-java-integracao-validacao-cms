package br.com.solidsign.validation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DssVerifyMessageDTO {
    private String messageKey;
    private String messageValue;

    public String getMessageKey()   { return messageKey; }
    public void setMessageKey(String v)   { this.messageKey = v; }
    public String getMessageValue() { return messageValue; }
    public void setMessageValue(String v) { this.messageValue = v; }

    @Override
    public String toString() { return messageKey + ": " + messageValue; }
}

