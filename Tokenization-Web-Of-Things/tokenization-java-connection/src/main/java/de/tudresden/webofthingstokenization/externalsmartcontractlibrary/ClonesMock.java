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
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
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
public class ClonesMock extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b506106db806100206000396000f3fe6080604052600436106100345760003560e01c80630fbe133c14610039578063360d0fad1461004e5780636e9ebc811461008a575b600080fd5b61004c61004736600461052a565b61009d565b005b34801561005a57600080fd5b5061006e61006936600461057d565b6100f3565b6040516001600160a01b03909116815260200160405180910390f35b61004c6100983660046105a7565b610111565b6100ee6100b2846001600160a01b031661012d565b83838080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152506101cc92505050565b505050565b60006101086001600160a01b03841683610229565b90505b92915050565b6101276100b26001600160a01b03861685610289565b50505050565b6000763d602d80600a3d3981f3363d3d373d3d3d363d730000008260601b60e81c176000526e5af43d82803e903d91602b57fd5bf38260781b17602052603760096000f090506001600160a01b0381166101c75760405162461bcd60e51b8152602060048201526016602482015275115490cc4c4d8dce8818dc99585d194819985a5b195960521b60448201526064015b60405180910390fd5b919050565b8051156101e9576101e76001600160a01b0383168234610326565b505b6040516001600160a01b03831681527f39a773f10839d86923d91d5ce7d6642f2f63a95d850495abb1f162e38aa04ea59060200160405180910390a15050565b6040513060388201526f5af43d82803e903d91602b57fd5bf3ff602482015260148101839052733d602d80600a3d3981f3363d3d373d3d3d363d738152605881018290526037600c82012060788201526055604390910120600090610108565b6000763d602d80600a3d3981f3363d3d373d3d3d363d730000008360601b60e81c176000526e5af43d82803e903d91602b57fd5bf38360781b1760205281603760096000f590506001600160a01b03811661010b5760405162461bcd60e51b815260206004820152601760248201527f455243313136373a2063726561746532206661696c656400000000000000000060448201526064016101be565b606061034c84848460405180606001604052806029815260200161067d60299139610354565b949350505050565b6060824710156103b55760405162461bcd60e51b815260206004820152602660248201527f416464726573733a20696e73756666696369656e742062616c616e636520666f6044820152651c8818d85b1b60d21b60648201526084016101be565b600080866001600160a01b031685876040516103d1919061062d565b60006040518083038185875af1925050503d806000811461040e576040519150601f19603f3d011682016040523d82523d6000602084013e610413565b606091505b50915091506104248783838761042f565b979650505050505050565b6060831561049b578251610494576001600160a01b0385163b6104945760405162461bcd60e51b815260206004820152601d60248201527f416464726573733a2063616c6c20746f206e6f6e2d636f6e747261637400000060448201526064016101be565b508161034c565b61034c83838151156104b05781518083602001fd5b8060405162461bcd60e51b81526004016101be9190610649565b80356001600160a01b03811681146101c757600080fd5b60008083601f8401126104f357600080fd5b50813567ffffffffffffffff81111561050b57600080fd5b60208301915083602082850101111561052357600080fd5b9250929050565b60008060006040848603121561053f57600080fd5b610548846104ca565b9250602084013567ffffffffffffffff81111561056457600080fd5b610570868287016104e1565b9497909650939450505050565b6000806040838503121561059057600080fd5b610599836104ca565b946020939093013593505050565b600080600080606085870312156105bd57600080fd5b6105c6856104ca565b935060208501359250604085013567ffffffffffffffff8111156105e957600080fd5b6105f5878288016104e1565b95989497509550505050565b60005b8381101561061c578181015183820152602001610604565b838111156101275750506000910152565b6000825161063f818460208701610601565b9190910192915050565b6020815260008251806020840152610668816040850160208701610601565b601f01601f1916919091016040019291505056fe416464726573733a206c6f772d6c6576656c2063616c6c20776974682076616c7565206661696c6564a2646970667358221220d5ff0a8db48c22f241b085ebdbd04320b3a1d83005de1bb3bd3a295cdf8fb80164736f6c63430008090033";

    public static final String FUNC_CLONE = "clone";

    public static final String FUNC_CLONEDETERMINISTIC = "cloneDeterministic";

    public static final String FUNC_PREDICTDETERMINISTICADDRESS = "predictDeterministicAddress";

    public static final Event NEWINSTANCE_EVENT = new Event("NewInstance", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    ;

    @Deprecated
    protected ClonesMock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ClonesMock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ClonesMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ClonesMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<NewInstanceEventResponse> getNewInstanceEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(NEWINSTANCE_EVENT, transactionReceipt);
        ArrayList<NewInstanceEventResponse> responses = new ArrayList<NewInstanceEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            NewInstanceEventResponse typedResponse = new NewInstanceEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.instance = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<NewInstanceEventResponse> newInstanceEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, NewInstanceEventResponse>() {
            @Override
            public NewInstanceEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(NEWINSTANCE_EVENT, log);
                NewInstanceEventResponse typedResponse = new NewInstanceEventResponse();
                typedResponse.log = log;
                typedResponse.instance = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<NewInstanceEventResponse> newInstanceEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(NEWINSTANCE_EVENT));
        return newInstanceEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> clone(String implementation, byte[] initdata, BigInteger weiValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_CLONE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, implementation), 
                new org.web3j.abi.datatypes.DynamicBytes(initdata)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<TransactionReceipt> cloneDeterministic(String implementation, byte[] salt, byte[] initdata, BigInteger weiValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_CLONEDETERMINISTIC, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, implementation), 
                new org.web3j.abi.datatypes.generated.Bytes32(salt), 
                new org.web3j.abi.datatypes.DynamicBytes(initdata)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<String> predictDeterministicAddress(String implementation, byte[] salt) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_PREDICTDETERMINISTICADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, implementation), 
                new org.web3j.abi.datatypes.generated.Bytes32(salt)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static ClonesMock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ClonesMock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ClonesMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ClonesMock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ClonesMock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ClonesMock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ClonesMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ClonesMock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ClonesMock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ClonesMock.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ClonesMock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ClonesMock.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<ClonesMock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ClonesMock.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ClonesMock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ClonesMock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class NewInstanceEventResponse extends BaseEventResponse {
        public String instance;
    }
}
