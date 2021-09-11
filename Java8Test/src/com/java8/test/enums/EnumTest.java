package com.java8.test.enums;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Optional;
import java.util.stream.Stream;

public class EnumTest {

	public static void main(String[] args) {
		
		AddressValidationVendor[] vendorArray = AddressValidationVendor.values();
		
		Optional<AddressValidationVendor> vendor2 = Arrays.stream(AddressValidationVendor.values()).filter(v -> v.toString()
				  .equalsIgnoreCase("PRECISELY")).findFirst();
		
		if (vendor2.isEmpty()) {
			System.out.println("Vendor is not found");
		} else {
			System.out.println(vendor2.get() + " : " + vendor2.get().getVendor());
		}
		
		System.out.println(vendor2.toString() + " : " + vendor2);
		
		for (AddressValidationVendor vendor: vendorArray) {
			System.out.println(vendor.getVendor());
		}
		
		
		System.out.println("Process Status: " + ProcessStatus.IN_PROCESSING.getStatus().equals("IN_PROCESSING"));
		
		
		
		OfferingName names [] = OfferingName.values();
		
		  for (OfferingName name: names) { System.out.println(name); }
		
			
		  System.out.println(Arrays.stream(OfferingName.values()).filter(v -> v.toString()
			  .equalsIgnoreCase("SILVER_PLAN")).findFirst().get());
			 
		
		OfferingName bronzePlane = OfferingName.valueOf("SILVER_PLAN");
		System.out.println(compareOfferings("BRONZE_PLAN"));
		
		System.out.println("Offering Id: " + OfferingDetails.getOfferingMap().get(bronzePlane));

	}
	
	public static boolean compareOfferings(String offeringName) {
		
		return EnumSet.allOf(OfferingName.class).contains(OfferingName.valueOf(offeringName));
	}
	
	/*
	 * private List<ValidationMessage> validateOfferingName(String offeringName) {
	 * 
	 * List<ValidationMessage> validationsList = null; try { OfferingName
	 * validOfferingName = OfferingName.valueOf(offeringName.toUpperCase()); } catch
	 * (IllegalArgumentException exception) { baseLogger.log(LogLevel.ERROR,
	 * ExceptionUtils.getStackTrace(exception)); validationsList = new
	 * ArrayList<>(); validationsList.add(new
	 * ValidationMessage(StatusCode.ERR_18003.errorCode(),
	 * exceptionManager.getExceptionMessage(StatusCode.ERR_18003.errorCode()),
	 * offeringName)); }
	 * 
	 * return validationsList; }
	 */

}
