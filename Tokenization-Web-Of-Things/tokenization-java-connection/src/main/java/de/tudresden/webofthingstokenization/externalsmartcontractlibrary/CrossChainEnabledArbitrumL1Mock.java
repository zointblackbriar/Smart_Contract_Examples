package de.tudresden.webofthingstokenization.externalsmartcontractlibrary;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.FunctionEncoder;
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
public class CrossChainEnabledArbitrumL1Mock extends Contract {
    public static final String BINARY = "60c06040523360805234801561001457600080fd5b5060405161046838038061046883398101604081905261003391610044565b6001600160a01b031660a052610074565b60006020828403121561005657600080fd5b81516001600160a01b038116811461006d57600080fd5b9392505050565b60805160a0516103bd6100ab6000396000818160a50152818161017201526101b60152600081816055015260e801526103bd6000f3fe608060405234801561001057600080fd5b50600436106100415760003560e01c80634b074af5146100465780638da5cb5b14610050578063f97f518914610093575b600080fd5b61004e61009b565b005b6100777f000000000000000000000000000000000000000000000000000000000000000081565b6040516001600160a01b03909116815260200160405180910390f35b61004e6100e6565b6001600160a01b037f00000000000000000000000000000000000000000000000000000000000000001633146100e45760405163253a6fc960e11b815260040160405180910390fd5b565b7f00000000000000000000000000000000000000000000000000000000000000006000610111610166565b9050806001600160a01b0316826001600160a01b03161461015d5760405163ef25d32b60e01b81526001600160a01b038083166004830152831660248201526044015b60405180910390fd5b5050565b905090565b60006001600160a01b037f00000000000000000000000000000000000000000000000000000000000000001633146101b15760405163253a6fc960e11b815260040160405180910390fd5b6101617f000000000000000000000000000000000000000000000000000000000000000060006001600160a01b03821633146102005760405163253a6fc960e11b815260040160405180910390fd5b6000826001600160a01b031663ab5d89436040518163ffffffff1660e01b815260040160206040518083038186803b15801561023b57600080fd5b505afa15801561024f573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906102739190610357565b6001600160a01b03166380648b026040518163ffffffff1660e01b815260040160206040518083038186803b1580156102ab57600080fd5b505afa1580156102bf573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906102e39190610357565b90506001600160a01b0381166103515760405162461bcd60e51b815260206004820152602d60248201527f4c6962417262697472756d4c313a2073797374656d206d65737361676573207760448201526c34ba3437baba1039b2b73232b960991b6064820152608401610154565b92915050565b60006020828403121561036957600080fd5b81516001600160a01b038116811461038057600080fd5b939250505056fea2646970667358221220778845fd90e1ffd11c2ac528f4462a7f232b4ea6b8d3407de792b640f5e9e0d064736f6c63430008090033";

    public static final String FUNC_CROSSCHAINOWNERRESTRICTED = "crossChainOwnerRestricted";

    public static final String FUNC_CROSSCHAINRESTRICTED = "crossChainRestricted";

    public static final String FUNC_OWNER = "owner";

    @Deprecated
    protected CrossChainEnabledArbitrumL1Mock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected CrossChainEnabledArbitrumL1Mock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected CrossChainEnabledArbitrumL1Mock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected CrossChainEnabledArbitrumL1Mock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
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
    public static CrossChainEnabledArbitrumL1Mock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new CrossChainEnabledArbitrumL1Mock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static CrossChainEnabledArbitrumL1Mock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new CrossChainEnabledArbitrumL1Mock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static CrossChainEnabledArbitrumL1Mock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new CrossChainEnabledArbitrumL1Mock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static CrossChainEnabledArbitrumL1Mock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new CrossChainEnabledArbitrumL1Mock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<CrossChainEnabledArbitrumL1Mock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String bridge) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, bridge)));
        return deployRemoteCall(CrossChainEnabledArbitrumL1Mock.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<CrossChainEnabledArbitrumL1Mock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String bridge) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, bridge)));
        return deployRemoteCall(CrossChainEnabledArbitrumL1Mock.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<CrossChainEnabledArbitrumL1Mock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String bridge) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, bridge)));
        return deployRemoteCall(CrossChainEnabledArbitrumL1Mock.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<CrossChainEnabledArbitrumL1Mock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String bridge) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, bridge)));
        return deployRemoteCall(CrossChainEnabledArbitrumL1Mock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
