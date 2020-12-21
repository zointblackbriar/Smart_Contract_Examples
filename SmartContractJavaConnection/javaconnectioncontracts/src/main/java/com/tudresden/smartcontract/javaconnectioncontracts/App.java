package com.tudresden.smartcontract.javaconnectioncontracts;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

import org.slf4j.Logger;

//import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

/**
 * Hello world!
 *
 */
public class App 
{
	private final static Logger logger = LoggerFactory.getLogger(App.class);
	private final static String PRIVATE_KEY = "d9c5e395970994db652a448d6d192e011bd57505010178a811ceb010ea101f21";
	private final static BigInteger GAS_LIMIT = BigInteger.valueOf(21000L);
	private final static BigInteger GAS_PRICE = BigInteger.valueOf(200000000000L);
	private final static String RECIPIENT = "0x502337834537AB4c23824Ce7f93e12D747A86eED";
	
	private App() throws Exception {
        Web3j webObject = Web3j.build(new HttpService());
        printWeb3Version(webObject);
        TransactionManager transactionManager = new RawTransactionManager(webObject, getCredentialFromPrivateKey());
        
        Transfer transfer = new Transfer(webObject, transactionManager);
        
        TransactionReceipt transactionReceipt = transfer.sendFunds(
        		RECIPIENT, 
        		BigDecimal.ONE,
        		Convert.Unit.ETHER,
        		GAS_PRICE,
        		GAS_LIMIT
        		).send();
        logger.info("Transaction = " + transactionReceipt.getTransactionHash());
	}
	
    public static void main( String[] args ) throws Exception
    {
//        System.out.println( "Hello World!" );
        logger.info("Hello from the SL4J");
        try {
            new App();
        } catch(Exception ex)
        {
        	
        }
        
    }
    
    private static void printWeb3Version(Web3j webObject) 
    {
        Web3ClientVersion web3ClientVersion = null; //first initialization
        
        
        try {
        	web3ClientVersion = webObject.web3ClientVersion().send();
        	logger.info("Web3 Client Version: " + web3ClientVersion);
        } catch(Exception ex) 
        {
        	ex.printStackTrace();
        }

    }
    
    private Credentials getCredentialFromWallet() throws IOException, CipherException 
    {
    	Credentials credentials = WalletUtils.loadCredentials("passphrase", "wallet/path");
    	return credentials;
    	
    }
    
    private Credentials getCredentialFromPrivateKey() {
//    	d9c5e395970994db652a448d6d192e011bd57505010178a811ceb010ea101f21

    	return Credentials.create(PRIVATE_KEY); 
    }
}
