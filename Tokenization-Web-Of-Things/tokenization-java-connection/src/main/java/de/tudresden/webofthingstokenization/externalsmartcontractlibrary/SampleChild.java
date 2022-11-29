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
public class SampleChild extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50610b2e806100206000396000f3fe608060405234801561001057600080fd5b506004361061009e5760003560e01c80638beaf7d7116100665780638beaf7d714610108578063ed7dfee31461011b578063f62d188814610124578063fa39851f14610137578063fe4b84df1461014c57600080fd5b80631c8aca3b146100a3578063237b5e96146100bf5780634a6c9db6146100c85780636f2edbd2146100eb5780638129fc1c14610100575b600080fd5b6100ac60035481565b6040519081526020015b60405180910390f35b6100ac60045481565b6000546100db9062010000900460ff1681565b60405190151581526020016100b6565b6100fe6100f93660046108bd565b61015f565b005b6100fe610228565b6100fe610116366004610914565b6102e0565b6100ac60015481565b6100fe610132366004610959565b61039c565b61013f610456565b6040516100b69190610996565b6100fe61015a3660046109eb565b6104e4565b600054610100900460ff161580801561017f5750600054600160ff909116105b806101995750303b158015610199575060005460ff166001145b6101be5760405162461bcd60e51b81526004016101b590610a04565b60405180910390fd5b6000805460ff1916600117905580156101e1576000805461ff0019166101001790555b6101ed85858585610566565b8015610221576000805461ff001916905560405160018152600080516020610ad98339815191529060200160405180910390a15b5050505050565b600054610100900460ff16158080156102485750600054600160ff909116105b806102625750303b158015610262575060005460ff166001145b61027e5760405162461bcd60e51b81526004016101b590610a04565b6000805460ff1916600117905580156102a1576000805461ff0019166101001790555b6102a96105af565b80156102dd576000805461ff001916905560405160018152600080516020610ad98339815191529060200160405180910390a15b50565b600054610100900460ff16158080156103005750600054600160ff909116105b8061031a5750303b15801561031a575060005460ff166001145b6103365760405162461bcd60e51b81526004016101b590610a04565b6000805460ff191660011790558015610359576000805461ff0019166101001790555b61036383836105e0565b8015610397576000805461ff001916905560405160018152600080516020610ad98339815191529060200160405180910390a15b505050565b600054610100900460ff16158080156103bc5750600054600160ff909116105b806103d65750303b1580156103d6575060005460ff166001145b6103f25760405162461bcd60e51b81526004016101b590610a04565b6000805460ff191660011790558015610415576000805461ff0019166101001790555b61041e82610619565b8015610452576000805461ff001916905560405160018152600080516020610ad98339815191529060200160405180910390a15b5050565b6002805461046390610a52565b80601f016020809104026020016040519081016040528092919081815260200182805461048f90610a52565b80156104dc5780601f106104b1576101008083540402835291602001916104dc565b820191906000526020600020905b8154815290600101906020018083116104bf57829003601f168201915b505050505081565b600054610100900460ff16158080156105045750600054600160ff909116105b8061051e5750303b15801561051e575060005460ff166001145b61053a5760405162461bcd60e51b81526004016101b590610a04565b6000805460ff19166001179055801561055d576000805461ff0019166101001790555b61041e82610651565b600054610100900460ff1661058d5760405162461bcd60e51b81526004016101b590610a8d565b61059684610651565b6105a083836105e0565b6105a981610689565b50505050565b600054610100900460ff166105d65760405162461bcd60e51b81526004016101b590610a8d565b6105de6106b5565b565b600054610100900460ff166106075760405162461bcd60e51b81526004016101b590610a8d565b61061082610619565b610452816106ef565b600054610100900460ff166106405760405162461bcd60e51b81526004016101b590610a8d565b6106486105af565b6102dd8161071b565b600054610100900460ff166106785760405162461bcd60e51b81526004016101b590610a8d565b6106806105af565b6102dd81610755565b600054610100900460ff166106b05760405162461bcd60e51b81526004016101b590610a8d565b600455565b600054610100900460ff166106dc5760405162461bcd60e51b81526004016101b590610a8d565b6000805462ff0000191662010000179055565b600054610100900460ff166107165760405162461bcd60e51b81526004016101b590610a8d565b600355565b600054610100900460ff166107425760405162461bcd60e51b81526004016101b590610a8d565b8051610452906002906020840190610781565b600054610100900460ff1661077c5760405162461bcd60e51b81526004016101b590610a8d565b600155565b82805461078d90610a52565b90600052602060002090601f0160209004810192826107af57600085556107f5565b82601f106107c857805160ff19168380011785556107f5565b828001600101855582156107f5579182015b828111156107f55782518255916020019190600101906107da565b50610801929150610805565b5090565b5b808211156108015760008155600101610806565b634e487b7160e01b600052604160045260246000fd5b600082601f83011261084157600080fd5b813567ffffffffffffffff8082111561085c5761085c61081a565b604051601f8301601f19908116603f011681019082821181831017156108845761088461081a565b8160405283815286602085880101111561089d57600080fd5b836020870160208301376000602085830101528094505050505092915050565b600080600080608085870312156108d357600080fd5b84359350602085013567ffffffffffffffff8111156108f157600080fd5b6108fd87828801610830565b949794965050505060408301359260600135919050565b6000806040838503121561092757600080fd5b823567ffffffffffffffff81111561093e57600080fd5b61094a85828601610830565b95602094909401359450505050565b60006020828403121561096b57600080fd5b813567ffffffffffffffff81111561098257600080fd5b61098e84828501610830565b949350505050565b600060208083528351808285015260005b818110156109c3578581018301518582016040015282016109a7565b818111156109d5576000604083870101525b50601f01601f1916929092016040019392505050565b6000602082840312156109fd57600080fd5b5035919050565b6020808252602e908201527f496e697469616c697a61626c653a20636f6e747261637420697320616c72656160408201526d191e481a5b9a5d1a585b1a5e995960921b606082015260800190565b600181811c90821680610a6657607f821691505b60208210811415610a8757634e487b7160e01b600052602260045260246000fd5b50919050565b6020808252602b908201527f496e697469616c697a61626c653a20636f6e7472616374206973206e6f74206960408201526a6e697469616c697a696e6760a81b60608201526080019056fe7f26b83ff96e1f2b6a682f133852f6798a09c465da95921460cefb3847402498a2646970667358221220ec4841f2535f253d918733f1929428530b81bd51040cef41878ccb9f77d3233e64736f6c63430008090033";

    public static final String FUNC_CHILD = "child";

    public static final String FUNC_FATHER = "father";

    public static final String FUNC_GRAMPS = "gramps";

    public static final String FUNC_initialize = "initialize";

    public static final String FUNC_ISHUMAN = "isHuman";

    public static final String FUNC_MOTHER = "mother";

    public static final Event INITIALIZED_EVENT = new Event("Initialized", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
    ;

    @Deprecated
    protected SampleChild(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected SampleChild(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected SampleChild(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected SampleChild(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
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

    public RemoteFunctionCall<BigInteger> child() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_CHILD, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
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

    public RemoteFunctionCall<TransactionReceipt> initialize(BigInteger _mother, String _gramps, BigInteger _father, BigInteger _child) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_initialize, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_mother), 
                new org.web3j.abi.datatypes.Utf8String(_gramps), 
                new org.web3j.abi.datatypes.generated.Uint256(_father), 
                new org.web3j.abi.datatypes.generated.Uint256(_child)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
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

    public RemoteFunctionCall<TransactionReceipt> initialize(BigInteger value) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_initialize, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> isHuman() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ISHUMAN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<BigInteger> mother() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_MOTHER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static SampleChild load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new SampleChild(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static SampleChild load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new SampleChild(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static SampleChild load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new SampleChild(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static SampleChild load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new SampleChild(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<SampleChild> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(SampleChild.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<SampleChild> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SampleChild.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<SampleChild> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(SampleChild.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<SampleChild> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SampleChild.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class InitializedEventResponse extends BaseEventResponse {
        public BigInteger version;
    }
}
