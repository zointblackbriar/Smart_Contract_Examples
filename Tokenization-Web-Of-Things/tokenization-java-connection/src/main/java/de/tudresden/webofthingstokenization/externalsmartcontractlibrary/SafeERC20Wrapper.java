package de.tudresden.webofthingstokenization.externalsmartcontractlibrary;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.FunctionEncoder;
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
public class SafeERC20Wrapper extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50604051610d01380380610d0183398101604081905261002f91610054565b600080546001600160a01b0319166001600160a01b0392909216919091179055610084565b60006020828403121561006657600080fd5b81516001600160a01b038116811461007d57600080fd5b9392505050565b610c6e806100936000396000f3fe608060405234801561001057600080fd5b50600436106100885760003560e01c80638a4068dd1161005b5780638a4068dd146100d0578063b759f954146100d8578063d505accf146100eb578063de242ff4146100fe57600080fd5b806310bad4cf1461008d57806311e330b2146100a25780633ba93f26146100b5578063811c34d3146100c8575b600080fd5b6100a061009b366004610aad565b610118565b005b6100a06100b0366004610aad565b610135565b6100a06100c3366004610aad565b61014f565b6100a06101b0565b6100a06101cd565b6100a06100e6366004610aad565b6101e7565b6100a06100f9366004610ae2565b610201565b610106610226565b60405190815260200160405180910390f35b60008054610132916001600160a01b0390911690836102af565b50565b60008054610132916001600160a01b039091169083610402565b600054604051631dd49f9360e11b8152600481018390526001600160a01b0390911690633ba93f2690602401600060405180830381600087803b15801561019557600080fd5b505af11580156101a9573d6000803e3d6000fd5b5050505050565b600080546101cb916001600160a01b039091169080806104c9565b565b600080546101cb916001600160a01b039091169080610501565b60008054610132916001600160a01b039091169083610536565b60005461021d906001600160a01b03168888888888888861065a565b50505050505050565b60008054604051636eb1769f60e11b815260048101839052602481018390526001600160a01b039091169063dd62ed3e9060440160206040518083038186803b15801561027257600080fd5b505afa158015610286573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906102aa9190610b55565b905090565b604051636eb1769f60e11b81523060048201526001600160a01b0383811660248301526000919085169063dd62ed3e9060440160206040518083038186803b1580156102fa57600080fd5b505afa15801561030e573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906103329190610b55565b90508181101561039b5760405162461bcd60e51b815260206004820152602960248201527f5361666545524332303a2064656372656173656420616c6c6f77616e63652062604482015268656c6f77207a65726f60b81b60648201526084015b60405180910390fd5b6040516001600160a01b038416602482015282820360448201819052906101a990869063095ea7b360e01b906064015b60408051601f198184030181529190526020810180516001600160e01b03166001600160e01b03199093169290921790915261084e565b604051636eb1769f60e11b81523060048201526001600160a01b038381166024830152600091839186169063dd62ed3e9060440160206040518083038186803b15801561044e57600080fd5b505afa158015610462573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906104869190610b55565b6104909190610b6e565b6040516001600160a01b0385166024820152604481018290529091506104c390859063095ea7b360e01b906064016103cb565b50505050565b6040516001600160a01b03808516602483015283166044820152606481018290526104c39085906323b872dd60e01b906084016103cb565b6040516001600160a01b03831660248201526044810182905261053190849063a9059cbb60e01b906064016103cb565b505050565b8015806105bf5750604051636eb1769f60e11b81523060048201526001600160a01b03838116602483015284169063dd62ed3e9060440160206040518083038186803b15801561058557600080fd5b505afa158015610599573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906105bd9190610b55565b155b61062a5760405162461bcd60e51b815260206004820152603660248201527f5361666545524332303a20617070726f76652066726f6d206e6f6e2d7a65726f60448201527520746f206e6f6e2d7a65726f20616c6c6f77616e636560501b6064820152608401610392565b6040516001600160a01b03831660248201526044810182905261053190849063095ea7b360e01b906064016103cb565b604051623f675f60e91b81526001600160a01b038881166004830152600091908a1690637ecebe009060240160206040518083038186803b15801561069e57600080fd5b505afa1580156106b2573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906106d69190610b55565b60405163d505accf60e01b81526001600160a01b038a811660048301528981166024830152604482018990526064820188905260ff8716608483015260a4820186905260c48201859052919250908a169063d505accf9060e401600060405180830381600087803b15801561074a57600080fd5b505af115801561075e573d6000803e3d6000fd5b5050604051623f675f60e91b81526001600160a01b038b81166004830152600093508c169150637ecebe009060240160206040518083038186803b1580156107a557600080fd5b505afa1580156107b9573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906107dd9190610b55565b90506107ea826001610b6e565b81146108425760405162461bcd60e51b815260206004820152602160248201527f5361666545524332303a207065726d697420646964206e6f74207375636365656044820152601960fa1b6064820152608401610392565b50505050505050505050565b60006108a3826040518060400160405280602081526020017f5361666545524332303a206c6f772d6c6576656c2063616c6c206661696c6564815250856001600160a01b03166109209092919063ffffffff16565b80519091501561053157808060200190518101906108c19190610b94565b6105315760405162461bcd60e51b815260206004820152602a60248201527f5361666545524332303a204552433230206f7065726174696f6e20646964206e6044820152691bdd081cdd58d8d9595960b21b6064820152608401610392565b606061092f8484600085610937565b949350505050565b6060824710156109985760405162461bcd60e51b815260206004820152602660248201527f416464726573733a20696e73756666696369656e742062616c616e636520666f6044820152651c8818d85b1b60d21b6064820152608401610392565b600080866001600160a01b031685876040516109b49190610be9565b60006040518083038185875af1925050503d80600081146109f1576040519150601f19603f3d011682016040523d82523d6000602084013e6109f6565b606091505b5091509150610a0787838387610a12565b979650505050505050565b60608315610a7e578251610a77576001600160a01b0385163b610a775760405162461bcd60e51b815260206004820152601d60248201527f416464726573733a2063616c6c20746f206e6f6e2d636f6e74726163740000006044820152606401610392565b508161092f565b61092f8383815115610a935781518083602001fd5b8060405162461bcd60e51b81526004016103929190610c05565b600060208284031215610abf57600080fd5b5035919050565b80356001600160a01b0381168114610add57600080fd5b919050565b600080600080600080600060e0888a031215610afd57600080fd5b610b0688610ac6565b9650610b1460208901610ac6565b95506040880135945060608801359350608088013560ff81168114610b3857600080fd5b9699959850939692959460a0840135945060c09093013592915050565b600060208284031215610b6757600080fd5b5051919050565b60008219821115610b8f57634e487b7160e01b600052601160045260246000fd5b500190565b600060208284031215610ba657600080fd5b81518015158114610bb657600080fd5b9392505050565b60005b83811015610bd8578181015183820152602001610bc0565b838111156104c35750506000910152565b60008251610bfb818460208701610bbd565b9190910192915050565b6020815260008251806020840152610c24816040850160208701610bbd565b601f01601f1916919091016040019291505056fea2646970667358221220bdb49bca8034dc0c475e9caff07139bc8588172efacae40d579b78cbc39e085164736f6c63430008090033";

    public static final String FUNC_ALLOWANCE = "allowance";

    public static final String FUNC_APPROVE = "approve";

    public static final String FUNC_DECREASEALLOWANCE = "decreaseAllowance";

    public static final String FUNC_INCREASEALLOWANCE = "increaseAllowance";

    public static final String FUNC_PERMIT = "permit";

    public static final String FUNC_SETALLOWANCE = "setAllowance";

    public static final String FUNC_TRANSFER = "transfer";

    public static final String FUNC_TRANSFERFROM = "transferFrom";

    @Deprecated
    protected SafeERC20Wrapper(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected SafeERC20Wrapper(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected SafeERC20Wrapper(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected SafeERC20Wrapper(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<BigInteger> allowance() {
        final Function function = new Function(FUNC_ALLOWANCE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> approve(BigInteger amount) {
        final Function function = new Function(
                FUNC_APPROVE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> decreaseAllowance(BigInteger amount) {
        final Function function = new Function(
                FUNC_DECREASEALLOWANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> increaseAllowance(BigInteger amount) {
        final Function function = new Function(
                FUNC_INCREASEALLOWANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> permit(String owner, String spender, BigInteger value, BigInteger deadline, BigInteger v, byte[] r, byte[] s) {
        final Function function = new Function(
                FUNC_PERMIT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, owner), 
                new org.web3j.abi.datatypes.Address(160, spender), 
                new org.web3j.abi.datatypes.generated.Uint256(value), 
                new org.web3j.abi.datatypes.generated.Uint256(deadline), 
                new org.web3j.abi.datatypes.generated.Uint8(v), 
                new org.web3j.abi.datatypes.generated.Bytes32(r), 
                new org.web3j.abi.datatypes.generated.Bytes32(s)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setAllowance(BigInteger allowance_) {
        final Function function = new Function(
                FUNC_SETALLOWANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(allowance_)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> transfer() {
        final Function function = new Function(
                FUNC_TRANSFER, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> transferFrom() {
        final Function function = new Function(
                FUNC_TRANSFERFROM, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static SafeERC20Wrapper load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new SafeERC20Wrapper(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static SafeERC20Wrapper load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new SafeERC20Wrapper(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static SafeERC20Wrapper load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new SafeERC20Wrapper(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static SafeERC20Wrapper load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new SafeERC20Wrapper(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<SafeERC20Wrapper> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String token) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, token)));
        return deployRemoteCall(SafeERC20Wrapper.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<SafeERC20Wrapper> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String token) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, token)));
        return deployRemoteCall(SafeERC20Wrapper.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<SafeERC20Wrapper> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String token) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, token)));
        return deployRemoteCall(SafeERC20Wrapper.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<SafeERC20Wrapper> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String token) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, token)));
        return deployRemoteCall(SafeERC20Wrapper.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
