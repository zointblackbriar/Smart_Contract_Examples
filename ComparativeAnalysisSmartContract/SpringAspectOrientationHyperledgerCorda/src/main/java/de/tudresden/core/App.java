package de.tudresden.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import de.tudresden.retailer.IRole;
import de.tudresden.retailer.Retailer;

public class App {
	public static void main(String[] args) throws Exception {

		ApplicationContext appContext = new ClassPathXmlApplicationContext("Spring-SupplyChain.xml");

		Retailer retailer = (Retailer) appContext.getBean("retailerImplBean");
		retailer.addRetailer();
		
		retailer.addRetailerReturnValue();
		
//		customer.addCustomerThrowException();
		
		retailer.addRetailerAround("Sample Retailer");
		
		ApplicationContext roleContext = new ClassPathXmlApplicationContext("Spring-Role.xml"); 
		IRole role = (IRole) roleContext.getBean("roleImplBean"); 
		role.activation();
	}
}