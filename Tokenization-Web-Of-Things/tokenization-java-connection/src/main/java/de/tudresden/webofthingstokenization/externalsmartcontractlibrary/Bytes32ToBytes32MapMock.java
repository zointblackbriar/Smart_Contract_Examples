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
public class Bytes32ToBytes32MapMock extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b5061076f806100206000396000f3fe608060405234801561001057600080fd5b50600436106100885760003560e01c806395bc26731161005b57806395bc2673146100f1578063dc09a8a714610106578063e0886f9014610130578063f71f7a251461015857600080fd5b80631d1a696d1461008d5780631f7b6d32146100b55780636cf3dff1146100cb5780638eaa6ac0146100de575b600080fd5b6100a061009b3660046105dc565b61016b565b60405190151581526020015b60405180910390f35b6100bd61017d565b6040519081526020016100ac565b6100bd6100d93660046105f5565b61018e565b6100bd6100ec3660046105dc565b6101da565b6101046100ff3660046105dc565b6101e6565b005b6101196101143660046105dc565b610233565b6040805192151583526020830191909152016100ac565b61014361013e3660046105dc565b610249565b604080519283526020830191909152016100ac565b610104610166366004610671565b610256565b600061017781836102a5565b92915050565b600061018960006102b8565b905090565b60006101d28484848080601f016020809104026020016040519081016040528093929190818152602001838380828437600092018290525094939250506102c39050565b949350505050565b60006101778183610318565b60006101f28183610388565b90507fed9840e0775590557ad736875d96c95cf1458b766335f74339951a32c82a9e3381604051610227911515815260200190565b60405180910390a15050565b60008061024081846103a5565b91509150915091565b60008061024081846103e2565b600061026381848461040d565b90507fed9840e0775590557ad736875d96c95cf1458b766335f74339951a32c82a9e3381604051610298911515815260200190565b60405180910390a1505050565b60006102b1838361042a565b9392505050565b600061017782610442565b6000828152600284016020526040812054801515806102e757506102e785856102a5565b839061030f5760405162461bcd60e51b81526004016103069190610693565b60405180910390fd5b50949350505050565b60008181526002830160205260408120548015158061033c575061033c84846102a5565b6102b15760405162461bcd60e51b815260206004820152601e60248201527f456e756d657261626c654d61703a206e6f6e6578697374656e74206b657900006044820152606401610306565b600081815260028301602052604081208190556102b1838361044c565b60008181526002830160205260408120548190806103d4576103c785856102a5565b9250600091506103db9050565b6001925090505b9250929050565b600080806103f08585610458565b600081815260029690960160205260409095205494959350505050565b600082815260028401602052604081208290556101d28484610464565b600081815260018301602052604081205415156102b1565b6000610177825490565b60006102b18383610470565b60006102b18383610563565b60006102b1838361058d565b600081815260018301602052604081205480156105595760006104946001836106e8565b85549091506000906104a8906001906106e8565b905081811461050d5760008660000182815481106104c8576104c861070d565b90600052602060002001549050808760000184815481106104eb576104eb61070d565b6000918252602080832090910192909255918252600188019052604090208390555b855486908061051e5761051e610723565b600190038181906000526020600020016000905590558560010160008681526020019081526020016000206000905560019350505050610177565b6000915050610177565b600082600001828154811061057a5761057a61070d565b9060005260206000200154905092915050565b60008181526001830160205260408120546105d457508154600181810184556000848152602080822090930184905584548482528286019093526040902091909155610177565b506000610177565b6000602082840312156105ee57600080fd5b5035919050565b60008060006040848603121561060a57600080fd5b83359250602084013567ffffffffffffffff8082111561062957600080fd5b818601915086601f83011261063d57600080fd5b81358181111561064c57600080fd5b87602082850101111561065e57600080fd5b6020830194508093505050509250925092565b6000806040838503121561068457600080fd5b50508035926020909101359150565b600060208083528351808285015260005b818110156106c0578581018301518582016040015282016106a4565b818111156106d2576000604083870101525b50601f01601f1916929092016040019392505050565b60008282101561070857634e487b7160e01b600052601160045260246000fd5b500390565b634e487b7160e01b600052603260045260246000fd5b634e487b7160e01b600052603160045260246000fdfea264697066735822122073ae3a169a1e0f88570901ab753ba6924ba76de570fb76172f054d5211e5be7b64736f6c63430008090033";

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
    protected Bytes32ToBytes32MapMock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Bytes32ToBytes32MapMock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Bytes32ToBytes32MapMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Bytes32ToBytes32MapMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
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

    public RemoteFunctionCall<Tuple2<byte[], byte[]>> at(BigInteger index) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_AT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}));
        return new RemoteFunctionCall<Tuple2<byte[], byte[]>>(function,
                new Callable<Tuple2<byte[], byte[]>>() {
                    @Override
                    public Tuple2<byte[], byte[]> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<byte[], byte[]>(
                                (byte[]) results.get(0).getValue(), 
                                (byte[]) results.get(1).getValue());
                    }
                });
    }

    public RemoteFunctionCall<Boolean> contains(byte[] key) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_CONTAINS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(key)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<byte[]> get(byte[] key) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GET, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(key)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<byte[]> getWithMessage(byte[] key, String errorMessage) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETWITHMESSAGE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(key), 
                new org.web3j.abi.datatypes.Utf8String(errorMessage)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<BigInteger> length() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_LENGTH, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> remove(byte[] key) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_REMOVE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(key)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> set(byte[] key, byte[] value) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SET, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(key), 
                new org.web3j.abi.datatypes.generated.Bytes32(value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple2<Boolean, byte[]>> tryGet(byte[] key) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_TRYGET, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(key)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}, new TypeReference<Bytes32>() {}));
        return new RemoteFunctionCall<Tuple2<Boolean, byte[]>>(function,
                new Callable<Tuple2<Boolean, byte[]>>() {
                    @Override
                    public Tuple2<Boolean, byte[]> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<Boolean, byte[]>(
                                (Boolean) results.get(0).getValue(), 
                                (byte[]) results.get(1).getValue());
                    }
                });
    }

    @Deprecated
    public static Bytes32ToBytes32MapMock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Bytes32ToBytes32MapMock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Bytes32ToBytes32MapMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Bytes32ToBytes32MapMock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Bytes32ToBytes32MapMock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Bytes32ToBytes32MapMock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Bytes32ToBytes32MapMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Bytes32ToBytes32MapMock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Bytes32ToBytes32MapMock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Bytes32ToBytes32MapMock.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Bytes32ToBytes32MapMock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Bytes32ToBytes32MapMock.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Bytes32ToBytes32MapMock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Bytes32ToBytes32MapMock.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Bytes32ToBytes32MapMock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Bytes32ToBytes32MapMock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class OperationResultEventResponse extends BaseEventResponse {
        public Boolean result;
    }
}
