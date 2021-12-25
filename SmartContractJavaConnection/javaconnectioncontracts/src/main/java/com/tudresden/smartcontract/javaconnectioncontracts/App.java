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
public class App {
	private final static Logger logger = LoggerFactory.getLogger(App.class);
	private final static String PRIVATE_KEY = "d9c5e395970994db652a448d6d192e011bd57505010178a811ceb010ea101f21";
	private final static BigInteger GAS_LIMIT = BigInteger.valueOf(21000L);
	private final static BigInteger GAS_PRICE = BigInteger.valueOf(200000000000L);
	private final static String RECIPIENT = "0x502337834537AB4c23824Ce7f93e12D747A86eED";
	private final static String CONTRACT_ADDRESS = "0xdDDd207a94a527446C1e9AC5f5009F8515Dea8f1"; //Contract Address is wrong

	private static Web3j App() throws Exception {
		Web3j webObject = Web3j.build(new HttpService());
		printWeb3Version(webObject);
		return webObject;
	}

	public static void main(String[] args) throws Exception {
//        System.out.println( "Hello World!" );
		logger.info("Hello from the SL4J");
		Web3j webObject = App();
		TransactionManager transactionManager = new RawTransactionManager(webObject, getCredentialFromPrivateKey());

		Transfer transfer = new Transfer(webObject, transactionManager);

		TransactionReceipt transactionReceipt = transfer
				.sendFunds(RECIPIENT, BigDecimal.ONE, Convert.Unit.ETHER, GAS_PRICE, GAS_LIMIT).send();
		logger.info("Transaction = " + transactionReceipt.getTransactionHash());
		
		Credentials credentials = getCredentialFromPrivateKey();
		logger.info("Credentials = " + credentials.toString());
		Thread.sleep(2000);
		AddressBook addressBook = loadContract(CONTRACT_ADDRESS, webObject, credentials);
		Thread.sleep(2000);
		printAddress(addressBook);
		try {
			new App();
		} catch (Exception ex) {

		}

	}
	
	private static void printAddress(AddressBook addressBook) throws Exception {
		for(Object address : addressBook.getAddresses().send()) {
			String addressString = address.toString();
			String alias = addressBook.getAlias(addressString).send();
			logger.info("Address: " + addressString + "aliases : " + alias);
		}
	}
	
	private void transferEthereum(Web3j web3jObject, Credentials credentials) throws Exception {
		TransactionManager transactionManager = new RawTransactionManager(
				web3jObject, credentials);
		
		Transfer transfer = new Transfer(web3jObject, transactionManager);
//        String toAddress,
//        BigDecimal value,
//        Convert.Unit unit,
//        BigInteger gasPrice,
//        BigInteger gasLimit) {
		TransactionReceipt transactionReceipt = transfer.sendFunds(RECIPIENT, BigDecimal.ONE, 
				Convert.Unit.ETHER, GAS_PRICE, GAS_LIMIT).send();
		
		logger.info("Transaction = " + transactionReceipt.getTransactionHash());
		
	}
	
	private static String deployContract(Web3j web3j, Credentials credentials) throws Exception {
		
		return AddressBook.deploy(web3j, credentials, GAS_PRICE, GAS_LIMIT).send().getContractAddress();
	}
	
	private static AddressBook loadContract(String contractAddress, Web3j web3jObject, Credentials credentials) {
		return AddressBook.load(contractAddress, web3jObject, credentials, GAS_PRICE, GAS_LIMIT);
	}
	
	private static void removeAddress(AddressBook adressBook, String addressRemoval) throws Exception {
		adressBook.removeAddresses(addressRemoval).send();
	}

	private static void printWeb3Version(Web3j webObject) {
		Web3ClientVersion web3ClientVersion = null; // first initialization

		try {
			web3ClientVersion = webObject.web3ClientVersion().send();
			logger.info("Web3 Client Version: " + web3ClientVersion);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
    private static void addAddresses(AddressBook addressBook) throws Exception {
        addressBook
                .addAddresses("0xFB525467E21F4d03a735b280A5d506778Df74f77", "Role1")
                .send();

        addressBook
                .addAddresses("0xe4A5D0D20550681BF95b119127d2F3a39C3756c3", "Role2")
                .send();

        addressBook
                .addAddresses("0xE006fb3330f773EbA01595CAaeD9b850e4367E0b", "Role3")
                .send();
    }

	private Credentials getCredentialFromWallet() throws IOException, CipherException {
		Credentials credentials = WalletUtils.loadCredentials("passphrase", "wallet/path");
		return credentials;

	}

	private static Credentials getCredentialFromPrivateKey() {
//    	d9c5e395970994db652a448d6d192e011bd57505010178a811ceb010ea101f21

		return Credentials.create(PRIVATE_KEY);
	}
}
