package de.tudresden.javaconnection.externalsmartcontractlibrary;

import java.math.BigInteger;
import java.util.Arrays;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
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
 * <p>Generated with web3j version 4.8.9.
 */
@SuppressWarnings("rawtypes")
public class AssetTransfer extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b506101f6806100206000396000f3fe608060405234801561001057600080fd5b50600436106100415760003560e01c806365366012146100465780637f92175d14610076578063ec69f29f1461008b575b600080fd5b600054610059906001600160a01b031681565b6040516001600160a01b0390911681526020015b60405180910390f35b61007e6100a2565b60405161006d9190610130565b61009460025481565b60405190815260200161006d565b600180546100af90610185565b80601f01602080910402602001604051908101604052809291908181526020018280546100db90610185565b80156101285780601f106100fd57610100808354040283529160200191610128565b820191906000526020600020905b81548152906001019060200180831161010b57829003601f168201915b505050505081565b600060208083528351808285015260005b8181101561015d57858101830151858201604001528201610141565b8181111561016f576000604083870101525b50601f01601f1916929092016040019392505050565b600181811c9082168061019957607f821691505b602082108114156101ba57634e487b7160e01b600052602260045260246000fd5b5091905056fea264697066735822122081e873ad3f1955d6e0c512496aa5a2753013649c40ec82bb128c304553a36a1364736f6c63430008090033";

    public static final String FUNC_ASKINGPRICE = "AskingPrice";

    public static final String FUNC_DESCRIPTOR = "Descriptor";

    public static final String FUNC_TRANSFERCOMPANY = "transferCompany";

    @Deprecated
    protected AssetTransfer(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected AssetTransfer(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected AssetTransfer(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected AssetTransfer(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<BigInteger> AskingPrice() {
        final Function function = new Function(FUNC_ASKINGPRICE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> Descriptor() {
        final Function function = new Function(FUNC_DESCRIPTOR, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> transferCompany() {
        final Function function = new Function(FUNC_TRANSFERCOMPANY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static AssetTransfer load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new AssetTransfer(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static AssetTransfer load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new AssetTransfer(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static AssetTransfer load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new AssetTransfer(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static AssetTransfer load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new AssetTransfer(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<AssetTransfer> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(AssetTransfer.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<AssetTransfer> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(AssetTransfer.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<AssetTransfer> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(AssetTransfer.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<AssetTransfer> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(AssetTransfer.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
