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
public class AddressImpl extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50610b65806100206000396000f3fe6080604052600436106100745760003560e01c8063a0b5ffb01161004e578063a0b5ffb0146100f4578063c21d36f314610114578063ee33b7e214610134578063fc40cf731461015457600080fd5b8063162790551461008057806324a084df146100bf5780632a011594146100e157600080fd5b3661007b57005b600080fd5b34801561008c57600080fd5b506100aa61009b366004610805565b6001600160a01b03163b151590565b60405190151581526020015b60405180910390f35b3480156100cb57600080fd5b506100df6100da366004610822565b610176565b005b6100df6100ef366004610897565b610184565b34801561010057600080fd5b506100df61010f3660046108f3565b61021b565b34801561012057600080fd5b506100df61012f3660046108f3565b6102af565b34801561014057600080fd5b506100df61014f3660046108f3565b6102f1565b34801561016057600080fd5b50610169610333565b6040516100b69190610978565b61018082826103c1565b5050565b60006101c88585858080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152508792506104e4915050565b90507fe518073da644d0626295bee74d5d5c51447a33857c62913bb30f35e2fba3db7c818060200190518101906101ff91906109c1565b60405161020c9190610978565b60405180910390a15050505050565b600061025d8484848080601f01602080910402602001604051908101604052809392919081815260200183838082843760009201919091525061051292505050565b90507fe518073da644d0626295bee74d5d5c51447a33857c62913bb30f35e2fba3db7c8180602001905181019061029491906109c1565b6040516102a19190610978565b60405180910390a150505050565b600061025d8484848080601f01602080910402602001604051908101604052809392919081815260200183838082843760009201919091525061055d92505050565b600061025d8484848080601f01602080910402602001604051908101604052809392919081815260200183838082843760009201919091525061058292505050565b6000805461034090610a63565b80601f016020809104026020016040519081016040528092919081815260200182805461036c90610a63565b80156103b95780601f1061038e576101008083540402835291602001916103b9565b820191906000526020600020905b81548152906001019060200180831161039c57829003601f168201915b505050505081565b804710156104165760405162461bcd60e51b815260206004820152601d60248201527f416464726573733a20696e73756666696369656e742062616c616e636500000060448201526064015b60405180910390fd5b6000826001600160a01b03168260405160006040518083038185875af1925050503d8060008114610463576040519150601f19603f3d011682016040523d82523d6000602084013e610468565b606091505b50509050806104df5760405162461bcd60e51b815260206004820152603a60248201527f416464726573733a20756e61626c6520746f2073656e642076616c75652c207260448201527f6563697069656e74206d61792068617665207265766572746564000000000000606482015260840161040d565b505050565b606061050a848484604051806060016040528060298152602001610abb602991396105a7565b949350505050565b6060610556838360006040518060400160405280601e81526020017f416464726573733a206c6f772d6c6576656c2063616c6c206661696c656400008152506105a7565b9392505050565b60606105568383604051806060016040528060258152602001610ae460259139610682565b60606105568383604051806060016040528060278152602001610b09602791396106fa565b6060824710156106085760405162461bcd60e51b815260206004820152602660248201527f416464726573733a20696e73756666696369656e742062616c616e636520666f6044820152651c8818d85b1b60d21b606482015260840161040d565b600080866001600160a01b031685876040516106249190610a9e565b60006040518083038185875af1925050503d8060008114610661576040519150601f19603f3d011682016040523d82523d6000602084013e610666565b606091505b509150915061067787838387610752565b979650505050505050565b6060600080856001600160a01b03168560405161069f9190610a9e565b600060405180830381855afa9150503d80600081146106da576040519150601f19603f3d011682016040523d82523d6000602084013e6106df565b606091505b50915091506106f086838387610752565b9695505050505050565b6060600080856001600160a01b0316856040516107179190610a9e565b600060405180830381855af49150503d80600081146106da576040519150601f19603f3d011682016040523d82523d6000602084013e6106df565b606083156107be5782516107b7576001600160a01b0385163b6107b75760405162461bcd60e51b815260206004820152601d60248201527f416464726573733a2063616c6c20746f206e6f6e2d636f6e7472616374000000604482015260640161040d565b508161050a565b61050a83838151156107d35781518083602001fd5b8060405162461bcd60e51b815260040161040d9190610978565b6001600160a01b038116811461080257600080fd5b50565b60006020828403121561081757600080fd5b8135610556816107ed565b6000806040838503121561083557600080fd5b8235610840816107ed565b946020939093013593505050565b60008083601f84011261086057600080fd5b50813567ffffffffffffffff81111561087857600080fd5b60208301915083602082850101111561089057600080fd5b9250929050565b600080600080606085870312156108ad57600080fd5b84356108b8816107ed565b9350602085013567ffffffffffffffff8111156108d457600080fd5b6108e08782880161084e565b9598909750949560400135949350505050565b60008060006040848603121561090857600080fd5b8335610913816107ed565b9250602084013567ffffffffffffffff81111561092f57600080fd5b61093b8682870161084e565b9497909650939450505050565b60005b8381101561096357818101518382015260200161094b565b83811115610972576000848401525b50505050565b6020815260008251806020840152610997816040850160208701610948565b601f01601f19169190910160400192915050565b634e487b7160e01b600052604160045260246000fd5b6000602082840312156109d357600080fd5b815167ffffffffffffffff808211156109eb57600080fd5b818401915084601f8301126109ff57600080fd5b815181811115610a1157610a116109ab565b604051601f8201601f19908116603f01168101908382118183101715610a3957610a396109ab565b81604052828152876020848701011115610a5257600080fd5b610677836020830160208801610948565b600181811c90821680610a7757607f821691505b60208210811415610a9857634e487b7160e01b600052602260045260246000fd5b50919050565b60008251610ab0818460208701610948565b919091019291505056fe416464726573733a206c6f772d6c6576656c2063616c6c20776974682076616c7565206661696c6564416464726573733a206c6f772d6c6576656c207374617469632063616c6c206661696c6564416464726573733a206c6f772d6c6576656c2064656c65676174652063616c6c206661696c6564a2646970667358221220c9780944382394fcdab4c9f5c7f87b485d7cc04393945460b4a742bd333617f964736f6c63430008090033";

    public static final String FUNC_FUNCTIONCALL = "functionCall";

    public static final String FUNC_FUNCTIONCALLWITHVALUE = "functionCallWithValue";

    public static final String FUNC_FUNCTIONDELEGATECALL = "functionDelegateCall";

    public static final String FUNC_FUNCTIONSTATICCALL = "functionStaticCall";

    public static final String FUNC_ISCONTRACT = "isContract";

    public static final String FUNC_SENDVALUE = "sendValue";

    public static final String FUNC_SHAREDANSWER = "sharedAnswer";

    public static final Event CALLRETURNVALUE_EVENT = new Event("CallReturnValue", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
    ;

    @Deprecated
    protected AddressImpl(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected AddressImpl(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected AddressImpl(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected AddressImpl(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<CallReturnValueEventResponse> getCallReturnValueEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(CALLRETURNVALUE_EVENT, transactionReceipt);
        ArrayList<CallReturnValueEventResponse> responses = new ArrayList<CallReturnValueEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            CallReturnValueEventResponse typedResponse = new CallReturnValueEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.data = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<CallReturnValueEventResponse> callReturnValueEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, CallReturnValueEventResponse>() {
            @Override
            public CallReturnValueEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(CALLRETURNVALUE_EVENT, log);
                CallReturnValueEventResponse typedResponse = new CallReturnValueEventResponse();
                typedResponse.log = log;
                typedResponse.data = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<CallReturnValueEventResponse> callReturnValueEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CALLRETURNVALUE_EVENT));
        return callReturnValueEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> functionCall(String target, byte[] data) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_FUNCTIONCALL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, target), 
                new org.web3j.abi.datatypes.DynamicBytes(data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> functionCallWithValue(String target, byte[] data, BigInteger value, BigInteger weiValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_FUNCTIONCALLWITHVALUE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, target), 
                new org.web3j.abi.datatypes.DynamicBytes(data), 
                new org.web3j.abi.datatypes.generated.Uint256(value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<TransactionReceipt> functionDelegateCall(String target, byte[] data) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_FUNCTIONDELEGATECALL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, target), 
                new org.web3j.abi.datatypes.DynamicBytes(data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> functionStaticCall(String target, byte[] data) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_FUNCTIONSTATICCALL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, target), 
                new org.web3j.abi.datatypes.DynamicBytes(data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> isContract(String account) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ISCONTRACT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, account)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> sendValue(String receiver, BigInteger amount) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SENDVALUE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, receiver), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> sharedAnswer() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_SHAREDANSWER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static AddressImpl load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new AddressImpl(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static AddressImpl load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new AddressImpl(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static AddressImpl load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new AddressImpl(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static AddressImpl load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new AddressImpl(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<AddressImpl> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(AddressImpl.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<AddressImpl> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(AddressImpl.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<AddressImpl> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(AddressImpl.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<AddressImpl> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(AddressImpl.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class CallReturnValueEventResponse extends BaseEventResponse {
        public String data;
    }
}
