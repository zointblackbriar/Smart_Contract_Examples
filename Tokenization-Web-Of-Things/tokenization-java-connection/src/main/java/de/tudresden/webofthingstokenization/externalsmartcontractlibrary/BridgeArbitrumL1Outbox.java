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
public class BridgeArbitrumL1Outbox extends Contract {
    public static final String BINARY = "60a06040523360805234801561001457600080fd5b506080516101846100356000396000818160640152608a01526101846000f3fe608060405234801561001057600080fd5b50600436106100365760003560e01c806380648b021461003b578063e78cea921461005f575b600080fd5b610043610086565b6040516001600160a01b03909116815260200160405180910390f35b6100437f000000000000000000000000000000000000000000000000000000000000000081565b60007f00000000000000000000000000000000000000000000000000000000000000006001600160a01b03166370348f3e6040518163ffffffff1660e01b815260040160206040518083038186803b1580156100e157600080fd5b505afa1580156100f5573d6000803e3d6000fd5b505050506040513d601f19601f82011682018060405250810190610119919061011e565b905090565b60006020828403121561013057600080fd5b81516001600160a01b038116811461014757600080fd5b939250505056fea2646970667358221220b321a3b324afc4c27ff617e92c7e7300f8a5e73ade6c9c75cd8b13e5b44e66c064736f6c63430008090033";

    public static final String FUNC_BRIDGE = "bridge";

    public static final String FUNC_L2TOL1SENDER = "l2ToL1Sender";

    @Deprecated
    protected BridgeArbitrumL1Outbox(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected BridgeArbitrumL1Outbox(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected BridgeArbitrumL1Outbox(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected BridgeArbitrumL1Outbox(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<String> bridge() {
        final Function function = new Function(FUNC_BRIDGE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> l2ToL1Sender() {
        final Function function = new Function(FUNC_L2TOL1SENDER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static BridgeArbitrumL1Outbox load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new BridgeArbitrumL1Outbox(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static BridgeArbitrumL1Outbox load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new BridgeArbitrumL1Outbox(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static BridgeArbitrumL1Outbox load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new BridgeArbitrumL1Outbox(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static BridgeArbitrumL1Outbox load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new BridgeArbitrumL1Outbox(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<BridgeArbitrumL1Outbox> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(BridgeArbitrumL1Outbox.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<BridgeArbitrumL1Outbox> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(BridgeArbitrumL1Outbox.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<BridgeArbitrumL1Outbox> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(BridgeArbitrumL1Outbox.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<BridgeArbitrumL1Outbox> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(BridgeArbitrumL1Outbox.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
