package com.java8.test.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

/**
 * This enum holds the US states values.
 *
 * @author Anil Kumar Yellamandala
 * @since 10.12.2020
 */
public enum USStatesType {

    AL("ALABAMA"),
    AK("ALASKA"),
    AZ("ARIZONA"),
    AR("ARKANSAS"),
    CA("CALIFORNIA"),
    CO("COLORADO"),
    CT("CONNECTICUT"),
    DE("DELAWARE"),
    DC("WASHINGTONDC"),
    FL("FLORIDA"),
    GA("GEORGIA"),
    ID("IDAHO"),
    IL("ILLINOIS"),
    IN("INDIANA"),
    IA("IOWA"),
    KS("KANSAS"),
    KY("KENTUCKY"),
    LA("LOUISIANA"),
    ME("MAINE"),
    MD("MARYLAND"),
    MA("MASSACHUSETTS"),
    MI("MICHIGAN"),
    MN("MINNESOTA"),
    MO("MISSOURI"),
    MS("MISSISSIPPI"),
    MT("MONTANA"),
    NE("NEBRASKA"),
    NV("NEVADA"),
    NH("NEWHAMSPHIRE"),
    NJ("NEWJERSY"),
    NM("NEWMEXICO"),
    NY("NEWYORK"),
    NC("NORTHCAROLINA"),
    ND("NORTH DAKOTA"),
    OH("OHIO"),
    OK("OKLAHOMA"),
    OR("OREGON"),
    PA("PENNSYLVANIA"),
    RI("RHODEISLAND"),
    SC("SOUTHCAROLINA"),
    SD("SOUTHDAKOTA"),
    TN("TENNESSEE"),
    TX("TEXAS"),
    UT("UTAH"),
    VT("VERMONT"),
    VA("VIRGINIA"),
    WA("WASHINGTON"),
    WV("WESTVIRGINIA"),
    WI("WISCONSIN"),
    WY("WYOMING"),
    PR("PUERTORICO"),
    HI("HAWAII");
    private final String stateVal;

    USStatesType(String stateVal) {
        this.stateVal = stateVal;
    }

    public String getStateVal() {
        return stateVal;
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static USStatesType findValue(@JsonProperty("stateVal") String stateVal) {
        return Arrays.stream(USStatesType.values()).filter(v -> v.toString()
                .equalsIgnoreCase(stateVal)).findFirst().get();
    }
}