package de.tudresden.contractsample.connection;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
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
 * <p>Generated with web3j version 4.8.9.
 */
@SuppressWarnings("rawtypes")
public class ComponentCore extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b506106fd806100206000396000f3fe608060405234801561001057600080fd5b50600436106100885760003560e01c8063ce2886e31161005b578063ce2886e314610122578063d0bf6d1514610133578063dc4b852014610146578063e959b38a1461015957600080fd5b806301ffc9a71461008d5780634ff6aa46146100b55780636e8eb7bc146100cc578063b3cac0a5146100f7575b600080fd5b6100a061009b3660046105f8565b61016c565b60405190151581526020015b60405180910390f35b6100ca600180546001600160a01b0319169055565b005b6100df6100da366004610629565b6101a3565b6040516001600160a01b0390911681526020016100ac565b6100a0610105366004610629565b6000908152602081905260409020546001600160a01b0316151590565b6001546001600160a01b03166100df565b6100ca610141366004610629565b610291565b6100ca61015436600461065e565b610391565b6100ca610167366004610679565b61041b565b60006301ffc9a760e01b6001600160e01b03198316148061019d57506001600160e01b0319821663b937000360e01b145b92915050565b60008181526020819052604080822054905163b3cac0a560e01b8152600481018490526001600160a01b0390911690309063b3cac0a59060240160206040518083038186803b1580156101f557600080fd5b505afa158015610209573d6000803e3d6000fd5b505050506040513d601f19601f8201168201806040525081019061022d91906106a5565b1561019d57604051630800096360e41b81523060048201526001600160a01b03821690638000963090602401600060405180830381600087803b15801561027357600080fd5b505af1158015610287573d6000803e3d6000fd5b5050505092915050565b60405163b3cac0a560e01b815260048101829052309063b3cac0a59060240160206040518083038186803b1580156102c857600080fd5b505afa1580156102dc573d6000803e3d6000fd5b505050506040513d601f19601f8201168201806040525081019061030091906106a5565b6103075750565b600081815260208190526040808220549051630800096360e41b815260048101929092526001600160a01b0316908190638000963090602401600060405180830381600087803b15801561035a57600080fd5b505af115801561036e573d6000803e3d6000fd5b5050506000928352505060208190526040902080546001600160a01b0319169055565b60006103a4826340560c3360e11b610522565b9050806103f85760405162461bcd60e51b815260206004820152601f60248201527f446f65736e277420737570706f7274205465616d20696e746572666163652e0060448201526064015b60405180910390fd5b50600180546001600160a01b0319166001600160a01b0392909216919091179055565b6001600160a01b03811661042d575050565b6000610440826318ca552960e11b610522565b9050806104a05760405162461bcd60e51b815260206004820152602860248201527f446f65736e277420737570706f727420436f6d706f6e656e74526f6c6520696e6044820152673a32b93330b1b29760c11b60648201526084016103ef565b6000838152602081905260409081902080546001600160a01b0319166001600160a01b0385169081179091559051630800096360e41b8152306004820152839190638000963090602401600060405180830381600087803b15801561050457600080fd5b505af1158015610518573d6000803e3d6000fd5b5050505050505050565b60008080610537856301ffc9a760e01b6105c4565b9092509050811580610547575080155b156105575760009250505061019d565b610569856001600160e01b03196105c4565b909250905081158061057a57508015155b1561058a5760009250505061019d565b61059485856105c4565b90925090506001821480156105a95750806001145b156105b95760019250505061019d565b506000949350505050565b6040516301ffc9a760e01b8082526004820183905260009182919060208160248189617530fa905190969095509350505050565b60006020828403121561060a57600080fd5b81356001600160e01b03198116811461062257600080fd5b9392505050565b60006020828403121561063b57600080fd5b5035919050565b80356001600160a01b038116811461065957600080fd5b919050565b60006020828403121561067057600080fd5b61062282610642565b6000806040838503121561068c57600080fd5b8235915061069c60208401610642565b90509250929050565b6000602082840312156106b757600080fd5b8151801515811461062257600080fdfea26469706673582212201bf561d3cb87d5e4809621adcb5771626ab5c312b2d6ea58fc0d93651e65428d64736f6c63430008090033";

    public static final String FUNC_ACTIVATETEAM = "activateTeam";

    public static final String FUNC_ADDROLE = "addRole";

    public static final String FUNC_DEACTIVATETEAM = "deactivateTeam";

    public static final String FUNC_GETACTIVETEAM = "getActiveTeam";

    public static final String FUNC_GETROLE = "getRole";

    public static final String FUNC_ISPLAYINGROLE = "isPlayingRole";

    public static final String FUNC_REMOVEROLE = "removeRole";

    public static final String FUNC_SUPPORTSINTERFACE = "supportsInterface";

    @Deprecated
    protected ComponentCore(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ComponentCore(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ComponentCore(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ComponentCore(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> activateTeam(String team) {
        final Function function = new Function(
                FUNC_ACTIVATETEAM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, team)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> addRole(byte[] spec, String role) {
        final Function function = new Function(
                FUNC_ADDROLE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(spec), 
                new org.web3j.abi.datatypes.Address(160, role)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> deactivateTeam() {
        final Function function = new Function(
                FUNC_DEACTIVATETEAM, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> getActiveTeam() {
        final Function function = new Function(FUNC_GETACTIVETEAM, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> getRole(byte[] spec) {
        final Function function = new Function(
                FUNC_GETROLE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(spec)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> isPlayingRole(byte[] spec) {
        final Function function = new Function(FUNC_ISPLAYINGROLE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(spec)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> removeRole(byte[] spec) {
        final Function function = new Function(
                FUNC_REMOVEROLE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(spec)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> supportsInterface(byte[] interfaceID) {
        final Function function = new Function(FUNC_SUPPORTSINTERFACE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes4(interfaceID)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    @Deprecated
    public static ComponentCore load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ComponentCore(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ComponentCore load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ComponentCore(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ComponentCore load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ComponentCore(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ComponentCore load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ComponentCore(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ComponentCore> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ComponentCore.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ComponentCore> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ComponentCore.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<ComponentCore> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ComponentCore.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ComponentCore> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ComponentCore.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
