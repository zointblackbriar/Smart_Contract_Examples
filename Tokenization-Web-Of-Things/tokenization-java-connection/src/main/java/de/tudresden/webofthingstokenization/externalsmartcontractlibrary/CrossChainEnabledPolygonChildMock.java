package de.tudresden.webofthingstokenization.externalsmartcontractlibrary;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.FunctionEncoder;
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
public class CrossChainEnabledPolygonChildMock extends Contract {
    public static final String BINARY = "60c060405233608052600180546001600160a01b03191661dead17905534801561002857600080fd5b5060405161061b38038061061b8339810160408190526100479161005d565b60016000556001600160a01b031660a05261008d565b60006020828403121561006f57600080fd5b81516001600160a01b038116811461008657600080fd5b9392505050565b60805160a0516105636100b86000396000610248015260008181606001526101c401526105636000f3fe608060405234801561001057600080fd5b506004361061004c5760003560e01c80634b074af5146100515780638da5cb5b1461005b5780639a7c4b711461009e578063f97f5189146100b1575b600080fd5b6100596100b9565b005b6100827f000000000000000000000000000000000000000000000000000000000000000081565b6040516001600160a01b03909116815260200160405180910390f35b6100596100ac36600461041d565b6100e0565b6100596101c2565b6100c161023d565b6100de5760405163253a6fc960e11b815260040160405180910390fd5b565b6100e861026c565b6100f061023d565b61010d5760405163253a6fc960e11b815260040160405180910390fd5b600180546001600160a01b0319166001600160a01b038516179055604080516020601f840181900481028201810190925282815261019d9130919085908590819084018382808284376000920191909152505060408051808201909152601c81527f63726f73732d636861696e20657865637574696f6e206661696c656400000000602082015291506102c69050565b50600180546001600160a01b03191661dead1790556101bc6001600055565b50505050565b7f000000000000000000000000000000000000000000000000000000000000000060006101ed61033e565b9050806001600160a01b0316826001600160a01b0316146102395760405163ef25d32b60e01b81526001600160a01b038083166004830152831660248201526044015b60405180910390fd5b5050565b336001600160a01b037f0000000000000000000000000000000000000000000000000000000000000000161490565b600260005414156102bf5760405162461bcd60e51b815260206004820152601f60248201527f5265656e7472616e637947756172643a207265656e7472616e742063616c6c006044820152606401610230565b6002600055565b6060600080856001600160a01b0316856040516102e391906104de565b600060405180830381855af49150503d806000811461031e576040519150601f19603f3d011682016040523d82523d6000602084013e610323565b606091505b509150915061033486838387610375565b9695505050505050565b600061034861023d565b6103655760405163253a6fc960e11b815260040160405180910390fd5b506001546001600160a01b031690565b606083156103e15782516103da576001600160a01b0385163b6103da5760405162461bcd60e51b815260206004820152601d60248201527f416464726573733a2063616c6c20746f206e6f6e2d636f6e74726163740000006044820152606401610230565b50816103eb565b6103eb83836103f3565b949350505050565b8151156104035781518083602001fd5b8060405162461bcd60e51b815260040161023091906104fa565b6000806000806060858703121561043357600080fd5b8435935060208501356001600160a01b038116811461045157600080fd5b9250604085013567ffffffffffffffff8082111561046e57600080fd5b818701915087601f83011261048257600080fd5b81358181111561049157600080fd5b8860208285010111156104a357600080fd5b95989497505060200194505050565b60005b838110156104cd5781810151838201526020016104b5565b838111156101bc5750506000910152565b600082516104f08184602087016104b2565b9190910192915050565b60208152600082518060208401526105198160408501602087016104b2565b601f01601f1916919091016040019291505056fea2646970667358221220a82cc8526f8a9f480a66d85635b0f0153ff1abef44fd1bebbd87e4920959e56064736f6c63430008090033";

    public static final String FUNC_CROSSCHAINOWNERRESTRICTED = "crossChainOwnerRestricted";

    public static final String FUNC_CROSSCHAINRESTRICTED = "crossChainRestricted";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_PROCESSMESSAGEFROMROOT = "processMessageFromRoot";

    @Deprecated
    protected CrossChainEnabledPolygonChildMock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected CrossChainEnabledPolygonChildMock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected CrossChainEnabledPolygonChildMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected CrossChainEnabledPolygonChildMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> crossChainOwnerRestricted() {
        final Function function = new Function(
                FUNC_CROSSCHAINOWNERRESTRICTED, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> crossChainRestricted() {
        final Function function = new Function(
                FUNC_CROSSCHAINRESTRICTED, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> processMessageFromRoot(BigInteger param0, String rootMessageSender, byte[] data) {
        final Function function = new Function(
                FUNC_PROCESSMESSAGEFROMROOT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0), 
                new org.web3j.abi.datatypes.Address(160, rootMessageSender), 
                new org.web3j.abi.datatypes.DynamicBytes(data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static CrossChainEnabledPolygonChildMock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new CrossChainEnabledPolygonChildMock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static CrossChainEnabledPolygonChildMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new CrossChainEnabledPolygonChildMock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static CrossChainEnabledPolygonChildMock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new CrossChainEnabledPolygonChildMock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static CrossChainEnabledPolygonChildMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new CrossChainEnabledPolygonChildMock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<CrossChainEnabledPolygonChildMock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String bridge) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, bridge)));
        return deployRemoteCall(CrossChainEnabledPolygonChildMock.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<CrossChainEnabledPolygonChildMock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String bridge) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, bridge)));
        return deployRemoteCall(CrossChainEnabledPolygonChildMock.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<CrossChainEnabledPolygonChildMock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String bridge) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, bridge)));
        return deployRemoteCall(CrossChainEnabledPolygonChildMock.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<CrossChainEnabledPolygonChildMock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String bridge) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, bridge)));
        return deployRemoteCall(CrossChainEnabledPolygonChildMock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
