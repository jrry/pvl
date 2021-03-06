package com.github.jrry.pvl;

/**
 * The Class IdentityCard.
 *
 * @author Jarosław Pawłowski
 */
class IdentityCard {

    /**
     * The identity card field with validation.
     */
    @PVL_IdentityCard
    private String identityCard;

    /**
     * Instantiates a new identity card.
     *
     * @param identityCard the identity card
     */
    IdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }
}
