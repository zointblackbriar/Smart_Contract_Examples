package org.web3j.model;

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
 * <p>Generated with web3j version 4.8.7.
 */
@SuppressWarnings("rawtypes")
public class AddressBook extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b5061065b806100206000396000f3fe608060405234801561001057600080fd5b506004361061004c5760003560e01c80634ba79dfe1461005157806399900d1114610079578063a39fac1214610114578063d033c4561461016c575b600080fd5b6100776004803603602081101561006757600080fd5b50356001600160a01b0316610222565b005b61009f6004803603602081101561008f57600080fd5b50356001600160a01b03166103c7565b6040805160208082528351818301528351919283929083019185019080838360005b838110156100d95781810151838201526020016100c1565b50505050905090810190601f1680156101065780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b61011c610479565b60408051602080825283518183015283519192839290830191858101910280838360005b83811015610158578181015183820152602001610140565b505050509050019250505060405180910390f35b6100776004803603604081101561018257600080fd5b6001600160a01b0382351691908101906040810160208201356401000000008111156101ad57600080fd5b8201836020820111156101bf57600080fd5b803590602001918460018302840111640100000000831117156101e157600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295506104e2945050505050565b33600090815260208190526040812054905b818110156103c25733600090815260208190526040902080548290811061025757fe5b6000918252602090912001546001600160a01b03848116911614156103ba5733600090815260208190526040902054600110801561029757506001820381105b1561031c57336000908152602081905260409020805460001984019081106102bb57fe5b600091825260208083209091015433835290829052604090912080546001600160a01b0390921691839081106102ed57fe5b9060005260206000200160006101000a8154816001600160a01b0302191690836001600160a01b031602179055505b3360009081526020819052604090208054600019840190811061033b57fe5b6000918252602080832090910180546001600160a01b03191690553382528190526040902080548061036957fe5b60008281526020808220830160001990810180546001600160a01b03191690559092019092553382526001815260408083206001600160a01b038716845290915281206103b59161053d565b6103c2565b600101610234565b505050565b3360009081526001602081815260408084206001600160a01b038616855282529283902080548451600294821615610100026000190190911693909304601f8101839004830284018301909452838352606093909183018282801561046d5780601f106104425761010080835404028352916020019161046d565b820191906000526020600020905b81548152906001019060200180831161045057829003601f168201915b50505050509050919050565b33600090815260208181526040918290208054835181840281018401909452808452606093928301828280156104d857602002820191906000526020600020905b81546001600160a01b031681526001909101906020018083116104ba575b5050505050905090565b336000818152602081815260408083208054600180820183559185528385200180546001600160a01b0319166001600160a01b038916908117909155948452825280832093835292815291902082516103c292840190610584565b50805460018160011615610100020316600290046000825580601f106105635750610581565b601f0160209004906000526020600020908101906105819190610610565b50565b828054600181600116156101000203166002900490600052602060002090601f0160209004810192826105ba5760008555610600565b82601f106105d357805160ff1916838001178555610600565b82800160010185558215610600579182015b828111156106005782518255916020019190600101906105e5565b5061060c929150610610565b5090565b5b8082111561060c576000815560010161061156fea264697066735822122067ba8e1231ed4401036c7c9d751714e7b59e451f88b14696ec52d6a6f866298a64736f6c63430007060033";

    public static final String FUNC_ADDADDRESS = "addAddress";

    public static final String FUNC_GETADDRESSES = "getAddresses";

    public static final String FUNC_GETALIAS = "getAlias";

    public static final String FUNC_REMOVEADDRESS = "removeAddress";

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

    public RemoteFunctionCall<TransactionReceipt> addAddress(String addr, String aliasSample) {
        final Function function = new Function(
                FUNC_ADDADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, addr), 
                new org.web3j.abi.datatypes.Utf8String(aliasSample)), 
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

    public RemoteFunctionCall<TransactionReceipt> removeAddress(String addr) {
        final Function function = new Function(
                FUNC_REMOVEADDRESS, 
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
