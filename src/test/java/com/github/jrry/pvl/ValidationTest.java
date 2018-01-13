package com.github.jrry.pvl;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.Configuration;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Test;

/**
 * The Class IdentityCardTest.
 * 
 * 
 * @author Jarosław Pawłowski
 */
public class ValidationTest {

	/** The Constant validator. */
	private static final Validator validator;

    static 
    {
        Configuration<?> config = Validation.byDefaultProvider().configure();
        ValidatorFactory factory = config.buildValidatorFactory();
        validator = factory.getValidator();
        factory.close();
    }

	@Test
    public void IdentityTestTrue() {
		IdentityCard vt = new IdentityCard("ABS123456");
		Set<ConstraintViolation<IdentityCard>> errors = validator.validate(vt);
        assertTrue(errors.isEmpty());
	}

	@Test
	public void IdentityTestFalse() {
		IdentityCard vt = new IdentityCard("ABC123456");
		Set<ConstraintViolation<IdentityCard>> errors = validator.validate(vt);
        assertFalse(errors.isEmpty());
	}

	@Test
	public void EmailTestTrue() {
		Email email = new Email("test@o2.pl");
		Set<ConstraintViolation<Email>> errors = validator.validate(email);
		assertTrue(errors.isEmpty());
	}

	@Test
	public void EmailTestFalse() {
		Email email = new Email("test@bugle.pl");
		Set<ConstraintViolation<Email>> errors = validator.validate(email);
		assertFalse(errors.isEmpty());
	}

	@Test
    public void NIPTestTrue() {
		NIP nip = new NIP("362-398-12-30");
		Set<ConstraintViolation<NIP>> errors = validator.validate(nip);
		assertTrue(errors.isEmpty());
	}

	@Test
	public void NIPTestFalse() {
		NIP nip = new NIP("362-123-12-30");
		Set<ConstraintViolation<NIP>> errors = validator.validate(nip);
        assertFalse(errors.isEmpty());
	}

	@Test
	public void PeselTestTrue() {
		Pesel pesel = new Pesel("02070803628");
		Set<ConstraintViolation<Pesel>> errors = validator.validate(pesel);
		assertTrue(errors.isEmpty());
	}

    @Test
    public void PeselTestFalse1() {
        Pesel pesel = new Pesel("02070803620");
        Set<ConstraintViolation<Pesel>> errors = validator.validate(pesel);
        assertFalse(errors.isEmpty());
    }

    @Test
    public void PeselTestFalse2() {
        Pesel pesel = new Pesel("02990803627");
        Set<ConstraintViolation<Pesel>> errors = validator.validate(pesel);
        assertFalse(errors.isEmpty());
    }

    @Test
    public void PeselTestFalse3() {
        Pesel pesel = new Pesel("99310803621");
        Set<ConstraintViolation<Pesel>> errors = validator.validate(pesel);
        assertFalse(errors.isEmpty());
    }
}
