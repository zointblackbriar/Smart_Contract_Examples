package de.tudresden.webofthingstokenization.externalsmartcontractlibrary;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint64;
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
public class TimersTimestampImpl extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50610243806100206000396000f3fe608060405234801561001057600080fd5b506004361061007d5760003560e01c80635f8d96de1161005b5780635f8d96de146100e05780639c30ad7e14610107578063aebc04831461012a578063d826f88f1461015c57600080fd5b80632260fe3a146100825780632f13b60c146100b5578063544736e6146100bd575b600080fd5b604080516020810190915260005467ffffffffffffffff1690819052155b60405190151581526020015b60405180910390f35b6100a0610169565b604080516020810190915260005467ffffffffffffffff169081905215156100a0565b604080516020808201835260005467ffffffffffffffff16918290529151908152016100ac565b604080516020810190915260005467ffffffffffffffff169081905242106100a0565b61015a6101383660046101dc565b6000805467ffffffffffffffff831667ffffffffffffffff1990911617905550565b005b61015a61018e565b905090565b60408051602081019091526000805467ffffffffffffffff16825290610164906101a6565b6101a46000805467ffffffffffffffff19169055565b565b60006101bc825167ffffffffffffffff16151590565b80156101d6575042826000015167ffffffffffffffff1611155b92915050565b6000602082840312156101ee57600080fd5b813567ffffffffffffffff8116811461020657600080fd5b939250505056fea2646970667358221220256e432360f1bf6da0e7b26ea4ef08f032245f34113a50997011a8df70583e8564736f6c63430008090033";

    public static final String FUNC_GETDEADLINE = "getDeadline";

    public static final String FUNC_ISEXPIRED = "isExpired";

    public static final String FUNC_ISPENDING = "isPending";

    public static final String FUNC_ISSTARTED = "isStarted";

    public static final String FUNC_ISUNSET = "isUnset";

    public static final String FUNC_RESET = "reset";

    public static final String FUNC_SETDEADLINE = "setDeadline";

    @Deprecated
    protected TimersTimestampImpl(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected TimersTimestampImpl(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected TimersTimestampImpl(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected TimersTimestampImpl(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<BigInteger> getDeadline() {
        final Function function = new Function(FUNC_GETDEADLINE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint64>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Boolean> isExpired() {
        final Function function = new Function(FUNC_ISEXPIRED, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<Boolean> isPending() {
        final Function function = new Function(FUNC_ISPENDING, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<Boolean> isStarted() {
        final Function function = new Function(FUNC_ISSTARTED, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<Boolean> isUnset() {
        final Function function = new Function(FUNC_ISUNSET, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> reset() {
        final Function function = new Function(
                FUNC_RESET, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setDeadline(BigInteger timestamp) {
        final Function function = new Function(
                FUNC_SETDEADLINE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint64(timestamp)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static TimersTimestampImpl load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new TimersTimestampImpl(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static TimersTimestampImpl load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new TimersTimestampImpl(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static TimersTimestampImpl load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new TimersTimestampImpl(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static TimersTimestampImpl load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new TimersTimestampImpl(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<TimersTimestampImpl> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(TimersTimestampImpl.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<TimersTimestampImpl> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(TimersTimestampImpl.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<TimersTimestampImpl> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(TimersTimestampImpl.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<TimersTimestampImpl> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(TimersTimestampImpl.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
