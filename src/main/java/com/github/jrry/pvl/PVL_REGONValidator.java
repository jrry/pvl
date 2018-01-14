package com.github.jrry.pvl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * The Class PVL_REGONValidator.
 *
 * @author Jarosław Pawłowski
 */
public class PVL_REGONValidator implements ConstraintValidator<PVL_REGON, String> {

    private static final int[] tab1 = {8, 9, 2, 3, 4, 5, 6, 7};
    private static final int[] tab2 = {2, 4, 8, 5, 0, 9, 7, 3, 6, 1, 2, 4, 8};

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (!value.matches("[0-9]+"))
            return false;
        if (value.length() == 9)
            return shortRegon(value);
        return value.length() == 14 && longRegon(value);
    }

    private boolean shortRegon(String value) {
        int sum = 0;
        int last = value.charAt(8) - '0';
        for (int i = 0; i < tab1.length; i++) {
            sum += (tab1[i] * (value.charAt(i) - '0'));
        }
        sum %= 11;
        sum %= 10;
        return sum == last;
    }

    private boolean longRegon(String value) {
        if (!shortRegon(value))
            return false;
        int sum = 0;
        int last = value.charAt(13) - '0';
        for (int i = 0; i < tab2.length; i++) {
            sum += (tab2[i] * (value.charAt(i) - '0'));
        }
        sum %= 11;
        sum %= 10;
        return sum == last;
    }
}
