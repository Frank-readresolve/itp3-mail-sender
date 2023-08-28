package co.simplon.itp3.mailsender.customValidations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import co.simplon.itp3.mailsender.services.EmailTemplateService;

public class UniqueTemplateIdentifierValidator implements
	ConstraintValidator<UniqueTemplateIdentifier, String> {

    private final EmailTemplateService service;

    public UniqueTemplateIdentifierValidator(
	    EmailTemplateService service) {
	this.service = service;
    }

    @Override
    public boolean isValid(String templateIdentifier,
	    ConstraintValidatorContext context) {
	if (templateIdentifier != null) {
	    return !this.service.templateIdentifierExists(
		    templateIdentifier);
	}
	return true;
    }

}
