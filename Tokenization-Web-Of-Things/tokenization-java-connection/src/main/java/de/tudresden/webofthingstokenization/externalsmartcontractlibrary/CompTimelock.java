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
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicBytes;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
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
public class CompTimelock extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b506040516110c53803806110c583398101604081905261002f9161014f565b6202a3008110156100ad5760405162461bcd60e51b815260206004820152603760248201527f54696d656c6f636b3a3a636f6e7374727563746f723a2044656c6179206d757360448201527f7420657863656564206d696e696d756d2064656c61792e00000000000000000060648201526084015b60405180910390fd5b62278d008111156101265760405162461bcd60e51b815260206004820152603860248201527f54696d656c6f636b3a3a73657444656c61793a2044656c6179206d757374206e60448201527f6f7420657863656564206d6178696d756d2064656c61792e000000000000000060648201526084016100a4565b600080546001600160a01b0319166001600160a01b039390931692909217909155600255610189565b6000806040838503121561016257600080fd5b82516001600160a01b038116811461017957600080fd5b6020939093015192949293505050565b610f2d806101986000396000f3fe6080604052600436106100c65760003560e01c80636a42b8f81161007f578063c1a287e211610059578063c1a287e2146101fc578063e177246e14610213578063f2b0653714610233578063f851a4401461027357600080fd5b80636a42b8f8146101b85780637d645fab146101ce578063b1b43ae5146101e557600080fd5b80630825f38f146100d25780630e18b681146100fb57806326782247146101125780633a66f9011461014a5780634dd18bf514610178578063591fcdfe1461019857600080fd5b366100cd57005b600080fd5b6100e56100e0366004610c80565b610293565b6040516100f29190610d8d565b60405180910390f35b34801561010757600080fd5b50610110610604565b005b34801561011e57600080fd5b50600154610132906001600160a01b031681565b6040516001600160a01b0390911681526020016100f2565b34801561015657600080fd5b5061016a610165366004610c80565b6106cd565b6040519081526020016100f2565b34801561018457600080fd5b50610110610193366004610da7565b61087a565b3480156101a457600080fd5b506101106101b3366004610c80565b610939565b3480156101c457600080fd5b5061016a60025481565b3480156101da57600080fd5b5061016a62278d0081565b3480156101f157600080fd5b5061016a6202a30081565b34801561020857600080fd5b5061016a6212750081565b34801561021f57600080fd5b5061011061022e366004610dc2565b610a53565b34801561023f57600080fd5b5061026361024e366004610dc2565b60036020526000908152604090205460ff1681565b60405190151581526020016100f2565b34801561027f57600080fd5b50600054610132906001600160a01b031681565b6000546060906001600160a01b0316331461031b5760405162461bcd60e51b815260206004820152603860248201527f54696d656c6f636b3a3a657865637574655472616e73616374696f6e3a20436160448201527f6c6c206d75737420636f6d652066726f6d2061646d696e2e000000000000000060648201526084015b60405180910390fd5b60008686868686604051602001610336959493929190610ddb565b60408051601f1981840301815291815281516020928301206000818152600390935291205490915060ff166103c15760405162461bcd60e51b815260206004820152603d6024820152600080516020610ed883398151915260448201527f616e73616374696f6e206861736e2774206265656e207175657565642e0000006064820152608401610312565b824210156104335760405162461bcd60e51b81526020600482015260456024820152600080516020610ed883398151915260448201527f616e73616374696f6e206861736e2774207375727061737365642074696d65206064820152643637b1b59760d91b608482015260a401610312565b6104406212750084610e27565b4211156104995760405162461bcd60e51b81526020600482015260336024820152600080516020610ed883398151915260448201527230b739b0b1ba34b7b71034b99039ba30b6329760691b6064820152608401610312565b6000818152600360205260409020805460ff1916905584516060906104bf5750836104eb565b8580519060200120856040516020016104d9929190610e4d565b60405160208183030381529060405290505b600080896001600160a01b031689846040516105079190610e7e565b60006040518083038185875af1925050503d8060008114610544576040519150601f19603f3d011682016040523d82523d6000602084013e610549565b606091505b5091509150816105af5760405162461bcd60e51b815260206004820152603d6024820152600080516020610ed883398151915260448201527f616e73616374696f6e20657865637574696f6e2072657665727465642e0000006064820152608401610312565b896001600160a01b0316847fa560e3198060a2f10670c1ec5b403077ea6ae93ca8de1c32b451dc1a943cd6e78b8b8b8b6040516105ef9493929190610e9a565b60405180910390a39998505050505050505050565b6001546001600160a01b031633146106845760405162461bcd60e51b815260206004820152603860248201527f54696d656c6f636b3a3a61636365707441646d696e3a2043616c6c206d75737460448201527f20636f6d652066726f6d2070656e64696e6741646d696e2e00000000000000006064820152608401610312565b60008054336001600160a01b0319918216811783556001805490921690915560405190917f71614071b88dee5e0b2ae578a9dd7b2ebbe9ae832ba419dc0242cd065a290b6c91a2565b600080546001600160a01b031633146107475760405162461bcd60e51b815260206004820152603660248201527f54696d656c6f636b3a3a71756575655472616e73616374696f6e3a2043616c6c6044820152751036bab9ba1031b7b6b290333937b69030b236b4b71760511b6064820152608401610312565b6002546107549042610e27565b8210156107db5760405162461bcd60e51b815260206004820152604960248201527f54696d656c6f636b3a3a71756575655472616e73616374696f6e3a204573746960448201527f6d6174656420657865637574696f6e20626c6f636b206d757374207361746973606482015268333c903232b630bc9760b91b608482015260a401610312565b600086868686866040516020016107f6959493929190610ddb565b60408051601f19818403018152828252805160209182012060008181526003909252919020805460ff1916600117905591506001600160a01b0388169082907f76e2796dc3a81d57b0e8504b647febcbeeb5f4af818e164f11eef8131a6a763f90610868908a908a908a908a90610e9a565b60405180910390a39695505050505050565b3330146108ef5760405162461bcd60e51b815260206004820152603860248201527f54696d656c6f636b3a3a73657450656e64696e6741646d696e3a2043616c6c2060448201527f6d75737420636f6d652066726f6d2054696d656c6f636b2e00000000000000006064820152608401610312565b600180546001600160a01b0319166001600160a01b0383169081179091556040517f69d78e38a01985fbb1462961809b4b2d65531bc93b2b94037f3334b82ca4a75690600090a250565b6000546001600160a01b031633146109b95760405162461bcd60e51b815260206004820152603760248201527f54696d656c6f636b3a3a63616e63656c5472616e73616374696f6e3a2043616c60448201527f6c206d75737420636f6d652066726f6d2061646d696e2e0000000000000000006064820152608401610312565b600085858585856040516020016109d4959493929190610ddb565b60408051601f19818403018152828252805160209182012060008181526003909252919020805460ff1916905591506001600160a01b0387169082907f2fffc091a501fd91bfbff27141450d3acb40fb8e6d8382b243ec7a812a3aaf8790610a43908990899089908990610e9a565b60405180910390a3505050505050565b333014610abc5760405162461bcd60e51b815260206004820152603160248201527f54696d656c6f636b3a3a73657444656c61793a2043616c6c206d75737420636f60448201527036b290333937b6902a34b6b2b637b1b59760791b6064820152608401610312565b6202a300811015610b2c5760405162461bcd60e51b815260206004820152603460248201527f54696d656c6f636b3a3a73657444656c61793a2044656c6179206d75737420656044820152733c31b2b2b21036b4b734b6bab6903232b630bc9760611b6064820152608401610312565b62278d00811115610ba55760405162461bcd60e51b815260206004820152603860248201527f54696d656c6f636b3a3a73657444656c61793a2044656c6179206d757374206e60448201527f6f7420657863656564206d6178696d756d2064656c61792e00000000000000006064820152608401610312565b600281905560405181907f948b1f6a42ee138b7e34058ba85a37f716d55ff25ff05a763f15bed6a04c8d2c90600090a250565b80356001600160a01b0381168114610bef57600080fd5b919050565b634e487b7160e01b600052604160045260246000fd5b600067ffffffffffffffff80841115610c2557610c25610bf4565b604051601f8501601f19908116603f01168101908282118183101715610c4d57610c4d610bf4565b81604052809350858152868686011115610c6657600080fd5b858560208301376000602087830101525050509392505050565b600080600080600060a08688031215610c9857600080fd5b610ca186610bd8565b945060208601359350604086013567ffffffffffffffff80821115610cc557600080fd5b818801915088601f830112610cd957600080fd5b610ce889833560208501610c0a565b94506060880135915080821115610cfe57600080fd5b508601601f81018813610d1057600080fd5b610d1f88823560208401610c0a565b95989497509295608001359392505050565b60005b83811015610d4c578181015183820152602001610d34565b83811115610d5b576000848401525b50505050565b60008151808452610d79816020860160208601610d31565b601f01601f19169290920160200192915050565b602081526000610da06020830184610d61565b9392505050565b600060208284031215610db957600080fd5b610da082610bd8565b600060208284031215610dd457600080fd5b5035919050565b60018060a01b038616815284602082015260a060408201526000610e0260a0830186610d61565b8281036060840152610e148186610d61565b9150508260808301529695505050505050565b60008219821115610e4857634e487b7160e01b600052601160045260246000fd5b500190565b6001600160e01b0319831681528151600090610e70816004850160208701610d31565b919091016004019392505050565b60008251610e90818460208701610d31565b9190910192915050565b848152608060208201526000610eb36080830186610d61565b8281036040840152610ec58186610d61565b9150508260608301529594505050505056fe54696d656c6f636b3a3a657865637574655472616e73616374696f6e3a205472a2646970667358221220e9358e85670353aabf7bc2858459338d56ad90566842eff15e1426d0780ff49e64736f6c63430008090033";

    public static final String FUNC_GRACE_PERIOD = "GRACE_PERIOD";

    public static final String FUNC_MAXIMUM_DELAY = "MAXIMUM_DELAY";

    public static final String FUNC_MINIMUM_DELAY = "MINIMUM_DELAY";

    public static final String FUNC_ACCEPTADMIN = "acceptAdmin";

    public static final String FUNC_ADMIN = "admin";

    public static final String FUNC_CANCELTRANSACTION = "cancelTransaction";

    public static final String FUNC_DELAY = "delay";

    public static final String FUNC_EXECUTETRANSACTION = "executeTransaction";

    public static final String FUNC_PENDINGADMIN = "pendingAdmin";

    public static final String FUNC_QUEUETRANSACTION = "queueTransaction";

    public static final String FUNC_QUEUEDTRANSACTIONS = "queuedTransactions";

    public static final String FUNC_SETDELAY = "setDelay";

    public static final String FUNC_SETPENDINGADMIN = "setPendingAdmin";

    public static final Event CANCELTRANSACTION_EVENT = new Event("CancelTransaction", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<DynamicBytes>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event EXECUTETRANSACTION_EVENT = new Event("ExecuteTransaction", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<DynamicBytes>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event NEWADMIN_EVENT = new Event("NewAdmin", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    public static final Event NEWDELAY_EVENT = new Event("NewDelay", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}));
    ;

    public static final Event NEWPENDINGADMIN_EVENT = new Event("NewPendingAdmin", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}));
    ;

    public static final Event QUEUETRANSACTION_EVENT = new Event("QueueTransaction", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<DynamicBytes>() {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected CompTimelock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected CompTimelock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected CompTimelock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected CompTimelock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<CancelTransactionEventResponse> getCancelTransactionEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(CANCELTRANSACTION_EVENT, transactionReceipt);
        ArrayList<CancelTransactionEventResponse> responses = new ArrayList<CancelTransactionEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            CancelTransactionEventResponse typedResponse = new CancelTransactionEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.txHash = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.target = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.signature = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.eta = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<CancelTransactionEventResponse> cancelTransactionEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, CancelTransactionEventResponse>() {
            @Override
            public CancelTransactionEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(CANCELTRANSACTION_EVENT, log);
                CancelTransactionEventResponse typedResponse = new CancelTransactionEventResponse();
                typedResponse.log = log;
                typedResponse.txHash = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.target = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.signature = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.eta = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<CancelTransactionEventResponse> cancelTransactionEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CANCELTRANSACTION_EVENT));
        return cancelTransactionEventFlowable(filter);
    }

    public static List<ExecuteTransactionEventResponse> getExecuteTransactionEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(EXECUTETRANSACTION_EVENT, transactionReceipt);
        ArrayList<ExecuteTransactionEventResponse> responses = new ArrayList<ExecuteTransactionEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ExecuteTransactionEventResponse typedResponse = new ExecuteTransactionEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.txHash = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.target = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.signature = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.eta = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ExecuteTransactionEventResponse> executeTransactionEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ExecuteTransactionEventResponse>() {
            @Override
            public ExecuteTransactionEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(EXECUTETRANSACTION_EVENT, log);
                ExecuteTransactionEventResponse typedResponse = new ExecuteTransactionEventResponse();
                typedResponse.log = log;
                typedResponse.txHash = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.target = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.signature = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.eta = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ExecuteTransactionEventResponse> executeTransactionEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(EXECUTETRANSACTION_EVENT));
        return executeTransactionEventFlowable(filter);
    }

    public static List<NewAdminEventResponse> getNewAdminEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(NEWADMIN_EVENT, transactionReceipt);
        ArrayList<NewAdminEventResponse> responses = new ArrayList<NewAdminEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            NewAdminEventResponse typedResponse = new NewAdminEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.newAdmin = (String) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<NewAdminEventResponse> newAdminEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, NewAdminEventResponse>() {
            @Override
            public NewAdminEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(NEWADMIN_EVENT, log);
                NewAdminEventResponse typedResponse = new NewAdminEventResponse();
                typedResponse.log = log;
                typedResponse.newAdmin = (String) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<NewAdminEventResponse> newAdminEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(NEWADMIN_EVENT));
        return newAdminEventFlowable(filter);
    }

    public static List<NewDelayEventResponse> getNewDelayEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(NEWDELAY_EVENT, transactionReceipt);
        ArrayList<NewDelayEventResponse> responses = new ArrayList<NewDelayEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            NewDelayEventResponse typedResponse = new NewDelayEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.newDelay = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<NewDelayEventResponse> newDelayEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, NewDelayEventResponse>() {
            @Override
            public NewDelayEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(NEWDELAY_EVENT, log);
                NewDelayEventResponse typedResponse = new NewDelayEventResponse();
                typedResponse.log = log;
                typedResponse.newDelay = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<NewDelayEventResponse> newDelayEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(NEWDELAY_EVENT));
        return newDelayEventFlowable(filter);
    }

    public static List<NewPendingAdminEventResponse> getNewPendingAdminEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(NEWPENDINGADMIN_EVENT, transactionReceipt);
        ArrayList<NewPendingAdminEventResponse> responses = new ArrayList<NewPendingAdminEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            NewPendingAdminEventResponse typedResponse = new NewPendingAdminEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.newPendingAdmin = (String) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<NewPendingAdminEventResponse> newPendingAdminEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, NewPendingAdminEventResponse>() {
            @Override
            public NewPendingAdminEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(NEWPENDINGADMIN_EVENT, log);
                NewPendingAdminEventResponse typedResponse = new NewPendingAdminEventResponse();
                typedResponse.log = log;
                typedResponse.newPendingAdmin = (String) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<NewPendingAdminEventResponse> newPendingAdminEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(NEWPENDINGADMIN_EVENT));
        return newPendingAdminEventFlowable(filter);
    }

    public static List<QueueTransactionEventResponse> getQueueTransactionEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(QUEUETRANSACTION_EVENT, transactionReceipt);
        ArrayList<QueueTransactionEventResponse> responses = new ArrayList<QueueTransactionEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            QueueTransactionEventResponse typedResponse = new QueueTransactionEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.txHash = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.target = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.signature = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.eta = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<QueueTransactionEventResponse> queueTransactionEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, QueueTransactionEventResponse>() {
            @Override
            public QueueTransactionEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(QUEUETRANSACTION_EVENT, log);
                QueueTransactionEventResponse typedResponse = new QueueTransactionEventResponse();
                typedResponse.log = log;
                typedResponse.txHash = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.target = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.signature = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.eta = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<QueueTransactionEventResponse> queueTransactionEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(QUEUETRANSACTION_EVENT));
        return queueTransactionEventFlowable(filter);
    }

    public RemoteFunctionCall<BigInteger> GRACE_PERIOD() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GRACE_PERIOD, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> MAXIMUM_DELAY() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_MAXIMUM_DELAY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> MINIMUM_DELAY() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_MINIMUM_DELAY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> acceptAdmin() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ACCEPTADMIN, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> admin() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ADMIN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> cancelTransaction(String target, BigInteger value, String signature, byte[] data, BigInteger eta) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_CANCELTRANSACTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, target), 
                new org.web3j.abi.datatypes.generated.Uint256(value), 
                new org.web3j.abi.datatypes.Utf8String(signature), 
                new org.web3j.abi.datatypes.DynamicBytes(data), 
                new org.web3j.abi.datatypes.generated.Uint256(eta)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> delay() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_DELAY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> executeTransaction(String target, BigInteger value, String signature, byte[] data, BigInteger eta, BigInteger weiValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_EXECUTETRANSACTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, target), 
                new org.web3j.abi.datatypes.generated.Uint256(value), 
                new org.web3j.abi.datatypes.Utf8String(signature), 
                new org.web3j.abi.datatypes.DynamicBytes(data), 
                new org.web3j.abi.datatypes.generated.Uint256(eta)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<String> pendingAdmin() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_PENDINGADMIN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> queueTransaction(String target, BigInteger value, String signature, byte[] data, BigInteger eta) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_QUEUETRANSACTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, target), 
                new org.web3j.abi.datatypes.generated.Uint256(value), 
                new org.web3j.abi.datatypes.Utf8String(signature), 
                new org.web3j.abi.datatypes.DynamicBytes(data), 
                new org.web3j.abi.datatypes.generated.Uint256(eta)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> queuedTransactions(byte[] param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_QUEUEDTRANSACTIONS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> setDelay(BigInteger delay_) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETDELAY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(delay_)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setPendingAdmin(String pendingAdmin_) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETPENDINGADMIN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, pendingAdmin_)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static CompTimelock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new CompTimelock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static CompTimelock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new CompTimelock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static CompTimelock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new CompTimelock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static CompTimelock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new CompTimelock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<CompTimelock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String admin_, BigInteger delay_) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, admin_), 
                new org.web3j.abi.datatypes.generated.Uint256(delay_)));
        return deployRemoteCall(CompTimelock.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<CompTimelock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String admin_, BigInteger delay_) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, admin_), 
                new org.web3j.abi.datatypes.generated.Uint256(delay_)));
        return deployRemoteCall(CompTimelock.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<CompTimelock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String admin_, BigInteger delay_) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, admin_), 
                new org.web3j.abi.datatypes.generated.Uint256(delay_)));
        return deployRemoteCall(CompTimelock.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<CompTimelock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String admin_, BigInteger delay_) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, admin_), 
                new org.web3j.abi.datatypes.generated.Uint256(delay_)));
        return deployRemoteCall(CompTimelock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class CancelTransactionEventResponse extends BaseEventResponse {
        public byte[] txHash;

        public String target;

        public BigInteger value;

        public String signature;

        public byte[] data;

        public BigInteger eta;
    }

    public static class ExecuteTransactionEventResponse extends BaseEventResponse {
        public byte[] txHash;

        public String target;

        public BigInteger value;

        public String signature;

        public byte[] data;

        public BigInteger eta;
    }

    public static class NewAdminEventResponse extends BaseEventResponse {
        public String newAdmin;
    }

    public static class NewDelayEventResponse extends BaseEventResponse {
        public BigInteger newDelay;
    }

    public static class NewPendingAdminEventResponse extends BaseEventResponse {
        public String newPendingAdmin;
    }

    public static class QueueTransactionEventResponse extends BaseEventResponse {
        public byte[] txHash;

        public String target;

        public BigInteger value;

        public String signature;

        public byte[] data;

        public BigInteger eta;
    }
}
