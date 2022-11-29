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
import org.web3j.abi.datatypes.Bool;
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
public class ERC2771ContextMock extends Contract {
    public static final String BINARY = "60a060405234801561001057600080fd5b506040516104f63803806104f683398101604081905261002f916100d8565b6001600160a01b0381166080527fd6558c3ed910d959271054471fd1c326679d9fece99c5091b00ed89627cf2bfc610065610086565b6040516001600160a01b03909116815260200160405180910390a150610108565b600061009a61009f60201b6101491760201c565b905090565b6080516000906001600160a01b03163314156100c2575060131936013560601c90565b61009a6100d460201b6101701760201c565b3390565b6000602082840312156100ea57600080fd5b81516001600160a01b038116811461010157600080fd5b9392505050565b6080516103d4610122600039600060d301526103d46000f3fe608060405234801561001057600080fd5b50600436106100415760003560e01c8063376bf26214610046578063572b6c051461005b578063d737d0c714610082575b600080fd5b6100596100543660046101dc565b61008a565b005b61006e610069366004610297565b6100d1565b604051901515815260200160405180910390f35b610059610103565b7faf235354a0a47c91ee171961326335cb2d1a8e55b8a89859b0e61eb049e50ea06100b3610174565b84846040516100c594939291906102c7565b60405180910390a15050565b7f00000000000000000000000000000000000000000000000000000000000000006001600160a01b0390811691161490565b7fd6558c3ed910d959271054471fd1c326679d9fece99c5091b00ed89627cf2bfc61012c610187565b6040516001600160a01b03909116815260200160405180910390a1565b6000610154336100d1565b15610166575060131936013560601c90565b503390565b905090565b3390565b36600061017f610191565b915091509091565b600061016b610149565b36600061019d336100d1565b156101be57600080366101b160148261034f565b9261017f93929190610374565b60003661017f565b634e487b7160e01b600052604160045260246000fd5b600080604083850312156101ef57600080fd5b82359150602083013567ffffffffffffffff8082111561020e57600080fd5b818501915085601f83011261022257600080fd5b813581811115610234576102346101c6565b604051601f8201601f19908116603f0116810190838211818310171561025c5761025c6101c6565b8160405282815288602084870101111561027557600080fd5b8260208601602083013760006020848301015280955050505050509250929050565b6000602082840312156102a957600080fd5b81356001600160a01b03811681146102c057600080fd5b9392505050565b60608152836060820152838560808301376000608085830101526000601f1980601f8701168301602086818601526080858303016040860152855180608084015260005b818110156103275787810183015184820160a00152820161030b565b8181111561033957600060a083860101525b50601f019092160160a001979650505050505050565b60008282101561036f57634e487b7160e01b600052601160045260246000fd5b500390565b6000808585111561038457600080fd5b8386111561039157600080fd5b505082019391909203915056fea26469706673582212201f786dbdedead0108d305257c822b62e2354b255dcbd75e831ab04065223a70964736f6c63430008090033";

    public static final String FUNC_ISTRUSTEDFORWARDER = "isTrustedForwarder";

    public static final String FUNC_MSGDATA = "msgData";

    public static final String FUNC_MSGSENDER = "msgSender";

    public static final Event DATA_EVENT = new Event("Data", 
            Arrays.<TypeReference<?>>asList(new TypeReference<DynamicBytes>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}));
    ;

    public static final Event SENDER_EVENT = new Event("Sender", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    ;

    @Deprecated
    protected ERC2771ContextMock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ERC2771ContextMock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ERC2771ContextMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ERC2771ContextMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
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

    public RemoteFunctionCall<Boolean> isTrustedForwarder(String forwarder) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ISTRUSTEDFORWARDER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, forwarder)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
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
    public static ERC2771ContextMock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ERC2771ContextMock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ERC2771ContextMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ERC2771ContextMock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ERC2771ContextMock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ERC2771ContextMock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ERC2771ContextMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ERC2771ContextMock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ERC2771ContextMock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String trustedForwarder) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, trustedForwarder)));
        return deployRemoteCall(ERC2771ContextMock.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<ERC2771ContextMock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String trustedForwarder) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, trustedForwarder)));
        return deployRemoteCall(ERC2771ContextMock.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ERC2771ContextMock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String trustedForwarder) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, trustedForwarder)));
        return deployRemoteCall(ERC2771ContextMock.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ERC2771ContextMock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String trustedForwarder) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, trustedForwarder)));
        return deployRemoteCall(ERC2771ContextMock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
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
