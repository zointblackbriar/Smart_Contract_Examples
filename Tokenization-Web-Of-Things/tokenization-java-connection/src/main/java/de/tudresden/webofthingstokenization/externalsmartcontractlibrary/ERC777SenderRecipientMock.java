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
public class ERC777SenderRecipientMock extends Contract {
    public static final String BINARY = "60806040526001805462010000600160b01b031916751820a4b7618bde71dce8cdc73aab6c95905fad24000017905534801561003a57600080fd5b50610bcd8061004a6000396000f3fe608060405234801561001057600080fd5b50600436106100a85760003560e01c806375ab97821161007157806375ab97821461012e578063a8badaa514610141578063c97e18fc14610154578063d2de64741461017c578063e0eb21801461018f578063e1ecbd30146101a257600080fd5b806223de29146100ad578063249cb3fa146100c25780633836ef89146100e757806344d17187146100fa5780634e4ae5a51461010d575b600080fd5b6100c06100bb3660046107b8565b6101b5565b005b6100d56100d0366004610869565b610325565b60405190815260200160405180910390f35b6100c06100f536600461093c565b61037d565b6100c06101083660046109a8565b6103e5565b6100c061011b366004610a01565b6001805460ff1916911515919091179055565b6100c061013c3660046107b8565b61044a565b6100c061014f366004610a23565b6105a0565b6100c0610162366004610a01565b600180549115156101000261ff0019909216919091179055565b6100c061018a366004610a23565b610636565b6100c061019d366004610a23565b61067f565b6100c06101b0366004610a23565b6106c4565b600154610100900460ff16156101ca57600080fd5b6000336040516370a0823160e01b81526001600160a01b038a811660048301529192506000918316906370a082319060240160206040518083038186803b15801561021457600080fd5b505afa158015610228573d6000803e3d6000fd5b505050506040513d601f19601f8201168201806040525081019061024c9190610a40565b6040516370a0823160e01b81526001600160a01b038a811660048301529192506000918416906370a082319060240160206040518083038186803b15801561029357600080fd5b505afa1580156102a7573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906102cb9190610a40565b90507f47e915878c47f3ec4d7ff646a2becb229f64fd2abe4d2b5e2bb4275b0cf50d4e8b8b8b8b8b8b8b8b8b8b8b6040516103109b9a99989796959493929190610a82565b60405180910390a15050505050505050505050565b6000828152602081815260408083206001600160a01b038516845290915281205460ff16610354576000610376565b7fa2ef4600d742022d532d4747cb3547474667d6f13804902513b2ec01c848f4b45b9392505050565b604051634decdde360e11b81526001600160a01b03851690639bd9bbc6906103ad90869086908690600401610b46565b600060405180830381600087803b1580156103c757600080fd5b505af11580156103db573d6000803e3d6000fd5b5050505050505050565b60405163fe9d930360e01b81526001600160a01b0384169063fe9d9303906104139085908590600401610b76565b600060405180830381600087803b15801561042d57600080fd5b505af1158015610441573d6000803e3d6000fd5b50505050505050565b60015460ff161561045a57600080fd5b6000336040516370a0823160e01b81526001600160a01b038a811660048301529192506000918316906370a082319060240160206040518083038186803b1580156104a457600080fd5b505afa1580156104b8573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906104dc9190610a40565b6040516370a0823160e01b81526001600160a01b038a811660048301529192506000918416906370a082319060240160206040518083038186803b15801561052357600080fd5b505afa158015610537573d6000803e3d6000fd5b505050506040513d601f19601f8201168201806040525081019061055b9190610a40565b90507faa3e88aca472e90221daf7d3d601abafb62b120319089d7a2c2f63588da855298b8b8b8b8b8b8b8b8b8b8b6040516103109b9a99989796959493929190610a82565b6001546040516329965a1d60e01b81523060048201527fb281fc8c12954d22544db45de3159a39272895b169a852b314f9cc762e44c53b60248201526001600160a01b03838116604483015262010000909204909116906329965a1d906064015b600060405180830381600087803b15801561061b57600080fd5b505af115801561062f573d6000803e3d6000fd5b5050505050565b6106607f29ddb589b1fb5fc7cf394961c1adf5f8c6454761adf795e67fe149f658abe89582610729565b306001600160a01b03821681141561067b5761067b816106c4565b5050565b6106a97fb281fc8c12954d22544db45de3159a39272895b169a852b314f9cc762e44c53b82610729565b306001600160a01b03821681141561067b5761067b816105a0565b6001546040516329965a1d60e01b81523060048201527f29ddb589b1fb5fc7cf394961c1adf5f8c6454761adf795e67fe149f658abe89560248201526001600160a01b03838116604483015262010000909204909116906329965a1d90606401610601565b6000918252602082815260408084206001600160a01b0390931684529190529020805460ff19166001179055565b6001600160a01b038116811461076c57600080fd5b50565b60008083601f84011261078157600080fd5b50813567ffffffffffffffff81111561079957600080fd5b6020830191508360208285010111156107b157600080fd5b9250929050565b60008060008060008060008060c0898b0312156107d457600080fd5b88356107df81610757565b975060208901356107ef81610757565b965060408901356107ff81610757565b955060608901359450608089013567ffffffffffffffff8082111561082357600080fd5b61082f8c838d0161076f565b909650945060a08b013591508082111561084857600080fd5b506108558b828c0161076f565b999c989b5096995094979396929594505050565b6000806040838503121561087c57600080fd5b82359150602083013561088e81610757565b809150509250929050565b634e487b7160e01b600052604160045260246000fd5b600082601f8301126108c057600080fd5b813567ffffffffffffffff808211156108db576108db610899565b604051601f8301601f19908116603f0116810190828211818310171561090357610903610899565b8160405283815286602085880101111561091c57600080fd5b836020870160208301376000602085830101528094505050505092915050565b6000806000806080858703121561095257600080fd5b843561095d81610757565b9350602085013561096d81610757565b925060408501359150606085013567ffffffffffffffff81111561099057600080fd5b61099c878288016108af565b91505092959194509250565b6000806000606084860312156109bd57600080fd5b83356109c881610757565b925060208401359150604084013567ffffffffffffffff8111156109eb57600080fd5b6109f7868287016108af565b9150509250925092565b600060208284031215610a1357600080fd5b8135801515811461037657600080fd5b600060208284031215610a3557600080fd5b813561037681610757565b600060208284031215610a5257600080fd5b5051919050565b81835281816020850137506000828201602090810191909152601f909101601f19169091010190565b6001600160a01b038c811682528b811660208301528a81166040830152606082018a905261012060808301819052600091610ac08483018b8d610a59565b915083820360a0850152610ad582898b610a59565b961660c0840152505060e08101929092526101009091015298975050505050505050565b6000815180845260005b81811015610b1f57602081850181015186830182015201610b03565b81811115610b31576000602083870101525b50601f01601f19169290920160200192915050565b60018060a01b0384168152826020820152606060408201526000610b6d6060830184610af9565b95945050505050565b828152604060208201526000610b8f6040830184610af9565b94935050505056fea2646970667358221220b57f1b9c4c024b3d9bf48b95d2d7ee628a6f13f6e63819f3e486fcc2e94c608264736f6c63430008090033";

    public static final String FUNC_BURN = "burn";

    public static final String FUNC_CANIMPLEMENTINTERFACEFORADDRESS = "canImplementInterfaceForAddress";

    public static final String FUNC_RECIPIENTFOR = "recipientFor";

    public static final String FUNC_REGISTERRECIPIENT = "registerRecipient";

    public static final String FUNC_REGISTERSENDER = "registerSender";

    public static final String FUNC_SEND = "send";

    public static final String FUNC_SENDERFOR = "senderFor";

    public static final String FUNC_SETSHOULDREVERTRECEIVE = "setShouldRevertReceive";

    public static final String FUNC_SETSHOULDREVERTSEND = "setShouldRevertSend";

    public static final String FUNC_TOKENSRECEIVED = "tokensReceived";

    public static final String FUNC_TOKENSTOSEND = "tokensToSend";

    public static final Event BEFORETOKENTRANSFER_EVENT = new Event("BeforeTokenTransfer", 
            Arrays.<TypeReference<?>>asList());
    ;

    public static final Event TOKENSRECEIVEDCALLED_EVENT = new Event("TokensReceivedCalled", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<DynamicBytes>() {}, new TypeReference<DynamicBytes>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event TOKENSTOSENDCALLED_EVENT = new Event("TokensToSendCalled", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<DynamicBytes>() {}, new TypeReference<DynamicBytes>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected ERC777SenderRecipientMock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ERC777SenderRecipientMock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ERC777SenderRecipientMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ERC777SenderRecipientMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<BeforeTokenTransferEventResponse> getBeforeTokenTransferEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(BEFORETOKENTRANSFER_EVENT, transactionReceipt);
        ArrayList<BeforeTokenTransferEventResponse> responses = new ArrayList<BeforeTokenTransferEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            BeforeTokenTransferEventResponse typedResponse = new BeforeTokenTransferEventResponse();
            typedResponse.log = eventValues.getLog();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<BeforeTokenTransferEventResponse> beforeTokenTransferEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, BeforeTokenTransferEventResponse>() {
            @Override
            public BeforeTokenTransferEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(BEFORETOKENTRANSFER_EVENT, log);
                BeforeTokenTransferEventResponse typedResponse = new BeforeTokenTransferEventResponse();
                typedResponse.log = log;
                return typedResponse;
            }
        });
    }

    public Flowable<BeforeTokenTransferEventResponse> beforeTokenTransferEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(BEFORETOKENTRANSFER_EVENT));
        return beforeTokenTransferEventFlowable(filter);
    }

    public static List<TokensReceivedCalledEventResponse> getTokensReceivedCalledEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(TOKENSRECEIVEDCALLED_EVENT, transactionReceipt);
        ArrayList<TokensReceivedCalledEventResponse> responses = new ArrayList<TokensReceivedCalledEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            TokensReceivedCalledEventResponse typedResponse = new TokensReceivedCalledEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.operator = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.from = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.to = (String) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(4).getValue();
            typedResponse.operatorData = (byte[]) eventValues.getNonIndexedValues().get(5).getValue();
            typedResponse.token = (String) eventValues.getNonIndexedValues().get(6).getValue();
            typedResponse.fromBalance = (BigInteger) eventValues.getNonIndexedValues().get(7).getValue();
            typedResponse.toBalance = (BigInteger) eventValues.getNonIndexedValues().get(8).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<TokensReceivedCalledEventResponse> tokensReceivedCalledEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, TokensReceivedCalledEventResponse>() {
            @Override
            public TokensReceivedCalledEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(TOKENSRECEIVEDCALLED_EVENT, log);
                TokensReceivedCalledEventResponse typedResponse = new TokensReceivedCalledEventResponse();
                typedResponse.log = log;
                typedResponse.operator = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.from = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.to = (String) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(4).getValue();
                typedResponse.operatorData = (byte[]) eventValues.getNonIndexedValues().get(5).getValue();
                typedResponse.token = (String) eventValues.getNonIndexedValues().get(6).getValue();
                typedResponse.fromBalance = (BigInteger) eventValues.getNonIndexedValues().get(7).getValue();
                typedResponse.toBalance = (BigInteger) eventValues.getNonIndexedValues().get(8).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<TokensReceivedCalledEventResponse> tokensReceivedCalledEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TOKENSRECEIVEDCALLED_EVENT));
        return tokensReceivedCalledEventFlowable(filter);
    }

    public static List<TokensToSendCalledEventResponse> getTokensToSendCalledEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(TOKENSTOSENDCALLED_EVENT, transactionReceipt);
        ArrayList<TokensToSendCalledEventResponse> responses = new ArrayList<TokensToSendCalledEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            TokensToSendCalledEventResponse typedResponse = new TokensToSendCalledEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.operator = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.from = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.to = (String) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(4).getValue();
            typedResponse.operatorData = (byte[]) eventValues.getNonIndexedValues().get(5).getValue();
            typedResponse.token = (String) eventValues.getNonIndexedValues().get(6).getValue();
            typedResponse.fromBalance = (BigInteger) eventValues.getNonIndexedValues().get(7).getValue();
            typedResponse.toBalance = (BigInteger) eventValues.getNonIndexedValues().get(8).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<TokensToSendCalledEventResponse> tokensToSendCalledEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, TokensToSendCalledEventResponse>() {
            @Override
            public TokensToSendCalledEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(TOKENSTOSENDCALLED_EVENT, log);
                TokensToSendCalledEventResponse typedResponse = new TokensToSendCalledEventResponse();
                typedResponse.log = log;
                typedResponse.operator = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.from = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.to = (String) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(4).getValue();
                typedResponse.operatorData = (byte[]) eventValues.getNonIndexedValues().get(5).getValue();
                typedResponse.token = (String) eventValues.getNonIndexedValues().get(6).getValue();
                typedResponse.fromBalance = (BigInteger) eventValues.getNonIndexedValues().get(7).getValue();
                typedResponse.toBalance = (BigInteger) eventValues.getNonIndexedValues().get(8).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<TokensToSendCalledEventResponse> tokensToSendCalledEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TOKENSTOSENDCALLED_EVENT));
        return tokensToSendCalledEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> burn(String token, BigInteger amount, byte[] data) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_BURN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, token), 
                new org.web3j.abi.datatypes.generated.Uint256(amount), 
                new org.web3j.abi.datatypes.DynamicBytes(data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<byte[]> canImplementInterfaceForAddress(byte[] interfaceHash, String account) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_CANIMPLEMENTINTERFACEFORADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(interfaceHash), 
                new org.web3j.abi.datatypes.Address(160, account)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<TransactionReceipt> recipientFor(String account) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_RECIPIENTFOR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, account)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> registerRecipient(String recipient) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_REGISTERRECIPIENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, recipient)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> registerSender(String sender) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_REGISTERSENDER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, sender)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> send(String token, String to, BigInteger amount, byte[] data) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SEND, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, token), 
                new org.web3j.abi.datatypes.Address(160, to), 
                new org.web3j.abi.datatypes.generated.Uint256(amount), 
                new org.web3j.abi.datatypes.DynamicBytes(data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> senderFor(String account) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SENDERFOR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, account)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setShouldRevertReceive(Boolean shouldRevert) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETSHOULDREVERTRECEIVE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Bool(shouldRevert)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setShouldRevertSend(Boolean shouldRevert) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETSHOULDREVERTSEND, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Bool(shouldRevert)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> tokensReceived(String operator, String from, String to, BigInteger amount, byte[] userData, byte[] operatorData) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TOKENSRECEIVED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, operator), 
                new org.web3j.abi.datatypes.Address(160, from), 
                new org.web3j.abi.datatypes.Address(160, to), 
                new org.web3j.abi.datatypes.generated.Uint256(amount), 
                new org.web3j.abi.datatypes.DynamicBytes(userData), 
                new org.web3j.abi.datatypes.DynamicBytes(operatorData)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> tokensToSend(String operator, String from, String to, BigInteger amount, byte[] userData, byte[] operatorData) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TOKENSTOSEND, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, operator), 
                new org.web3j.abi.datatypes.Address(160, from), 
                new org.web3j.abi.datatypes.Address(160, to), 
                new org.web3j.abi.datatypes.generated.Uint256(amount), 
                new org.web3j.abi.datatypes.DynamicBytes(userData), 
                new org.web3j.abi.datatypes.DynamicBytes(operatorData)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static ERC777SenderRecipientMock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ERC777SenderRecipientMock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ERC777SenderRecipientMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ERC777SenderRecipientMock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ERC777SenderRecipientMock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ERC777SenderRecipientMock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ERC777SenderRecipientMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ERC777SenderRecipientMock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ERC777SenderRecipientMock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ERC777SenderRecipientMock.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ERC777SenderRecipientMock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ERC777SenderRecipientMock.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<ERC777SenderRecipientMock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ERC777SenderRecipientMock.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ERC777SenderRecipientMock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ERC777SenderRecipientMock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class BeforeTokenTransferEventResponse extends BaseEventResponse {
    }

    public static class TokensReceivedCalledEventResponse extends BaseEventResponse {
        public String operator;

        public String from;

        public String to;

        public BigInteger amount;

        public byte[] data;

        public byte[] operatorData;

        public String token;

        public BigInteger fromBalance;

        public BigInteger toBalance;
    }

    public static class TokensToSendCalledEventResponse extends BaseEventResponse {
        public String operator;

        public String from;

        public String to;

        public BigInteger amount;

        public byte[] data;

        public byte[] operatorData;

        public String token;

        public BigInteger fromBalance;

        public BigInteger toBalance;
    }
}
