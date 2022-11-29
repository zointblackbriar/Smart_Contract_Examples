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
public class ERC4626Mock extends Contract {
    public static final String BINARY = "60c06040523480156200001157600080fd5b5060405162001a9138038062001a9183398101604081905262000034916200032d565b82828281600390805190602001906200004f929190620001ad565b50805162000065906004906020840190620001ad565b5050506000806200007c83620000c160201b60201c565b9150915081620000a1576200009b620001a860201b620008c81760201c565b620000a3565b805b60ff1660a05250506001600160a01b0316608052506200042c915050565b60408051600481526024810182526020810180516001600160e01b031663313ce56760e01b17905290516000918291829182916001600160a01b038716916200010a91620003b7565b6000604051808303816000865af19150503d806000811462000149576040519150601f19603f3d011682016040523d82523d6000602084013e6200014e565b606091505b50915091508180156200016357506020815110155b156200019b57600081806020019051810190620001819190620003d5565b905060ff811162000199576001969095509350505050565b505b5060009485945092505050565b601290565b828054620001bb90620003ef565b90600052602060002090601f016020900481019282620001df57600085556200022a565b82601f10620001fa57805160ff19168380011785556200022a565b828001600101855582156200022a579182015b828111156200022a5782518255916020019190600101906200020d565b50620002389291506200023c565b5090565b5b808211156200023857600081556001016200023d565b634e487b7160e01b600052604160045260246000fd5b60005b83811015620002865781810151838201526020016200026c565b8381111562000296576000848401525b50505050565b600082601f830112620002ae57600080fd5b81516001600160401b0380821115620002cb57620002cb62000253565b604051601f8301601f19908116603f01168101908282118183101715620002f657620002f662000253565b816040528381528660208588010111156200031057600080fd5b6200032384602083016020890162000269565b9695505050505050565b6000806000606084860312156200034357600080fd5b83516001600160a01b03811681146200035b57600080fd5b60208501519093506001600160401b03808211156200037957600080fd5b62000387878388016200029c565b935060408601519150808211156200039e57600080fd5b50620003ad868287016200029c565b9150509250925092565b60008251620003cb81846020870162000269565b9190910192915050565b600060208284031215620003e857600080fd5b5051919050565b600181811c908216806200040457607f821691505b602082108114156200042657634e487b7160e01b600052602260045260246000fd5b50919050565b60805160a05161162a62000467600039600061026f0152600081816102bb0152818161044d01528181610e820152610f42015261162a6000f3fe608060405234801561001057600080fd5b50600436106101cf5760003560e01c80636e553f6511610104578063b460af94116100a2578063ce96cb7711610071578063ce96cb77146103fc578063d905777e1461040f578063dd62ed3e14610422578063ef8b30f7146103e957600080fd5b8063b460af94146103ae578063ba087652146103c1578063c63d75b6146103d4578063c6e6f592146103e957600080fd5b806395d89b41116100de57806395d89b411461036d578063a457c2d714610375578063a9059cbb14610388578063b3d7f6b91461039b57600080fd5b80636e553f651461031e57806370a082311461033157806394bf804d1461035a57600080fd5b8063313ce56711610171578063395093511161014b57806339509351146102e5578063402d267d146102f8578063492dc9381461030b5780634cdad5061461020457600080fd5b8063313ce56714610268578063378934b41461029957806338d52e0f146102ae57600080fd5b8063095ea7b3116101ad578063095ea7b3146102175780630a28a4771461023a57806318160ddd1461024d57806323b872dd1461025557600080fd5b806301e1d114146101d457806306fdde03146101ef57806307a2d13a14610204575b600080fd5b6101dc610435565b6040519081526020015b60405180910390f35b6101f76104d4565b6040516101e69190611395565b6101dc6102123660046113c8565b610566565b61022a6102253660046113fd565b610579565b60405190151581526020016101e6565b6101dc6102483660046113c8565b610591565b6002546101dc565b61022a610263366004611427565b61059e565b60405160ff7f00000000000000000000000000000000000000000000000000000000000000001681526020016101e6565b6102ac6102a73660046113fd565b6105c4565b005b6040516001600160a01b037f00000000000000000000000000000000000000000000000000000000000000001681526020016101e6565b61022a6102f33660046113fd565b6105d2565b6101dc610306366004611463565b6105f4565b6102ac6103193660046113fd565b610612565b6101dc61032c36600461147e565b61061c565b6101dc61033f366004611463565b6001600160a01b031660009081526020819052604090205490565b6101dc61036836600461147e565b610694565b6101f76106ae565b61022a6103833660046113fd565b6106bd565b61022a6103963660046113fd565b610743565b6101dc6103a93660046113c8565b610751565b6101dc6103bc3660046114aa565b61075e565b6101dc6103cf3660046114aa565b6107da565b6101dc6103e2366004611463565b5060001990565b6101dc6103f73660046113c8565b61084e565b6101dc61040a366004611463565b61085b565b6101dc61041d366004611463565b61087f565b6101dc6104303660046114e6565b61089d565b6040516370a0823160e01b81523060048201526000907f00000000000000000000000000000000000000000000000000000000000000006001600160a01b0316906370a082319060240160206040518083038186803b15801561049757600080fd5b505afa1580156104ab573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906104cf9190611510565b905090565b6060600380546104e390611529565b80601f016020809104026020016040519081016040528092919081815260200182805461050f90611529565b801561055c5780601f106105315761010080835404028352916020019161055c565b820191906000526020600020905b81548152906001019060200180831161053f57829003601f168201915b5050505050905090565b60006105738260006108cd565b92915050565b600033610587818585610900565b5060019392505050565b6000610573826001610a25565b6000336105ac858285610a57565b6105b7858585610ad1565b60019150505b9392505050565b6105ce8282610c75565b5050565b6000336105878185856105e5838361089d565b6105ef9190611564565b610900565b60006105fe610d34565b610609576000610573565b60001992915050565b6105ce8282610d4e565b6000610627826105f4565b83111561067b5760405162461bcd60e51b815260206004820152601e60248201527f455243343632363a206465706f736974206d6f7265207468616e206d6178000060448201526064015b60405180910390fd5b60006106868461084e565b90506105bd33848684610e7d565b6000806106a084610751565b90506105bd33848387610e7d565b6060600480546104e390611529565b600033816106cb828661089d565b90508381101561072b5760405162461bcd60e51b815260206004820152602560248201527f45524332303a2064656372656173656420616c6c6f77616e63652062656c6f77604482015264207a65726f60d81b6064820152608401610672565b6107388286868403610900565b506001949350505050565b600033610587818585610ad1565b60006105738260016108cd565b60006107698261085b565b8411156107b85760405162461bcd60e51b815260206004820152601f60248201527f455243343632363a207769746864726177206d6f7265207468616e206d6178006044820152606401610672565b60006107c385610591565b90506107d23385858885610f0f565b949350505050565b60006107e58261087f565b8411156108345760405162461bcd60e51b815260206004820152601d60248201527f455243343632363a2072656465656d206d6f7265207468616e206d61780000006044820152606401610672565b600061083f85610566565b90506107d23385858489610f0f565b6000610573826000610a25565b6001600160a01b0381166000908152602081905260408120546105739060006108cd565b6001600160a01b038116600090815260208190526040812054610573565b6001600160a01b03918216600090815260016020908152604080832093909416825291909152205490565b601290565b6000806108d960025490565b905080156108fa576108f56108ec610435565b85908386610fcf565b6107d2565b836107d2565b6001600160a01b0383166109625760405162461bcd60e51b8152602060048201526024808201527f45524332303a20617070726f76652066726f6d20746865207a65726f206164646044820152637265737360e01b6064820152608401610672565b6001600160a01b0382166109c35760405162461bcd60e51b815260206004820152602260248201527f45524332303a20617070726f766520746f20746865207a65726f206164647265604482015261737360f01b6064820152608401610672565b6001600160a01b0383811660008181526001602090815260408083209487168084529482529182902085905590518481527f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b92591015b60405180910390a3505050565b600080610a3160025490565b9050831580610a3e575080155b6108fa576108f581610a4e610435565b86919086610fcf565b6000610a63848461089d565b90506000198114610acb5781811015610abe5760405162461bcd60e51b815260206004820152601d60248201527f45524332303a20696e73756666696369656e7420616c6c6f77616e63650000006044820152606401610672565b610acb8484848403610900565b50505050565b6001600160a01b038316610b355760405162461bcd60e51b815260206004820152602560248201527f45524332303a207472616e736665722066726f6d20746865207a65726f206164604482015264647265737360d81b6064820152608401610672565b6001600160a01b038216610b975760405162461bcd60e51b815260206004820152602360248201527f45524332303a207472616e7366657220746f20746865207a65726f206164647260448201526265737360e81b6064820152608401610672565b6001600160a01b03831660009081526020819052604090205481811015610c0f5760405162461bcd60e51b815260206004820152602660248201527f45524332303a207472616e7366657220616d6f756e7420657863656564732062604482015265616c616e636560d01b6064820152608401610672565b6001600160a01b03848116600081815260208181526040808320878703905593871680835291849020805487019055925185815290927fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef910160405180910390a3610acb565b6001600160a01b038216610ccb5760405162461bcd60e51b815260206004820152601f60248201527f45524332303a206d696e7420746f20746865207a65726f2061646472657373006044820152606401610672565b8060026000828254610cdd9190611564565b90915550506001600160a01b038216600081815260208181526040808320805486019055518481527fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef910160405180910390a35050565b600080610d3f610435565b11806104cf5750506002541590565b6001600160a01b038216610dae5760405162461bcd60e51b815260206004820152602160248201527f45524332303a206275726e2066726f6d20746865207a65726f206164647265736044820152607360f81b6064820152608401610672565b6001600160a01b03821660009081526020819052604090205481811015610e225760405162461bcd60e51b815260206004820152602260248201527f45524332303a206275726e20616d6f756e7420657863656564732062616c616e604482015261636560f01b6064820152608401610672565b6001600160a01b0383166000818152602081815260408083208686039055600280548790039055518581529192917fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef9101610a18565b505050565b610ea97f000000000000000000000000000000000000000000000000000000000000000085308561102c565b610eb38382610c75565b826001600160a01b0316846001600160a01b03167fdcbc1c05240f31ff3ad067ef1ee35ce4997762752e3a095284754544f4c709d78484604051610f01929190918252602082015260400190565b60405180910390a350505050565b826001600160a01b0316856001600160a01b031614610f3357610f33838683610a57565b610f3d8382610d4e565b610f687f00000000000000000000000000000000000000000000000000000000000000008584611097565b826001600160a01b0316846001600160a01b0316866001600160a01b03167ffbde797d201c681b91056529119e0b02407c7bb96a4a2c75c01fc9667232c8db8585604051610fc0929190918252602082015260400190565b60405180910390a45050505050565b600080610fdd8686866110c7565b90506001836002811115610ff357610ff361158a565b14801561101057506000848061100b5761100b6115a0565b868809115b1561102357611020600182611564565b90505b95945050505050565b6040516001600160a01b0380851660248301528316604482015260648101829052610acb9085906323b872dd60e01b906084015b60408051601f198184030181529190526020810180516001600160e01b03166001600160e01b031990931692909217909152611177565b6040516001600160a01b038316602482015260448101829052610e7890849063a9059cbb60e01b90606401611060565b600080806000198587098587029250828110838203039150508060001415611102578382816110f8576110f86115a0565b04925050506105bd565b80841161110e57600080fd5b60008486880960026001871981018816978890046003810283188082028403028082028403028082028403028082028403028082028403029081029092039091026000889003889004909101858311909403939093029303949094049190911702949350505050565b60006111cc826040518060400160405280602081526020017f5361666545524332303a206c6f772d6c6576656c2063616c6c206661696c6564815250856001600160a01b03166112499092919063ffffffff16565b805190915015610e7857808060200190518101906111ea91906115b6565b610e785760405162461bcd60e51b815260206004820152602a60248201527f5361666545524332303a204552433230206f7065726174696f6e20646964206e6044820152691bdd081cdd58d8d9595960b21b6064820152608401610672565b60606107d2848460008585600080866001600160a01b0316858760405161127091906115d8565b60006040518083038185875af1925050503d80600081146112ad576040519150601f19603f3d011682016040523d82523d6000602084013e6112b2565b606091505b50915091506112c3878383876112ce565b979650505050505050565b6060831561133a578251611333576001600160a01b0385163b6113335760405162461bcd60e51b815260206004820152601d60248201527f416464726573733a2063616c6c20746f206e6f6e2d636f6e74726163740000006044820152606401610672565b50816107d2565b6107d2838381511561134f5781518083602001fd5b8060405162461bcd60e51b81526004016106729190611395565b60005b8381101561138457818101518382015260200161136c565b83811115610acb5750506000910152565b60208152600082518060208401526113b4816040850160208701611369565b601f01601f19169190910160400192915050565b6000602082840312156113da57600080fd5b5035919050565b80356001600160a01b03811681146113f857600080fd5b919050565b6000806040838503121561141057600080fd5b611419836113e1565b946020939093013593505050565b60008060006060848603121561143c57600080fd5b611445846113e1565b9250611453602085016113e1565b9150604084013590509250925092565b60006020828403121561147557600080fd5b6105bd826113e1565b6000806040838503121561149157600080fd5b823591506114a1602084016113e1565b90509250929050565b6000806000606084860312156114bf57600080fd5b833592506114cf602085016113e1565b91506114dd604085016113e1565b90509250925092565b600080604083850312156114f957600080fd5b611502836113e1565b91506114a1602084016113e1565b60006020828403121561152257600080fd5b5051919050565b600181811c9082168061153d57607f821691505b6020821081141561155e57634e487b7160e01b600052602260045260246000fd5b50919050565b6000821982111561158557634e487b7160e01b600052601160045260246000fd5b500190565b634e487b7160e01b600052602160045260246000fd5b634e487b7160e01b600052601260045260246000fd5b6000602082840312156115c857600080fd5b815180151581146105bd57600080fd5b600082516115ea818460208701611369565b919091019291505056fea26469706673582212205b46ec26d25688e331361dd15e209b64d30dd998cf05186462ceb9ea509d828c64736f6c63430008090033";

    public static final String FUNC_ALLOWANCE = "allowance";

    public static final String FUNC_APPROVE = "approve";

    public static final String FUNC_ASSET = "asset";

    public static final String FUNC_BALANCEOF = "balanceOf";

    public static final String FUNC_CONVERTTOASSETS = "convertToAssets";

    public static final String FUNC_CONVERTTOSHARES = "convertToShares";

    public static final String FUNC_DECIMALS = "decimals";

    public static final String FUNC_DECREASEALLOWANCE = "decreaseAllowance";

    public static final String FUNC_DEPOSIT = "deposit";

    public static final String FUNC_INCREASEALLOWANCE = "increaseAllowance";

    public static final String FUNC_MAXDEPOSIT = "maxDeposit";

    public static final String FUNC_MAXMINT = "maxMint";

    public static final String FUNC_MAXREDEEM = "maxRedeem";

    public static final String FUNC_MAXWITHDRAW = "maxWithdraw";

    public static final String FUNC_MINT = "mint";

    public static final String FUNC_MOCKBURN = "mockBurn";

    public static final String FUNC_MOCKMINT = "mockMint";

    public static final String FUNC_NAME = "name";

    public static final String FUNC_PREVIEWDEPOSIT = "previewDeposit";

    public static final String FUNC_PREVIEWMINT = "previewMint";

    public static final String FUNC_PREVIEWREDEEM = "previewRedeem";

    public static final String FUNC_PREVIEWWITHDRAW = "previewWithdraw";

    public static final String FUNC_REDEEM = "redeem";

    public static final String FUNC_SYMBOL = "symbol";

    public static final String FUNC_TOTALASSETS = "totalAssets";

    public static final String FUNC_TOTALSUPPLY = "totalSupply";

    public static final String FUNC_TRANSFER = "transfer";

    public static final String FUNC_TRANSFERFROM = "transferFrom";

    public static final String FUNC_WITHDRAW = "withdraw";

    public static final Event APPROVAL_EVENT = new Event("Approval", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event DEPOSIT_EVENT = new Event("Deposit", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event TRANSFER_EVENT = new Event("Transfer", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event WITHDRAW_EVENT = new Event("Withdraw", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected ERC4626Mock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ERC4626Mock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ERC4626Mock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ERC4626Mock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
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

    public static List<DepositEventResponse> getDepositEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(DEPOSIT_EVENT, transactionReceipt);
        ArrayList<DepositEventResponse> responses = new ArrayList<DepositEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            DepositEventResponse typedResponse = new DepositEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.sender = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.owner = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.assets = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.shares = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<DepositEventResponse> depositEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, DepositEventResponse>() {
            @Override
            public DepositEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(DEPOSIT_EVENT, log);
                DepositEventResponse typedResponse = new DepositEventResponse();
                typedResponse.log = log;
                typedResponse.sender = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.owner = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.assets = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.shares = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<DepositEventResponse> depositEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(DEPOSIT_EVENT));
        return depositEventFlowable(filter);
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

    public static List<WithdrawEventResponse> getWithdrawEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(WITHDRAW_EVENT, transactionReceipt);
        ArrayList<WithdrawEventResponse> responses = new ArrayList<WithdrawEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            WithdrawEventResponse typedResponse = new WithdrawEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.sender = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.receiver = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.owner = (String) eventValues.getIndexedValues().get(2).getValue();
            typedResponse.assets = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.shares = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<WithdrawEventResponse> withdrawEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, WithdrawEventResponse>() {
            @Override
            public WithdrawEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(WITHDRAW_EVENT, log);
                WithdrawEventResponse typedResponse = new WithdrawEventResponse();
                typedResponse.log = log;
                typedResponse.sender = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.receiver = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.owner = (String) eventValues.getIndexedValues().get(2).getValue();
                typedResponse.assets = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.shares = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<WithdrawEventResponse> withdrawEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(WITHDRAW_EVENT));
        return withdrawEventFlowable(filter);
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

    public RemoteFunctionCall<String> asset() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ASSET, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> balanceOf(String account) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_BALANCEOF, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, account)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> convertToAssets(BigInteger shares) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_CONVERTTOASSETS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(shares)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> convertToShares(BigInteger assets) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_CONVERTTOSHARES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(assets)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
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

    public RemoteFunctionCall<TransactionReceipt> deposit(BigInteger assets, String receiver) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_DEPOSIT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(assets), 
                new org.web3j.abi.datatypes.Address(160, receiver)), 
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

    public RemoteFunctionCall<BigInteger> maxDeposit(String param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_MAXDEPOSIT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> maxMint(String param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_MAXMINT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> maxRedeem(String owner) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_MAXREDEEM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, owner)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> maxWithdraw(String owner) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_MAXWITHDRAW, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, owner)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> mint(BigInteger shares, String receiver) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_MINT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(shares), 
                new org.web3j.abi.datatypes.Address(160, receiver)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> mockBurn(String account, BigInteger amount) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_MOCKBURN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, account), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> mockMint(String account, BigInteger amount) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_MOCKMINT, 
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

    public RemoteFunctionCall<BigInteger> previewDeposit(BigInteger assets) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_PREVIEWDEPOSIT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(assets)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> previewMint(BigInteger shares) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_PREVIEWMINT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(shares)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> previewRedeem(BigInteger shares) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_PREVIEWREDEEM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(shares)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> previewWithdraw(BigInteger assets) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_PREVIEWWITHDRAW, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(assets)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> redeem(BigInteger shares, String receiver, String owner) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_REDEEM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(shares), 
                new org.web3j.abi.datatypes.Address(160, receiver), 
                new org.web3j.abi.datatypes.Address(160, owner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> symbol() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_SYMBOL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> totalAssets() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_TOTALASSETS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> totalSupply() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_TOTALSUPPLY, 
                Arrays.<Type>asList(), 
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

    public RemoteFunctionCall<TransactionReceipt> withdraw(BigInteger assets, String receiver, String owner) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_WITHDRAW, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(assets), 
                new org.web3j.abi.datatypes.Address(160, receiver), 
                new org.web3j.abi.datatypes.Address(160, owner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static ERC4626Mock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ERC4626Mock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ERC4626Mock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ERC4626Mock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ERC4626Mock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ERC4626Mock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ERC4626Mock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ERC4626Mock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ERC4626Mock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String asset, String name, String symbol) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, asset), 
                new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.Utf8String(symbol)));
        return deployRemoteCall(ERC4626Mock.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<ERC4626Mock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String asset, String name, String symbol) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, asset), 
                new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.Utf8String(symbol)));
        return deployRemoteCall(ERC4626Mock.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ERC4626Mock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String asset, String name, String symbol) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, asset), 
                new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.Utf8String(symbol)));
        return deployRemoteCall(ERC4626Mock.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ERC4626Mock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String asset, String name, String symbol) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, asset), 
                new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.Utf8String(symbol)));
        return deployRemoteCall(ERC4626Mock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class ApprovalEventResponse extends BaseEventResponse {
        public String owner;

        public String spender;

        public BigInteger value;
    }

    public static class DepositEventResponse extends BaseEventResponse {
        public String sender;

        public String owner;

        public BigInteger assets;

        public BigInteger shares;
    }

    public static class TransferEventResponse extends BaseEventResponse {
        public String from;

        public String to;

        public BigInteger value;
    }

    public static class WithdrawEventResponse extends BaseEventResponse {
        public String sender;

        public String receiver;

        public String owner;

        public BigInteger assets;

        public BigInteger shares;
    }
}
