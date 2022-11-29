package de.tudresden.webofthingstokenization.externalsmartcontractlibrary;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint160;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint96;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;
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
public class Checkpoints160Mock extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b5061068e806100206000396000f3fe608060405234801561001057600080fd5b50600436106100625760003560e01c80631f7b6d32146100675780634455fc091461007d57806352bfe789146100a8578063907c0f92146100b057806394c2e537146100e6578063fa617704146100f9575b600080fd5b6000546040519081526020015b60405180910390f35b61009061008b366004610593565b610131565b6040516001600160a01b039091168152602001610074565b610090610143565b6100b861014f565b6040805193151584526001600160601b0390921660208401526001600160a01b031690820152606001610074565b6100906100f4366004610593565b610169565b61010c6101073660046105ae565b610175565b604080516001600160a01b03938416815292909116602083015201610074565b905090565b600061013d818361018e565b92915050565b600061012c60006101e7565b600080600061015e6000610221565b925092509250909192565b600061013d818361029a565b6000806101838185856102c5565b915091509250929050565b8154600090816101a0858583856102e0565b905080156101db576101c5856101b7600184610607565b600091825260209091200190565b54600160601b90046001600160a01b03166101de565b60005b95945050505050565b8054600090801561021757610201836101b7600184610607565b54600160601b90046001600160a01b031661021a565b60005b9392505050565b8054600090819081908061024057600080600093509350935050610293565b6000610251866101b7600185610607565b6040805180820190915290546001600160601b038116808352600160601b9091046001600160a01b031660209092018290526001965094509250610293915050565b9193909250565b8154600090816102ac85858385610344565b90508181146101db5760008581526020902081016101c5565b6000806102d38585856103a0565b915091505b935093915050565b60005b8183101561033c5760006102f7848461055c565b6000878152602090209091506001600160601b038616908201546001600160601b0316111561032857809250610336565b61033381600161061e565b93505b506102e3565b509392505050565b60005b8183101561033c57600061035b848461055c565b6000878152602090209091506001600160601b038616908201546001600160601b031610156103965761038f81600161061e565b935061039a565b8092505b50610347565b8254600090819080156105005760006103be876101b7600185610607565b6040805180820190915290546001600160601b03808216808452600160601b9092046001600160a01b0316602084015291925090871610156104465760405162461bcd60e51b815260206004820152601760248201527f436865636b706f696e743a20696e76616c6964206b6579000000000000000000604482015260640160405180910390fd5b856001600160601b031681600001516001600160601b0316141561049e5784610474886101b7600186610607565b80546001600160a01b0392909216600160601b026001600160601b039092169190911790556104f0565b604080518082019091526001600160601b0380881682526001600160a01b0380881660208085019182528b54600181018d5560008d81529190912094519151909216600160601b029216919091179101555b6020015192508391506102d89050565b5050604080518082019091526001600160601b0380851682526001600160a01b0380851660208085019182528854600181018a5560008a815291822095519251909316600160601b0291909316179201919091559050816102d8565b600061056b6002848418610636565b61021a9084841661061e565b80356001600160601b038116811461058e57600080fd5b919050565b6000602082840312156105a557600080fd5b61021a82610577565b600080604083850312156105c157600080fd5b6105ca83610577565b915060208301356001600160a01b03811681146105e657600080fd5b809150509250929050565b634e487b7160e01b600052601160045260246000fd5b600082821015610619576106196105f1565b500390565b60008219821115610631576106316105f1565b500190565b60008261065357634e487b7160e01b600052601260045260246000fd5b50049056fea264697066735822122097977e666e526db3117cafd23c5f8318f7d9f4c5b08b62a7f50df1be95d5ee7064736f6c63430008090033";

    public static final String FUNC_LATEST = "latest";

    public static final String FUNC_LATESTCHECKPOINT = "latestCheckpoint";

    public static final String FUNC_LENGTH = "length";

    public static final String FUNC_LOWERLOOKUP = "lowerLookup";

    public static final String FUNC_PUSH = "push";

    public static final String FUNC_UPPERLOOKUP = "upperLookup";

    @Deprecated
    protected Checkpoints160Mock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Checkpoints160Mock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Checkpoints160Mock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Checkpoints160Mock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<BigInteger> latest() {
        final Function function = new Function(FUNC_LATEST, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint160>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Tuple3<Boolean, BigInteger, BigInteger>> latestCheckpoint() {
        final Function function = new Function(FUNC_LATESTCHECKPOINT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}, new TypeReference<Uint96>() {}, new TypeReference<Uint160>() {}));
        return new RemoteFunctionCall<Tuple3<Boolean, BigInteger, BigInteger>>(function,
                new Callable<Tuple3<Boolean, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple3<Boolean, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<Boolean, BigInteger, BigInteger>(
                                (Boolean) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue());
                    }
                });
    }

    public RemoteFunctionCall<BigInteger> length() {
        final Function function = new Function(FUNC_LENGTH, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> lowerLookup(BigInteger key) {
        final Function function = new Function(FUNC_LOWERLOOKUP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint96(key)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint160>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> push(BigInteger key, BigInteger value) {
        final Function function = new Function(
                FUNC_PUSH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint96(key), 
                new org.web3j.abi.datatypes.generated.Uint160(value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> upperLookup(BigInteger key) {
        final Function function = new Function(FUNC_UPPERLOOKUP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint96(key)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint160>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static Checkpoints160Mock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Checkpoints160Mock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Checkpoints160Mock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Checkpoints160Mock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Checkpoints160Mock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Checkpoints160Mock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Checkpoints160Mock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Checkpoints160Mock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Checkpoints160Mock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Checkpoints160Mock.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Checkpoints160Mock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Checkpoints160Mock.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Checkpoints160Mock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Checkpoints160Mock.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Checkpoints160Mock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Checkpoints160Mock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
