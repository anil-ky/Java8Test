package com.java8.enums;

import java.util.stream.Stream;

/**
 * This is a typelist to OfferingNames.
 *
 * @author Anil Kumar Yellamandala
 * @since 18.11.2020
 */
public enum OfferingName {

    GOLD_PLAN("GOLD PLANS"),
    SILVER_PLAN("SILVER PLANS"),
    BRONZE_PLAN("BRONZE PLANS");

    private final String offeringNameValue;

    OfferingName(String offeringNameValue) {
        this.offeringNameValue = offeringNameValue;
    }

    public String getOfferingNameValue() {
        return offeringNameValue;
    }
    
    public static Stream<OfferingName> stream() {
        return Stream.of(OfferingName.values()); 
    }
}
