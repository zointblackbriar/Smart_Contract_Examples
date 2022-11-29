package de.tudresden.webofthingstokenization.externalsmartcontractlibrary;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
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
public class BridgeOptimismMock extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50610350806100206000396000f3fe608060405234801561001057600080fd5b50600436106100365760003560e01c80636e296e451461003b578063fb417a5b1461005a575b600080fd5b600054604080516001600160a01b039092168252519081900360200190f35b61006d610068366004610221565b61006f565b005b600080546001600160a01b038381166001600160a01b03198316178355604051918116929182918816906100a690889088906102b5565b6000604051808303816000865af19150503d80600081146100e3576040519150601f19603f3d011682016040523d82523d6000602084013e6100e8565b606091505b509150915061012e8783836040518060400160405280601781526020017f6c6f772d6c6576656c2063616c6c207265766572746564000000000000000000815250610158565b5050600080546001600160a01b0319166001600160a01b0393909316929092179091555050505050565b606083156101c95782516101c2576001600160a01b0385163b6101c25760405162461bcd60e51b815260206004820152601d60248201527f416464726573733a2063616c6c20746f206e6f6e2d636f6e747261637400000060448201526064015b60405180910390fd5b50816101d3565b6101d383836101db565b949350505050565b8151156101eb5781518083602001fd5b8060405162461bcd60e51b81526004016101b991906102c5565b80356001600160a01b038116811461021c57600080fd5b919050565b6000806000806060858703121561023757600080fd5b61024085610205565b9350602085013567ffffffffffffffff8082111561025d57600080fd5b818701915087601f83011261027157600080fd5b81358181111561028057600080fd5b88602082850101111561029257600080fd5b6020830195508094505050506102aa60408601610205565b905092959194509250565b8183823760009101908152919050565b600060208083528351808285015260005b818110156102f2578581018301518582016040015282016102d6565b81811115610304576000604083870101525b50601f01601f191692909201604001939250505056fea264697066735822122026ad5867c3813d3962dde699c423f904d32e9659cfd77735710f201835ae2f1c64736f6c63430008090033";

    public static final String FUNC_RELAYAS = "relayAs";

    public static final String FUNC_XDOMAINMESSAGESENDER = "xDomainMessageSender";

    @Deprecated
    protected BridgeOptimismMock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected BridgeOptimismMock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected BridgeOptimismMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected BridgeOptimismMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
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

    public RemoteFunctionCall<String> xDomainMessageSender() {
        final Function function = new Function(FUNC_XDOMAINMESSAGESENDER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static BridgeOptimismMock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new BridgeOptimismMock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static BridgeOptimismMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new BridgeOptimismMock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static BridgeOptimismMock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new BridgeOptimismMock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static BridgeOptimismMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new BridgeOptimismMock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<BridgeOptimismMock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(BridgeOptimismMock.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<BridgeOptimismMock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(BridgeOptimismMock.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<BridgeOptimismMock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(BridgeOptimismMock.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<BridgeOptimismMock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(BridgeOptimismMock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
