package de.tudresden.webofthingstokenization.externalsmartcontractlibrary;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
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
 * <p>Generated with web3j version 4.9.4.
 */
@SuppressWarnings("rawtypes")
public class MulticallTest extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b506105e9806100206000396000f3fe608060405234801561001057600080fd5b506004361061002b5760003560e01c8063b568d01614610030575b600080fd5b61004361003e3660046102a4565b610045565b005b60008367ffffffffffffffff81111561006057610060610327565b60405190808252806020026020018201604052801561009357816020015b606081526020019060019003908161007e5790505b50905060005b8481101561015a578585828181106100b3576100b361033d565b90506020020160208101906100c89190610353565b8484838181106100da576100da61033d565b6040516001600160a01b039094166024850152602002919091013560448301525060640160408051601f198184030181529190526020810180516001600160e01b031663a9059cbb60e01b179052825183908390811061013c5761013c61033d565b6020026020010181905250808061015290610377565b915050610099565b50604051631592ca1b60e31b81526000906001600160a01b0388169063ac9650d89061018a9085906004016103d0565b600060405180830381600087803b1580156101a457600080fd5b505af11580156101b8573d6000803e3d6000fd5b505050506040513d6000823e601f3d908101601f191682016040526101e0919081019061047b565b905060005b8151811015610236578181815181106102005761020061033d565b602002602001015180602001905181019061021b9190610591565b61022457600080fd5b8061022e81610377565b9150506101e5565b5050505050505050565b6001600160a01b038116811461025557600080fd5b50565b60008083601f84011261026a57600080fd5b50813567ffffffffffffffff81111561028257600080fd5b6020830191508360208260051b850101111561029d57600080fd5b9250929050565b6000806000806000606086880312156102bc57600080fd5b85356102c781610240565b9450602086013567ffffffffffffffff808211156102e457600080fd5b6102f089838a01610258565b9096509450604088013591508082111561030957600080fd5b5061031688828901610258565b969995985093965092949392505050565b634e487b7160e01b600052604160045260246000fd5b634e487b7160e01b600052603260045260246000fd5b60006020828403121561036557600080fd5b813561037081610240565b9392505050565b600060001982141561039957634e487b7160e01b600052601160045260246000fd5b5060010190565b60005b838110156103bb5781810151838201526020016103a3565b838111156103ca576000848401525b50505050565b6000602080830181845280855180835260408601915060408160051b870101925083870160005b8281101561043d57878503603f190184528151805180875261041e818989018a85016103a0565b601f01601f1916959095018601945092850192908501906001016103f7565b5092979650505050505050565b604051601f8201601f1916810167ffffffffffffffff8111828210171561047357610473610327565b604052919050565b6000602080838503121561048e57600080fd5b825167ffffffffffffffff808211156104a657600080fd5b8185019150601f86818401126104bb57600080fd5b8251828111156104cd576104cd610327565b8060051b6104dc86820161044a565b918252848101860191868101908a8411156104f657600080fd5b87870192505b83831015610583578251868111156105145760008081fd5b8701603f81018c136105265760008081fd5b8881015160408882111561053c5761053c610327565b61054d828901601f19168c0161044a565b8281528e828486010111156105625760008081fd5b610571838d83018487016103a0565b855250505091870191908701906104fc565b9a9950505050505050505050565b6000602082840312156105a357600080fd5b8151801515811461037057600080fdfea26469706673582212203130ba04103dea930029210c44b8a0125c8cc32e8f59197efc8ae2780a5e5c9964736f6c63430008090033";

    public static final String FUNC_CHECKRETURNVALUES = "checkReturnValues";

    @Deprecated
    protected MulticallTest(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected MulticallTest(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected MulticallTest(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected MulticallTest(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> checkReturnValues(String multicallToken, List<String> recipients, List<BigInteger> amounts) {
        final Function function = new Function(
                FUNC_CHECKRETURNVALUES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, multicallToken), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(recipients, org.web3j.abi.datatypes.Address.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(amounts, org.web3j.abi.datatypes.generated.Uint256.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static MulticallTest load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new MulticallTest(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static MulticallTest load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new MulticallTest(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static MulticallTest load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new MulticallTest(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static MulticallTest load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new MulticallTest(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<MulticallTest> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(MulticallTest.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<MulticallTest> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(MulticallTest.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<MulticallTest> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(MulticallTest.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<MulticallTest> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(MulticallTest.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
