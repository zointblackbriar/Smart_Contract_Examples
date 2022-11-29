package de.tudresden.webofthingstokenization.externalsmartcontractlibrary;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
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
import org.web3j.tuples.generated.Tuple2;
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
public class UintToUintMapMock extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b506107de806100206000396000f3fe608060405234801561001057600080fd5b50600436106100885760003560e01c80639507d39a1161005b5780639507d39a146100fa578063c051a3a61461010d578063c34052e014610120578063e0886f901461014357600080fd5b80631ab06ee51461008d5780631f7b6d32146100a25780634cc82215146100bd578063871394d9146100d0575b600080fd5b6100a061009b36600461064b565b61016b565b005b6100aa6101ba565b6040519081526020015b60405180910390f35b6100a06100cb36600461066d565b6101cb565b6100e36100de36600461066d565b610218565b6040805192151583526020830191909152016100b4565b6100aa61010836600461066d565b61022e565b6100aa61011b366004610686565b610240565b61013361012e36600461066d565b61028c565b60405190151581526020016100b4565b61015661015136600461066d565b610298565b604080519283526020830191909152016100b4565b60006101788184846102a5565b90507fed9840e0775590557ad736875d96c95cf1458b766335f74339951a32c82a9e33816040516101ad911515815260200190565b60405180910390a1505050565b60006101c660006102b2565b905090565b60006101d781836102bd565b90507fed9840e0775590557ad736875d96c95cf1458b766335f74339951a32c82a9e338160405161020c911515815260200190565b60405180910390a15050565b60008061022581846102d0565b91509150915091565b600061023a81836102ee565b92915050565b60006102848484848080601f016020809104026020016040519081016040528093929190818152602001838380828437600092018290525094939250506102fa9050565b949350505050565b600061023a8183610307565b6000806102258184610313565b6000610284848484610322565b600061023a8261033f565b60006102c9838361034a565b9392505050565b60008080806102df8686610367565b909450925050505b9250929050565b60006102c983836103a1565b6000610284848484610416565b60006102c98383610462565b60008080806102df868661046e565b600082815260028401602052604081208290556102848484610499565b600061023a826104a5565b600081815260028301602052604081208190556102c983836104af565b6000818152600283016020526040812054819080610396576103898585610462565b9250600091506102e79050565b6001925090506102e7565b6000818152600283016020526040812054801515806103c557506103c58484610462565b6102c95760405162461bcd60e51b815260206004820152601e60248201527f456e756d657261626c654d61703a206e6f6e6578697374656e74206b6579000060448201526064015b60405180910390fd5b60008281526002840160205260408120548015158061043a575061043a8585610462565b83906104595760405162461bcd60e51b815260040161040d9190610702565b50949350505050565b60006102c983836104bb565b6000808061047c85856104d3565b600081815260029690960160205260409095205494959350505050565b60006102c983836104df565b600061023a825490565b60006102c9838361052e565b600081815260018301602052604081205415156102c9565b60006102c98383610621565b60008181526001830160205260408120546105265750815460018181018455600084815260208082209093018490558454848252828601909352604090209190915561023a565b50600061023a565b60008181526001830160205260408120548015610617576000610552600183610757565b855490915060009061056690600190610757565b90508181146105cb5760008660000182815481106105865761058661077c565b90600052602060002001549050808760000184815481106105a9576105a961077c565b6000918252602080832090910192909255918252600188019052604090208390555b85548690806105dc576105dc610792565b60019003818190600052602060002001600090559055856001016000868152602001908152602001600020600090556001935050505061023a565b600091505061023a565b60008260000182815481106106385761063861077c565b9060005260206000200154905092915050565b6000806040838503121561065e57600080fd5b50508035926020909101359150565b60006020828403121561067f57600080fd5b5035919050565b60008060006040848603121561069b57600080fd5b83359250602084013567ffffffffffffffff808211156106ba57600080fd5b818601915086601f8301126106ce57600080fd5b8135818111156106dd57600080fd5b8760208285010111156106ef57600080fd5b6020830194508093505050509250925092565b600060208083528351808285015260005b8181101561072f57858101830151858201604001528201610713565b81811115610741576000604083870101525b50601f01601f1916929092016040019392505050565b60008282101561077757634e487b7160e01b600052601160045260246000fd5b500390565b634e487b7160e01b600052603260045260246000fd5b634e487b7160e01b600052603160045260246000fdfea2646970667358221220a68df3720a2c577cf047c64bdf5e8c81fc6a915ecf7fa550506f5dfcd1527cc364736f6c63430008090033";

    public static final String FUNC_AT = "at";

    public static final String FUNC_CONTAINS = "contains";

    public static final String FUNC_GET = "get";

    public static final String FUNC_GETWITHMESSAGE = "getWithMessage";

    public static final String FUNC_LENGTH = "length";

    public static final String FUNC_REMOVE = "remove";

    public static final String FUNC_SET = "set";

    public static final String FUNC_TRYGET = "tryGet";

    public static final Event OPERATIONRESULT_EVENT = new Event("OperationResult", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
    ;

    @Deprecated
    protected UintToUintMapMock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected UintToUintMapMock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected UintToUintMapMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected UintToUintMapMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<OperationResultEventResponse> getOperationResultEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(OPERATIONRESULT_EVENT, transactionReceipt);
        ArrayList<OperationResultEventResponse> responses = new ArrayList<OperationResultEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            OperationResultEventResponse typedResponse = new OperationResultEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.result = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
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
                typedResponse.result = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<OperationResultEventResponse> operationResultEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OPERATIONRESULT_EVENT));
        return operationResultEventFlowable(filter);
    }

    public RemoteFunctionCall<Tuple2<BigInteger, BigInteger>> at(BigInteger index) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_AT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple2<BigInteger, BigInteger>>(function,
                new Callable<Tuple2<BigInteger, BigInteger>>() {
                    @Override
                    public Tuple2<BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<BigInteger, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue());
                    }
                });
    }

    public RemoteFunctionCall<Boolean> contains(BigInteger key) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_CONTAINS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(key)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<BigInteger> get(BigInteger key) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GET, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(key)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getWithMessage(BigInteger key, String errorMessage) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETWITHMESSAGE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(key), 
                new org.web3j.abi.datatypes.Utf8String(errorMessage)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> length() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_LENGTH, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> remove(BigInteger key) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_REMOVE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(key)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> set(BigInteger key, BigInteger value) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SET, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(key), 
                new org.web3j.abi.datatypes.generated.Uint256(value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple2<Boolean, BigInteger>> tryGet(BigInteger key) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_TRYGET, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(key)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple2<Boolean, BigInteger>>(function,
                new Callable<Tuple2<Boolean, BigInteger>>() {
                    @Override
                    public Tuple2<Boolean, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<Boolean, BigInteger>(
                                (Boolean) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue());
                    }
                });
    }

    @Deprecated
    public static UintToUintMapMock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new UintToUintMapMock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static UintToUintMapMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new UintToUintMapMock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static UintToUintMapMock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new UintToUintMapMock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static UintToUintMapMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new UintToUintMapMock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<UintToUintMapMock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(UintToUintMapMock.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<UintToUintMapMock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(UintToUintMapMock.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<UintToUintMapMock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(UintToUintMapMock.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<UintToUintMapMock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(UintToUintMapMock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class OperationResultEventResponse extends BaseEventResponse {
        public Boolean result;
    }
}
