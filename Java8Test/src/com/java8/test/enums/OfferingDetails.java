package com.java8.test.enums;

import java.util.EnumMap;

public class OfferingDetails {

    private static EnumMap<OfferingName, OfferingId> offeringMap;

    static  {
        offeringMap = new EnumMap<>(OfferingName.class);
        offeringMap.put(OfferingName.BRONZE_PLAN, OfferingId.BRONZE);
        offeringMap.put(OfferingName.SILVER_PLAN, OfferingId.SILVER);
        offeringMap.put(OfferingName.GOLD_PLAN, OfferingId.GOLD);
    }

    public static EnumMap<OfferingName, OfferingId> getOfferingMap() {
        return offeringMap;
    }
}
