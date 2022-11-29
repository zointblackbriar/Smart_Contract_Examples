package de.tudresden.webofthingstokenization.externalsmartcontractlibrary;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
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
public class StorageSlotMock extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b5061023c806100206000396000f3fe608060405234801561001057600080fd5b50600436106100885760003560e01c80634f3029c21161005b5780634f3029c21461010a578063a6ed563e146100c5578063ca446dd91461011e578063f8715b3e1461014957600080fd5b806321f8a7211461008d57806333598b00146100c55780633848207a146100e55780634e91db081461010a575b600080fd5b6100a861009b366004610165565b546001600160a01b031690565b6040516001600160a01b0390911681526020015b60405180910390f35b6100d76100d3366004610165565b5490565b6040519081526020016100bc565b6100fa6100f3366004610165565b5460ff1690565b60405190151581526020016100bc565b61011c61011836600461017e565b9055565b005b61011c61012c3660046101a0565b81546001600160a01b0319166001600160a01b0391909116179055565b61011c6101573660046101dc565b815460ff1916901515179055565b60006020828403121561017757600080fd5b5035919050565b6000806040838503121561019157600080fd5b50508035926020909101359150565b600080604083850312156101b357600080fd5b8235915060208301356001600160a01b03811681146101d157600080fd5b809150509250929050565b600080604083850312156101ef57600080fd5b82359150602083013580151581146101d157600080fdfea2646970667358221220347e2bb86d02d83f94a4c0a95c9e65cc738872303dbc68b125b7a3cdbd0f341564736f6c63430008090033";

    public static final String FUNC_GETADDRESS = "getAddress";

    public static final String FUNC_GETBOOLEAN = "getBoolean";

    public static final String FUNC_GETBYTES32 = "getBytes32";

    public static final String FUNC_GETUINT256 = "getUint256";

    public static final String FUNC_SETADDRESS = "setAddress";

    public static final String FUNC_SETBOOLEAN = "setBoolean";

    public static final String FUNC_SETBYTES32 = "setBytes32";

    public static final String FUNC_SETUINT256 = "setUint256";

    @Deprecated
    protected StorageSlotMock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected StorageSlotMock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected StorageSlotMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected StorageSlotMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<String> getAddress(byte[] slot) {
        final Function function = new Function(FUNC_GETADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(slot)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Boolean> getBoolean(byte[] slot) {
        final Function function = new Function(FUNC_GETBOOLEAN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(slot)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<byte[]> getBytes32(byte[] slot) {
        final Function function = new Function(FUNC_GETBYTES32, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(slot)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<BigInteger> getUint256(byte[] slot) {
        final Function function = new Function(FUNC_GETUINT256, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(slot)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> setAddress(byte[] slot, String value) {
        final Function function = new Function(
                FUNC_SETADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(slot), 
                new org.web3j.abi.datatypes.Address(160, value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setBoolean(byte[] slot, Boolean value) {
        final Function function = new Function(
                FUNC_SETBOOLEAN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(slot), 
                new org.web3j.abi.datatypes.Bool(value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setBytes32(byte[] slot, byte[] value) {
        final Function function = new Function(
                FUNC_SETBYTES32, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(slot), 
                new org.web3j.abi.datatypes.generated.Bytes32(value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setUint256(byte[] slot, BigInteger value) {
        final Function function = new Function(
                FUNC_SETUINT256, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(slot), 
                new org.web3j.abi.datatypes.generated.Uint256(value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static StorageSlotMock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new StorageSlotMock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static StorageSlotMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new StorageSlotMock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static StorageSlotMock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new StorageSlotMock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static StorageSlotMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new StorageSlotMock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<StorageSlotMock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(StorageSlotMock.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<StorageSlotMock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(StorageSlotMock.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<StorageSlotMock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(StorageSlotMock.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<StorageSlotMock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(StorageSlotMock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
