package co.simplon.itp3.mailsender.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "mail_trackers")
public class MailTracker extends AbstractEntity {

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Column(name = "body_length")
    private int bodyLength;

    @Column(name = "subject_length")
    private int subjectLength;

    @Column(name = "success")
    private Boolean success;

    @Column(name = "message")
    private String message;

    public LocalDateTime getDateTime() {
	return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
	this.dateTime = dateTime;
    }

    public int getBodyLength() {
	return bodyLength;
    }

    public void setBodyLength(int bodyLength) {
	this.bodyLength = bodyLength;
    }

    public int getSubjectLength() {
	return subjectLength;
    }

    public void setSubjectLength(int subjectLength) {
	this.subjectLength = subjectLength;
    }

    public Boolean getSuccess() {
	return success;
    }

    public void setSuccess(Boolean success) {
	this.success = success;
    }

    public String getMessage() {
	return message;
    }

    public void setMessage(String message) {
	this.message = message;
    }

    @Override
    public String toString() {
	return "{dateTime=" + dateTime + ", bodyLength="
		+ bodyLength + ", subjectLength="
		+ subjectLength + ", success=" + success
		+ ", message=" + message + "}";
    }

}
