package com.github.jrry.pvl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigInteger;
import java.util.regex.Pattern;

/**
 * The Class PVL_IBANValidator.
 *
 * @author Jarosław Pawłowski
 */
public class PVL_IBANValidator implements ConstraintValidator<PVL_IBAN, String> {

    private static Pattern pattern = Pattern.compile("^[A-Z]{2}[0-9]{26}$", Pattern.CASE_INSENSITIVE);

    @Override
    public void initialize(PVL_IBAN constraintAnnotation) {}

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null || !pattern.matcher(value).matches())
            return false;

        String first = value.substring(2,4);
        String second = value.substring(4);
        int temp = value.charAt(0) - '7';
        second += temp;
        temp = value.charAt(1) - '7';
        second += temp;
        second += first;
        BigInteger number = new BigInteger(second);

        return number.mod(BigInteger.valueOf(97L)).equals(BigInteger.ONE);
    }
}
