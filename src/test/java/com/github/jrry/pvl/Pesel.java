package com.github.jrry.pvl;

/**
 * The Class Pesel.
 *
 * @author Jarosław Pawłowski
 */
class Pesel {

    @PVL_Pesel
    private String pesel;

    /**
     * Instantiates a new Pesel.
     *
     * @param pesel the pesel
     */
    Pesel(String pesel) {
        this.pesel = pesel;
    }
}
