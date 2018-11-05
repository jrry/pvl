package com.github.jrry.pvl;

/**
 * The Class Password.
 *
 * @author Jarosław Pawłowski
 */
class Password {

    @PVL_Password
    private String password;

    /**
     * Instantiates a new Password.
     *
     * @param password the password
     */
    Password(String password) {
        this.password = password;
    }
}
