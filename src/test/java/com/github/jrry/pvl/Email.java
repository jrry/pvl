package com.github.jrry.pvl;

/**
 * The Class Email.
 * 
 * 
 * @author Jarosław Pawłowski
 */
public class Email {
	
	/** The email adress. */
	@PVL_Email
	private String adress;

	/**
	 * Instantiates a new email.
	 *
	 * @param adress the adress
	 */
	public Email(String adress) {
		this.adress = adress;
	}
	
}
