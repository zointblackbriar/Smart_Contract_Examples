package de.tudresden.webofthingstokenization.externalsmartcontractlibrary;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
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
public class CrossChainEnabledArbitrumL2Mock extends Contract {
    public static final String BINARY = "60a06040523360805234801561001457600080fd5b50608051610318610035600039600081816055015260c401526103186000f3fe608060405234801561001057600080fd5b50600436106100415760003560e01c80634b074af5146100465780638da5cb5b14610050578063f97f518914610093575b600080fd5b61004e61009b565b005b6100777f000000000000000000000000000000000000000000000000000000000000000081565b6040516001600160a01b03909116815260200160405180910390f35b61004e6100c2565b6100a361013c565b6100c05760405163253a6fc960e11b815260040160405180910390fd5b565b7f000000000000000000000000000000000000000000000000000000000000000060006100ed61014d565b9050806001600160a01b0316826001600160a01b0316146101385760405163ef25d32b60e01b81526001600160a01b0380831660048301528316602482015260440160405180910390fd5b5050565b6000610148606461017e565b905090565b600061015761013c565b6101745760405163253a6fc960e11b815260040160405180910390fd5b61014860646101f7565b6000816001600160a01b031663175a260b6040518163ffffffff1660e01b815260040160206040518083038186803b1580156101b957600080fd5b505afa1580156101cd573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906101f19190610290565b92915050565b60006102028261017e565b61021f5760405163253a6fc960e11b815260040160405180910390fd5b816001600160a01b031663d74523b36040518163ffffffff1660e01b815260040160206040518083038186803b15801561025857600080fd5b505afa15801561026c573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906101f191906102b9565b6000602082840312156102a257600080fd5b815180151581146102b257600080fd5b9392505050565b6000602082840312156102cb57600080fd5b81516001600160a01b03811681146102b257600080fdfea264697066735822122020dd26a9e41b48ee14e75854ff4a758e4ee82aed6012912cef1d33f1ba7fc00b64736f6c63430008090033";

    public static final String FUNC_CROSSCHAINOWNERRESTRICTED = "crossChainOwnerRestricted";

    public static final String FUNC_CROSSCHAINRESTRICTED = "crossChainRestricted";

    public static final String FUNC_OWNER = "owner";

    @Deprecated
    protected CrossChainEnabledArbitrumL2Mock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected CrossChainEnabledArbitrumL2Mock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected CrossChainEnabledArbitrumL2Mock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected CrossChainEnabledArbitrumL2Mock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> crossChainOwnerRestricted() {
        final Function function = new Function(
                FUNC_CROSSCHAINOWNERRESTRICTED, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> crossChainRestricted() {
        final Function function = new Function(
                FUNC_CROSSCHAINRESTRICTED, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static CrossChainEnabledArbitrumL2Mock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new CrossChainEnabledArbitrumL2Mock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static CrossChainEnabledArbitrumL2Mock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new CrossChainEnabledArbitrumL2Mock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static CrossChainEnabledArbitrumL2Mock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new CrossChainEnabledArbitrumL2Mock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static CrossChainEnabledArbitrumL2Mock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new CrossChainEnabledArbitrumL2Mock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<CrossChainEnabledArbitrumL2Mock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(CrossChainEnabledArbitrumL2Mock.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<CrossChainEnabledArbitrumL2Mock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(CrossChainEnabledArbitrumL2Mock.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<CrossChainEnabledArbitrumL2Mock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(CrossChainEnabledArbitrumL2Mock.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<CrossChainEnabledArbitrumL2Mock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(CrossChainEnabledArbitrumL2Mock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
