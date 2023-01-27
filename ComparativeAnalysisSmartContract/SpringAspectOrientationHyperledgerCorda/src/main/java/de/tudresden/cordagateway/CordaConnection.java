package de.tudresden.cordagateway;

import org.apache.log4j.Logger;

import net.corda.core.messaging.CordaRPCOps;
import net.corda.core.utilities.NetworkHostAndPort;
import net.corda.client.rpc.CordaRPCClient;
import net.corda.client.rpc.CordaRPCConnection;


public class CordaConnection {
	
	private static final Logger logger = Logger.getLogger(CordaConnection.class.getName()); 
	
	public boolean cordaConnectionFunc() {
		try {
			final NetworkHostAndPort nodeAddress = NetworkHostAndPort.parse("Node address"); 
			String username = "sampleuser"; 
			String password = "samplepass";
			final CordaRPCClient client = new CordaRPCClient(nodeAddress); 
			final CordaRPCConnection connection = client.start(username, password); 
			final CordaRPCOps cordaRPCOperations = connection.getProxy(); 
			logger.info(cordaRPCOperations.currentNodeTime().toString());
			connection.notifyServerAndClose();
			
		} catch(Exception ex) 
		{
			ex.printStackTrace();
		}
		return true; 
	}

}
