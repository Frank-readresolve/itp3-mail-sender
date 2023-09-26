package co.simplon.itp3.mailsender.dtos;

import java.util.Arrays;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import co.simplon.itp3.mailsender.customValidations.MaxSize;

public class SendAuthEmailDto {

    private String[] primaryRecipient;

    @Email
    private String cc;

    @Email
    private String bcc;

    @NotBlank
    @Email
    private String sender;

    @NotBlank
    @Pattern(regexp = "[a-zA-Z0-9\\s]+")
    @Size(min = 1, max = 100)
    private String subject;

    @NotBlank
    @Size(min = 1, max = 10000)
    private String body;

    @MaxSize(maxSizeInMB = 5)
    private String filePath;

    public SendAuthEmailDto() {

    }

    public String[] getPrimaryRecipient() {
	return primaryRecipient;
    }

    public void setPrimaryRecipient(
	    String[] primaryRecipient) {
	this.primaryRecipient = primaryRecipient;
    }

    public String getCc() {
	return cc;
    }

    public void setCc(String cc) {
	this.cc = cc;
    }

    public String getBcc() {
	return bcc;
    }

    public void setBcc(String bcc) {
	this.bcc = bcc;
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

    public String getFilePath() {
	return filePath;
    }

    public void setFilePath(String filePath) {
	this.filePath = filePath;
    }

    @Override
    public String toString() {
	return "{primaryRecipient="
		+ Arrays.toString(primaryRecipient)
		+ ", cc=" + cc + ", bcc=" + bcc
		+ ", sender=" + sender + ", subject="
		+ subject + ", body=" + body + ", filePath="
		+ filePath + "}";
    }

}
