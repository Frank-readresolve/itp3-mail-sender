package co.simplon.itp3.mailsender.customValidations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import co.simplon.itp3.mailsender.services.CustomerService;

public class UniqueEmailValidator implements
	ConstraintValidator<UniqueEmail, String> {

    private CustomerService service;

    public UniqueEmailValidator(CustomerService service) {
	this.service = service;
    }

    @Override
    public boolean isValid(String email,
	    ConstraintValidatorContext context) {

	return !this.service.emailValueExists(email);
    }
};
