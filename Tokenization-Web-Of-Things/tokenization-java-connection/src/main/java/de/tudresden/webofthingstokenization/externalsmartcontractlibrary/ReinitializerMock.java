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
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
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
public class ReinitializerMock extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b5061056e806100206000396000f3fe608060405234801561001057600080fd5b50600436106100885760003560e01c80638129fc1c1161005b5780638129fc1c146100d9578063874f33a1146100e1578063b3c65015146100e9578063f8d6cdba146100fe57600080fd5b8063073de42e1461008d57806331f44900146100a257806361bc221a146100aa5780636b2d8f8f146100c6575b600080fd5b6100a061009b36600461044c565b610111565b005b6100a06101a6565b6100b360015481565b6040519081526020015b60405180910390f35b6100a06100d436600461046e565b6101b0565b6100a06101c6565b6100a061027e565b60005460405160ff90911681526020016100bd565b6100a061010c36600461046e565b610300565b6000548190610100900460ff16158015610132575060005460ff8083169116105b6101575760405162461bcd60e51b815260040161014e906104a1565b60405180910390fd5b6000805461ffff191660ff83161761010017905561017361027e565b6000805461ff001916905560405160ff821681526000805160206105198339815191529060200160405180910390a15050565b6101ae61038e565b565b6101b982610111565b6101c281610111565b5050565b600054610100900460ff16158080156101e65750600054600160ff909116105b806102005750303b158015610200575060005460ff166001145b61021c5760405162461bcd60e51b815260040161014e906104a1565b6000805460ff19166001179055801561023f576000805461ff0019166101001790555b61024761027e565b801561027b576000805461ff0019169055604051600181526000805160206105198339815191529060200160405180910390a15b50565b600054610100900460ff166102e95760405162461bcd60e51b815260206004820152602b60248201527f496e697469616c697a61626c653a20636f6e7472616374206973206e6f74206960448201526a6e697469616c697a696e6760a81b606482015260840161014e565b600180549060006102f9836104ef565b9190505550565b6000548290610100900460ff16158015610321575060005460ff8083169116105b61033d5760405162461bcd60e51b815260040161014e906104a1565b6000805461ffff191660ff83161761010017905561035a82610111565b6000805461ff001916905560405160ff821681526000805160206105198339815191529060200160405180910390a1505050565b600054610100900460ff16156103f65760405162461bcd60e51b815260206004820152602760248201527f496e697469616c697a61626c653a20636f6e747261637420697320696e697469604482015266616c697a696e6760c81b606482015260840161014e565b60005460ff908116146101ae576000805460ff191660ff9081179091556040519081526000805160206105198339815191529060200160405180910390a1565b803560ff8116811461044757600080fd5b919050565b60006020828403121561045e57600080fd5b61046782610436565b9392505050565b6000806040838503121561048157600080fd5b61048a83610436565b915061049860208401610436565b90509250929050565b6020808252602e908201527f496e697469616c697a61626c653a20636f6e747261637420697320616c72656160408201526d191e481a5b9a5d1a585b1a5e995960921b606082015260800190565b600060001982141561051157634e487b7160e01b600052601160045260246000fd5b506001019056fe7f26b83ff96e1f2b6a682f133852f6798a09c465da95921460cefb3847402498a264697066735822122059be42e6cdb4e098d7668ef89bd883b445d0a64ee1ae8aef57c719185f2a066964736f6c63430008090033";

    public static final String FUNC_CHAINREINITIALIZE = "chainReinitialize";

    public static final String FUNC_COUNTER = "counter";

    public static final String FUNC_DISABLEINITIALIZERS = "disableInitializers";

    public static final String FUNC_DOSTUFF = "doStuff";

    public static final String FUNC_GETINITIALIZEDVERSION = "getInitializedVersion";

    public static final String FUNC_INITIALIZE = "initialize";

    public static final String FUNC_NESTEDREINITIALIZE = "nestedReinitialize";

    public static final String FUNC_REINITIALIZE = "reinitialize";

    public static final Event INITIALIZED_EVENT = new Event("Initialized", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
    ;

    @Deprecated
    protected ReinitializerMock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ReinitializerMock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ReinitializerMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ReinitializerMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
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

    public RemoteFunctionCall<TransactionReceipt> chainReinitialize(BigInteger i, BigInteger j) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_CHAINREINITIALIZE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint8(i), 
                new org.web3j.abi.datatypes.generated.Uint8(j)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> counter() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_COUNTER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> disableInitializers() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_DISABLEINITIALIZERS, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> doStuff() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_DOSTUFF, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> getInitializedVersion() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETINITIALIZEDVERSION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> initialize() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_INITIALIZE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> nestedReinitialize(BigInteger i, BigInteger j) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_NESTEDREINITIALIZE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint8(i), 
                new org.web3j.abi.datatypes.generated.Uint8(j)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> reinitialize(BigInteger i) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_REINITIALIZE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint8(i)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static ReinitializerMock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ReinitializerMock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ReinitializerMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ReinitializerMock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ReinitializerMock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ReinitializerMock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ReinitializerMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ReinitializerMock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ReinitializerMock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ReinitializerMock.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ReinitializerMock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ReinitializerMock.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<ReinitializerMock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ReinitializerMock.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ReinitializerMock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ReinitializerMock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class InitializedEventResponse extends BaseEventResponse {
        public BigInteger version;
    }
}
