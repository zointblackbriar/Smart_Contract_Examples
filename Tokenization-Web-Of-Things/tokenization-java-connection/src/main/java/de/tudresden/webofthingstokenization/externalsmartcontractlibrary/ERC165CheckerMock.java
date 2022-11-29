package de.tudresden.webofthingstokenization.externalsmartcontractlibrary;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicArray;
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
public class ERC165CheckerMock extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50610577806100206000396000f3fe608060405234801561001057600080fd5b50600436106100575760003560e01c80634b9dd9041461005c57806355a899751461008457806377e6b4cc14610097578063c398a925146100b7578063d9057007146100ca575b600080fd5b61006f61006a366004610396565b6100dd565b60405190151581526020015b60405180910390f35b61006f61009236600461046e565b6100fb565b6100aa6100a5366004610396565b610110565b60405161007b91906104a1565b61006f6100c53660046104e7565b610125565b61006f6100d836600461046e565b610139565b60006100f26001600160a01b0384168361014e565b90505b92915050565b60006100f26001600160a01b038416836101be565b60606100f26001600160a01b03841683610247565b60006100f5826001600160a01b03166102fd565b60006100f26001600160a01b03841683610330565b6000610159836102fd565b610165575060006100f5565b60005b82518110156101b4576101948484838151811061018757610187610502565b60200260200101516101be565b6101a25760009150506100f5565b806101ac81610518565b915050610168565b5060019392505050565b604080516001600160e01b03198316602480830191909152825180830390910181526044909101909152602080820180516001600160e01b03166301ffc9a760e01b178152825160009392849283928392918391908a617530fa92503d91506000519050828015610230575060208210155b801561023c5750600081115b979650505050505050565b60606000825167ffffffffffffffff81111561026557610265610368565b60405190808252806020026020018201604052801561028e578160200160208202803683370190505b50905061029a846102fd565b156100f25760005b83518110156102f5576102c18585838151811061018757610187610502565b8282815181106102d3576102d3610502565b91151560209283029190910190910152806102ed81610518565b9150506102a2565b509392505050565b6000610310826301ffc9a760e01b6101be565b80156100f55750610329826001600160e01b03196101be565b1592915050565b600061033b836102fd565b80156100f257506100f283836101be565b80356001600160a01b038116811461036357600080fd5b919050565b634e487b7160e01b600052604160045260246000fd5b80356001600160e01b03198116811461036357600080fd5b600080604083850312156103a957600080fd5b6103b28361034c565b915060208084013567ffffffffffffffff808211156103d057600080fd5b818601915086601f8301126103e457600080fd5b8135818111156103f6576103f6610368565b8060051b604051601f19603f8301168101818110858211171561041b5761041b610368565b60405291825284820192508381018501918983111561043957600080fd5b938501935b8285101561045e5761044f8561037e565b8452938501939285019261043e565b8096505050505050509250929050565b6000806040838503121561048157600080fd5b61048a8361034c565b91506104986020840161037e565b90509250929050565b6020808252825182820181905260009190848201906040850190845b818110156104db5783511515835292840192918401916001016104bd565b50909695505050505050565b6000602082840312156104f957600080fd5b6100f28261034c565b634e487b7160e01b600052603260045260246000fd5b600060001982141561053a57634e487b7160e01b600052601160045260246000fd5b506001019056fea26469706673582212204f4bf94da18b2d9025a216e22d6dbaa90603cf0b46252bba0ee4bc4badf75b5164736f6c63430008090033";

    public static final String FUNC_GETSUPPORTEDINTERFACES = "getSupportedInterfaces";

    public static final String FUNC_SUPPORTSALLINTERFACES = "supportsAllInterfaces";

    public static final String FUNC_SUPPORTSERC165 = "supportsERC165";

    public static final String FUNC_SUPPORTSERC165INTERFACEUNCHECKED = "supportsERC165InterfaceUnchecked";

    public static final String FUNC_SUPPORTSINTERFACE = "supportsInterface";

    @Deprecated
    protected ERC165CheckerMock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ERC165CheckerMock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ERC165CheckerMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ERC165CheckerMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<List> getSupportedInterfaces(String account, List<byte[]> interfaceIds) {
        final Function function = new Function(FUNC_GETSUPPORTEDINTERFACES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, account), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes4>(
                        org.web3j.abi.datatypes.generated.Bytes4.class,
                        org.web3j.abi.Utils.typeMap(interfaceIds, org.web3j.abi.datatypes.generated.Bytes4.class))), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Bool>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteFunctionCall<Boolean> supportsAllInterfaces(String account, List<byte[]> interfaceIds) {
        final Function function = new Function(FUNC_SUPPORTSALLINTERFACES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, account), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes4>(
                        org.web3j.abi.datatypes.generated.Bytes4.class,
                        org.web3j.abi.Utils.typeMap(interfaceIds, org.web3j.abi.datatypes.generated.Bytes4.class))), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<Boolean> supportsERC165(String account) {
        final Function function = new Function(FUNC_SUPPORTSERC165, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, account)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<Boolean> supportsERC165InterfaceUnchecked(String account, byte[] interfaceId) {
        final Function function = new Function(FUNC_SUPPORTSERC165INTERFACEUNCHECKED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, account), 
                new org.web3j.abi.datatypes.generated.Bytes4(interfaceId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<Boolean> supportsInterface(String account, byte[] interfaceId) {
        final Function function = new Function(FUNC_SUPPORTSINTERFACE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, account), 
                new org.web3j.abi.datatypes.generated.Bytes4(interfaceId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    @Deprecated
    public static ERC165CheckerMock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ERC165CheckerMock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ERC165CheckerMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ERC165CheckerMock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ERC165CheckerMock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ERC165CheckerMock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ERC165CheckerMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ERC165CheckerMock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ERC165CheckerMock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ERC165CheckerMock.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ERC165CheckerMock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ERC165CheckerMock.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<ERC165CheckerMock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(ERC165CheckerMock.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<ERC165CheckerMock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(ERC165CheckerMock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
