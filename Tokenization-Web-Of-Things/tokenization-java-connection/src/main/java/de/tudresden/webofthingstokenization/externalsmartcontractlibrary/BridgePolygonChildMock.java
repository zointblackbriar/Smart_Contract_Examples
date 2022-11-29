package de.tudresden.webofthingstokenization.externalsmartcontractlibrary;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
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
public class BridgePolygonChildMock extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b506101dd806100206000396000f3fe608060405234801561001057600080fd5b506004361061002b5760003560e01c8063fb417a5b14610030575b600080fd5b61004361003e3660046100cc565b610045565b005b604051639a7c4b7160e01b81526001600160a01b03851690639a7c4b719061007890600090859088908890600401610160565b600060405180830381600087803b15801561009257600080fd5b505af11580156100a6573d6000803e3d6000fd5b5050505050505050565b80356001600160a01b03811681146100c757600080fd5b919050565b600080600080606085870312156100e257600080fd5b6100eb856100b0565b9350602085013567ffffffffffffffff8082111561010857600080fd5b818701915087601f83011261011c57600080fd5b81358181111561012b57600080fd5b88602082850101111561013d57600080fd5b602083019550809450505050610155604086016100b0565b905092959194509250565b8481526001600160a01b03841660208201526060604082018190528101829052818360808301376000818301608090810191909152601f909201601f19160101939250505056fea2646970667358221220ec98df43a342692e297e1a34d9b8bbd485c7d92a7838b5f7fbc54062d537022764736f6c63430008090033";

    public static final String FUNC_RELAYAS = "relayAs";

    @Deprecated
    protected BridgePolygonChildMock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected BridgePolygonChildMock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected BridgePolygonChildMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected BridgePolygonChildMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> relayAs(String target, byte[] data, String sender) {
        final Function function = new Function(
                FUNC_RELAYAS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, target), 
                new org.web3j.abi.datatypes.DynamicBytes(data), 
                new org.web3j.abi.datatypes.Address(160, sender)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static BridgePolygonChildMock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new BridgePolygonChildMock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static BridgePolygonChildMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new BridgePolygonChildMock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static BridgePolygonChildMock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new BridgePolygonChildMock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static BridgePolygonChildMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new BridgePolygonChildMock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<BridgePolygonChildMock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(BridgePolygonChildMock.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<BridgePolygonChildMock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(BridgePolygonChildMock.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<BridgePolygonChildMock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(BridgePolygonChildMock.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<BridgePolygonChildMock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(BridgePolygonChildMock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
