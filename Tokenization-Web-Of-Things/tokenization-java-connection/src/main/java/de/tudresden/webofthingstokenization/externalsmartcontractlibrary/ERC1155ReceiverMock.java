package de.tudresden.webofthingstokenization.externalsmartcontractlibrary;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Array;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.DynamicBytes;
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
public class ERC1155ReceiverMock extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b506040516106df3803806106df83398101604081905261002f916100bd565b6000805491151569010000000000000000000260ff60481b1960e094851c65010000000000021664ffffffffff60281b199515156401000000000264ffffffffff199094169690941c95909517919091179290921617919091179055610111565b80516001600160e01b0319811681146100a857600080fd5b919050565b805180151581146100a857600080fd5b600080600080608085870312156100d357600080fd5b6100dc85610090565b93506100ea602086016100ad565b92506100f860408601610090565b9150610106606086016100ad565b905092959194509250565b6105bf806101206000396000f3fe608060405234801561001057600080fd5b50600436106100415760003560e01c806301ffc9a714610046578063bc197c811461007f578063f23a6e61146100ab575b600080fd5b61006a610054366004610261565b6001600160e01b0319166301ffc9a760e01b1490565b60405190151581526020015b60405180910390f35b61009261008d36600461033c565b6100be565b6040516001600160e01b03199091168152602001610076565b6100926100b93660046103f7565b61019f565b600080546901000000000000000000900460ff161561013c5760405162461bcd60e51b815260206004820152602f60248201527f4552433131353552656365697665724d6f636b3a20726576657274696e67206f60448201526e6e206261746368207265636569766560881b60648201526084015b60405180910390fd5b7f0bcad9224ba33b574e9c85298de2f44b4c80015a21aa5df474896444909863d889898989898989895a60405161017b999897969594939291906104ce565b60405180910390a15060005465010000000000900460e01b98975050505050505050565b60008054640100000000900460ff161561020d5760405162461bcd60e51b815260206004820152602960248201527f4552433131353552656365697665724d6f636b3a20726576657274696e67206f6044820152686e207265636569766560b81b6064820152608401610133565b7f20dfa9f79060c8c4d7fe892c97c71bcf6e3b63d1dcf66fea7aefc0211628cf298787878787875a604051610248979695949392919061053a565b60405180910390a15060005460e01b9695505050505050565b60006020828403121561027357600080fd5b81356001600160e01b03198116811461028b57600080fd5b9392505050565b80356001600160a01b03811681146102a957600080fd5b919050565b60008083601f8401126102c057600080fd5b50813567ffffffffffffffff8111156102d857600080fd5b6020830191508360208260051b85010111156102f357600080fd5b9250929050565b60008083601f84011261030c57600080fd5b50813567ffffffffffffffff81111561032457600080fd5b6020830191508360208285010111156102f357600080fd5b60008060008060008060008060a0898b03121561035857600080fd5b61036189610292565b975061036f60208a01610292565b9650604089013567ffffffffffffffff8082111561038c57600080fd5b6103988c838d016102ae565b909850965060608b01359150808211156103b157600080fd5b6103bd8c838d016102ae565b909650945060808b01359150808211156103d657600080fd5b506103e38b828c016102fa565b999c989b5096995094979396929594505050565b60008060008060008060a0878903121561041057600080fd5b61041987610292565b955061042760208801610292565b94506040870135935060608701359250608087013567ffffffffffffffff81111561045157600080fd5b61045d89828a016102fa565b979a9699509497509295939492505050565b81835260006001600160fb1b0383111561048857600080fd5b8260051b8083602087013760009401602001938452509192915050565b81835281816020850137506000828201602090810191909152601f909101601f19169091010190565b6001600160a01b038a811682528916602082015260c0604082018190526000906104fb908301898b61046f565b828103606084015261050e81888a61046f565b905082810360808401526105238186886104a5565b9150508260a08301529a9950505050505050505050565b6001600160a01b03888116825287166020820152604081018690526060810185905260c06080820181905260009061057590830185876104a5565b90508260a08301529897505050505050505056fea2646970667358221220d15932c95455adbd0b463b613275ffd3310b2dbea15f1c9e26c92c2f1a48b4bf64736f6c63430008090033";

    public static final String FUNC_ONERC1155BATCHRECEIVED = "onERC1155BatchReceived";

    public static final String FUNC_ONERC1155RECEIVED = "onERC1155Received";

    public static final String FUNC_SUPPORTSINTERFACE = "supportsInterface";

    public static final Event BATCHRECEIVED_EVENT = new Event("BatchReceived", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<DynamicArray<Uint256>>() {}, new TypeReference<DynamicArray<Uint256>>() {}, new TypeReference<DynamicBytes>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event RECEIVED_EVENT = new Event("Received", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<DynamicBytes>() {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected ERC1155ReceiverMock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ERC1155ReceiverMock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ERC1155ReceiverMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ERC1155ReceiverMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<BatchReceivedEventResponse> getBatchReceivedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(BATCHRECEIVED_EVENT, transactionReceipt);
        ArrayList<BatchReceivedEventResponse> responses = new ArrayList<BatchReceivedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            BatchReceivedEventResponse typedResponse = new BatchReceivedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.operator = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.from = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.ids = (List<BigInteger>) ((Array) eventValues.getNonIndexedValues().get(2)).getNativeValueCopy();
            typedResponse.values = (List<BigInteger>) ((Array) eventValues.getNonIndexedValues().get(3)).getNativeValueCopy();
            typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(4).getValue();
            typedResponse.gas = (BigInteger) eventValues.getNonIndexedValues().get(5).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<BatchReceivedEventResponse> batchReceivedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, BatchReceivedEventResponse>() {
            @Override
            public BatchReceivedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(BATCHRECEIVED_EVENT, log);
                BatchReceivedEventResponse typedResponse = new BatchReceivedEventResponse();
                typedResponse.log = log;
                typedResponse.operator = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.from = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.ids = (List<BigInteger>) ((Array) eventValues.getNonIndexedValues().get(2)).getNativeValueCopy();
                typedResponse.values = (List<BigInteger>) ((Array) eventValues.getNonIndexedValues().get(3)).getNativeValueCopy();
                typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(4).getValue();
                typedResponse.gas = (BigInteger) eventValues.getNonIndexedValues().get(5).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<BatchReceivedEventResponse> batchReceivedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(BATCHRECEIVED_EVENT));
        return batchReceivedEventFlowable(filter);
    }

    public static List<ReceivedEventResponse> getReceivedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(RECEIVED_EVENT, transactionReceipt);
        ArrayList<ReceivedEventResponse> responses = new ArrayList<ReceivedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ReceivedEventResponse typedResponse = new ReceivedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.operator = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.from = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.id = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(4).getValue();
            typedResponse.gas = (BigInteger) eventValues.getNonIndexedValues().get(5).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ReceivedEventResponse> receivedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ReceivedEventResponse>() {
            @Override
            public ReceivedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(RECEIVED_EVENT, log);
                ReceivedEventResponse typedResponse = new ReceivedEventResponse();
                typedResponse.log = log;
                typedResponse.operator = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.from = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.id = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(4).getValue();
                typedResponse.gas = (BigInteger) eventValues.getNonIndexedValues().get(5).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ReceivedEventResponse> receivedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(RECEIVED_EVENT));
        return receivedEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> onERC1155BatchReceived(String operator, String from, List<BigInteger> ids, List<BigInteger> values, byte[] data) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ONERC1155BATCHRECEIVED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, operator), 
                new org.web3j.abi.datatypes.Address(160, from), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(ids, org.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(values, org.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.web3j.abi.datatypes.DynamicBytes(data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> onERC1155Received(String operator, String from, BigInteger id, BigInteger value, byte[] data) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ONERC1155RECEIVED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, operator), 
                new org.web3j.abi.datatypes.Address(160, from), 
                new org.web3j.abi.datatypes.generated.Uint256(id), 
                new org.web3j.abi.datatypes.generated.Uint256(value), 
                new org.web3j.abi.datatypes.DynamicBytes(data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> supportsInterface(byte[] interfaceId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_SUPPORTSINTERFACE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes4(interfaceId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    @Deprecated
    public static ERC1155ReceiverMock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ERC1155ReceiverMock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ERC1155ReceiverMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ERC1155ReceiverMock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ERC1155ReceiverMock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ERC1155ReceiverMock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ERC1155ReceiverMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ERC1155ReceiverMock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ERC1155ReceiverMock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, byte[] recRetval, Boolean recReverts, byte[] batRetval, Boolean batReverts) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes4(recRetval), 
                new org.web3j.abi.datatypes.Bool(recReverts), 
                new org.web3j.abi.datatypes.generated.Bytes4(batRetval), 
                new org.web3j.abi.datatypes.Bool(batReverts)));
        return deployRemoteCall(ERC1155ReceiverMock.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<ERC1155ReceiverMock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, byte[] recRetval, Boolean recReverts, byte[] batRetval, Boolean batReverts) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes4(recRetval), 
                new org.web3j.abi.datatypes.Bool(recReverts), 
                new org.web3j.abi.datatypes.generated.Bytes4(batRetval), 
                new org.web3j.abi.datatypes.Bool(batReverts)));
        return deployRemoteCall(ERC1155ReceiverMock.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ERC1155ReceiverMock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, byte[] recRetval, Boolean recReverts, byte[] batRetval, Boolean batReverts) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes4(recRetval), 
                new org.web3j.abi.datatypes.Bool(recReverts), 
                new org.web3j.abi.datatypes.generated.Bytes4(batRetval), 
                new org.web3j.abi.datatypes.Bool(batReverts)));
        return deployRemoteCall(ERC1155ReceiverMock.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ERC1155ReceiverMock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, byte[] recRetval, Boolean recReverts, byte[] batRetval, Boolean batReverts) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes4(recRetval), 
                new org.web3j.abi.datatypes.Bool(recReverts), 
                new org.web3j.abi.datatypes.generated.Bytes4(batRetval), 
                new org.web3j.abi.datatypes.Bool(batReverts)));
        return deployRemoteCall(ERC1155ReceiverMock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class BatchReceivedEventResponse extends BaseEventResponse {
        public String operator;

        public String from;

        public List<BigInteger> ids;

        public List<BigInteger> values;

        public byte[] data;

        public BigInteger gas;
    }

    public static class ReceivedEventResponse extends BaseEventResponse {
        public String operator;

        public String from;

        public BigInteger id;

        public BigInteger value;

        public byte[] data;

        public BigInteger gas;
    }
}
