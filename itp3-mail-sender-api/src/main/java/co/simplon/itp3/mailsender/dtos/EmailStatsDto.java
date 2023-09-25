package co.simplon.itp3.mailsender.dtos;

public class EmailStatsDto {

    private long sentEmails;

    private long successfullySentEmails;

    private long unssuccessfullySentEmails;

    private long maxLengthBody;

    private long maxLengthSubject;

    public long getSentEmails() {
	return sentEmails;
    }

    public void setSentEmails(long sentEmails) {
	this.sentEmails = sentEmails;
    }

    public long getSuccessfullySentEmails() {
	return successfullySentEmails;
    }

    public void setSuccessfullySentEmails(
	    long successfullySentEmails) {
	this.successfullySentEmails = successfullySentEmails;
    }

    public long getUnssuccessfullySentEmails() {
	return unssuccessfullySentEmails;
    }

    public void setUnssuccessfullySentEmails(
	    long unssuccessfullySentEmails) {
	this.unssuccessfullySentEmails = unssuccessfullySentEmails;
    }

    public long getMaxLengthBody() {
	return maxLengthBody;
    }

    public void setMaxLengthBody(long maxLengthBody) {
	this.maxLengthBody = maxLengthBody;
    }

    public long getMaxLengthSubject() {
	return maxLengthSubject;
    }

    public void setMaxLengthSubject(long maxLengthSubject) {
	this.maxLengthSubject = maxLengthSubject;
    }

    @Override
    public String toString() {
	return "{sentEmails=" + sentEmails
		+ ", successfullySentEmails="
		+ successfullySentEmails
		+ ", unssuccessfullySentEmails="
		+ unssuccessfullySentEmails
		+ ", maxLengthBody=" + maxLengthBody
		+ ", maxLengthSubject=" + maxLengthSubject
		+ "}";
    }
}
