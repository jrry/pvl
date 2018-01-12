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
    
	/**
	 * Identity test true.
	 */
	@Test
    public void IdentityTestTrue() {
		IdentityCard vt = new IdentityCard("ABS123456");
		Set<ConstraintViolation<IdentityCard>> errors = validator.validate(vt);
        assertTrue(errors.isEmpty());
	}
	
	/**
	 * Identity test false.
	 */
	@Test
	public void IdentityTestFalse() {
		IdentityCard vt = new IdentityCard("ABC123456");
		Set<ConstraintViolation<IdentityCard>> errors = validator.validate(vt);
        assertFalse(errors.isEmpty());
	}
	
	/**
	 * Email test true.
	 */
	@Test
	public void EmailTestTrue() {
		Email email = new Email("test@o2.pl");
		Set<ConstraintViolation<Email>> errors = validator.validate(email);
		assertTrue(errors.isEmpty());
	}
	
	/**
	 * Email test false.
	 */
	@Test
	public void EmailTestFalse() {
		Email email = new Email("test@bugle.pl");
		Set<ConstraintViolation<Email>> errors = validator.validate(email);
		assertFalse(errors.isEmpty());
	}
	
	/**
	 * NIP test true.
	 */
	@Test
    public void NIPTestTrue() {
		NIP nip = new NIP("362-398-12-30");
		Set<ConstraintViolation<NIP>> errors = validator.validate(nip);
        assertTrue(errors.isEmpty());
	}
	
	/**
	 * NIP test false.
	 */
	@Test
	public void NIPTestFalse() {
		NIP nip = new NIP("362-123-12-30");
		Set<ConstraintViolation<NIP>> errors = validator.validate(nip);
        assertFalse(errors.isEmpty());
	}
}
