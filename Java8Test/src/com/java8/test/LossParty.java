package com.java8.test;

public enum LossParty {
    FIRST_PARTY("FIRST_PARTY"),
    SECOND_PARTY("SECOND_PARTY"),
    THIRD_PARTY("THIRD_PARTY");

    private String partyType;

    LossParty(String partyType) {
        this.partyType = partyType;
    }

    public String getPartyType() {
        return partyType;
    }
}
