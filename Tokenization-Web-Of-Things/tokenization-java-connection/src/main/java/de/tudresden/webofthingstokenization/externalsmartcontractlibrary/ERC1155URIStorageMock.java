package de.tudresden.webofthingstokenization.externalsmartcontractlibrary;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Array;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
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
public class ERC1155URIStorageMock extends Contract {
    public static final String BINARY = "60a06040819052600060808190526200001b916003916200007b565b503480156200002957600080fd5b5060405162002199380380620021998339810160408190526200004c9162000137565b8080620000598162000062565b50505062000250565b8051620000779060029060208401906200007b565b5050565b828054620000899062000213565b90600052602060002090601f016020900481019282620000ad5760008555620000f8565b82601f10620000c857805160ff1916838001178555620000f8565b82800160010185558215620000f8579182015b82811115620000f8578251825591602001919060010190620000db565b50620001069291506200010a565b5090565b5b808211156200010657600081556001016200010b565b634e487b7160e01b600052604160045260246000fd5b600060208083850312156200014b57600080fd5b82516001600160401b03808211156200016357600080fd5b818501915085601f8301126200017857600080fd5b8151818111156200018d576200018d62000121565b604051601f8201601f19908116603f01168101908382118183101715620001b857620001b862000121565b816040528281528886848701011115620001d157600080fd5b600093505b82841015620001f55784840186015181850187015292850192620001d6565b82841115620002075760008684830101525b98975050505050505050565b600181811c908216806200022857607f821691505b602082108114156200024a57634e487b7160e01b600052602260045260246000fd5b50919050565b611f3980620002606000396000f3fe608060405234801561001057600080fd5b50600436106100f45760003560e01c806355f804b311610097578063a22cb46511610066578063a22cb46514610209578063e985e9c51461021c578063f242432a14610258578063f5298aca1461026b57600080fd5b806355f804b3146101bd5780636b20c454146101d0578063731133e9146101e3578063862440e2146101f657600080fd5b80630e89341c116100d35780630e89341c146101575780631f7fdffa146101775780632eb2c2d61461018a5780634e1273f41461019d57600080fd5b8062fdd58e146100f957806301ffc9a71461011f57806302fe530514610142575b600080fd5b61010c61010736600461131f565b61027e565b6040519081526020015b60405180910390f35b61013261012d36600461135f565b610314565b6040519015158152602001610116565b610155610150366004611431565b610366565b005b61016a61016536600461146d565b610372565b60405161011691906114de565b610155610185366004611585565b61037d565b61015561019836600461161d565b61038f565b6101b06101ab3660046116c6565b6103db565b60405161011691906117cb565b6101556101cb366004611431565b610504565b6101556101de3660046117de565b61050d565b6101556101f1366004611851565b61051d565b6101556102043660046118a5565b610529565b6101556102173660046118e1565b610537565b61013261022a36600461191d565b6001600160a01b03918216600090815260016020908152604080832093909416825291909152205460ff1690565b610155610266366004611950565b610542565b6101556102793660046119b4565b610587565b60006001600160a01b0383166102ee5760405162461bcd60e51b815260206004820152602a60248201527f455243313135353a2061646472657373207a65726f206973206e6f742061207660448201526930b634b21037bbb732b960b11b60648201526084015b60405180910390fd5b506000908152602081815260408083206001600160a01b03949094168352929052205490565b60006001600160e01b03198216636cdb3d1360e11b148061034557506001600160e01b031982166303a24d0760e21b145b8061036057506301ffc9a760e01b6001600160e01b03198316145b92915050565b61036f81610592565b50565b6060610360826105a5565b61038984848484610685565b50505050565b6001600160a01b0385163314806103ab57506103ab853361022a565b6103c75760405162461bcd60e51b81526004016102e5906119e7565b6103d485858585856107d0565b5050505050565b606081518351146104405760405162461bcd60e51b815260206004820152602960248201527f455243313135353a206163636f756e747320616e6420696473206c656e677468604482015268040dad2e6dac2e8c6d60bb1b60648201526084016102e5565b600083516001600160401b0381111561045b5761045b61137c565b604051908082528060200260200182016040528015610484578160200160208202803683370190505b50905060005b84518110156104fc576104cf8582815181106104a8576104a8611a35565b60200260200101518583815181106104c2576104c2611a35565b602002602001015161027e565b8282815181106104e1576104e1611a35565b60209081029190910101526104f581611a61565b905061048a565b509392505050565b61036f8161096c565b61051883838361097f565b505050565b61038984848484610b09565b6105338282610be3565b5050565b610533338383610c47565b6001600160a01b03851633148061055e575061055e853361022a565b61057a5760405162461bcd60e51b81526004016102e5906119e7565b6103d48585858585610d28565b610518838383610e52565b805161053390600290602084019061126a565b6000818152600460205260408120805460609291906105c390611a7c565b80601f01602080910402602001604051908101604052809291908181526020018280546105ef90611a7c565b801561063c5780601f106106115761010080835404028352916020019161063c565b820191906000526020600020905b81548152906001019060200180831161061f57829003601f168201915b50505050509050600081511161065a5761065583610f56565b61067e565b60038160405160200161066e929190611ad3565b6040516020818303038152906040525b9392505050565b6001600160a01b0384166106ab5760405162461bcd60e51b81526004016102e590611b7a565b81518351146106cc5760405162461bcd60e51b81526004016102e590611bbb565b3360005b8451811015610768578381815181106106eb576106eb611a35565b602002602001015160008087848151811061070857610708611a35565b602002602001015181526020019081526020016000206000886001600160a01b03166001600160a01b0316815260200190815260200160002060008282546107509190611c03565b9091555081905061076081611a61565b9150506106d0565b50846001600160a01b031660006001600160a01b0316826001600160a01b03167f4a39dc06d4c0dbc64b70af90fd698a233a518aa5d07e595d983b8c0526c8f7fb87876040516107b9929190611c1b565b60405180910390a46103d481600087878787610fea565b81518351146107f15760405162461bcd60e51b81526004016102e590611bbb565b6001600160a01b0384166108175760405162461bcd60e51b81526004016102e590611c40565b3360005b84518110156108fe57600085828151811061083857610838611a35565b60200260200101519050600085838151811061085657610856611a35565b602090810291909101810151600084815280835260408082206001600160a01b038e1683529093529190912054909150818110156108a65760405162461bcd60e51b81526004016102e590611c85565b6000838152602081815260408083206001600160a01b038e8116855292528083208585039055908b168252812080548492906108e3908490611c03565b92505081905550505050806108f790611a61565b905061081b565b50846001600160a01b0316866001600160a01b0316826001600160a01b03167f4a39dc06d4c0dbc64b70af90fd698a233a518aa5d07e595d983b8c0526c8f7fb878760405161094e929190611c1b565b60405180910390a4610964818787878787610fea565b505050505050565b805161053390600390602084019061126a565b6001600160a01b0383166109a55760405162461bcd60e51b81526004016102e590611ccf565b80518251146109c65760405162461bcd60e51b81526004016102e590611bbb565b604080516020810190915260009081905233905b8351811015610a9c5760008482815181106109f7576109f7611a35565b602002602001015190506000848381518110610a1557610a15611a35565b602090810291909101810151600084815280835260408082206001600160a01b038c168352909352919091205490915081811015610a655760405162461bcd60e51b81526004016102e590611d12565b6000928352602083815260408085206001600160a01b038b1686529091529092209103905580610a9481611a61565b9150506109da565b5060006001600160a01b0316846001600160a01b0316826001600160a01b03167f4a39dc06d4c0dbc64b70af90fd698a233a518aa5d07e595d983b8c0526c8f7fb8686604051610aed929190611c1b565b60405180910390a4604080516020810190915260009052610389565b6001600160a01b038416610b2f5760405162461bcd60e51b81526004016102e590611b7a565b336000610b3b85611155565b90506000610b4885611155565b90506000868152602081815260408083206001600160a01b038b16845290915281208054879290610b7a908490611c03565b909155505060408051878152602081018790526001600160a01b03808a1692600092918716917fc3d58168c5ae7397731d063d5bbf3d657854427343f4c083240f7aacaa2d0f62910160405180910390a4610bda836000898989896111a0565b50505050505050565b60008281526004602090815260409091208251610c029284019061126a565b50817f6bb7ff708619ba0610cba295a58592e0451dee2622938c8755667688daf3529b610c2e84610372565b604051610c3b91906114de565b60405180910390a25050565b816001600160a01b0316836001600160a01b03161415610cbb5760405162461bcd60e51b815260206004820152602960248201527f455243313135353a2073657474696e6720617070726f76616c20737461747573604482015268103337b91039b2b63360b91b60648201526084016102e5565b6001600160a01b03838116600081815260016020908152604080832094871680845294825291829020805460ff191686151590811790915591519182527f17307eab39ab6107e8899845ad3d59bd9653f200f220920489ca2b5937696c31910160405180910390a3505050565b6001600160a01b038416610d4e5760405162461bcd60e51b81526004016102e590611c40565b336000610d5a85611155565b90506000610d6785611155565b90506000868152602081815260408083206001600160a01b038c16845290915290205485811015610daa5760405162461bcd60e51b81526004016102e590611c85565b6000878152602081815260408083206001600160a01b038d8116855292528083208985039055908a16825281208054889290610de7908490611c03565b909155505060408051888152602081018890526001600160a01b03808b16928c821692918816917fc3d58168c5ae7397731d063d5bbf3d657854427343f4c083240f7aacaa2d0f62910160405180910390a4610e47848a8a8a8a8a6111a0565b505050505050505050565b6001600160a01b038316610e785760405162461bcd60e51b81526004016102e590611ccf565b336000610e8484611155565b90506000610e9184611155565b60408051602080820183526000918290528882528181528282206001600160a01b038b1683529052205490915084811015610ede5760405162461bcd60e51b81526004016102e590611d12565b6000868152602081815260408083206001600160a01b038b81168086529184528285208a8703905582518b81529384018a90529092908816917fc3d58168c5ae7397731d063d5bbf3d657854427343f4c083240f7aacaa2d0f62910160405180910390a4604080516020810190915260009052610bda565b606060028054610f6590611a7c565b80601f0160208091040260200160405190810160405280929190818152602001828054610f9190611a7c565b8015610fde5780601f10610fb357610100808354040283529160200191610fde565b820191906000526020600020905b815481529060010190602001808311610fc157829003601f168201915b50505050509050919050565b6001600160a01b0384163b156109645760405163bc197c8160e01b81526001600160a01b0385169063bc197c819061102e9089908990889088908890600401611d56565b602060405180830381600087803b15801561104857600080fd5b505af1925050508015611078575060408051601f3d908101601f1916820190925261107591810190611db4565b60015b61112557611084611dd1565b806308c379a014156110be5750611099611ded565b806110a457506110c0565b8060405162461bcd60e51b81526004016102e591906114de565b505b60405162461bcd60e51b815260206004820152603460248201527f455243313135353a207472616e7366657220746f206e6f6e2d455243313135356044820152732932b1b2b4bb32b91034b6b83632b6b2b73a32b960611b60648201526084016102e5565b6001600160e01b0319811663bc197c8160e01b14610bda5760405162461bcd60e51b81526004016102e590611e76565b6040805160018082528183019092526060916000919060208083019080368337019050509050828160008151811061118f5761118f611a35565b602090810291909101015292915050565b6001600160a01b0384163b156109645760405163f23a6e6160e01b81526001600160a01b0385169063f23a6e61906111e49089908990889088908890600401611ebe565b602060405180830381600087803b1580156111fe57600080fd5b505af192505050801561122e575060408051601f3d908101601f1916820190925261122b91810190611db4565b60015b61123a57611084611dd1565b6001600160e01b0319811663f23a6e6160e01b14610bda5760405162461bcd60e51b81526004016102e590611e76565b82805461127690611a7c565b90600052602060002090601f01602090048101928261129857600085556112de565b82601f106112b157805160ff19168380011785556112de565b828001600101855582156112de579182015b828111156112de5782518255916020019190600101906112c3565b506112ea9291506112ee565b5090565b5b808211156112ea57600081556001016112ef565b80356001600160a01b038116811461131a57600080fd5b919050565b6000806040838503121561133257600080fd5b61133b83611303565b946020939093013593505050565b6001600160e01b03198116811461036f57600080fd5b60006020828403121561137157600080fd5b813561067e81611349565b634e487b7160e01b600052604160045260246000fd5b601f8201601f191681016001600160401b03811182821017156113b7576113b761137c565b6040525050565b600082601f8301126113cf57600080fd5b81356001600160401b038111156113e8576113e861137c565b6040516113ff601f8301601f191660200182611392565b81815284602083860101111561141457600080fd5b816020850160208301376000918101602001919091529392505050565b60006020828403121561144357600080fd5b81356001600160401b0381111561145957600080fd5b611465848285016113be565b949350505050565b60006020828403121561147f57600080fd5b5035919050565b60005b838110156114a1578181015183820152602001611489565b838111156103895750506000910152565b600081518084526114ca816020860160208601611486565b601f01601f19169290920160200192915050565b60208152600061067e60208301846114b2565b60006001600160401b0382111561150a5761150a61137c565b5060051b60200190565b600082601f83011261152557600080fd5b81356020611532826114f1565b60405161153f8282611392565b83815260059390931b850182019282810191508684111561155f57600080fd5b8286015b8481101561157a5780358352918301918301611563565b509695505050505050565b6000806000806080858703121561159b57600080fd5b6115a485611303565b935060208501356001600160401b03808211156115c057600080fd5b6115cc88838901611514565b945060408701359150808211156115e257600080fd5b6115ee88838901611514565b9350606087013591508082111561160457600080fd5b50611611878288016113be565b91505092959194509250565b600080600080600060a0868803121561163557600080fd5b61163e86611303565b945061164c60208701611303565b935060408601356001600160401b038082111561166857600080fd5b61167489838a01611514565b9450606088013591508082111561168a57600080fd5b61169689838a01611514565b935060808801359150808211156116ac57600080fd5b506116b9888289016113be565b9150509295509295909350565b600080604083850312156116d957600080fd5b82356001600160401b03808211156116f057600080fd5b818501915085601f83011261170457600080fd5b81356020611711826114f1565b60405161171e8282611392565b83815260059390931b850182019282810191508984111561173e57600080fd5b948201945b838610156117635761175486611303565b82529482019490820190611743565b9650508601359250508082111561177957600080fd5b5061178685828601611514565b9150509250929050565b600081518084526020808501945080840160005b838110156117c0578151875295820195908201906001016117a4565b509495945050505050565b60208152600061067e6020830184611790565b6000806000606084860312156117f357600080fd5b6117fc84611303565b925060208401356001600160401b038082111561181857600080fd5b61182487838801611514565b9350604086013591508082111561183a57600080fd5b5061184786828701611514565b9150509250925092565b6000806000806080858703121561186757600080fd5b61187085611303565b9350602085013592506040850135915060608501356001600160401b0381111561189957600080fd5b611611878288016113be565b600080604083850312156118b857600080fd5b8235915060208301356001600160401b038111156118d557600080fd5b611786858286016113be565b600080604083850312156118f457600080fd5b6118fd83611303565b91506020830135801515811461191257600080fd5b809150509250929050565b6000806040838503121561193057600080fd5b61193983611303565b915061194760208401611303565b90509250929050565b600080600080600060a0868803121561196857600080fd5b61197186611303565b945061197f60208701611303565b9350604086013592506060860135915060808601356001600160401b038111156119a857600080fd5b6116b9888289016113be565b6000806000606084860312156119c957600080fd5b6119d284611303565b95602085013595506040909401359392505050565b6020808252602e908201527f455243313135353a2063616c6c6572206973206e6f7420746f6b656e206f776e60408201526d195c881bdc88185c1c1c9bdd995960921b606082015260800190565b634e487b7160e01b600052603260045260246000fd5b634e487b7160e01b600052601160045260246000fd5b6000600019821415611a7557611a75611a4b565b5060010190565b600181811c90821680611a9057607f821691505b60208210811415611ab157634e487b7160e01b600052602260045260246000fd5b50919050565b60008151611ac9818560208601611486565b9290920192915050565b600080845481600182811c915080831680611aef57607f831692505b6020808410821415611b0f57634e487b7160e01b86526022600452602486fd5b818015611b235760018114611b3457611b61565b60ff19861689528489019650611b61565b60008b81526020902060005b86811015611b595781548b820152908501908301611b40565b505084890196505b505050505050611b718185611ab7565b95945050505050565b60208082526021908201527f455243313135353a206d696e7420746f20746865207a65726f206164647265736040820152607360f81b606082015260800190565b60208082526028908201527f455243313135353a2069647320616e6420616d6f756e7473206c656e677468206040820152670dad2e6dac2e8c6d60c31b606082015260800190565b60008219821115611c1657611c16611a4b565b500190565b604081526000611c2e6040830185611790565b8281036020840152611b718185611790565b60208082526025908201527f455243313135353a207472616e7366657220746f20746865207a65726f206164604082015264647265737360d81b606082015260800190565b6020808252602a908201527f455243313135353a20696e73756666696369656e742062616c616e636520666f60408201526939103a3930b739b332b960b11b606082015260800190565b60208082526023908201527f455243313135353a206275726e2066726f6d20746865207a65726f206164647260408201526265737360e81b606082015260800190565b60208082526024908201527f455243313135353a206275726e20616d6f756e7420657863656564732062616c604082015263616e636560e01b606082015260800190565b6001600160a01b0386811682528516602082015260a060408201819052600090611d8290830186611790565b8281036060840152611d948186611790565b90508281036080840152611da881856114b2565b98975050505050505050565b600060208284031215611dc657600080fd5b815161067e81611349565b600060033d1115611dea5760046000803e5060005160e01c5b90565b600060443d1015611dfb5790565b6040516003193d81016004833e81513d6001600160401b038160248401118184111715611e2a57505050505090565b8285019150815181811115611e425750505050505090565b843d8701016020828501011115611e5c5750505050505090565b611e6b60208286010187611392565b509095945050505050565b60208082526028908201527f455243313135353a204552433131353552656365697665722072656a656374656040820152676420746f6b656e7360c01b606082015260800190565b6001600160a01b03868116825285166020820152604081018490526060810183905260a060808201819052600090611ef8908301846114b2565b97965050505050505056fea26469706673582212201af9521892af6b35185cc2e24d18bdd4124cbe7459072e82187dabca2a5e024864736f6c63430008090033";

    public static final String FUNC_BALANCEOF = "balanceOf";

    public static final String FUNC_BALANCEOFBATCH = "balanceOfBatch";

    public static final String FUNC_BURN = "burn";

    public static final String FUNC_BURNBATCH = "burnBatch";

    public static final String FUNC_ISAPPROVEDFORALL = "isApprovedForAll";

    public static final String FUNC_MINT = "mint";

    public static final String FUNC_MINTBATCH = "mintBatch";

    public static final String FUNC_SAFEBATCHTRANSFERFROM = "safeBatchTransferFrom";

    public static final String FUNC_SAFETRANSFERFROM = "safeTransferFrom";

    public static final String FUNC_SETAPPROVALFORALL = "setApprovalForAll";

    public static final String FUNC_SETBASEURI = "setBaseURI";

    public static final String FUNC_setURI = "setURI";

    public static final String FUNC_SUPPORTSINTERFACE = "supportsInterface";

    public static final String FUNC_URI = "uri";

    public static final Event APPROVALFORALL_EVENT = new Event("ApprovalForAll", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Bool>() {}));
    ;

    public static final Event TRANSFERBATCH_EVENT = new Event("TransferBatch", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<DynamicArray<Uint256>>() {}, new TypeReference<DynamicArray<Uint256>>() {}));
    ;

    public static final Event TRANSFERSINGLE_EVENT = new Event("TransferSingle", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event URI_EVENT = new Event("URI", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Uint256>(true) {}));
    ;

    @Deprecated
    protected ERC1155URIStorageMock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ERC1155URIStorageMock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ERC1155URIStorageMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ERC1155URIStorageMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<ApprovalForAllEventResponse> getApprovalForAllEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(APPROVALFORALL_EVENT, transactionReceipt);
        ArrayList<ApprovalForAllEventResponse> responses = new ArrayList<ApprovalForAllEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ApprovalForAllEventResponse typedResponse = new ApprovalForAllEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.account = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.operator = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.approved = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ApprovalForAllEventResponse> approvalForAllEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ApprovalForAllEventResponse>() {
            @Override
            public ApprovalForAllEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(APPROVALFORALL_EVENT, log);
                ApprovalForAllEventResponse typedResponse = new ApprovalForAllEventResponse();
                typedResponse.log = log;
                typedResponse.account = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.operator = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.approved = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ApprovalForAllEventResponse> approvalForAllEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(APPROVALFORALL_EVENT));
        return approvalForAllEventFlowable(filter);
    }

    public static List<TransferBatchEventResponse> getTransferBatchEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(TRANSFERBATCH_EVENT, transactionReceipt);
        ArrayList<TransferBatchEventResponse> responses = new ArrayList<TransferBatchEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            TransferBatchEventResponse typedResponse = new TransferBatchEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.operator = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.from = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.to = (String) eventValues.getIndexedValues().get(2).getValue();
            typedResponse.ids = (List<BigInteger>) ((Array) eventValues.getNonIndexedValues().get(0)).getNativeValueCopy();
            typedResponse.values = (List<BigInteger>) ((Array) eventValues.getNonIndexedValues().get(1)).getNativeValueCopy();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<TransferBatchEventResponse> transferBatchEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, TransferBatchEventResponse>() {
            @Override
            public TransferBatchEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(TRANSFERBATCH_EVENT, log);
                TransferBatchEventResponse typedResponse = new TransferBatchEventResponse();
                typedResponse.log = log;
                typedResponse.operator = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.from = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.to = (String) eventValues.getIndexedValues().get(2).getValue();
                typedResponse.ids = (List<BigInteger>) ((Array) eventValues.getNonIndexedValues().get(0)).getNativeValueCopy();
                typedResponse.values = (List<BigInteger>) ((Array) eventValues.getNonIndexedValues().get(1)).getNativeValueCopy();
                return typedResponse;
            }
        });
    }

    public Flowable<TransferBatchEventResponse> transferBatchEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TRANSFERBATCH_EVENT));
        return transferBatchEventFlowable(filter);
    }

    public static List<TransferSingleEventResponse> getTransferSingleEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(TRANSFERSINGLE_EVENT, transactionReceipt);
        ArrayList<TransferSingleEventResponse> responses = new ArrayList<TransferSingleEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            TransferSingleEventResponse typedResponse = new TransferSingleEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.operator = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.from = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.to = (String) eventValues.getIndexedValues().get(2).getValue();
            typedResponse.id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<TransferSingleEventResponse> transferSingleEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, TransferSingleEventResponse>() {
            @Override
            public TransferSingleEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(TRANSFERSINGLE_EVENT, log);
                TransferSingleEventResponse typedResponse = new TransferSingleEventResponse();
                typedResponse.log = log;
                typedResponse.operator = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.from = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.to = (String) eventValues.getIndexedValues().get(2).getValue();
                typedResponse.id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<TransferSingleEventResponse> transferSingleEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TRANSFERSINGLE_EVENT));
        return transferSingleEventFlowable(filter);
    }

    public static List<URIEventResponse> getURIEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(URI_EVENT, transactionReceipt);
        ArrayList<URIEventResponse> responses = new ArrayList<URIEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            URIEventResponse typedResponse = new URIEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.id = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.value = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<URIEventResponse> uRIEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, URIEventResponse>() {
            @Override
            public URIEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(URI_EVENT, log);
                URIEventResponse typedResponse = new URIEventResponse();
                typedResponse.log = log;
                typedResponse.id = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.value = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<URIEventResponse> uRIEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(URI_EVENT));
        return uRIEventFlowable(filter);
    }

    public RemoteFunctionCall<BigInteger> balanceOf(String account, BigInteger id) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_BALANCEOF, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, account), 
                new org.web3j.abi.datatypes.generated.Uint256(id)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<List> balanceOfBatch(List<String> accounts, List<BigInteger> ids) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_BALANCEOFBATCH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(accounts, org.web3j.abi.datatypes.Address.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(ids, org.web3j.abi.datatypes.generated.Uint256.class))), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Uint256>>() {}));
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

    public RemoteFunctionCall<TransactionReceipt> burn(String owner, BigInteger id, BigInteger value) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_BURN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, owner), 
                new org.web3j.abi.datatypes.generated.Uint256(id), 
                new org.web3j.abi.datatypes.generated.Uint256(value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> burnBatch(String owner, List<BigInteger> ids, List<BigInteger> values) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_BURNBATCH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, owner), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(ids, org.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(values, org.web3j.abi.datatypes.generated.Uint256.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> isApprovedForAll(String account, String operator) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ISAPPROVEDFORALL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, account), 
                new org.web3j.abi.datatypes.Address(160, operator)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> mint(String to, BigInteger id, BigInteger value, byte[] data) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_MINT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, to), 
                new org.web3j.abi.datatypes.generated.Uint256(id), 
                new org.web3j.abi.datatypes.generated.Uint256(value), 
                new org.web3j.abi.datatypes.DynamicBytes(data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> mintBatch(String to, List<BigInteger> ids, List<BigInteger> values, byte[] data) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_MINTBATCH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, to), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(ids, org.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(values, org.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.web3j.abi.datatypes.DynamicBytes(data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> safeBatchTransferFrom(String from, String to, List<BigInteger> ids, List<BigInteger> amounts, byte[] data) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SAFEBATCHTRANSFERFROM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, from), 
                new org.web3j.abi.datatypes.Address(160, to), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(ids, org.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(amounts, org.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.web3j.abi.datatypes.DynamicBytes(data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> safeTransferFrom(String from, String to, BigInteger id, BigInteger amount, byte[] data) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SAFETRANSFERFROM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, from), 
                new org.web3j.abi.datatypes.Address(160, to), 
                new org.web3j.abi.datatypes.generated.Uint256(id), 
                new org.web3j.abi.datatypes.generated.Uint256(amount), 
                new org.web3j.abi.datatypes.DynamicBytes(data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setApprovalForAll(String operator, Boolean approved) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETAPPROVALFORALL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, operator), 
                new org.web3j.abi.datatypes.Bool(approved)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setBaseURI(String baseURI) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETBASEURI, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(baseURI)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setURI(String newuri) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_setURI, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(newuri)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setURI(BigInteger tokenId, String _tokenURI) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_setURI, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(tokenId), 
                new org.web3j.abi.datatypes.Utf8String(_tokenURI)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> supportsInterface(byte[] interfaceId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_SUPPORTSINTERFACE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes4(interfaceId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<String> uri(BigInteger tokenId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_URI, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static ERC1155URIStorageMock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ERC1155URIStorageMock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ERC1155URIStorageMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ERC1155URIStorageMock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ERC1155URIStorageMock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ERC1155URIStorageMock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ERC1155URIStorageMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ERC1155URIStorageMock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ERC1155URIStorageMock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _uri) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_uri)));
        return deployRemoteCall(ERC1155URIStorageMock.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<ERC1155URIStorageMock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _uri) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_uri)));
        return deployRemoteCall(ERC1155URIStorageMock.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ERC1155URIStorageMock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _uri) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_uri)));
        return deployRemoteCall(ERC1155URIStorageMock.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ERC1155URIStorageMock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _uri) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_uri)));
        return deployRemoteCall(ERC1155URIStorageMock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class ApprovalForAllEventResponse extends BaseEventResponse {
        public String account;

        public String operator;

        public Boolean approved;
    }

    public static class TransferBatchEventResponse extends BaseEventResponse {
        public String operator;

        public String from;

        public String to;

        public List<BigInteger> ids;

        public List<BigInteger> values;
    }

    public static class TransferSingleEventResponse extends BaseEventResponse {
        public String operator;

        public String from;

        public String to;

        public BigInteger id;

        public BigInteger value;
    }

    public static class URIEventResponse extends BaseEventResponse {
        public BigInteger id;

        public String value;
    }
}
