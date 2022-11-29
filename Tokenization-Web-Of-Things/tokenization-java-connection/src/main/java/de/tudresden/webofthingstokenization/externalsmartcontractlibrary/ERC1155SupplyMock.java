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
public class ERC1155SupplyMock extends Contract {
    public static final String BINARY = "60806040523480156200001157600080fd5b506040516200213f3803806200213f83398101604081905262000034916200011f565b808062000041816200004a565b50505062000238565b80516200005f90600290602084019062000063565b5050565b8280546200007190620001fb565b90600052602060002090601f016020900481019282620000955760008555620000e0565b82601f10620000b057805160ff1916838001178555620000e0565b82800160010185558215620000e0579182015b82811115620000e0578251825591602001919060010190620000c3565b50620000ee929150620000f2565b5090565b5b80821115620000ee5760008155600101620000f3565b634e487b7160e01b600052604160045260246000fd5b600060208083850312156200013357600080fd5b82516001600160401b03808211156200014b57600080fd5b818501915085601f8301126200016057600080fd5b81518181111562000175576200017562000109565b604051601f8201601f19908116603f01168101908382118183101715620001a057620001a062000109565b816040528281528886848701011115620001b957600080fd5b600093505b82841015620001dd5784840186015181850187015292850192620001be565b82841115620001ef5760008684830101525b98975050505050505050565b600181811c908216806200021057607f821691505b602082108114156200023257634e487b7160e01b600052602260045260246000fd5b50919050565b611ef780620002486000396000f3fe608060405234801561001057600080fd5b50600436106100f45760003560e01c80634f558e7911610097578063bd85b03911610066578063bd85b03914610218578063e985e9c514610238578063f242432a14610274578063f5298aca1461028757600080fd5b80634f558e79146101bd5780636b20c454146101df578063731133e9146101f2578063a22cb4651461020557600080fd5b80630e89341c116100d35780630e89341c146101575780631f7fdffa146101775780632eb2c2d61461018a5780634e1273f41461019d57600080fd5b8062fdd58e146100f957806301ffc9a71461011f57806302fe530514610142575b600080fd5b61010c6101073660046113ae565b61029a565b6040519081526020015b60405180910390f35b61013261012d3660046113ee565b610330565b6040519015158152602001610116565b6101556101503660046114b3565b610382565b005b61016a610165366004611504565b61038e565b604051610116919061156a565b610155610185366004611632565b610422565b6101556101983660046116cb565b610434565b6101b06101ab366004611775565b610480565b604051610116919061187b565b6101326101cb366004611504565b600090815260036020526040902054151590565b6101556101ed36600461188e565b6105aa565b610155610200366004611902565b6105ba565b610155610213366004611957565b6105c6565b61010c610226366004611504565b60009081526003602052604090205490565b610132610246366004611993565b6001600160a01b03918216600090815260016020908152604080832093909416825291909152205460ff1690565b6101556102823660046119c6565b6105d5565b610155610295366004611a2b565b61061a565b60006001600160a01b03831661030a5760405162461bcd60e51b815260206004820152602a60248201527f455243313135353a2061646472657373207a65726f206973206e6f742061207660448201526930b634b21037bbb732b960b11b60648201526084015b60405180910390fd5b506000908152602081815260408083206001600160a01b03949094168352929052205490565b60006001600160e01b03198216636cdb3d1360e11b148061036157506001600160e01b031982166303a24d0760e21b145b8061037c57506301ffc9a760e01b6001600160e01b03198316145b92915050565b61038b81610625565b50565b60606002805461039d90611a5e565b80601f01602080910402602001604051908101604052809291908181526020018280546103c990611a5e565b80156104165780601f106103eb57610100808354040283529160200191610416565b820191906000526020600020905b8154815290600101906020018083116103f957829003601f168201915b50505050509050919050565b61042e84848484610638565b50505050565b6001600160a01b03851633148061045057506104508533610246565b61046c5760405162461bcd60e51b815260040161030190611a99565b6104798585858585610792565b5050505050565b606081518351146104e55760405162461bcd60e51b815260206004820152602960248201527f455243313135353a206163636f756e747320616e6420696473206c656e677468604482015268040dad2e6dac2e8c6d60bb1b6064820152608401610301565b6000835167ffffffffffffffff81111561050157610501611412565b60405190808252806020026020018201604052801561052a578160200160208202803683370190505b50905060005b84518110156105a25761057585828151811061054e5761054e611ae7565b602002602001015185838151811061056857610568611ae7565b602002602001015161029a565b82828151811061058757610587611ae7565b602090810291909101015261059b81611b13565b9050610530565b509392505050565b6105b583838361093c565b505050565b61042e84848484610ad8565b6105d1338383610bc1565b5050565b6001600160a01b0385163314806105f157506105f18533610246565b61060d5760405162461bcd60e51b815260040161030190611a99565b6104798585858585610ca2565b6105b5838383610dda565b80516105d19060029060208401906112f9565b6001600160a01b03841661065e5760405162461bcd60e51b815260040161030190611b2e565b815183511461067f5760405162461bcd60e51b815260040161030190611b6f565b3361068f81600087878787610ef2565b60005b845181101561072a578381815181106106ad576106ad611ae7565b60200260200101516000808784815181106106ca576106ca611ae7565b602002602001015181526020019081526020016000206000886001600160a01b03166001600160a01b0316815260200190815260200160002060008282546107129190611bb7565b9091555081905061072281611b13565b915050610692565b50846001600160a01b031660006001600160a01b0316826001600160a01b03167f4a39dc06d4c0dbc64b70af90fd698a233a518aa5d07e595d983b8c0526c8f7fb878760405161077b929190611bcf565b60405180910390a461047981600087878787610f00565b81518351146107b35760405162461bcd60e51b815260040161030190611b6f565b6001600160a01b0384166107d95760405162461bcd60e51b815260040161030190611bfd565b336107e8818787878787610ef2565b60005b84518110156108ce57600085828151811061080857610808611ae7565b60200260200101519050600085838151811061082657610826611ae7565b602090810291909101810151600084815280835260408082206001600160a01b038e1683529093529190912054909150818110156108765760405162461bcd60e51b815260040161030190611c42565b6000838152602081815260408083206001600160a01b038e8116855292528083208585039055908b168252812080548492906108b3908490611bb7565b92505081905550505050806108c790611b13565b90506107eb565b50846001600160a01b0316866001600160a01b0316826001600160a01b03167f4a39dc06d4c0dbc64b70af90fd698a233a518aa5d07e595d983b8c0526c8f7fb878760405161091e929190611bcf565b60405180910390a4610934818787878787610f00565b505050505050565b6001600160a01b0383166109625760405162461bcd60e51b815260040161030190611c8c565b80518251146109835760405162461bcd60e51b815260040161030190611b6f565b60003390506109a681856000868660405180602001604052806000815250610ef2565b60005b8351811015610a6b5760008482815181106109c6576109c6611ae7565b6020026020010151905060008483815181106109e4576109e4611ae7565b602090810291909101810151600084815280835260408082206001600160a01b038c168352909352919091205490915081811015610a345760405162461bcd60e51b815260040161030190611ccf565b6000928352602083815260408085206001600160a01b038b1686529091529092209103905580610a6381611b13565b9150506109a9565b5060006001600160a01b0316846001600160a01b0316826001600160a01b03167f4a39dc06d4c0dbc64b70af90fd698a233a518aa5d07e595d983b8c0526c8f7fb8686604051610abc929190611bcf565b60405180910390a460408051602081019091526000905261042e565b6001600160a01b038416610afe5760405162461bcd60e51b815260040161030190611b2e565b336000610b0a8561106b565b90506000610b178561106b565b9050610b2883600089858589610ef2565b6000868152602081815260408083206001600160a01b038b16845290915281208054879290610b58908490611bb7565b909155505060408051878152602081018790526001600160a01b03808a1692600092918716917fc3d58168c5ae7397731d063d5bbf3d657854427343f4c083240f7aacaa2d0f62910160405180910390a4610bb8836000898989896110b6565b50505050505050565b816001600160a01b0316836001600160a01b03161415610c355760405162461bcd60e51b815260206004820152602960248201527f455243313135353a2073657474696e6720617070726f76616c20737461747573604482015268103337b91039b2b63360b91b6064820152608401610301565b6001600160a01b03838116600081815260016020908152604080832094871680845294825291829020805460ff191686151590811790915591519182527f17307eab39ab6107e8899845ad3d59bd9653f200f220920489ca2b5937696c31910160405180910390a3505050565b6001600160a01b038416610cc85760405162461bcd60e51b815260040161030190611bfd565b336000610cd48561106b565b90506000610ce18561106b565b9050610cf1838989858589610ef2565b6000868152602081815260408083206001600160a01b038c16845290915290205485811015610d325760405162461bcd60e51b815260040161030190611c42565b6000878152602081815260408083206001600160a01b038d8116855292528083208985039055908a16825281208054889290610d6f908490611bb7565b909155505060408051888152602081018890526001600160a01b03808b16928c821692918816917fc3d58168c5ae7397731d063d5bbf3d657854427343f4c083240f7aacaa2d0f62910160405180910390a4610dcf848a8a8a8a8a6110b6565b505050505050505050565b6001600160a01b038316610e005760405162461bcd60e51b815260040161030190611c8c565b336000610e0c8461106b565b90506000610e198461106b565b9050610e3983876000858560405180602001604052806000815250610ef2565b6000858152602081815260408083206001600160a01b038a16845290915290205484811015610e7a5760405162461bcd60e51b815260040161030190611ccf565b6000868152602081815260408083206001600160a01b038b81168086529184528285208a8703905582518b81529384018a90529092908816917fc3d58168c5ae7397731d063d5bbf3d657854427343f4c083240f7aacaa2d0f62910160405180910390a4604080516020810190915260009052610bb8565b610934868686868686611180565b6001600160a01b0384163b156109345760405163bc197c8160e01b81526001600160a01b0385169063bc197c8190610f449089908990889088908890600401611d13565b602060405180830381600087803b158015610f5e57600080fd5b505af1925050508015610f8e575060408051601f3d908101601f19168201909252610f8b91810190611d71565b60015b61103b57610f9a611d8e565b806308c379a01415610fd45750610faf611daa565b80610fba5750610fd6565b8060405162461bcd60e51b8152600401610301919061156a565b505b60405162461bcd60e51b815260206004820152603460248201527f455243313135353a207472616e7366657220746f206e6f6e2d455243313135356044820152732932b1b2b4bb32b91034b6b83632b6b2b73a32b960611b6064820152608401610301565b6001600160e01b0319811663bc197c8160e01b14610bb85760405162461bcd60e51b815260040161030190611e34565b604080516001808252818301909252606091600091906020808301908036833701905050905082816000815181106110a5576110a5611ae7565b602090810291909101015292915050565b6001600160a01b0384163b156109345760405163f23a6e6160e01b81526001600160a01b0385169063f23a6e61906110fa9089908990889088908890600401611e7c565b602060405180830381600087803b15801561111457600080fd5b505af1925050508015611144575060408051601f3d908101601f1916820190925261114191810190611d71565b60015b61115057610f9a611d8e565b6001600160e01b0319811663f23a6e6160e01b14610bb85760405162461bcd60e51b815260040161030190611e34565b6001600160a01b0385166112075760005b8351811015611205578281815181106111ac576111ac611ae7565b6020026020010151600360008684815181106111ca576111ca611ae7565b6020026020010151815260200190815260200160002060008282546111ef9190611bb7565b909155506111fe905081611b13565b9050611191565b505b6001600160a01b0384166109345760005b8351811015610bb857600084828151811061123557611235611ae7565b60200260200101519050600084838151811061125357611253611ae7565b60200260200101519050600060036000848152602001908152602001600020549050818110156112d65760405162461bcd60e51b815260206004820152602860248201527f455243313135353a206275726e20616d6f756e74206578636565647320746f74604482015267616c537570706c7960c01b6064820152608401610301565b600092835260036020526040909220910390556112f281611b13565b9050611218565b82805461130590611a5e565b90600052602060002090601f016020900481019282611327576000855561136d565b82601f1061134057805160ff191683800117855561136d565b8280016001018555821561136d579182015b8281111561136d578251825591602001919060010190611352565b5061137992915061137d565b5090565b5b80821115611379576000815560010161137e565b80356001600160a01b03811681146113a957600080fd5b919050565b600080604083850312156113c157600080fd5b6113ca83611392565b946020939093013593505050565b6001600160e01b03198116811461038b57600080fd5b60006020828403121561140057600080fd5b813561140b816113d8565b9392505050565b634e487b7160e01b600052604160045260246000fd5b601f8201601f1916810167ffffffffffffffff8111828210171561144e5761144e611412565b6040525050565b600067ffffffffffffffff83111561146f5761146f611412565b604051611486601f8501601f191660200182611428565b80915083815284848401111561149b57600080fd5b83836020830137600060208583010152509392505050565b6000602082840312156114c557600080fd5b813567ffffffffffffffff8111156114dc57600080fd5b8201601f810184136114ed57600080fd5b6114fc84823560208401611455565b949350505050565b60006020828403121561151657600080fd5b5035919050565b6000815180845260005b8181101561154357602081850181015186830182015201611527565b81811115611555576000602083870101525b50601f01601f19169290920160200192915050565b60208152600061140b602083018461151d565b600067ffffffffffffffff82111561159757611597611412565b5060051b60200190565b600082601f8301126115b257600080fd5b813560206115bf8261157d565b6040516115cc8282611428565b83815260059390931b85018201928281019150868411156115ec57600080fd5b8286015b8481101561160757803583529183019183016115f0565b509695505050505050565b600082601f83011261162357600080fd5b61140b83833560208501611455565b6000806000806080858703121561164857600080fd5b61165185611392565b9350602085013567ffffffffffffffff8082111561166e57600080fd5b61167a888389016115a1565b9450604087013591508082111561169057600080fd5b61169c888389016115a1565b935060608701359150808211156116b257600080fd5b506116bf87828801611612565b91505092959194509250565b600080600080600060a086880312156116e357600080fd5b6116ec86611392565b94506116fa60208701611392565b9350604086013567ffffffffffffffff8082111561171757600080fd5b61172389838a016115a1565b9450606088013591508082111561173957600080fd5b61174589838a016115a1565b9350608088013591508082111561175b57600080fd5b5061176888828901611612565b9150509295509295909350565b6000806040838503121561178857600080fd5b823567ffffffffffffffff808211156117a057600080fd5b818501915085601f8301126117b457600080fd5b813560206117c18261157d565b6040516117ce8282611428565b83815260059390931b85018201928281019150898411156117ee57600080fd5b948201945b838610156118135761180486611392565b825294820194908201906117f3565b9650508601359250508082111561182957600080fd5b50611836858286016115a1565b9150509250929050565b600081518084526020808501945080840160005b8381101561187057815187529582019590820190600101611854565b509495945050505050565b60208152600061140b6020830184611840565b6000806000606084860312156118a357600080fd5b6118ac84611392565b9250602084013567ffffffffffffffff808211156118c957600080fd5b6118d5878388016115a1565b935060408601359150808211156118eb57600080fd5b506118f8868287016115a1565b9150509250925092565b6000806000806080858703121561191857600080fd5b61192185611392565b93506020850135925060408501359150606085013567ffffffffffffffff81111561194b57600080fd5b6116bf87828801611612565b6000806040838503121561196a57600080fd5b61197383611392565b91506020830135801515811461198857600080fd5b809150509250929050565b600080604083850312156119a657600080fd5b6119af83611392565b91506119bd60208401611392565b90509250929050565b600080600080600060a086880312156119de57600080fd5b6119e786611392565b94506119f560208701611392565b93506040860135925060608601359150608086013567ffffffffffffffff811115611a1f57600080fd5b61176888828901611612565b600080600060608486031215611a4057600080fd5b611a4984611392565b95602085013595506040909401359392505050565b600181811c90821680611a7257607f821691505b60208210811415611a9357634e487b7160e01b600052602260045260246000fd5b50919050565b6020808252602e908201527f455243313135353a2063616c6c6572206973206e6f7420746f6b656e206f776e60408201526d195c881bdc88185c1c1c9bdd995960921b606082015260800190565b634e487b7160e01b600052603260045260246000fd5b634e487b7160e01b600052601160045260246000fd5b6000600019821415611b2757611b27611afd565b5060010190565b60208082526021908201527f455243313135353a206d696e7420746f20746865207a65726f206164647265736040820152607360f81b606082015260800190565b60208082526028908201527f455243313135353a2069647320616e6420616d6f756e7473206c656e677468206040820152670dad2e6dac2e8c6d60c31b606082015260800190565b60008219821115611bca57611bca611afd565b500190565b604081526000611be26040830185611840565b8281036020840152611bf48185611840565b95945050505050565b60208082526025908201527f455243313135353a207472616e7366657220746f20746865207a65726f206164604082015264647265737360d81b606082015260800190565b6020808252602a908201527f455243313135353a20696e73756666696369656e742062616c616e636520666f60408201526939103a3930b739b332b960b11b606082015260800190565b60208082526023908201527f455243313135353a206275726e2066726f6d20746865207a65726f206164647260408201526265737360e81b606082015260800190565b60208082526024908201527f455243313135353a206275726e20616d6f756e7420657863656564732062616c604082015263616e636560e01b606082015260800190565b6001600160a01b0386811682528516602082015260a060408201819052600090611d3f90830186611840565b8281036060840152611d518186611840565b90508281036080840152611d65818561151d565b98975050505050505050565b600060208284031215611d8357600080fd5b815161140b816113d8565b600060033d1115611da75760046000803e5060005160e01c5b90565b600060443d1015611db85790565b6040516003193d81016004833e81513d67ffffffffffffffff8160248401118184111715611de857505050505090565b8285019150815181811115611e005750505050505090565b843d8701016020828501011115611e1a5750505050505090565b611e2960208286010187611428565b509095945050505050565b60208082526028908201527f455243313135353a204552433131353552656365697665722072656a656374656040820152676420746f6b656e7360c01b606082015260800190565b6001600160a01b03868116825285166020820152604081018490526060810183905260a060808201819052600090611eb69083018461151d565b97965050505050505056fea26469706673582212200caaea2fc8d8f141a9a28bd402e1dae1596cf2cfb99b46c5f6fff5580ad8604664736f6c63430008090033";

    public static final String FUNC_BALANCEOF = "balanceOf";

    public static final String FUNC_BALANCEOFBATCH = "balanceOfBatch";

    public static final String FUNC_BURN = "burn";

    public static final String FUNC_BURNBATCH = "burnBatch";

    public static final String FUNC_EXISTS = "exists";

    public static final String FUNC_ISAPPROVEDFORALL = "isApprovedForAll";

    public static final String FUNC_MINT = "mint";

    public static final String FUNC_MINTBATCH = "mintBatch";

    public static final String FUNC_SAFEBATCHTRANSFERFROM = "safeBatchTransferFrom";

    public static final String FUNC_SAFETRANSFERFROM = "safeTransferFrom";

    public static final String FUNC_SETAPPROVALFORALL = "setApprovalForAll";

    public static final String FUNC_SETURI = "setURI";

    public static final String FUNC_SUPPORTSINTERFACE = "supportsInterface";

    public static final String FUNC_TOTALSUPPLY = "totalSupply";

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
    protected ERC1155SupplyMock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ERC1155SupplyMock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ERC1155SupplyMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ERC1155SupplyMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
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

    public RemoteFunctionCall<Boolean> exists(BigInteger id) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_EXISTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(id)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
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

    public RemoteFunctionCall<BigInteger> totalSupply(BigInteger id) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_TOTALSUPPLY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(id)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> uri(BigInteger param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_URI, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static ERC1155SupplyMock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ERC1155SupplyMock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ERC1155SupplyMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ERC1155SupplyMock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ERC1155SupplyMock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ERC1155SupplyMock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ERC1155SupplyMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ERC1155SupplyMock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ERC1155SupplyMock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String uri) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(uri)));
        return deployRemoteCall(ERC1155SupplyMock.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<ERC1155SupplyMock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String uri) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(uri)));
        return deployRemoteCall(ERC1155SupplyMock.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ERC1155SupplyMock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String uri) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(uri)));
        return deployRemoteCall(ERC1155SupplyMock.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ERC1155SupplyMock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String uri) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(uri)));
        return deployRemoteCall(ERC1155SupplyMock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
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
