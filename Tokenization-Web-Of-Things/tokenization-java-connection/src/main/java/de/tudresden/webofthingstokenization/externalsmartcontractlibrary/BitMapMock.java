package de.tudresden.webofthingstokenization.externalsmartcontractlibrary;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
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
public class BitMapMock extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b506101eb806100206000396000f3fe608060405234801561001057600080fd5b506004361061004c5760003560e01c8063088d22551461005157806360fe47b1146100845780639507d39a146100b4578063dcc9d43c146100fa575b600080fd5b61008261005f366004610167565b600881901c60009081526020819052604090208054600160ff84161b1916905550565b005b610082610092366004610167565b600881901c60009081526020819052604090208054600160ff84161b17905550565b6100e66100c2366004610167565b600881901c600090815260208190526040812054600160ff84161b16151592915050565b604051901515815260200160405180910390f35b610082610108366004610180565b61011460008383610118565b5050565b801561014257600882901c60009081526020849052604090208054600160ff85161b179055505050565b600882901c60009081526020849052604090208054600160ff85161b19169055505050565b60006020828403121561017957600080fd5b5035919050565b6000806040838503121561019357600080fd5b82359150602083013580151581146101aa57600080fd5b80915050925092905056fea2646970667358221220ff45bcb8c5af0225800fd60fd0a3756ed6de2d5d87b8138fcc48fd7892b2004164736f6c63430008090033";

    public static final String FUNC_GET = "get";

    public static final String FUNC_SET = "set";

    public static final String FUNC_SETTO = "setTo";

    public static final String FUNC_UNSET = "unset";

    @Deprecated
    protected BitMapMock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected BitMapMock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected BitMapMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected BitMapMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<Boolean> get(BigInteger index) {
        final Function function = new Function(FUNC_GET, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> set(BigInteger index) {
        final Function function = new Function(
                FUNC_SET, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(index)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setTo(BigInteger index, Boolean value) {
        final Function function = new Function(
                FUNC_SETTO, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(index), 
                new org.web3j.abi.datatypes.Bool(value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> unset(BigInteger index) {
        final Function function = new Function(
                FUNC_UNSET, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(index)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static BitMapMock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new BitMapMock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static BitMapMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new BitMapMock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static BitMapMock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new BitMapMock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static BitMapMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new BitMapMock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<BitMapMock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(BitMapMock.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<BitMapMock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(BitMapMock.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<BitMapMock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(BitMapMock.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<BitMapMock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(BitMapMock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
