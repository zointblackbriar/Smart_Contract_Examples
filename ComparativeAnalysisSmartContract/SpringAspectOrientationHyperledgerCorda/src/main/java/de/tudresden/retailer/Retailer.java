package de.tudresden.retailer;

public interface Retailer {

	void addRetailer();
	
	String addRetailerReturnValue();
	
	void addRetailerException() throws Exception;
	
	void addRetailerAround(String name);
}