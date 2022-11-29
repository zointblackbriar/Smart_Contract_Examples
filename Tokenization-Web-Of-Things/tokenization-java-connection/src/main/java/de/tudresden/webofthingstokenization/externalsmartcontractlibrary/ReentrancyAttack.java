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
public class ReentrancyAttack extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b506101be806100206000396000f3fe608060405234801561001057600080fd5b506004361061002b5760003560e01c80630a2df1ed14610030575b600080fd5b61004361003e36600461011c565b610045565b005b60408051600481526024810182526020810180516001600160e01b03166001600160e01b0319851617905290516000913391610081919061014d565b6000604051808303816000865af19150503d80600081146100be576040519150601f19603f3d011682016040523d82523d6000602084013e6100c3565b606091505b50509050806101185760405162461bcd60e51b815260206004820152601d60248201527f5265656e7472616e637941747461636b3a206661696c65642063616c6c000000604482015260640160405180910390fd5b5050565b60006020828403121561012e57600080fd5b81356001600160e01b03198116811461014657600080fd5b9392505050565b6000825160005b8181101561016e5760208186018101518583015201610154565b8181111561017d576000828501525b50919091019291505056fea2646970667358221220c7661197cd75ac1a2d75fafef5050eb9bdbdf2d522ae40df30204fd76f1b0c0a64736f6c63430008090033";

    public static final String FUNC_CALLSENDER = "callSender";

    @Deprecated
    protected ReentrancyAttack(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ReentrancyAttack(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ReentrancyAttack(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ReentrancyAttack(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> callSender(byte[] data) {
        final Function function = new Function(
                FUNC_CALLSENDER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes4(data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static ReentrancyAttack load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ReentrancyAttack(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ReentrancyAttack load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ReentrancyAttack(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ReentrancyAttack load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ReentrancyAttack(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ReentrancyAttack load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ReentrancyAttack(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ReentrancyAttack> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ReentrancyAttack.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ReentrancyAttack> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ReentrancyAttack.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<ReentrancyAttack> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ReentrancyAttack.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ReentrancyAttack> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ReentrancyAttack.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
