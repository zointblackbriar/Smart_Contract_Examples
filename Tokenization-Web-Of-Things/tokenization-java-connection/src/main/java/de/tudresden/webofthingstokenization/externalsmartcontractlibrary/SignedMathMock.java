package de.tudresden.webofthingstokenization.externalsmartcontractlibrary;

import java.math.BigInteger;
import java.util.Arrays;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Int256;
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
public class SignedMathMock extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b5061021f806100206000396000f3fe608060405234801561001057600080fd5b506004361061004c5760003560e01c80631b5ac4b51461005157806329aa9cbe146100765780637f0bb2921461008957806381fe57861461009c575b600080fd5b61006461005f366004610157565b6100af565b60405190815260200160405180910390f35b610064610084366004610170565b6100c0565b610064610097366004610170565b6100d3565b6100646100aa366004610170565b6100df565b60006100ba826100eb565b92915050565b60006100cc8383610102565b9392505050565b60006100cc8383610118565b60006100cc8383610148565b6000808212156100fe57816000036100ba565b5090565b600081831261011157816100cc565b5090919050565b60008061012c84841860011d8585166101a8565b905061014060ff82901c85851816826101a8565b949350505050565b600081831361011157816100cc565b60006020828403121561016957600080fd5b5035919050565b6000806040838503121561018357600080fd5b50508035926020909101359150565b634e487b7160e01b600052601160045260246000fd5b600080821280156001600160ff1b03849003851316156101ca576101ca610192565b600160ff1b83900384128116156101e3576101e3610192565b5050019056fea26469706673582212200965054f9917e89f4069826e9c49817e6c298f1cdf302d445e4bad19e5da626a64736f6c63430008090033";

    public static final String FUNC_ABS = "abs";

    public static final String FUNC_AVERAGE = "average";

    public static final String FUNC_MAX = "max";

    public static final String FUNC_MIN = "min";

    @Deprecated
    protected SignedMathMock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected SignedMathMock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected SignedMathMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected SignedMathMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<BigInteger> abs(BigInteger n) {
        final Function function = new Function(FUNC_ABS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(n)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> average(BigInteger a, BigInteger b) {
        final Function function = new Function(FUNC_AVERAGE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(a), 
                new org.web3j.abi.datatypes.generated.Int256(b)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> max(BigInteger a, BigInteger b) {
        final Function function = new Function(FUNC_MAX, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(a), 
                new org.web3j.abi.datatypes.generated.Int256(b)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> min(BigInteger a, BigInteger b) {
        final Function function = new Function(FUNC_MIN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(a), 
                new org.web3j.abi.datatypes.generated.Int256(b)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static SignedMathMock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new SignedMathMock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static SignedMathMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new SignedMathMock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static SignedMathMock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new SignedMathMock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static SignedMathMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new SignedMathMock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<SignedMathMock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(SignedMathMock.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<SignedMathMock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SignedMathMock.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<SignedMathMock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(SignedMathMock.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<SignedMathMock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SignedMathMock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
