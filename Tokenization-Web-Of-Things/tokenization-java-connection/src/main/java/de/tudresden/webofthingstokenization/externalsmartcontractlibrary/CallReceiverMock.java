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
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
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
public class CallReceiverMock extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b5061053e806100206000396000f3fe6080604052600436106100915760003560e01c8063a793ab4711610059578063a793ab47146100e3578063aa04f77e146100eb578063c8fc769614610100578063fc40cf731461012f578063fdb273251461014457600080fd5b80630c034968146100965780630f63e42c146100a05780632c81d638146100cb5780633bcfaa14146100d35780633e6fec04146100db575b600080fd5b61009e610157565b005b3480156100ac57600080fd5b506100b56101a3565b6040516100c29190610417565b60405180910390f35b61009e600080fd5b61009e6101f0565b6100b56101a3565b61009e6101fa565b3480156100f757600080fd5b506100b5610241565b34801561010c57600080fd5b506040805180820190915260068152650c1e0c4c8ccd60d21b60208201526100b5565b34801561013b57600080fd5b506100b5610290565b6100b561015236600461046c565b61031e565b60405162461bcd60e51b815260206004820152601b60248201527f43616c6c52656365697665724d6f636b3a20726576657274696e670000000000604482015260640160405180910390fd5b6040516060907f52c66ed6ec9ca819cba26fe2b2650059270d8981b295af300187a964f54a8c2390600090a1506040805180820190915260068152650c1e0c4c8ccd60d21b602082015290565b6101f861048e565b565b60005b6001805480820182556000919091527fb10e2d527612073b26eecdfd717e6a320cf44b4afac2b0732d9fcbe2b7fa0cf60181905561023a816104a4565b90506101fd565b604080518082019091526002808252611a1960f11b602090920191825260609161026e916000919061037e565b50506040805180820190915260068152650c1e0c4c8ccd60d21b602082015290565b6000805461029d906104cd565b80601f01602080910402602001604051908101604052809291908181526020018280546102c9906104cd565b80156103165780601f106102eb57610100808354040283529160200191610316565b820191906000526020600020905b8154815290600101906020018083116102f957829003601f168201915b505050505081565b60408051838152602081018390526060917f2b42b3c9af4187c86225f201736204c7597312c830cb5c2537dff6ef24b946ae910160405180910390a1506040805180820190915260068152650c1e0c4c8ccd60d21b602082015292915050565b82805461038a906104cd565b90600052602060002090601f0160209004810192826103ac57600085556103f2565b82601f106103c557805160ff19168380011785556103f2565b828001600101855582156103f2579182015b828111156103f25782518255916020019190600101906103d7565b506103fe929150610402565b5090565b5b808211156103fe5760008155600101610403565b600060208083528351808285015260005b8181101561044457858101830151858201604001528201610428565b81811115610456576000604083870101525b50601f01601f1916929092016040019392505050565b6000806040838503121561047f57600080fd5b50508035926020909101359150565b634e487b7160e01b600052600160045260246000fd5b60006000198214156104c657634e487b7160e01b600052601160045260246000fd5b5060010190565b600181811c908216806104e157607f821691505b6020821081141561050257634e487b7160e01b600052602260045260246000fd5b5091905056fea264697066735822122007764fce66e466750735ba2e4494415876a4bc3c6e5e38bf8035cbaeb1f5f80c64736f6c63430008090033";

    public static final String FUNC_MOCKFUNCTION = "mockFunction";

    public static final String FUNC_MOCKFUNCTIONNONPAYABLE = "mockFunctionNonPayable";

    public static final String FUNC_MOCKFUNCTIONOUTOFGAS = "mockFunctionOutOfGas";

    public static final String FUNC_MOCKFUNCTIONREVERTSNOREASON = "mockFunctionRevertsNoReason";

    public static final String FUNC_MOCKFUNCTIONREVERTSREASON = "mockFunctionRevertsReason";

    public static final String FUNC_MOCKFUNCTIONTHROWS = "mockFunctionThrows";

    public static final String FUNC_MOCKFUNCTIONWITHARGS = "mockFunctionWithArgs";

    public static final String FUNC_MOCKFUNCTIONWRITESSTORAGE = "mockFunctionWritesStorage";

    public static final String FUNC_MOCKSTATICFUNCTION = "mockStaticFunction";

    public static final String FUNC_SHAREDANSWER = "sharedAnswer";

    public static final Event MOCKFUNCTIONCALLED_EVENT = new Event("MockFunctionCalled", 
            Arrays.<TypeReference<?>>asList());
    ;

    public static final Event MOCKFUNCTIONCALLEDWITHARGS_EVENT = new Event("MockFunctionCalledWithArgs", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected CallReceiverMock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected CallReceiverMock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected CallReceiverMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected CallReceiverMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<MockFunctionCalledEventResponse> getMockFunctionCalledEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(MOCKFUNCTIONCALLED_EVENT, transactionReceipt);
        ArrayList<MockFunctionCalledEventResponse> responses = new ArrayList<MockFunctionCalledEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            MockFunctionCalledEventResponse typedResponse = new MockFunctionCalledEventResponse();
            typedResponse.log = eventValues.getLog();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<MockFunctionCalledEventResponse> mockFunctionCalledEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, MockFunctionCalledEventResponse>() {
            @Override
            public MockFunctionCalledEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(MOCKFUNCTIONCALLED_EVENT, log);
                MockFunctionCalledEventResponse typedResponse = new MockFunctionCalledEventResponse();
                typedResponse.log = log;
                return typedResponse;
            }
        });
    }

    public Flowable<MockFunctionCalledEventResponse> mockFunctionCalledEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(MOCKFUNCTIONCALLED_EVENT));
        return mockFunctionCalledEventFlowable(filter);
    }

    public static List<MockFunctionCalledWithArgsEventResponse> getMockFunctionCalledWithArgsEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(MOCKFUNCTIONCALLEDWITHARGS_EVENT, transactionReceipt);
        ArrayList<MockFunctionCalledWithArgsEventResponse> responses = new ArrayList<MockFunctionCalledWithArgsEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            MockFunctionCalledWithArgsEventResponse typedResponse = new MockFunctionCalledWithArgsEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.a = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.b = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<MockFunctionCalledWithArgsEventResponse> mockFunctionCalledWithArgsEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, MockFunctionCalledWithArgsEventResponse>() {
            @Override
            public MockFunctionCalledWithArgsEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(MOCKFUNCTIONCALLEDWITHARGS_EVENT, log);
                MockFunctionCalledWithArgsEventResponse typedResponse = new MockFunctionCalledWithArgsEventResponse();
                typedResponse.log = log;
                typedResponse.a = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.b = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<MockFunctionCalledWithArgsEventResponse> mockFunctionCalledWithArgsEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(MOCKFUNCTIONCALLEDWITHARGS_EVENT));
        return mockFunctionCalledWithArgsEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> mockFunction(BigInteger weiValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_MOCKFUNCTION, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<TransactionReceipt> mockFunctionNonPayable() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_MOCKFUNCTIONNONPAYABLE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> mockFunctionOutOfGas(BigInteger weiValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_MOCKFUNCTIONOUTOFGAS, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<TransactionReceipt> mockFunctionRevertsNoReason(BigInteger weiValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_MOCKFUNCTIONREVERTSNOREASON, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<TransactionReceipt> mockFunctionRevertsReason(BigInteger weiValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_MOCKFUNCTIONREVERTSREASON, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<TransactionReceipt> mockFunctionThrows(BigInteger weiValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_MOCKFUNCTIONTHROWS, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<TransactionReceipt> mockFunctionWithArgs(BigInteger a, BigInteger b, BigInteger weiValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_MOCKFUNCTIONWITHARGS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a), 
                new org.web3j.abi.datatypes.generated.Uint256(b)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<TransactionReceipt> mockFunctionWritesStorage() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_MOCKFUNCTIONWRITESSTORAGE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> mockStaticFunction() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_MOCKSTATICFUNCTION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> sharedAnswer() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_SHAREDANSWER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static CallReceiverMock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new CallReceiverMock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static CallReceiverMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new CallReceiverMock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static CallReceiverMock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new CallReceiverMock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static CallReceiverMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new CallReceiverMock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<CallReceiverMock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(CallReceiverMock.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<CallReceiverMock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(CallReceiverMock.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<CallReceiverMock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(CallReceiverMock.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<CallReceiverMock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(CallReceiverMock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class MockFunctionCalledEventResponse extends BaseEventResponse {
    }

    public static class MockFunctionCalledWithArgsEventResponse extends BaseEventResponse {
        public BigInteger a;

        public BigInteger b;
    }
}
