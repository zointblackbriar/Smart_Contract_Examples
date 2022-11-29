package de.tudresden.webofthingstokenization.externalsmartcontractlibrary;

import java.math.BigInteger;
import java.util.Arrays;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.9.4.
 */
@SuppressWarnings("rawtypes")
public class BridgeArbitrumL1Inbox extends Contract {
    public static final String BINARY = "60a060405233608052348015601357600080fd5b5060805160a561002c60003960006031015260a56000f3fe6080604052348015600f57600080fd5b506004361060285760003560e01c8063e78cea9214602d575b600080fd5b60537f000000000000000000000000000000000000000000000000000000000000000081565b6040516001600160a01b03909116815260200160405180910390f3fea26469706673582212202c0e34b86da543ec4308b0e0f075b71f0c18a3d89e612a69879a1a219c088e9a64736f6c63430008090033";

    public static final String FUNC_BRIDGE = "bridge";

    @Deprecated
    protected BridgeArbitrumL1Inbox(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected BridgeArbitrumL1Inbox(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected BridgeArbitrumL1Inbox(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected BridgeArbitrumL1Inbox(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<String> bridge() {
        final Function function = new Function(FUNC_BRIDGE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static BridgeArbitrumL1Inbox load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new BridgeArbitrumL1Inbox(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static BridgeArbitrumL1Inbox load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new BridgeArbitrumL1Inbox(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static BridgeArbitrumL1Inbox load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new BridgeArbitrumL1Inbox(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static BridgeArbitrumL1Inbox load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new BridgeArbitrumL1Inbox(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<BridgeArbitrumL1Inbox> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(BridgeArbitrumL1Inbox.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<BridgeArbitrumL1Inbox> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(BridgeArbitrumL1Inbox.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<BridgeArbitrumL1Inbox> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(BridgeArbitrumL1Inbox.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<BridgeArbitrumL1Inbox> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(BridgeArbitrumL1Inbox.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
