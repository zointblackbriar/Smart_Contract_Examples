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
public class CrossChainEnabledOptimismMock extends Contract {
    public static final String BINARY = "60c06040523360805234801561001457600080fd5b5060405161038738038061038783398101604081905261003391610044565b6001600160a01b031660a052610074565b60006020828403121561005657600080fd5b81516001600160a01b038116811461006d57600080fd5b9392505050565b60805160a0516102dc6100ab6000396000818160a50152818161017101526101b50152600081816055015260e801526102dc6000f3fe608060405234801561001057600080fd5b50600436106100415760003560e01c80634b074af5146100465780638da5cb5b14610050578063f97f518914610093575b600080fd5b61004e61009b565b005b6100777f000000000000000000000000000000000000000000000000000000000000000081565b6040516001600160a01b03909116815260200160405180910390f35b61004e6100e6565b6001600160a01b037f00000000000000000000000000000000000000000000000000000000000000001633146100e45760405163253a6fc960e11b815260040160405180910390fd5b565b7f00000000000000000000000000000000000000000000000000000000000000006000610111610165565b9050806001600160a01b0316826001600160a01b03161461015c5760405163ef25d32b60e01b81526001600160a01b0380831660048301528316602482015260440160405180910390fd5b5050565b905090565b60006001600160a01b037f00000000000000000000000000000000000000000000000000000000000000001633146101b05760405163253a6fc960e11b815260040160405180910390fd5b6101607f000000000000000000000000000000000000000000000000000000000000000060006001600160a01b03821633146101ff5760405163253a6fc960e11b815260040160405180910390fd5b816001600160a01b0316636e296e456040518163ffffffff1660e01b815260040160206040518083038186803b15801561023857600080fd5b505afa15801561024c573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906102709190610276565b92915050565b60006020828403121561028857600080fd5b81516001600160a01b038116811461029f57600080fd5b939250505056fea26469706673582212204d513f40b86562594242e80113995a319cfdf37ca1e0e96aea305f4e5b30de8e64736f6c63430008090033";

    public static final String FUNC_CROSSCHAINOWNERRESTRICTED = "crossChainOwnerRestricted";

    public static final String FUNC_CROSSCHAINRESTRICTED = "crossChainRestricted";

    public static final String FUNC_OWNER = "owner";

    @Deprecated
    protected CrossChainEnabledOptimismMock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected CrossChainEnabledOptimismMock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected CrossChainEnabledOptimismMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected CrossChainEnabledOptimismMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
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
    public static CrossChainEnabledOptimismMock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new CrossChainEnabledOptimismMock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static CrossChainEnabledOptimismMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new CrossChainEnabledOptimismMock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static CrossChainEnabledOptimismMock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new CrossChainEnabledOptimismMock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static CrossChainEnabledOptimismMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new CrossChainEnabledOptimismMock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<CrossChainEnabledOptimismMock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String bridge) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, bridge)));
        return deployRemoteCall(CrossChainEnabledOptimismMock.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<CrossChainEnabledOptimismMock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String bridge) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, bridge)));
        return deployRemoteCall(CrossChainEnabledOptimismMock.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<CrossChainEnabledOptimismMock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String bridge) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, bridge)));
        return deployRemoteCall(CrossChainEnabledOptimismMock.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<CrossChainEnabledOptimismMock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String bridge) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, bridge)));
        return deployRemoteCall(CrossChainEnabledOptimismMock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
