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
public class IdentityCardTest {
	
	/** The Constant validator. */
	private static final Validator validator;

    static {
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

}
