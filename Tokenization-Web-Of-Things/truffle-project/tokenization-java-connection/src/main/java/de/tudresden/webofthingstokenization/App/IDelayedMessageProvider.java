package de.tudresden.webofthingstokenization.App;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.DynamicBytes;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
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
public class IDelayedMessageProvider extends Contract {
    public static final String BINARY = "";

    public static final Event INBOXMESSAGEDELIVERED_EVENT = new Event("InboxMessageDelivered", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}, new TypeReference<DynamicBytes>() {}));
    ;

    public static final Event INBOXMESSAGEDELIVEREDFROMORIGIN_EVENT = new Event("InboxMessageDeliveredFromOrigin", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}));
    ;

    @Deprecated
    protected IDelayedMessageProvider(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected IDelayedMessageProvider(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected IDelayedMessageProvider(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected IDelayedMessageProvider(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<InboxMessageDeliveredEventResponse> getInboxMessageDeliveredEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(INBOXMESSAGEDELIVERED_EVENT, transactionReceipt);
        ArrayList<InboxMessageDeliveredEventResponse> responses = new ArrayList<InboxMessageDeliveredEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            InboxMessageDeliveredEventResponse typedResponse = new InboxMessageDeliveredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.messageNum = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<InboxMessageDeliveredEventResponse> inboxMessageDeliveredEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, InboxMessageDeliveredEventResponse>() {
            @Override
            public InboxMessageDeliveredEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(INBOXMESSAGEDELIVERED_EVENT, log);
                InboxMessageDeliveredEventResponse typedResponse = new InboxMessageDeliveredEventResponse();
                typedResponse.log = log;
                typedResponse.messageNum = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<InboxMessageDeliveredEventResponse> inboxMessageDeliveredEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(INBOXMESSAGEDELIVERED_EVENT));
        return inboxMessageDeliveredEventFlowable(filter);
    }

    public List<InboxMessageDeliveredFromOriginEventResponse> getInboxMessageDeliveredFromOriginEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(INBOXMESSAGEDELIVEREDFROMORIGIN_EVENT, transactionReceipt);
        ArrayList<InboxMessageDeliveredFromOriginEventResponse> responses = new ArrayList<InboxMessageDeliveredFromOriginEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            InboxMessageDeliveredFromOriginEventResponse typedResponse = new InboxMessageDeliveredFromOriginEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.messageNum = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<InboxMessageDeliveredFromOriginEventResponse> inboxMessageDeliveredFromOriginEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, InboxMessageDeliveredFromOriginEventResponse>() {
            @Override
            public InboxMessageDeliveredFromOriginEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(INBOXMESSAGEDELIVEREDFROMORIGIN_EVENT, log);
                InboxMessageDeliveredFromOriginEventResponse typedResponse = new InboxMessageDeliveredFromOriginEventResponse();
                typedResponse.log = log;
                typedResponse.messageNum = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<InboxMessageDeliveredFromOriginEventResponse> inboxMessageDeliveredFromOriginEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(INBOXMESSAGEDELIVEREDFROMORIGIN_EVENT));
        return inboxMessageDeliveredFromOriginEventFlowable(filter);
    }

    @Deprecated
    public static IDelayedMessageProvider load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new IDelayedMessageProvider(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static IDelayedMessageProvider load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new IDelayedMessageProvider(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static IDelayedMessageProvider load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new IDelayedMessageProvider(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static IDelayedMessageProvider load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new IDelayedMessageProvider(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<IDelayedMessageProvider> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(IDelayedMessageProvider.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<IDelayedMessageProvider> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IDelayedMessageProvider.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<IDelayedMessageProvider> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(IDelayedMessageProvider.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<IDelayedMessageProvider> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IDelayedMessageProvider.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class InboxMessageDeliveredEventResponse extends BaseEventResponse {
        public BigInteger messageNum;

        public byte[] data;
    }

    public static class InboxMessageDeliveredFromOriginEventResponse extends BaseEventResponse {
        public BigInteger messageNum;
    }
}
