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
    private String CcRecipient;

    @Email
    private String BccRecipient;

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

    public String getCcRecipient() {
	return CcRecipient;
    }

    public void setCcRecipient(String ccRecipient) {
	CcRecipient = ccRecipient;
    }

    public String getBccRecipient() {
	return BccRecipient;
    }

    public void setBccRecipient(String bccRecipient) {
	BccRecipient = bccRecipient;
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
		+ ", CcRecipient=" + CcRecipient
		+ ", BccRecipient=" + BccRecipient
		+ ", sender=" + sender + ", subject="
		+ subject + ", body=" + body + ", filePath="
		+ filePath + "}";
    }

}
