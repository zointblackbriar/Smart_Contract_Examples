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
public class ContextMockCaller extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b506102cf806100206000396000f3fe608060405234801561001057600080fd5b50600436106100355760003560e01c80628604591461003a5780633207ad961461004f575b600080fd5b61004d61004836600461014f565b610062565b005b61004d61005d36600461021a565b6100c7565b604051631bb5f93160e11b81526001600160a01b0384169063376bf26290610090908590859060040161023c565b600060405180830381600087803b1580156100aa57600080fd5b505af11580156100be573d6000803e3d6000fd5b50505050505050565b806001600160a01b031663d737d0c76040518163ffffffff1660e01b8152600401600060405180830381600087803b15801561010257600080fd5b505af1158015610116573d6000803e3d6000fd5b5050505050565b80356001600160a01b038116811461013457600080fd5b919050565b634e487b7160e01b600052604160045260246000fd5b60008060006060848603121561016457600080fd5b61016d8461011d565b925060208401359150604084013567ffffffffffffffff8082111561019157600080fd5b818601915086601f8301126101a557600080fd5b8135818111156101b7576101b7610139565b604051601f8201601f19908116603f011681019083821181831017156101df576101df610139565b816040528281528960208487010111156101f857600080fd5b8260208601602083013760006020848301015280955050505050509250925092565b60006020828403121561022c57600080fd5b6102358261011d565b9392505050565b82815260006020604081840152835180604085015260005b8181101561027057858101830151858201606001528201610254565b81811115610282576000606083870101525b50601f01601f19169290920160600194935050505056fea264697066735822122027c277411766ce441d95c9a596f70d551b47063377b988c17090e5fe0320b34564736f6c63430008090033";

    public static final String FUNC_CALLDATA = "callData";

    public static final String FUNC_CALLSENDER = "callSender";

    @Deprecated
    protected ContextMockCaller(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ContextMockCaller(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ContextMockCaller(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ContextMockCaller(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> callData(String context, BigInteger integerValue, String stringValue) {
        final Function function = new Function(
                FUNC_CALLDATA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, context), 
                new org.web3j.abi.datatypes.generated.Uint256(integerValue), 
                new org.web3j.abi.datatypes.Utf8String(stringValue)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> callSender(String context) {
        final Function function = new Function(
                FUNC_CALLSENDER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, context)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static ContextMockCaller load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ContextMockCaller(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ContextMockCaller load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ContextMockCaller(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ContextMockCaller load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ContextMockCaller(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ContextMockCaller load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ContextMockCaller(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ContextMockCaller> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ContextMockCaller.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ContextMockCaller> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ContextMockCaller.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<ContextMockCaller> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ContextMockCaller.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ContextMockCaller> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ContextMockCaller.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
