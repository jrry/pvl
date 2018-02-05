package com.github.jrry.pvl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * The Class PVL_IdentityCardValidator.
 *
 * @author Jarosław Pawłowski
 */
public class PVL_IdentityCardValidator implements ConstraintValidator<PVL_IdentityCard, String> {

    private static final int[] tab = {7, 3, 1};

    @Override
    public void initialize(PVL_IdentityCard constraintAnnotation) {}

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || !value.matches("[A-Z]{3}[0-9]{6}"))
            return false;

        char[] series, number;
        int sum = 0;

        series = value.substring(0, 3).toCharArray();
        number = value.substring(3).toCharArray();

        for (int i = 0; i < series.length; i++) {
            series[i] = (char) ((series[i] - '7') * tab[i % 3]);
            sum += series[i];
        }

        number[0] -= '0';

        for (int i = 0; i < number.length - 1; i++) {
            number[i + 1] = (char) ((number[i + 1] - '0') * tab[i % 3]);
            sum += number[i + 1];
        }

        sum %= 10;

        return sum == number[0];
    }
}
