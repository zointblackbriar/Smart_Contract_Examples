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
public class Bytes32ToUintMapMock extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b506107e2806100206000396000f3fe608060405234801561001057600080fd5b50600436106100885760003560e01c80638eaa6ac01161005b5780638eaa6ac0146100f357806395bc267314610106578063dc09a8a714610119578063e0886f901461014357600080fd5b80631d1a696d1461008d5780631f7b6d32146100b5578063273f4940146100cb5780636cf3dff1146100e0575b600080fd5b6100a061009b36600461064f565b61016b565b60405190151581526020015b60405180910390f35b6100bd61017d565b6040519081526020016100ac565b6100de6100d9366004610668565b61018e565b005b6100bd6100ee36600461068a565b6101dd565b6100bd61010136600461064f565b610229565b6100de61011436600461064f565b610235565b61012c61012736600461064f565b610282565b6040805192151583526020830191909152016100ac565b61015661015136600461064f565b610298565b604080519283526020830191909152016100ac565b600061017781836102a5565b92915050565b600061018960006102b8565b905090565b600061019b8184846102c3565b90507fed9840e0775590557ad736875d96c95cf1458b766335f74339951a32c82a9e33816040516101d0911515815260200190565b60405180910390a1505050565b60006102218484848080601f016020809104026020016040519081016040528093929190818152602001838380828437600092018290525094939250506102d09050565b949350505050565b600061017781836102dd565b600061024181836102e9565b90507fed9840e0775590557ad736875d96c95cf1458b766335f74339951a32c82a9e3381604051610276911515815260200190565b60405180910390a15050565b60008061028f81846102f5565b91509150915091565b60008061028f8184610313565b60006102b18383610322565b9392505050565b60006101778261032e565b6000610221848484610339565b6000610221848484610356565b60006102b183836103ab565b60006102b1838361041b565b60008080806103048686610438565b909450925050505b9250929050565b60008080806103048686610472565b60006102b1838361049d565b6000610177826104b5565b6000828152600284016020526040812082905561022184846104bf565b60008281526002840160205260408120548015158061037a575061037a8585610322565b83906103a25760405162461bcd60e51b81526004016103999190610706565b60405180910390fd5b50949350505050565b6000818152600283016020526040812054801515806103cf57506103cf8484610322565b6102b15760405162461bcd60e51b815260206004820152601e60248201527f456e756d657261626c654d61703a206e6f6e6578697374656e74206b657900006044820152606401610399565b600081815260028301602052604081208190556102b183836104cb565b60008181526002830160205260408120548190806104675761045a8585610322565b92506000915061030c9050565b60019250905061030c565b6000808061048085856104d7565b600081815260029690960160205260409095205494959350505050565b600081815260018301602052604081205415156102b1565b6000610177825490565b60006102b183836104e3565b60006102b18383610532565b60006102b18383610625565b600081815260018301602052604081205461052a57508154600181810184556000848152602080822090930184905584548482528286019093526040902091909155610177565b506000610177565b6000818152600183016020526040812054801561061b57600061055660018361075b565b855490915060009061056a9060019061075b565b90508181146105cf57600086600001828154811061058a5761058a610780565b90600052602060002001549050808760000184815481106105ad576105ad610780565b6000918252602080832090910192909255918252600188019052604090208390555b85548690806105e0576105e0610796565b600190038181906000526020600020016000905590558560010160008681526020019081526020016000206000905560019350505050610177565b6000915050610177565b600082600001828154811061063c5761063c610780565b9060005260206000200154905092915050565b60006020828403121561066157600080fd5b5035919050565b6000806040838503121561067b57600080fd5b50508035926020909101359150565b60008060006040848603121561069f57600080fd5b83359250602084013567ffffffffffffffff808211156106be57600080fd5b818601915086601f8301126106d257600080fd5b8135818111156106e157600080fd5b8760208285010111156106f357600080fd5b6020830194508093505050509250925092565b600060208083528351808285015260005b8181101561073357858101830151858201604001528201610717565b81811115610745576000604083870101525b50601f01601f1916929092016040019392505050565b60008282101561077b57634e487b7160e01b600052601160045260246000fd5b500390565b634e487b7160e01b600052603260045260246000fd5b634e487b7160e01b600052603160045260246000fdfea26469706673582212206319a443719a43a692f133c1a49ec7452b12b1d130f95d30d930f1dc07b1de5864736f6c63430008090033";

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
    protected Bytes32ToUintMapMock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Bytes32ToUintMapMock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Bytes32ToUintMapMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Bytes32ToUintMapMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
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

    public RemoteFunctionCall<Tuple2<byte[], BigInteger>> at(BigInteger index) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_AT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple2<byte[], BigInteger>>(function,
                new Callable<Tuple2<byte[], BigInteger>>() {
                    @Override
                    public Tuple2<byte[], BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<byte[], BigInteger>(
                                (byte[]) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue());
                    }
                });
    }

    public RemoteFunctionCall<Boolean> contains(byte[] key) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_CONTAINS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(key)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<BigInteger> get(byte[] key) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GET, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(key)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getWithMessage(byte[] key, String errorMessage) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETWITHMESSAGE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(key), 
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

    public RemoteFunctionCall<TransactionReceipt> remove(byte[] key) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_REMOVE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(key)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> set(byte[] key, BigInteger value) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SET, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(key), 
                new org.web3j.abi.datatypes.generated.Uint256(value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple2<Boolean, BigInteger>> tryGet(byte[] key) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_TRYGET, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(key)), 
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
    public static Bytes32ToUintMapMock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Bytes32ToUintMapMock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Bytes32ToUintMapMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Bytes32ToUintMapMock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Bytes32ToUintMapMock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Bytes32ToUintMapMock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Bytes32ToUintMapMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Bytes32ToUintMapMock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Bytes32ToUintMapMock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Bytes32ToUintMapMock.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Bytes32ToUintMapMock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Bytes32ToUintMapMock.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Bytes32ToUintMapMock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Bytes32ToUintMapMock.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Bytes32ToUintMapMock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Bytes32ToUintMapMock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class OperationResultEventResponse extends BaseEventResponse {
        public Boolean result;
    }
}
