package de.tudresden.contractsample.connection;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
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
public class Greeter extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b5060405161059638038061059683398101604081905261002f9161010a565b600080546001600160a01b03191633179055805161005490600190602084019061005b565b5050610214565b828054610067906101d9565b90600052602060002090601f01602090048101928261008957600085556100cf565b82601f106100a257805160ff19168380011785556100cf565b828001600101855582156100cf579182015b828111156100cf5782518255916020019190600101906100b4565b506100db9291506100df565b5090565b5b808211156100db57600081556001016100e0565b634e487b7160e01b600052604160045260246000fd5b6000602080838503121561011d57600080fd5b82516001600160401b038082111561013457600080fd5b818501915085601f83011261014857600080fd5b81518181111561015a5761015a6100f4565b604051601f8201601f19908116603f01168101908382118183101715610182576101826100f4565b81604052828152888684870101111561019a57600080fd5b600093505b828410156101bc578484018601518185018701529285019261019f565b828411156101cd5760008684830101525b98975050505050505050565b600181811c908216806101ed57607f821691505b6020821081141561020e57634e487b7160e01b600052602260045260246000fd5b50919050565b610373806102236000396000f3fe608060405234801561001057600080fd5b50600436106100415760003560e01c806341c0e1b5146100465780634ac0d66e14610050578063cfae321714610063575b600080fd5b61004e610081565b005b61004e61005e3660046101fc565b6100a4565b61006b6100bb565b60405161007891906102ad565b60405180910390f35b6000546001600160a01b03163314156100a2576000546001600160a01b0316ff5b565b80516100b790600190602084019061014d565b5050565b6060600180546100ca90610302565b80601f01602080910402602001604051908101604052809291908181526020018280546100f690610302565b80156101435780601f1061011857610100808354040283529160200191610143565b820191906000526020600020905b81548152906001019060200180831161012657829003601f168201915b5050505050905090565b82805461015990610302565b90600052602060002090601f01602090048101928261017b57600085556101c1565b82601f1061019457805160ff19168380011785556101c1565b828001600101855582156101c1579182015b828111156101c15782518255916020019190600101906101a6565b506101cd9291506101d1565b5090565b5b808211156101cd57600081556001016101d2565b634e487b7160e01b600052604160045260246000fd5b60006020828403121561020e57600080fd5b813567ffffffffffffffff8082111561022657600080fd5b818401915084601f83011261023a57600080fd5b81358181111561024c5761024c6101e6565b604051601f8201601f19908116603f01168101908382118183101715610274576102746101e6565b8160405282815287602084870101111561028d57600080fd5b826020860160208301376000928101602001929092525095945050505050565b600060208083528351808285015260005b818110156102da578581018301518582016040015282016102be565b818111156102ec576000604083870101525b50601f01601f1916929092016040019392505050565b600181811c9082168061031657607f821691505b6020821081141561033757634e487b7160e01b600052602260045260246000fd5b5091905056fea26469706673582212203bfdd3daba915b88ab6007a1a2e8b8a84503440e647c60d6564a7c44b1b0c58b64736f6c63430008090033";

    public static final String FUNC_GREET = "greet";

    public static final String FUNC_KILL = "kill";

    public static final String FUNC_NEWGREETING = "newGreeting";

    @Deprecated
    protected Greeter(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Greeter(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Greeter(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Greeter(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<String> greet() {
        final Function function = new Function(FUNC_GREET, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> kill() {
        final Function function = new Function(
                FUNC_KILL, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> newGreeting(String _greeting) {
        final Function function = new Function(
                FUNC_NEWGREETING, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_greeting)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Greeter load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Greeter(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Greeter load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Greeter(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Greeter load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Greeter(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Greeter load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Greeter(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Greeter> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _greeting) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_greeting)));
        return deployRemoteCall(Greeter.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<Greeter> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _greeting) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_greeting)));
        return deployRemoteCall(Greeter.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Greeter> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _greeting) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_greeting)));
        return deployRemoteCall(Greeter.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Greeter> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _greeting) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_greeting)));
        return deployRemoteCall(Greeter.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
