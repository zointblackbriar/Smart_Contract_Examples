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
import org.web3j.abi.datatypes.Address;
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
public class UintToAddressMapMock extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50610829806100206000396000f3fe608060405234801561001057600080fd5b50600436106100885760003560e01c80639507d39a1161005b5780639507d39a14610102578063c051a3a61461012d578063c34052e014610140578063e0886f901461016357600080fd5b80631f7b6d321461008d5780632f30c6f6146100a85780634cc82215146100bd578063871394d9146100d0575b600080fd5b610095610193565b6040519081526020015b60405180910390f35b6100bb6100b636600461067c565b6101a4565b005b6100bb6100cb3660046106b8565b6101f3565b6100e36100de3660046106b8565b610240565b6040805192151583526001600160a01b0390911660208301520161009f565b6101156101103660046106b8565b610256565b6040516001600160a01b03909116815260200161009f565b61011561013b3660046106d1565b610268565b61015361014e3660046106b8565b6102b4565b604051901515815260200161009f565b6101766101713660046106b8565b6102c0565b604080519283526001600160a01b0390911660208301520161009f565b600061019f60006102cd565b905090565b60006101b18184846102d8565b90507fed9840e0775590557ad736875d96c95cf1458b766335f74339951a32c82a9e33816040516101e6911515815260200190565b60405180910390a1505050565b60006101ff81836102ee565b90507fed9840e0775590557ad736875d96c95cf1458b766335f74339951a32c82a9e3381604051610234911515815260200190565b60405180910390a15050565b60008061024d8184610301565b91509150915091565b6000610262818361031f565b92915050565b60006102ac8484848080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920182905250949392505061032b9050565b949350505050565b60006102628183610338565b60008061024d8184610344565b600061026282610353565b60006102ac84846001600160a01b03851661035e565b60006102fa838361037b565b9392505050565b60008080806103108686610398565b909450925050505b9250929050565b60006102fa83836103d2565b60006102ac848484610447565b60006102fa8383610493565b6000808080610310868661049f565b6000610262826104ca565b600082815260028401602052604081208290556102ac84846104d4565b600081815260028301602052604081208190556102fa83836104e0565b60008181526002830160205260408120548190806103c7576103ba8585610493565b9250600091506103189050565b600192509050610318565b6000818152600283016020526040812054801515806103f657506103f68484610493565b6102fa5760405162461bcd60e51b815260206004820152601e60248201527f456e756d657261626c654d61703a206e6f6e6578697374656e74206b6579000060448201526064015b60405180910390fd5b60008281526002840160205260408120548015158061046b575061046b8585610493565b839061048a5760405162461bcd60e51b815260040161043e919061074d565b50949350505050565b60006102fa83836104ec565b600080806104ad8585610504565b600081815260029690960160205260409095205494959350505050565b6000610262825490565b60006102fa8383610510565b60006102fa838361055f565b600081815260018301602052604081205415156102fa565b60006102fa8383610652565b600081815260018301602052604081205461055757508154600181810184556000848152602080822090930184905584548482528286019093526040902091909155610262565b506000610262565b600081815260018301602052604081205480156106485760006105836001836107a2565b8554909150600090610597906001906107a2565b90508181146105fc5760008660000182815481106105b7576105b76107c7565b90600052602060002001549050808760000184815481106105da576105da6107c7565b6000918252602080832090910192909255918252600188019052604090208390555b855486908061060d5761060d6107dd565b600190038181906000526020600020016000905590558560010160008681526020019081526020016000206000905560019350505050610262565b6000915050610262565b6000826000018281548110610669576106696107c7565b9060005260206000200154905092915050565b6000806040838503121561068f57600080fd5b8235915060208301356001600160a01b03811681146106ad57600080fd5b809150509250929050565b6000602082840312156106ca57600080fd5b5035919050565b6000806000604084860312156106e657600080fd5b83359250602084013567ffffffffffffffff8082111561070557600080fd5b818601915086601f83011261071957600080fd5b81358181111561072857600080fd5b87602082850101111561073a57600080fd5b6020830194508093505050509250925092565b600060208083528351808285015260005b8181101561077a5785810183015185820160400152820161075e565b8181111561078c576000604083870101525b50601f01601f1916929092016040019392505050565b6000828210156107c257634e487b7160e01b600052601160045260246000fd5b500390565b634e487b7160e01b600052603260045260246000fd5b634e487b7160e01b600052603160045260246000fdfea264697066735822122052109c4d4054878a2646dc3bef104c2933e08f48971bd51aad55b1ca44ab150964736f6c63430008090033";

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
    protected UintToAddressMapMock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected UintToAddressMapMock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected UintToAddressMapMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected UintToAddressMapMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
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

    public RemoteFunctionCall<Tuple2<BigInteger, String>> at(BigInteger index) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_AT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>() {}));
        return new RemoteFunctionCall<Tuple2<BigInteger, String>>(function,
                new Callable<Tuple2<BigInteger, String>>() {
                    @Override
                    public Tuple2<BigInteger, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<BigInteger, String>(
                                (BigInteger) results.get(0).getValue(), 
                                (String) results.get(1).getValue());
                    }
                });
    }

    public RemoteFunctionCall<Boolean> contains(BigInteger key) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_CONTAINS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(key)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<String> get(BigInteger key) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GET, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(key)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> getWithMessage(BigInteger key, String errorMessage) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETWITHMESSAGE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(key), 
                new org.web3j.abi.datatypes.Utf8String(errorMessage)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
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

    public RemoteFunctionCall<TransactionReceipt> set(BigInteger key, String value) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SET, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(key), 
                new org.web3j.abi.datatypes.Address(160, value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple2<Boolean, String>> tryGet(BigInteger key) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_TRYGET, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(key)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}, new TypeReference<Address>() {}));
        return new RemoteFunctionCall<Tuple2<Boolean, String>>(function,
                new Callable<Tuple2<Boolean, String>>() {
                    @Override
                    public Tuple2<Boolean, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<Boolean, String>(
                                (Boolean) results.get(0).getValue(), 
                                (String) results.get(1).getValue());
                    }
                });
    }

    @Deprecated
    public static UintToAddressMapMock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new UintToAddressMapMock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static UintToAddressMapMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new UintToAddressMapMock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static UintToAddressMapMock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new UintToAddressMapMock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static UintToAddressMapMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new UintToAddressMapMock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<UintToAddressMapMock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(UintToAddressMapMock.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<UintToAddressMapMock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(UintToAddressMapMock.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<UintToAddressMapMock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(UintToAddressMapMock.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<UintToAddressMapMock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(UintToAddressMapMock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class OperationResultEventResponse extends BaseEventResponse {
        public Boolean result;
    }
}
