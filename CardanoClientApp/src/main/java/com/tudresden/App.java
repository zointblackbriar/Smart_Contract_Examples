package com.tudresden;

import com.bloxbean.cardano.client.exception.AddressExcepion;
import com.bloxbean.cardano.client.backend.exception.ApiException;
import com.bloxbean.cardano.client.exception.CborSerializationException;
import com.bloxbean.cardano.client.account.Account;
import com.bloxbean.cardano.client.common.model.Networks;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.Logger;


/**
 * Hello world!
 *
 */
public class App 
{
    private static final Logger logger = Logger.getLogger(App.class.getName());
    public static void main( String[] args ) throws ApiException, CborSerializationException, AddressExcepion {
        System.out.println( "Hello Main Method!" );
        App newObject = new App();
        newObject.transfer();
    }

    public void transfer() throws ApiException, AddressExcepion, CborSerializationException {
        // BackendService backendService = BackendFactory.getBlockfrostBackendService(Constants.BLOCKFROST_TESTNET_URL, Constant.BF_PROJECT_KEY);
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("src/resources/application.properties"));
            System.out.println("mnemonic: " + prop.getProperty("mnemonic"));
            Account sender = new Account(Networks.testnet(), prop.getProperty("mnemonic"));
            System.out.println("sender: " + sender);
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
