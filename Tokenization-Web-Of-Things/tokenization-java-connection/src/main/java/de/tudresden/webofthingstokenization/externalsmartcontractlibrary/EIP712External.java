package de.tudresden.webofthingstokenization.externalsmartcontractlibrary;

import java.math.BigInteger;
import java.util.Arrays;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
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
public class EIP712External extends Contract {
    public static final String BINARY = "61014060405234801561001157600080fd5b5060405161090d38038061090d83398101604081905261003091610186565b815160209283012081519183019190912060e08290526101008190524660a0818152604080517f8b73c3c69bb8fe3d512ecc4cf759cc79239f7b179b0ffacaa9a75d522b39400f818801819052818301969096526060810194909452608080850193909352308483018190528151808603909301835260c094850190915281519190950120905291909152610120526101e9565b634e487b7160e01b600052604160045260246000fd5b600082601f8301126100eb57600080fd5b81516001600160401b0380821115610105576101056100c4565b604051601f8301601f19908116603f0116810190828211818310171561012d5761012d6100c4565b8160405283815260209250868385880101111561014957600080fd5b600091505b8382101561016b578582018301518183018401529082019061014e565b8382111561017c5760008385830101525b9695505050505050565b6000806040838503121561019957600080fd5b82516001600160401b03808211156101b057600080fd5b6101bc868387016100da565b935060208501519150808211156101d257600080fd5b506101df858286016100da565b9150509250929050565b60805160a05160c05160e05161010051610120516106d56102386000396000610234015260006102830152600061025e015260006101b7015260006101e10152600061020b01526106d56000f3fe608060405234801561001057600080fd5b50600436106100415760003560e01c806308c6e079146100465780633408e4701461005b578063f698da251461006f575b600080fd5b6100596100543660046105d9565b610077565b005b465b60405190815260200160405180910390f35b61005d610123565b60006100ed7f847fc9da8ec3c72cae85ca691245eaeb0a4a1e74f77c3a919c43afda231d39ba8484805190602001206040516020016100d2939291909283526001600160a01b03919091166020830152604082015260600190565b60405160208183030381529060405280519060200120610132565b905060006100fb8287610186565b9050846001600160a01b0316816001600160a01b03161461011b57600080fd5b505050505050565b600061012d6101aa565b905090565b600061018061013f6101aa565b8360405161190160f01b6020820152602281018390526042810182905260009060620160405160208183030381529060405280519060200120905092915050565b92915050565b600080600061019585856102d1565b915091506101a281610317565b509392505050565b6000306001600160a01b037f00000000000000000000000000000000000000000000000000000000000000001614801561020357507f000000000000000000000000000000000000000000000000000000000000000046145b1561022d57507f000000000000000000000000000000000000000000000000000000000000000090565b50604080517f00000000000000000000000000000000000000000000000000000000000000006020808301919091527f0000000000000000000000000000000000000000000000000000000000000000828401527f000000000000000000000000000000000000000000000000000000000000000060608301524660808301523060a0808401919091528351808403909101815260c0909201909252805191012090565b6000808251604114156103085760208301516040840151606085015160001a6102fc8782858561046d565b94509450505050610310565b506000905060025b9250929050565b600081600481111561032b5761032b610689565b14156103345750565b600181600481111561034857610348610689565b141561039b5760405162461bcd60e51b815260206004820152601860248201527f45434453413a20696e76616c6964207369676e6174757265000000000000000060448201526064015b60405180910390fd5b60028160048111156103af576103af610689565b14156103fd5760405162461bcd60e51b815260206004820152601f60248201527f45434453413a20696e76616c6964207369676e6174757265206c656e677468006044820152606401610392565b600381600481111561041157610411610689565b141561046a5760405162461bcd60e51b815260206004820152602260248201527f45434453413a20696e76616c6964207369676e6174757265202773272076616c604482015261756560f01b6064820152608401610392565b50565b6000807f7fffffffffffffffffffffffffffffff5d576e7357a4501ddfe92f46681b20a08311156104a45750600090506003610528565b6040805160008082526020820180845289905260ff881692820192909252606081018690526080810185905260019060a0016020604051602081039080840390855afa1580156104f8573d6000803e3d6000fd5b5050604051601f1901519150506001600160a01b03811661052157600060019250925050610528565b9150600090505b94509492505050565b634e487b7160e01b600052604160045260246000fd5b600067ffffffffffffffff8084111561056257610562610531565b604051601f8501601f19908116603f0116810190828211818310171561058a5761058a610531565b816040528093508581528686860111156105a357600080fd5b858560208301376000602087830101525050509392505050565b80356001600160a01b03811681146105d457600080fd5b919050565b600080600080608085870312156105ef57600080fd5b843567ffffffffffffffff8082111561060757600080fd5b818701915087601f83011261061b57600080fd5b61062a88833560208501610547565b9550610638602088016105bd565b9450610646604088016105bd565b9350606087013591508082111561065c57600080fd5b508501601f8101871361066e57600080fd5b61067d87823560208401610547565b91505092959194509250565b634e487b7160e01b600052602160045260246000fdfea2646970667358221220406a5df33887b28d618b9f3351aabe73b93ee8a03ebbb2275e8053d259b3a13a64736f6c63430008090033";

    public static final String FUNC_DOMAINSEPARATOR = "domainSeparator";

    public static final String FUNC_GETCHAINID = "getChainId";

    public static final String FUNC_VERIFY = "verify";

    @Deprecated
    protected EIP712External(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected EIP712External(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected EIP712External(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected EIP712External(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<byte[]> domainSeparator() {
        final Function function = new Function(FUNC_DOMAINSEPARATOR, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<BigInteger> getChainId() {
        final Function function = new Function(FUNC_GETCHAINID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static EIP712External load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new EIP712External(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static EIP712External load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new EIP712External(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static EIP712External load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new EIP712External(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static EIP712External load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new EIP712External(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<EIP712External> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String name, String version) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.Utf8String(version)));
        return deployRemoteCall(EIP712External.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<EIP712External> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String name, String version) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.Utf8String(version)));
        return deployRemoteCall(EIP712External.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<EIP712External> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String name, String version) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.Utf8String(version)));
        return deployRemoteCall(EIP712External.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<EIP712External> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String name, String version) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.Utf8String(version)));
        return deployRemoteCall(EIP712External.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
