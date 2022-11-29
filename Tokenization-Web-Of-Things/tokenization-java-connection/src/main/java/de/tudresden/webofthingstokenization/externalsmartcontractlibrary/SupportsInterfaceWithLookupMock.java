package de.tudresden.webofthingstokenization.externalsmartcontractlibrary;

import java.math.BigInteger;
import java.util.Arrays;
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
public class SupportsInterfaceWithLookupMock extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b506100216301ffc9a760e01b610026565b6100c1565b6001600160e01b0319808216141561009c5760405162461bcd60e51b815260206004820152602f60248201527f455243313635496e7465726661636573537570706f727465643a20696e76616c60448201526e1a59081a5b9d195c999858d9481a59608a1b606482015260840160405180910390fd5b6001600160e01b0319166000908152602081905260409020805460ff19166001179055565b610100806100d06000396000f3fe6080604052348015600f57600080fd5b506004361060325760003560e01c806301ffc9a714603757806334d7006c146076575b600080fd5b60616042366004609b565b6001600160e01b03191660009081526020819052604090205460ff1690565b60405190151581526020015b60405180910390f35b60836301ffc9a760e01b81565b6040516001600160e01b03199091168152602001606d565b60006020828403121560ac57600080fd5b81356001600160e01b03198116811460c357600080fd5b939250505056fea264697066735822122006d4311c615a206ab055b3c9c0b78471ce8f62b81ad562f218017288619e5a4f64736f6c63430008090033";

    public static final String FUNC_INTERFACE_ID_ERC165 = "INTERFACE_ID_ERC165";

    public static final String FUNC_SUPPORTSINTERFACE = "supportsInterface";

    @Deprecated
    protected SupportsInterfaceWithLookupMock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected SupportsInterfaceWithLookupMock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected SupportsInterfaceWithLookupMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected SupportsInterfaceWithLookupMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
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
    public static SupportsInterfaceWithLookupMock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new SupportsInterfaceWithLookupMock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static SupportsInterfaceWithLookupMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new SupportsInterfaceWithLookupMock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static SupportsInterfaceWithLookupMock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new SupportsInterfaceWithLookupMock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static SupportsInterfaceWithLookupMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new SupportsInterfaceWithLookupMock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<SupportsInterfaceWithLookupMock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(SupportsInterfaceWithLookupMock.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<SupportsInterfaceWithLookupMock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(SupportsInterfaceWithLookupMock.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<SupportsInterfaceWithLookupMock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SupportsInterfaceWithLookupMock.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<SupportsInterfaceWithLookupMock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SupportsInterfaceWithLookupMock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
