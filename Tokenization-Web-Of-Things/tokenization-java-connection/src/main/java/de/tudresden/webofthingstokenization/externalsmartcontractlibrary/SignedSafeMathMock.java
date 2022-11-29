package de.tudresden.webofthingstokenization.externalsmartcontractlibrary;

import java.math.BigInteger;
import java.util.Arrays;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Int256;
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
public class SignedSafeMathMock extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b506102c5806100206000396000f3fe608060405234801561001057600080fd5b506004361061004c5760003560e01c80634350913814610051578063a5f3c23b14610076578063adefc37b14610089578063bbe93d911461009c575b600080fd5b61006461005f366004610116565b6100af565b60405190815260200160405180910390f35b610064610084366004610116565b6100c2565b610064610097366004610116565b6100ce565b6100646100aa366004610116565b6100da565b60006100bb83836100e6565b9392505050565b60006100bb83836100f2565b60006100bb83836100fe565b60006100bb838361010a565b60006100bb828461014e565b60006100bb828461018a565b60006100bb82846101cb565b60006100bb828461020a565b6000806040838503121561012957600080fd5b50508035926020909101359150565b634e487b7160e01b600052601160045260246000fd5b60008261016b57634e487b7160e01b600052601260045260246000fd5b600160ff1b82146000198414161561018557610185610138565b500590565b600080821280156001600160ff1b03849003851316156101ac576101ac610138565b600160ff1b83900384128116156101c5576101c5610138565b50500190565b60008083128015600160ff1b8501841216156101e9576101e9610138565b6001600160ff1b038401831381161561020457610204610138565b50500390565b60006001600160ff1b038184138284138082168684048611161561023057610230610138565b600160ff1b600087128281168783058912161561024f5761024f610138565b6000871292508782058712848416161561026b5761026b610138565b8785058712818416161561028157610281610138565b50505092909302939250505056fea26469706673582212204340992f11acff1dfbe932fbf92608f9f01095248494519a84f4158799bf6b4664736f6c63430008090033";

    public static final String FUNC_ADD = "add";

    public static final String FUNC_DIV = "div";

    public static final String FUNC_MUL = "mul";

    public static final String FUNC_SUB = "sub";

    @Deprecated
    protected SignedSafeMathMock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected SignedSafeMathMock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected SignedSafeMathMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected SignedSafeMathMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<BigInteger> add(BigInteger a, BigInteger b) {
        final Function function = new Function(FUNC_ADD, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(a), 
                new org.web3j.abi.datatypes.generated.Int256(b)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> div(BigInteger a, BigInteger b) {
        final Function function = new Function(FUNC_DIV, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(a), 
                new org.web3j.abi.datatypes.generated.Int256(b)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> mul(BigInteger a, BigInteger b) {
        final Function function = new Function(FUNC_MUL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(a), 
                new org.web3j.abi.datatypes.generated.Int256(b)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> sub(BigInteger a, BigInteger b) {
        final Function function = new Function(FUNC_SUB, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(a), 
                new org.web3j.abi.datatypes.generated.Int256(b)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static SignedSafeMathMock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new SignedSafeMathMock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static SignedSafeMathMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new SignedSafeMathMock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static SignedSafeMathMock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new SignedSafeMathMock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static SignedSafeMathMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new SignedSafeMathMock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<SignedSafeMathMock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(SignedSafeMathMock.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<SignedSafeMathMock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SignedSafeMathMock.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<SignedSafeMathMock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(SignedSafeMathMock.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<SignedSafeMathMock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SignedSafeMathMock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
