package co.simplon.itp3.mailsender.customValidations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import co.simplon.itp3.mailsender.dtos.CreateCustomerDto;

public class EmailValueDifferentValidator implements
	ConstraintValidator<EmailValueDifferent, CreateCustomerDto> {

    @Override
    public boolean isValid(CreateCustomerDto inputs,
	    ConstraintValidatorContext context) {
	String fieldValue = inputs.getContactEmail();
	String fieldMatchValue = inputs.getFromReplyTo();

	if (fieldValue != null) {
	    return !fieldValue.equals(fieldMatchValue);
	} else {
	    return fieldMatchValue == null;
	}
    }

}
