package com.github.jrry.pvl;

import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.InitialDirContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PVL_EmailValidator implements ConstraintValidator<PVL_Email, String> {

	public boolean isValid(String value, ConstraintValidatorContext context) {
		try {
			return isMailServer(value);
		} catch (NamingException e) {}
		return false;
	}
	
	private boolean isMailServer(String name) throws NamingException {
		InitialDirContext idc = new InitialDirContext();
		Attributes att = idc.getAttributes("dns:/" + name, new String[] {"MX"});
		Attribute attMX = att.get("MX");
		return attMX != null;
	} 

}
