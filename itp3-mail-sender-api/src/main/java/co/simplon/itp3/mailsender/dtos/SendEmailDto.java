package co.simplon.itp3.mailsender.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SendEmailDto {

    @NotBlank
    @Email
    private String primaryRecipient;

    @NotBlank
    @Email
    private String sender;

    @NotNull
    @Pattern(regexp = "[a-zA-Z0-9\\s]+")
    @Size(max = 100)
    private String subject;

    @NotNull
    @Pattern(regexp = "[a-zA-Z0-9\\s]+")
    @Size(max = 1000)
    private String body;

    public String getPrimaryRecipient() {
	return primaryRecipient;
    }

    public void setPrimaryRecipient(
	    String primaryRecipient) {
	this.primaryRecipient = primaryRecipient;
    }

    public String getSender() {
	return sender;
    }

    public void setSender(String sender) {
	this.sender = sender;
    }

    public String getSubject() {
	return subject;
    }

    public void setSubject(String subject) {
	this.subject = subject;
    }

    public String getBody() {
	return body;
    }

    public void setBody(String body) {
	this.body = body;
    }

    @Override
    public String toString() {
	return "{primaryRecipient=" + primaryRecipient
		+ ", sender=" + sender + ", subject="
		+ subject + ", body=" + body + "}";
    }

}
