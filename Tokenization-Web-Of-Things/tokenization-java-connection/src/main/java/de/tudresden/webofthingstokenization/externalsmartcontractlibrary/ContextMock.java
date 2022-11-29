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
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicBytes;
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
public class ContextMock extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b5061025e806100206000396000f3fe608060405234801561001057600080fd5b50600436106100365760003560e01c8063376bf2621461003b578063d737d0c714610050575b600080fd5b61004e6100493660046100e5565b610058565b005b61004e61009a565b7faf235354a0a47c91ee171961326335cb2d1a8e55b8a89859b0e61eb049e50ea0600036848460405161008e94939291906101a0565b60405180910390a15050565b6040805133815290517fd6558c3ed910d959271054471fd1c326679d9fece99c5091b00ed89627cf2bfc9181900360200190a1565b634e487b7160e01b600052604160045260246000fd5b600080604083850312156100f857600080fd5b82359150602083013567ffffffffffffffff8082111561011757600080fd5b818501915085601f83011261012b57600080fd5b81358181111561013d5761013d6100cf565b604051601f8201601f19908116603f01168101908382118183101715610165576101656100cf565b8160405282815288602084870101111561017e57600080fd5b8260208601602083013760006020848301015280955050505050509250929050565b60608152836060820152838560808301376000608085830101526000601f1980601f8701168301602086818601526080858303016040860152855180608084015260005b818110156102005787810183015184820160a0015282016101e4565b8181111561021257600060a083860101525b50601f019092160160a00197965050505050505056fea264697066735822122044656a5880bb7d943706d7227ebbe0699b06c2b54993ce5e9c618e6ae2d4390b64736f6c63430008090033";

    public static final String FUNC_MSGDATA = "msgData";

    public static final String FUNC_MSGSENDER = "msgSender";

    public static final Event DATA_EVENT = new Event("Data", 
            Arrays.<TypeReference<?>>asList(new TypeReference<DynamicBytes>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}));
    ;

    public static final Event SENDER_EVENT = new Event("Sender", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    ;

    @Deprecated
    protected ContextMock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ContextMock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ContextMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ContextMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<DataEventResponse> getDataEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(DATA_EVENT, transactionReceipt);
        ArrayList<DataEventResponse> responses = new ArrayList<DataEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            DataEventResponse typedResponse = new DataEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.integerValue = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.stringValue = (String) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<DataEventResponse> dataEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, DataEventResponse>() {
            @Override
            public DataEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(DATA_EVENT, log);
                DataEventResponse typedResponse = new DataEventResponse();
                typedResponse.log = log;
                typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.integerValue = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.stringValue = (String) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<DataEventResponse> dataEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(DATA_EVENT));
        return dataEventFlowable(filter);
    }

    public static List<SenderEventResponse> getSenderEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(SENDER_EVENT, transactionReceipt);
        ArrayList<SenderEventResponse> responses = new ArrayList<SenderEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            SenderEventResponse typedResponse = new SenderEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.sender = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<SenderEventResponse> senderEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, SenderEventResponse>() {
            @Override
            public SenderEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(SENDER_EVENT, log);
                SenderEventResponse typedResponse = new SenderEventResponse();
                typedResponse.log = log;
                typedResponse.sender = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<SenderEventResponse> senderEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(SENDER_EVENT));
        return senderEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> msgData(BigInteger integerValue, String stringValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_MSGDATA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(integerValue), 
                new org.web3j.abi.datatypes.Utf8String(stringValue)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> msgSender() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_MSGSENDER, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static ContextMock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ContextMock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ContextMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ContextMock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ContextMock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ContextMock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ContextMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ContextMock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ContextMock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ContextMock.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ContextMock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ContextMock.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<ContextMock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ContextMock.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ContextMock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ContextMock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class DataEventResponse extends BaseEventResponse {
        public byte[] data;

        public BigInteger integerValue;

        public String stringValue;
    }

    public static class SenderEventResponse extends BaseEventResponse {
        public String sender;
    }
}
