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
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
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
public class ERC20SnapshotMock extends Contract {
    public static final String BINARY = "60806040523480156200001157600080fd5b50604051620014f8380380620014f8833981016040819052620000349162000439565b8351849084906200004d906003906020850190620002c6565b50805162000063906004906020840190620002c6565b5050506200007882826200008260201b60201c565b505050506200056a565b6001600160a01b038216620000dd5760405162461bcd60e51b815260206004820152601f60248201527f45524332303a206d696e7420746f20746865207a65726f206164647265737300604482015260640160405180910390fd5b620000eb6000838362000156565b8060026000828254620000ff9190620004e2565b90915550506001600160a01b038216600081815260208181526040808320805486019055518481527fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef910160405180910390a35050565b6200016e8383836200019260201b620004ae1760201c565b6001600160a01b03831662000197576200018882620001c2565b62000192620001fa565b505050565b6001600160a01b038216620001b1576200018883620001c2565b620001bc83620001c2565b62000192825b6001600160a01b03811660009081526005602090815260408083209183905290912054620001f791906200020c565b6200020c565b50565b6200020a6006620001f160025490565b565b6000620002186200025b565b905080620002268462000279565b101562000192578254600180820185556000858152602080822090930193909355938401805494850181558252902090910155565b6000620002746008620002c260201b620004b31760201c565b905090565b80546000906200028b57506000919050565b815482906200029d90600190620004fd565b81548110620002b057620002b062000517565b90600052602060002001549050919050565b5490565b828054620002d4906200052d565b90600052602060002090601f016020900481019282620002f8576000855562000343565b82601f106200031357805160ff191683800117855562000343565b8280016001018555821562000343579182015b828111156200034357825182559160200191906001019062000326565b506200035192915062000355565b5090565b5b8082111562000351576000815560010162000356565b634e487b7160e01b600052604160045260246000fd5b600082601f8301126200039457600080fd5b81516001600160401b0380821115620003b157620003b16200036c565b604051601f8301601f19908116603f01168101908282118183101715620003dc57620003dc6200036c565b81604052838152602092508683858801011115620003f957600080fd5b600091505b838210156200041d5785820183015181830184015290820190620003fe565b838211156200042f5760008385830101525b9695505050505050565b600080600080608085870312156200045057600080fd5b84516001600160401b03808211156200046857600080fd5b620004768883890162000382565b955060208701519150808211156200048d57600080fd5b506200049c8782880162000382565b604087015190945090506001600160a01b0381168114620004bc57600080fd5b6060959095015193969295505050565b634e487b7160e01b600052601160045260246000fd5b60008219821115620004f857620004f8620004cc565b500190565b600082821015620005125762000512620004cc565b500390565b634e487b7160e01b600052603260045260246000fd5b600181811c908216806200054257607f821691505b602082108114156200056457634e487b7160e01b600052602260045260246000fd5b50919050565b610f7e806200057a6000396000f3fe608060405234801561001057600080fd5b50600436106101005760003560e01c806370a08231116100975780639dc29fac116100665780639dc29fac14610201578063a457c2d714610214578063a9059cbb14610227578063dd62ed3e1461023a57600080fd5b806370a08231146101b557806395d89b41146101de5780639711715a146101e6578063981b24d0146101ee57600080fd5b8063313ce567116100d3578063313ce5671461016b578063395093511461017a57806340c10f191461018d5780634ee2cd7e146101a257600080fd5b806306fdde0314610105578063095ea7b31461012357806318160ddd1461014657806323b872dd14610158575b600080fd5b61010d61024d565b60405161011a9190610d57565b60405180910390f35b610136610131366004610dc3565b6102df565b604051901515815260200161011a565b6002545b60405190815260200161011a565b610136610166366004610ded565b6102f9565b6040516012815260200161011a565b610136610188366004610dc3565b61031d565b6101a061019b366004610dc3565b61033f565b005b61014a6101b0366004610dc3565b61034d565b61014a6101c3366004610e29565b6001600160a01b031660009081526020819052604090205490565b61010d6103a6565b6101a06103b5565b61014a6101fc366004610e44565b6103c0565b6101a061020f366004610dc3565b6103eb565b610136610222366004610dc3565b6103f5565b610136610235366004610dc3565b610475565b61014a610248366004610e5d565b610483565b60606003805461025c90610e90565b80601f016020809104026020016040519081016040528092919081815260200182805461028890610e90565b80156102d55780601f106102aa576101008083540402835291602001916102d5565b820191906000526020600020905b8154815290600101906020018083116102b857829003601f168201915b5050505050905090565b6000336102ed8185856104b7565b60019150505b92915050565b6000336103078582856105db565b610312858585610655565b506001949350505050565b6000336102ed8185856103308383610483565b61033a9190610ee1565b6104b7565b6103498282610804565b5050565b6001600160a01b0382166000908152600560205260408120819081906103749085906108cf565b915091508161039b576001600160a01b03851660009081526020819052604090205461039d565b805b95945050505050565b60606004805461025c90610e90565b6103bd6109c6565b50565b60008060006103d08460066108cf565b91509150816103e1576002546103e3565b805b949350505050565b6103498282610a20565b600033816104038286610483565b9050838110156104685760405162461bcd60e51b815260206004820152602560248201527f45524332303a2064656372656173656420616c6c6f77616e63652062656c6f77604482015264207a65726f60d81b60648201526084015b60405180910390fd5b61031282868684036104b7565b6000336102ed818585610655565b6001600160a01b03918216600090815260016020908152604080832093909416825291909152205490565b505050565b5490565b6001600160a01b0383166105195760405162461bcd60e51b8152602060048201526024808201527f45524332303a20617070726f76652066726f6d20746865207a65726f206164646044820152637265737360e01b606482015260840161045f565b6001600160a01b03821661057a5760405162461bcd60e51b815260206004820152602260248201527f45524332303a20617070726f766520746f20746865207a65726f206164647265604482015261737360f01b606482015260840161045f565b6001600160a01b0383811660008181526001602090815260408083209487168084529482529182902085905590518481527f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925910160405180910390a3505050565b60006105e78484610483565b9050600019811461064f57818110156106425760405162461bcd60e51b815260206004820152601d60248201527f45524332303a20696e73756666696369656e7420616c6c6f77616e6365000000604482015260640161045f565b61064f84848484036104b7565b50505050565b6001600160a01b0383166106b95760405162461bcd60e51b815260206004820152602560248201527f45524332303a207472616e736665722066726f6d20746865207a65726f206164604482015264647265737360d81b606482015260840161045f565b6001600160a01b03821661071b5760405162461bcd60e51b815260206004820152602360248201527f45524332303a207472616e7366657220746f20746865207a65726f206164647260448201526265737360e81b606482015260840161045f565b610726838383610b5e565b6001600160a01b0383166000908152602081905260409020548181101561079e5760405162461bcd60e51b815260206004820152602660248201527f45524332303a207472616e7366657220616d6f756e7420657863656564732062604482015265616c616e636560d01b606482015260840161045f565b6001600160a01b03848116600081815260208181526040808320878703905593871680835291849020805487019055925185815290927fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef910160405180910390a361064f565b6001600160a01b03821661085a5760405162461bcd60e51b815260206004820152601f60248201527f45524332303a206d696e7420746f20746865207a65726f206164647265737300604482015260640161045f565b61086660008383610b5e565b80600260008282546108789190610ee1565b90915550506001600160a01b038216600081815260208181526040808320805486019055518481527fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef910160405180910390a35050565b6000806000841161091b5760405162461bcd60e51b815260206004820152601660248201527504552433230536e617073686f743a20696420697320360541b604482015260640161045f565b610923610ba6565b8411156109725760405162461bcd60e51b815260206004820152601d60248201527f4552433230536e617073686f743a206e6f6e6578697374656e74206964000000604482015260640161045f565b600061097e8486610bb6565b84549091508114156109975760008092509250506109bf565b60018460010182815481106109ae576109ae610ef9565b906000526020600020015492509250505b9250929050565b60006109d6600880546001019055565b60006109e0610ba6565b90507f8030e83b04d87bef53480e26263266d6ca66863aa8506aca6f2559d18aa1cb6781604051610a1391815260200190565b60405180910390a1919050565b6001600160a01b038216610a805760405162461bcd60e51b815260206004820152602160248201527f45524332303a206275726e2066726f6d20746865207a65726f206164647265736044820152607360f81b606482015260840161045f565b610a8c82600083610b5e565b6001600160a01b03821660009081526020819052604090205481811015610b005760405162461bcd60e51b815260206004820152602260248201527f45524332303a206275726e20616d6f756e7420657863656564732062616c616e604482015261636560f01b606482015260840161045f565b6001600160a01b0383166000818152602081815260408083208686039055600280548790039055518581529192917fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef910160405180910390a3505050565b6001600160a01b038316610b7d57610b7582610c61565b6104ae610c93565b6001600160a01b038216610b9457610b7583610c61565b610b9d83610c61565b6104ae82610c61565b6000610bb160085490565b905090565b8154600090610bc7575060006102f3565b82546000905b80821015610c14576000610be18383610ca3565b60008781526020902090915085908201541115610c0057809150610c0e565b610c0b816001610ee1565b92505b50610bcd565b600082118015610c40575083610c3d86610c2f600186610f0f565b600091825260209091200190565b54145b15610c5957610c50600183610f0f565b925050506102f3565b5090506102f3565b6001600160a01b038116600090815260056020908152604080832091839052909120546103bd9190610cc5565b610cc5565b610ca16006610c8e60025490565b565b6000610cb26002848418610f26565b610cbe90848416610ee1565b9392505050565b6000610ccf610ba6565b905080610cdb84610d0f565b10156104ae578254600180820185556000858152602080822090930193909355938401805494850181558252902090910155565b8054600090610d2057506000919050565b81548290610d3090600190610f0f565b81548110610d4057610d40610ef9565b90600052602060002001549050919050565b919050565b600060208083528351808285015260005b81811015610d8457858101830151858201604001528201610d68565b81811115610d96576000604083870101525b50601f01601f1916929092016040019392505050565b80356001600160a01b0381168114610d5257600080fd5b60008060408385031215610dd657600080fd5b610ddf83610dac565b946020939093013593505050565b600080600060608486031215610e0257600080fd5b610e0b84610dac565b9250610e1960208501610dac565b9150604084013590509250925092565b600060208284031215610e3b57600080fd5b610cbe82610dac565b600060208284031215610e5657600080fd5b5035919050565b60008060408385031215610e7057600080fd5b610e7983610dac565b9150610e8760208401610dac565b90509250929050565b600181811c90821680610ea457607f821691505b60208210811415610ec557634e487b7160e01b600052602260045260246000fd5b50919050565b634e487b7160e01b600052601160045260246000fd5b60008219821115610ef457610ef4610ecb565b500190565b634e487b7160e01b600052603260045260246000fd5b600082821015610f2157610f21610ecb565b500390565b600082610f4357634e487b7160e01b600052601260045260246000fd5b50049056fea2646970667358221220025b4a5bb065ca428376682b11a93336ad8721ad2c99189d4e2ea678d9f9e56364736f6c63430008090033";

    public static final String FUNC_ALLOWANCE = "allowance";

    public static final String FUNC_APPROVE = "approve";

    public static final String FUNC_BALANCEOF = "balanceOf";

    public static final String FUNC_BALANCEOFAT = "balanceOfAt";

    public static final String FUNC_BURN = "burn";

    public static final String FUNC_DECIMALS = "decimals";

    public static final String FUNC_DECREASEALLOWANCE = "decreaseAllowance";

    public static final String FUNC_INCREASEALLOWANCE = "increaseAllowance";

    public static final String FUNC_MINT = "mint";

    public static final String FUNC_NAME = "name";

    public static final String FUNC_SNAPSHOT = "snapshot";

    public static final String FUNC_SYMBOL = "symbol";

    public static final String FUNC_TOTALSUPPLY = "totalSupply";

    public static final String FUNC_TOTALSUPPLYAT = "totalSupplyAt";

    public static final String FUNC_TRANSFER = "transfer";

    public static final String FUNC_TRANSFERFROM = "transferFrom";

    public static final Event APPROVAL_EVENT = new Event("Approval", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event SNAPSHOT_EVENT = new Event("Snapshot", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    public static final Event TRANSFER_EVENT = new Event("Transfer", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected ERC20SnapshotMock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ERC20SnapshotMock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ERC20SnapshotMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ERC20SnapshotMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<ApprovalEventResponse> getApprovalEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(APPROVAL_EVENT, transactionReceipt);
        ArrayList<ApprovalEventResponse> responses = new ArrayList<ApprovalEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ApprovalEventResponse typedResponse = new ApprovalEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.spender = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ApprovalEventResponse> approvalEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ApprovalEventResponse>() {
            @Override
            public ApprovalEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(APPROVAL_EVENT, log);
                ApprovalEventResponse typedResponse = new ApprovalEventResponse();
                typedResponse.log = log;
                typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.spender = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ApprovalEventResponse> approvalEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(APPROVAL_EVENT));
        return approvalEventFlowable(filter);
    }

    public static List<SnapshotEventResponse> getSnapshotEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(SNAPSHOT_EVENT, transactionReceipt);
        ArrayList<SnapshotEventResponse> responses = new ArrayList<SnapshotEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            SnapshotEventResponse typedResponse = new SnapshotEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<SnapshotEventResponse> snapshotEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, SnapshotEventResponse>() {
            @Override
            public SnapshotEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(SNAPSHOT_EVENT, log);
                SnapshotEventResponse typedResponse = new SnapshotEventResponse();
                typedResponse.log = log;
                typedResponse.id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<SnapshotEventResponse> snapshotEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(SNAPSHOT_EVENT));
        return snapshotEventFlowable(filter);
    }

    public static List<TransferEventResponse> getTransferEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(TRANSFER_EVENT, transactionReceipt);
        ArrayList<TransferEventResponse> responses = new ArrayList<TransferEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            TransferEventResponse typedResponse = new TransferEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<TransferEventResponse> transferEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, TransferEventResponse>() {
            @Override
            public TransferEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(TRANSFER_EVENT, log);
                TransferEventResponse typedResponse = new TransferEventResponse();
                typedResponse.log = log;
                typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<TransferEventResponse> transferEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TRANSFER_EVENT));
        return transferEventFlowable(filter);
    }

    public RemoteFunctionCall<BigInteger> allowance(String owner, String spender) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ALLOWANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, owner), 
                new org.web3j.abi.datatypes.Address(160, spender)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> approve(String spender, BigInteger amount) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_APPROVE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, spender), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> balanceOf(String account) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_BALANCEOF, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, account)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> balanceOfAt(String account, BigInteger snapshotId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_BALANCEOFAT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, account), 
                new org.web3j.abi.datatypes.generated.Uint256(snapshotId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> burn(String account, BigInteger amount) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_BURN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, account), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> decimals() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_DECIMALS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> decreaseAllowance(String spender, BigInteger subtractedValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_DECREASEALLOWANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, spender), 
                new org.web3j.abi.datatypes.generated.Uint256(subtractedValue)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> increaseAllowance(String spender, BigInteger addedValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_INCREASEALLOWANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, spender), 
                new org.web3j.abi.datatypes.generated.Uint256(addedValue)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> mint(String account, BigInteger amount) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_MINT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, account), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> name() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_NAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> snapshot() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SNAPSHOT, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> symbol() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_SYMBOL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> totalSupply() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_TOTALSUPPLY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> totalSupplyAt(BigInteger snapshotId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_TOTALSUPPLYAT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(snapshotId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> transfer(String to, BigInteger amount) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, to), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> transferFrom(String from, String to, BigInteger amount) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFERFROM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, from), 
                new org.web3j.abi.datatypes.Address(160, to), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static ERC20SnapshotMock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ERC20SnapshotMock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ERC20SnapshotMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ERC20SnapshotMock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ERC20SnapshotMock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ERC20SnapshotMock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ERC20SnapshotMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ERC20SnapshotMock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ERC20SnapshotMock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String name, String symbol, String initialAccount, BigInteger initialBalance) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.Utf8String(symbol), 
                new org.web3j.abi.datatypes.Address(160, initialAccount), 
                new org.web3j.abi.datatypes.generated.Uint256(initialBalance)));
        return deployRemoteCall(ERC20SnapshotMock.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<ERC20SnapshotMock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String name, String symbol, String initialAccount, BigInteger initialBalance) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.Utf8String(symbol), 
                new org.web3j.abi.datatypes.Address(160, initialAccount), 
                new org.web3j.abi.datatypes.generated.Uint256(initialBalance)));
        return deployRemoteCall(ERC20SnapshotMock.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ERC20SnapshotMock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String name, String symbol, String initialAccount, BigInteger initialBalance) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.Utf8String(symbol), 
                new org.web3j.abi.datatypes.Address(160, initialAccount), 
                new org.web3j.abi.datatypes.generated.Uint256(initialBalance)));
        return deployRemoteCall(ERC20SnapshotMock.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ERC20SnapshotMock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String name, String symbol, String initialAccount, BigInteger initialBalance) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.Utf8String(symbol), 
                new org.web3j.abi.datatypes.Address(160, initialAccount), 
                new org.web3j.abi.datatypes.generated.Uint256(initialBalance)));
        return deployRemoteCall(ERC20SnapshotMock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class ApprovalEventResponse extends BaseEventResponse {
        public String owner;

        public String spender;

        public BigInteger value;
    }

    public static class SnapshotEventResponse extends BaseEventResponse {
        public BigInteger id;
    }

    public static class TransferEventResponse extends BaseEventResponse {
        public String from;

        public String to;

        public BigInteger value;
    }
}
