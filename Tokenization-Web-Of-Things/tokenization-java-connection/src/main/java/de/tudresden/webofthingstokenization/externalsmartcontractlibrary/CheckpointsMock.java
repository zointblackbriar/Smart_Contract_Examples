package de.tudresden.webofthingstokenization.externalsmartcontractlibrary;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;
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
public class CheckpointsMock extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b5061097d806100206000396000f3fe608060405234801561001057600080fd5b50600436106100625760003560e01c80630a289305146100675780631f7b6d321461008d57806352bfe78914610095578063907c0f921461009d578063959ac484146100c2578063ee1bc751146100ea575b600080fd5b61007a6100753660046108b1565b6100fd565b6040519081526020015b60405180910390f35b60005461007a565b61007a61010f565b6100a5610129565b604080519315158452602084019290925290820152606001610084565b6100d56100d03660046108b1565b610155565b60408051928352602083019190915201610084565b61007a6100f83660046108b1565b61016b565b60006101098183610177565b92915050565b600061011b6000610297565b6001600160e01b0316905090565b600080600061013860006102d1565b919563ffffffff90911694506001600160e01b0390911692509050565b6000806101628184610347565b91509150915091565b6000610109818361037b565b60004382106101cd5760405162461bcd60e51b815260206004820181905260248201527f436865636b706f696e74733a20626c6f636b206e6f7420796574206d696e656460448201526064015b60405180910390fd5b60006101d88361042d565b845490915060008160058111156102365760006101f484610496565b6101fe90856108e0565b60008981526020902090915081015463ffffffff908116908616101561022657809150610234565b6102318160016108f7565b92505b505b60006102448886858561057b565b9050801561027f576102698861025b6001846108e0565b600091825260209091200190565b54600160201b90046001600160e01b0316610282565b60005b6001600160e01b031698975050505050505050565b805460009080156102c7576102b18361025b6001846108e0565b54600160201b90046001600160e01b03166102ca565b60005b9392505050565b805460009081908190806102f057600080600093509350935050610340565b60006103018661025b6001856108e0565b60408051808201909152905463ffffffff8116808352600160201b9091046001600160e01b031660209092018290526001965094509250610340915050565b9193909250565b600080610365846103574361042d565b610360866105d9565b610642565b6001600160e01b03918216969116945092505050565b60004382106103cc5760405162461bcd60e51b815260206004820181905260248201527f436865636b706f696e74733a20626c6f636b206e6f7420796574206d696e656460448201526064016101c4565b60006103d78361042d565b845490915060006103ea8684838561057b565b90508015610417576104018661025b6001846108e0565b54600160201b90046001600160e01b031661041a565b60005b6001600160e01b03169695505050505050565b600063ffffffff8211156104925760405162461bcd60e51b815260206004820152602660248201527f53616665436173743a2076616c756520646f65736e27742066697420696e203360448201526532206269747360d01b60648201526084016101c4565b5090565b6000816104a557506000919050565b600060016104b2846107ec565b901c6001901b905060018184816104cb576104cb61090f565b048201901c905060018184816104e3576104e361090f565b048201901c905060018184816104fb576104fb61090f565b048201901c905060018184816105135761051361090f565b048201901c9050600181848161052b5761052b61090f565b048201901c905060018184816105435761054361090f565b048201901c9050600181848161055b5761055b61090f565b048201901c90506102ca818285816105755761057561090f565b04610880565b60005b818310156105d15760006105928484610896565b60008781526020902090915063ffffffff86169082015463ffffffff1611156105bd578092506105cb565b6105c88160016108f7565b93505b5061057e565b509392505050565b60006001600160e01b038211156104925760405162461bcd60e51b815260206004820152602760248201527f53616665436173743a2076616c756520646f65736e27742066697420696e20326044820152663234206269747360c81b60648201526084016101c4565b82546000908190801561078f5760006106608761025b6001856108e0565b60408051808201909152905463ffffffff808216808452600160201b9092046001600160e01b0316602084015291925090871610156106e15760405162461bcd60e51b815260206004820152601760248201527f436865636b706f696e743a20696e76616c6964206b657900000000000000000060448201526064016101c4565b8563ffffffff16816000015163ffffffff16141561073057846107098861025b6001866108e0565b80546001600160e01b0392909216600160201b0263ffffffff90921691909117905561077f565b6040805180820190915263ffffffff80881682526001600160e01b0380881660208085019182528b54600181018d5560008d81529190912094519151909216600160201b029216919091179101555b6020015192508391506107e49050565b50506040805180820190915263ffffffff80851682526001600160e01b0380851660208085019182528854600181018a5560008a815291822095519251909316600160201b0291909316179201919091559050815b935093915050565b600080608083901c1561080157608092831c92015b604083901c1561081357604092831c92015b602083901c1561082557602092831c92015b601083901c1561083757601092831c92015b600883901c1561084957600892831c92015b600483901c1561085b57600492831c92015b600283901c1561086d57600292831c92015b600183901c156101095760010192915050565b600081831061088f57816102ca565b5090919050565b60006108a56002848418610925565b6102ca908484166108f7565b6000602082840312156108c357600080fd5b5035919050565b634e487b7160e01b600052601160045260246000fd5b6000828210156108f2576108f26108ca565b500390565b6000821982111561090a5761090a6108ca565b500190565b634e487b7160e01b600052601260045260246000fd5b60008261094257634e487b7160e01b600052601260045260246000fd5b50049056fea264697066735822122008b852c6ce81752e0295f49e673aded270b4338e447d2d648a1527518380b61064736f6c63430008090033";

    public static final String FUNC_GETATBLOCK = "getAtBlock";

    public static final String FUNC_GETATPROBABLYRECENTBLOCK = "getAtProbablyRecentBlock";

    public static final String FUNC_LATEST = "latest";

    public static final String FUNC_LATESTCHECKPOINT = "latestCheckpoint";

    public static final String FUNC_LENGTH = "length";

    public static final String FUNC_PUSH = "push";

    @Deprecated
    protected CheckpointsMock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected CheckpointsMock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected CheckpointsMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected CheckpointsMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<BigInteger> getAtBlock(BigInteger blockNumber) {
        final Function function = new Function(FUNC_GETATBLOCK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(blockNumber)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getAtProbablyRecentBlock(BigInteger blockNumber) {
        final Function function = new Function(FUNC_GETATPROBABLYRECENTBLOCK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(blockNumber)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> latest() {
        final Function function = new Function(FUNC_LATEST, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Tuple3<Boolean, BigInteger, BigInteger>> latestCheckpoint() {
        final Function function = new Function(FUNC_LATESTCHECKPOINT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple3<Boolean, BigInteger, BigInteger>>(function,
                new Callable<Tuple3<Boolean, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple3<Boolean, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<Boolean, BigInteger, BigInteger>(
                                (Boolean) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue());
                    }
                });
    }

    public RemoteFunctionCall<BigInteger> length() {
        final Function function = new Function(FUNC_LENGTH, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> push(BigInteger value) {
        final Function function = new Function(
                FUNC_PUSH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static CheckpointsMock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new CheckpointsMock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static CheckpointsMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new CheckpointsMock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static CheckpointsMock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new CheckpointsMock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static CheckpointsMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new CheckpointsMock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<CheckpointsMock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(CheckpointsMock.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<CheckpointsMock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(CheckpointsMock.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<CheckpointsMock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(CheckpointsMock.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<CheckpointsMock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(CheckpointsMock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
