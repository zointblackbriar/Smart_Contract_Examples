package de.tudresden.webofthingstokenization.externalsmartcontractlibrary;

import java.math.BigInteger;
import java.util.Arrays;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
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
public class ECDSAMock extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b506108cf806100206000396000f3fe608060405234801561001057600080fd5b50600436106100575760003560e01c8063126442731461005c57806319045a251461008c578063918a15cf1461009f57806392bd87b5146100c0578063a005410b146100d3575b600080fd5b61006f61006a36600461062b565b6100e6565b6040516001600160a01b0390911681526020015b60405180910390f35b61006f61009a366004610711565b6100fd565b6100b26100ad366004610758565b610110565b604051908152602001610083565b6100b26100ce366004610771565b610121565b61006f6100e13660046107a6565b61012c565b60006100f485858585610141565b95945050505050565b60006101098383610169565b9392505050565b600061011b8261018d565b92915050565b600061011b826101e1565b60006101398484846101ff565b949350505050565b600080600061015287878787610225565b9150915061015f816102e9565b5095945050505050565b6000806000610178858561043f565b91509150610185816102e9565b509392505050565b6040517f19457468657265756d205369676e6564204d6573736167653a0a3332000000006020820152603c8101829052600090605c015b604051602081830303815290604052805190602001209050919050565b60006101ed8251610485565b826040516020016101c4929190610802565b600080600061020f86868661051a565b9150915061021c816102e9565b50949350505050565b6000807f7fffffffffffffffffffffffffffffff5d576e7357a4501ddfe92f46681b20a083111561025c57506000905060036102e0565b6040805160008082526020820180845289905260ff881692820192909252606081018690526080810185905260019060a0016020604051602081039080840390855afa1580156102b0573d6000803e3d6000fd5b5050604051601f1901519150506001600160a01b0381166102d9576000600192509250506102e0565b9150600090505b94509492505050565b60008160048111156102fd576102fd61085d565b14156103065750565b600181600481111561031a5761031a61085d565b141561036d5760405162461bcd60e51b815260206004820152601860248201527f45434453413a20696e76616c6964207369676e6174757265000000000000000060448201526064015b60405180910390fd5b60028160048111156103815761038161085d565b14156103cf5760405162461bcd60e51b815260206004820152601f60248201527f45434453413a20696e76616c6964207369676e6174757265206c656e677468006044820152606401610364565b60038160048111156103e3576103e361085d565b141561043c5760405162461bcd60e51b815260206004820152602260248201527f45434453413a20696e76616c6964207369676e6174757265202773272076616c604482015261756560f01b6064820152608401610364565b50565b6000808251604114156104765760208301516040840151606085015160001a61046a87828585610225565b9450945050505061047e565b506000905060025b9250929050565b6060600061049283610553565b600101905060008167ffffffffffffffff8111156104b2576104b261066e565b6040519080825280601f01601f1916602001820160405280156104dc576020820181803683370190505b5090508181016020015b600019016f181899199a1a9b1b9c1cb0b131b232b360811b600a86061a8153600a850494508461051557610185565b6104e6565b6000806001600160ff1b0383168161053760ff86901c601b610873565b905061054587828885610225565b935093505050935093915050565b60008072184f03e93ff9f4daa797ed6e38ed64bf6a1f0160401b83106105925772184f03e93ff9f4daa797ed6e38ed64bf6a1f0160401b830492506040015b6d04ee2d6d415b85acef810000000083106105be576d04ee2d6d415b85acef8100000000830492506020015b662386f26fc1000083106105dc57662386f26fc10000830492506010015b6305f5e10083106105f4576305f5e100830492506008015b612710831061060857612710830492506004015b6064831061061a576064830492506002015b600a831061011b5760010192915050565b6000806000806080858703121561064157600080fd5b84359350602085013560ff8116811461065957600080fd5b93969395505050506040820135916060013590565b634e487b7160e01b600052604160045260246000fd5b600082601f83011261069557600080fd5b813567ffffffffffffffff808211156106b0576106b061066e565b604051601f8301601f19908116603f011681019082821181831017156106d8576106d861066e565b816040528381528660208588010111156106f157600080fd5b836020870160208301376000602085830101528094505050505092915050565b6000806040838503121561072457600080fd5b82359150602083013567ffffffffffffffff81111561074257600080fd5b61074e85828601610684565b9150509250929050565b60006020828403121561076a57600080fd5b5035919050565b60006020828403121561078357600080fd5b813567ffffffffffffffff81111561079a57600080fd5b61013984828501610684565b6000806000606084860312156107bb57600080fd5b505081359360208301359350604090920135919050565b60005b838110156107ed5781810151838201526020016107d5565b838111156107fc576000848401525b50505050565b7f19457468657265756d205369676e6564204d6573736167653a0a00000000000081526000835161083a81601a8501602088016107d2565b83519083019061085181601a8401602088016107d2565b01601a01949350505050565b634e487b7160e01b600052602160045260246000fd5b6000821982111561089457634e487b7160e01b600052601160045260246000fd5b50019056fea2646970667358221220a6a236ffedeb2a68b96e284570baa0fa4a64eb76632ca58667db15a92effc4b264736f6c63430008090033";

    public static final String FUNC_RECOVER = "recover";

    public static final String FUNC_RECOVER_R_VS = "recover_r_vs";

    public static final String FUNC_RECOVER_V_R_S = "recover_v_r_s";

    public static final String FUNC_toEthSignedMessageHash = "toEthSignedMessageHash";

    @Deprecated
    protected ECDSAMock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ECDSAMock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ECDSAMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ECDSAMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<String> recover(byte[] hash, byte[] signature) {
        final Function function = new Function(FUNC_RECOVER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(hash), 
                new org.web3j.abi.datatypes.DynamicBytes(signature)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> recover_r_vs(byte[] hash, byte[] r, byte[] vs) {
        final Function function = new Function(FUNC_RECOVER_R_VS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(hash), 
                new org.web3j.abi.datatypes.generated.Bytes32(r), 
                new org.web3j.abi.datatypes.generated.Bytes32(vs)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> recover_v_r_s(byte[] hash, BigInteger v, byte[] r, byte[] s) {
        final Function function = new Function(FUNC_RECOVER_V_R_S, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(hash), 
                new org.web3j.abi.datatypes.generated.Uint8(v), 
                new org.web3j.abi.datatypes.generated.Bytes32(r), 
                new org.web3j.abi.datatypes.generated.Bytes32(s)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<byte[]> toEthSignedMessageHash(byte[] hash) {
        final Function function = new Function(FUNC_toEthSignedMessageHash, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(hash)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<byte[]> toEthSignedMessageHash(byte[] s) {
        final Function function = new Function(FUNC_toEthSignedMessageHash, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicBytes(s)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    @Deprecated
    public static ECDSAMock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ECDSAMock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ECDSAMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ECDSAMock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ECDSAMock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ECDSAMock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ECDSAMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ECDSAMock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ECDSAMock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ECDSAMock.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ECDSAMock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ECDSAMock.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<ECDSAMock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ECDSAMock.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ECDSAMock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ECDSAMock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
