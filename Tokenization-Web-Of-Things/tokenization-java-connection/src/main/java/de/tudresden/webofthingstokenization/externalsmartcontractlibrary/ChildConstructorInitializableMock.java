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
public class ChildConstructorInitializableMock extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50600054610100900460ff16158080156100315750600054600160ff909116105b8061005c575061004a3061021b60201b6102fa1760201c565b15801561005c575060005460ff166001145b6100b25760405162461bcd60e51b815260206004820152602e602482015260008051602061085183398151915260448201526d191e481a5b9a5d1a585b1a5e995960921b60648201526084015b60405180910390fd5b6000805460ff1916600117905580156100d5576000805461ff0019166101001790555b6100dd61022a565b6100e5610332565b8015610119576000805461ff0019169055604051600181526000805160206108718339815191529060200160405180910390a15b50600054610100900460ff161580801561013a5750600054600160ff909116105b8061016557506101533061021b60201b6102fa1760201c565b158015610165575060005460ff166001145b6101b65760405162461bcd60e51b815260206004820152602e602482015260008051602061085183398151915260448201526d191e481a5b9a5d1a585b1a5e995960921b60648201526084016100a9565b6000805460ff1916600117905580156101d9576000805461ff0019166101001790555b6101e16103b2565b8015610215576000805461ff0019169055604051600181526000805160206108718339815191529060200160405180910390a15b506104b5565b6001600160a01b03163b151590565b600054610100900460ff161580801561024a5750600054600160ff909116105b8061027557506102633061021b60201b6102fa1760201c565b158015610275575060005460ff166001145b6102c65760405162461bcd60e51b815260206004820152602e602482015260008051602061085183398151915260448201526d191e481a5b9a5d1a585b1a5e995960921b60648201526084016100a9565b6000805460ff1916600117905580156102e9576000805461ff0019166101001790555b6000805462ff0000191662010000179055801561032f576000805461ff001916905560405160018152600080516020610871833981519152906020015b60405180910390a15b50565b600054610100900460ff1661039d5760405162461bcd60e51b815260206004820152602b60248201527f496e697469616c697a61626c653a20636f6e7472616374206973206e6f74206960448201526a6e697469616c697a696e6760a81b60648201526084016100a9565b6000805463ff00000019166301000000179055565b600054610100900460ff16158080156103d25750600054600160ff909116105b806103fd57506103eb3061021b60201b6102fa1760201c565b1580156103fd575060005460ff166001145b61044e5760405162461bcd60e51b815260206004820152602e602482015260008051602061085183398151915260448201526d191e481a5b9a5d1a585b1a5e995960921b60648201526084016100a9565b6000805460ff191660011790558015610471576000805461ff0019166101001790555b6000805460ff60201b1916640100000000179055801561032f576000805461ff00191690556040516001815260008051602061087183398151915290602001610326565b61038d806104c46000396000f3fe608060405234801561001057600080fd5b50600436106100625760003560e01c806310065ed2146100675780637cffe97a146100715780638129fc1c14610099578063b23d810b146100a1578063c3b8ef2a146100b6578063de74c703146100c9575b600080fd5b61006f6100d1565b005b600054610085906301000000900460ff1681565b604051901515815260200160405180910390f35b61006f610156565b60005461008590640100000000900460ff1681565b6000546100859062010000900460ff1681565b61006f61022a565b600054610100900460ff166101415760405162461bcd60e51b815260206004820152602b60248201527f496e697469616c697a61626c653a20636f6e7472616374206973206e6f74206960448201526a6e697469616c697a696e6760a81b60648201526084015b60405180910390fd5b6000805463ff00000019166301000000179055565b600054610100900460ff16158080156101765750600054600160ff909116105b806101905750303b158015610190575060005460ff166001145b6101ac5760405162461bcd60e51b815260040161013890610309565b6000805460ff1916600117905580156101cf576000805461ff0019166101001790555b6000805462ff00001916620100001790558015610227576000805461ff0019169055604051600181527f7f26b83ff96e1f2b6a682f133852f6798a09c465da95921460cefb3847402498906020015b60405180910390a15b50565b600054610100900460ff161580801561024a5750600054600160ff909116105b806102645750303b158015610264575060005460ff166001145b6102805760405162461bcd60e51b815260040161013890610309565b6000805460ff1916600117905580156102a3576000805461ff0019166101001790555b6000805464ff0000000019166401000000001790558015610227576000805461ff0019169055604051600181527f7f26b83ff96e1f2b6a682f133852f6798a09c465da95921460cefb38474024989060200161021e565b6001600160a01b03163b151590565b6020808252602e908201527f496e697469616c697a61626c653a20636f6e747261637420697320616c72656160408201526d191e481a5b9a5d1a585b1a5e995960921b60608201526080019056fea2646970667358221220f91be370059e589a8872cc11e60a34c78bd73b8ff648609e3104a514273f9e1f64736f6c63430008090033496e697469616c697a61626c653a20636f6e747261637420697320616c7265617f26b83ff96e1f2b6a682f133852f6798a09c465da95921460cefb3847402498";

    public static final String FUNC_CHILDINITIALIZE = "childInitialize";

    public static final String FUNC_CHILDINITIALIZERRAN = "childInitializerRan";

    public static final String FUNC_INITIALIZE = "initialize";

    public static final String FUNC_INITIALIZEONLYINITIALIZING = "initializeOnlyInitializing";

    public static final String FUNC_INITIALIZERRAN = "initializerRan";

    public static final String FUNC_ONLYINITIALIZINGRAN = "onlyInitializingRan";

    public static final Event INITIALIZED_EVENT = new Event("Initialized", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
    ;

    @Deprecated
    protected ChildConstructorInitializableMock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ChildConstructorInitializableMock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ChildConstructorInitializableMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ChildConstructorInitializableMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
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

    public RemoteFunctionCall<TransactionReceipt> childInitialize() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_CHILDINITIALIZE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> childInitializerRan() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_CHILDINITIALIZERRAN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
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
    public static ChildConstructorInitializableMock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ChildConstructorInitializableMock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ChildConstructorInitializableMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ChildConstructorInitializableMock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ChildConstructorInitializableMock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ChildConstructorInitializableMock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ChildConstructorInitializableMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ChildConstructorInitializableMock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ChildConstructorInitializableMock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ChildConstructorInitializableMock.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<ChildConstructorInitializableMock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ChildConstructorInitializableMock.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ChildConstructorInitializableMock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ChildConstructorInitializableMock.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ChildConstructorInitializableMock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ChildConstructorInitializableMock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class InitializedEventResponse extends BaseEventResponse {
        public BigInteger version;
    }
}
