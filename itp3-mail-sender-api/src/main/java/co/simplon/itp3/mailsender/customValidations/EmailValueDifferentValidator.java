package co.simplon.itp3.mailsender.customValidations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapperImpl;

public class EmailValueDifferentValidator implements
	ConstraintValidator<EmailValueDifferent, Object> {

    private String field;
    private String fieldMatch;

    @Override
    public void initialize(
	    EmailValueDifferent constraintAnnotation) {
	this.field = constraintAnnotation.field();
	this.fieldMatch = constraintAnnotation.fieldMatch();
    }

    @Override
    public boolean isValid(Object value,
	    ConstraintValidatorContext context) {
	Object fieldValue = new BeanWrapperImpl(value)
		.getPropertyValue(field);
	Object fieldMatchValue = new BeanWrapperImpl(value)
		.getPropertyValue(fieldMatch);

	if (fieldValue != null) {
	    return !fieldValue.equals(fieldMatchValue);
	} else {
	    return fieldMatchValue == null;
	}
    }

}
