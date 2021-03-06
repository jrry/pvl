package com.github.jrry.pvl;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static java.util.Objects.isNull;

public class PVL_PasswordValidator implements ConstraintValidator<PVL_Password, String> {
    private int min;
    private int max;
    private String characters;

    private boolean isUppercaseLetter = false;
    private boolean isLowercaseLetter = false;
    private boolean isDigit = false;
    private boolean isSpecialCharacter = false;

    @Override
    public void initialize(PVL_Password constraintAnnotation) {
        min = constraintAnnotation.min();
        max = constraintAnnotation.max();
        characters = constraintAnnotation.characters();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (isNull(value) || !isCorrectLength(value, context))
            return false;
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            if (c > 64 && c < 91)
                isUppercaseLetter = true;
            else if (c > 96 && c < 123)
                isLowercaseLetter = true;
            else if (c > 47 && c < 58)
                isDigit = true;
            else if (StringUtils.containsAny(String.valueOf(c), characters))
                isSpecialCharacter = true;
            else {
                message(context, "Invalid character '" + c + "'. Password must contain at least one special characters: " + characters);
                return false;
            }
        }
        return isCorrectCharacters(context);
    }

    private boolean isCorrectLength(String value, ConstraintValidatorContext context) {
        if (value.length() < min || value.length() > max) {
            message(context, "Password must have length: " + min + " - " + max);
            return false;
        }
        return true;
    }

    private boolean isCorrectCharacters(ConstraintValidatorContext context) {
        if (!isUppercaseLetter) {
            message(context, "Password must contain at least one uppercase letter");
            return false;
        }
        if (!isLowercaseLetter) {
            message(context, "Password must contain at least one lowercase letter");
            return false;
        }
        if (!isDigit) {
            message(context, "Password must contain at least one digit");
            return false;
        }
        if (!isSpecialCharacter) {
            message(context, "Password must contain at least one special characters: " + characters);
            return false;
        }
        return true;
    }

    private void message(ConstraintValidatorContext context, String text) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(text).addConstraintViolation();
    }
}
