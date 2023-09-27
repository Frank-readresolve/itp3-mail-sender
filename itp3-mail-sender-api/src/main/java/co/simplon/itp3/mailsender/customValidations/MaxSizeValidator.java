package co.simplon.itp3.mailsender.customValidations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MaxSizeValidator
	implements ConstraintValidator<MaxSize, String> {

    private static final long MB = 1024 * 1024;

    private long maxSizeInMB;

    @Override
    public void initialize(MaxSize maxSize) {
	this.maxSizeInMB = maxSize.maxSizeInMB();
    }

    @Override
    public boolean isValid(String filePath,
	    ConstraintValidatorContext constraintValidatorContext) {

	if (filePath == null) {
	    return true;
	}

	return filePath.length() < (maxSizeInMB * MB);
    }
}