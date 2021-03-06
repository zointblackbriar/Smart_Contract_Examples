package com.tudresden.smartcontract.javaconnectioncontracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicArray;
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
 * <p>Generated with web3j version 4.5.16.
 */
@SuppressWarnings("rawtypes")
public class AddressBook extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b5061064d806100206000396000f3fe608060405234801561001057600080fd5b506004361061004c5760003560e01c806376ac02051461005157806399900d1114610109578063a39fac12146101a4578063d23f1836146101fc575b600080fd5b6101076004803603604081101561006757600080fd5b6001600160a01b03823516919081019060408101602082013564010000000081111561009257600080fd5b8201836020820111156100a457600080fd5b803590602001918460018302840111640100000000831117156100c657600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550610222945050505050565b005b61012f6004803603602081101561011f57600080fd5b50356001600160a01b0316610282565b6040805160208082528351818301528351919283929083019185019080838360005b83811015610169578181015183820152602001610151565b50505050905090810190601f1680156101965780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b6101ac610334565b60408051602080825283518183015283519192839290830191858101910280838360005b838110156101e85781810151838201526020016101d0565b505050509050019250505060405180910390f35b6101076004803603602081101561021257600080fd5b50356001600160a01b031661039d565b336000818152602081815260408083208054600180820183559185528385200180546001600160a01b0319166001600160a01b0389169081179091559484528252808320938352928152919020825161027d9284019061053d565b505050565b3360009081526001602081815260408084206001600160a01b038616855282529283902080548451600294821615610100026000190190911693909304601f810183900483028401830190945283835260609390918301828280156103285780601f106102fd57610100808354040283529160200191610328565b820191906000526020600020905b81548152906001019060200180831161030b57829003601f168201915b50505050509050919050565b336000908152602081815260409182902080548351818402810184019094528084526060939283018282801561039357602002820191906000526020600020905b81546001600160a01b03168152600190910190602001808311610375575b5050505050905090565b33600090815260208190526040812054905b8181101561027d573360009081526020819052604090208054829081106103d257fe5b6000918252602090912001546001600160a01b03848116911614156105355733600090815260208190526040902054600110801561041257506001820381105b15610497573360009081526020819052604090208054600019840190811061043657fe5b600091825260208083209091015433835290829052604090912080546001600160a01b03909216918390811061046857fe5b9060005260206000200160006101000a8154816001600160a01b0302191690836001600160a01b031602179055505b336000908152602081905260409020805460001984019081106104b657fe5b6000918252602080832090910180546001600160a01b0319169055338252819052604090208054806104e457fe5b60008281526020808220830160001990810180546001600160a01b03191690559092019092553382526001815260408083206001600160a01b03871684529091528120610530916105bb565b61027d565b6001016103af565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061057e57805160ff19168380011785556105ab565b828001600101855582156105ab579182015b828111156105ab578251825591602001919060010190610590565b506105b7929150610602565b5090565b50805460018160011615610100020316600290046000825580601f106105e157506105ff565b601f0160209004906000526020600020908101906105ff9190610602565b50565b5b808211156105b7576000815560010161060356fea2646970667358221220972cb3799d01821806ac59669a94544174e150bbc802681e7b4e24c32b63ddb764736f6c63430007000033";

    public static final String FUNC_ADDADDRESSES = "addAddresses";

    public static final String FUNC_GETADDRESSES = "getAddresses";

    public static final String FUNC_GETALIAS = "getAlias";

    public static final String FUNC_REMOVEADDRESSES = "removeAddresses";

    @Deprecated
    protected AddressBook(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected AddressBook(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected AddressBook(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected AddressBook(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> addAddresses(String addr, String aliasStr) {
        final Function function = new Function(
                FUNC_ADDADDRESSES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, addr), 
                new org.web3j.abi.datatypes.Utf8String(aliasStr)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<List> getAddresses() {
        final Function function = new Function(FUNC_GETADDRESSES, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
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

    public RemoteFunctionCall<String> getAlias(String addr) {
        final Function function = new Function(FUNC_GETALIAS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, addr)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> removeAddresses(String addr) {
        final Function function = new Function(
                FUNC_REMOVEADDRESSES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, addr)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static AddressBook load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new AddressBook(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static AddressBook load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new AddressBook(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static AddressBook load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new AddressBook(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static AddressBook load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new AddressBook(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<AddressBook> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(AddressBook.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<AddressBook> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(AddressBook.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<AddressBook> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(AddressBook.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<AddressBook> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(AddressBook.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
