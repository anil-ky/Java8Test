package com.java8.features.functionalinterface;

import java.util.Date;
import java.util.function.Supplier;

// Supplier
// Supplier<R>: It will just supply the required object and will not take any input.
// There is no chaining in the supplier. Only it gives an output.
public class SupplierPredefinedFI {

    public Supplier<Date> currentDate = () -> new Date();

    public static void main(String str[]) {
        SupplierPredefinedFI a = new SupplierPredefinedFI(); // Before Java 8
        a.fetchCurrentDate();
        System.out.println("Before Java 8:: " + a.fetchCurrentDate());

        //Java 8
        Supplier<Date> cd = () -> new Date();
        System.out.println("Java 8:: " + cd.get());
    }

    public Date fetchCurrentDate() {
        return new Date();
    }


}
