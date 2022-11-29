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
public class EnumerableUintSetMock extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b5061048f806100206000396000f3fe608060405234801561001057600080fd5b50600436106100625760003560e01c80631003e2d2146100675780631f7b6d321461007c5780634cc8221514610097578063971217b7146100aa578063c34052e0146100bf578063e0886f90146100e2575b600080fd5b61007a6100753660046103ab565b6100f5565b005b610084610142565b6040519081526020015b60405180910390f35b61007a6100a53660046103ab565b610153565b6100b261015f565b60405161008e91906103c4565b6100d26100cd3660046103ab565b61016b565b604051901515815260200161008e565b6100846100f03660046103ab565b61017d565b60006101018183610189565b90507fed9840e0775590557ad736875d96c95cf1458b766335f74339951a32c82a9e3381604051610136911515815260200190565b60405180910390a15050565b600061014e600061019c565b905090565b600061010181836101a6565b606061014e60006101b2565b600061017781836101bf565b92915050565b600061017781836101d7565b600061019583836101e3565b9392505050565b6000610177825490565b60006101958383610232565b6060600061019583610325565b60008181526001830160205260408120541515610195565b60006101958383610381565b600081815260018301602052604081205461022a57508154600181810184556000848152602080822090930184905584548482528286019093526040902091909155610177565b506000610177565b6000818152600183016020526040812054801561031b576000610256600183610408565b855490915060009061026a90600190610408565b90508181146102cf57600086600001828154811061028a5761028a61042d565b90600052602060002001549050808760000184815481106102ad576102ad61042d565b6000918252602080832090910192909255918252600188019052604090208390555b85548690806102e0576102e0610443565b600190038181906000526020600020016000905590558560010160008681526020019081526020016000206000905560019350505050610177565b6000915050610177565b60608160000180548060200260200160405190810160405280929190818152602001828054801561037557602002820191906000526020600020905b815481526020019060010190808311610361575b50505050509050919050565b60008260000182815481106103985761039861042d565b9060005260206000200154905092915050565b6000602082840312156103bd57600080fd5b5035919050565b6020808252825182820181905260009190848201906040850190845b818110156103fc578351835292840192918401916001016103e0565b50909695505050505050565b60008282101561042857634e487b7160e01b600052601160045260246000fd5b500390565b634e487b7160e01b600052603260045260246000fd5b634e487b7160e01b600052603160045260246000fdfea2646970667358221220e59ce12c69bbbe5991a8e4666d20121f9f29c90ab19b8b9a5aa2008af2cfe00a64736f6c63430008090033";

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
    protected EnumerableUintSetMock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected EnumerableUintSetMock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected EnumerableUintSetMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected EnumerableUintSetMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
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

    public RemoteFunctionCall<TransactionReceipt> add(BigInteger value) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ADD, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> at(BigInteger index) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_AT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Boolean> contains(BigInteger value) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_CONTAINS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(value)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<BigInteger> length() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_LENGTH, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> remove(BigInteger value) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_REMOVE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<List> values() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_VALUES, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Uint256>>() {}));
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
    public static EnumerableUintSetMock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new EnumerableUintSetMock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static EnumerableUintSetMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new EnumerableUintSetMock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static EnumerableUintSetMock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new EnumerableUintSetMock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static EnumerableUintSetMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new EnumerableUintSetMock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<EnumerableUintSetMock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(EnumerableUintSetMock.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<EnumerableUintSetMock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(EnumerableUintSetMock.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<EnumerableUintSetMock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(EnumerableUintSetMock.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<EnumerableUintSetMock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(EnumerableUintSetMock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class OperationResultEventResponse extends BaseEventResponse {
        public Boolean result;
    }
}
