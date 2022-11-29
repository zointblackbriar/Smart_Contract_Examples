package de.tudresden.webofthingstokenization.externalsmartcontractlibrary;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
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
public class ERC3156FlashBorrowerMock extends Contract {
    public static final String BINARY = "60c060405234801561001057600080fd5b5060405161079438038061079483398101604081905261002f91610053565b1515608052151560a052610086565b8051801515811461004e57600080fd5b919050565b6000806040838503121561006657600080fd5b61006f8361003e565b915061007d6020840161003e565b90509250929050565b60805160a0516106e96100ab60003960006102f20152600061023201526106e96000f3fe608060405234801561001057600080fd5b506004361061002b5760003560e01c806323e30c8b14610030575b600080fd5b61004361003e36600461052d565b610055565b60405190815260200160405180910390f35b6000336001600160a01b0387161461006c57600080fd5b6040516370a0823160e01b815230600482018190527f6ff2acfcb07917b1e80e53f0fe390b467b1151d15b38730a6e08397799c05a8b918891906001600160a01b038316906370a082319060240160206040518083038186803b1580156100d257600080fd5b505afa1580156100e6573d6000803e3d6000fd5b505050506040513d601f19601f8201168201806040525081019061010a91906105d3565b604080516001600160a01b0394851681529390921660208401529082015260600160405180910390a17f7249fd4c03cce09b30a13d77804b198e2647c0ccd59eadf4de4e7c16099badc586876001600160a01b03166318160ddd6040518163ffffffff1660e01b815260040160206040518083038186803b15801561018e57600080fd5b505afa1580156101a2573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906101c691906105d3565b604080516001600160a01b03909316835260208301919091520160405180910390a181156102305761022e8684848080601f01602080910402602001604051908101604052809392919081815260200183838082843760009201919091525061034992505050565b505b7f0000000000000000000000000000000000000000000000000000000000000000156102f0576001600160a01b03861663095ea7b38761027087896105ec565b6040516001600160e01b031960e085901b1681526001600160a01b0390921660048301526024820152604401602060405180830381600087803b1580156102b657600080fd5b505af11580156102ca573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906102ee9190610612565b505b7f000000000000000000000000000000000000000000000000000000000000000061031c57600061033e565b7f439148f0bbc682ca079e46d6e2c2f0c1e3b820f1a291b069d8882abf8cf18dd95b979650505050505050565b606061038d838360006040518060400160405280601e81526020017f416464726573733a206c6f772d6c6576656c2063616c6c206661696c65640000815250610394565b9392505050565b6060824710156103fa5760405162461bcd60e51b815260206004820152602660248201527f416464726573733a20696e73756666696369656e742062616c616e636520666f6044820152651c8818d85b1b60d21b60648201526084015b60405180910390fd5b600080866001600160a01b031685876040516104169190610664565b60006040518083038185875af1925050503d8060008114610453576040519150601f19603f3d011682016040523d82523d6000602084013e610458565b606091505b509150915061046987838387610476565b925050505b949350505050565b606083156104e25782516104db576001600160a01b0385163b6104db5760405162461bcd60e51b815260206004820152601d60248201527f416464726573733a2063616c6c20746f206e6f6e2d636f6e747261637400000060448201526064016103f1565b508161046e565b61046e83838151156104f75781518083602001fd5b8060405162461bcd60e51b81526004016103f19190610680565b80356001600160a01b038116811461052857600080fd5b919050565b60008060008060008060a0878903121561054657600080fd5b61054f87610511565b955061055d60208801610511565b94506040870135935060608701359250608087013567ffffffffffffffff8082111561058857600080fd5b818901915089601f83011261059c57600080fd5b8135818111156105ab57600080fd5b8a60208285010111156105bd57600080fd5b6020830194508093505050509295509295509295565b6000602082840312156105e557600080fd5b5051919050565b6000821982111561060d57634e487b7160e01b600052601160045260246000fd5b500190565b60006020828403121561062457600080fd5b8151801515811461038d57600080fd5b60005b8381101561064f578181015183820152602001610637565b8381111561065e576000848401525b50505050565b60008251610676818460208701610634565b9190910192915050565b602081526000825180602084015261069f816040850160208701610634565b601f01601f1916919091016040019291505056fea26469706673582212200fd73b801e9fe6f7eb7832e63b20982055216f60408b1135336b86aedd2424db64736f6c63430008090033";

    public static final String FUNC_ONFLASHLOAN = "onFlashLoan";

    public static final Event BALANCEOF_EVENT = new Event("BalanceOf", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event TOTALSUPPLY_EVENT = new Event("TotalSupply", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected ERC3156FlashBorrowerMock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ERC3156FlashBorrowerMock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ERC3156FlashBorrowerMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ERC3156FlashBorrowerMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<BalanceOfEventResponse> getBalanceOfEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(BALANCEOF_EVENT, transactionReceipt);
        ArrayList<BalanceOfEventResponse> responses = new ArrayList<BalanceOfEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            BalanceOfEventResponse typedResponse = new BalanceOfEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.token = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.account = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<BalanceOfEventResponse> balanceOfEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, BalanceOfEventResponse>() {
            @Override
            public BalanceOfEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(BALANCEOF_EVENT, log);
                BalanceOfEventResponse typedResponse = new BalanceOfEventResponse();
                typedResponse.log = log;
                typedResponse.token = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.account = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<BalanceOfEventResponse> balanceOfEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(BALANCEOF_EVENT));
        return balanceOfEventFlowable(filter);
    }

    public static List<TotalSupplyEventResponse> getTotalSupplyEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(TOTALSUPPLY_EVENT, transactionReceipt);
        ArrayList<TotalSupplyEventResponse> responses = new ArrayList<TotalSupplyEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            TotalSupplyEventResponse typedResponse = new TotalSupplyEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.token = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<TotalSupplyEventResponse> totalSupplyEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, TotalSupplyEventResponse>() {
            @Override
            public TotalSupplyEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(TOTALSUPPLY_EVENT, log);
                TotalSupplyEventResponse typedResponse = new TotalSupplyEventResponse();
                typedResponse.log = log;
                typedResponse.token = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<TotalSupplyEventResponse> totalSupplyEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TOTALSUPPLY_EVENT));
        return totalSupplyEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> onFlashLoan(String param0, String token, BigInteger amount, BigInteger fee, byte[] data) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ONFLASHLOAN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, param0), 
                new org.web3j.abi.datatypes.Address(160, token), 
                new org.web3j.abi.datatypes.generated.Uint256(amount), 
                new org.web3j.abi.datatypes.generated.Uint256(fee), 
                new org.web3j.abi.datatypes.DynamicBytes(data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static ERC3156FlashBorrowerMock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ERC3156FlashBorrowerMock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ERC3156FlashBorrowerMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ERC3156FlashBorrowerMock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ERC3156FlashBorrowerMock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ERC3156FlashBorrowerMock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ERC3156FlashBorrowerMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ERC3156FlashBorrowerMock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ERC3156FlashBorrowerMock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, Boolean enableReturn, Boolean enableApprove) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Bool(enableReturn), 
                new org.web3j.abi.datatypes.Bool(enableApprove)));
        return deployRemoteCall(ERC3156FlashBorrowerMock.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<ERC3156FlashBorrowerMock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, Boolean enableReturn, Boolean enableApprove) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Bool(enableReturn), 
                new org.web3j.abi.datatypes.Bool(enableApprove)));
        return deployRemoteCall(ERC3156FlashBorrowerMock.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ERC3156FlashBorrowerMock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, Boolean enableReturn, Boolean enableApprove) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Bool(enableReturn), 
                new org.web3j.abi.datatypes.Bool(enableApprove)));
        return deployRemoteCall(ERC3156FlashBorrowerMock.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ERC3156FlashBorrowerMock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, Boolean enableReturn, Boolean enableApprove) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Bool(enableReturn), 
                new org.web3j.abi.datatypes.Bool(enableApprove)));
        return deployRemoteCall(ERC3156FlashBorrowerMock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class BalanceOfEventResponse extends BaseEventResponse {
        public String token;

        public String account;

        public BigInteger value;
    }

    public static class TotalSupplyEventResponse extends BaseEventResponse {
        public String token;

        public BigInteger value;
    }
}
