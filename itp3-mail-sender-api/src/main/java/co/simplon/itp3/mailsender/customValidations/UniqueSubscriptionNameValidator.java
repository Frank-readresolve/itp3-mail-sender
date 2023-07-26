package co.simplon.itp3.mailsender.customValidations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import co.simplon.itp3.mailsender.services.SubscriptionService;

public class UniqueSubscriptionNameValidator implements
	ConstraintValidator<UniqueSubscriptionName, String> {

    private final SubscriptionService service;

    public UniqueSubscriptionNameValidator(
	    SubscriptionService service) {
	this.service = service;
    }

    @Override
    public boolean isValid(String subscriptionName,
	    ConstraintValidatorContext context) {
	if (subscriptionName != null) {
	    return !this.service.subscriptionNameValueExist(
		    subscriptionName);
	}
	return true;
    }

}
