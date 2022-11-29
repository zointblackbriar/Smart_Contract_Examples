package de.tudresden.webofthingstokenization.externalsmartcontractlibrary;

import java.math.BigInteger;
import java.util.Arrays;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
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
public class StringsMock extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50610614806100206000396000f3fe608060405234801561001057600080fd5b506004361061004c5760003560e01c80631bb0c6651461005157806363e1cbea1461007a5780636900a3ae1461008d5780638fba8d5c146100a0575b600080fd5b61006461005f366004610495565b6100b3565b60405161007191906104be565b60405180910390f35b610064610088366004610513565b6100c4565b61006461009b366004610535565b6100d7565b6100646100ae366004610535565b6100e2565b60606100be826100ed565b92915050565b60606100d083836100ff565b9392505050565b60606100be8261029f565b60606100be8261033c565b60606100be6001600160a01b03831660145b6060600061010e836002610564565b610119906002610583565b67ffffffffffffffff8111156101315761013161059b565b6040519080825280601f01601f19166020018201604052801561015b576020820181803683370190505b509050600360fc1b81600081518110610176576101766105b1565b60200101906001600160f81b031916908160001a905350600f60fb1b816001815181106101a5576101a56105b1565b60200101906001600160f81b031916908160001a90535060006101c9846002610564565b6101d4906001610583565b90505b600181111561024c576f181899199a1a9b1b9c1cb0b131b232b360811b85600f1660108110610208576102086105b1565b1a60f81b82828151811061021e5761021e6105b1565b60200101906001600160f81b031916908160001a90535060049490941c93610245816105c7565b90506101d7565b5083156100d05760405162461bcd60e51b815260206004820181905260248201527f537472696e67733a20686578206c656e67746820696e73756666696369656e74604482015260640160405180910390fd5b606060006102ac83610353565b600101905060008167ffffffffffffffff8111156102cc576102cc61059b565b6040519080825280601f01601f1916602001820160405280156102f6576020820181803683370190505b5090508181016020015b600019016f181899199a1a9b1b9c1cb0b131b232b360811b600a86061a8153600a850494508461032f57610334565b610300565b509392505050565b60606100be8261034b8461042b565b6001016100ff565b60008072184f03e93ff9f4daa797ed6e38ed64bf6a1f0160401b83106103925772184f03e93ff9f4daa797ed6e38ed64bf6a1f0160401b830492506040015b6d04ee2d6d415b85acef810000000083106103be576d04ee2d6d415b85acef8100000000830492506020015b662386f26fc1000083106103dc57662386f26fc10000830492506010015b6305f5e10083106103f4576305f5e100830492506008015b612710831061040857612710830492506004015b6064831061041a576064830492506002015b600a83106100be5760010192915050565b600080608083901c156104435760809290921c916010015b604083901c156104585760409290921c916008015b602083901c1561046d5760209290921c916004015b601083901c156104825760109290921c916002015b600883901c156100be5760010192915050565b6000602082840312156104a757600080fd5b81356001600160a01b03811681146100d057600080fd5b600060208083528351808285015260005b818110156104eb578581018301518582016040015282016104cf565b818111156104fd576000604083870101525b50601f01601f1916929092016040019392505050565b6000806040838503121561052657600080fd5b50508035926020909101359150565b60006020828403121561054757600080fd5b5035919050565b634e487b7160e01b600052601160045260246000fd5b600081600019048311821515161561057e5761057e61054e565b500290565b600082198211156105965761059661054e565b500190565b634e487b7160e01b600052604160045260246000fd5b634e487b7160e01b600052603260045260246000fd5b6000816105d6576105d661054e565b50600019019056fea2646970667358221220bf68de332ffc1e2ceb6ea3b82d00dc3bf29f7e53dca600a7addb0e09304b4ad264736f6c63430008090033";

    public static final String FUNC_toHexString = "toHexString";

    public static final String FUNC_TOSTRING = "toString";

    @Deprecated
    protected StringsMock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected StringsMock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected StringsMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected StringsMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<String> toHexString(String addr) {
        final Function function = new Function(FUNC_toHexString, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, addr)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> toHexString(BigInteger value, BigInteger length) {
        final Function function = new Function(FUNC_toHexString, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(value), 
                new org.web3j.abi.datatypes.generated.Uint256(length)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> toHexString(BigInteger value) {
        final Function function = new Function(FUNC_toHexString, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(value)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> toString(BigInteger value) {
        final Function function = new Function(FUNC_TOSTRING, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(value)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static StringsMock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new StringsMock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static StringsMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new StringsMock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static StringsMock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new StringsMock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static StringsMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new StringsMock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<StringsMock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(StringsMock.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<StringsMock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(StringsMock.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<StringsMock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(StringsMock.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<StringsMock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(StringsMock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
