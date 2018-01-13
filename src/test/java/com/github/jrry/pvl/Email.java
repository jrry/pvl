package com.github.jrry.pvl;

/**
 * The Class Email.
 *
 * @author Jarosław Pawłowski
 */
class Email {

    /**
     * The email adress.
     */
    @PVL_Email
    private String adress;

    /**
     * Instantiates a new email.
     *
     * @param adress the adress
     */
    Email(String adress) {
        this.adress = adress;
    }

}
