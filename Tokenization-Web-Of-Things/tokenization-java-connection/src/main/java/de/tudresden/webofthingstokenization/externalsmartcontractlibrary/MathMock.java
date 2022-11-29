package de.tudresden.webofthingstokenization.externalsmartcontractlibrary;

import java.math.BigInteger;
import java.util.Arrays;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
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
public class MathMock extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b5061087a806100206000396000f3fe608060405234801561001057600080fd5b50600436106100935760003560e01c80636d5433e6116100665780636d5433e6146100f65780637ae2b5c7146101095780639cb353271461011c578063ae2affdd1461012f578063efbb69311461014257600080fd5b80630b4e545d146100985780631a134248146100bd5780632b7423ab146100d05780632bc55222146100e3575b600080fd5b6100ab6100a6366004610724565b610155565b60405190815260200160405180910390f35b6100ab6100cb366004610750565b610168565b6100ab6100de36600461078f565b61017f565b6100ab6100f1366004610724565b61018b565b6100ab61010436600461078f565b610197565b6100ab61011736600461078f565b6101a3565b6100ab61012a36600461078f565b6101af565b6100ab61013d366004610724565b6101bb565b6100ab610150366004610724565b6101c7565b600061016183836101d3565b9392505050565b600061017685858585610222565b95945050505050565b6000610161838361027d565b60006101618383610298565b600061016183836102d4565b600061016183836102ea565b600061016183836102f9565b60006101618383610330565b6000610161838361036a565b6000806101df846103a5565b905060018360028111156101f5576101f56107b1565b148015610209575083600382901b6001901b105b610214576000610217565b60015b60ff16019392505050565b600080610230868686610410565b90506001836002811115610246576102466107b1565b14801561026357506000848061025e5761025e6107c7565b868809115b15610176576102736001826107f3565b9695505050505050565b600061028c600284841861080b565b610161908484166107f3565b6000806102a4846104bf565b905060018360028111156102ba576102ba6107b1565b148015610209575083816001901b10610214576000610217565b60008183116102e35781610161565b5090919050565b60008183106102e35781610161565b60008215610327578161030d60018561082d565b610317919061080b565b6103229060016107f3565b610161565b50600092915050565b60008061033c84610553565b90506001836002811115610352576103526107b1565b14801561020957508381820210610214576000610217565b60008061037684610638565b9050600183600281111561038c5761038c6107b1565b14801561020957508381600a0a10610214576000610217565b600080608083901c156103bd5760809290921c916010015b604083901c156103d25760409290921c916008015b602083901c156103e75760209290921c916004015b601083901c156103fc5760109290921c916002015b600883901c1561040a576001015b92915050565b60008080600019858709858702925082811083820303915050806000141561044b57838281610441576104416107c7565b0492505050610161565b80841161045757600080fd5b600084868809600260036001881981018916988990049182028318808302840302808302840302808302840302808302840302808302840302918202909203026000889003889004909101858311909403939093029303949094049190911702949350505050565b600080608083901c156104d457608092831c92015b604083901c156104e657604092831c92015b602083901c156104f857602092831c92015b601083901c1561050a57601092831c92015b600883901c1561051c57600892831c92015b600483901c1561052e57600492831c92015b600283901c1561054057600292831c92015b600183901c1561040a5760010192915050565b60008161056257506000919050565b6000600161056f846104bf565b901c6001901b90506001818481610588576105886107c7565b048201901c905060018184816105a0576105a06107c7565b048201901c905060018184816105b8576105b86107c7565b048201901c905060018184816105d0576105d06107c7565b048201901c905060018184816105e8576105e86107c7565b048201901c90506001818481610600576106006107c7565b048201901c90506001818481610618576106186107c7565b048201901c905061016181828581610632576106326107c7565b046102ea565b60008072184f03e93ff9f4daa797ed6e38ed64bf6a1f0160401b83106106775772184f03e93ff9f4daa797ed6e38ed64bf6a1f0160401b830492506040015b6d04ee2d6d415b85acef810000000083106106a3576d04ee2d6d415b85acef8100000000830492506020015b662386f26fc1000083106106c157662386f26fc10000830492506010015b6305f5e10083106106d9576305f5e100830492506008015b61271083106106ed57612710830492506004015b606483106106ff576064830492506002015b600a831061040a5760010192915050565b80356003811061071f57600080fd5b919050565b6000806040838503121561073757600080fd5b8235915061074760208401610710565b90509250929050565b6000806000806080858703121561076657600080fd5b84359350602085013592506040850135915061078460608601610710565b905092959194509250565b600080604083850312156107a257600080fd5b50508035926020909101359150565b634e487b7160e01b600052602160045260246000fd5b634e487b7160e01b600052601260045260246000fd5b634e487b7160e01b600052601160045260246000fd5b60008219821115610806576108066107dd565b500190565b60008261082857634e487b7160e01b600052601260045260246000fd5b500490565b60008282101561083f5761083f6107dd565b50039056fea264697066735822122002c54107fe0aa63624956b7b5bcee309e6046ecc3937d343dbe8a12e5d12bf2264736f6c63430008090033";

    public static final String FUNC_AVERAGE = "average";

    public static final String FUNC_CEILDIV = "ceilDiv";

    public static final String FUNC_LOG10 = "log10";

    public static final String FUNC_LOG2 = "log2";

    public static final String FUNC_LOG256 = "log256";

    public static final String FUNC_MAX = "max";

    public static final String FUNC_MIN = "min";

    public static final String FUNC_MULDIV = "mulDiv";

    public static final String FUNC_SQRT = "sqrt";

    @Deprecated
    protected MathMock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected MathMock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected MathMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected MathMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<BigInteger> average(BigInteger a, BigInteger b) {
        final Function function = new Function(FUNC_AVERAGE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a), 
                new org.web3j.abi.datatypes.generated.Uint256(b)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> ceilDiv(BigInteger a, BigInteger b) {
        final Function function = new Function(FUNC_CEILDIV, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a), 
                new org.web3j.abi.datatypes.generated.Uint256(b)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> log10(BigInteger a, BigInteger direction) {
        final Function function = new Function(FUNC_LOG10, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a), 
                new org.web3j.abi.datatypes.generated.Uint8(direction)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> log2(BigInteger a, BigInteger direction) {
        final Function function = new Function(FUNC_LOG2, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a), 
                new org.web3j.abi.datatypes.generated.Uint8(direction)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> log256(BigInteger a, BigInteger direction) {
        final Function function = new Function(FUNC_LOG256, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a), 
                new org.web3j.abi.datatypes.generated.Uint8(direction)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> max(BigInteger a, BigInteger b) {
        final Function function = new Function(FUNC_MAX, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a), 
                new org.web3j.abi.datatypes.generated.Uint256(b)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> min(BigInteger a, BigInteger b) {
        final Function function = new Function(FUNC_MIN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a), 
                new org.web3j.abi.datatypes.generated.Uint256(b)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> mulDiv(BigInteger a, BigInteger b, BigInteger denominator, BigInteger direction) {
        final Function function = new Function(FUNC_MULDIV, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a), 
                new org.web3j.abi.datatypes.generated.Uint256(b), 
                new org.web3j.abi.datatypes.generated.Uint256(denominator), 
                new org.web3j.abi.datatypes.generated.Uint8(direction)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> sqrt(BigInteger a, BigInteger direction) {
        final Function function = new Function(FUNC_SQRT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a), 
                new org.web3j.abi.datatypes.generated.Uint8(direction)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static MathMock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new MathMock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static MathMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new MathMock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static MathMock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new MathMock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static MathMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new MathMock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<MathMock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(MathMock.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<MathMock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(MathMock.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<MathMock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(MathMock.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<MathMock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(MathMock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
