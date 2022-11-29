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
public class Create2Impl extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50610549806100206000396000f3fe6080604052600436106100435760003560e01c8063076c37b21461004f578063481286e61461007157806356299481146100ad57806366cfa057146100cd57600080fd5b3661004a57005b600080fd5b34801561005b57600080fd5b5061006f61006a36600461029e565b6100ed565b005b34801561007d57600080fd5b5061009161008c36600461029e565b61011f565b6040516001600160a01b03909116815260200160405180910390f35b3480156100b957600080fd5b506100916100c83660046102c0565b610132565b3480156100d957600080fd5b5061006f6100e836600461031b565b610147565b61011a82826040518060200161010290610291565b601f1982820381018352601f90910116604052610158565b505050565b600061012b838361025e565b9392505050565b600061013f848484610267565b949350505050565b610152838383610158565b50505050565b6000834710156101af5760405162461bcd60e51b815260206004820152601d60248201527f437265617465323a20696e73756666696369656e742062616c616e636500000060448201526064015b60405180910390fd5b81516101fd5760405162461bcd60e51b815260206004820181905260248201527f437265617465323a2062797465636f6465206c656e677468206973207a65726f60448201526064016101a6565b8282516020840186f590506001600160a01b03811661012b5760405162461bcd60e51b815260206004820152601960248201527f437265617465323a204661696c6564206f6e206465706c6f790000000000000060448201526064016101a6565b600061012b8383305b6000604051836040820152846020820152828152600b8101905060ff815360559020949350505050565b610134806103e083390190565b600080604083850312156102b157600080fd5b50508035926020909101359150565b6000806000606084860312156102d557600080fd5b833592506020840135915060408401356001600160a01b03811681146102fa57600080fd5b809150509250925092565b634e487b7160e01b600052604160045260246000fd5b60008060006060848603121561033057600080fd5b8335925060208401359150604084013567ffffffffffffffff8082111561035657600080fd5b818601915086601f83011261036a57600080fd5b81358181111561037c5761037c610305565b604051601f8201601f19908116603f011681019083821181831017156103a4576103a4610305565b816040528281528960208487010111156103bd57600080fd5b826020860160208301376000602084830101528095505050505050925092509256fe608060405234801561001057600080fd5b50610114806100206000396000f3fe6080604052348015600f57600080fd5b506004361060285760003560e01c8063249cb3fa14602d575b600080fd5b603c603836600460a4565b604e565b60405190815260200160405180910390f35b6000828152602081815260408083206001600160a01b038516845290915281205460ff16607b576000609d565b7fa2ef4600d742022d532d4747cb3547474667d6f13804902513b2ec01c848f4b45b9392505050565b6000806040838503121560b657600080fd5b8235915060208301356001600160a01b038116811460d357600080fd5b80915050925092905056fea264697066735822122064001b23d352bf802cccb327ac557d47638d7ebb906a0bd68ff29b334619837064736f6c63430008090033a264697066735822122045f432606c57c9587fb9550b7d975debc27007684765710c99b662e5c574a46964736f6c63430008090033";

    public static final String FUNC_COMPUTEADDRESS = "computeAddress";

    public static final String FUNC_COMPUTEADDRESSWITHDEPLOYER = "computeAddressWithDeployer";

    public static final String FUNC_DEPLOYERC1820IMPLEMENTER = "deployERC1820Implementer";

    @Deprecated
    protected Create2Impl(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Create2Impl(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Create2Impl(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Create2Impl(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<String> computeAddress(byte[] salt, byte[] codeHash) {
        final Function function = new Function(FUNC_COMPUTEADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(salt), 
                new org.web3j.abi.datatypes.generated.Bytes32(codeHash)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> computeAddressWithDeployer(byte[] salt, byte[] codeHash, String deployer) {
        final Function function = new Function(FUNC_COMPUTEADDRESSWITHDEPLOYER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(salt), 
                new org.web3j.abi.datatypes.generated.Bytes32(codeHash), 
                new org.web3j.abi.datatypes.Address(160, deployer)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> deploy(BigInteger value, byte[] salt, byte[] code) {
        final Function function = new Function(
                FUNC_DEPLOY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(value), 
                new org.web3j.abi.datatypes.generated.Bytes32(salt), 
                new org.web3j.abi.datatypes.DynamicBytes(code)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> deployERC1820Implementer(BigInteger value, byte[] salt) {
        final Function function = new Function(
                FUNC_DEPLOYERC1820IMPLEMENTER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(value), 
                new org.web3j.abi.datatypes.generated.Bytes32(salt)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Create2Impl load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Create2Impl(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Create2Impl load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Create2Impl(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Create2Impl load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Create2Impl(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Create2Impl load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Create2Impl(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Create2Impl> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Create2Impl.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Create2Impl> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Create2Impl.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Create2Impl> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Create2Impl.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Create2Impl> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Create2Impl.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
