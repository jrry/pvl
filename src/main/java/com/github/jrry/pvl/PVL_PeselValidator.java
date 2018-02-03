package com.github.jrry.pvl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.regex.Pattern;

/**
 * The Class PVL_PeselValidator.
 *
 * @author Jarosław Pawłowski
 */
public class PVL_PeselValidator implements ConstraintValidator<PVL_Pesel, String> {

    private static final int[] tab = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};
    private static Pattern pattern = Pattern.compile("^\\d{11}$", Pattern.CASE_INSENSITIVE);

    @Override
    public void initialize(PVL_Pesel constraintAnnotation) {}

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null || !pattern.matcher(value).matches())
            return false;

        int year, month, day;

        day = Integer.parseInt(value.substring(4, 6));
        month = Integer.parseInt(value.substring(2, 4));

        if (month > 32)
            return false;
        else if (month > 12) {
            month -= 20;
            year = Integer.parseInt("20" + value.substring(0, 2));
        } else {
            year = Integer.parseInt("19" + value.substring(0, 2));
        }

        LocalDate now = LocalDate.now();
        LocalDate born;
        try {
            born = LocalDate.of(year, month, day);
        } catch (DateTimeException e) {
            return false;
        }

        if (born.isAfter(now))
            return false;

        char[] elements = value.toCharArray();
        int sum = 0;
        int last = elements[10] - '0';

        for (int i = 0; i < tab.length; i++) {
            sum += (tab[i] * (elements[i] - '0'));
        }

        sum %= 10;
        sum = 10 - sum;
        sum %= 10;

        return sum == last;
    }
}
