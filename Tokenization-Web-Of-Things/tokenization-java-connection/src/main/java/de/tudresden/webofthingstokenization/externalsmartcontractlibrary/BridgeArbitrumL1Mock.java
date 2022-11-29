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
public class BridgeArbitrumL1Mock extends Contract {
    public static final String BINARY = "60c060405260405161001090610080565b604051809103906000f08015801561002c573d6000803e3d6000fd5b506001600160a01b03166080526040516100459061008c565b604051809103906000f080158015610061573d6000803e3d6000fd5b506001600160a01b031660a05234801561007a57600080fd5b50610099565b60d1806104b183390190565b6101b98061058283390190565b60805160a0516103ef6100c2600039600081816087015260b00152600060d701526103ef6000f3fe608060405234801561001057600080fd5b50600436106100575760003560e01c806370348f3e1461005c578063ab5d894314610085578063ce11e6ab146100ab578063fb0e722b146100d2578063fb417a5b146100f9575b600080fd5b6000546001600160a01b03165b6040516001600160a01b03909116815260200160405180910390f35b7f0000000000000000000000000000000000000000000000000000000000000000610069565b6100697f000000000000000000000000000000000000000000000000000000000000000081565b6100697f000000000000000000000000000000000000000000000000000000000000000081565b61010c6101073660046102c0565b61010e565b005b600080546001600160a01b038381166001600160a01b03198316178355604051918116929182918816906101459088908890610354565b6000604051808303816000865af19150503d8060008114610182576040519150601f19603f3d011682016040523d82523d6000602084013e610187565b606091505b50915091506101cd8783836040518060400160405280601781526020017f6c6f772d6c6576656c2063616c6c2072657665727465640000000000000000008152506101f7565b5050600080546001600160a01b0319166001600160a01b0393909316929092179091555050505050565b60608315610268578251610261576001600160a01b0385163b6102615760405162461bcd60e51b815260206004820152601d60248201527f416464726573733a2063616c6c20746f206e6f6e2d636f6e747261637400000060448201526064015b60405180910390fd5b5081610272565b610272838361027a565b949350505050565b81511561028a5781518083602001fd5b8060405162461bcd60e51b81526004016102589190610364565b80356001600160a01b03811681146102bb57600080fd5b919050565b600080600080606085870312156102d657600080fd5b6102df856102a4565b9350602085013567ffffffffffffffff808211156102fc57600080fd5b818701915087601f83011261031057600080fd5b81358181111561031f57600080fd5b88602082850101111561033157600080fd5b602083019550809450505050610349604086016102a4565b905092959194509250565b8183823760009101908152919050565b600060208083528351808285015260005b8181101561039157858101830151858201604001528201610375565b818111156103a3576000604083870101525b50601f01601f191692909201604001939250505056fea2646970667358221220519b54c8b48e40415215c7e71b1be10ad9e1cc83cdc0678baa99a9e68b3f6a1664736f6c6343000809003360a060405233608052348015601357600080fd5b5060805160a561002c60003960006031015260a56000f3fe6080604052348015600f57600080fd5b506004361060285760003560e01c8063e78cea9214602d575b600080fd5b60537f000000000000000000000000000000000000000000000000000000000000000081565b6040516001600160a01b03909116815260200160405180910390f3fea26469706673582212202c0e34b86da543ec4308b0e0f075b71f0c18a3d89e612a69879a1a219c088e9a64736f6c6343000809003360a06040523360805234801561001457600080fd5b506080516101846100356000396000818160640152608a01526101846000f3fe608060405234801561001057600080fd5b50600436106100365760003560e01c806380648b021461003b578063e78cea921461005f575b600080fd5b610043610086565b6040516001600160a01b03909116815260200160405180910390f35b6100437f000000000000000000000000000000000000000000000000000000000000000081565b60007f00000000000000000000000000000000000000000000000000000000000000006001600160a01b03166370348f3e6040518163ffffffff1660e01b815260040160206040518083038186803b1580156100e157600080fd5b505afa1580156100f5573d6000803e3d6000fd5b505050506040513d601f19601f82011682018060405250810190610119919061011e565b905090565b60006020828403121561013057600080fd5b81516001600160a01b038116811461014757600080fd5b939250505056fea2646970667358221220b321a3b324afc4c27ff617e92c7e7300f8a5e73ade6c9c75cd8b13e5b44e66c064736f6c63430008090033";

    public static final String FUNC_ACTIVEOUTBOX = "activeOutbox";

    public static final String FUNC_CURRENTSENDER = "currentSender";

    public static final String FUNC_INBOX = "inbox";

    public static final String FUNC_OUTBOX = "outbox";

    public static final String FUNC_RELAYAS = "relayAs";

    @Deprecated
    protected BridgeArbitrumL1Mock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected BridgeArbitrumL1Mock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected BridgeArbitrumL1Mock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected BridgeArbitrumL1Mock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<String> activeOutbox() {
        final Function function = new Function(FUNC_ACTIVEOUTBOX, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> currentSender() {
        final Function function = new Function(FUNC_CURRENTSENDER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> inbox() {
        final Function function = new Function(FUNC_INBOX, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> outbox() {
        final Function function = new Function(FUNC_OUTBOX, 
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

    @Deprecated
    public static BridgeArbitrumL1Mock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new BridgeArbitrumL1Mock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static BridgeArbitrumL1Mock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new BridgeArbitrumL1Mock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static BridgeArbitrumL1Mock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new BridgeArbitrumL1Mock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static BridgeArbitrumL1Mock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new BridgeArbitrumL1Mock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<BridgeArbitrumL1Mock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(BridgeArbitrumL1Mock.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<BridgeArbitrumL1Mock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(BridgeArbitrumL1Mock.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<BridgeArbitrumL1Mock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(BridgeArbitrumL1Mock.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<BridgeArbitrumL1Mock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(BridgeArbitrumL1Mock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
