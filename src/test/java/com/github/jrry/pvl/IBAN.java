package com.github.jrry.pvl;

/**
 * The Class IBAN.
 *
 * @author Jarosław Pawłowski
 */
public class IBAN {
    @PVL_IBAN
    private String IBANnumber;

    /**
     * Instantiates a new IBAN.
     *
     * @param IBANnumber the IBAN number
     */
    public IBAN(String IBANnumber) {
        this.IBANnumber = IBANnumber;
    }
}
