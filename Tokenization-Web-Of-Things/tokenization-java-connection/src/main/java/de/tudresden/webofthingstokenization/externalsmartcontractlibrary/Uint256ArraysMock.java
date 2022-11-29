package de.tudresden.webofthingstokenization.externalsmartcontractlibrary;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
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
public class Uint256ArraysMock extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b506040516103b83803806103b883398101604081905261002f916100bf565b8051610042906000906020840190610049565b505061017c565b828054828255906000526020600020908101928215610084579160200282015b82811115610084578251825591602001919060010190610069565b50610090929150610094565b5090565b5b808211156100905760008155600101610095565b634e487b7160e01b600052604160045260246000fd5b600060208083850312156100d257600080fd5b82516001600160401b03808211156100e957600080fd5b818501915085601f8301126100fd57600080fd5b81518181111561010f5761010f6100a9565b8060051b604051601f19603f83011681018181108582111715610134576101346100a9565b60405291825284820192508381018501918883111561015257600080fd5b938501935b8285101561017057845184529385019392850192610157565b98975050505050505050565b61022d8061018b6000396000f3fe608060405234801561001057600080fd5b50600436106100365760003560e01c806333e3a58a1461003b57806340aa934d14610060575b600080fd5b61004e610049366004610177565b610098565b60405190815260200160405180910390f35b61004e61006e366004610177565b600080527f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e563015490565b60006100a481836100aa565b92915050565b81546000906100bb575060006100a4565b82546000905b808210156101085760006100d58383610155565b600087815260209020909150859082015411156100f457809150610102565b6100ff8160016101a6565b92505b506100c1565b600082118015610134575083610131866101236001866101be565b600091825260209091200190565b54145b1561014d576101446001836101be565b925050506100a4565b509392505050565b600061016460028484186101d5565b610170908484166101a6565b9392505050565b60006020828403121561018957600080fd5b5035919050565b634e487b7160e01b600052601160045260246000fd5b600082198211156101b9576101b9610190565b500190565b6000828210156101d0576101d0610190565b500390565b6000826101f257634e487b7160e01b600052601260045260246000fd5b50049056fea26469706673582212202e217b4cd093c814853c0174fdf68b76a3ba8918b39426ef649831db69c4c3bc64736f6c63430008090033";

    public static final String FUNC_FINDUPPERBOUND = "findUpperBound";

    public static final String FUNC_UNSAFEACCESS = "unsafeAccess";

    @Deprecated
    protected Uint256ArraysMock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Uint256ArraysMock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Uint256ArraysMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Uint256ArraysMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<BigInteger> findUpperBound(BigInteger element) {
        final Function function = new Function(FUNC_FINDUPPERBOUND, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(element)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> unsafeAccess(BigInteger pos) {
        final Function function = new Function(FUNC_UNSAFEACCESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(pos)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static Uint256ArraysMock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Uint256ArraysMock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Uint256ArraysMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Uint256ArraysMock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Uint256ArraysMock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Uint256ArraysMock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Uint256ArraysMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Uint256ArraysMock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Uint256ArraysMock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, List<BigInteger> array) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(array, org.web3j.abi.datatypes.generated.Uint256.class))));
        return deployRemoteCall(Uint256ArraysMock.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<Uint256ArraysMock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, List<BigInteger> array) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(array, org.web3j.abi.datatypes.generated.Uint256.class))));
        return deployRemoteCall(Uint256ArraysMock.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Uint256ArraysMock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, List<BigInteger> array) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(array, org.web3j.abi.datatypes.generated.Uint256.class))));
        return deployRemoteCall(Uint256ArraysMock.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Uint256ArraysMock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, List<BigInteger> array) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(array, org.web3j.abi.datatypes.generated.Uint256.class))));
        return deployRemoteCall(Uint256ArraysMock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
