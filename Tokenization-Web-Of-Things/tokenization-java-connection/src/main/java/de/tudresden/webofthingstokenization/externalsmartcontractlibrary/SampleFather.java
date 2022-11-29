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
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
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
public class SampleFather extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50610840806100206000396000f3fe608060405234801561001057600080fd5b50600436106100625760003560e01c80631c8aca3b146100675780634a6c9db6146100835780638129fc1c146100a65780638beaf7d7146100b0578063f62d1888146100c3578063fa39851f146100d6575b600080fd5b61007060025481565b6040519081526020015b60405180910390f35b6000546100969062010000900460ff1681565b604051901515815260200161007a565b6100ae6100eb565b005b6100ae6100be36600461065f565b6101be565b6100ae6100d13660046106a4565b61028c565b6100de610358565b60405161007a91906106e1565b600054610100900460ff161580801561010b5750600054600160ff909116105b806101255750303b158015610125575060005460ff166001145b61014a5760405162461bcd60e51b815260040161014190610736565b60405180910390fd5b6000805460ff19166001179055801561016d576000805461ff0019166101001790555b6101756103e6565b80156101bb576000805461ff0019169055604051600181527f7f26b83ff96e1f2b6a682f133852f6798a09c465da95921460cefb38474024989060200160405180910390a15b50565b600054610100900460ff16158080156101de5750600054600160ff909116105b806101f85750303b1580156101f8575060005460ff166001145b6102145760405162461bcd60e51b815260040161014190610736565b6000805460ff191660011790558015610237576000805461ff0019166101001790555b6102418383610417565b8015610287576000805461ff0019169055604051600181527f7f26b83ff96e1f2b6a682f133852f6798a09c465da95921460cefb38474024989060200160405180910390a15b505050565b600054610100900460ff16158080156102ac5750600054600160ff909116105b806102c65750303b1580156102c6575060005460ff166001145b6102e25760405162461bcd60e51b815260040161014190610736565b6000805460ff191660011790558015610305576000805461ff0019166101001790555b61030e82610450565b8015610354576000805461ff0019169055604051600181527f7f26b83ff96e1f2b6a682f133852f6798a09c465da95921460cefb38474024989060200160405180910390a15b5050565b6001805461036590610784565b80601f016020809104026020016040519081016040528092919081815260200182805461039190610784565b80156103de5780601f106103b3576101008083540402835291602001916103de565b820191906000526020600020905b8154815290600101906020018083116103c157829003601f168201915b505050505081565b600054610100900460ff1661040d5760405162461bcd60e51b8152600401610141906107bf565b610415610488565b565b600054610100900460ff1661043e5760405162461bcd60e51b8152600401610141906107bf565b61044782610450565b610354816104c2565b600054610100900460ff166104775760405162461bcd60e51b8152600401610141906107bf565b61047f6103e6565b6101bb816104ee565b600054610100900460ff166104af5760405162461bcd60e51b8152600401610141906107bf565b6000805462ff0000191662010000179055565b600054610100900460ff166104e95760405162461bcd60e51b8152600401610141906107bf565b600255565b600054610100900460ff166105155760405162461bcd60e51b8152600401610141906107bf565b805161035490600190602084019082805461052f90610784565b90600052602060002090601f0160209004810192826105515760008555610597565b82601f1061056a57805160ff1916838001178555610597565b82800160010185558215610597579182015b8281111561059757825182559160200191906001019061057c565b506105a39291506105a7565b5090565b5b808211156105a357600081556001016105a8565b634e487b7160e01b600052604160045260246000fd5b600082601f8301126105e357600080fd5b813567ffffffffffffffff808211156105fe576105fe6105bc565b604051601f8301601f19908116603f01168101908282118183101715610626576106266105bc565b8160405283815286602085880101111561063f57600080fd5b836020870160208301376000602085830101528094505050505092915050565b6000806040838503121561067257600080fd5b823567ffffffffffffffff81111561068957600080fd5b610695858286016105d2565b95602094909401359450505050565b6000602082840312156106b657600080fd5b813567ffffffffffffffff8111156106cd57600080fd5b6106d9848285016105d2565b949350505050565b600060208083528351808285015260005b8181101561070e578581018301518582016040015282016106f2565b81811115610720576000604083870101525b50601f01601f1916929092016040019392505050565b6020808252602e908201527f496e697469616c697a61626c653a20636f6e747261637420697320616c72656160408201526d191e481a5b9a5d1a585b1a5e995960921b606082015260800190565b600181811c9082168061079857607f821691505b602082108114156107b957634e487b7160e01b600052602260045260246000fd5b50919050565b6020808252602b908201527f496e697469616c697a61626c653a20636f6e7472616374206973206e6f74206960408201526a6e697469616c697a696e6760a81b60608201526080019056fea2646970667358221220e3af0b5766fa4181d629ac30dbdf3f758bc70d2fb835f1fef66f22244cdc6e7864736f6c63430008090033";

    public static final String FUNC_FATHER = "father";

    public static final String FUNC_GRAMPS = "gramps";

    public static final String FUNC_initialize = "initialize";

    public static final String FUNC_ISHUMAN = "isHuman";

    public static final Event INITIALIZED_EVENT = new Event("Initialized", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
    ;

    @Deprecated
    protected SampleFather(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected SampleFather(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected SampleFather(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected SampleFather(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<InitializedEventResponse> getInitializedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(INITIALIZED_EVENT, transactionReceipt);
        ArrayList<InitializedEventResponse> responses = new ArrayList<InitializedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            InitializedEventResponse typedResponse = new InitializedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.version = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<InitializedEventResponse> initializedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, InitializedEventResponse>() {
            @Override
            public InitializedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(INITIALIZED_EVENT, log);
                InitializedEventResponse typedResponse = new InitializedEventResponse();
                typedResponse.log = log;
                typedResponse.version = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<InitializedEventResponse> initializedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(INITIALIZED_EVENT));
        return initializedEventFlowable(filter);
    }

    public RemoteFunctionCall<BigInteger> father() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_FATHER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> gramps() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GRAMPS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> initialize() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_initialize, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> initialize(String _gramps, BigInteger _father) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_initialize, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_gramps), 
                new org.web3j.abi.datatypes.generated.Uint256(_father)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> initialize(String value) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_initialize, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> isHuman() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ISHUMAN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    @Deprecated
    public static SampleFather load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new SampleFather(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static SampleFather load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new SampleFather(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static SampleFather load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new SampleFather(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static SampleFather load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new SampleFather(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<SampleFather> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(SampleFather.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<SampleFather> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SampleFather.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<SampleFather> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(SampleFather.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<SampleFather> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SampleFather.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class InitializedEventResponse extends BaseEventResponse {
        public BigInteger version;
    }
}
