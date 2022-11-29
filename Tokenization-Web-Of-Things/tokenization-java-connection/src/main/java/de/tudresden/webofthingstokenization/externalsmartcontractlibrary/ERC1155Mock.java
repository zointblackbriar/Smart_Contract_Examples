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
public class ERC1155Mock extends Contract {
    public static final String BINARY = "60806040523480156200001157600080fd5b5060405162001eee38038062001eee83398101604081905262000034916200011d565b80620000408162000048565b505062000236565b80516200005d90600290602084019062000061565b5050565b8280546200006f90620001f9565b90600052602060002090601f016020900481019282620000935760008555620000de565b82601f10620000ae57805160ff1916838001178555620000de565b82800160010185558215620000de579182015b82811115620000de578251825591602001919060010190620000c1565b50620000ec929150620000f0565b5090565b5b80821115620000ec5760008155600101620000f1565b634e487b7160e01b600052604160045260246000fd5b600060208083850312156200013157600080fd5b82516001600160401b03808211156200014957600080fd5b818501915085601f8301126200015e57600080fd5b81518181111562000173576200017362000107565b604051601f8201601f19908116603f011681019083821181831017156200019e576200019e62000107565b816040528281528886848701011115620001b757600080fd5b600093505b82841015620001db5784840186015181850187015292850192620001bc565b82841115620001ed5760008684830101525b98975050505050505050565b600181811c908216806200020e57607f821691505b602082108114156200023057634e487b7160e01b600052602260045260246000fd5b50919050565b611ca880620002466000396000f3fe608060405234801561001057600080fd5b50600436106100ce5760003560e01c80634e1273f41161008c578063a22cb46511610066578063a22cb465146101bd578063e985e9c5146101d0578063f242432a1461020c578063f5298aca1461021f57600080fd5b80634e1273f4146101775780636b20c45414610197578063731133e9146101aa57600080fd5b8062fdd58e146100d357806301ffc9a7146100f957806302fe53051461011c5780630e89341c146101315780631f7fdffa146101515780632eb2c2d614610164575b600080fd5b6100e66100e136600461115f565b610232565b6040519081526020015b60405180910390f35b61010c61010736600461119f565b6102c8565b60405190151581526020016100f0565b61012f61012a366004611264565b61031a565b005b61014461013f3660046112b5565b610326565b6040516100f0919061131b565b61012f61015f3660046113e3565b6103ba565b61012f61017236600461147c565b6103cc565b61018a610185366004611526565b610418565b6040516100f0919061162c565b61012f6101a536600461163f565b610542565b61012f6101b83660046116b3565b610552565b61012f6101cb366004611708565b61055e565b61010c6101de366004611744565b6001600160a01b03918216600090815260016020908152604080832093909416825291909152205460ff1690565b61012f61021a366004611777565b61056d565b61012f61022d3660046117dc565b6105b2565b60006001600160a01b0383166102a25760405162461bcd60e51b815260206004820152602a60248201527f455243313135353a2061646472657373207a65726f206973206e6f742061207660448201526930b634b21037bbb732b960b11b60648201526084015b60405180910390fd5b506000908152602081815260408083206001600160a01b03949094168352929052205490565b60006001600160e01b03198216636cdb3d1360e11b14806102f957506001600160e01b031982166303a24d0760e21b145b8061031457506301ffc9a760e01b6001600160e01b03198316145b92915050565b610323816105bd565b50565b6060600280546103359061180f565b80601f01602080910402602001604051908101604052809291908181526020018280546103619061180f565b80156103ae5780601f10610383576101008083540402835291602001916103ae565b820191906000526020600020905b81548152906001019060200180831161039157829003601f168201915b50505050509050919050565b6103c6848484846105d0565b50505050565b6001600160a01b0385163314806103e857506103e885336101de565b6104045760405162461bcd60e51b81526004016102999061184a565b610411858585858561071b565b5050505050565b6060815183511461047d5760405162461bcd60e51b815260206004820152602960248201527f455243313135353a206163636f756e747320616e6420696473206c656e677468604482015268040dad2e6dac2e8c6d60bb1b6064820152608401610299565b6000835167ffffffffffffffff811115610499576104996111c3565b6040519080825280602002602001820160405280156104c2578160200160208202803683370190505b50905060005b845181101561053a5761050d8582815181106104e6576104e6611898565b602002602001015185838151811061050057610500611898565b6020026020010151610232565b82828151811061051f5761051f611898565b6020908102919091010152610533816118c4565b90506104c8565b509392505050565b61054d8383836108b7565b505050565b6103c684848484610a41565b610569338383610b1b565b5050565b6001600160a01b038516331480610589575061058985336101de565b6105a55760405162461bcd60e51b81526004016102999061184a565b6104118585858585610bfc565b61054d838383610d26565b80516105699060029060208401906110aa565b6001600160a01b0384166105f65760405162461bcd60e51b8152600401610299906118df565b81518351146106175760405162461bcd60e51b815260040161029990611920565b3360005b84518110156106b35783818151811061063657610636611898565b602002602001015160008087848151811061065357610653611898565b602002602001015181526020019081526020016000206000886001600160a01b03166001600160a01b03168152602001908152602001600020600082825461069b9190611968565b909155508190506106ab816118c4565b91505061061b565b50846001600160a01b031660006001600160a01b0316826001600160a01b03167f4a39dc06d4c0dbc64b70af90fd698a233a518aa5d07e595d983b8c0526c8f7fb8787604051610704929190611980565b60405180910390a461041181600087878787610e2a565b815183511461073c5760405162461bcd60e51b815260040161029990611920565b6001600160a01b0384166107625760405162461bcd60e51b8152600401610299906119ae565b3360005b845181101561084957600085828151811061078357610783611898565b6020026020010151905060008583815181106107a1576107a1611898565b602090810291909101810151600084815280835260408082206001600160a01b038e1683529093529190912054909150818110156107f15760405162461bcd60e51b8152600401610299906119f3565b6000838152602081815260408083206001600160a01b038e8116855292528083208585039055908b1682528120805484929061082e908490611968565b9250508190555050505080610842906118c4565b9050610766565b50846001600160a01b0316866001600160a01b0316826001600160a01b03167f4a39dc06d4c0dbc64b70af90fd698a233a518aa5d07e595d983b8c0526c8f7fb8787604051610899929190611980565b60405180910390a46108af818787878787610e2a565b505050505050565b6001600160a01b0383166108dd5760405162461bcd60e51b815260040161029990611a3d565b80518251146108fe5760405162461bcd60e51b815260040161029990611920565b604080516020810190915260009081905233905b83518110156109d457600084828151811061092f5761092f611898565b60200260200101519050600084838151811061094d5761094d611898565b602090810291909101810151600084815280835260408082206001600160a01b038c16835290935291909120549091508181101561099d5760405162461bcd60e51b815260040161029990611a80565b6000928352602083815260408085206001600160a01b038b16865290915290922091039055806109cc816118c4565b915050610912565b5060006001600160a01b0316846001600160a01b0316826001600160a01b03167f4a39dc06d4c0dbc64b70af90fd698a233a518aa5d07e595d983b8c0526c8f7fb8686604051610a25929190611980565b60405180910390a46040805160208101909152600090526103c6565b6001600160a01b038416610a675760405162461bcd60e51b8152600401610299906118df565b336000610a7385610f95565b90506000610a8085610f95565b90506000868152602081815260408083206001600160a01b038b16845290915281208054879290610ab2908490611968565b909155505060408051878152602081018790526001600160a01b03808a1692600092918716917fc3d58168c5ae7397731d063d5bbf3d657854427343f4c083240f7aacaa2d0f62910160405180910390a4610b1283600089898989610fe0565b50505050505050565b816001600160a01b0316836001600160a01b03161415610b8f5760405162461bcd60e51b815260206004820152602960248201527f455243313135353a2073657474696e6720617070726f76616c20737461747573604482015268103337b91039b2b63360b91b6064820152608401610299565b6001600160a01b03838116600081815260016020908152604080832094871680845294825291829020805460ff191686151590811790915591519182527f17307eab39ab6107e8899845ad3d59bd9653f200f220920489ca2b5937696c31910160405180910390a3505050565b6001600160a01b038416610c225760405162461bcd60e51b8152600401610299906119ae565b336000610c2e85610f95565b90506000610c3b85610f95565b90506000868152602081815260408083206001600160a01b038c16845290915290205485811015610c7e5760405162461bcd60e51b8152600401610299906119f3565b6000878152602081815260408083206001600160a01b038d8116855292528083208985039055908a16825281208054889290610cbb908490611968565b909155505060408051888152602081018890526001600160a01b03808b16928c821692918816917fc3d58168c5ae7397731d063d5bbf3d657854427343f4c083240f7aacaa2d0f62910160405180910390a4610d1b848a8a8a8a8a610fe0565b505050505050505050565b6001600160a01b038316610d4c5760405162461bcd60e51b815260040161029990611a3d565b336000610d5884610f95565b90506000610d6584610f95565b60408051602080820183526000918290528882528181528282206001600160a01b038b1683529052205490915084811015610db25760405162461bcd60e51b815260040161029990611a80565b6000868152602081815260408083206001600160a01b038b81168086529184528285208a8703905582518b81529384018a90529092908816917fc3d58168c5ae7397731d063d5bbf3d657854427343f4c083240f7aacaa2d0f62910160405180910390a4604080516020810190915260009052610b12565b6001600160a01b0384163b156108af5760405163bc197c8160e01b81526001600160a01b0385169063bc197c8190610e6e9089908990889088908890600401611ac4565b602060405180830381600087803b158015610e8857600080fd5b505af1925050508015610eb8575060408051601f3d908101601f19168201909252610eb591810190611b22565b60015b610f6557610ec4611b3f565b806308c379a01415610efe5750610ed9611b5b565b80610ee45750610f00565b8060405162461bcd60e51b8152600401610299919061131b565b505b60405162461bcd60e51b815260206004820152603460248201527f455243313135353a207472616e7366657220746f206e6f6e2d455243313135356044820152732932b1b2b4bb32b91034b6b83632b6b2b73a32b960611b6064820152608401610299565b6001600160e01b0319811663bc197c8160e01b14610b125760405162461bcd60e51b815260040161029990611be5565b60408051600180825281830190925260609160009190602080830190803683370190505090508281600081518110610fcf57610fcf611898565b602090810291909101015292915050565b6001600160a01b0384163b156108af5760405163f23a6e6160e01b81526001600160a01b0385169063f23a6e61906110249089908990889088908890600401611c2d565b602060405180830381600087803b15801561103e57600080fd5b505af192505050801561106e575060408051601f3d908101601f1916820190925261106b91810190611b22565b60015b61107a57610ec4611b3f565b6001600160e01b0319811663f23a6e6160e01b14610b125760405162461bcd60e51b815260040161029990611be5565b8280546110b69061180f565b90600052602060002090601f0160209004810192826110d8576000855561111e565b82601f106110f157805160ff191683800117855561111e565b8280016001018555821561111e579182015b8281111561111e578251825591602001919060010190611103565b5061112a92915061112e565b5090565b5b8082111561112a576000815560010161112f565b80356001600160a01b038116811461115a57600080fd5b919050565b6000806040838503121561117257600080fd5b61117b83611143565b946020939093013593505050565b6001600160e01b03198116811461032357600080fd5b6000602082840312156111b157600080fd5b81356111bc81611189565b9392505050565b634e487b7160e01b600052604160045260246000fd5b601f8201601f1916810167ffffffffffffffff811182821017156111ff576111ff6111c3565b6040525050565b600067ffffffffffffffff831115611220576112206111c3565b604051611237601f8501601f1916602001826111d9565b80915083815284848401111561124c57600080fd5b83836020830137600060208583010152509392505050565b60006020828403121561127657600080fd5b813567ffffffffffffffff81111561128d57600080fd5b8201601f8101841361129e57600080fd5b6112ad84823560208401611206565b949350505050565b6000602082840312156112c757600080fd5b5035919050565b6000815180845260005b818110156112f4576020818501810151868301820152016112d8565b81811115611306576000602083870101525b50601f01601f19169290920160200192915050565b6020815260006111bc60208301846112ce565b600067ffffffffffffffff821115611348576113486111c3565b5060051b60200190565b600082601f83011261136357600080fd5b813560206113708261132e565b60405161137d82826111d9565b83815260059390931b850182019282810191508684111561139d57600080fd5b8286015b848110156113b857803583529183019183016113a1565b509695505050505050565b600082601f8301126113d457600080fd5b6111bc83833560208501611206565b600080600080608085870312156113f957600080fd5b61140285611143565b9350602085013567ffffffffffffffff8082111561141f57600080fd5b61142b88838901611352565b9450604087013591508082111561144157600080fd5b61144d88838901611352565b9350606087013591508082111561146357600080fd5b50611470878288016113c3565b91505092959194509250565b600080600080600060a0868803121561149457600080fd5b61149d86611143565b94506114ab60208701611143565b9350604086013567ffffffffffffffff808211156114c857600080fd5b6114d489838a01611352565b945060608801359150808211156114ea57600080fd5b6114f689838a01611352565b9350608088013591508082111561150c57600080fd5b50611519888289016113c3565b9150509295509295909350565b6000806040838503121561153957600080fd5b823567ffffffffffffffff8082111561155157600080fd5b818501915085601f83011261156557600080fd5b813560206115728261132e565b60405161157f82826111d9565b83815260059390931b850182019282810191508984111561159f57600080fd5b948201945b838610156115c4576115b586611143565b825294820194908201906115a4565b965050860135925050808211156115da57600080fd5b506115e785828601611352565b9150509250929050565b600081518084526020808501945080840160005b8381101561162157815187529582019590820190600101611605565b509495945050505050565b6020815260006111bc60208301846115f1565b60008060006060848603121561165457600080fd5b61165d84611143565b9250602084013567ffffffffffffffff8082111561167a57600080fd5b61168687838801611352565b9350604086013591508082111561169c57600080fd5b506116a986828701611352565b9150509250925092565b600080600080608085870312156116c957600080fd5b6116d285611143565b93506020850135925060408501359150606085013567ffffffffffffffff8111156116fc57600080fd5b611470878288016113c3565b6000806040838503121561171b57600080fd5b61172483611143565b91506020830135801515811461173957600080fd5b809150509250929050565b6000806040838503121561175757600080fd5b61176083611143565b915061176e60208401611143565b90509250929050565b600080600080600060a0868803121561178f57600080fd5b61179886611143565b94506117a660208701611143565b93506040860135925060608601359150608086013567ffffffffffffffff8111156117d057600080fd5b611519888289016113c3565b6000806000606084860312156117f157600080fd5b6117fa84611143565b95602085013595506040909401359392505050565b600181811c9082168061182357607f821691505b6020821081141561184457634e487b7160e01b600052602260045260246000fd5b50919050565b6020808252602e908201527f455243313135353a2063616c6c6572206973206e6f7420746f6b656e206f776e60408201526d195c881bdc88185c1c1c9bdd995960921b606082015260800190565b634e487b7160e01b600052603260045260246000fd5b634e487b7160e01b600052601160045260246000fd5b60006000198214156118d8576118d86118ae565b5060010190565b60208082526021908201527f455243313135353a206d696e7420746f20746865207a65726f206164647265736040820152607360f81b606082015260800190565b60208082526028908201527f455243313135353a2069647320616e6420616d6f756e7473206c656e677468206040820152670dad2e6dac2e8c6d60c31b606082015260800190565b6000821982111561197b5761197b6118ae565b500190565b60408152600061199360408301856115f1565b82810360208401526119a581856115f1565b95945050505050565b60208082526025908201527f455243313135353a207472616e7366657220746f20746865207a65726f206164604082015264647265737360d81b606082015260800190565b6020808252602a908201527f455243313135353a20696e73756666696369656e742062616c616e636520666f60408201526939103a3930b739b332b960b11b606082015260800190565b60208082526023908201527f455243313135353a206275726e2066726f6d20746865207a65726f206164647260408201526265737360e81b606082015260800190565b60208082526024908201527f455243313135353a206275726e20616d6f756e7420657863656564732062616c604082015263616e636560e01b606082015260800190565b6001600160a01b0386811682528516602082015260a060408201819052600090611af0908301866115f1565b8281036060840152611b0281866115f1565b90508281036080840152611b1681856112ce565b98975050505050505050565b600060208284031215611b3457600080fd5b81516111bc81611189565b600060033d1115611b585760046000803e5060005160e01c5b90565b600060443d1015611b695790565b6040516003193d81016004833e81513d67ffffffffffffffff8160248401118184111715611b9957505050505090565b8285019150815181811115611bb15750505050505090565b843d8701016020828501011115611bcb5750505050505090565b611bda602082860101876111d9565b509095945050505050565b60208082526028908201527f455243313135353a204552433131353552656365697665722072656a656374656040820152676420746f6b656e7360c01b606082015260800190565b6001600160a01b03868116825285166020820152604081018490526060810183905260a060808201819052600090611c67908301846112ce565b97965050505050505056fea2646970667358221220949e9c4a8c02765b3bcec138d7b4570b6b05d93a4161c38eb4f962ee2920a2db64736f6c63430008090033";

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

    public static final String FUNC_SETURI = "setURI";

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
    protected ERC1155Mock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ERC1155Mock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ERC1155Mock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ERC1155Mock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
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

    public RemoteFunctionCall<TransactionReceipt> setURI(String newuri) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SETURI, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(newuri)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> supportsInterface(byte[] interfaceId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_SUPPORTSINTERFACE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes4(interfaceId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<String> uri(BigInteger param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_URI, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static ERC1155Mock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ERC1155Mock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ERC1155Mock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ERC1155Mock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ERC1155Mock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ERC1155Mock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ERC1155Mock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ERC1155Mock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ERC1155Mock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String uri) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(uri)));
        return deployRemoteCall(ERC1155Mock.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<ERC1155Mock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String uri) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(uri)));
        return deployRemoteCall(ERC1155Mock.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ERC1155Mock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String uri) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(uri)));
        return deployRemoteCall(ERC1155Mock.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ERC1155Mock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String uri) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(uri)));
        return deployRemoteCall(ERC1155Mock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
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
