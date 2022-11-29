package de.tudresden.webofthingstokenization.externalsmartcontractlibrary;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
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
public class AddressArraysMock extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b5060405161029c38038061029c83398101604081905261002f916100f5565b8051610042906000906020840190610049565b50506101b9565b82805482825590600052602060002090810192821561009e579160200282015b8281111561009e57825182546001600160a01b0319166001600160a01b03909116178255602090920191600190910190610069565b506100aa9291506100ae565b5090565b5b808211156100aa57600081556001016100af565b634e487b7160e01b600052604160045260246000fd5b80516001600160a01b03811681146100f057600080fd5b919050565b6000602080838503121561010857600080fd5b82516001600160401b038082111561011f57600080fd5b818501915085601f83011261013357600080fd5b815181811115610145576101456100c3565b8060051b604051601f19603f8301168101818110858211171561016a5761016a6100c3565b60405291825284820192508381018501918883111561018857600080fd5b938501935b828510156101ad5761019e856100d9565b8452938501939285019261018d565b98975050505050505050565b60d5806101c76000396000f3fe6080604052348015600f57600080fd5b506004361060285760003560e01c806340aa934d14602d575b600080fd5b606b60383660046087565b600080527f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e56301546001600160a01b031690565b6040516001600160a01b03909116815260200160405180910390f35b600060208284031215609857600080fd5b503591905056fea2646970667358221220dbb8e6038c769a65a967f9a0a6099e83641402ddd09589ae67ce0abf39b7396c64736f6c63430008090033";

    public static final String FUNC_UNSAFEACCESS = "unsafeAccess";

    @Deprecated
    protected AddressArraysMock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected AddressArraysMock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected AddressArraysMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected AddressArraysMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<String> unsafeAccess(BigInteger pos) {
        final Function function = new Function(FUNC_UNSAFEACCESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(pos)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static AddressArraysMock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new AddressArraysMock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static AddressArraysMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new AddressArraysMock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static AddressArraysMock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new AddressArraysMock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static AddressArraysMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new AddressArraysMock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<AddressArraysMock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, List<String> array) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(array, org.web3j.abi.datatypes.Address.class))));
        return deployRemoteCall(AddressArraysMock.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<AddressArraysMock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, List<String> array) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(array, org.web3j.abi.datatypes.Address.class))));
        return deployRemoteCall(AddressArraysMock.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<AddressArraysMock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, List<String> array) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(array, org.web3j.abi.datatypes.Address.class))));
        return deployRemoteCall(AddressArraysMock.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<AddressArraysMock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, List<String> array) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(array, org.web3j.abi.datatypes.Address.class))));
        return deployRemoteCall(AddressArraysMock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
