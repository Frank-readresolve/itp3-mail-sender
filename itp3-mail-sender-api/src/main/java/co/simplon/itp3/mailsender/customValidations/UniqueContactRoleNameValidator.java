package co.simplon.itp3.mailsender.customValidations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import co.simplon.itp3.mailsender.services.ContactRoleService;

public class UniqueContactRoleNameValidator implements
	ConstraintValidator<UniqueContactRoleName, String> {

    private final ContactRoleService service;

    public UniqueContactRoleNameValidator(
	    ContactRoleService service) {
	this.service = service;
    }

    @Override
    public boolean isValid(String contactRoleName,
	    ConstraintValidatorContext context) {
	if (contactRoleName != null) {
	    return !this.service.contactRoleNameValueExists(
		    contactRoleName);
	}
	return true;

    }

}
