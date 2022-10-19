package de.tudresden.CROP.javaapplication;

import org.web3j.model.*;
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
import org.web3j.model.AddressBook;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
/**
 * Hello world!
 *
 */
public class App 
{
    private final static String PRIVATE_KEY = "0xd93a5d930a42f74099ae52bad176934ca9b7bd16297ef8edf31999ebfaf775a8";

    private final static BigInteger GAS_LIMIT = BigInteger.valueOf(6721975L);
    private final static BigInteger GAS_PRICE = BigInteger.valueOf(20000000000L);

    private final static String RECIPIENT = "0x4E64B8cE0Ff7238677899f100b02BC8f1e0191F4";

    private final static String CONTRACT_ADDRESS = "0xdd10a09af47e5ec05c9e2c7073393e1372177960d4a38266ffcd5fed2e1afb06";

    public static void main(String[] args) {
        try {
            new App();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private App() throws Exception {
        Web3j web3j = Web3j.build(new HttpService());

        Credentials credentials = getCredentialsFromPrivateKey();

        AddressBook addressBook = loadContract(CONTRACT_ADDRESS, web3j, credentials);

        removeAddress(addressBook);

        printAddresses(addressBook);
    }

    private void printWeb3Version(Web3j web3j) {
        Web3ClientVersion web3ClientVersion = null;
        try {
            web3ClientVersion = web3j.web3ClientVersion().send();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String web3ClientVersionString = web3ClientVersion.getWeb3ClientVersion();
        System.out.println("Web3 client version: " + web3ClientVersionString);
    }

    private Credentials getCredentialsFromWallet() throws IOException, CipherException {
        return WalletUtils.loadCredentials(
                "passphrase",
                "wallet/path"
        );
    }

    private Credentials getCredentialsFromPrivateKey() {
        return Credentials.create(PRIVATE_KEY);
    }

    private void transferEthereum(Web3j web3j, Credentials credentials) throws Exception {
        TransactionManager transactionManager = new RawTransactionManager(
                web3j,
                credentials
        );

        Transfer transfer = new Transfer(web3j, transactionManager);

        TransactionReceipt transactionReceipt = transfer.sendFunds(
                RECIPIENT,
                BigDecimal.ONE,
                Convert.Unit.ETHER,
                GAS_PRICE,
                GAS_LIMIT
        ).send();

        System.out.print("Transaction = " + transactionReceipt.getTransactionHash());
    }

    private String deployContract(Web3j web3j, Credentials credentials) throws Exception {
        return AddressBook.deploy(web3j, credentials, GAS_PRICE, GAS_LIMIT)
                .send()
                .getContractAddress();
    }

    private AddressBook loadContract(String contractAddress, Web3j web3j, Credentials credentials) {
        return AddressBook.load(contractAddress, web3j, credentials, GAS_PRICE, GAS_LIMIT);
    }

    private void addAddresses(AddressBook addressBook) throws Exception {
        addressBook
                .addAddress("0xf9607dEaA419D5f4433390278335D2217e7aD997", "Tom")
                .send();

        addressBook
                .addAddress("0x3ca9e9F89796e8a81687DaBDf8fd5a02686BE20E", "Susan")
                .send();

        addressBook
                .addAddress("0xE7f7F44A8DB8712F1ede9F02729E706AD11e10d9", "Bob")
                .send();
    }

    private void printAddresses(AddressBook addressBook) throws Exception {
        for (Object address : addressBook.getAddresses().send()) {
            String addressString = address.toString();
            String alias = addressBook.getAlias(addressString).send();
            System.out.println("Address " + addressString + " aliased as " + alias);
        }
    }

    private void removeAddress(AddressBook addressBook) throws Exception {
        addressBook
                .removeAddress("0x256a04B9F02036Ed2f785D8f316806411D605285")
                .send();
    }
}
