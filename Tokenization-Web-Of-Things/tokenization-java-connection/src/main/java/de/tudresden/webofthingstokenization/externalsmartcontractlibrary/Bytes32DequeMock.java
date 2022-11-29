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
public class Bytes32DequeMock extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b506105f8806100206000396000f3fe608060405234801561001057600080fd5b506004361061009e5760003560e01c80638dde0840116100665780638dde084014610134578063ba75bbd81461013c578063c39f130c14610144578063e0886f901461018d578063f2a75fe4146101a057600080fd5b80630df3aa97146100a3578063107dfb64146100f15780631f7b6d321461010c57806352efea6e1461012457806384d9fedd1461012c575b600080fd5b6100ef6100b1366004610552565b60008054600019600f91820b019081900b825260016020526040822083905581546001600160801b039091166001600160801b031990911617905550565b005b6100f96101c4565b6040519081526020015b60405180910390f35b600054600f81810b600160801b909204900b036100f9565b6100ef610216565b6100f9610221565b6100f961022e565b6100f961023a565b6100ef610152366004610552565b60008054600160801b90819004600f0b8083526001602081905260408420859055835491016001600160801b03908116909202911617905550565b6100f961019b366004610552565b610246565b600054600f81810b600160801b909204900b13156040519015158152602001610103565b6000806101d16000610258565b90507f103eed58ce9f94500a2c4079d50a53cb9a602378270d152a3004209a6a588e1d8160405161020491815260200190565b60405180910390a1919050565b905090565b61021f60008055565b565b6000806101d160006102d8565b6000610211600061034e565b600061021160006103b1565b60006102528183610405565b92915050565b60006102738254600f81810b600160801b909204900b131590565b1561029157604051631ed9509560e11b815260040160405180910390fd5b508054600160801b90819004600f90810b600019019081900b60009081526001840160205260408120805491905583546001600160801b0390811692169092021790915590565b60006102f38254600f81810b600160801b909204900b131590565b1561031157604051631ed9509560e11b815260040160405180910390fd5b508054600f0b6000818152600180840160205260408220805492905583546001600160801b03191692016001600160801b03169190911790915590565b60006103698254600f81810b600160801b909204900b131590565b1561038757604051631ed9509560e11b815260040160405180910390fd5b508054600160801b9004600f90810b60001901900b60009081526001909101602052604090205490565b60006103cc8254600f81810b600160801b909204900b131590565b156103ea57604051631ed9509560e11b815260040160405180910390fd5b508054600f0b60009081526001909101602052604090205490565b60008061042861041484610476565b85546104239190600f0b610581565b6104e9565b8454909150600160801b9004600f90810b9082900b1261045b57604051632d0483c560e21b815260040160405180910390fd5b600f0b60009081526001939093016020525050604090205490565b60006001600160ff1b038211156104e55760405162461bcd60e51b815260206004820152602860248201527f53616665436173743a2076616c756520646f65736e27742066697420696e2061604482015267371034b73a191a9b60c11b60648201526084015b60405180910390fd5b5090565b80600f81900b811461054d5760405162461bcd60e51b815260206004820152602760248201527f53616665436173743a2076616c756520646f65736e27742066697420696e20316044820152663238206269747360c81b60648201526084016104dc565b919050565b60006020828403121561056457600080fd5b5035919050565b634e487b7160e01b600052601160045260246000fd5b600080821280156001600160ff1b03849003851316156105a3576105a361056b565b600160ff1b83900384128116156105bc576105bc61056b565b5050019056fea2646970667358221220a6f2f9316e44b12b1d2f26ccbee477530beebcb4956433875485211b50e1c2e664736f6c63430008090033";

    public static final String FUNC_AT = "at";

    public static final String FUNC_BACK = "back";

    public static final String FUNC_CLEAR = "clear";

    public static final String FUNC_EMPTY = "empty";

    public static final String FUNC_FRONT = "front";

    public static final String FUNC_LENGTH = "length";

    public static final String FUNC_POPBACK = "popBack";

    public static final String FUNC_POPFRONT = "popFront";

    public static final String FUNC_PUSHBACK = "pushBack";

    public static final String FUNC_PUSHFRONT = "pushFront";

    public static final Event OPERATIONRESULT_EVENT = new Event("OperationResult", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
    ;

    @Deprecated
    protected Bytes32DequeMock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Bytes32DequeMock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Bytes32DequeMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Bytes32DequeMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<OperationResultEventResponse> getOperationResultEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(OPERATIONRESULT_EVENT, transactionReceipt);
        ArrayList<OperationResultEventResponse> responses = new ArrayList<OperationResultEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            OperationResultEventResponse typedResponse = new OperationResultEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.value = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
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
                typedResponse.value = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<OperationResultEventResponse> operationResultEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OPERATIONRESULT_EVENT));
        return operationResultEventFlowable(filter);
    }

    public RemoteFunctionCall<byte[]> at(BigInteger i) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_AT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(i)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<byte[]> back() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_BACK, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<TransactionReceipt> clear() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_CLEAR, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> empty() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_EMPTY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<byte[]> front() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_FRONT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<BigInteger> length() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_LENGTH, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> popBack() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_POPBACK, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> popFront() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_POPFRONT, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> pushBack(byte[] value) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_PUSHBACK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> pushFront(byte[] value) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_PUSHFRONT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Bytes32DequeMock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Bytes32DequeMock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Bytes32DequeMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Bytes32DequeMock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Bytes32DequeMock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Bytes32DequeMock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Bytes32DequeMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Bytes32DequeMock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Bytes32DequeMock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Bytes32DequeMock.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Bytes32DequeMock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Bytes32DequeMock.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Bytes32DequeMock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Bytes32DequeMock.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Bytes32DequeMock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Bytes32DequeMock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class OperationResultEventResponse extends BaseEventResponse {
        public byte[] value;
    }
}
