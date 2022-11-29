package de.tudresden.webofthingstokenization.externalsmartcontractlibrary;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes4;
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
public class ERC165InterfacesSupported extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b5060405161036c38038061036c83398101604081905261002f9161015a565b61003f6301ffc9a760e01b61008c565b60005b8151811015610085576100738282815181106100605761006061021e565b602002602001015161008c60201b60201c565b8061007d81610234565b915050610042565b505061025d565b6001600160e01b031980821614156101025760405162461bcd60e51b815260206004820152602f60248201527f455243313635496e7465726661636573537570706f727465643a20696e76616c60448201526e1a59081a5b9d195c999858d9481a59608a1b606482015260840160405180910390fd5b6001600160e01b0319166000908152602081905260409020805460ff19166001179055565b634e487b7160e01b600052604160045260246000fd5b80516001600160e01b03198116811461015557600080fd5b919050565b6000602080838503121561016d57600080fd5b82516001600160401b038082111561018457600080fd5b818501915085601f83011261019857600080fd5b8151818111156101aa576101aa610127565b8060051b604051601f19603f830116810181811085821117156101cf576101cf610127565b6040529182528482019250838101850191888311156101ed57600080fd5b938501935b82851015610212576102038561013d565b845293850193928501926101f2565b98975050505050505050565b634e487b7160e01b600052603260045260246000fd5b600060001982141561025657634e487b7160e01b600052601160045260246000fd5b5060010190565b6101008061026c6000396000f3fe6080604052348015600f57600080fd5b506004361060325760003560e01c806301ffc9a714603757806334d7006c146076575b600080fd5b60616042366004609b565b6001600160e01b03191660009081526020819052604090205460ff1690565b60405190151581526020015b60405180910390f35b60836301ffc9a760e01b81565b6040516001600160e01b03199091168152602001606d565b60006020828403121560ac57600080fd5b81356001600160e01b03198116811460c357600080fd5b939250505056fea2646970667358221220cd7aa4b694b5797f9a7217679f6f305e50e3e64e2d98a1eb7b2cdd88a459a17764736f6c63430008090033";

    public static final String FUNC_INTERFACE_ID_ERC165 = "INTERFACE_ID_ERC165";

    public static final String FUNC_SUPPORTSINTERFACE = "supportsInterface";

    @Deprecated
    protected ERC165InterfacesSupported(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ERC165InterfacesSupported(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ERC165InterfacesSupported(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ERC165InterfacesSupported(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<byte[]> INTERFACE_ID_ERC165() {
        final Function function = new Function(FUNC_INTERFACE_ID_ERC165, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes4>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<Boolean> supportsInterface(byte[] interfaceId) {
        final Function function = new Function(FUNC_SUPPORTSINTERFACE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes4(interfaceId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    @Deprecated
    public static ERC165InterfacesSupported load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ERC165InterfacesSupported(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ERC165InterfacesSupported load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ERC165InterfacesSupported(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ERC165InterfacesSupported load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ERC165InterfacesSupported(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ERC165InterfacesSupported load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ERC165InterfacesSupported(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ERC165InterfacesSupported> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, List<byte[]> interfaceIds) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes4>(
                        org.web3j.abi.datatypes.generated.Bytes4.class,
                        org.web3j.abi.Utils.typeMap(interfaceIds, org.web3j.abi.datatypes.generated.Bytes4.class))));
        return deployRemoteCall(ERC165InterfacesSupported.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<ERC165InterfacesSupported> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, List<byte[]> interfaceIds) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes4>(
                        org.web3j.abi.datatypes.generated.Bytes4.class,
                        org.web3j.abi.Utils.typeMap(interfaceIds, org.web3j.abi.datatypes.generated.Bytes4.class))));
        return deployRemoteCall(ERC165InterfacesSupported.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ERC165InterfacesSupported> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, List<byte[]> interfaceIds) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes4>(
                        org.web3j.abi.datatypes.generated.Bytes4.class,
                        org.web3j.abi.Utils.typeMap(interfaceIds, org.web3j.abi.datatypes.generated.Bytes4.class))));
        return deployRemoteCall(ERC165InterfacesSupported.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ERC165InterfacesSupported> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, List<byte[]> interfaceIds) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes4>(
                        org.web3j.abi.datatypes.generated.Bytes4.class,
                        org.web3j.abi.Utils.typeMap(interfaceIds, org.web3j.abi.datatypes.generated.Bytes4.class))));
        return deployRemoteCall(ERC165InterfacesSupported.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
