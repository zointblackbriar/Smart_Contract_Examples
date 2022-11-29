package de.tudresden.webofthingstokenization.externalsmartcontractlibrary;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
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
public class ConstructorInitializableMock extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50600054610100900460ff16158080156100315750600054600160ff909116105b8061005c575061004a3061011f60201b61023d1760201c565b15801561005c575060005460ff166001145b6100b25760405162461bcd60e51b815260206004820152602e602482015260008051602061054683398151915260448201526d191e481a5b9a5d1a585b1a5e995960921b60648201526084015b60405180910390fd5b6000805460ff1916600117905580156100d5576000805461ff0019166101001790555b6100dd61012e565b6100e5610235565b8015610119576000805461ff0019169055604051600181526000805160206105668339815191529060200160405180910390a15b506102b5565b6001600160a01b03163b151590565b600054610100900460ff161580801561014e5750600054600160ff909116105b8061017957506101673061011f60201b61023d1760201c565b158015610179575060005460ff166001145b6101ca5760405162461bcd60e51b815260206004820152602e602482015260008051602061054683398151915260448201526d191e481a5b9a5d1a585b1a5e995960921b60648201526084016100a9565b6000805460ff1916600117905580156101ed576000805461ff0019166101001790555b6000805462ff00001916620100001790558015610232576000805461ff0019169055604051600181526000805160206105668339815191529060200160405180910390a15b50565b600054610100900460ff166102a05760405162461bcd60e51b815260206004820152602b60248201527f496e697469616c697a61626c653a20636f6e7472616374206973206e6f74206960448201526a6e697469616c697a696e6760a81b60648201526084016100a9565b6000805463ff00000019166301000000179055565b610282806102c46000396000f3fe608060405234801561001057600080fd5b506004361061004c5760003560e01c806310065ed2146100515780637cffe97a1461005b5780638129fc1c14610083578063c3b8ef2a1461008b575b600080fd5b61005961009e565b005b60005461006f906301000000900460ff1681565b604051901515815260200160405180910390f35b610059610123565b60005461006f9062010000900460ff1681565b600054610100900460ff1661010e5760405162461bcd60e51b815260206004820152602b60248201527f496e697469616c697a61626c653a20636f6e7472616374206973206e6f74206960448201526a6e697469616c697a696e6760a81b60648201526084015b60405180910390fd5b6000805463ff00000019166301000000179055565b600054610100900460ff16158080156101435750600054600160ff909116105b8061015d5750303b15801561015d575060005460ff166001145b6101c05760405162461bcd60e51b815260206004820152602e60248201527f496e697469616c697a61626c653a20636f6e747261637420697320616c72656160448201526d191e481a5b9a5d1a585b1a5e995960921b6064820152608401610105565b6000805460ff1916600117905580156101e3576000805461ff0019166101001790555b6000805462ff0000191662010000179055801561023a576000805461ff0019169055604051600181527f7f26b83ff96e1f2b6a682f133852f6798a09c465da95921460cefb38474024989060200160405180910390a15b50565b6001600160a01b03163b15159056fea264697066735822122086bc96380380e2d54f13e60c6df4b5a5197dae72b7158fe13b323574b0613df364736f6c63430008090033496e697469616c697a61626c653a20636f6e747261637420697320616c7265617f26b83ff96e1f2b6a682f133852f6798a09c465da95921460cefb3847402498";

    public static final String FUNC_INITIALIZE = "initialize";

    public static final String FUNC_INITIALIZEONLYINITIALIZING = "initializeOnlyInitializing";

    public static final String FUNC_INITIALIZERRAN = "initializerRan";

    public static final String FUNC_ONLYINITIALIZINGRAN = "onlyInitializingRan";

    public static final Event INITIALIZED_EVENT = new Event("Initialized", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
    ;

    @Deprecated
    protected ConstructorInitializableMock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ConstructorInitializableMock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ConstructorInitializableMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ConstructorInitializableMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<InitializedEventResponse> getInitializedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(INITIALIZED_EVENT, transactionReceipt);
        ArrayList<InitializedEventResponse> responses = new ArrayList<InitializedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            InitializedEventResponse typedResponse = new InitializedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.version = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<InitializedEventResponse> initializedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, InitializedEventResponse>() {
            @Override
            public InitializedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(INITIALIZED_EVENT, log);
                InitializedEventResponse typedResponse = new InitializedEventResponse();
                typedResponse.log = log;
                typedResponse.version = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<InitializedEventResponse> initializedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(INITIALIZED_EVENT));
        return initializedEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> initialize() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_INITIALIZE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> initializeOnlyInitializing() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_INITIALIZEONLYINITIALIZING, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> initializerRan() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_INITIALIZERRAN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<Boolean> onlyInitializingRan() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ONLYINITIALIZINGRAN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    @Deprecated
    public static ConstructorInitializableMock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ConstructorInitializableMock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ConstructorInitializableMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ConstructorInitializableMock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ConstructorInitializableMock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ConstructorInitializableMock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ConstructorInitializableMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ConstructorInitializableMock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ConstructorInitializableMock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ConstructorInitializableMock.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<ConstructorInitializableMock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ConstructorInitializableMock.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ConstructorInitializableMock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ConstructorInitializableMock.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ConstructorInitializableMock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ConstructorInitializableMock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class InitializedEventResponse extends BaseEventResponse {
        public BigInteger version;
    }
}
