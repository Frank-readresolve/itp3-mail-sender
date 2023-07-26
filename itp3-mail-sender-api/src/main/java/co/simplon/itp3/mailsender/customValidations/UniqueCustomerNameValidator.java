package co.simplon.itp3.mailsender.customValidations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import co.simplon.itp3.mailsender.services.CustomerService;

public class UniqueCustomerNameValidator implements
	ConstraintValidator<UniqueCustomerName, String> {

    private CustomerService service;

    public UniqueCustomerNameValidator(
	    CustomerService service) {
	this.service = service;
    }

    @Override
    public boolean isValid(String customerName,
	    ConstraintValidatorContext context) {
	return !this.service
		.customerNameValueExist(customerName);
    }

}
