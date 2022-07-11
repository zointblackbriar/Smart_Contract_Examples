package de.tudresden.contractsample.connection;

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
 * <p>Generated with web3j version 4.8.9.
 */
@SuppressWarnings("rawtypes")
public class AddressBook extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b5061077e806100206000396000f3fe608060405234801561001057600080fd5b506004361061004c5760003560e01c80634ba79dfe1461005157806399900d1114610066578063a39fac121461008f578063d033c456146100a4575b600080fd5b61006461005f3660046104fd565b6100b7565b005b6100796100743660046104fd565b610290565b604051610086919061051f565b60405180910390f35b610097610347565b6040516100869190610574565b6100646100b23660046105d7565b6103b0565b33600090815260208190526040812054905b81811015610279573360009081526020819052604090208054829081106100f2576100f2610699565b6000918252602090912001546001600160a01b038481169116141561027e5733600090815260208190526040902054600110801561013957506101366001836106c5565b81105b156101cf573360009081526020819052604090206101586001846106c5565b8154811061016857610168610699565b600091825260208083209091015433835290829052604090912080546001600160a01b0390921691839081106101a0576101a0610699565b9060005260206000200160006101000a8154816001600160a01b0302191690836001600160a01b031602179055505b3360009081526020819052604090206101e96001846106c5565b815481106101f9576101f9610699565b6000918252602080832090910180546001600160a01b03191690553382528190526040902080548061022d5761022d6106dc565b60008281526020808220830160001990810180546001600160a01b03191690559092019092553382526001815260408083206001600160a01b038716845290915281206102799161040b565b505050565b80610288816106f2565b9150506100c9565b3360009081526001602090815260408083206001600160a01b038516845290915290208054606091906102c29061070d565b80601f01602080910402602001604051908101604052809291908181526020018280546102ee9061070d565b801561033b5780601f106103105761010080835404028352916020019161033b565b820191906000526020600020905b81548152906001019060200180831161031e57829003601f168201915b50505050509050919050565b33600090815260208181526040918290208054835181840281018401909452808452606093928301828280156103a657602002820191906000526020600020905b81546001600160a01b03168152600190910190602001808311610388575b5050505050905090565b336000818152602081815260408083208054600180820183559185528385200180546001600160a01b0319166001600160a01b0389169081179091559484528252808320938352928152919020825161027992840190610448565b5080546104179061070d565b6000825580601f10610427575050565b601f01602090049060005260206000209081019061044591906104cc565b50565b8280546104549061070d565b90600052602060002090601f01602090048101928261047657600085556104bc565b82601f1061048f57805160ff19168380011785556104bc565b828001600101855582156104bc579182015b828111156104bc5782518255916020019190600101906104a1565b506104c89291506104cc565b5090565b5b808211156104c857600081556001016104cd565b80356001600160a01b03811681146104f857600080fd5b919050565b60006020828403121561050f57600080fd5b610518826104e1565b9392505050565b600060208083528351808285015260005b8181101561054c57858101830151858201604001528201610530565b8181111561055e576000604083870101525b50601f01601f1916929092016040019392505050565b6020808252825182820181905260009190848201906040850190845b818110156105b55783516001600160a01b031683529284019291840191600101610590565b50909695505050505050565b634e487b7160e01b600052604160045260246000fd5b600080604083850312156105ea57600080fd5b6105f3836104e1565b9150602083013567ffffffffffffffff8082111561061057600080fd5b818501915085601f83011261062457600080fd5b813581811115610636576106366105c1565b604051601f8201601f19908116603f0116810190838211818310171561065e5761065e6105c1565b8160405282815288602084870101111561067757600080fd5b8260208601602083013760006020848301015280955050505050509250929050565b634e487b7160e01b600052603260045260246000fd5b634e487b7160e01b600052601160045260246000fd5b6000828210156106d7576106d76106af565b500390565b634e487b7160e01b600052603160045260246000fd5b6000600019821415610706576107066106af565b5060010190565b600181811c9082168061072157607f821691505b6020821081141561074257634e487b7160e01b600052602260045260246000fd5b5091905056fea2646970667358221220a7b575f8eac3ff469f92d7e1c9e0fb09ef034b63d8707413c9b7ed6e2c07c2be64736f6c63430008090033";

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
