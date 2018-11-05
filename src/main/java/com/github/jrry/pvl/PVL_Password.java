package com.github.jrry.pvl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * The string has to be a well-formed password
 *
 * @author Jarosław Pawłowski
 */
@Documented
@Constraint(validatedBy = PVL_PasswordValidator.class)
@Target({METHOD, FIELD, ANNOTATION_TYPE, PARAMETER})
@Retention(RUNTIME)
public @interface PVL_Password {
    String message() default "Password must not be null";
    int min() default 6;
    int max() default 25;
    String characters() default "!@#$%^&*()_-+=?.,";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
