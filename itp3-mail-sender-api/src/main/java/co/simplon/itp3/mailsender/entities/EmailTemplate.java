package co.simplon.itp3.mailsender.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "email_templates")
public class EmailTemplate extends AbstractEntity {

    @Column(name = "template_identifier")
    private String templateIdentifier;
    @Column(name = "template_subject")
    private String templateSubject;
    @Column(name = "template_body")
    private String templateBody;

    public String getTemplateIdentifier() {
	return templateIdentifier;
    }

    public void setTemplateIdentifier(
	    String templateIdentifier) {
	this.templateIdentifier = templateIdentifier;
    }

    public String getTemplateSubject() {
	return templateSubject;
    }

    public void setTemplateSubject(String templateSubject) {
	this.templateSubject = templateSubject;
    }

    public String getTemplateBody() {
	return templateBody;
    }

    public void setTemplateBody(String templateBody) {
	this.templateBody = templateBody;
    }

    @Override
    public String toString() {
	return "{templateIdentifier=" + templateIdentifier
		+ ", templateSubject=" + templateSubject
		+ ", templateBody=" + templateBody + "}";
    }

}
