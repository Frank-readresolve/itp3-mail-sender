package co.simplon.itp3.mailsender.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class EmailTemplateDto {

    @NotBlank
    @Size(min = 1, max = 200)
    private String templateSubject;

    @NotBlank
    @Size(min = 1, max = 10000)
    private String templateBody;

    public EmailTemplateDto() {
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
	return "{templateSubject=" + templateSubject
		+ ", templateBody=" + templateBody + "}";
    }

}
