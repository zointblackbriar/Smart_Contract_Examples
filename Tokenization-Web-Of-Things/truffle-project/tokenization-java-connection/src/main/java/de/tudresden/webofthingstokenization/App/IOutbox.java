package de.tudresden.webofthingstokenization.App;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint128;
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
 * <p>Generated with web3j version 4.8.9.
 */
@SuppressWarnings("rawtypes")
public class IOutbox extends Contract {
    public static final String BINARY = "";

    public static final String FUNC_OUTBOX_VERSION = "OUTBOX_VERSION";

    public static final String FUNC_BRIDGE = "bridge";

    public static final String FUNC_CALCULATEITEMHASH = "calculateItemHash";

    public static final String FUNC_CALCULATEMERKLEROOT = "calculateMerkleRoot";

    public static final String FUNC_EXECUTETRANSACTION = "executeTransaction";

    public static final String FUNC_EXECUTETRANSACTIONSIMULATION = "executeTransactionSimulation";

    public static final String FUNC_ISSPENT = "isSpent";

    public static final String FUNC_L2TOL1BLOCK = "l2ToL1Block";

    public static final String FUNC_L2TOL1ETHBLOCK = "l2ToL1EthBlock";

    public static final String FUNC_L2TOL1OUTPUTID = "l2ToL1OutputId";

    public static final String FUNC_L2TOL1SENDER = "l2ToL1Sender";

    public static final String FUNC_L2TOL1TIMESTAMP = "l2ToL1Timestamp";

    public static final String FUNC_ROLLUP = "rollup";

    public static final String FUNC_ROOTS = "roots";

    public static final String FUNC_SPENT = "spent";

    public static final String FUNC_UPDATESENDROOT = "updateSendRoot";

    public static final Event OUTBOXTRANSACTIONEXECUTED_EVENT = new Event("OutBoxTransactionExecuted", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event SENDROOTUPDATED_EVENT = new Event("SendRootUpdated", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Bytes32>(true) {}));
    ;

    @Deprecated
    protected IOutbox(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected IOutbox(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected IOutbox(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected IOutbox(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<OutBoxTransactionExecutedEventResponse> getOutBoxTransactionExecutedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(OUTBOXTRANSACTIONEXECUTED_EVENT, transactionReceipt);
        ArrayList<OutBoxTransactionExecutedEventResponse> responses = new ArrayList<OutBoxTransactionExecutedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            OutBoxTransactionExecutedEventResponse typedResponse = new OutBoxTransactionExecutedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.to = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.l2Sender = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.zero = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
            typedResponse.transactionIndex = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<OutBoxTransactionExecutedEventResponse> outBoxTransactionExecutedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, OutBoxTransactionExecutedEventResponse>() {
            @Override
            public OutBoxTransactionExecutedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(OUTBOXTRANSACTIONEXECUTED_EVENT, log);
                OutBoxTransactionExecutedEventResponse typedResponse = new OutBoxTransactionExecutedEventResponse();
                typedResponse.log = log;
                typedResponse.to = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.l2Sender = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.zero = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
                typedResponse.transactionIndex = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<OutBoxTransactionExecutedEventResponse> outBoxTransactionExecutedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OUTBOXTRANSACTIONEXECUTED_EVENT));
        return outBoxTransactionExecutedEventFlowable(filter);
    }

    public List<SendRootUpdatedEventResponse> getSendRootUpdatedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(SENDROOTUPDATED_EVENT, transactionReceipt);
        ArrayList<SendRootUpdatedEventResponse> responses = new ArrayList<SendRootUpdatedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            SendRootUpdatedEventResponse typedResponse = new SendRootUpdatedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.blockHash = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.outputRoot = (byte[]) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<SendRootUpdatedEventResponse> sendRootUpdatedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, SendRootUpdatedEventResponse>() {
            @Override
            public SendRootUpdatedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(SENDROOTUPDATED_EVENT, log);
                SendRootUpdatedEventResponse typedResponse = new SendRootUpdatedEventResponse();
                typedResponse.log = log;
                typedResponse.blockHash = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.outputRoot = (byte[]) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<SendRootUpdatedEventResponse> sendRootUpdatedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(SENDROOTUPDATED_EVENT));
        return sendRootUpdatedEventFlowable(filter);
    }

    public RemoteFunctionCall<BigInteger> OUTBOX_VERSION() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_OUTBOX_VERSION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint128>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> bridge() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_BRIDGE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<byte[]> calculateItemHash(String l2Sender, String to, BigInteger l2Block, BigInteger l1Block, BigInteger l2Timestamp, BigInteger value, byte[] data) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_CALCULATEITEMHASH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, l2Sender), 
                new org.web3j.abi.datatypes.Address(160, to), 
                new org.web3j.abi.datatypes.generated.Uint256(l2Block), 
                new org.web3j.abi.datatypes.generated.Uint256(l1Block), 
                new org.web3j.abi.datatypes.generated.Uint256(l2Timestamp), 
                new org.web3j.abi.datatypes.generated.Uint256(value), 
                new org.web3j.abi.datatypes.DynamicBytes(data)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<byte[]> calculateMerkleRoot(List<byte[]> proof, BigInteger path, byte[] item) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_CALCULATEMERKLEROOT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(proof, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.generated.Uint256(path), 
                new org.web3j.abi.datatypes.generated.Bytes32(item)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<TransactionReceipt> executeTransaction(List<byte[]> proof, BigInteger index, String l2Sender, String to, BigInteger l2Block, BigInteger l1Block, BigInteger l2Timestamp, BigInteger value, byte[] data) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_EXECUTETRANSACTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(proof, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.generated.Uint256(index), 
                new org.web3j.abi.datatypes.Address(160, l2Sender), 
                new org.web3j.abi.datatypes.Address(160, to), 
                new org.web3j.abi.datatypes.generated.Uint256(l2Block), 
                new org.web3j.abi.datatypes.generated.Uint256(l1Block), 
                new org.web3j.abi.datatypes.generated.Uint256(l2Timestamp), 
                new org.web3j.abi.datatypes.generated.Uint256(value), 
                new org.web3j.abi.datatypes.DynamicBytes(data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> executeTransactionSimulation(BigInteger index, String l2Sender, String to, BigInteger l2Block, BigInteger l1Block, BigInteger l2Timestamp, BigInteger value, byte[] data) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_EXECUTETRANSACTIONSIMULATION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(index), 
                new org.web3j.abi.datatypes.Address(160, l2Sender), 
                new org.web3j.abi.datatypes.Address(160, to), 
                new org.web3j.abi.datatypes.generated.Uint256(l2Block), 
                new org.web3j.abi.datatypes.generated.Uint256(l1Block), 
                new org.web3j.abi.datatypes.generated.Uint256(l2Timestamp), 
                new org.web3j.abi.datatypes.generated.Uint256(value), 
                new org.web3j.abi.datatypes.DynamicBytes(data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> isSpent(BigInteger index) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ISSPENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<BigInteger> l2ToL1Block() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_L2TOL1BLOCK, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> l2ToL1EthBlock() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_L2TOL1ETHBLOCK, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<byte[]> l2ToL1OutputId() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_L2TOL1OUTPUTID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<String> l2ToL1Sender() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_L2TOL1SENDER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> l2ToL1Timestamp() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_L2TOL1TIMESTAMP, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> rollup() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ROLLUP, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<byte[]> roots(byte[] param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ROOTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<byte[]> spent(BigInteger param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_SPENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<TransactionReceipt> updateSendRoot(byte[] sendRoot, byte[] l2BlockHash) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_UPDATESENDROOT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(sendRoot), 
                new org.web3j.abi.datatypes.generated.Bytes32(l2BlockHash)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static IOutbox load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new IOutbox(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static IOutbox load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new IOutbox(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static IOutbox load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new IOutbox(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static IOutbox load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new IOutbox(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<IOutbox> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(IOutbox.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<IOutbox> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IOutbox.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<IOutbox> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(IOutbox.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<IOutbox> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IOutbox.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class OutBoxTransactionExecutedEventResponse extends BaseEventResponse {
        public String to;

        public String l2Sender;

        public BigInteger zero;

        public BigInteger transactionIndex;
    }

    public static class SendRootUpdatedEventResponse extends BaseEventResponse {
        public byte[] blockHash;

        public byte[] outputRoot;
    }
}
