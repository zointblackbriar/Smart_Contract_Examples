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
public class ERC1155PausableMock extends Contract {
    public static final String BINARY = "60806040523480156200001157600080fd5b506040516200214c3803806200214c833981016040819052620000349162000129565b8080620000418162000054565b50506003805460ff191690555062000242565b8051620000699060029060208401906200006d565b5050565b8280546200007b9062000205565b90600052602060002090601f0160209004810192826200009f5760008555620000ea565b82601f10620000ba57805160ff1916838001178555620000ea565b82800160010185558215620000ea579182015b82811115620000ea578251825591602001919060010190620000cd565b50620000f8929150620000fc565b5090565b5b80821115620000f85760008155600101620000fd565b634e487b7160e01b600052604160045260246000fd5b600060208083850312156200013d57600080fd5b82516001600160401b03808211156200015557600080fd5b818501915085601f8301126200016a57600080fd5b8151818111156200017f576200017f62000113565b604051601f8201601f19908116603f01168101908382118183101715620001aa57620001aa62000113565b816040528281528886848701011115620001c357600080fd5b600093505b82841015620001e75784840186015181850187015292850192620001c8565b82841115620001f95760008684830101525b98975050505050505050565b600181811c908216806200021a57607f821691505b602082108114156200023c57634e487b7160e01b600052602260045260246000fd5b50919050565b611efa80620002526000396000f3fe608060405234801561001057600080fd5b50600436106100ff5760003560e01c80635c975abb11610097578063a22cb46511610066578063a22cb46514610209578063e985e9c51461021c578063f242432a14610258578063f5298aca1461026b57600080fd5b80635c975abb146101d05780636b20c454146101db578063731133e9146101ee5780638456cb591461020157600080fd5b80631f7fdffa116100d35780631f7fdffa146101825780632eb2c2d6146101955780633f4ba83a146101a85780634e1273f4146101b057600080fd5b8062fdd58e1461010457806301ffc9a71461012a57806302fe53051461014d5780630e89341c14610162575b600080fd5b6101176101123660046113b1565b61027e565b6040519081526020015b60405180910390f35b61013d6101383660046113f1565b610314565b6040519015158152602001610121565b61016061015b3660046114b6565b610366565b005b610175610170366004611507565b610372565b604051610121919061156d565b610160610190366004611635565b610406565b6101606101a33660046116ce565b610418565b610160610464565b6101c36101be366004611778565b61046e565b604051610121919061187e565b60035460ff1661013d565b6101606101e9366004611891565b610598565b6101606101fc366004611905565b6105a8565b6101606105b4565b61016061021736600461195a565b6105bc565b61013d61022a366004611996565b6001600160a01b03918216600090815260016020908152604080832093909416825291909152205460ff1690565b6101606102663660046119c9565b6105cb565b610160610279366004611a2e565b610610565b60006001600160a01b0383166102ee5760405162461bcd60e51b815260206004820152602a60248201527f455243313135353a2061646472657373207a65726f206973206e6f742061207660448201526930b634b21037bbb732b960b11b60648201526084015b60405180910390fd5b506000908152602081815260408083206001600160a01b03949094168352929052205490565b60006001600160e01b03198216636cdb3d1360e11b148061034557506001600160e01b031982166303a24d0760e21b145b8061036057506301ffc9a760e01b6001600160e01b03198316145b92915050565b61036f8161061b565b50565b60606002805461038190611a61565b80601f01602080910402602001604051908101604052809291908181526020018280546103ad90611a61565b80156103fa5780601f106103cf576101008083540402835291602001916103fa565b820191906000526020600020905b8154815290600101906020018083116103dd57829003601f168201915b50505050509050919050565b6104128484848461062e565b50505050565b6001600160a01b0385163314806104345750610434853361022a565b6104505760405162461bcd60e51b81526004016102e590611a9c565b61045d8585858585610788565b5050505050565b61046c610932565b565b606081518351146104d35760405162461bcd60e51b815260206004820152602960248201527f455243313135353a206163636f756e747320616e6420696473206c656e677468604482015268040dad2e6dac2e8c6d60bb1b60648201526084016102e5565b6000835167ffffffffffffffff8111156104ef576104ef611415565b604051908082528060200260200182016040528015610518578160200160208202803683370190505b50905060005b84518110156105905761056385828151811061053c5761053c611aea565b602002602001015185838151811061055657610556611aea565b602002602001015161027e565b82828151811061057557610575611aea565b602090810291909101015261058981611b16565b905061051e565b509392505050565b6105a3838383610984565b505050565b61041284848484610b20565b61046c610c09565b6105c7338383610c46565b5050565b6001600160a01b0385163314806105e757506105e7853361022a565b6106035760405162461bcd60e51b81526004016102e590611a9c565b61045d8585858585610d27565b6105a3838383610e5f565b80516105c79060029060208401906112fc565b6001600160a01b0384166106545760405162461bcd60e51b81526004016102e590611b31565b81518351146106755760405162461bcd60e51b81526004016102e590611b72565b3361068581600087878787610f77565b60005b8451811015610720578381815181106106a3576106a3611aea565b60200260200101516000808784815181106106c0576106c0611aea565b602002602001015181526020019081526020016000206000886001600160a01b03166001600160a01b0316815260200190815260200160002060008282546107089190611bba565b9091555081905061071881611b16565b915050610688565b50846001600160a01b031660006001600160a01b0316826001600160a01b03167f4a39dc06d4c0dbc64b70af90fd698a233a518aa5d07e595d983b8c0526c8f7fb8787604051610771929190611bd2565b60405180910390a461045d81600087878787610f85565b81518351146107a95760405162461bcd60e51b81526004016102e590611b72565b6001600160a01b0384166107cf5760405162461bcd60e51b81526004016102e590611c00565b336107de818787878787610f77565b60005b84518110156108c45760008582815181106107fe576107fe611aea565b60200260200101519050600085838151811061081c5761081c611aea565b602090810291909101810151600084815280835260408082206001600160a01b038e16835290935291909120549091508181101561086c5760405162461bcd60e51b81526004016102e590611c45565b6000838152602081815260408083206001600160a01b038e8116855292528083208585039055908b168252812080548492906108a9908490611bba565b92505081905550505050806108bd90611b16565b90506107e1565b50846001600160a01b0316866001600160a01b0316826001600160a01b03167f4a39dc06d4c0dbc64b70af90fd698a233a518aa5d07e595d983b8c0526c8f7fb8787604051610914929190611bd2565b60405180910390a461092a818787878787610f85565b505050505050565b61093a6110f0565b6003805460ff191690557f5db9ee0a495bf2e6ff9c91a7834c1ba4fdd244a5e8aa4e537bd38aeae4b073aa335b6040516001600160a01b03909116815260200160405180910390a1565b6001600160a01b0383166109aa5760405162461bcd60e51b81526004016102e590611c8f565b80518251146109cb5760405162461bcd60e51b81526004016102e590611b72565b60003390506109ee81856000868660405180602001604052806000815250610f77565b60005b8351811015610ab3576000848281518110610a0e57610a0e611aea565b602002602001015190506000848381518110610a2c57610a2c611aea565b602090810291909101810151600084815280835260408082206001600160a01b038c168352909352919091205490915081811015610a7c5760405162461bcd60e51b81526004016102e590611cd2565b6000928352602083815260408085206001600160a01b038b1686529091529092209103905580610aab81611b16565b9150506109f1565b5060006001600160a01b0316846001600160a01b0316826001600160a01b03167f4a39dc06d4c0dbc64b70af90fd698a233a518aa5d07e595d983b8c0526c8f7fb8686604051610b04929190611bd2565b60405180910390a4604080516020810190915260009052610412565b6001600160a01b038416610b465760405162461bcd60e51b81526004016102e590611b31565b336000610b5285611139565b90506000610b5f85611139565b9050610b7083600089858589610f77565b6000868152602081815260408083206001600160a01b038b16845290915281208054879290610ba0908490611bba565b909155505060408051878152602081018790526001600160a01b03808a1692600092918716917fc3d58168c5ae7397731d063d5bbf3d657854427343f4c083240f7aacaa2d0f62910160405180910390a4610c0083600089898989611184565b50505050505050565b610c1161124e565b6003805460ff191660011790557f62e78cea01bee320cd4e420270b5ea74000d11b0c9f74754ebdbfc544b05a2586109673390565b816001600160a01b0316836001600160a01b03161415610cba5760405162461bcd60e51b815260206004820152602960248201527f455243313135353a2073657474696e6720617070726f76616c20737461747573604482015268103337b91039b2b63360b91b60648201526084016102e5565b6001600160a01b03838116600081815260016020908152604080832094871680845294825291829020805460ff191686151590811790915591519182527f17307eab39ab6107e8899845ad3d59bd9653f200f220920489ca2b5937696c31910160405180910390a3505050565b6001600160a01b038416610d4d5760405162461bcd60e51b81526004016102e590611c00565b336000610d5985611139565b90506000610d6685611139565b9050610d76838989858589610f77565b6000868152602081815260408083206001600160a01b038c16845290915290205485811015610db75760405162461bcd60e51b81526004016102e590611c45565b6000878152602081815260408083206001600160a01b038d8116855292528083208985039055908a16825281208054889290610df4908490611bba565b909155505060408051888152602081018890526001600160a01b03808b16928c821692918816917fc3d58168c5ae7397731d063d5bbf3d657854427343f4c083240f7aacaa2d0f62910160405180910390a4610e54848a8a8a8a8a611184565b505050505050505050565b6001600160a01b038316610e855760405162461bcd60e51b81526004016102e590611c8f565b336000610e9184611139565b90506000610e9e84611139565b9050610ebe83876000858560405180602001604052806000815250610f77565b6000858152602081815260408083206001600160a01b038a16845290915290205484811015610eff5760405162461bcd60e51b81526004016102e590611cd2565b6000868152602081815260408083206001600160a01b038b81168086529184528285208a8703905582518b81529384018a90529092908816917fc3d58168c5ae7397731d063d5bbf3d657854427343f4c083240f7aacaa2d0f62910160405180910390a4604080516020810190915260009052610c00565b61092a868686868686611294565b6001600160a01b0384163b1561092a5760405163bc197c8160e01b81526001600160a01b0385169063bc197c8190610fc99089908990889088908890600401611d16565b602060405180830381600087803b158015610fe357600080fd5b505af1925050508015611013575060408051601f3d908101601f1916820190925261101091810190611d74565b60015b6110c05761101f611d91565b806308c379a014156110595750611034611dad565b8061103f575061105b565b8060405162461bcd60e51b81526004016102e5919061156d565b505b60405162461bcd60e51b815260206004820152603460248201527f455243313135353a207472616e7366657220746f206e6f6e2d455243313135356044820152732932b1b2b4bb32b91034b6b83632b6b2b73a32b960611b60648201526084016102e5565b6001600160e01b0319811663bc197c8160e01b14610c005760405162461bcd60e51b81526004016102e590611e37565b60035460ff1661046c5760405162461bcd60e51b815260206004820152601460248201527314185d5cd8589b194e881b9bdd081c185d5cd95960621b60448201526064016102e5565b6040805160018082528183019092526060916000919060208083019080368337019050509050828160008151811061117357611173611aea565b602090810291909101015292915050565b6001600160a01b0384163b1561092a5760405163f23a6e6160e01b81526001600160a01b0385169063f23a6e61906111c89089908990889088908890600401611e7f565b602060405180830381600087803b1580156111e257600080fd5b505af1925050508015611212575060408051601f3d908101601f1916820190925261120f91810190611d74565b60015b61121e5761101f611d91565b6001600160e01b0319811663f23a6e6160e01b14610c005760405162461bcd60e51b81526004016102e590611e37565b60035460ff161561046c5760405162461bcd60e51b815260206004820152601060248201526f14185d5cd8589b194e881c185d5cd95960821b60448201526064016102e5565b60035460ff161561092a5760405162461bcd60e51b815260206004820152602c60248201527f455243313135355061757361626c653a20746f6b656e207472616e736665722060448201526b1dda1a5b19481c185d5cd95960a21b60648201526084016102e5565b82805461130890611a61565b90600052602060002090601f01602090048101928261132a5760008555611370565b82601f1061134357805160ff1916838001178555611370565b82800160010185558215611370579182015b82811115611370578251825591602001919060010190611355565b5061137c929150611380565b5090565b5b8082111561137c5760008155600101611381565b80356001600160a01b03811681146113ac57600080fd5b919050565b600080604083850312156113c457600080fd5b6113cd83611395565b946020939093013593505050565b6001600160e01b03198116811461036f57600080fd5b60006020828403121561140357600080fd5b813561140e816113db565b9392505050565b634e487b7160e01b600052604160045260246000fd5b601f8201601f1916810167ffffffffffffffff8111828210171561145157611451611415565b6040525050565b600067ffffffffffffffff83111561147257611472611415565b604051611489601f8501601f19166020018261142b565b80915083815284848401111561149e57600080fd5b83836020830137600060208583010152509392505050565b6000602082840312156114c857600080fd5b813567ffffffffffffffff8111156114df57600080fd5b8201601f810184136114f057600080fd5b6114ff84823560208401611458565b949350505050565b60006020828403121561151957600080fd5b5035919050565b6000815180845260005b818110156115465760208185018101518683018201520161152a565b81811115611558576000602083870101525b50601f01601f19169290920160200192915050565b60208152600061140e6020830184611520565b600067ffffffffffffffff82111561159a5761159a611415565b5060051b60200190565b600082601f8301126115b557600080fd5b813560206115c282611580565b6040516115cf828261142b565b83815260059390931b85018201928281019150868411156115ef57600080fd5b8286015b8481101561160a57803583529183019183016115f3565b509695505050505050565b600082601f83011261162657600080fd5b61140e83833560208501611458565b6000806000806080858703121561164b57600080fd5b61165485611395565b9350602085013567ffffffffffffffff8082111561167157600080fd5b61167d888389016115a4565b9450604087013591508082111561169357600080fd5b61169f888389016115a4565b935060608701359150808211156116b557600080fd5b506116c287828801611615565b91505092959194509250565b600080600080600060a086880312156116e657600080fd5b6116ef86611395565b94506116fd60208701611395565b9350604086013567ffffffffffffffff8082111561171a57600080fd5b61172689838a016115a4565b9450606088013591508082111561173c57600080fd5b61174889838a016115a4565b9350608088013591508082111561175e57600080fd5b5061176b88828901611615565b9150509295509295909350565b6000806040838503121561178b57600080fd5b823567ffffffffffffffff808211156117a357600080fd5b818501915085601f8301126117b757600080fd5b813560206117c482611580565b6040516117d1828261142b565b83815260059390931b85018201928281019150898411156117f157600080fd5b948201945b838610156118165761180786611395565b825294820194908201906117f6565b9650508601359250508082111561182c57600080fd5b50611839858286016115a4565b9150509250929050565b600081518084526020808501945080840160005b8381101561187357815187529582019590820190600101611857565b509495945050505050565b60208152600061140e6020830184611843565b6000806000606084860312156118a657600080fd5b6118af84611395565b9250602084013567ffffffffffffffff808211156118cc57600080fd5b6118d8878388016115a4565b935060408601359150808211156118ee57600080fd5b506118fb868287016115a4565b9150509250925092565b6000806000806080858703121561191b57600080fd5b61192485611395565b93506020850135925060408501359150606085013567ffffffffffffffff81111561194e57600080fd5b6116c287828801611615565b6000806040838503121561196d57600080fd5b61197683611395565b91506020830135801515811461198b57600080fd5b809150509250929050565b600080604083850312156119a957600080fd5b6119b283611395565b91506119c060208401611395565b90509250929050565b600080600080600060a086880312156119e157600080fd5b6119ea86611395565b94506119f860208701611395565b93506040860135925060608601359150608086013567ffffffffffffffff811115611a2257600080fd5b61176b88828901611615565b600080600060608486031215611a4357600080fd5b611a4c84611395565b95602085013595506040909401359392505050565b600181811c90821680611a7557607f821691505b60208210811415611a9657634e487b7160e01b600052602260045260246000fd5b50919050565b6020808252602e908201527f455243313135353a2063616c6c6572206973206e6f7420746f6b656e206f776e60408201526d195c881bdc88185c1c1c9bdd995960921b606082015260800190565b634e487b7160e01b600052603260045260246000fd5b634e487b7160e01b600052601160045260246000fd5b6000600019821415611b2a57611b2a611b00565b5060010190565b60208082526021908201527f455243313135353a206d696e7420746f20746865207a65726f206164647265736040820152607360f81b606082015260800190565b60208082526028908201527f455243313135353a2069647320616e6420616d6f756e7473206c656e677468206040820152670dad2e6dac2e8c6d60c31b606082015260800190565b60008219821115611bcd57611bcd611b00565b500190565b604081526000611be56040830185611843565b8281036020840152611bf78185611843565b95945050505050565b60208082526025908201527f455243313135353a207472616e7366657220746f20746865207a65726f206164604082015264647265737360d81b606082015260800190565b6020808252602a908201527f455243313135353a20696e73756666696369656e742062616c616e636520666f60408201526939103a3930b739b332b960b11b606082015260800190565b60208082526023908201527f455243313135353a206275726e2066726f6d20746865207a65726f206164647260408201526265737360e81b606082015260800190565b60208082526024908201527f455243313135353a206275726e20616d6f756e7420657863656564732062616c604082015263616e636560e01b606082015260800190565b6001600160a01b0386811682528516602082015260a060408201819052600090611d4290830186611843565b8281036060840152611d548186611843565b90508281036080840152611d688185611520565b98975050505050505050565b600060208284031215611d8657600080fd5b815161140e816113db565b600060033d1115611daa5760046000803e5060005160e01c5b90565b600060443d1015611dbb5790565b6040516003193d81016004833e81513d67ffffffffffffffff8160248401118184111715611deb57505050505090565b8285019150815181811115611e035750505050505090565b843d8701016020828501011115611e1d5750505050505090565b611e2c6020828601018761142b565b509095945050505050565b60208082526028908201527f455243313135353a204552433131353552656365697665722072656a656374656040820152676420746f6b656e7360c01b606082015260800190565b6001600160a01b03868116825285166020820152604081018490526060810183905260a060808201819052600090611eb990830184611520565b97965050505050505056fea2646970667358221220cab17c21b932e6ab28606653c9b4454de8955f050aa4c2d170ebe8c1ff784f2864736f6c63430008090033";

    public static final String FUNC_BALANCEOF = "balanceOf";

    public static final String FUNC_BALANCEOFBATCH = "balanceOfBatch";

    public static final String FUNC_BURN = "burn";

    public static final String FUNC_BURNBATCH = "burnBatch";

    public static final String FUNC_ISAPPROVEDFORALL = "isApprovedForAll";

    public static final String FUNC_MINT = "mint";

    public static final String FUNC_MINTBATCH = "mintBatch";

    public static final String FUNC_PAUSE = "pause";

    public static final String FUNC_PAUSED = "paused";

    public static final String FUNC_SAFEBATCHTRANSFERFROM = "safeBatchTransferFrom";

    public static final String FUNC_SAFETRANSFERFROM = "safeTransferFrom";

    public static final String FUNC_SETAPPROVALFORALL = "setApprovalForAll";

    public static final String FUNC_SETURI = "setURI";

    public static final String FUNC_SUPPORTSINTERFACE = "supportsInterface";

    public static final String FUNC_UNPAUSE = "unpause";

    public static final String FUNC_URI = "uri";

    public static final Event APPROVALFORALL_EVENT = new Event("ApprovalForAll", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Bool>() {}));
    ;

    public static final Event PAUSED_EVENT = new Event("Paused", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
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

    public static final Event UNPAUSED_EVENT = new Event("Unpaused", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    ;

    @Deprecated
    protected ERC1155PausableMock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ERC1155PausableMock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ERC1155PausableMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ERC1155PausableMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
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

    public static List<PausedEventResponse> getPausedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(PAUSED_EVENT, transactionReceipt);
        ArrayList<PausedEventResponse> responses = new ArrayList<PausedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            PausedEventResponse typedResponse = new PausedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.account = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<PausedEventResponse> pausedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, PausedEventResponse>() {
            @Override
            public PausedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(PAUSED_EVENT, log);
                PausedEventResponse typedResponse = new PausedEventResponse();
                typedResponse.log = log;
                typedResponse.account = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<PausedEventResponse> pausedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PAUSED_EVENT));
        return pausedEventFlowable(filter);
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

    public static List<UnpausedEventResponse> getUnpausedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(UNPAUSED_EVENT, transactionReceipt);
        ArrayList<UnpausedEventResponse> responses = new ArrayList<UnpausedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            UnpausedEventResponse typedResponse = new UnpausedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.account = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<UnpausedEventResponse> unpausedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, UnpausedEventResponse>() {
            @Override
            public UnpausedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(UNPAUSED_EVENT, log);
                UnpausedEventResponse typedResponse = new UnpausedEventResponse();
                typedResponse.log = log;
                typedResponse.account = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<UnpausedEventResponse> unpausedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(UNPAUSED_EVENT));
        return unpausedEventFlowable(filter);
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

    public RemoteFunctionCall<TransactionReceipt> pause() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_PAUSE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> paused() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_PAUSED, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
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

    public RemoteFunctionCall<TransactionReceipt> unpause() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_UNPAUSE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> uri(BigInteger param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_URI, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static ERC1155PausableMock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ERC1155PausableMock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ERC1155PausableMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ERC1155PausableMock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ERC1155PausableMock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ERC1155PausableMock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ERC1155PausableMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ERC1155PausableMock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ERC1155PausableMock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String uri) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(uri)));
        return deployRemoteCall(ERC1155PausableMock.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<ERC1155PausableMock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String uri) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(uri)));
        return deployRemoteCall(ERC1155PausableMock.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ERC1155PausableMock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String uri) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(uri)));
        return deployRemoteCall(ERC1155PausableMock.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ERC1155PausableMock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String uri) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(uri)));
        return deployRemoteCall(ERC1155PausableMock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class ApprovalForAllEventResponse extends BaseEventResponse {
        public String account;

        public String operator;

        public Boolean approved;
    }

    public static class PausedEventResponse extends BaseEventResponse {
        public String account;
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

    public static class UnpausedEventResponse extends BaseEventResponse {
        public String account;
    }
}
