package com.github.jrry.pvl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * The string has to be a well-formed REGON
 *
 * @author Jarosław Pawłowski
 */
@Documented
@Constraint(validatedBy = PVL_REGONValidator.class)
@Target({METHOD, FIELD, ANNOTATION_TYPE, PARAMETER})
@Retention(RUNTIME)
public @interface PVL_REGON {
    String message() default "Incorrect REGON";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
