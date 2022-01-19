package de.tudresden.algorandjava;
import com.algorand.algosdk.account.Account;
import com.algorand.algosdk.v2.client.common.AlgodClient;
import com.algorand.algosdk.v2.client.model.NodeStatusResponse;
import com.algorand.algosdk.v2.client.model.PendingTransactionResponse;
import com.algorand.algosdk.v2.client.common.Response;

import java.util.logging.Logger;

public class AlgorandConnection {

    private static final Logger logger = Logger.getLogger(AlgorandConnection.class.getName());
        //Create an Account

    public Account createAccount() throws Exception {
        Account myAccount = null;

        try {
            myAccount = new Account();
            logger.info("My Address: " + myAccount.getAddress());
            logger.info("My Passphrase: " + myAccount.toMnemonic());
            logger.info("Copy the address of algorand: " + myAccount.getAddress().toString());
        } catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return myAccount;
    }
    private AlgodClient commonClient = null;
    private AlgodClient connectToAlgoNetwork() {

        final String ALGOD_API_ADDR = "localhost";
        final String ALGOD_API_TOKEN = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        final Integer ALGOD_PORT = 4001; 
        AlgodClient client = null;
        try {
            client = new AlgodClient(ALGOD_API_ADDR, ALGOD_PORT, ALGOD_API_TOKEN); 
            commonClient = client;
        } catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return client;
    }

    private PendingTransactionResponse waitForConfirmation(AlgodClient algodClient, String transactionID, Integer timeout) throws Exception{
        if(algodClient == null || transactionID == null || timeout < 0) {
            throw new IllegalArgumentException("Bad arguments have been provided");
        }
        Response <NodeStatusResponse> response = algodClient.GetStatus().execute();
        if(!response.isSuccessful()) {
            throw new Exception(response.message());
        }
        return null; 
    }

    private String showBalance(com.algorand.algosdk.account.Account myAccount) throws Exception {
        String myAddress = myAccount.getAddress().toString();
        Response < com.algorand.algosdk.v2.client.model.Account > responseAccount = commonClient.AccountInformation(myAccount.getAddress()).execute();        
        return myAddress;
    }
    
}
