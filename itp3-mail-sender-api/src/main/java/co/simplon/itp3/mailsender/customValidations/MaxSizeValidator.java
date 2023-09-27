package co.simplon.itp3.mailsender.customValidations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.web.multipart.MultipartFile;

public class MaxSizeValidator implements
	ConstraintValidator<MaxSize, MultipartFile> {

    private static final long MB = 1024 * 1024;

    private long maxSizeInMB;

    @Override
    public void initialize(MaxSize maxSize) {
	this.maxSizeInMB = maxSize.maxSizeInMB();
    }

    @Override
    public boolean isValid(MultipartFile file,
	    ConstraintValidatorContext constraintValidatorContext) {

	if (file == null) {
	    return true;
	}

	return file.getSize() < (maxSizeInMB * MB);
    }
}