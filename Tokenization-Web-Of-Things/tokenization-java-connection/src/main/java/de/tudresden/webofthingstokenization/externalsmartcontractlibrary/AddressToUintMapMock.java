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
public class AddressToUintMapMock extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50610868806100206000396000f3fe608060405234801561001057600080fd5b50600436106100885760003560e01c80635dbe47e81161005b5780635dbe47e8146100e3578063864083af14610106578063c2bc2efc14610130578063e0886f901461014357600080fd5b80631f7b6d321461008d57806329092d0e146100a85780633825d828146100bd5780633a992ce7146100d0575b600080fd5b610095610175565b6040519081526020015b60405180910390f35b6100bb6100b63660046106ab565b610186565b005b6100bb6100cb3660046106c6565b6101d3565b6100956100de3660046106f0565b610222565b6100f66100f13660046106ab565b61026e565b604051901515815260200161009f565b6101196101143660046106ab565b610280565b60408051921515835260208301919091520161009f565b61009561013e3660046106ab565b610296565b610156610151366004610773565b6102a2565b604080516001600160a01b03909316835260208301919091520161009f565b600061018160006102af565b905090565b600061019281836102ba565b90507fed9840e0775590557ad736875d96c95cf1458b766335f74339951a32c82a9e33816040516101c7911515815260200190565b60405180910390a15050565b60006101e08184846102d6565b90507fed9840e0775590557ad736875d96c95cf1458b766335f74339951a32c82a9e3381604051610215911515815260200190565b60405180910390a1505050565b60006102668484848080601f016020809104026020016040519081016040528093929190818152602001838380828437600092018290525094939250506102ec9050565b949350505050565b600061027a8183610302565b92915050565b60008061028d8184610317565b91509150915091565b600061027a818361033e565b60008061028d8184610353565b600061027a82610362565b60006102cf836001600160a01b03841661036d565b9392505050565b6000610266846001600160a01b0385168461038a565b6000610266846001600160a01b038516846103a7565b60006102cf836001600160a01b0384166103fc565b600080808061032f866001600160a01b038716610408565b909450925050505b9250929050565b60006102cf836001600160a01b038416610442565b600080808061032f86866104b2565b600061027a826104dd565b600081815260028301602052604081208190556102cf83836104e7565b6000828152600284016020526040812082905561026684846104f3565b6000828152600284016020526040812054801515806103cb57506103cb85856103fc565b83906103f35760405162461bcd60e51b81526004016103ea919061078c565b60405180910390fd5b50949350505050565b60006102cf83836104ff565b60008181526002830160205260408120548190806104375761042a85856103fc565b9250600091506103379050565b600192509050610337565b600081815260028301602052604081205480151580610466575061046684846103fc565b6102cf5760405162461bcd60e51b815260206004820152601e60248201527f456e756d657261626c654d61703a206e6f6e6578697374656e74206b6579000060448201526064016103ea565b600080806104c08585610517565b600081815260029690960160205260409095205494959350505050565b600061027a825490565b60006102cf8383610523565b60006102cf8383610616565b600081815260018301602052604081205415156102cf565b60006102cf8383610665565b6000818152600183016020526040812054801561060c5760006105476001836107e1565b855490915060009061055b906001906107e1565b90508181146105c057600086600001828154811061057b5761057b610806565b906000526020600020015490508087600001848154811061059e5761059e610806565b6000918252602080832090910192909255918252600188019052604090208390555b85548690806105d1576105d161081c565b60019003818190600052602060002001600090559055856001016000868152602001908152602001600020600090556001935050505061027a565b600091505061027a565b600081815260018301602052604081205461065d5750815460018181018455600084815260208082209093018490558454848252828601909352604090209190915561027a565b50600061027a565b600082600001828154811061067c5761067c610806565b9060005260206000200154905092915050565b80356001600160a01b03811681146106a657600080fd5b919050565b6000602082840312156106bd57600080fd5b6102cf8261068f565b600080604083850312156106d957600080fd5b6106e28361068f565b946020939093013593505050565b60008060006040848603121561070557600080fd5b61070e8461068f565b9250602084013567ffffffffffffffff8082111561072b57600080fd5b818601915086601f83011261073f57600080fd5b81358181111561074e57600080fd5b87602082850101111561076057600080fd5b6020830194508093505050509250925092565b60006020828403121561078557600080fd5b5035919050565b600060208083528351808285015260005b818110156107b95785810183015185820160400152820161079d565b818111156107cb576000604083870101525b50601f01601f1916929092016040019392505050565b60008282101561080157634e487b7160e01b600052601160045260246000fd5b500390565b634e487b7160e01b600052603260045260246000fd5b634e487b7160e01b600052603160045260246000fdfea2646970667358221220d4aed80899d19a4411ce3baacfa62f642a1fcd5641a504a8e34de336a252880064736f6c63430008090033";

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
    protected AddressToUintMapMock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected AddressToUintMapMock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected AddressToUintMapMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected AddressToUintMapMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
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

    public RemoteFunctionCall<Tuple2<String, BigInteger>> at(BigInteger index) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_AT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple2<String, BigInteger>>(function,
                new Callable<Tuple2<String, BigInteger>>() {
                    @Override
                    public Tuple2<String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<String, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue());
                    }
                });
    }

    public RemoteFunctionCall<Boolean> contains(String key) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_CONTAINS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, key)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<BigInteger> get(String key) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GET, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, key)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getWithMessage(String key, String errorMessage) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETWITHMESSAGE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, key), 
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

    public RemoteFunctionCall<TransactionReceipt> remove(String key) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_REMOVE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, key)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> set(String key, BigInteger value) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SET, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, key), 
                new org.web3j.abi.datatypes.generated.Uint256(value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple2<Boolean, BigInteger>> tryGet(String key) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_TRYGET, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, key)), 
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
    public static AddressToUintMapMock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new AddressToUintMapMock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static AddressToUintMapMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new AddressToUintMapMock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static AddressToUintMapMock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new AddressToUintMapMock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static AddressToUintMapMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new AddressToUintMapMock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<AddressToUintMapMock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(AddressToUintMapMock.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<AddressToUintMapMock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(AddressToUintMapMock.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<AddressToUintMapMock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(AddressToUintMapMock.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<AddressToUintMapMock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(AddressToUintMapMock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class OperationResultEventResponse extends BaseEventResponse {
        public Boolean result;
    }
}
