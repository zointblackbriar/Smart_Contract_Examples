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
import org.web3j.abi.datatypes.generated.Uint224;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint32;
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
public class Checkpoints224Mock extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50610663806100206000396000f3fe608060405234801561001057600080fd5b50600436106100625760003560e01c80631f7b6d321461006757806352bfe7891461007d5780637a9b2fd81461009d578063907c0f92146100b0578063a9dc1528146100e3578063b50b7eb6146100f6575b600080fd5b6000546040519081526020015b60405180910390f35b61008561012e565b6040516001600160e01b039091168152602001610074565b6100856100ab366004610568565b61013a565b6100b861014c565b60408051931515845263ffffffff90921660208401526001600160e01b031690820152606001610074565b6100856100f1366004610568565b610166565b610109610104366004610583565b610172565b604080516001600160e01b03938416815292909116602083015201610074565b905090565b6000610129600061018b565b600061014681836101d3565b92915050565b600080600061015b600061021c565b925092509250909192565b60006101468183610292565b6000806101808185856102bb565b915091509250929050565b805460009080156101c9576101b3836101a56001846105dc565b600091825260209091200190565b54600160201b90046001600160e01b03166101cc565b60005b9392505050565b8154600090816101e5858583856102d6565b90508181146102105760008581526020902081015b54600160201b90046001600160e01b0316610213565b60005b95945050505050565b8054600090819081908061023b5760008060009350935093505061028b565b600061024c866101a56001856105dc565b60408051808201909152905463ffffffff8116808352600160201b9091046001600160e01b03166020909201829052600196509450925061028b915050565b9193909250565b8154600090816102a485858385610334565b90508015610210576101fa856101a56001846105dc565b6000806102c985858561038a565b915091505b935093915050565b60005b8183101561032c5760006102ed8484610534565b60008781526020902090915063ffffffff86169082015463ffffffff1610156103225761031b8160016105f3565b9350610326565b8092505b506102d9565b509392505050565b60005b8183101561032c57600061034b8484610534565b60008781526020902090915063ffffffff86169082015463ffffffff16111561037657809250610384565b6103818160016105f3565b93505b50610337565b8254600090819080156104db5760006103a8876101a56001856105dc565b60408051808201909152905463ffffffff808216808452600160201b9092046001600160e01b03166020840152919250908716101561042d5760405162461bcd60e51b815260206004820152601760248201527f436865636b706f696e743a20696e76616c6964206b6579000000000000000000604482015260640160405180910390fd5b8563ffffffff16816000015163ffffffff16141561047c5784610455886101a56001866105dc565b80546001600160e01b0392909216600160201b0263ffffffff9092169190911790556104cb565b6040805180820190915263ffffffff80881682526001600160e01b0380881660208085019182528b54600181018d5560008d81529190912094519151909216600160201b029216919091179101555b6020015192508391506102ce9050565b50506040805180820190915263ffffffff80851682526001600160e01b0380851660208085019182528854600181018a5560008a815291822095519251909316600160201b0291909316179201919091559050816102ce565b6000610543600284841861060b565b6101cc908484166105f3565b803563ffffffff8116811461056357600080fd5b919050565b60006020828403121561057a57600080fd5b6101cc8261054f565b6000806040838503121561059657600080fd5b61059f8361054f565b915060208301356001600160e01b03811681146105bb57600080fd5b809150509250929050565b634e487b7160e01b600052601160045260246000fd5b6000828210156105ee576105ee6105c6565b500390565b60008219821115610606576106066105c6565b500190565b60008261062857634e487b7160e01b600052601260045260246000fd5b50049056fea264697066735822122050cf0ca2ef30506cd5ab96429e5826be11573b28edd636a6f9dc72f22cfb1cee64736f6c63430008090033";

    public static final String FUNC_LATEST = "latest";

    public static final String FUNC_LATESTCHECKPOINT = "latestCheckpoint";

    public static final String FUNC_LENGTH = "length";

    public static final String FUNC_LOWERLOOKUP = "lowerLookup";

    public static final String FUNC_PUSH = "push";

    public static final String FUNC_UPPERLOOKUP = "upperLookup";

    @Deprecated
    protected Checkpoints224Mock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Checkpoints224Mock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Checkpoints224Mock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Checkpoints224Mock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<BigInteger> latest() {
        final Function function = new Function(FUNC_LATEST, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint224>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Tuple3<Boolean, BigInteger, BigInteger>> latestCheckpoint() {
        final Function function = new Function(FUNC_LATESTCHECKPOINT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}, new TypeReference<Uint32>() {}, new TypeReference<Uint224>() {}));
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
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint32(key)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint224>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> push(BigInteger key, BigInteger value) {
        final Function function = new Function(
                FUNC_PUSH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint32(key), 
                new org.web3j.abi.datatypes.generated.Uint224(value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> upperLookup(BigInteger key) {
        final Function function = new Function(FUNC_UPPERLOOKUP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint32(key)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint224>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static Checkpoints224Mock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Checkpoints224Mock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Checkpoints224Mock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Checkpoints224Mock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Checkpoints224Mock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Checkpoints224Mock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Checkpoints224Mock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Checkpoints224Mock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Checkpoints224Mock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Checkpoints224Mock.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Checkpoints224Mock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Checkpoints224Mock.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Checkpoints224Mock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Checkpoints224Mock.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Checkpoints224Mock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Checkpoints224Mock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
