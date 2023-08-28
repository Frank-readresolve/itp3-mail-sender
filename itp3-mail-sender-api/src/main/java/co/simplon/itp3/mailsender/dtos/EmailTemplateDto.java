package co.simplon.itp3.mailsender.dtos;

import javax.validation.constraints.NotBlank;

import co.simplon.itp3.mailsender.customValidations.UniqueTemplateIdentifier;

public class EmailTemplateDto {

    @NotBlank
    @UniqueTemplateIdentifier
    private String templateIdentifier;

    @NotBlank
    private String templateSubject;

    @NotBlank
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
