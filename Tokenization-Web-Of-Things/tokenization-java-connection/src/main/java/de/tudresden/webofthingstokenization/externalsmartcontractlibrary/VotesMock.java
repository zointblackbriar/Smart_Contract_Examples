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
public class VotesMock extends Contract {
    public static final String BINARY = "6101406040523480156200001257600080fd5b50604051620015613803806200156183398101604081905262000035916200010f565b60408051808201825260018152603160f81b60209182015282519281019290922060e08190527fc89efdaa54c0f20c7adf612882df0950f5a951637e0307cdcb4c672f298b8bc66101008190524660a081815284517f8b73c3c69bb8fe3d512ecc4cf759cc79239f7b179b0ffacaa9a75d522b39400f818801819052818701959095526060810193909352608080840192909252308382018190528551808503909201825260c09384019095528051950194909420909352915261012052620001eb565b634e487b7160e01b600052604160045260246000fd5b600060208083850312156200012357600080fd5b82516001600160401b03808211156200013b57600080fd5b818501915085601f8301126200015057600080fd5b815181811115620001655762000165620000f9565b604051601f8201601f19908116603f01168101908382118183101715620001905762000190620000f9565b816040528281528886848701011115620001a957600080fd5b600093505b82841015620001cd5784840186015181850187015292850192620001ae565b82841115620001df5760008684830101525b98975050505050505050565b60805160a05160c05160e05161010051610120516113266200023b6000396000610576015260006105c5015260006105a0015260006104f9015260006105230152600061054d01526113266000f3fe608060405234801561001057600080fd5b50600436106100cf5760003560e01c80635c19a95c1161008c5780638e539e8c116100665780638e539e8c146101a95780639ab24eb0146101bc578063c3cda520146101cf578063c4e41b22146101e257600080fd5b80635c19a95c146101705780637ecebe00146101835780638ab656861461019657600080fd5b80633408e470146100d45780633644e515146100e95780633a46b1a8146100f157806340c10f191461010457806342966c6814610119578063587cde1e1461012c575b600080fd5b465b6040519081526020015b60405180910390f35b6100d66101ea565b6100d66100ff36600461116c565b6101f9565b61011761011236600461116c565b610222565b005b610117610127366004611196565b610287565b61015861013a3660046111af565b6001600160a01b039081166000908152602081905260409020541690565b6040516001600160a01b0390911681526020016100e0565b61011761017e3660046111af565b6102d1565b6100d66101913660046111af565b6102dc565b6101176101a43660046111ca565b6102fc565b6100d66101b7366004611196565b610306565b6100d66101ca3660046111af565b610367565b6101176101dd3660046111fd565b610397565b6100d66104e2565b60006101f46104ec565b905090565b6001600160a01b038216600090815260016020526040812061021b9083610613565b9392505050565b6001600160a01b038216600090815260046020526040812080546001929061024b908490611273565b9091555050600081815260056020526040812080546001600160a01b0319166001600160a01b0385161790556102839083600161072f565b5050565b6000818152600560209081526040808320546001600160a01b031680845260049092528220805491926001926102be90849061128b565b909155506102839050816000600161072f565b3361028381836107a4565b6001600160a01b0381166000908152600360205260408120545b92915050565b61028382826107a4565b600043821061035c5760405162461bcd60e51b815260206004820152601a60248201527f566f7465733a20626c6f636b206e6f7420796574206d696e656400000000000060448201526064015b60405180910390fd5b6102f6600283610613565b6001600160a01b03811660009081526001602052604081206103889061082c565b6001600160e01b031692915050565b834211156103e75760405162461bcd60e51b815260206004820152601860248201527f566f7465733a207369676e6174757265206578706972656400000000000000006044820152606401610353565b604080517fe48329057bfd03d55e49b547132e39cffd9c1820ad7b9d4c5307691425d15adf60208201526001600160a01b038816918101919091526060810186905260808101859052600090610461906104599060a00160405160208183030381529060405280519060200120610866565b8585856108b4565b905061048a816001600160a01b0316600090815260036020526040902080546001810190915590565b86146104cf5760405162461bcd60e51b8152602060048201526014602482015273566f7465733a20696e76616c6964206e6f6e636560601b6044820152606401610353565b6104d981886107a4565b50505050505050565b60006101f46108dc565b6000306001600160a01b037f00000000000000000000000000000000000000000000000000000000000000001614801561054557507f000000000000000000000000000000000000000000000000000000000000000046145b1561056f57507f000000000000000000000000000000000000000000000000000000000000000090565b50604080517f00000000000000000000000000000000000000000000000000000000000000006020808301919091527f0000000000000000000000000000000000000000000000000000000000000000828401527f000000000000000000000000000000000000000000000000000000000000000060608301524660808301523060a0808401919091528351808403909101815260c0909201909252805191012090565b60004382106106645760405162461bcd60e51b815260206004820181905260248201527f436865636b706f696e74733a20626c6f636b206e6f7420796574206d696e65646044820152606401610353565b600061066f836108f6565b845490915060008160058111156106cd57600061068b8461095f565b610695908561128b565b60008981526020902090915081015463ffffffff90811690861610156106bd578091506106cb565b6106c8816001611273565b92505b505b60006106db88868585610a44565b9050801561071757610700886106f260018461128b565b600091825260209091200190565b5464010000000090046001600160e01b031661071a565b60005b6001600160e01b031698975050505050505050565b6001600160a01b03831661074e5761074b6002610aa283610aae565b50505b6001600160a01b03821661076d5761076a6002610ae683610aae565b50505b6001600160a01b0383811660009081526020819052604080822054858416835291205461079f92918216911683610af2565b505050565b6001600160a01b0382811660008181526020819052604080822080548686166001600160a01b0319821681179092559151919094169392849290917f3134e8a2e6d97e929a7e54011ea5485d7d196dd5f0ba4d4ef95803e8e3fc257f9190a461079f8183610827866001600160a01b031660009081526004602052604090205490565b610af2565b8054600090801561085d57610846836106f260018461128b565b5464010000000090046001600160e01b031661021b565b60009392505050565b60006102f66108736104ec565b8360405161190160f01b6020820152602281018390526042810182905260009060620160405160208183030381529060405280519060200120905092915050565b60008060006108c587878787610c2f565b915091506108d281610cf3565b5095945050505050565b60006108e8600261082c565b6001600160e01b0316905090565b600063ffffffff82111561095b5760405162461bcd60e51b815260206004820152602660248201527f53616665436173743a2076616c756520646f65736e27742066697420696e203360448201526532206269747360d01b6064820152608401610353565b5090565b60008161096e57506000919050565b6000600161097b84610e44565b901c6001901b90506001818481610994576109946112a2565b048201901c905060018184816109ac576109ac6112a2565b048201901c905060018184816109c4576109c46112a2565b048201901c905060018184816109dc576109dc6112a2565b048201901c905060018184816109f4576109f46112a2565b048201901c90506001818481610a0c57610a0c6112a2565b048201901c90506001818481610a2457610a246112a2565b048201901c905061021b81828581610a3e57610a3e6112a2565b04610ed8565b60005b81831015610a9a576000610a5b8484610eee565b60008781526020902090915063ffffffff86169082015463ffffffff161115610a8657809250610a94565b610a91816001611273565b93505b50610a47565b509392505050565b600061021b8284611273565b600080610ad985610ad4610ac18861082c565b6001600160e01b0316868863ffffffff16565b610f09565b915091505b935093915050565b600061021b828461128b565b816001600160a01b0316836001600160a01b031614158015610b145750600081115b1561079f576001600160a01b03831615610ba2576001600160a01b03831660009081526001602052604081208190610b4f90610ae685610aae565b91509150846001600160a01b03167fdec2bacdd2f05b59de34da9b523dff8be42e5e38e818c82fdb0bae774387a7248383604051610b97929190918252602082015260400190565b60405180910390a250505b6001600160a01b0382161561079f576001600160a01b03821660009081526001602052604081208190610bd890610aa285610aae565b91509150836001600160a01b03167fdec2bacdd2f05b59de34da9b523dff8be42e5e38e818c82fdb0bae774387a7248383604051610c20929190918252602082015260400190565b60405180910390a25050505050565b6000807f7fffffffffffffffffffffffffffffff5d576e7357a4501ddfe92f46681b20a0831115610c665750600090506003610cea565b6040805160008082526020820180845289905260ff881692820192909252606081018690526080810185905260019060a0016020604051602081039080840390855afa158015610cba573d6000803e3d6000fd5b5050604051601f1901519150506001600160a01b038116610ce357600060019250925050610cea565b9150600090505b94509492505050565b6000816004811115610d0757610d076112b8565b1415610d105750565b6001816004811115610d2457610d246112b8565b1415610d725760405162461bcd60e51b815260206004820152601860248201527f45434453413a20696e76616c6964207369676e617475726500000000000000006044820152606401610353565b6002816004811115610d8657610d866112b8565b1415610dd45760405162461bcd60e51b815260206004820152601f60248201527f45434453413a20696e76616c6964207369676e6174757265206c656e677468006044820152606401610353565b6003816004811115610de857610de86112b8565b1415610e415760405162461bcd60e51b815260206004820152602260248201527f45434453413a20696e76616c6964207369676e6174757265202773272076616c604482015261756560f01b6064820152608401610353565b50565b600080608083901c15610e5957608092831c92015b604083901c15610e6b57604092831c92015b602083901c15610e7d57602092831c92015b601083901c15610e8f57601092831c92015b600883901c15610ea157600892831c92015b600483901c15610eb357600492831c92015b600283901c15610ec557600292831c92015b600183901c156102f65760010192915050565b6000818310610ee7578161021b565b5090919050565b6000610efd60028484186112ce565b61021b90848416611273565b600080610f2784610f19436108f6565b610f2286610f3d565b610fa6565b6001600160e01b03918216969116945092505050565b60006001600160e01b0382111561095b5760405162461bcd60e51b815260206004820152602760248201527f53616665436173743a2076616c756520646f65736e27742066697420696e20326044820152663234206269747360c81b6064820152608401610353565b8254600090819080156110f6576000610fc4876106f260018561128b565b60408051808201909152905463ffffffff8082168084526401000000009092046001600160e01b0316602084015291925090871610156110465760405162461bcd60e51b815260206004820152601760248201527f436865636b706f696e743a20696e76616c6964206b65790000000000000000006044820152606401610353565b8563ffffffff16816000015163ffffffff161415611096578461106e886106f260018661128b565b80546001600160e01b03929092166401000000000263ffffffff9092169190911790556110e6565b6040805180820190915263ffffffff80881682526001600160e01b0380881660208085019182528b54600181018d5560008d81529190912094519151909216640100000000029216919091179101555b602001519250839150610ade9050565b50506040805180820190915263ffffffff80851682526001600160e01b0380851660208085019182528854600181018a5560008a815291822095519251909316640100000000029190931617920191909155905081610ade565b80356001600160a01b038116811461116757600080fd5b919050565b6000806040838503121561117f57600080fd5b61118883611150565b946020939093013593505050565b6000602082840312156111a857600080fd5b5035919050565b6000602082840312156111c157600080fd5b61021b82611150565b600080604083850312156111dd57600080fd5b6111e683611150565b91506111f460208401611150565b90509250929050565b60008060008060008060c0878903121561121657600080fd5b61121f87611150565b95506020870135945060408701359350606087013560ff8116811461124357600080fd5b9598949750929560808101359460a0909101359350915050565b634e487b7160e01b600052601160045260246000fd5b600082198211156112865761128661125d565b500190565b60008282101561129d5761129d61125d565b500390565b634e487b7160e01b600052601260045260246000fd5b634e487b7160e01b600052602160045260246000fd5b6000826112eb57634e487b7160e01b600052601260045260246000fd5b50049056fea26469706673582212202151a09be4cc1d40ae1770948e0b7e5e559f77b7867bb6d6dbffa075b2ded3f964736f6c63430008090033";

    public static final String FUNC_DOMAIN_SEPARATOR = "DOMAIN_SEPARATOR";

    public static final String FUNC_BURN = "burn";

    public static final String FUNC_delegate = "delegate";

    public static final String FUNC_DELEGATEBYSIG = "delegateBySig";

    public static final String FUNC_DELEGATES = "delegates";

    public static final String FUNC_GETCHAINID = "getChainId";

    public static final String FUNC_GETPASTTOTALSUPPLY = "getPastTotalSupply";

    public static final String FUNC_GETPASTVOTES = "getPastVotes";

    public static final String FUNC_GETTOTALSUPPLY = "getTotalSupply";

    public static final String FUNC_GETVOTES = "getVotes";

    public static final String FUNC_MINT = "mint";

    public static final String FUNC_NONCES = "nonces";

    public static final Event DELEGATECHANGED_EVENT = new Event("DelegateChanged", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event DELEGATEVOTESCHANGED_EVENT = new Event("DelegateVotesChanged", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected VotesMock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected VotesMock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected VotesMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected VotesMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<DelegateChangedEventResponse> getDelegateChangedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(DELEGATECHANGED_EVENT, transactionReceipt);
        ArrayList<DelegateChangedEventResponse> responses = new ArrayList<DelegateChangedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            DelegateChangedEventResponse typedResponse = new DelegateChangedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.delegator = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.fromDelegate = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.toDelegate = (String) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<DelegateChangedEventResponse> delegateChangedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, DelegateChangedEventResponse>() {
            @Override
            public DelegateChangedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(DELEGATECHANGED_EVENT, log);
                DelegateChangedEventResponse typedResponse = new DelegateChangedEventResponse();
                typedResponse.log = log;
                typedResponse.delegator = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.fromDelegate = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.toDelegate = (String) eventValues.getIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<DelegateChangedEventResponse> delegateChangedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(DELEGATECHANGED_EVENT));
        return delegateChangedEventFlowable(filter);
    }

    public static List<DelegateVotesChangedEventResponse> getDelegateVotesChangedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(DELEGATEVOTESCHANGED_EVENT, transactionReceipt);
        ArrayList<DelegateVotesChangedEventResponse> responses = new ArrayList<DelegateVotesChangedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            DelegateVotesChangedEventResponse typedResponse = new DelegateVotesChangedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.delegate = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.previousBalance = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.newBalance = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<DelegateVotesChangedEventResponse> delegateVotesChangedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, DelegateVotesChangedEventResponse>() {
            @Override
            public DelegateVotesChangedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(DELEGATEVOTESCHANGED_EVENT, log);
                DelegateVotesChangedEventResponse typedResponse = new DelegateVotesChangedEventResponse();
                typedResponse.log = log;
                typedResponse.delegate = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.previousBalance = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.newBalance = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<DelegateVotesChangedEventResponse> delegateVotesChangedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(DELEGATEVOTESCHANGED_EVENT));
        return delegateVotesChangedEventFlowable(filter);
    }

    public RemoteFunctionCall<byte[]> DOMAIN_SEPARATOR() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_DOMAIN_SEPARATOR, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<TransactionReceipt> burn(BigInteger voteId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_BURN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(voteId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> delegate(String delegatee) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_delegate, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, delegatee)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> delegate(String account, String newDelegation) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_delegate, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, account), 
                new org.web3j.abi.datatypes.Address(160, newDelegation)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> delegateBySig(String delegatee, BigInteger nonce, BigInteger expiry, BigInteger v, byte[] r, byte[] s) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_DELEGATEBYSIG, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, delegatee), 
                new org.web3j.abi.datatypes.generated.Uint256(nonce), 
                new org.web3j.abi.datatypes.generated.Uint256(expiry), 
                new org.web3j.abi.datatypes.generated.Uint8(v), 
                new org.web3j.abi.datatypes.generated.Bytes32(r), 
                new org.web3j.abi.datatypes.generated.Bytes32(s)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> delegates(String account) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_DELEGATES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, account)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> getChainId() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETCHAINID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getPastTotalSupply(BigInteger blockNumber) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETPASTTOTALSUPPLY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(blockNumber)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getPastVotes(String account, BigInteger blockNumber) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETPASTVOTES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, account), 
                new org.web3j.abi.datatypes.generated.Uint256(blockNumber)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getTotalSupply() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETTOTALSUPPLY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getVotes(String account) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETVOTES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, account)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> mint(String account, BigInteger voteId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_MINT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, account), 
                new org.web3j.abi.datatypes.generated.Uint256(voteId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> nonces(String owner) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_NONCES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, owner)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static VotesMock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new VotesMock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static VotesMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new VotesMock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static VotesMock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new VotesMock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static VotesMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new VotesMock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<VotesMock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String name) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name)));
        return deployRemoteCall(VotesMock.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<VotesMock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String name) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name)));
        return deployRemoteCall(VotesMock.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<VotesMock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String name) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name)));
        return deployRemoteCall(VotesMock.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<VotesMock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String name) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name)));
        return deployRemoteCall(VotesMock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class DelegateChangedEventResponse extends BaseEventResponse {
        public String delegator;

        public String fromDelegate;

        public String toDelegate;
    }

    public static class DelegateVotesChangedEventResponse extends BaseEventResponse {
        public String delegate;

        public BigInteger previousBalance;

        public BigInteger newBalance;
    }
}
