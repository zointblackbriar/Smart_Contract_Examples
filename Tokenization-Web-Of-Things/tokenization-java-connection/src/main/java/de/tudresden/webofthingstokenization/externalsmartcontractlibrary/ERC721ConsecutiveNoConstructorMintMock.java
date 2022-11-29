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
public class ERC721ConsecutiveNoConstructorMintMock extends Contract {
    public static final String BINARY = "60806040523480156200001157600080fd5b50604051620020a8380380620020a883398101604081905262000034916200088c565b8151829082906200004d90600090602085019062000719565b5080516200006390600190602084019062000719565b505050620000793360006200008160201b60201c565b5050620009cf565b62000097306200011e60201b620006491760201c565b620001035760405162461bcd60e51b815260206004820152603160248201527f455243373231436f6e73656375746976653a2063616e2774206d696e742064756044820152703934b7339031b7b739ba393ab1ba34b7b760791b60648201526084015b60405180910390fd5b6200011a82826200012d60201b620006581760201c565b5050565b6001600160a01b03163b151590565b6001600160a01b038216620001855760405162461bcd60e51b815260206004820181905260248201527f4552433732313a206d696e7420746f20746865207a65726f20616464726573736044820152606401620000fa565b6200019081620002c0565b15620001df5760405162461bcd60e51b815260206004820152601c60248201527f4552433732313a20746f6b656e20616c7265616479206d696e746564000000006044820152606401620000fa565b620001ef600083836001620002df565b620001fa81620002c0565b15620002495760405162461bcd60e51b815260206004820152601c60248201527f4552433732313a20746f6b656e20616c7265616479206d696e746564000000006044820152606401620000fa565b6001600160a01b038216600081815260036020908152604080832080546001019055848352600290915280822080546001600160a01b0319168417905551839291907fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef908290a46200011a6000838360016200036f565b600080620002ce836200045d565b6001600160a01b0316141592915050565b600181111562000369576001600160a01b0384161562000329576001600160a01b03841660009081526003602052604081208054839290620003239084906200090c565b90915550505b6001600160a01b0383161562000369576001600160a01b038316600090815260036020526040812080548392906200036390849062000926565b90915550505b50505050565b6001600160a01b0383161580156200039857506200038c620004ed565b6001600160601b031682105b8015620003bd5750620003bb8260076200053060201b620007dd1790919060201c565b155b15620004445780600114620004295760405162461bcd60e51b815260206004820152602b60248201527f455243373231436f6e73656375746976653a206261746368206275726e206e6f60448201526a1d081cdd5c1c1bdc9d195960aa1b6064820152608401620000fa565b620004448260076200055460201b620008011790919060201c565b62000369848484846200036960201b620005cf1760201c565b60008062000476836200057d60201b6200082a1760201c565b90506001600160a01b0381161515806200049657506001600160601b0383115b15620004a25792915050565b620004bd8360076200053060201b620007dd1790919060201c565b620004e357620004dd8360066200059860201b620008451790919060201c565b620004e6565b60005b9392505050565b6000806000620005096006620005ed60201b6200088d1760201c565b5091509150816200051c57600062000529565b6200052981600162000941565b9250505090565b600881901c600090815260208390526040902054600160ff83161b16151592915050565b600881901c600090815260209290925260409091208054600160ff9093169290921b9091179055565b6000908152600260205260409020546001600160a01b031690565b815460009081620005ac8585838562000683565b9050818114620005e1576000858152602090208101546c0100000000000000000000000090046001600160a01b0316620005e4565b60005b95945050505050565b805460009081908190806200060e576000806000935093509350506200067c565b60006200063086620006226001856200090c565b600091825260209091200190565b6040805180820190915290546001600160601b0381168083526c010000000000000000000000009091046001600160a01b0316602090920182905260019650945092506200067c915050565b9193909250565b60005b81831015620006f2576000620006a88484620006fa60201b620009141760201c565b6000878152602090209091506001600160601b038616908201546001600160601b03161015620006e757620006df81600162000926565b9350620006eb565b8092505b5062000686565b509392505050565b60006200070b60028484186200096f565b620004e69084841662000926565b828054620007279062000992565b90600052602060002090601f0160209004810192826200074b576000855562000796565b82601f106200076657805160ff191683800117855562000796565b8280016001018555821562000796579182015b828111156200079657825182559160200191906001019062000779565b50620007a4929150620007a8565b5090565b5b80821115620007a45760008155600101620007a9565b634e487b7160e01b600052604160045260246000fd5b600082601f830112620007e757600080fd5b81516001600160401b0380821115620008045762000804620007bf565b604051601f8301601f19908116603f011681019082821181831017156200082f576200082f620007bf565b816040528381526020925086838588010111156200084c57600080fd5b600091505b8382101562000870578582018301518183018401529082019062000851565b83821115620008825760008385830101525b9695505050505050565b60008060408385031215620008a057600080fd5b82516001600160401b0380821115620008b857600080fd5b620008c686838701620007d5565b93506020850151915080821115620008dd57600080fd5b50620008ec85828601620007d5565b9150509250929050565b634e487b7160e01b600052601160045260246000fd5b600082821015620009215762000921620008f6565b500390565b600082198211156200093c576200093c620008f6565b500190565b60006001600160601b03828116848216808303821115620009665762000966620008f6565b01949350505050565b6000826200098d57634e487b7160e01b600052601260045260246000fd5b500490565b600181811c90821680620009a757607f821691505b60208210811415620009c957634e487b7160e01b600052602260045260246000fd5b50919050565b6116c980620009df6000396000f3fe608060405234801561001057600080fd5b50600436106100cf5760003560e01c80636352211e1161008c578063a22cb46511610066578063a22cb465146101b3578063b88d4fde146101c6578063c87b56dd146101d9578063e985e9c5146101ec57600080fd5b80636352211e1461017757806370a082311461018a57806395d89b41146101ab57600080fd5b806301ffc9a7146100d457806306fdde03146100fc578063081812fc14610111578063095ea7b31461013c57806323b872dd1461015157806342842e0e14610164575b600080fd5b6100e76100e23660046111c3565b610228565b60405190151581526020015b60405180910390f35b61010461027a565b6040516100f39190611238565b61012461011f36600461124b565b61030c565b6040516001600160a01b0390911681526020016100f3565b61014f61014a366004611280565b610333565b005b61014f61015f3660046112aa565b61044e565b61014f6101723660046112aa565b61047f565b61012461018536600461124b565b61049a565b61019d6101983660046112e6565b6104f9565b6040519081526020016100f3565b61010461057f565b61014f6101c1366004611301565b61058e565b61014f6101d4366004611353565b61059d565b6101046101e736600461124b565b6105d5565b6100e76101fa36600461142f565b6001600160a01b03918216600090815260056020908152604080832093909416825291909152205460ff1690565b60006001600160e01b031982166380ac58cd60e01b148061025957506001600160e01b03198216635b5e139f60e01b145b8061027457506301ffc9a760e01b6001600160e01b03198316145b92915050565b60606000805461028990611462565b80601f01602080910402602001604051908101604052809291908181526020018280546102b590611462565b80156103025780601f106102d757610100808354040283529160200191610302565b820191906000526020600020905b8154815290600101906020018083116102e557829003601f168201915b5050505050905090565b60006103178261092f565b506000908152600460205260409020546001600160a01b031690565b600061033e8261049a565b9050806001600160a01b0316836001600160a01b031614156103b15760405162461bcd60e51b815260206004820152602160248201527f4552433732313a20617070726f76616c20746f2063757272656e74206f776e656044820152603960f91b60648201526084015b60405180910390fd5b336001600160a01b03821614806103cd57506103cd81336101fa565b61043f5760405162461bcd60e51b815260206004820152603d60248201527f4552433732313a20617070726f76652063616c6c6572206973206e6f7420746f60448201527f6b656e206f776e6572206f7220617070726f76656420666f7220616c6c00000060648201526084016103a8565b6104498383610982565b505050565b61045833826109f0565b6104745760405162461bcd60e51b81526004016103a89061149d565b610449838383610a6f565b6104498383836040518060200160405280600081525061059d565b6000806104a683610be8565b90506001600160a01b0381166102745760405162461bcd60e51b8152602060048201526018602482015277115490cdcc8c4e881a5b9d985b1a59081d1bdad95b88125160421b60448201526064016103a8565b60006001600160a01b0382166105635760405162461bcd60e51b815260206004820152602960248201527f4552433732313a2061646472657373207a65726f206973206e6f7420612076616044820152683634b21037bbb732b960b91b60648201526084016103a8565b506001600160a01b031660009081526003602052604090205490565b60606001805461028990611462565b610599338383610c46565b5050565b6105a733836109f0565b6105c35760405162461bcd60e51b81526004016103a89061149d565b6105cf84848484610d15565b50505050565b60606105e08261092f565b60006105f760408051602081019091526000815290565b905060008151116106175760405180602001604052806000815250610642565b8061062184610d48565b6040516020016106329291906114ea565b6040516020818303038152906040525b9392505050565b6001600160a01b03163b151590565b6001600160a01b0382166106ae5760405162461bcd60e51b815260206004820181905260248201527f4552433732313a206d696e7420746f20746865207a65726f206164647265737360448201526064016103a8565b6106b781610de5565b156107045760405162461bcd60e51b815260206004820152601c60248201527f4552433732313a20746f6b656e20616c7265616479206d696e7465640000000060448201526064016103a8565b610712600083836001610e02565b61071b81610de5565b156107685760405162461bcd60e51b815260206004820152601c60248201527f4552433732313a20746f6b656e20616c7265616479206d696e7465640000000060448201526064016103a8565b6001600160a01b038216600081815260036020908152604080832080546001019055848352600290915280822080546001600160a01b0319168417905551839291907fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef908290a4610599600083836001610e8a565b600881901c600090815260208390526040902054600160ff83161b16151592915050565b600881901c600090815260209290925260409091208054600160ff9093169290921b9091179055565b6000908152600260205260409020546001600160a01b031690565b81546000908161085785858385610f3d565b905081811461088157600085815260209020810154600160601b90046001600160a01b0316610884565b60005b95945050505050565b805460009081908190806108ac5760008060009350935093505061090d565b60006108cb866108bd60018561152f565b600091825260209091200190565b6040805180820190915290546001600160601b038116808352600160601b9091046001600160a01b03166020909201829052600196509450925061090d915050565b9193909250565b60006109236002848418611546565b61064290848416611568565b61093881610de5565b61097f5760405162461bcd60e51b8152602060048201526018602482015277115490cdcc8c4e881a5b9d985b1a59081d1bdad95b88125160421b60448201526064016103a8565b50565b600081815260046020526040902080546001600160a01b0319166001600160a01b03841690811790915581906109b78261049a565b6001600160a01b03167f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b92560405160405180910390a45050565b6000806109fc8361049a565b9050806001600160a01b0316846001600160a01b03161480610a4357506001600160a01b0380821660009081526005602090815260408083209388168352929052205460ff165b80610a675750836001600160a01b0316610a5c8461030c565b6001600160a01b0316145b949350505050565b826001600160a01b0316610a828261049a565b6001600160a01b031614610aa85760405162461bcd60e51b81526004016103a890611580565b6001600160a01b038216610b0a5760405162461bcd60e51b8152602060048201526024808201527f4552433732313a207472616e7366657220746f20746865207a65726f206164646044820152637265737360e01b60648201526084016103a8565b610b178383836001610e02565b826001600160a01b0316610b2a8261049a565b6001600160a01b031614610b505760405162461bcd60e51b81526004016103a890611580565b600081815260046020908152604080832080546001600160a01b03199081169091556001600160a01b0387811680865260038552838620805460001901905590871680865283862080546001019055868652600290945282852080549092168417909155905184937fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef91a46104498383836001610e8a565b600080610bf48361082a565b90506001600160a01b038116151580610c1357506001600160601b0383115b15610c1e5792915050565b610c296007846107dd565b610c3d57610c38600684610845565b610642565b60009392505050565b816001600160a01b0316836001600160a01b03161415610ca85760405162461bcd60e51b815260206004820152601960248201527f4552433732313a20617070726f766520746f2063616c6c65720000000000000060448201526064016103a8565b6001600160a01b03838116600081815260056020908152604080832094871680845294825291829020805460ff191686151590811790915591519182527f17307eab39ab6107e8899845ad3d59bd9653f200f220920489ca2b5937696c31910160405180910390a3505050565b610d20848484610a6f565b610d2c84848484610f99565b6105cf5760405162461bcd60e51b81526004016103a8906115c5565b60606000610d55836110a3565b600101905060008167ffffffffffffffff811115610d7557610d7561133d565b6040519080825280601f01601f191660200182016040528015610d9f576020820181803683370190505b5090508181016020015b600019016f181899199a1a9b1b9c1cb0b131b232b360811b600a86061a8153600a8504945084610dd857610ddd565b610da9565b509392505050565b600080610df183610be8565b6001600160a01b0316141592915050565b60018111156105cf576001600160a01b03841615610e48576001600160a01b03841660009081526003602052604081208054839290610e4290849061152f565b90915550505b6001600160a01b038316156105cf576001600160a01b03831660009081526003602052604081208054839290610e7f908490611568565b909155505050505050565b6001600160a01b038316158015610eb05750610ea461117b565b6001600160601b031682105b8015610ec45750610ec26007836107dd565b155b15610f385780600114610f2d5760405162461bcd60e51b815260206004820152602b60248201527f455243373231436f6e73656375746976653a206261746368206275726e206e6f60448201526a1d081cdd5c1c1bdc9d195960aa1b60648201526084016103a8565b610f38600783610801565b6105cf565b60005b81831015610ddd576000610f548484610914565b6000878152602090209091506001600160601b038616908201546001600160601b03161015610f8f57610f88816001611568565b9350610f93565b8092505b50610f40565b60006001600160a01b0384163b1561109b57604051630a85bd0160e11b81526001600160a01b0385169063150b7a0290610fdd903390899088908890600401611617565b602060405180830381600087803b158015610ff757600080fd5b505af1925050508015611027575060408051601f3d908101601f1916820190925261102491810190611654565b60015b611081573d808015611055576040519150601f19603f3d011682016040523d82523d6000602084013e61105a565b606091505b5080516110795760405162461bcd60e51b81526004016103a8906115c5565b805181602001fd5b6001600160e01b031916630a85bd0160e11b149050610a67565b506001610a67565b60008072184f03e93ff9f4daa797ed6e38ed64bf6a1f0160401b83106110e25772184f03e93ff9f4daa797ed6e38ed64bf6a1f0160401b830492506040015b6d04ee2d6d415b85acef8100000000831061110e576d04ee2d6d415b85acef8100000000830492506020015b662386f26fc10000831061112c57662386f26fc10000830492506010015b6305f5e1008310611144576305f5e100830492506008015b612710831061115857612710830492506004015b6064831061116a576064830492506002015b600a83106102745760010192915050565b600080600061118a600661088d565b50915091508161119b5760006111a6565b6111a6816001611671565b9250505090565b6001600160e01b03198116811461097f57600080fd5b6000602082840312156111d557600080fd5b8135610642816111ad565b60005b838110156111fb5781810151838201526020016111e3565b838111156105cf5750506000910152565b600081518084526112248160208601602086016111e0565b601f01601f19169290920160200192915050565b602081526000610642602083018461120c565b60006020828403121561125d57600080fd5b5035919050565b80356001600160a01b038116811461127b57600080fd5b919050565b6000806040838503121561129357600080fd5b61129c83611264565b946020939093013593505050565b6000806000606084860312156112bf57600080fd5b6112c884611264565b92506112d660208501611264565b9150604084013590509250925092565b6000602082840312156112f857600080fd5b61064282611264565b6000806040838503121561131457600080fd5b61131d83611264565b91506020830135801515811461133257600080fd5b809150509250929050565b634e487b7160e01b600052604160045260246000fd5b6000806000806080858703121561136957600080fd5b61137285611264565b935061138060208601611264565b925060408501359150606085013567ffffffffffffffff808211156113a457600080fd5b818701915087601f8301126113b857600080fd5b8135818111156113ca576113ca61133d565b604051601f8201601f19908116603f011681019083821181831017156113f2576113f261133d565b816040528281528a602084870101111561140b57600080fd5b82602086016020830137600060208483010152809550505050505092959194509250565b6000806040838503121561144257600080fd5b61144b83611264565b915061145960208401611264565b90509250929050565b600181811c9082168061147657607f821691505b6020821081141561149757634e487b7160e01b600052602260045260246000fd5b50919050565b6020808252602d908201527f4552433732313a2063616c6c6572206973206e6f7420746f6b656e206f776e6560408201526c1c881bdc88185c1c1c9bdd9959609a1b606082015260800190565b600083516114fc8184602088016111e0565b8351908301906115108183602088016111e0565b01949350505050565b634e487b7160e01b600052601160045260246000fd5b60008282101561154157611541611519565b500390565b60008261156357634e487b7160e01b600052601260045260246000fd5b500490565b6000821982111561157b5761157b611519565b500190565b60208082526025908201527f4552433732313a207472616e736665722066726f6d20696e636f72726563742060408201526437bbb732b960d91b606082015260800190565b60208082526032908201527f4552433732313a207472616e7366657220746f206e6f6e20455243373231526560408201527131b2b4bb32b91034b6b83632b6b2b73a32b960711b606082015260800190565b6001600160a01b038581168252841660208201526040810183905260806060820181905260009061164a9083018461120c565b9695505050505050565b60006020828403121561166657600080fd5b8151610642816111ad565b60006001600160601b038083168185168083038211156115105761151061151956fea2646970667358221220565e28e3871f10d62230dc624c45f0ff31d27a061060d4460bdc8d079a41f76b64736f6c63430008090033";

    public static final String FUNC_APPROVE = "approve";

    public static final String FUNC_BALANCEOF = "balanceOf";

    public static final String FUNC_GETAPPROVED = "getApproved";

    public static final String FUNC_ISAPPROVEDFORALL = "isApprovedForAll";

    public static final String FUNC_NAME = "name";

    public static final String FUNC_OWNEROF = "ownerOf";

    public static final String FUNC_safeTransferFrom = "safeTransferFrom";

    public static final String FUNC_SETAPPROVALFORALL = "setApprovalForAll";

    public static final String FUNC_SUPPORTSINTERFACE = "supportsInterface";

    public static final String FUNC_SYMBOL = "symbol";

    public static final String FUNC_TOKENURI = "tokenURI";

    public static final String FUNC_TRANSFERFROM = "transferFrom";

    public static final Event APPROVAL_EVENT = new Event("Approval", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>(true) {}));
    ;

    public static final Event APPROVALFORALL_EVENT = new Event("ApprovalForAll", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Bool>() {}));
    ;

    public static final Event CONSECUTIVETRANSFER_EVENT = new Event("ConsecutiveTransfer", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event TRANSFER_EVENT = new Event("Transfer", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>(true) {}));
    ;

    @Deprecated
    protected ERC721ConsecutiveNoConstructorMintMock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ERC721ConsecutiveNoConstructorMintMock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ERC721ConsecutiveNoConstructorMintMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ERC721ConsecutiveNoConstructorMintMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<ApprovalEventResponse> getApprovalEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(APPROVAL_EVENT, transactionReceipt);
        ArrayList<ApprovalEventResponse> responses = new ArrayList<ApprovalEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ApprovalEventResponse typedResponse = new ApprovalEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.approved = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
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
                typedResponse.approved = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ApprovalEventResponse> approvalEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(APPROVAL_EVENT));
        return approvalEventFlowable(filter);
    }

    public static List<ApprovalForAllEventResponse> getApprovalForAllEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(APPROVALFORALL_EVENT, transactionReceipt);
        ArrayList<ApprovalForAllEventResponse> responses = new ArrayList<ApprovalForAllEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ApprovalForAllEventResponse typedResponse = new ApprovalForAllEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
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
                typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
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

    public static List<ConsecutiveTransferEventResponse> getConsecutiveTransferEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(CONSECUTIVETRANSFER_EVENT, transactionReceipt);
        ArrayList<ConsecutiveTransferEventResponse> responses = new ArrayList<ConsecutiveTransferEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ConsecutiveTransferEventResponse typedResponse = new ConsecutiveTransferEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.fromTokenId = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.fromAddress = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.toAddress = (String) eventValues.getIndexedValues().get(2).getValue();
            typedResponse.toTokenId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ConsecutiveTransferEventResponse> consecutiveTransferEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ConsecutiveTransferEventResponse>() {
            @Override
            public ConsecutiveTransferEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(CONSECUTIVETRANSFER_EVENT, log);
                ConsecutiveTransferEventResponse typedResponse = new ConsecutiveTransferEventResponse();
                typedResponse.log = log;
                typedResponse.fromTokenId = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.fromAddress = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.toAddress = (String) eventValues.getIndexedValues().get(2).getValue();
                typedResponse.toTokenId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ConsecutiveTransferEventResponse> consecutiveTransferEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CONSECUTIVETRANSFER_EVENT));
        return consecutiveTransferEventFlowable(filter);
    }

    public static List<TransferEventResponse> getTransferEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(TRANSFER_EVENT, transactionReceipt);
        ArrayList<TransferEventResponse> responses = new ArrayList<TransferEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            TransferEventResponse typedResponse = new TransferEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
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
                typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<TransferEventResponse> transferEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TRANSFER_EVENT));
        return transferEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> approve(String to, BigInteger tokenId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_APPROVE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, to), 
                new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> balanceOf(String owner) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_BALANCEOF, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, owner)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> getApproved(BigInteger tokenId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETAPPROVED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Boolean> isApprovedForAll(String owner, String operator) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ISAPPROVEDFORALL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, owner), 
                new org.web3j.abi.datatypes.Address(160, operator)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<String> name() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_NAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> ownerOf(BigInteger tokenId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_OWNEROF, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> safeTransferFrom(String from, String to, BigInteger tokenId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_safeTransferFrom, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, from), 
                new org.web3j.abi.datatypes.Address(160, to), 
                new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> safeTransferFrom(String from, String to, BigInteger tokenId, byte[] data) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_safeTransferFrom, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, from), 
                new org.web3j.abi.datatypes.Address(160, to), 
                new org.web3j.abi.datatypes.generated.Uint256(tokenId), 
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

    public RemoteFunctionCall<Boolean> supportsInterface(byte[] interfaceId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_SUPPORTSINTERFACE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes4(interfaceId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<String> symbol() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_SYMBOL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> tokenURI(BigInteger tokenId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_TOKENURI, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> transferFrom(String from, String to, BigInteger tokenId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFERFROM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, from), 
                new org.web3j.abi.datatypes.Address(160, to), 
                new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static ERC721ConsecutiveNoConstructorMintMock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ERC721ConsecutiveNoConstructorMintMock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ERC721ConsecutiveNoConstructorMintMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ERC721ConsecutiveNoConstructorMintMock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ERC721ConsecutiveNoConstructorMintMock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ERC721ConsecutiveNoConstructorMintMock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ERC721ConsecutiveNoConstructorMintMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ERC721ConsecutiveNoConstructorMintMock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ERC721ConsecutiveNoConstructorMintMock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String name, String symbol) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.Utf8String(symbol)));
        return deployRemoteCall(ERC721ConsecutiveNoConstructorMintMock.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<ERC721ConsecutiveNoConstructorMintMock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String name, String symbol) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.Utf8String(symbol)));
        return deployRemoteCall(ERC721ConsecutiveNoConstructorMintMock.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ERC721ConsecutiveNoConstructorMintMock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String name, String symbol) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.Utf8String(symbol)));
        return deployRemoteCall(ERC721ConsecutiveNoConstructorMintMock.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ERC721ConsecutiveNoConstructorMintMock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String name, String symbol) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.Utf8String(symbol)));
        return deployRemoteCall(ERC721ConsecutiveNoConstructorMintMock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class ApprovalEventResponse extends BaseEventResponse {
        public String owner;

        public String approved;

        public BigInteger tokenId;
    }

    public static class ApprovalForAllEventResponse extends BaseEventResponse {
        public String owner;

        public String operator;

        public Boolean approved;
    }

    public static class ConsecutiveTransferEventResponse extends BaseEventResponse {
        public BigInteger fromTokenId;

        public String fromAddress;

        public String toAddress;

        public BigInteger toTokenId;
    }

    public static class TransferEventResponse extends BaseEventResponse {
        public String from;

        public String to;

        public BigInteger tokenId;
    }
}
