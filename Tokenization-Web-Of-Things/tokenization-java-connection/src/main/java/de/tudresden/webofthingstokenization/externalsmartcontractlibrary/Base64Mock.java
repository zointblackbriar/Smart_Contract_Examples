package de.tudresden.webofthingstokenization.externalsmartcontractlibrary;

import java.math.BigInteger;
import java.util.Arrays;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
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
public class Base64Mock extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b506103bf806100206000396000f3fe608060405234801561001057600080fd5b506004361061002b5760003560e01c806312496a1b14610030575b600080fd5b61004361003e3660046101d4565b610059565b6040516100509190610285565b60405180910390f35b60606100648261006a565b92915050565b606081516000141561008a57505060408051602081019091526000815290565b600060405180606001604052806040815260200161034a60409139905060006003845160026100b991906102f0565b6100c39190610308565b6100ce90600461032a565b67ffffffffffffffff8111156100e6576100e66101be565b6040519080825280601f01601f191660200182016040528015610110576020820181803683370190505b509050600182016020820185865187015b8082101561017c576003820191508151603f8160121c168501518453600184019350603f81600c1c168501518453600184019350603f8160061c168501518453600184019350603f8116850151845350600183019250610121565b505060038651066001811461019857600281146101ab576101b3565b603d6001830353603d60028303536101b3565b603d60018303535b509195945050505050565b634e487b7160e01b600052604160045260246000fd5b6000602082840312156101e657600080fd5b813567ffffffffffffffff808211156101fe57600080fd5b818401915084601f83011261021257600080fd5b813581811115610224576102246101be565b604051601f8201601f19908116603f0116810190838211818310171561024c5761024c6101be565b8160405282815287602084870101111561026557600080fd5b826020860160208301376000928101602001929092525095945050505050565b600060208083528351808285015260005b818110156102b257858101830151858201604001528201610296565b818111156102c4576000604083870101525b50601f01601f1916929092016040019392505050565b634e487b7160e01b600052601160045260246000fd5b60008219821115610303576103036102da565b500190565b60008261032557634e487b7160e01b600052601260045260246000fd5b500490565b6000816000190483118215151615610344576103446102da565b50029056fe4142434445464748494a4b4c4d4e4f505152535455565758595a6162636465666768696a6b6c6d6e6f707172737475767778797a303132333435363738392b2fa26469706673582212205b74901853e762fbb611db0613e287ada8d4c37363852b2f2665dc58c322ba2164736f6c63430008090033";

    public static final String FUNC_ENCODE = "encode";

    @Deprecated
    protected Base64Mock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Base64Mock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Base64Mock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Base64Mock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<String> encode(byte[] value) {
        final Function function = new Function(FUNC_ENCODE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicBytes(value)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static Base64Mock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Base64Mock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Base64Mock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Base64Mock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Base64Mock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Base64Mock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Base64Mock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Base64Mock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Base64Mock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Base64Mock.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Base64Mock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Base64Mock.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Base64Mock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Base64Mock.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Base64Mock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Base64Mock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
