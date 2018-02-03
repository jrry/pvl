package com.github.jrry.pvl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * The Class PVL_NIPValidator.
 *
 * @author Jarosław Pawłowski
 */
public class PVL_NIPValidator implements ConstraintValidator<PVL_NIP, String> {

    private static final int[] tab = {6, 5, 7, 2, 3, 4, 5, 6, 7};

    @Override
    public void initialize(PVL_NIP constraintAnnotation) {}

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null)
            return false;

        String parseNip = value.replaceAll("[^\\d]", "");

        if (parseNip.length() != 10)
            return false;

        int sum = 0;
        int last = parseNip.charAt(9) - '0';

        for (int i = 0; i < tab.length; i++)
            sum += (tab[i] * (parseNip.charAt(i) - '0'));

        sum %= 11;

        return (sum != 10) && (last == sum);
    }
}
