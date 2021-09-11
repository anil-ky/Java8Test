package com.java8.test.enums;

/**
 * This is a typelist to OfferingIds.
 *
 * @author Anil Kumar Yellamandala
 * @since 18.11.2020
 */
public enum OfferingId {

    GOLD("GOLD"),
    SILVER("SILVER"),
    BRONZE("BRONZE");

    private final String offeringIdValue;

    OfferingId(String offeringIdValue) {
        this.offeringIdValue = offeringIdValue;
    }

    public String getOfferingIdValue() {
        return offeringIdValue;
    }
}
