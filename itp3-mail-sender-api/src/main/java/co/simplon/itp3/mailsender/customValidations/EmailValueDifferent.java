package co.simplon.itp3.mailsender.customValidations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
@Constraint(validatedBy = EmailValueDifferentValidator.class)
public @interface EmailValueDifferent {
    String message() default "from/reply to email and contact email must be different";

    String field();

    String fieldMatch();

    @interface List {
	EmailValueDifferent[] value();
    }
}
