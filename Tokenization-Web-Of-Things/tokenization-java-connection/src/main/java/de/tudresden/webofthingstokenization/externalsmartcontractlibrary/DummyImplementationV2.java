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
public class DummyImplementationV2 extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b5061064e806100206000396000f3fe6080604052600436106100a75760003560e01c80635e383d21116100645780635e383d21146101675780636d4ce63c14610187578063763e2831146101a35780639fba1f9a146101be578063d31f8b6b146101c8578063e79f5bee1461012957600080fd5b80631f1bd692146100ac578063227367d5146100d75780633bccbbc9146100f05780633fa4f24514610105578063454b06081461012957806354fd4d501461013c575b600080fd5b3480156100b857600080fd5b506100c16101e8565b6040516100ce91906103e8565b60405180910390f35b3480156100e357600080fd5b506100ee600a600055565b005b3480156100fc57600080fd5b506100ee610276565b34801561011157600080fd5b5061011b60005481565b6040519081526020016100ce565b6100ee61013736600461043d565b600055565b34801561014857600080fd5b506040805180820190915260028152612b1960f11b60208201526100c1565b34801561017357600080fd5b5061011b61018236600461043d565b6102c2565b34801561019357600080fd5b50604051600181526020016100ce565b3480156101af57600080fd5b506100ee61013736600461043d565b6100ee6064600055565b3480156101d457600080fd5b506100ee6101e336600461051d565b6102e3565b600180546101f5906105dd565b80601f0160208091040260200160405190810160405280929190818152602001828054610221906105dd565b801561026e5780601f106102435761010080835404028352916020019161026e565b820191906000526020600020905b81548152906001019060200180831161025157829003601f168201915b505050505081565b60405162461bcd60e51b815260206004820152601c60248201527f44756d6d79496d706c656d656e746174696f6e20726576657274656400000000604482015260640160405180910390fd5b600281815481106102d257600080fd5b600091825260209091200154905081565b600083905581516102fb906001906020850190610315565b50805161030f906002906020840190610399565b50505050565b828054610321906105dd565b90600052602060002090601f0160209004810192826103435760008555610389565b82601f1061035c57805160ff1916838001178555610389565b82800160010185558215610389579182015b8281111561038957825182559160200191906001019061036e565b506103959291506103d3565b5090565b828054828255906000526020600020908101928215610389579160200282018281111561038957825182559160200191906001019061036e565b5b8082111561039557600081556001016103d4565b600060208083528351808285015260005b81811015610415578581018301518582016040015282016103f9565b81811115610427576000604083870101525b50601f01601f1916929092016040019392505050565b60006020828403121561044f57600080fd5b5035919050565b634e487b7160e01b600052604160045260246000fd5b604051601f8201601f1916810167ffffffffffffffff8111828210171561049557610495610456565b604052919050565b600082601f8301126104ae57600080fd5b8135602067ffffffffffffffff8211156104ca576104ca610456565b8160051b6104d982820161046c565b92835284810182019282810190878511156104f357600080fd5b83870192505b84831015610512578235825291830191908301906104f9565b979650505050505050565b60008060006060848603121561053257600080fd5b8335925060208085013567ffffffffffffffff8082111561055257600080fd5b818701915087601f83011261056657600080fd5b81358181111561057857610578610456565b61058a601f8201601f1916850161046c565b818152898583860101111561059e57600080fd5b8185850186830137600091810190940152919350604086013591808311156105c557600080fd5b50506105d38682870161049d565b9150509250925092565b600181811c908216806105f157607f821691505b6020821081141561061257634e487b7160e01b600052602260045260246000fd5b5091905056fea2646970667358221220230532b66f25bad6617e51a437ccd0a7142721090058db1c0277fad4446fd23864736f6c63430008090033";

    public static final String FUNC_GET = "get";

    public static final String FUNC_INITIALIZE = "initialize";

    public static final String FUNC_INITIALIZENONPAYABLE = "initializeNonPayable";

    public static final String FUNC_INITIALIZENONPAYABLEWITHVALUE = "initializeNonPayableWithValue";

    public static final String FUNC_INITIALIZEPAYABLE = "initializePayable";

    public static final String FUNC_INITIALIZEPAYABLEWITHVALUE = "initializePayableWithValue";

    public static final String FUNC_MIGRATE = "migrate";

    public static final String FUNC_REVERTS = "reverts";

    public static final String FUNC_TEXT = "text";

    public static final String FUNC_VALUE = "value";

    public static final String FUNC_VALUES = "values";

    public static final String FUNC_VERSION = "version";

    @Deprecated
    protected DummyImplementationV2(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected DummyImplementationV2(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected DummyImplementationV2(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected DummyImplementationV2(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
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

    public RemoteFunctionCall<TransactionReceipt> migrate(BigInteger newVal, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_MIGRATE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(newVal)), 
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
    public static DummyImplementationV2 load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new DummyImplementationV2(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static DummyImplementationV2 load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new DummyImplementationV2(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static DummyImplementationV2 load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new DummyImplementationV2(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static DummyImplementationV2 load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new DummyImplementationV2(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<DummyImplementationV2> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(DummyImplementationV2.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<DummyImplementationV2> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(DummyImplementationV2.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<DummyImplementationV2> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(DummyImplementationV2.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<DummyImplementationV2> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(DummyImplementationV2.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
