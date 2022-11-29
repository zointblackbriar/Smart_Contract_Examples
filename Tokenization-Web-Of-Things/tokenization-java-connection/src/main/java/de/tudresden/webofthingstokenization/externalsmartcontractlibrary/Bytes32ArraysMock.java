package de.tudresden.webofthingstokenization.externalsmartcontractlibrary;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
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
public class Bytes32ArraysMock extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b5060405161024c38038061024c83398101604081905261002f916100bf565b8051610042906000906020840190610049565b505061017c565b828054828255906000526020600020908101928215610084579160200282015b82811115610084578251825591602001919060010190610069565b50610090929150610094565b5090565b5b808211156100905760008155600101610095565b634e487b7160e01b600052604160045260246000fd5b600060208083850312156100d257600080fd5b82516001600160401b03808211156100e957600080fd5b818501915085601f8301126100fd57600080fd5b81518181111561010f5761010f6100a9565b8060051b604051601f19603f83011681018181108582111715610134576101346100a9565b60405291825284820192508381018501918883111561015257600080fd5b938501935b8285101561017057845184529385019392850192610157565b98975050505050505050565b60c28061018a6000396000f3fe6080604052348015600f57600080fd5b506004361060285760003560e01c806340aa934d14602d575b600080fd5b606260383660046074565b600080527f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e563015490565b60405190815260200160405180910390f35b600060208284031215608557600080fd5b503591905056fea2646970667358221220cc4a9ffcb9340db58073fce5673e767daf4faec5cc8a3b85024955c0df1e75bd64736f6c63430008090033";

    public static final String FUNC_UNSAFEACCESS = "unsafeAccess";

    @Deprecated
    protected Bytes32ArraysMock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Bytes32ArraysMock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Bytes32ArraysMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Bytes32ArraysMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<byte[]> unsafeAccess(BigInteger pos) {
        final Function function = new Function(FUNC_UNSAFEACCESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(pos)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    @Deprecated
    public static Bytes32ArraysMock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Bytes32ArraysMock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Bytes32ArraysMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Bytes32ArraysMock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Bytes32ArraysMock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Bytes32ArraysMock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Bytes32ArraysMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Bytes32ArraysMock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Bytes32ArraysMock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, List<byte[]> array) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(array, org.web3j.abi.datatypes.generated.Bytes32.class))));
        return deployRemoteCall(Bytes32ArraysMock.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<Bytes32ArraysMock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, List<byte[]> array) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(array, org.web3j.abi.datatypes.generated.Bytes32.class))));
        return deployRemoteCall(Bytes32ArraysMock.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Bytes32ArraysMock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, List<byte[]> array) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(array, org.web3j.abi.datatypes.generated.Bytes32.class))));
        return deployRemoteCall(Bytes32ArraysMock.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Bytes32ArraysMock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, List<byte[]> array) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(array, org.web3j.abi.datatypes.generated.Bytes32.class))));
        return deployRemoteCall(Bytes32ArraysMock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
