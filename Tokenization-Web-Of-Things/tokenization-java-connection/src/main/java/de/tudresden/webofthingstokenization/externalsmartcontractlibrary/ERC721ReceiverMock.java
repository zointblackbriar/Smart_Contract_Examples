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
public class ERC721ReceiverMock extends Contract {
    public static final String BINARY = "60c060405234801561001057600080fd5b506040516104d53803806104d583398101604081905261002f9161006e565b6001600160e01b0319821660805280600381111561004f5761004f6100b9565b60a0816003811115610063576100636100b9565b8152505050506100cf565b6000806040838503121561008157600080fd5b82516001600160e01b03198116811461009957600080fd5b6020840151909250600481106100ae57600080fd5b809150509250929050565b634e487b7160e01b600052602160045260246000fd5b60805160a0516103d56101006000396000818160660152818160ec015261012b015260006101b201526103d56000f3fe608060405234801561001057600080fd5b506004361061002b5760003560e01c8063150b7a0214610030575b600080fd5b61004361003e36600461020b565b610060565b6040516001600160e01b0319909116815260200160405180910390f35b600060017f00000000000000000000000000000000000000000000000000000000000000006003811115610096576100966102e7565b14156100e85760405162461bcd60e51b815260206004820152601d60248201527f45524337323152656365697665724d6f636b3a20726576657274696e67000000604482015260640160405180910390fd5b60027f0000000000000000000000000000000000000000000000000000000000000000600381111561011c5761011c6102e7565b141561012757600080fd5b60037f0000000000000000000000000000000000000000000000000000000000000000600381111561015b5761015b6102e7565b141561017057600061016d81806102fd565b50505b7f28fa6e16458f9c24aa59ddd4085264573006dbe30304837873c7deafc702b038858585855a6040516101a795949392919061031f565b60405180910390a1507f0000000000000000000000000000000000000000000000000000000000000000949350505050565b80356001600160a01b03811681146101f057600080fd5b919050565b634e487b7160e01b600052604160045260246000fd5b6000806000806080858703121561022157600080fd5b61022a856101d9565b9350610238602086016101d9565b925060408501359150606085013567ffffffffffffffff8082111561025c57600080fd5b818701915087601f83011261027057600080fd5b813581811115610282576102826101f5565b604051601f8201601f19908116603f011681019083821181831017156102aa576102aa6101f5565b816040528281528a60208487010111156102c357600080fd5b82602086016020830137600060208483010152809550505050505092959194509250565b634e487b7160e01b600052602160045260246000fd5b60008261031a57634e487b7160e01b600052601260045260246000fd5b500490565b600060018060a01b03808816835260208188168185015286604085015260a06060850152855191508160a085015260005b8281101561036c5786810182015185820160c001528101610350565b8281111561037e57600060c084870101525b5050608083019390935250601f91909101601f19160160c00194935050505056fea2646970667358221220e40e6a0b88234cdc3df34772c48661772d075099ac9c95b597b936c4a2d4f2c964736f6c63430008090033";

    public static final String FUNC_ONERC721RECEIVED = "onERC721Received";

    public static final Event RECEIVED_EVENT = new Event("Received", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<DynamicBytes>() {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected ERC721ReceiverMock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ERC721ReceiverMock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ERC721ReceiverMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ERC721ReceiverMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<ReceivedEventResponse> getReceivedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(RECEIVED_EVENT, transactionReceipt);
        ArrayList<ReceivedEventResponse> responses = new ArrayList<ReceivedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ReceivedEventResponse typedResponse = new ReceivedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.operator = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.from = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.tokenId = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.gas = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
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
                typedResponse.tokenId = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse.gas = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ReceivedEventResponse> receivedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(RECEIVED_EVENT));
        return receivedEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> onERC721Received(String operator, String from, BigInteger tokenId, byte[] data) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ONERC721RECEIVED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, operator), 
                new org.web3j.abi.datatypes.Address(160, from), 
                new org.web3j.abi.datatypes.generated.Uint256(tokenId), 
                new org.web3j.abi.datatypes.DynamicBytes(data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static ERC721ReceiverMock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ERC721ReceiverMock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ERC721ReceiverMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ERC721ReceiverMock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ERC721ReceiverMock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ERC721ReceiverMock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ERC721ReceiverMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ERC721ReceiverMock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ERC721ReceiverMock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, byte[] retval, BigInteger error) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes4(retval), 
                new org.web3j.abi.datatypes.generated.Uint8(error)));
        return deployRemoteCall(ERC721ReceiverMock.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<ERC721ReceiverMock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, byte[] retval, BigInteger error) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes4(retval), 
                new org.web3j.abi.datatypes.generated.Uint8(error)));
        return deployRemoteCall(ERC721ReceiverMock.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ERC721ReceiverMock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, byte[] retval, BigInteger error) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes4(retval), 
                new org.web3j.abi.datatypes.generated.Uint8(error)));
        return deployRemoteCall(ERC721ReceiverMock.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ERC721ReceiverMock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, byte[] retval, BigInteger error) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes4(retval), 
                new org.web3j.abi.datatypes.generated.Uint8(error)));
        return deployRemoteCall(ERC721ReceiverMock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class ReceivedEventResponse extends BaseEventResponse {
        public String operator;

        public String from;

        public BigInteger tokenId;

        public byte[] data;

        public BigInteger gas;
    }
}
