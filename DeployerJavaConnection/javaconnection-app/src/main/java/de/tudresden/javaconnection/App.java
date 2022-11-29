package de.tudresden.javaconnection;
import de.tudresden.javaconnection.externalsmartcontractlibrary.HelloWorld;
import de.tudresden.javaconnection.util.PropertyUtil;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.core.methods.response.EthBlockNumber; 

import java.util.logging.Logger;
/**
 * Hello world!
 *
 */
public class App 
{

    private static final Logger logger = Logger.getLogger(App.class.getName());
    private static String AVAILABLE_ACCOUNT = PropertyUtil.getInstance().getProperty("AVAILABLE_ACCOUNT");
    private static String PRIVATE_KEY = PropertyUtil.getInstance().getProperty("PRIVATE_KEY");
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        try {
            Web3j web3j = Web3j.build(new HttpService("http://127.0.0.1:8545"));
            String account =  web3j.ethAccounts().send().getAccounts().get(0);
            logger.info("Connected to the Ethereum client: " + web3j.web3ClientVersion().send().getWeb3ClientVersion());
            EthBlockNumber ethBlockNumber = web3j.ethBlockNumber().send(); 
            logger.info("The number of block size" + ethBlockNumber.getBlockNumber().signum()); 
            // LOGGER.info()
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
