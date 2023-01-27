package de.tudresden.retailer.impl;

import de.tudresden.retailer.Retailer;

public class RetailerImpl implements Retailer {

	@Override
	public void addRetailer() {
		// TODO Auto-generated method stub
		System.out.println("addRetailer is running");
		
	}

	@Override
	public String addRetailerReturnValue() {
		// TODO Auto-generated method stub
		System.out.println("addRetailerReturnValue is running");
		return "Walmart Income";
	}

	@Override
	public void addRetailerException() throws Exception {
		System.out.println("addRetailerExpection happened");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addRetailerAround(String name) {
		// TODO Auto-generated method stub
		
	}

//	public void addCustomer(){
//		System.out.println("addCustomer() is running ");
//	}
//	
//	public String addCustomerReturnValue(){
//		System.out.println("addCustomerReturnValue() is running ");
//		return "abc";
//	}
//	
//	public void addCustomerThrowException() throws Exception {
//		System.out.println("addCustomerThrowException() is running ");
//		throw new Exception("Generic Error");
//	}
//	
//	public void addCustomerAround(String name){
//		System.out.println("addCustomerAround() is running, args : " + name);
//	}
}