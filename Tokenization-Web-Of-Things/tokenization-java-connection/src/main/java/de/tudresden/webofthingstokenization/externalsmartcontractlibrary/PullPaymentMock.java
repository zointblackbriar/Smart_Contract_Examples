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
public class PullPaymentMock extends Contract {
    public static final String BINARY = "60a06040526040516100109061003e565b604051809103906000f08015801561002c573d6000803e3d6000fd5b506001600160a01b031660805261004b565b61058b8061036e83390190565b6080516102fb6100736000396000818160b20152818161014101526101e201526102fb6000f3fe608060405234801561001057600080fd5b50600436106100415760003560e01c806331b3eb9414610046578063d44409911461005b578063e2982c211461006e575b600080fd5b61005961005436600461025c565b610093565b005b610059610069366004610280565b610111565b61008161007c36600461025c565b61011f565b60405190815260200160405180910390f35b6040516351cff8d960e01b81526001600160a01b0382811660048301527f000000000000000000000000000000000000000000000000000000000000000016906351cff8d990602401600060405180830381600087803b1580156100f657600080fd5b505af115801561010a573d6000803e3d6000fd5b5050505050565b61011b82826101c3565b5050565b6040516371d4ed8d60e11b81526001600160a01b0382811660048301526000917f00000000000000000000000000000000000000000000000000000000000000009091169063e3a9db1a9060240160206040518083038186803b15801561018557600080fd5b505afa158015610199573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906101bd91906102ac565b92915050565b60405163f340fa0160e01b81526001600160a01b0383811660048301527f0000000000000000000000000000000000000000000000000000000000000000169063f340fa019083906024016000604051808303818588803b15801561022757600080fd5b505af115801561023b573d6000803e3d6000fd5b50505050505050565b6001600160a01b038116811461025957600080fd5b50565b60006020828403121561026e57600080fd5b813561027981610244565b9392505050565b6000806040838503121561029357600080fd5b823561029e81610244565b946020939093013593505050565b6000602082840312156102be57600080fd5b505191905056fea2646970667358221220f93f144120296ee6cbca1f3468bc01eb17a6e3292187b36d884411bb1130780364736f6c63430008090033608060405234801561001057600080fd5b5061001a3361001f565b61006f565b600080546001600160a01b038381166001600160a01b0319831681178455604051919092169283917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e09190a35050565b61050d8061007e6000396000f3fe6080604052600436106100555760003560e01c806351cff8d91461005a578063715018a61461007c5780638da5cb5b14610091578063e3a9db1a146100be578063f2fde38b14610102578063f340fa0114610122575b600080fd5b34801561006657600080fd5b5061007a61007536600461048d565b610135565b005b34801561008857600080fd5b5061007a6101ac565b34801561009d57600080fd5b506000546040516001600160a01b0390911681526020015b60405180910390f35b3480156100ca57600080fd5b506100f46100d936600461048d565b6001600160a01b031660009081526001602052604090205490565b6040519081526020016100b5565b34801561010e57600080fd5b5061007a61011d36600461048d565b6101c0565b61007a61013036600461048d565b61023e565b61013d6102b0565b6001600160a01b0381166000818152600160205260408120805491905590610165908261030a565b816001600160a01b03167f7084f5476618d8e60b11ef0d7d3f06914655adb8793e28ff7f018d4c76d505d5826040516101a091815260200190565b60405180910390a25050565b6101b46102b0565b6101be6000610428565b565b6101c86102b0565b6001600160a01b0381166102325760405162461bcd60e51b815260206004820152602660248201527f4f776e61626c653a206e6577206f776e657220697320746865207a65726f206160448201526564647265737360d01b60648201526084015b60405180910390fd5b61023b81610428565b50565b6102466102b0565b6001600160a01b0381166000908152600160205260408120805434928392916102709084906104b1565b90915550506040518181526001600160a01b038316907f2da466a7b24304f47e87fa2e1e5a81b9831ce54fec19055ce277ca2f39ba42c4906020016101a0565b6000546001600160a01b031633146101be5760405162461bcd60e51b815260206004820181905260248201527f4f776e61626c653a2063616c6c6572206973206e6f7420746865206f776e65726044820152606401610229565b8047101561035a5760405162461bcd60e51b815260206004820152601d60248201527f416464726573733a20696e73756666696369656e742062616c616e63650000006044820152606401610229565b6000826001600160a01b03168260405160006040518083038185875af1925050503d80600081146103a7576040519150601f19603f3d011682016040523d82523d6000602084013e6103ac565b606091505b50509050806104235760405162461bcd60e51b815260206004820152603a60248201527f416464726573733a20756e61626c6520746f2073656e642076616c75652c207260448201527f6563697069656e74206d617920686176652072657665727465640000000000006064820152608401610229565b505050565b600080546001600160a01b038381166001600160a01b0319831681178455604051919092169283917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e09190a35050565b6001600160a01b038116811461023b57600080fd5b60006020828403121561049f57600080fd5b81356104aa81610478565b9392505050565b600082198211156104d257634e487b7160e01b600052601160045260246000fd5b50019056fea264697066735822122049a160efdbda8286ef3cae2c2d1c8d9047a3b53702981805433931a3237451e164736f6c63430008090033";

    public static final String FUNC_CALLTRANSFER = "callTransfer";

    public static final String FUNC_PAYMENTS = "payments";

    public static final String FUNC_WITHDRAWPAYMENTS = "withdrawPayments";

    @Deprecated
    protected PullPaymentMock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected PullPaymentMock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected PullPaymentMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected PullPaymentMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> callTransfer(String dest, BigInteger amount) {
        final Function function = new Function(
                FUNC_CALLTRANSFER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, dest), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> payments(String dest) {
        final Function function = new Function(FUNC_PAYMENTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, dest)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> withdrawPayments(String payee) {
        final Function function = new Function(
                FUNC_WITHDRAWPAYMENTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, payee)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static PullPaymentMock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new PullPaymentMock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static PullPaymentMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new PullPaymentMock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static PullPaymentMock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new PullPaymentMock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static PullPaymentMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new PullPaymentMock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<PullPaymentMock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, BigInteger initialWeiValue) {
        return deployRemoteCall(PullPaymentMock.class, web3j, credentials, contractGasProvider, BINARY, "", initialWeiValue);
    }

    public static RemoteCall<PullPaymentMock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, BigInteger initialWeiValue) {
        return deployRemoteCall(PullPaymentMock.class, web3j, transactionManager, contractGasProvider, BINARY, "", initialWeiValue);
    }

    @Deprecated
    public static RemoteCall<PullPaymentMock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployRemoteCall(PullPaymentMock.class, web3j, credentials, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    @Deprecated
    public static RemoteCall<PullPaymentMock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployRemoteCall(PullPaymentMock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }
}
