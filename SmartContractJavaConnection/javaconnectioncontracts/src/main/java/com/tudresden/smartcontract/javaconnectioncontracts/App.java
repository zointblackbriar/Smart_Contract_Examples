package com.tudresden.smartcontract.javaconnectioncontracts;

import org.slf4j.Logger;

//import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;

/**
 * Hello world!
 *
 */
public class App 
{
	private final static Logger logger = LoggerFactory.getLogger(App.class);
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
        logger.info("Hello from the SL4J");
        Web3j webObject = Web3j.build(new HttpService());
        Web3ClientVersion web3ClientVersion = null; //first initialization
        
        
        try {
        	web3ClientVersion = webObject.web3ClientVersion().send();
        	logger.info("Web3 Client Version: " + web3ClientVersion);
        } catch(Exception ex) 
        {
        	ex.printStackTrace();
        }
    }
}
