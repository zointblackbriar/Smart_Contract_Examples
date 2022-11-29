package de.tudresden.webofthingstokenization.externalsmartcontractlibrary;

import java.math.BigInteger;
import java.util.Arrays;
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
import org.web3j.tuples.generated.Tuple2;
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
public class SafeMathMock extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50610814806100206000396000f3fe608060405234801561001057600080fd5b50600436106101165760003560e01c80639f5cec89116100a2578063dcc721d211610071578063dcc721d21461021b578063fb1191981461022e578063fb24c86014610241578063fb999ded14610249578063fc0ce5031461025157600080fd5b80639f5cec89146101da578063a155bd62146101ed578063a29962b114610200578063c460ae041461021357600080fd5b80636f91e802116100e95780636f91e80214610191578063736ecb18146101995780637e86d25c146101ac578063869f602f146101b4578063884557bf146101c757600080fd5b80633449b5fb1461011b57806338dc0867146101415780636281efa41461016b5780636c7ac6371461017e575b600080fd5b61012e6101293660046105e6565b610264565b6040519081526020015b60405180910390f35b61015461014f3660046106aa565b610279565b604080519215158352602083019190915201610138565b6101546101793660046106aa565b610292565b61012e61018c3660046106aa565b61029f565b61012e6102b2565b6101546101a73660046106aa565b6102e7565b61012e6102f4565b61012e6101c23660046106aa565b610320565b6101546101d53660046106aa565b61032c565b61012e6101e83660046105e6565b610339565b61012e6101fb3660046105e6565b610346565b61015461020e3660046106aa565b610353565b61012e610360565b61012e6102293660046106aa565b61038c565b61012e61023c3660046106aa565b610398565b61012e6103a4565b61012e6103d0565b61012e61025f3660046106aa565b6103fc565b6000610271848484610408565b949350505050565b600080610286848461044b565b915091505b9250929050565b600080610286848461047b565b60006102ab83836104c1565b9392505050565b604051602060005b818110156102de576102cd6001806104cd565b506102d7816106e2565b90506102ba565b50506040510390565b60008061028684846104d9565b604051602060005b818110156102de5761030f600180610509565b50610319816106e2565b90506102fc565b60006102ab83836104cd565b6000806102868484610515565b6000610271848484610530565b600061027184848461055c565b6000806102868484610596565b604051602060005b818110156102de5761037b6001806105b8565b50610385816106e2565b9050610368565b60006102ab83836105c4565b60006102ab8383610509565b604051602060005b818110156102de576103bf6001806105c4565b506103c9816106e2565b90506103ac565b604051602060005b818110156102de576103eb6001806104c1565b506103f5816106e2565b90506103d8565b60006102ab83836105b8565b600081836104325760405162461bcd60e51b815260040161042991906106fd565b60405180910390fd5b5082848161044257610442610752565b04949350505050565b6000808261045e5750600090508061028b565b600183858161046f5761046f610752565b06915091509250929050565b6000808361048f575060019050600061028b565b838302838582816104a2576104a2610752565b04146104b557600080925092505061028b565b60019590945092505050565b60006102ab8284610768565b60006102ab828461077f565b600080826104ec5750600090508061028b565b60018385816104fd576104fd610752565b04915091509250929050565b60006102ab8284610793565b600080838301848110156104b557600080925092505061028b565b600081848411156105545760405162461bcd60e51b815260040161042991906106fd565b505050900390565b6000818361057d5760405162461bcd60e51b815260040161042991906106fd565b5082848161058d5761058d610752565b06949350505050565b600080838311156105ac5750600090508061028b565b50600193919092039150565b60006102ab82846107b2565b60006102ab82846107c6565b634e487b7160e01b600052604160045260246000fd5b6000806000606084860312156105fb57600080fd5b8335925060208401359150604084013567ffffffffffffffff8082111561062157600080fd5b818601915086601f83011261063557600080fd5b813581811115610647576106476105d0565b604051601f8201601f19908116603f0116810190838211818310171561066f5761066f6105d0565b8160405282815289602084870101111561068857600080fd5b8260208601602083013760006020848301015280955050505050509250925092565b600080604083850312156106bd57600080fd5b50508035926020909101359150565b634e487b7160e01b600052601160045260246000fd5b60006000198214156106f6576106f66106cc565b5060010190565b600060208083528351808285015260005b8181101561072a5785810183015185820160400152820161070e565b8181111561073c576000604083870101525b50601f01601f1916929092016040019392505050565b634e487b7160e01b600052601260045260246000fd5b60008282101561077a5761077a6106cc565b500390565b60008261078e5761078e610752565b500690565b60008160001904831182151516156107ad576107ad6106cc565b500290565b6000826107c1576107c1610752565b500490565b600082198211156107d9576107d96106cc565b50019056fea2646970667358221220e109573824e9a419e556161e3a283879a4dc813ed1154464c014d6246e41eca064736f6c63430008090033";

    public static final String FUNC_ADDMEMORYCHECK = "addMemoryCheck";

    public static final String FUNC_DIVMEMORYCHECK = "divMemoryCheck";

    public static final String FUNC_DIVWITHMESSAGE = "divWithMessage";

    public static final String FUNC_DOADD = "doAdd";

    public static final String FUNC_DODIV = "doDiv";

    public static final String FUNC_DOMOD = "doMod";

    public static final String FUNC_DOMUL = "doMul";

    public static final String FUNC_DOSUB = "doSub";

    public static final String FUNC_MODMEMORYCHECK = "modMemoryCheck";

    public static final String FUNC_MODWITHMESSAGE = "modWithMessage";

    public static final String FUNC_MULMEMORYCHECK = "mulMemoryCheck";

    public static final String FUNC_SUBMEMORYCHECK = "subMemoryCheck";

    public static final String FUNC_SUBWITHMESSAGE = "subWithMessage";

    public static final String FUNC_TRYADD = "tryAdd";

    public static final String FUNC_TRYDIV = "tryDiv";

    public static final String FUNC_TRYMOD = "tryMod";

    public static final String FUNC_TRYMUL = "tryMul";

    public static final String FUNC_TRYSUB = "trySub";

    @Deprecated
    protected SafeMathMock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected SafeMathMock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected SafeMathMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected SafeMathMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<BigInteger> addMemoryCheck() {
        final Function function = new Function(FUNC_ADDMEMORYCHECK, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> divMemoryCheck() {
        final Function function = new Function(FUNC_DIVMEMORYCHECK, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> divWithMessage(BigInteger a, BigInteger b, String errorMessage) {
        final Function function = new Function(FUNC_DIVWITHMESSAGE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a), 
                new org.web3j.abi.datatypes.generated.Uint256(b), 
                new org.web3j.abi.datatypes.Utf8String(errorMessage)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> doAdd(BigInteger a, BigInteger b) {
        final Function function = new Function(FUNC_DOADD, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a), 
                new org.web3j.abi.datatypes.generated.Uint256(b)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> doDiv(BigInteger a, BigInteger b) {
        final Function function = new Function(FUNC_DODIV, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a), 
                new org.web3j.abi.datatypes.generated.Uint256(b)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> doMod(BigInteger a, BigInteger b) {
        final Function function = new Function(FUNC_DOMOD, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a), 
                new org.web3j.abi.datatypes.generated.Uint256(b)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> doMul(BigInteger a, BigInteger b) {
        final Function function = new Function(FUNC_DOMUL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a), 
                new org.web3j.abi.datatypes.generated.Uint256(b)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> doSub(BigInteger a, BigInteger b) {
        final Function function = new Function(FUNC_DOSUB, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a), 
                new org.web3j.abi.datatypes.generated.Uint256(b)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> modMemoryCheck() {
        final Function function = new Function(FUNC_MODMEMORYCHECK, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> modWithMessage(BigInteger a, BigInteger b, String errorMessage) {
        final Function function = new Function(FUNC_MODWITHMESSAGE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a), 
                new org.web3j.abi.datatypes.generated.Uint256(b), 
                new org.web3j.abi.datatypes.Utf8String(errorMessage)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> mulMemoryCheck() {
        final Function function = new Function(FUNC_MULMEMORYCHECK, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> subMemoryCheck() {
        final Function function = new Function(FUNC_SUBMEMORYCHECK, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> subWithMessage(BigInteger a, BigInteger b, String errorMessage) {
        final Function function = new Function(FUNC_SUBWITHMESSAGE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a), 
                new org.web3j.abi.datatypes.generated.Uint256(b), 
                new org.web3j.abi.datatypes.Utf8String(errorMessage)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Tuple2<Boolean, BigInteger>> tryAdd(BigInteger a, BigInteger b) {
        final Function function = new Function(FUNC_TRYADD, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a), 
                new org.web3j.abi.datatypes.generated.Uint256(b)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple2<Boolean, BigInteger>>(function,
                new Callable<Tuple2<Boolean, BigInteger>>() {
                    @Override
                    public Tuple2<Boolean, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<Boolean, BigInteger>(
                                (Boolean) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue());
                    }
                });
    }

    public RemoteFunctionCall<Tuple2<Boolean, BigInteger>> tryDiv(BigInteger a, BigInteger b) {
        final Function function = new Function(FUNC_TRYDIV, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a), 
                new org.web3j.abi.datatypes.generated.Uint256(b)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple2<Boolean, BigInteger>>(function,
                new Callable<Tuple2<Boolean, BigInteger>>() {
                    @Override
                    public Tuple2<Boolean, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<Boolean, BigInteger>(
                                (Boolean) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue());
                    }
                });
    }

    public RemoteFunctionCall<Tuple2<Boolean, BigInteger>> tryMod(BigInteger a, BigInteger b) {
        final Function function = new Function(FUNC_TRYMOD, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a), 
                new org.web3j.abi.datatypes.generated.Uint256(b)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple2<Boolean, BigInteger>>(function,
                new Callable<Tuple2<Boolean, BigInteger>>() {
                    @Override
                    public Tuple2<Boolean, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<Boolean, BigInteger>(
                                (Boolean) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue());
                    }
                });
    }

    public RemoteFunctionCall<Tuple2<Boolean, BigInteger>> tryMul(BigInteger a, BigInteger b) {
        final Function function = new Function(FUNC_TRYMUL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a), 
                new org.web3j.abi.datatypes.generated.Uint256(b)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple2<Boolean, BigInteger>>(function,
                new Callable<Tuple2<Boolean, BigInteger>>() {
                    @Override
                    public Tuple2<Boolean, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<Boolean, BigInteger>(
                                (Boolean) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue());
                    }
                });
    }

    public RemoteFunctionCall<Tuple2<Boolean, BigInteger>> trySub(BigInteger a, BigInteger b) {
        final Function function = new Function(FUNC_TRYSUB, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a), 
                new org.web3j.abi.datatypes.generated.Uint256(b)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple2<Boolean, BigInteger>>(function,
                new Callable<Tuple2<Boolean, BigInteger>>() {
                    @Override
                    public Tuple2<Boolean, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<Boolean, BigInteger>(
                                (Boolean) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue());
                    }
                });
    }

    @Deprecated
    public static SafeMathMock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new SafeMathMock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static SafeMathMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new SafeMathMock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static SafeMathMock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new SafeMathMock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static SafeMathMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new SafeMathMock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<SafeMathMock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(SafeMathMock.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<SafeMathMock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SafeMathMock.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<SafeMathMock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(SafeMathMock.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<SafeMathMock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SafeMathMock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
