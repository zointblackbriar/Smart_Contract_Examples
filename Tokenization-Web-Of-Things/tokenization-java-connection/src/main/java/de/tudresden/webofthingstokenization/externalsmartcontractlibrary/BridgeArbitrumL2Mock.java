package de.tudresden.webofthingstokenization.externalsmartcontractlibrary;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
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
public class BridgeArbitrumL2Mock extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50610379806100206000396000f3fe608060405234801561001057600080fd5b50600436106100415760003560e01c8063175a260b14610046578063d74523b314610068578063fb417a5b14610083575b600080fd5b6000546040516001600160a01b03909116151581526020015b60405180910390f35b6000546040516001600160a01b03909116815260200161005f565b61009661009136600461024a565b610098565b005b600080546001600160a01b038381166001600160a01b03198316178355604051918116929182918816906100cf90889088906102de565b6000604051808303816000865af19150503d806000811461010c576040519150601f19603f3d011682016040523d82523d6000602084013e610111565b606091505b50915091506101578783836040518060400160405280601781526020017f6c6f772d6c6576656c2063616c6c207265766572746564000000000000000000815250610181565b5050600080546001600160a01b0319166001600160a01b0393909316929092179091555050505050565b606083156101f25782516101eb576001600160a01b0385163b6101eb5760405162461bcd60e51b815260206004820152601d60248201527f416464726573733a2063616c6c20746f206e6f6e2d636f6e747261637400000060448201526064015b60405180910390fd5b50816101fc565b6101fc8383610204565b949350505050565b8151156102145781518083602001fd5b8060405162461bcd60e51b81526004016101e291906102ee565b80356001600160a01b038116811461024557600080fd5b919050565b6000806000806060858703121561026057600080fd5b6102698561022e565b9350602085013567ffffffffffffffff8082111561028657600080fd5b818701915087601f83011261029a57600080fd5b8135818111156102a957600080fd5b8860208285010111156102bb57600080fd5b6020830195508094505050506102d36040860161022e565b905092959194509250565b8183823760009101908152919050565b600060208083528351808285015260005b8181101561031b578581018301518582016040015282016102ff565b8181111561032d576000604083870101525b50601f01601f191692909201604001939250505056fea26469706673582212200bc1d5953f69d8db8f100e539b4dc98835f7d0ff4f823bef7324a4563ade419b64736f6c63430008090033";

    public static final String FUNC_MYCALLERSADDRESSWITHOUTALIASING = "myCallersAddressWithoutAliasing";

    public static final String FUNC_RELAYAS = "relayAs";

    public static final String FUNC_WASMYCALLERSADDRESSALIASED = "wasMyCallersAddressAliased";

    @Deprecated
    protected BridgeArbitrumL2Mock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected BridgeArbitrumL2Mock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected BridgeArbitrumL2Mock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected BridgeArbitrumL2Mock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<String> myCallersAddressWithoutAliasing() {
        final Function function = new Function(FUNC_MYCALLERSADDRESSWITHOUTALIASING, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
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

    public RemoteFunctionCall<Boolean> wasMyCallersAddressAliased() {
        final Function function = new Function(FUNC_WASMYCALLERSADDRESSALIASED, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    @Deprecated
    public static BridgeArbitrumL2Mock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new BridgeArbitrumL2Mock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static BridgeArbitrumL2Mock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new BridgeArbitrumL2Mock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static BridgeArbitrumL2Mock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new BridgeArbitrumL2Mock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static BridgeArbitrumL2Mock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new BridgeArbitrumL2Mock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<BridgeArbitrumL2Mock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(BridgeArbitrumL2Mock.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<BridgeArbitrumL2Mock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(BridgeArbitrumL2Mock.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<BridgeArbitrumL2Mock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(BridgeArbitrumL2Mock.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<BridgeArbitrumL2Mock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(BridgeArbitrumL2Mock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
