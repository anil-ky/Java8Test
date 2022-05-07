package com.java8.enums;

public enum AddressValidationVendor {
	
    ADDRESSVALIDATIONAPI("ADDRESSVALIDATIONAPI"),
    PRECISELY("PRECISELYADDRESSAPI"),
    SMARTYSTREETS("SMARTYSTREETSADDRESSAPI");
	
    String vendor;

    AddressValidationVendor(String addValInsur) {
        this.vendor = addValInsur;
    }
    
    public String getVendor() {
        return vendor;
    }

}
