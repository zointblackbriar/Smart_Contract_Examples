package de.tudresden.webofthingstokenization.externalsmartcontractlibrary;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
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
public class ReentrancyMock extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50600160008181559055610478806100296000396000f3fe608060405234801561001057600080fd5b506004361061007d5760003560e01c806396ffa6901161005b57806396ffa690146100ba578063a408f312146100cd578063b672ad8b146100d5578063cecc95a7146100e857600080fd5b8063083b27321461008257806361bc221a1461008c5780638c5344fa146100a7575b600080fd5b61008a6100f0565b005b61009560015481565b60405190815260200160405180910390f35b61008a6100b5366004610379565b61010c565b61008a6100c8366004610379565b61021e565b61008a610242565b61008a6100e3366004610392565b610259565b61008a6102f6565b6100f8610306565b610100610360565b61010a6001600055565b565b610114610306565b801561021157610122610360565b6000306101306001846103d8565b60405160240161014291815260200190565b60408051601f198184030181529181526020820180516001600160e01b0316634629a27d60e11b1790525161017791906103ef565b6000604051808303816000865af19150503d80600081146101b4576040519150601f19603f3d011682016040523d82523d6000602084013e6101b9565b606091505b505090508061020f5760405162461bcd60e51b815260206004820152601b60248201527f5265656e7472616e63794d6f636b3a206661696c65642063616c6c000000000060448201526064015b60405180910390fd5b505b61021b6001600055565b50565b610226610306565b801561021157610234610360565b6102116100c86001836103d8565b61024a610306565b60005460021461010057600080fd5b610261610306565b610269610360565b604051630a2df1ed60e01b815263041d939960e11b60048201527f083b2732f78169bfaad6b407fa338cc97d697ed69d3915a18239cc111d51a402906001600160a01b03831690630a2df1ed90602401600060405180830381600087803b1580156102d357600080fd5b505af11580156102e7573d6000803e3d6000fd5b505050505061021b6001600055565b6000546002141561010a57600080fd5b600260005414156103595760405162461bcd60e51b815260206004820152601f60248201527f5265656e7472616e637947756172643a207265656e7472616e742063616c6c006044820152606401610206565b6002600055565b6001806000828254610372919061042a565b9091555050565b60006020828403121561038b57600080fd5b5035919050565b6000602082840312156103a457600080fd5b81356001600160a01b03811681146103bb57600080fd5b9392505050565b634e487b7160e01b600052601160045260246000fd5b6000828210156103ea576103ea6103c2565b500390565b6000825160005b8181101561041057602081860181015185830152016103f6565b8181111561041f576000828501525b509190910192915050565b6000821982111561043d5761043d6103c2565b50019056fea26469706673582212201b813bd56d08a75487e0ea4c0e97027717e70027fe7f300711fc43e471f86da264736f6c63430008090033";

    public static final String FUNC_CALLBACK = "callback";

    public static final String FUNC_COUNTANDCALL = "countAndCall";

    public static final String FUNC_COUNTLOCALRECURSIVE = "countLocalRecursive";

    public static final String FUNC_COUNTTHISRECURSIVE = "countThisRecursive";

    public static final String FUNC_COUNTER = "counter";

    public static final String FUNC_GUARDEDCHECKENTERED = "guardedCheckEntered";

    public static final String FUNC_UNGUARDEDCHECKNOTENTERED = "unguardedCheckNotEntered";

    @Deprecated
    protected ReentrancyMock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ReentrancyMock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ReentrancyMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ReentrancyMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> callback() {
        final Function function = new Function(
                FUNC_CALLBACK, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> countAndCall(String attacker) {
        final Function function = new Function(
                FUNC_COUNTANDCALL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, attacker)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> countLocalRecursive(BigInteger n) {
        final Function function = new Function(
                FUNC_COUNTLOCALRECURSIVE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(n)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> countThisRecursive(BigInteger n) {
        final Function function = new Function(
                FUNC_COUNTTHISRECURSIVE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(n)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> counter() {
        final Function function = new Function(FUNC_COUNTER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> guardedCheckEntered() {
        final Function function = new Function(
                FUNC_GUARDEDCHECKENTERED, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static ReentrancyMock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ReentrancyMock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ReentrancyMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ReentrancyMock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ReentrancyMock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ReentrancyMock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ReentrancyMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ReentrancyMock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ReentrancyMock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ReentrancyMock.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<ReentrancyMock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ReentrancyMock.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ReentrancyMock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ReentrancyMock.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ReentrancyMock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ReentrancyMock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
