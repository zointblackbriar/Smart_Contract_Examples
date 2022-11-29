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
import org.web3j.abi.datatypes.StaticStruct;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint224;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint32;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.abi.datatypes.generated.Uint96;
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
public class ERC20VotesCompMock extends Contract {
    public static final String BINARY = "6101406040523480156200001257600080fd5b50604051620022e1380380620022e1833981016040819052620000359162000292565b8180604051806040016040528060018152602001603160f81b815250848481600390805190602001906200006b9291906200011f565b508051620000819060049060208401906200011f565b5050825160208085019190912083518483012060e08290526101008190524660a0818152604080517f8b73c3c69bb8fe3d512ecc4cf759cc79239f7b179b0ffacaa9a75d522b39400f81880181905281830187905260608201869052608082019490945230818401528151808203909301835260c0019052805194019390932091935091906080523060c05261012052506200033995505050505050565b8280546200012d90620002fc565b90600052602060002090601f0160209004810192826200015157600085556200019c565b82601f106200016c57805160ff19168380011785556200019c565b828001600101855582156200019c579182015b828111156200019c5782518255916020019190600101906200017f565b50620001aa929150620001ae565b5090565b5b80821115620001aa5760008155600101620001af565b634e487b7160e01b600052604160045260246000fd5b600082601f830112620001ed57600080fd5b81516001600160401b03808211156200020a576200020a620001c5565b604051601f8301601f19908116603f01168101908282118183101715620002355762000235620001c5565b816040528381526020925086838588010111156200025257600080fd5b600091505b8382101562000276578582018301518183018401529082019062000257565b83821115620002885760008385830101525b9695505050505050565b60008060408385031215620002a657600080fd5b82516001600160401b0380821115620002be57600080fd5b620002cc86838701620001db565b93506020850151915080821115620002e357600080fd5b50620002f285828601620001db565b9150509250929050565b600181811c908216806200031157607f821691505b602082108114156200033357634e487b7160e01b600052602260045260246000fd5b50919050565b60805160a05160c05160e0516101005161012051611f58620003896000396000610ede01526000610f2d01526000610f0801526000610e6101526000610e8b01526000610eb50152611f586000f3fe608060405234801561001057600080fd5b50600436106101a95760003560e01c806370a08231116100f9578063a457c2d711610097578063c3cda52011610071578063c3cda520146103cc578063d505accf146103df578063dd62ed3e146103f2578063f1127ed81461040557600080fd5b8063a457c2d714610393578063a9059cbb146103a6578063b4b5ea57146103b957600080fd5b80638e539e8c116100d35780638e539e8c1461035257806395d89b41146103655780639ab24eb01461036d5780639dc29fac1461038057600080fd5b806370a08231146102eb578063782d6fe1146103145780637ecebe001461033f57600080fd5b80633644e5151161016657806340c10f191161014057806340c10f1914610257578063587cde1e1461026c5780635c19a95c146102b05780636fcfff45146102c357600080fd5b80633644e5151461022957806339509351146102315780633a46b1a81461024457600080fd5b806306fdde03146101ae578063095ea7b3146101cc57806318160ddd146101ef57806323b872dd14610201578063313ce567146102145780633408e47014610223575b600080fd5b6101b6610442565b6040516101c39190611bf3565b60405180910390f35b6101df6101da366004611c64565b6104d4565b60405190151581526020016101c3565b6002545b6040519081526020016101c3565b6101df61020f366004611c8e565b6104ec565b604051601281526020016101c3565b466101f3565b6101f3610510565b6101df61023f366004611c64565b61051f565b6101f3610252366004611c64565b610541565b61026a610265366004611c64565b6105c0565b005b61029861027a366004611cca565b6001600160a01b039081166000908152600760205260409020541690565b6040516001600160a01b0390911681526020016101c3565b61026a6102be366004611cca565b6105ce565b6102d66102d1366004611cca565b6105db565b60405163ffffffff90911681526020016101c3565b6101f36102f9366004611cca565b6001600160a01b031660009081526020819052604090205490565b610327610322366004611c64565b610603565b6040516001600160601b0390911681526020016101c3565b6101f361034d366004611cca565b610617565b6101f3610360366004611ce5565b610635565b6101b6610691565b6101f361037b366004611cca565b6106a0565b61026a61038e366004611c64565b610722565b6101df6103a1366004611c64565b61072c565b6101df6103b4366004611c64565b6107a7565b6103276103c7366004611cca565b6107b5565b61026a6103da366004611d0f565b6107c3565b61026a6103ed366004611d67565b6108f9565b6101f3610400366004611dd1565b610a5d565b610418610413366004611e04565b610a88565b60408051825163ffffffff1681526020928301516001600160e01b031692810192909252016101c3565b60606003805461045190611e44565b80601f016020809104026020016040519081016040528092919081815260200182805461047d90611e44565b80156104ca5780601f1061049f576101008083540402835291602001916104ca565b820191906000526020600020905b8154815290600101906020018083116104ad57829003601f168201915b5050505050905090565b6000336104e2818585610b0c565b5060019392505050565b6000336104fa858285610c30565b610505858585610caa565b506001949350505050565b600061051a610e54565b905090565b6000336104e28185856105328383610a5d565b61053c9190611e8f565b610b0c565b60004382106105975760405162461bcd60e51b815260206004820152601f60248201527f4552433230566f7465733a20626c6f636b206e6f7420796574206d696e65640060448201526064015b60405180910390fd5b6001600160a01b03831660009081526008602052604090206105b99083610f7b565b9392505050565b6105ca8282611064565b5050565b6105d833826110ee565b50565b6001600160a01b0381166000908152600860205260408120546105fd90611167565b92915050565b60006105b96106128484610541565b6111d0565b6001600160a01b0381166000908152600560205260408120546105fd565b60004382106106865760405162461bcd60e51b815260206004820152601f60248201527f4552433230566f7465733a20626c6f636b206e6f7420796574206d696e656400604482015260640161058e565b6105fd600983610f7b565b60606004805461045190611e44565b6001600160a01b038116600090815260086020526040812054801561070f576001600160a01b0383166000908152600860205260409020805460001983019081106106ed576106ed611ea7565b60009182526020909120015464010000000090046001600160e01b0316610712565b60005b6001600160e01b03169392505050565b6105ca8282611238565b6000338161073a8286610a5d565b90508381101561079a5760405162461bcd60e51b815260206004820152602560248201527f45524332303a2064656372656173656420616c6c6f77616e63652062656c6f77604482015264207a65726f60d81b606482015260840161058e565b6105058286868403610b0c565b6000336104e2818585610caa565b60006105fd610612836106a0565b834211156108135760405162461bcd60e51b815260206004820152601d60248201527f4552433230566f7465733a207369676e61747572652065787069726564000000604482015260640161058e565b604080517fe48329057bfd03d55e49b547132e39cffd9c1820ad7b9d4c5307691425d15adf60208201526001600160a01b03881691810191909152606081018690526080810185905260009061088d906108859060a00160405160208183030381529060405280519060200120611250565b85858561129e565b9050610898816112c6565b86146108e65760405162461bcd60e51b815260206004820152601960248201527f4552433230566f7465733a20696e76616c6964206e6f6e636500000000000000604482015260640161058e565b6108f081886110ee565b50505050505050565b834211156109495760405162461bcd60e51b815260206004820152601d60248201527f45524332305065726d69743a206578706972656420646561646c696e65000000604482015260640161058e565b60007f6e71edae12b1b97f4d1f60370fef10105fa2faae0126114a169c64845d6126c98888886109788c6112c6565b6040805160208101969096526001600160a01b0394851690860152929091166060840152608083015260a082015260c0810186905260e00160405160208183030381529060405280519060200120905060006109d382611250565b905060006109e38287878761129e565b9050896001600160a01b0316816001600160a01b031614610a465760405162461bcd60e51b815260206004820152601e60248201527f45524332305065726d69743a20696e76616c6964207369676e61747572650000604482015260640161058e565b610a518a8a8a610b0c565b50505050505050505050565b6001600160a01b03918216600090815260016020908152604080832093909416825291909152205490565b60408051808201909152600080825260208201526001600160a01b0383166000908152600860205260409020805463ffffffff8416908110610acc57610acc611ea7565b60009182526020918290206040805180820190915291015463ffffffff8116825264010000000090046001600160e01b0316918101919091529392505050565b6001600160a01b038316610b6e5760405162461bcd60e51b8152602060048201526024808201527f45524332303a20617070726f76652066726f6d20746865207a65726f206164646044820152637265737360e01b606482015260840161058e565b6001600160a01b038216610bcf5760405162461bcd60e51b815260206004820152602260248201527f45524332303a20617070726f766520746f20746865207a65726f206164647265604482015261737360f01b606482015260840161058e565b6001600160a01b0383811660008181526001602090815260408083209487168084529482529182902085905590518481527f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925910160405180910390a3505050565b6000610c3c8484610a5d565b90506000198114610ca45781811015610c975760405162461bcd60e51b815260206004820152601d60248201527f45524332303a20696e73756666696369656e7420616c6c6f77616e6365000000604482015260640161058e565b610ca48484848403610b0c565b50505050565b6001600160a01b038316610d0e5760405162461bcd60e51b815260206004820152602560248201527f45524332303a207472616e736665722066726f6d20746865207a65726f206164604482015264647265737360d81b606482015260840161058e565b6001600160a01b038216610d705760405162461bcd60e51b815260206004820152602360248201527f45524332303a207472616e7366657220746f20746865207a65726f206164647260448201526265737360e81b606482015260840161058e565b6001600160a01b03831660009081526020819052604090205481811015610de85760405162461bcd60e51b815260206004820152602660248201527f45524332303a207472616e7366657220616d6f756e7420657863656564732062604482015265616c616e636560d01b606482015260840161058e565b6001600160a01b03848116600081815260208181526040808320878703905593871680835291849020805487019055925185815290927fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef910160405180910390a3610ca48484846112f3565b6000306001600160a01b037f000000000000000000000000000000000000000000000000000000000000000016148015610ead57507f000000000000000000000000000000000000000000000000000000000000000046145b15610ed757507f000000000000000000000000000000000000000000000000000000000000000090565b50604080517f00000000000000000000000000000000000000000000000000000000000000006020808301919091527f0000000000000000000000000000000000000000000000000000000000000000828401527f000000000000000000000000000000000000000000000000000000000000000060608301524660808301523060a0808401919091528351808403909101815260c0909201909252805191012090565b815460009081816005811115610fd5576000610f9684611325565b610fa09085611ebd565b600088815260209020909150869082015463ffffffff161115610fc557809150610fd3565b610fd0816001611e8f565b92505b505b80821015611022576000610fe9838361140a565b600088815260209020909150869082015463ffffffff16111561100e5780915061101c565b611019816001611e8f565b92505b50610fd5565b801561104e576000868152602090208101600019015464010000000090046001600160e01b0316611051565b60005b6001600160e01b03169695505050505050565b61106e8282611425565b6002546001600160601b0310156110e05760405162461bcd60e51b815260206004820152603060248201527f4552433230566f7465733a20746f74616c20737570706c79207269736b73206f60448201526f766572666c6f77696e6720766f74657360801b606482015260840161058e565b610ca460096114ec836114f8565b6001600160a01b038281166000818152600760208181526040808420805485845282862054949093528787166001600160a01b03198416811790915590519190951694919391928592917f3134e8a2e6d97e929a7e54011ea5485d7d196dd5f0ba4d4ef95803e8e3fc257f9190a4610ca482848361164c565b600063ffffffff8211156111cc5760405162461bcd60e51b815260206004820152602660248201527f53616665436173743a2076616c756520646f65736e27742066697420696e203360448201526532206269747360d01b606482015260840161058e565b5090565b60006001600160601b038211156111cc5760405162461bcd60e51b815260206004820152602660248201527f53616665436173743a2076616c756520646f65736e27742066697420696e203960448201526536206269747360d01b606482015260840161058e565b6112428282611789565b610ca460096118c2836114f8565b60006105fd61125d610e54565b8360405161190160f01b6020820152602281018390526042810182905260009060620160405160208183030381529060405280519060200120905092915050565b60008060006112af878787876118ce565b915091506112bc81611992565b5095945050505050565b6001600160a01b03811660009081526005602052604090208054600181018255905b50919050565b505050565b6001600160a01b038381166000908152600760205260408082205485841683529120546112ee9291821691168361164c565b60008161133457506000919050565b6000600161134184611ae0565b901c6001901b9050600181848161135a5761135a611ed4565b048201901c9050600181848161137257611372611ed4565b048201901c9050600181848161138a5761138a611ed4565b048201901c905060018184816113a2576113a2611ed4565b048201901c905060018184816113ba576113ba611ed4565b048201901c905060018184816113d2576113d2611ed4565b048201901c905060018184816113ea576113ea611ed4565b048201901c90506105b98182858161140457611404611ed4565b04611b74565b60006114196002848418611eea565b6105b990848416611e8f565b6001600160a01b03821661147b5760405162461bcd60e51b815260206004820152601f60248201527f45524332303a206d696e7420746f20746865207a65726f206164647265737300604482015260640161058e565b806002600082825461148d9190611e8f565b90915550506001600160a01b038216600081815260208181526040808320805486019055518481527fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef910160405180910390a36105ca600083836112f3565b60006105b98284611e8f565b825460009081908181156115455760008781526020902082016000190160408051808201909152905463ffffffff8116825264010000000090046001600160e01b0316602082015261155a565b60408051808201909152600080825260208201525b905080602001516001600160e01b0316935061157a84868863ffffffff16565b92506000821180156115925750805163ffffffff1643145b156115d7576115a083611b8a565b60008881526020902083016000190180546001600160e01b03929092166401000000000263ffffffff909216919091179055611642565b8660405180604001604052806115ec43611167565b63ffffffff16815260200161160086611b8a565b6001600160e01b0390811690915282546001810184556000938452602093849020835194909301519091166401000000000263ffffffff909316929092179101555b5050935093915050565b816001600160a01b0316836001600160a01b03161415801561166e5750600081115b156112ee576001600160a01b038316156116fc576001600160a01b038316600090815260086020526040812081906116a9906118c2856114f8565b91509150846001600160a01b03167fdec2bacdd2f05b59de34da9b523dff8be42e5e38e818c82fdb0bae774387a72483836040516116f1929190918252602082015260400190565b60405180910390a250505b6001600160a01b038216156112ee576001600160a01b03821660009081526008602052604081208190611732906114ec856114f8565b91509150836001600160a01b03167fdec2bacdd2f05b59de34da9b523dff8be42e5e38e818c82fdb0bae774387a724838360405161177a929190918252602082015260400190565b60405180910390a25050505050565b6001600160a01b0382166117e95760405162461bcd60e51b815260206004820152602160248201527f45524332303a206275726e2066726f6d20746865207a65726f206164647265736044820152607360f81b606482015260840161058e565b6001600160a01b0382166000908152602081905260409020548181101561185d5760405162461bcd60e51b815260206004820152602260248201527f45524332303a206275726e20616d6f756e7420657863656564732062616c616e604482015261636560f01b606482015260840161058e565b6001600160a01b0383166000818152602081815260408083208686039055600280548790039055518581529192917fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef910160405180910390a36112ee836000846112f3565b60006105b98284611ebd565b6000807f7fffffffffffffffffffffffffffffff5d576e7357a4501ddfe92f46681b20a08311156119055750600090506003611989565b6040805160008082526020820180845289905260ff881692820192909252606081018690526080810185905260019060a0016020604051602081039080840390855afa158015611959573d6000803e3d6000fd5b5050604051601f1901519150506001600160a01b03811661198257600060019250925050611989565b9150600090505b94509492505050565b60008160048111156119a6576119a6611f0c565b14156119af5750565b60018160048111156119c3576119c3611f0c565b1415611a115760405162461bcd60e51b815260206004820152601860248201527f45434453413a20696e76616c6964207369676e61747572650000000000000000604482015260640161058e565b6002816004811115611a2557611a25611f0c565b1415611a735760405162461bcd60e51b815260206004820152601f60248201527f45434453413a20696e76616c6964207369676e6174757265206c656e67746800604482015260640161058e565b6003816004811115611a8757611a87611f0c565b14156105d85760405162461bcd60e51b815260206004820152602260248201527f45434453413a20696e76616c6964207369676e6174757265202773272076616c604482015261756560f01b606482015260840161058e565b600080608083901c15611af557608092831c92015b604083901c15611b0757604092831c92015b602083901c15611b1957602092831c92015b601083901c15611b2b57601092831c92015b600883901c15611b3d57600892831c92015b600483901c15611b4f57600492831c92015b600283901c15611b6157600292831c92015b600183901c156105fd5760010192915050565b6000818310611b8357816105b9565b5090919050565b60006001600160e01b038211156111cc5760405162461bcd60e51b815260206004820152602760248201527f53616665436173743a2076616c756520646f65736e27742066697420696e20326044820152663234206269747360c81b606482015260840161058e565b600060208083528351808285015260005b81811015611c2057858101830151858201604001528201611c04565b81811115611c32576000604083870101525b50601f01601f1916929092016040019392505050565b80356001600160a01b0381168114611c5f57600080fd5b919050565b60008060408385031215611c7757600080fd5b611c8083611c48565b946020939093013593505050565b600080600060608486031215611ca357600080fd5b611cac84611c48565b9250611cba60208501611c48565b9150604084013590509250925092565b600060208284031215611cdc57600080fd5b6105b982611c48565b600060208284031215611cf757600080fd5b5035919050565b803560ff81168114611c5f57600080fd5b60008060008060008060c08789031215611d2857600080fd5b611d3187611c48565b95506020870135945060408701359350611d4d60608801611cfe565b92506080870135915060a087013590509295509295509295565b600080600080600080600060e0888a031215611d8257600080fd5b611d8b88611c48565b9650611d9960208901611c48565b95506040880135945060608801359350611db560808901611cfe565b925060a0880135915060c0880135905092959891949750929550565b60008060408385031215611de457600080fd5b611ded83611c48565b9150611dfb60208401611c48565b90509250929050565b60008060408385031215611e1757600080fd5b611e2083611c48565b9150602083013563ffffffff81168114611e3957600080fd5b809150509250929050565b600181811c90821680611e5857607f821691505b602082108114156112e857634e487b7160e01b600052602260045260246000fd5b634e487b7160e01b600052601160045260246000fd5b60008219821115611ea257611ea2611e79565b500190565b634e487b7160e01b600052603260045260246000fd5b600082821015611ecf57611ecf611e79565b500390565b634e487b7160e01b600052601260045260246000fd5b600082611f0757634e487b7160e01b600052601260045260246000fd5b500490565b634e487b7160e01b600052602160045260246000fdfea2646970667358221220a2ad128d2107f36da56102c44a47150d853abca82394dfda78ce9b4a3aa35c5d64736f6c63430008090033";

    public static final String FUNC_DOMAIN_SEPARATOR = "DOMAIN_SEPARATOR";

    public static final String FUNC_ALLOWANCE = "allowance";

    public static final String FUNC_APPROVE = "approve";

    public static final String FUNC_BALANCEOF = "balanceOf";

    public static final String FUNC_BURN = "burn";

    public static final String FUNC_CHECKPOINTS = "checkpoints";

    public static final String FUNC_DECIMALS = "decimals";

    public static final String FUNC_DECREASEALLOWANCE = "decreaseAllowance";

    public static final String FUNC_DELEGATE = "delegate";

    public static final String FUNC_DELEGATEBYSIG = "delegateBySig";

    public static final String FUNC_DELEGATES = "delegates";

    public static final String FUNC_GETCHAINID = "getChainId";

    public static final String FUNC_GETCURRENTVOTES = "getCurrentVotes";

    public static final String FUNC_GETPASTTOTALSUPPLY = "getPastTotalSupply";

    public static final String FUNC_GETPASTVOTES = "getPastVotes";

    public static final String FUNC_GETPRIORVOTES = "getPriorVotes";

    public static final String FUNC_GETVOTES = "getVotes";

    public static final String FUNC_INCREASEALLOWANCE = "increaseAllowance";

    public static final String FUNC_MINT = "mint";

    public static final String FUNC_NAME = "name";

    public static final String FUNC_NONCES = "nonces";

    public static final String FUNC_NUMCHECKPOINTS = "numCheckpoints";

    public static final String FUNC_PERMIT = "permit";

    public static final String FUNC_SYMBOL = "symbol";

    public static final String FUNC_TOTALSUPPLY = "totalSupply";

    public static final String FUNC_TRANSFER = "transfer";

    public static final String FUNC_TRANSFERFROM = "transferFrom";

    public static final Event APPROVAL_EVENT = new Event("Approval", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event DELEGATECHANGED_EVENT = new Event("DelegateChanged", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event DELEGATEVOTESCHANGED_EVENT = new Event("DelegateVotesChanged", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event TRANSFER_EVENT = new Event("Transfer", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected ERC20VotesCompMock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected ERC20VotesCompMock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected ERC20VotesCompMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected ERC20VotesCompMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
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

    public RemoteFunctionCall<byte[]> DOMAIN_SEPARATOR() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_DOMAIN_SEPARATOR, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
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

    public RemoteFunctionCall<TransactionReceipt> burn(String account, BigInteger amount) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_BURN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, account), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Checkpoint> checkpoints(String account, BigInteger pos) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_CHECKPOINTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, account), 
                new org.web3j.abi.datatypes.generated.Uint32(pos)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Checkpoint>() {}));
        return executeRemoteCallSingleValueReturn(function, Checkpoint.class);
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

    public RemoteFunctionCall<TransactionReceipt> delegate(String delegatee) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_DELEGATE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, delegatee)), 
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

    public RemoteFunctionCall<BigInteger> getCurrentVotes(String account) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETCURRENTVOTES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, account)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint96>() {}));
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

    public RemoteFunctionCall<BigInteger> getPriorVotes(String account, BigInteger blockNumber) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETPRIORVOTES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, account), 
                new org.web3j.abi.datatypes.generated.Uint256(blockNumber)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint96>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getVotes(String account) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETVOTES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, account)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
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

    public RemoteFunctionCall<BigInteger> nonces(String owner) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_NONCES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, owner)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> numCheckpoints(String account) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_NUMCHECKPOINTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, account)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint32>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> permit(String owner, String spender, BigInteger value, BigInteger deadline, BigInteger v, byte[] r, byte[] s) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_PERMIT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, owner), 
                new org.web3j.abi.datatypes.Address(160, spender), 
                new org.web3j.abi.datatypes.generated.Uint256(value), 
                new org.web3j.abi.datatypes.generated.Uint256(deadline), 
                new org.web3j.abi.datatypes.generated.Uint8(v), 
                new org.web3j.abi.datatypes.generated.Bytes32(r), 
                new org.web3j.abi.datatypes.generated.Bytes32(s)), 
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
    public static ERC20VotesCompMock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new ERC20VotesCompMock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static ERC20VotesCompMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new ERC20VotesCompMock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static ERC20VotesCompMock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new ERC20VotesCompMock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static ERC20VotesCompMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new ERC20VotesCompMock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<ERC20VotesCompMock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String name, String symbol) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.Utf8String(symbol)));
        return deployRemoteCall(ERC20VotesCompMock.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<ERC20VotesCompMock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String name, String symbol) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.Utf8String(symbol)));
        return deployRemoteCall(ERC20VotesCompMock.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ERC20VotesCompMock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String name, String symbol) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.Utf8String(symbol)));
        return deployRemoteCall(ERC20VotesCompMock.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<ERC20VotesCompMock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String name, String symbol) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.Utf8String(symbol)));
        return deployRemoteCall(ERC20VotesCompMock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class Checkpoint extends StaticStruct {
        public BigInteger fromBlock;

        public BigInteger votes;

        public Checkpoint(BigInteger fromBlock, BigInteger votes) {
            super(new org.web3j.abi.datatypes.generated.Uint32(fromBlock), 
                    new org.web3j.abi.datatypes.generated.Uint224(votes));
            this.fromBlock = fromBlock;
            this.votes = votes;
        }

        public Checkpoint(Uint32 fromBlock, Uint224 votes) {
            super(fromBlock, votes);
            this.fromBlock = fromBlock.getValue();
            this.votes = votes.getValue();
        }
    }

    public static class ApprovalEventResponse extends BaseEventResponse {
        public String owner;

        public String spender;

        public BigInteger value;
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

    public static class TransferEventResponse extends BaseEventResponse {
        public String from;

        public String to;

        public BigInteger value;
    }
}
