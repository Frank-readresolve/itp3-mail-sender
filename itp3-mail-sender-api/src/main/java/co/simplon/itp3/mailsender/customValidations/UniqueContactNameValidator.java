package co.simplon.itp3.mailsender.customValidations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import co.simplon.itp3.mailsender.services.ContactRoleService;

public class UniqueContactNameValidator implements
	ConstraintValidator<UniqueContactName, String> {

    private final ContactRoleService service;

    public UniqueContactNameValidator(
	    ContactRoleService service) {
	this.service = service;
    }

    @Override
    public boolean isValid(String contactName,
	    ConstraintValidatorContext context) {
	if (contactName != null) {
	    return !this.service
		    .contactNameValueExists(contactName);
	}
	return true;

    }

}
