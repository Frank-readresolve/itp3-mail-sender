package co.simplon.itp3.mailsender.customValidations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import co.simplon.itp3.mailsender.services.ContactRoleService;

public class UniqueRoleCodeValidator implements
	ConstraintValidator<UniqueRoleCode, String> {

    private final ContactRoleService service;

    public UniqueRoleCodeValidator(
	    ContactRoleService service) {

	this.service = service;
    }

    @Override
    public boolean isValid(String roleCode,
	    ConstraintValidatorContext context) {
	if (roleCode != null) {
	    return !this.service
		    .roleCodeValueExists(roleCode);
	}
	return true;
    }
}
