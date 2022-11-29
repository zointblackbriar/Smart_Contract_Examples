package de.tudresden.webofthingstokenization.externalsmartcontractlibrary;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
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
public class DummyImplementation extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50610643806100206000396000f3fe60806040526004361061009c5760003560e01c80635e383d21116100645780635e383d21146101495780636d4ce63c14610169578063763e2831146101855780639fba1f9a146101a5578063d31f8b6b146101af578063e79f5bee146101cf57600080fd5b80631f1bd692146100a1578063227367d5146100cc5780633bccbbc9146100e55780633fa4f245146100fa57806354fd4d501461011e575b600080fd5b3480156100ad57600080fd5b506100b66101dd565b6040516100c391906103dd565b60405180910390f35b3480156100d857600080fd5b506100e3600a600055565b005b3480156100f157600080fd5b506100e361026b565b34801561010657600080fd5b5061011060005481565b6040519081526020016100c3565b34801561012a57600080fd5b50604080518082019091526002815261563160f01b60208201526100b6565b34801561015557600080fd5b50610110610164366004610432565b6102b7565b34801561017557600080fd5b50604051600181526020016100c3565b34801561019157600080fd5b506100e36101a0366004610432565b600055565b6100e36064600055565b3480156101bb57600080fd5b506100e36101ca366004610512565b6102d8565b6100e36101a0366004610432565b600180546101ea906105d2565b80601f0160208091040260200160405190810160405280929190818152602001828054610216906105d2565b80156102635780601f1061023857610100808354040283529160200191610263565b820191906000526020600020905b81548152906001019060200180831161024657829003601f168201915b505050505081565b60405162461bcd60e51b815260206004820152601c60248201527f44756d6d79496d706c656d656e746174696f6e20726576657274656400000000604482015260640160405180910390fd5b600281815481106102c757600080fd5b600091825260209091200154905081565b600083905581516102f090600190602085019061030a565b50805161030490600290602084019061038e565b50505050565b828054610316906105d2565b90600052602060002090601f016020900481019282610338576000855561037e565b82601f1061035157805160ff191683800117855561037e565b8280016001018555821561037e579182015b8281111561037e578251825591602001919060010190610363565b5061038a9291506103c8565b5090565b82805482825590600052602060002090810192821561037e579160200282018281111561037e578251825591602001919060010190610363565b5b8082111561038a57600081556001016103c9565b600060208083528351808285015260005b8181101561040a578581018301518582016040015282016103ee565b8181111561041c576000604083870101525b50601f01601f1916929092016040019392505050565b60006020828403121561044457600080fd5b5035919050565b634e487b7160e01b600052604160045260246000fd5b604051601f8201601f1916810167ffffffffffffffff8111828210171561048a5761048a61044b565b604052919050565b600082601f8301126104a357600080fd5b8135602067ffffffffffffffff8211156104bf576104bf61044b565b8160051b6104ce828201610461565b92835284810182019282810190878511156104e857600080fd5b83870192505b84831015610507578235825291830191908301906104ee565b979650505050505050565b60008060006060848603121561052757600080fd5b8335925060208085013567ffffffffffffffff8082111561054757600080fd5b818701915087601f83011261055b57600080fd5b81358181111561056d5761056d61044b565b61057f601f8201601f19168501610461565b818152898583860101111561059357600080fd5b8185850186830137600091810190940152919350604086013591808311156105ba57600080fd5b50506105c886828701610492565b9150509250925092565b600181811c908216806105e657607f821691505b6020821081141561060757634e487b7160e01b600052602260045260246000fd5b5091905056fea264697066735822122069ff6f94253650c89a8b5b97587185f7a883bfe94a14b104a00b0ae02819ea6164736f6c63430008090033";

    public static final String FUNC_GET = "get";

    public static final String FUNC_INITIALIZE = "initialize";

    public static final String FUNC_INITIALIZENONPAYABLE = "initializeNonPayable";

    public static final String FUNC_INITIALIZENONPAYABLEWITHVALUE = "initializeNonPayableWithValue";

    public static final String FUNC_INITIALIZEPAYABLE = "initializePayable";

    public static final String FUNC_INITIALIZEPAYABLEWITHVALUE = "initializePayableWithValue";

    public static final String FUNC_REVERTS = "reverts";

    public static final String FUNC_TEXT = "text";

    public static final String FUNC_VALUE = "value";

    public static final String FUNC_VALUES = "values";

    public static final String FUNC_VERSION = "version";

    @Deprecated
    protected DummyImplementation(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected DummyImplementation(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected DummyImplementation(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected DummyImplementation(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<Boolean> get() {
        final Function function = new Function(FUNC_GET, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> initialize(BigInteger _value, String _text, List<BigInteger> _values) {
        final Function function = new Function(
                FUNC_INITIALIZE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_value), 
                new org.web3j.abi.datatypes.Utf8String(_text), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(_values, org.web3j.abi.datatypes.generated.Uint256.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> initializeNonPayable() {
        final Function function = new Function(
                FUNC_INITIALIZENONPAYABLE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> initializeNonPayableWithValue(BigInteger _value) {
        final Function function = new Function(
                FUNC_INITIALIZENONPAYABLEWITHVALUE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> initializePayable(BigInteger weiValue) {
        final Function function = new Function(
                FUNC_INITIALIZEPAYABLE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<TransactionReceipt> initializePayableWithValue(BigInteger _value, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_INITIALIZEPAYABLEWITHVALUE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<String> text() {
        final Function function = new Function(FUNC_TEXT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> value() {
        final Function function = new Function(FUNC_VALUE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> values(BigInteger param0) {
        final Function function = new Function(FUNC_VALUES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> version() {
        final Function function = new Function(FUNC_VERSION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static DummyImplementation load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new DummyImplementation(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static DummyImplementation load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new DummyImplementation(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static DummyImplementation load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new DummyImplementation(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static DummyImplementation load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new DummyImplementation(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<DummyImplementation> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(DummyImplementation.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<DummyImplementation> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(DummyImplementation.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<DummyImplementation> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(DummyImplementation.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<DummyImplementation> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(DummyImplementation.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
