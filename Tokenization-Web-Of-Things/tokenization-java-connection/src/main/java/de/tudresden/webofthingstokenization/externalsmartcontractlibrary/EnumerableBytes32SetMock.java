package de.tudresden.webofthingstokenization.externalsmartcontractlibrary;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
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
public class EnumerableBytes32SetMock extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b5061048b806100206000396000f3fe608060405234801561001057600080fd5b50600436106100625760003560e01c80631d1a696d146100675780631f7b6d321461008f578063446bffba146100a557806395bc2673146100ba578063971217b7146100cd578063e0886f90146100e2575b600080fd5b61007a6100753660046103a7565b6100f5565b60405190151581526020015b60405180910390f35b610097610107565b604051908152602001610086565b6100b86100b33660046103a7565b610118565b005b6100b86100c83660046103a7565b610165565b6100d5610171565b60405161008691906103c0565b6100976100f03660046103a7565b61017d565b60006101018183610189565b92915050565b600061011360006101a4565b905090565b600061012481836101ae565b90507fed9840e0775590557ad736875d96c95cf1458b766335f74339951a32c82a9e3381604051610159911515815260200190565b60405180910390a15050565b600061012481836101ba565b606061011360006101c6565b600061010181836101d3565b600081815260018301602052604081205415155b9392505050565b6000610101825490565b600061019d83836101df565b600061019d838361022e565b6060600061019d83610321565b600061019d838361037d565b600081815260018301602052604081205461022657508154600181810184556000848152602080822090930184905584548482528286019093526040902091909155610101565b506000610101565b60008181526001830160205260408120548015610317576000610252600183610404565b855490915060009061026690600190610404565b90508181146102cb57600086600001828154811061028657610286610429565b90600052602060002001549050808760000184815481106102a9576102a9610429565b6000918252602080832090910192909255918252600188019052604090208390555b85548690806102dc576102dc61043f565b600190038181906000526020600020016000905590558560010160008681526020019081526020016000206000905560019350505050610101565b6000915050610101565b60608160000180548060200260200160405190810160405280929190818152602001828054801561037157602002820191906000526020600020905b81548152602001906001019080831161035d575b50505050509050919050565b600082600001828154811061039457610394610429565b9060005260206000200154905092915050565b6000602082840312156103b957600080fd5b5035919050565b6020808252825182820181905260009190848201906040850190845b818110156103f8578351835292840192918401916001016103dc565b50909695505050505050565b60008282101561042457634e487b7160e01b600052601160045260246000fd5b500390565b634e487b7160e01b600052603260045260246000fd5b634e487b7160e01b600052603160045260246000fdfea2646970667358221220c0339b120b2e7ad9239eba8d4717ce45009f21050fb6b84c0088dee8a8426cd364736f6c63430008090033";

    public static final String FUNC_ADD = "add";

    public static final String FUNC_AT = "at";

    public static final String FUNC_CONTAINS = "contains";

    public static final String FUNC_LENGTH = "length";

    public static final String FUNC_REMOVE = "remove";

    public static final String FUNC_VALUES = "values";

    public static final Event OPERATIONRESULT_EVENT = new Event("OperationResult", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
    ;

    @Deprecated
    protected EnumerableBytes32SetMock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected EnumerableBytes32SetMock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected EnumerableBytes32SetMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected EnumerableBytes32SetMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<OperationResultEventResponse> getOperationResultEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(OPERATIONRESULT_EVENT, transactionReceipt);
        ArrayList<OperationResultEventResponse> responses = new ArrayList<OperationResultEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            OperationResultEventResponse typedResponse = new OperationResultEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.result = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<OperationResultEventResponse> operationResultEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, OperationResultEventResponse>() {
            @Override
            public OperationResultEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(OPERATIONRESULT_EVENT, log);
                OperationResultEventResponse typedResponse = new OperationResultEventResponse();
                typedResponse.log = log;
                typedResponse.result = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<OperationResultEventResponse> operationResultEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OPERATIONRESULT_EVENT));
        return operationResultEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> add(byte[] value) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ADD, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<byte[]> at(BigInteger index) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_AT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<Boolean> contains(byte[] value) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_CONTAINS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(value)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<BigInteger> length() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_LENGTH, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> remove(byte[] value) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_REMOVE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<List> values() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_VALUES, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Bytes32>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    @Deprecated
    public static EnumerableBytes32SetMock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new EnumerableBytes32SetMock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static EnumerableBytes32SetMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new EnumerableBytes32SetMock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static EnumerableBytes32SetMock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new EnumerableBytes32SetMock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static EnumerableBytes32SetMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new EnumerableBytes32SetMock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<EnumerableBytes32SetMock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(EnumerableBytes32SetMock.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<EnumerableBytes32SetMock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(EnumerableBytes32SetMock.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<EnumerableBytes32SetMock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(EnumerableBytes32SetMock.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<EnumerableBytes32SetMock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(EnumerableBytes32SetMock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class OperationResultEventResponse extends BaseEventResponse {
        public Boolean result;
    }
}
