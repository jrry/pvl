package com.github.jrry.pvl;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * The string has to be a well-formed email with check server exist
 * 
 * 
 * @author Jarosław Pawłowski
 */
@Documented
@Constraint(validatedBy = PVL_EmailValidator.class)
@Target({ METHOD, FIELD, ANNOTATION_TYPE, PARAMETER })
@Retention(RUNTIME)
public @interface PVL_Email {
	String message() default "Incorrect email adress";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
