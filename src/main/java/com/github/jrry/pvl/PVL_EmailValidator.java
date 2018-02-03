package com.github.jrry.pvl;

import java.util.regex.Pattern;

import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.InitialDirContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * The Class PVL_EmailValidator.
 *
 * @author Jarosław Pawłowski
 */
public class PVL_EmailValidator implements ConstraintValidator<PVL_Email, String> {

    private static final String EMAIL_REGEX = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";

    private static Pattern pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);

    @Override
    public void initialize(PVL_Email constraintAnnotation) {}

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || !pattern.matcher(value).matches())
            return false;
        try {
            return isMailServer(value);
        } catch (NamingException ignored) {
        }
        return false;
    }

    /**
     * Checks if is mail server.
     *
     * @param name the name
     * @return true, if is mail server exist
     * @throws NamingException the naming exception
     */
    private boolean isMailServer(String name) throws NamingException {
        String[] hostname = name.split("@", 2);
        InitialDirContext idc = new InitialDirContext();
        Attributes att = idc.getAttributes("dns:/" + hostname[1], new String[]{"MX"});
        Attribute attMX = att.get("MX");
        return attMX != null;
    }

}
