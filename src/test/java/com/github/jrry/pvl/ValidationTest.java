package com.github.jrry.pvl;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.Configuration;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

/**
 * The Class IdentityCardTest.
 *
 * @author Jarosław Pawłowski
 */
public class ValidationTest {

    /**
     * The Constant validator.
     */
    private static Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void IdentityTestCorrect() {
        IdentityCard vt = new IdentityCard("ABS123456");
        Set<ConstraintViolation<IdentityCard>> errors = validator.validate(vt);
        assertTrue(errors.isEmpty());
    }

    @Test
    public void IdentityTestIncorrect() {
        IdentityCard vt = new IdentityCard("ABC123456");
        Set<ConstraintViolation<IdentityCard>> errors = validator.validate(vt);
        assertFalse(errors.isEmpty());
    }

    @Test
    public void EmailTestCorrect() {
        Email email = new Email("test@o2.pl");
        Set<ConstraintViolation<Email>> errors = validator.validate(email);
        assertTrue(errors.isEmpty());
    }

    @Test
    public void EmailTestIncorrect() {
        Email email = new Email("test@bugle.pl");
        Set<ConstraintViolation<Email>> errors = validator.validate(email);
        assertFalse(errors.isEmpty());
    }

    @Test
    public void NIPTestCorrect() {
        NIP nip = new NIP("362-398-12-30");
        Set<ConstraintViolation<NIP>> errors = validator.validate(nip);
        assertTrue(errors.isEmpty());
    }

    @Test
    public void NIPTestIncorrect() {
        NIP nip = new NIP("362-123-12-30");
        Set<ConstraintViolation<NIP>> errors = validator.validate(nip);
        assertFalse(errors.isEmpty());
    }

    @Test
    public void PasswordTestCorrect() {
        Password password = new Password("qwertyQwerty!123");
        Set<ConstraintViolation<Password>> errors = validator.validate(password);
        assertTrue(errors.isEmpty());
    }

    @Test
    public void PasswordLengthIncorrect() {
        Password password = new Password("Ty!12");
        Set<ConstraintViolation<Password>> errors = validator.validate(password);
        assertFalse(errors.isEmpty());
    }

    @Test
    public void PasswordWithoutCharacterIncorrect() {
        Password password = new Password("Qwerty123");
        Set<ConstraintViolation<Password>> errors = validator.validate(password);
        assertFalse(errors.isEmpty());
    }

    @Test
    public void PasswordWithoutDigitIncorrect() {
        Password password = new Password("Qwertyuiop");
        Set<ConstraintViolation<Password>> errors = validator.validate(password);
        assertFalse(errors.isEmpty());
    }

    @Test
    public void PasswordWithoutUppercaseLettersIncorrect() {
        Password password = new Password("qwerty!123");
        Set<ConstraintViolation<Password>> errors = validator.validate(password);
        assertFalse(errors.isEmpty());
    }

    @Test
    public void PeselTestCorrect() {
        Pesel pesel = new Pesel("02070803628");
        Set<ConstraintViolation<Pesel>> errors = validator.validate(pesel);
        assertTrue(errors.isEmpty());
    }

    @Test
    public void PeselTestIncorrect1() {
        Pesel pesel = new Pesel("02070803620");
        Set<ConstraintViolation<Pesel>> errors = validator.validate(pesel);
        assertFalse(errors.isEmpty());
    }

    @Test
    public void PeselTestIncorrect2() {
        Pesel pesel = new Pesel("02990803627");
        Set<ConstraintViolation<Pesel>> errors = validator.validate(pesel);
        assertFalse(errors.isEmpty());
    }

    @Test
    public void PeselTestIncorrect3() {
        Pesel pesel = new Pesel("99310803621");
        Set<ConstraintViolation<Pesel>> errors = validator.validate(pesel);
        assertFalse(errors.isEmpty());
    }

    @Test
    public void RegonTestCorrect1() {
        REGON regon = new REGON("732065814");
        Set<ConstraintViolation<REGON>> errors = validator.validate(regon);
        assertTrue(errors.isEmpty());
    }

    @Test
    public void RegonTestCorrect2() {
        REGON regon = new REGON("23511332857188");
        Set<ConstraintViolation<REGON>> errors = validator.validate(regon);
        assertTrue(errors.isEmpty());
    }

    @Test
    public void RegonTestIncorrect1() {
        REGON regon = new REGON("732065815");
        Set<ConstraintViolation<REGON>> errors = validator.validate(regon);
        assertFalse(errors.isEmpty());
    }

    @Test
    public void RegonTestIncorrect2() {
        REGON regon = new REGON("23511332857189");
        Set<ConstraintViolation<REGON>> errors = validator.validate(regon);
        assertFalse(errors.isEmpty());
    }

    @Test
    public void IBANTestCorrect() {
        IBAN iban = new IBAN("PL83101010230000261395100000");
        Set<ConstraintViolation<IBAN>> errors = validator.validate(iban);
        assertTrue(errors.isEmpty());
    }

    @Test
    public void IBANTestIncorrect() {
        IBAN iban = new IBAN("EN83101010230000261395100000");
        Set<ConstraintViolation<IBAN>> errors = validator.validate(iban);
        assertFalse(errors.isEmpty());
    }
}
