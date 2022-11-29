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
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.DynamicBytes;
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
public class ERC777Mock extends Contract {
    public static final String BINARY = "60806040523480156200001157600080fd5b50604051620023c2380380620023c2833981016040819052620000349162000803565b82828282600290805190602001906200004f929190620005fc565b50815162000065906003906020850190620005fc565b5080516200007b9060049060208401906200068b565b5060005b8151811015620000eb57600160056000848481518110620000a457620000a46200092c565b6020908102919091018101516001600160a01b03168252810191909152604001600020805460ff191691151591909117905580620000e28162000958565b9150506200007f565b506040516329965a1d60e01b815230600482018190527fac7fbab5f54a3ca8194167523c6753bfeb96a445279294b6125b68cce217705460248301526044820152731820a4b7618bde71dce8cdc73aab6c95905fad24906329965a1d90606401600060405180830381600087803b1580156200016657600080fd5b505af11580156200017b573d6000803e3d6000fd5b50506040516329965a1d60e01b815230600482018190527faea199e31a596269b42cdafd93407f14436db6e4cad65417994c2eb37381e05a60248301526044820152731820a4b7618bde71dce8cdc73aab6c95905fad2492506329965a1d9150606401600060405180830381600087803b158015620001f957600080fd5b505af11580156200020e573d6000803e3d6000fd5b5050505050505062000247858560405180602001604052806000815250604051806020016040528060008152506200025260201b60201c565b505050505062000ab8565b6200026284848484600162000268565b50505050565b6001600160a01b038516620002c45760405162461bcd60e51b815260206004820181905260248201527f4552433737373a206d696e7420746f20746865207a65726f206164647265737360448201526064015b60405180910390fd5b33620002d48160008888620003c9565b8460016000828254620002e8919062000976565b90915550506001600160a01b038616600090815260208190526040812080548792906200031790849062000976565b909155506200032f90508160008888888888620003f8565b856001600160a01b0316816001600160a01b03167f2fe5be0146f74c5bce36c0b80911af6c7d86ff27e89d5cfa61fc681327954e5d8787876040516200037893929190620009bf565b60405180910390a36040518581526001600160a01b038716906000907fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef9060200160405180910390a3505050505050565b6040517f52316ab8e8b0687ce803e403dfe429541bccd4f6c4683ec65d254d382f15a26590600090a150505050565b60405163555ddc6560e11b81526001600160a01b03861660048201527fb281fc8c12954d22544db45de3159a39272895b169a852b314f9cc762e44c53b6024820152600090731820a4b7618bde71dce8cdc73aab6c95905fad249063aabbb8ca9060440160206040518083038186803b1580156200047557600080fd5b505afa1580156200048a573d6000803e3d6000fd5b505050506040513d601f19601f82011682018060405250810190620004b09190620009f8565b90506001600160a01b0381161562000532576040516223de2960e01b81526001600160a01b038216906223de2990620004f8908b908b908b908b908b908b9060040162000a1d565b600060405180830381600087803b1580156200051357600080fd5b505af115801562000528573d6000803e3d6000fd5b50505050620005e3565b8115620005e35762000558866001600160a01b0316620005ed60201b620008591760201c565b15620005e35760405162461bcd60e51b815260206004820152604d60248201527f4552433737373a20746f6b656e20726563697069656e7420636f6e747261637460448201527f20686173206e6f20696d706c656d656e74657220666f7220455243373737546f60648201526c1ad95b9cd49958da5c1a595b9d609a1b608482015260a401620002bb565b5050505050505050565b6001600160a01b03163b151590565b8280546200060a9062000a7b565b90600052602060002090601f0160209004810192826200062e576000855562000679565b82601f106200064957805160ff191683800117855562000679565b8280016001018555821562000679579182015b82811115620006795782518255916020019190600101906200065c565b5062000687929150620006e3565b5090565b82805482825590600052602060002090810192821562000679579160200282015b828111156200067957825182546001600160a01b0319166001600160a01b03909116178255602090920191600190910190620006ac565b5b80821115620006875760008155600101620006e4565b80516001600160a01b03811681146200071257600080fd5b919050565b634e487b7160e01b600052604160045260246000fd5b604051601f8201601f191681016001600160401b038111828210171562000758576200075862000717565b604052919050565b60005b838110156200077d57818101518382015260200162000763565b83811115620002625750506000910152565b600082601f830112620007a157600080fd5b81516001600160401b03811115620007bd57620007bd62000717565b620007d2601f8201601f19166020016200072d565b818152846020838601011115620007e857600080fd5b620007fb82602083016020870162000760565b949350505050565b600080600080600060a086880312156200081c57600080fd5b6200082786620006fa565b60208781015160408901519297509550906001600160401b03808211156200084e57600080fd5b6200085c8a838b016200078f565b955060608901519150808211156200087357600080fd5b620008818a838b016200078f565b945060808901519150808211156200089857600080fd5b818901915089601f830112620008ad57600080fd5b815181811115620008c257620008c262000717565b8060051b9150620008d58483016200072d565b818152918301840191848101908c841115620008f057600080fd5b938501935b8385101562000919576200090985620006fa565b82529385019390850190620008f5565b8096505050505050509295509295909350565b634e487b7160e01b600052603260045260246000fd5b634e487b7160e01b600052601160045260246000fd5b60006000198214156200096f576200096f62000942565b5060010190565b600082198211156200098c576200098c62000942565b500190565b60008151808452620009ab81602086016020860162000760565b601f01601f19169290920160200192915050565b838152606060208201526000620009da606083018562000991565b8281036040840152620009ee818562000991565b9695505050505050565b60006020828403121562000a0b57600080fd5b62000a1682620006fa565b9392505050565b6001600160a01b0387811682528681166020830152851660408201526060810184905260c06080820181905260009062000a5a9083018562000991565b82810360a084015262000a6e818562000991565b9998505050505050505050565b600181811c9082168062000a9057607f821691505b6020821081141562000ab257634e487b7160e01b600052602260045260246000fd5b50919050565b6118fa8062000ac86000396000f3fe608060405234801561001057600080fd5b50600436106101375760003560e01c8063959b8c3f116100b8578063cfbfab0b1161007c578063cfbfab0b14610272578063d95b637114610285578063dd62ed3e14610298578063fad8b32a146102d1578063fc673c4f146102e4578063fe9d9303146102f757600080fd5b8063959b8c3f1461021e57806395d89b41146102315780639bd9bbc614610239578063a9059cbb1461024c578063b1f0b5be1461025f57600080fd5b8063313ce567116100ff578063313ce567146101b7578063556f0dc7146101c657806356189cb4146101cd57806362ad1b83146101e257806370a08231146101f557600080fd5b806306e485381461013c57806306fdde031461015a578063095ea7b31461016f57806318160ddd1461019257806323b872dd146101a4575b600080fd5b61014461030a565b60405161015191906112d4565b60405180910390f35b61016261036c565b604051610151919061136e565b61018261017d366004611399565b6103f5565b6040519015158152602001610151565b6001545b604051908152602001610151565b6101826101b23660046113c5565b61040d565b60405160128152602001610151565b6001610196565b6101e06101db3660046113c5565b610453565b005b6101e06101f03660046114a9565b610463565b61019661020336600461153c565b6001600160a01b031660009081526020819052604090205490565b6101e061022c36600461153c565b6104a8565b6101626105c6565b6101e0610247366004611559565b6105d5565b61018261025a366004611399565b6105f3565b6101e061026d3660046115b2565b61062b565b6101e0610280366004611632565b61063d565b6101826102933660046116cc565b61064a565b6101966102a63660046116cc565b6001600160a01b03918216600090815260086020908152604080832093909416825291909152205490565b6101e06102df36600461153c565b6106ec565b6101e06102f23660046115b2565b610808565b6101e0610305366004611705565b61083a565b6060600480548060200260200160405190810160405280929190818152602001828054801561036257602002820191906000526020600020905b81546001600160a01b03168152600190910190602001808311610344575b5050505050905090565b60606002805461037b9061174c565b80601f01602080910402602001604051908101604052809291908181526020018280546103a79061174c565b80156103625780601f106103c957610100808354040283529160200191610362565b820191906000526020600020905b8154815290600101906020018083116103d757509395945050505050565b600033610403818585610868565b5060019392505050565b60003361041b85828561098f565b61044885858560405180602001604052806000815250604051806020016040528060008152506000610a1b565b506001949350505050565b61045e838383610868565b505050565b61046d338661064a565b6104925760405162461bcd60e51b815260040161048990611787565b60405180910390fd5b6104a185858585856001610a1b565b5050505050565b336001600160a01b038216141561050d5760405162461bcd60e51b8152602060048201526024808201527f4552433737373a20617574686f72697a696e672073656c66206173206f70657260448201526330ba37b960e11b6064820152608401610489565b6001600160a01b03811660009081526005602052604090205460ff161561055e573360009081526007602090815260408083206001600160a01b03851684529091529020805460ff1916905561058d565b3360009081526006602090815260408083206001600160a01b03851684529091529020805460ff191660011790555b60405133906001600160a01b038316907ff4caeb2d6ca8932a215a353d0703c326ec2d81fc68170f320eb2ab49e9df61f990600090a350565b60606003805461037b9061174c565b61045e33848484604051806020016040528060008152506001610a1b565b600061062233848460405180602001604052806000815250604051806020016040528060008152506000610a1b565b50600192915050565b61063784848484610b17565b50505050565b6104a18585858585610b21565b6000816001600160a01b0316836001600160a01b031614806106b557506001600160a01b03831660009081526005602052604090205460ff1680156106b557506001600160a01b0380831660009081526007602090815260408083209387168352929052205460ff16155b806106e557506001600160a01b0380831660009081526006602090815260408083209387168352929052205460ff165b9392505050565b6001600160a01b03811633141561074f5760405162461bcd60e51b815260206004820152602160248201527f4552433737373a207265766f6b696e672073656c66206173206f70657261746f6044820152603960f91b6064820152608401610489565b6001600160a01b03811660009081526005602052604090205460ff16156107a3573360009081526007602090815260408083206001600160a01b03851684529091529020805460ff191660011790556107cf565b3360009081526006602090815260408083206001600160a01b03851684529091529020805460ff191690555b60405133906001600160a01b038316907f50546e66e5f44d728365dc3908c63bc5cfeeab470722c1677e3073a6ac294aa190600090a350565b610812338561064a565b61082e5760405162461bcd60e51b815260040161048990611787565b61063784848484610c73565b61085533838360405180602001604052806000815250610c73565b5050565b6001600160a01b03163b151590565b6001600160a01b0383166108cc5760405162461bcd60e51b815260206004820152602560248201527f4552433737373a20617070726f76652066726f6d20746865207a65726f206164604482015264647265737360d81b6064820152608401610489565b6001600160a01b03821661092e5760405162461bcd60e51b815260206004820152602360248201527f4552433737373a20617070726f766520746f20746865207a65726f206164647260448201526265737360e81b6064820152608401610489565b6001600160a01b0383811660008181526008602090815260408083209487168084529482529182902085905590518481527f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925910160405180910390a3505050565b6001600160a01b0383811660009081526008602090815260408083209386168352929052205460001981146106375781811015610a0e5760405162461bcd60e51b815260206004820152601e60248201527f4552433737373a20696e73756666696369656e7420616c6c6f77616e636500006044820152606401610489565b6106378484848403610868565b6001600160a01b038616610a805760405162461bcd60e51b815260206004820152602660248201527f4552433737373a207472616e736665722066726f6d20746865207a65726f206160448201526564647265737360d01b6064820152608401610489565b6001600160a01b038516610ae25760405162461bcd60e51b8152602060048201526024808201527f4552433737373a207472616e7366657220746f20746865207a65726f206164646044820152637265737360e01b6064820152608401610489565b33610af1818888888888610e29565b610aff818888888888610f5f565b610b0e818888888888886110d1565b50505050505050565b6106378484848460015b6001600160a01b038516610b775760405162461bcd60e51b815260206004820181905260248201527f4552433737373a206d696e7420746f20746865207a65726f20616464726573736044820152606401610489565b33610b8581600088886112a5565b8460016000828254610b9791906117e9565b90915550506001600160a01b03861660009081526020819052604081208054879290610bc49084906117e9565b90915550610bda905081600088888888886110d1565b856001600160a01b0316816001600160a01b03167f2fe5be0146f74c5bce36c0b80911af6c7d86ff27e89d5cfa61fc681327954e5d878787604051610c2193929190611801565b60405180910390a36040518581526001600160a01b038716906000907fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef906020015b60405180910390a3505050505050565b6001600160a01b038416610cd45760405162461bcd60e51b815260206004820152602260248201527f4552433737373a206275726e2066726f6d20746865207a65726f206164647265604482015261737360f01b6064820152608401610489565b33610ce481866000878787610e29565b610cf181866000876112a5565b6001600160a01b03851660009081526020819052604090205484811015610d665760405162461bcd60e51b815260206004820152602360248201527f4552433737373a206275726e20616d6f756e7420657863656564732062616c616044820152626e636560e81b6064820152608401610489565b6001600160a01b0386166000908152602081905260408120868303905560018054879290610d95908490611836565b92505081905550856001600160a01b0316826001600160a01b03167fa78a9be3a7b862d26933ad85fb11d80ef66b8f972d7cbba06621d583943a4098878787604051610de393929190611801565b60405180910390a36040518581526000906001600160a01b038816907fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef90602001610c63565b60405163555ddc6560e11b81526001600160a01b03861660048201527f29ddb589b1fb5fc7cf394961c1adf5f8c6454761adf795e67fe149f658abe8956024820152600090731820a4b7618bde71dce8cdc73aab6c95905fad249063aabbb8ca9060440160206040518083038186803b158015610ea557600080fd5b505afa158015610eb9573d6000803e3d6000fd5b505050506040513d601f19601f82011682018060405250810190610edd919061184d565b90506001600160a01b03811615610b0e57604051633ad5cbc160e11b81526001600160a01b038216906375ab978290610f24908a908a908a908a908a908a9060040161186a565b600060405180830381600087803b158015610f3e57600080fd5b505af1158015610f52573d6000803e3d6000fd5b5050505050505050505050565b610f6b868686866112a5565b6001600160a01b03851660009081526020819052604090205483811015610fe45760405162461bcd60e51b815260206004820152602760248201527f4552433737373a207472616e7366657220616d6f756e7420657863656564732060448201526662616c616e636560c81b6064820152608401610489565b6001600160a01b0380871660009081526020819052604080822087850390559187168152908120805486929061101b9084906117e9565b92505081905550846001600160a01b0316866001600160a01b0316886001600160a01b03167f06b541ddaa720db2b10a4d0cdac39b8d360425fc073085fac19bc8261467798787878760405161107393929190611801565b60405180910390a4846001600160a01b0316866001600160a01b03167fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef866040516110c091815260200190565b60405180910390a350505050505050565b60405163555ddc6560e11b81526001600160a01b03861660048201527fb281fc8c12954d22544db45de3159a39272895b169a852b314f9cc762e44c53b6024820152600090731820a4b7618bde71dce8cdc73aab6c95905fad249063aabbb8ca9060440160206040518083038186803b15801561114d57600080fd5b505afa158015611161573d6000803e3d6000fd5b505050506040513d601f19601f82011682018060405250810190611185919061184d565b90506001600160a01b03811615611201576040516223de2960e01b81526001600160a01b038216906223de29906111ca908b908b908b908b908b908b9060040161186a565b600060405180830381600087803b1580156111e457600080fd5b505af11580156111f8573d6000803e3d6000fd5b5050505061129b565b811561129b576001600160a01b0386163b1561129b5760405162461bcd60e51b815260206004820152604d60248201527f4552433737373a20746f6b656e20726563697069656e7420636f6e747261637460448201527f20686173206e6f20696d706c656d656e74657220666f7220455243373737546f60648201526c1ad95b9cd49958da5c1a595b9d609a1b608482015260a401610489565b5050505050505050565b6040517f52316ab8e8b0687ce803e403dfe429541bccd4f6c4683ec65d254d382f15a26590600090a150505050565b6020808252825182820181905260009190848201906040850190845b818110156113155783516001600160a01b0316835292840192918401916001016112f0565b50909695505050505050565b6000815180845260005b818110156113475760208185018101518683018201520161132b565b81811115611359576000602083870101525b50601f01601f19169290920160200192915050565b6020815260006106e56020830184611321565b6001600160a01b038116811461139657600080fd5b50565b600080604083850312156113ac57600080fd5b82356113b781611381565b946020939093013593505050565b6000806000606084860312156113da57600080fd5b83356113e581611381565b925060208401356113f581611381565b929592945050506040919091013590565b634e487b7160e01b600052604160045260246000fd5b600082601f83011261142d57600080fd5b813567ffffffffffffffff8082111561144857611448611406565b604051601f8301601f19908116603f0116810190828211818310171561147057611470611406565b8160405283815286602085880101111561148957600080fd5b836020870160208301376000602085830101528094505050505092915050565b600080600080600060a086880312156114c157600080fd5b85356114cc81611381565b945060208601356114dc81611381565b935060408601359250606086013567ffffffffffffffff8082111561150057600080fd5b61150c89838a0161141c565b9350608088013591508082111561152257600080fd5b5061152f8882890161141c565b9150509295509295909350565b60006020828403121561154e57600080fd5b81356106e581611381565b60008060006060848603121561156e57600080fd5b833561157981611381565b925060208401359150604084013567ffffffffffffffff81111561159c57600080fd5b6115a88682870161141c565b9150509250925092565b600080600080608085870312156115c857600080fd5b84356115d381611381565b935060208501359250604085013567ffffffffffffffff808211156115f757600080fd5b6116038883890161141c565b9350606087013591508082111561161957600080fd5b506116268782880161141c565b91505092959194509250565b600080600080600060a0868803121561164a57600080fd5b853561165581611381565b945060208601359350604086013567ffffffffffffffff8082111561167957600080fd5b61168589838a0161141c565b9450606088013591508082111561169b57600080fd5b506116a88882890161141c565b925050608086013580151581146116be57600080fd5b809150509295509295909350565b600080604083850312156116df57600080fd5b82356116ea81611381565b915060208301356116fa81611381565b809150509250929050565b6000806040838503121561171857600080fd5b82359150602083013567ffffffffffffffff81111561173657600080fd5b6117428582860161141c565b9150509250929050565b600181811c9082168061176057607f821691505b6020821081141561178157634e487b7160e01b600052602260045260246000fd5b50919050565b6020808252602c908201527f4552433737373a2063616c6c6572206973206e6f7420616e206f70657261746f60408201526b39103337b9103437b63232b960a11b606082015260800190565b634e487b7160e01b600052601160045260246000fd5b600082198211156117fc576117fc6117d3565b500190565b83815260606020820152600061181a6060830185611321565b828103604084015261182c8185611321565b9695505050505050565b600082821015611848576118486117d3565b500390565b60006020828403121561185f57600080fd5b81516106e581611381565b6001600160a01b0387811682528681166020830152851660408201526060810184905260c0608082018190526000906118a590830185611321565b82810360a08401526118b78185611321565b999850505050505050505056fea26469706673582212204a412dbf769190ab5d3529f0c0a3f6edf0226787e2933c7eccd5093d76a5c45964736f6c63430008090033";

    public static final String FUNC_ALLOWANCE = "allowance";

    public static final String FUNC_APPROVE = "approve";

    public static final String FUNC_APPROVEINTERNAL = "approveInternal";

    public static final String FUNC_AUTHORIZEOPERATOR = "authorizeOperator";

    public static final String FUNC_BALANCEOF = "balanceOf";

    public static final String FUNC_BURN = "burn";

    public static final String FUNC_DECIMALS = "decimals";

    public static final String FUNC_DEFAULTOPERATORS = "defaultOperators";

    public static final String FUNC_GRANULARITY = "granularity";

    public static final String FUNC_ISOPERATORFOR = "isOperatorFor";

    public static final String FUNC_MINTINTERNAL = "mintInternal";

    public static final String FUNC_MINTINTERNALEXTENDED = "mintInternalExtended";

    public static final String FUNC_NAME = "name";

    public static final String FUNC_OPERATORBURN = "operatorBurn";

    public static final String FUNC_OPERATORSEND = "operatorSend";

    public static final String FUNC_REVOKEOPERATOR = "revokeOperator";

    public static final String FUNC_SEND = "send";

    public static final String FUNC_SYMBOL = "symbol";

    public static final String FUNC_TOTALSUPPLY = "totalSupply";

    public static final String FUNC_TRANSFER = "transfer";

    public static final String FUNC_TRANSFERFROM = "transferFrom";

    public static final Event APPROVAL_EVENT = new Event("Approval", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event AUTHORIZEDOPERATOR_EVENT = new Event("AuthorizedOperator", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event BEFORETOKENTRANSFER_EVENT = new Event("BeforeTokenTransfer", 
            Arrays.<TypeReference<?>>asList());
    ;

    public static final Event BURNED_EVENT = new Event("Burned", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<DynamicBytes>() {}, new TypeReference<DynamicBytes>() {}));
    ;

    public static final Event MINTED_EVENT = new Event("Minted", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<DynamicBytes>() {}, new TypeReference<DynamicBytes>() {}));
    ;

    public static final Event REVOKEDOPERATOR_EVENT = new Event("RevokedOperator", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event SENT_EVENT = new Event("Sent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<DynamicBytes>() {}, new TypeReference<DynamicBytes>() {}));
    ;

    public static final Event TRANSFER_EVENT = new Event("Transfer", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected ERC777Mock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ERC777Mock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ERC777Mock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ERC777Mock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
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

    public static List<AuthorizedOperatorEventResponse> getAuthorizedOperatorEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(AUTHORIZEDOPERATOR_EVENT, transactionReceipt);
        ArrayList<AuthorizedOperatorEventResponse> responses = new ArrayList<AuthorizedOperatorEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AuthorizedOperatorEventResponse typedResponse = new AuthorizedOperatorEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.operator = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.tokenHolder = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<AuthorizedOperatorEventResponse> authorizedOperatorEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, AuthorizedOperatorEventResponse>() {
            @Override
            public AuthorizedOperatorEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(AUTHORIZEDOPERATOR_EVENT, log);
                AuthorizedOperatorEventResponse typedResponse = new AuthorizedOperatorEventResponse();
                typedResponse.log = log;
                typedResponse.operator = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.tokenHolder = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<AuthorizedOperatorEventResponse> authorizedOperatorEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(AUTHORIZEDOPERATOR_EVENT));
        return authorizedOperatorEventFlowable(filter);
    }

    public static List<BeforeTokenTransferEventResponse> getBeforeTokenTransferEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(BEFORETOKENTRANSFER_EVENT, transactionReceipt);
        ArrayList<BeforeTokenTransferEventResponse> responses = new ArrayList<BeforeTokenTransferEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            BeforeTokenTransferEventResponse typedResponse = new BeforeTokenTransferEventResponse();
            typedResponse.log = eventValues.getLog();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<BeforeTokenTransferEventResponse> beforeTokenTransferEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, BeforeTokenTransferEventResponse>() {
            @Override
            public BeforeTokenTransferEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(BEFORETOKENTRANSFER_EVENT, log);
                BeforeTokenTransferEventResponse typedResponse = new BeforeTokenTransferEventResponse();
                typedResponse.log = log;
                return typedResponse;
            }
        });
    }

    public Flowable<BeforeTokenTransferEventResponse> beforeTokenTransferEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(BEFORETOKENTRANSFER_EVENT));
        return beforeTokenTransferEventFlowable(filter);
    }

    public static List<BurnedEventResponse> getBurnedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(BURNED_EVENT, transactionReceipt);
        ArrayList<BurnedEventResponse> responses = new ArrayList<BurnedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            BurnedEventResponse typedResponse = new BurnedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.operator = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.from = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.operatorData = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<BurnedEventResponse> burnedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, BurnedEventResponse>() {
            @Override
            public BurnedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(BURNED_EVENT, log);
                BurnedEventResponse typedResponse = new BurnedEventResponse();
                typedResponse.log = log;
                typedResponse.operator = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.from = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.operatorData = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<BurnedEventResponse> burnedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(BURNED_EVENT));
        return burnedEventFlowable(filter);
    }

    public static List<MintedEventResponse> getMintedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(MINTED_EVENT, transactionReceipt);
        ArrayList<MintedEventResponse> responses = new ArrayList<MintedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            MintedEventResponse typedResponse = new MintedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.operator = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.operatorData = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<MintedEventResponse> mintedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, MintedEventResponse>() {
            @Override
            public MintedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(MINTED_EVENT, log);
                MintedEventResponse typedResponse = new MintedEventResponse();
                typedResponse.log = log;
                typedResponse.operator = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.operatorData = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<MintedEventResponse> mintedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(MINTED_EVENT));
        return mintedEventFlowable(filter);
    }

    public static List<RevokedOperatorEventResponse> getRevokedOperatorEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(REVOKEDOPERATOR_EVENT, transactionReceipt);
        ArrayList<RevokedOperatorEventResponse> responses = new ArrayList<RevokedOperatorEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            RevokedOperatorEventResponse typedResponse = new RevokedOperatorEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.operator = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.tokenHolder = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<RevokedOperatorEventResponse> revokedOperatorEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, RevokedOperatorEventResponse>() {
            @Override
            public RevokedOperatorEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(REVOKEDOPERATOR_EVENT, log);
                RevokedOperatorEventResponse typedResponse = new RevokedOperatorEventResponse();
                typedResponse.log = log;
                typedResponse.operator = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.tokenHolder = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<RevokedOperatorEventResponse> revokedOperatorEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(REVOKEDOPERATOR_EVENT));
        return revokedOperatorEventFlowable(filter);
    }

    public static List<SentEventResponse> getSentEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(SENT_EVENT, transactionReceipt);
        ArrayList<SentEventResponse> responses = new ArrayList<SentEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            SentEventResponse typedResponse = new SentEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.operator = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.from = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.to = (String) eventValues.getIndexedValues().get(2).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.operatorData = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<SentEventResponse> sentEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, SentEventResponse>() {
            @Override
            public SentEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(SENT_EVENT, log);
                SentEventResponse typedResponse = new SentEventResponse();
                typedResponse.log = log;
                typedResponse.operator = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.from = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.to = (String) eventValues.getIndexedValues().get(2).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.operatorData = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<SentEventResponse> sentEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(SENT_EVENT));
        return sentEventFlowable(filter);
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

    public RemoteFunctionCall<BigInteger> allowance(String holder, String spender) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ALLOWANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, holder), 
                new org.web3j.abi.datatypes.Address(160, spender)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> approve(String spender, BigInteger value) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_APPROVE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, spender), 
                new org.web3j.abi.datatypes.generated.Uint256(value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> approveInternal(String holder, String spender, BigInteger value) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_APPROVEINTERNAL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, holder), 
                new org.web3j.abi.datatypes.Address(160, spender), 
                new org.web3j.abi.datatypes.generated.Uint256(value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> authorizeOperator(String operator) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_AUTHORIZEOPERATOR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, operator)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> balanceOf(String tokenHolder) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_BALANCEOF, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, tokenHolder)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> burn(BigInteger amount, byte[] data) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_BURN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(amount), 
                new org.web3j.abi.datatypes.DynamicBytes(data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> decimals() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_DECIMALS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<List> defaultOperators() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_DEFAULTOPERATORS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
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

    public RemoteFunctionCall<BigInteger> granularity() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GRANULARITY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Boolean> isOperatorFor(String operator, String tokenHolder) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ISOPERATORFOR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, operator), 
                new org.web3j.abi.datatypes.Address(160, tokenHolder)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> mintInternal(String to, BigInteger amount, byte[] userData, byte[] operatorData) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_MINTINTERNAL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, to), 
                new org.web3j.abi.datatypes.generated.Uint256(amount), 
                new org.web3j.abi.datatypes.DynamicBytes(userData), 
                new org.web3j.abi.datatypes.DynamicBytes(operatorData)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> mintInternalExtended(String to, BigInteger amount, byte[] userData, byte[] operatorData, Boolean requireReceptionAck) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_MINTINTERNALEXTENDED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, to), 
                new org.web3j.abi.datatypes.generated.Uint256(amount), 
                new org.web3j.abi.datatypes.DynamicBytes(userData), 
                new org.web3j.abi.datatypes.DynamicBytes(operatorData), 
                new org.web3j.abi.datatypes.Bool(requireReceptionAck)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> name() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_NAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> operatorBurn(String account, BigInteger amount, byte[] data, byte[] operatorData) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_OPERATORBURN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, account), 
                new org.web3j.abi.datatypes.generated.Uint256(amount), 
                new org.web3j.abi.datatypes.DynamicBytes(data), 
                new org.web3j.abi.datatypes.DynamicBytes(operatorData)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> operatorSend(String sender, String recipient, BigInteger amount, byte[] data, byte[] operatorData) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_OPERATORSEND, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, sender), 
                new org.web3j.abi.datatypes.Address(160, recipient), 
                new org.web3j.abi.datatypes.generated.Uint256(amount), 
                new org.web3j.abi.datatypes.DynamicBytes(data), 
                new org.web3j.abi.datatypes.DynamicBytes(operatorData)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> revokeOperator(String operator) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_REVOKEOPERATOR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, operator)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> send(String recipient, BigInteger amount, byte[] data) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SEND, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, recipient), 
                new org.web3j.abi.datatypes.generated.Uint256(amount), 
                new org.web3j.abi.datatypes.DynamicBytes(data)), 
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

    public RemoteFunctionCall<TransactionReceipt> transfer(String recipient, BigInteger amount) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, recipient), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> transferFrom(String holder, String recipient, BigInteger amount) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFERFROM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, holder), 
                new org.web3j.abi.datatypes.Address(160, recipient), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static ERC777Mock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ERC777Mock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ERC777Mock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ERC777Mock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ERC777Mock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ERC777Mock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ERC777Mock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ERC777Mock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ERC777Mock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String initialHolder, BigInteger initialBalance, String name, String symbol, List<String> defaultOperators) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, initialHolder), 
                new org.web3j.abi.datatypes.generated.Uint256(initialBalance), 
                new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.Utf8String(symbol), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(defaultOperators, org.web3j.abi.datatypes.Address.class))));
        return deployRemoteCall(ERC777Mock.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<ERC777Mock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String initialHolder, BigInteger initialBalance, String name, String symbol, List<String> defaultOperators) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, initialHolder), 
                new org.web3j.abi.datatypes.generated.Uint256(initialBalance), 
                new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.Utf8String(symbol), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(defaultOperators, org.web3j.abi.datatypes.Address.class))));
        return deployRemoteCall(ERC777Mock.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ERC777Mock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String initialHolder, BigInteger initialBalance, String name, String symbol, List<String> defaultOperators) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, initialHolder), 
                new org.web3j.abi.datatypes.generated.Uint256(initialBalance), 
                new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.Utf8String(symbol), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(defaultOperators, org.web3j.abi.datatypes.Address.class))));
        return deployRemoteCall(ERC777Mock.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ERC777Mock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String initialHolder, BigInteger initialBalance, String name, String symbol, List<String> defaultOperators) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, initialHolder), 
                new org.web3j.abi.datatypes.generated.Uint256(initialBalance), 
                new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.Utf8String(symbol), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(defaultOperators, org.web3j.abi.datatypes.Address.class))));
        return deployRemoteCall(ERC777Mock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class ApprovalEventResponse extends BaseEventResponse {
        public String owner;

        public String spender;

        public BigInteger value;
    }

    public static class AuthorizedOperatorEventResponse extends BaseEventResponse {
        public String operator;

        public String tokenHolder;
    }

    public static class BeforeTokenTransferEventResponse extends BaseEventResponse {
    }

    public static class BurnedEventResponse extends BaseEventResponse {
        public String operator;

        public String from;

        public BigInteger amount;

        public byte[] data;

        public byte[] operatorData;
    }

    public static class MintedEventResponse extends BaseEventResponse {
        public String operator;

        public String to;

        public BigInteger amount;

        public byte[] data;

        public byte[] operatorData;
    }

    public static class RevokedOperatorEventResponse extends BaseEventResponse {
        public String operator;

        public String tokenHolder;
    }

    public static class SentEventResponse extends BaseEventResponse {
        public String operator;

        public String from;

        public String to;

        public BigInteger amount;

        public byte[] data;

        public byte[] operatorData;
    }

    public static class TransferEventResponse extends BaseEventResponse {
        public String from;

        public String to;

        public BigInteger value;
    }
}
