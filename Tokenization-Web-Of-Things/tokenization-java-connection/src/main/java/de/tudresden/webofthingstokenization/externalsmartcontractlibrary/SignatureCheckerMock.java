package de.tudresden.webofthingstokenization.externalsmartcontractlibrary;

import java.math.BigInteger;
import java.util.Arrays;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
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
public class SignatureCheckerMock extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b5061049d806100206000396000f3fe608060405234801561001057600080fd5b506004361061002b5760003560e01c80636ccea65214610030575b600080fd5b61004361003e3660046102d9565b610057565b604051901515815260200160405180910390f35b600061006d6001600160a01b0385168484610077565b90505b9392505050565b600080600061008685856101b9565b9092509050600081600481111561009f5761009f6103b2565b1480156100bd5750856001600160a01b0316826001600160a01b0316145b156100cd57600192505050610070565b600080876001600160a01b0316631626ba7e60e01b88886040516024016100f59291906103f8565b60408051601f198184030181529181526020820180516001600160e01b03166001600160e01b03199094169390931790925290516101339190610432565b600060405180830381855afa9150503d806000811461016e576040519150601f19603f3d011682016040523d82523d6000602084013e610173565b606091505b5091509150818015610186575080516020145b80156101ad57508051630b135d3f60e11b906101ab908301602090810190840161044e565b145b98975050505050505050565b6000808251604114156101f05760208301516040840151606085015160001a6101e4878285856101ff565b945094505050506101f8565b506000905060025b9250929050565b6000807f7fffffffffffffffffffffffffffffff5d576e7357a4501ddfe92f46681b20a083111561023657506000905060036102ba565b6040805160008082526020820180845289905260ff881692820192909252606081018690526080810185905260019060a0016020604051602081039080840390855afa15801561028a573d6000803e3d6000fd5b5050604051601f1901519150506001600160a01b0381166102b3576000600192509250506102ba565b9150600090505b94509492505050565b634e487b7160e01b600052604160045260246000fd5b6000806000606084860312156102ee57600080fd5b83356001600160a01b038116811461030557600080fd5b925060208401359150604084013567ffffffffffffffff8082111561032957600080fd5b818601915086601f83011261033d57600080fd5b81358181111561034f5761034f6102c3565b604051601f8201601f19908116603f01168101908382118183101715610377576103776102c3565b8160405282815289602084870101111561039057600080fd5b8260208601602083013760006020848301015280955050505050509250925092565b634e487b7160e01b600052602160045260246000fd5b60005b838110156103e35781810151838201526020016103cb565b838111156103f2576000848401525b50505050565b828152604060208201526000825180604084015261041d8160608501602087016103c8565b601f01601f1916919091016060019392505050565b600082516104448184602087016103c8565b9190910192915050565b60006020828403121561046057600080fd5b505191905056fea26469706673582212201df1a701ffd18e325a1805cca0c4f2a56f5cee8106fec321a71c2d3d83ba1cdd64736f6c63430008090033";

    public static final String FUNC_ISVALIDSIGNATURENOW = "isValidSignatureNow";

    @Deprecated
    protected SignatureCheckerMock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected SignatureCheckerMock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected SignatureCheckerMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected SignatureCheckerMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<Boolean> isValidSignatureNow(String signer, byte[] hash, byte[] signature) {
        final Function function = new Function(FUNC_ISVALIDSIGNATURENOW, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, signer), 
                new org.web3j.abi.datatypes.generated.Bytes32(hash), 
                new org.web3j.abi.datatypes.DynamicBytes(signature)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    @Deprecated
    public static SignatureCheckerMock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new SignatureCheckerMock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static SignatureCheckerMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new SignatureCheckerMock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static SignatureCheckerMock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new SignatureCheckerMock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static SignatureCheckerMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new SignatureCheckerMock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<SignatureCheckerMock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(SignatureCheckerMock.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<SignatureCheckerMock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SignatureCheckerMock.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<SignatureCheckerMock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(SignatureCheckerMock.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<SignatureCheckerMock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SignatureCheckerMock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
