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
import org.web3j.abi.datatypes.DynamicBytes;
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
public class TimelockController extends Contract {
    public static final String BINARY = "60806040523480156200001157600080fd5b506040516200232638038062002326833981016040819052620000349162000408565b6200004f600080516020620022a6833981519152806200022d565b62000079600080516020620022c6833981519152600080516020620022a68339815191526200022d565b620000a3600080516020620022e6833981519152600080516020620022a68339815191526200022d565b620000cd60008051602062002306833981519152600080516020620022a68339815191526200022d565b620000e8600080516020620022a68339815191523062000278565b6001600160a01b03811615620001135762000113600080516020620022a68339815191528262000278565b60005b835181101562000199576200015d600080516020620022c68339815191528583815181106200014957620001496200048f565b60200260200101516200027860201b60201c565b62000186600080516020620023068339815191528583815181106200014957620001496200048f565b6200019181620004a5565b905062000116565b5060005b8251811015620001e357620001d0600080516020620022e68339815191528483815181106200014957620001496200048f565b620001db81620004a5565b90506200019d565b5060028490556040805160008152602081018690527f11c24f4ead16507c69ac467fbd5e4eed5fb5c699626d2cc6d66421df253886d5910160405180910390a150505050620004cf565b600082815260208190526040808220600101805490849055905190918391839186917fbd79b86ffe0ab8e8776151514217cd7cacd52c909f66475c3af44e129f0b00ff9190a4505050565b62000284828262000288565b5050565b6000828152602081815260408083206001600160a01b038516845290915290205460ff1662000284576000828152602081815260408083206001600160a01b03851684529091529020805460ff19166001179055620002e43390565b6001600160a01b0316816001600160a01b0316837f2f8788117e7eff1d82e926ec794901d17c78024a50270940304540a733656f0d60405160405180910390a45050565b634e487b7160e01b600052604160045260246000fd5b80516001600160a01b03811681146200035657600080fd5b919050565b600082601f8301126200036d57600080fd5b815160206001600160401b03808311156200038c576200038c62000328565b8260051b604051601f19603f83011681018181108482111715620003b457620003b462000328565b604052938452858101830193838101925087851115620003d357600080fd5b83870191505b84821015620003fd57620003ed826200033e565b83529183019190830190620003d9565b979650505050505050565b600080600080608085870312156200041f57600080fd5b845160208601519094506001600160401b03808211156200043f57600080fd5b6200044d888389016200035b565b945060408701519150808211156200046457600080fd5b5062000473878288016200035b565b92505062000484606086016200033e565b905092959194509250565b634e487b7160e01b600052603260045260246000fd5b6000600019821415620004c857634e487b7160e01b600052601160045260246000fd5b5060010190565b611dc780620004df6000396000f3fe6080604052600436106101bb5760003560e01c80638065657f116100ec578063bc197c811161008a578063d547741f11610064578063d547741f14610582578063e38335e5146105a2578063f23a6e61146105b5578063f27a0c92146105e157600080fd5b8063bc197c8114610509578063c4d252f514610535578063d45c44351461055557600080fd5b806391d14854116100c657806391d1485414610480578063a217fddf146104a0578063b08e51c0146104b5578063b1c5f427146104e957600080fd5b80638065657f1461040c5780638f2a0bb01461042c5780638f61f4f51461044c57600080fd5b8063248a9ca31161015957806331d507501161013357806331d507501461038c57806336568abe146103ac578063584b153e146103cc57806364d62353146103ec57600080fd5b8063248a9ca31461030b5780632ab0f5291461033b5780632f2ff15d1461036c57600080fd5b80630d3cf6fc116101955780630d3cf6fc14610260578063134008d31461029457806313bc9f20146102a7578063150b7a02146102c757600080fd5b806301d5062a146101c757806301ffc9a7146101e957806307bd02651461021e57600080fd5b366101c257005b600080fd5b3480156101d357600080fd5b506101e76101e23660046113c0565b6105f6565b005b3480156101f557600080fd5b50610209610204366004611434565b61068b565b60405190151581526020015b60405180910390f35b34801561022a57600080fd5b506102527fd8aa0f3194971a2a116679f7c2090f6939c8d4e01a2a8d7e41d55e5351469e6381565b604051908152602001610215565b34801561026c57600080fd5b506102527f5f58e3a2316349923ce3780f8d587db2d72378aed66a8261c916544fa6846ca581565b6101e76102a236600461145e565b6106b6565b3480156102b357600080fd5b506102096102c23660046114c9565b61076b565b3480156102d357600080fd5b506102f26102e2366004611597565b630a85bd0160e11b949350505050565b6040516001600160e01b03199091168152602001610215565b34801561031757600080fd5b506102526103263660046114c9565b60009081526020819052604090206001015490565b34801561034757600080fd5b506102096103563660046114c9565b6000908152600160208190526040909120541490565b34801561037857600080fd5b506101e76103873660046115fe565b610791565b34801561039857600080fd5b506102096103a73660046114c9565b6107bb565b3480156103b857600080fd5b506101e76103c73660046115fe565b6107d4565b3480156103d857600080fd5b506102096103e73660046114c9565b610857565b3480156103f857600080fd5b506101e76104073660046114c9565b61086d565b34801561041857600080fd5b5061025261042736600461145e565b610911565b34801561043857600080fd5b506101e761044736600461166e565b610950565b34801561045857600080fd5b506102527fb09aa5aeb3702cfd50b6b62bc4532604938f21248a27a1d5ca736082b6819cc181565b34801561048c57600080fd5b5061020961049b3660046115fe565b610aa2565b3480156104ac57600080fd5b50610252600081565b3480156104c157600080fd5b506102527ffd643c72710c63c0180259aba6b2d05451e3591a24e58b62239378085726f78381565b3480156104f557600080fd5b5061025261050436600461171f565b610acb565b34801561051557600080fd5b506102f2610524366004611846565b63bc197c8160e01b95945050505050565b34801561054157600080fd5b506101e76105503660046114c9565b610b10565b34801561056157600080fd5b506102526105703660046114c9565b60009081526001602052604090205490565b34801561058e57600080fd5b506101e761059d3660046115fe565b610be5565b6101e76105b036600461171f565b610c0a565b3480156105c157600080fd5b506102f26105d03660046118ef565b63f23a6e6160e01b95945050505050565b3480156105ed57600080fd5b50600254610252565b7fb09aa5aeb3702cfd50b6b62bc4532604938f21248a27a1d5ca736082b6819cc161062081610d94565b6000610630898989898989610911565b905061063c8184610da1565b6000817f4cf4410cc57040e44862ef0f45f3dd5a5e02db8eb8add648d4b0e236f1d07dca8b8b8b8b8b8a6040516106789695949392919061197c565b60405180910390a3505050505050505050565b60006001600160e01b03198216630271189760e51b14806106b057506106b082610e90565b92915050565b7fd8aa0f3194971a2a116679f7c2090f6939c8d4e01a2a8d7e41d55e5351469e636106e2816000610aa2565b6106f0576106f08133610ec5565b6000610700888888888888610911565b905061070c8185610f1e565b61071888888888610fba565b6000817fc2617efa69bab66782fa219543714338489c4e9e178271560a91b82c3f612b588a8a8a8a60405161075094939291906119b9565b60405180910390a36107618161108d565b5050505050505050565b60008181526001602052604081205460018111801561078a5750428111155b9392505050565b6000828152602081905260409020600101546107ac81610d94565b6107b683836110c6565b505050565b60008181526001602052604081205481905b1192915050565b6001600160a01b03811633146108495760405162461bcd60e51b815260206004820152602f60248201527f416363657373436f6e74726f6c3a2063616e206f6e6c792072656e6f756e636560448201526e103937b632b9903337b91039b2b63360891b60648201526084015b60405180910390fd5b610853828261114a565b5050565b60008181526001602081905260408220546107cd565b3330146108d05760405162461bcd60e51b815260206004820152602b60248201527f54696d656c6f636b436f6e74726f6c6c65723a2063616c6c6572206d7573742060448201526a62652074696d656c6f636b60a81b6064820152608401610840565b60025460408051918252602082018390527f11c24f4ead16507c69ac467fbd5e4eed5fb5c699626d2cc6d66421df253886d5910160405180910390a1600255565b600086868686868660405160200161092e9695949392919061197c565b6040516020818303038152906040528051906020012090509695505050505050565b7fb09aa5aeb3702cfd50b6b62bc4532604938f21248a27a1d5ca736082b6819cc161097a81610d94565b8887146109995760405162461bcd60e51b8152600401610840906119eb565b8885146109b85760405162461bcd60e51b8152600401610840906119eb565b60006109ca8b8b8b8b8b8b8b8b610acb565b90506109d68184610da1565b60005b8a811015610a945780827f4cf4410cc57040e44862ef0f45f3dd5a5e02db8eb8add648d4b0e236f1d07dca8e8e85818110610a1657610a16611a2e565b9050602002016020810190610a2b9190611a44565b8d8d86818110610a3d57610a3d611a2e565b905060200201358c8c87818110610a5657610a56611a2e565b9050602002810190610a689190611a5f565b8c8b604051610a7c9695949392919061197c565b60405180910390a3610a8d81611abb565b90506109d9565b505050505050505050505050565b6000918252602082815260408084206001600160a01b0393909316845291905290205460ff1690565b60008888888888888888604051602001610aec989796959493929190611b66565b60405160208183030381529060405280519060200120905098975050505050505050565b7ffd643c72710c63c0180259aba6b2d05451e3591a24e58b62239378085726f783610b3a81610d94565b610b4382610857565b610ba95760405162461bcd60e51b815260206004820152603160248201527f54696d656c6f636b436f6e74726f6c6c65723a206f7065726174696f6e2063616044820152701b9b9bdd0818994818d85b98d95b1b1959607a1b6064820152608401610840565b6000828152600160205260408082208290555183917fbaa1eb22f2a492ba1a5fea61b8df4d27c6c8b5f3971e63bb58fa14ff72eedb7091a25050565b600082815260208190526040902060010154610c0081610d94565b6107b6838361114a565b7fd8aa0f3194971a2a116679f7c2090f6939c8d4e01a2a8d7e41d55e5351469e63610c36816000610aa2565b610c4457610c448133610ec5565b878614610c635760405162461bcd60e51b8152600401610840906119eb565b878414610c825760405162461bcd60e51b8152600401610840906119eb565b6000610c948a8a8a8a8a8a8a8a610acb565b9050610ca08185610f1e565b60005b89811015610d7e5760008b8b83818110610cbf57610cbf611a2e565b9050602002016020810190610cd49190611a44565b905060008a8a84818110610cea57610cea611a2e565b9050602002013590503660008a8a86818110610d0857610d08611a2e565b9050602002810190610d1a9190611a5f565b91509150610d2a84848484610fba565b84867fc2617efa69bab66782fa219543714338489c4e9e178271560a91b82c3f612b5886868686604051610d6194939291906119b9565b60405180910390a35050505080610d7790611abb565b9050610ca3565b50610d888161108d565b50505050505050505050565b610d9e8133610ec5565b50565b610daa826107bb565b15610e0f5760405162461bcd60e51b815260206004820152602f60248201527f54696d656c6f636b436f6e74726f6c6c65723a206f7065726174696f6e20616c60448201526e1c9958591e481cd8da19591d5b1959608a1b6064820152608401610840565b600254811015610e705760405162461bcd60e51b815260206004820152602660248201527f54696d656c6f636b436f6e74726f6c6c65723a20696e73756666696369656e746044820152652064656c617960d01b6064820152608401610840565b610e7a8142611c11565b6000928352600160205260409092209190915550565b60006001600160e01b03198216637965db0b60e01b14806106b057506301ffc9a760e01b6001600160e01b03198316146106b0565b610ecf8282610aa2565b61085357610edc816111af565b610ee78360206111c1565b604051602001610ef8929190611c59565b60408051601f198184030181529082905262461bcd60e51b825261084091600401611cce565b610f278261076b565b610f435760405162461bcd60e51b815260040161084090611d01565b801580610f5f5750600081815260016020819052604090912054145b6108535760405162461bcd60e51b815260206004820152602660248201527f54696d656c6f636b436f6e74726f6c6c65723a206d697373696e6720646570656044820152656e64656e637960d01b6064820152608401610840565b6000846001600160a01b0316848484604051610fd7929190611d4b565b60006040518083038185875af1925050503d8060008114611014576040519150601f19603f3d011682016040523d82523d6000602084013e611019565b606091505b50509050806110865760405162461bcd60e51b815260206004820152603360248201527f54696d656c6f636b436f6e74726f6c6c65723a20756e6465726c79696e6720746044820152721c985b9cd858dd1a5bdb881c995d995c9d1959606a1b6064820152608401610840565b5050505050565b6110968161076b565b6110b25760405162461bcd60e51b815260040161084090611d01565b600090815260016020819052604090912055565b6110d08282610aa2565b610853576000828152602081815260408083206001600160a01b03851684529091529020805460ff191660011790556111063390565b6001600160a01b0316816001600160a01b0316837f2f8788117e7eff1d82e926ec794901d17c78024a50270940304540a733656f0d60405160405180910390a45050565b6111548282610aa2565b15610853576000828152602081815260408083206001600160a01b0385168085529252808320805460ff1916905551339285917ff6391f5c32d9c69d2a47ea670b442974b53935d1edc7fd64eb21e047a839171b9190a45050565b60606106b06001600160a01b03831660145b606060006111d0836002611d5b565b6111db906002611c11565b6001600160401b038111156111f2576111f26114e2565b6040519080825280601f01601f19166020018201604052801561121c576020820181803683370190505b509050600360fc1b8160008151811061123757611237611a2e565b60200101906001600160f81b031916908160001a905350600f60fb1b8160018151811061126657611266611a2e565b60200101906001600160f81b031916908160001a905350600061128a846002611d5b565b611295906001611c11565b90505b600181111561130d576f181899199a1a9b1b9c1cb0b131b232b360811b85600f16601081106112c9576112c9611a2e565b1a60f81b8282815181106112df576112df611a2e565b60200101906001600160f81b031916908160001a90535060049490941c9361130681611d7a565b9050611298565b50831561078a5760405162461bcd60e51b815260206004820181905260248201527f537472696e67733a20686578206c656e67746820696e73756666696369656e746044820152606401610840565b80356001600160a01b038116811461137357600080fd5b919050565b60008083601f84011261138a57600080fd5b5081356001600160401b038111156113a157600080fd5b6020830191508360208285010111156113b957600080fd5b9250929050565b600080600080600080600060c0888a0312156113db57600080fd5b6113e48861135c565b96506020880135955060408801356001600160401b0381111561140657600080fd5b6114128a828b01611378565b989b979a50986060810135976080820135975060a09091013595509350505050565b60006020828403121561144657600080fd5b81356001600160e01b03198116811461078a57600080fd5b60008060008060008060a0878903121561147757600080fd5b6114808761135c565b95506020870135945060408701356001600160401b038111156114a257600080fd5b6114ae89828a01611378565b979a9699509760608101359660809091013595509350505050565b6000602082840312156114db57600080fd5b5035919050565b634e487b7160e01b600052604160045260246000fd5b604051601f8201601f191681016001600160401b0381118282101715611520576115206114e2565b604052919050565b600082601f83011261153957600080fd5b81356001600160401b03811115611552576115526114e2565b611565601f8201601f19166020016114f8565b81815284602083860101111561157a57600080fd5b816020850160208301376000918101602001919091529392505050565b600080600080608085870312156115ad57600080fd5b6115b68561135c565b93506115c46020860161135c565b92506040850135915060608501356001600160401b038111156115e657600080fd5b6115f287828801611528565b91505092959194509250565b6000806040838503121561161157600080fd5b823591506116216020840161135c565b90509250929050565b60008083601f84011261163c57600080fd5b5081356001600160401b0381111561165357600080fd5b6020830191508360208260051b85010111156113b957600080fd5b600080600080600080600080600060c08a8c03121561168c57600080fd5b89356001600160401b03808211156116a357600080fd5b6116af8d838e0161162a565b909b50995060208c01359150808211156116c857600080fd5b6116d48d838e0161162a565b909950975060408c01359150808211156116ed57600080fd5b506116fa8c828d0161162a565b9a9d999c50979a969997986060880135976080810135975060a0013595509350505050565b60008060008060008060008060a0898b03121561173b57600080fd5b88356001600160401b038082111561175257600080fd5b61175e8c838d0161162a565b909a50985060208b013591508082111561177757600080fd5b6117838c838d0161162a565b909850965060408b013591508082111561179c57600080fd5b506117a98b828c0161162a565b999c989b509699959896976060870135966080013595509350505050565b600082601f8301126117d857600080fd5b813560206001600160401b038211156117f3576117f36114e2565b8160051b6118028282016114f8565b928352848101820192828101908785111561181c57600080fd5b83870192505b8483101561183b57823582529183019190830190611822565b979650505050505050565b600080600080600060a0868803121561185e57600080fd5b6118678661135c565b94506118756020870161135c565b935060408601356001600160401b038082111561189157600080fd5b61189d89838a016117c7565b945060608801359150808211156118b357600080fd5b6118bf89838a016117c7565b935060808801359150808211156118d557600080fd5b506118e288828901611528565b9150509295509295909350565b600080600080600060a0868803121561190757600080fd5b6119108661135c565b945061191e6020870161135c565b9350604086013592506060860135915060808601356001600160401b0381111561194757600080fd5b6118e288828901611528565b81835281816020850137506000828201602090810191909152601f909101601f19169091010190565b60018060a01b038716815285602082015260a0604082015260006119a460a083018688611953565b60608301949094525060800152949350505050565b60018060a01b03851681528360208201526060604082015260006119e1606083018486611953565b9695505050505050565b60208082526023908201527f54696d656c6f636b436f6e74726f6c6c65723a206c656e677468206d69736d616040820152620e8c6d60eb1b606082015260800190565b634e487b7160e01b600052603260045260246000fd5b600060208284031215611a5657600080fd5b61078a8261135c565b6000808335601e19843603018112611a7657600080fd5b8301803591506001600160401b03821115611a9057600080fd5b6020019150368190038213156113b957600080fd5b634e487b7160e01b600052601160045260246000fd5b6000600019821415611acf57611acf611aa5565b5060010190565b81835260006020808501808196508560051b810191508460005b87811015611b595782840389528135601e19883603018112611b1157600080fd5b870180356001600160401b03811115611b2957600080fd5b803603891315611b3857600080fd5b611b458682898501611953565b9a87019a9550505090840190600101611af0565b5091979650505050505050565b60a0808252810188905260008960c08301825b8b811015611ba7576001600160a01b03611b928461135c565b16825260209283019290910190600101611b79565b5083810360208501528881526001600160fb1b03891115611bc757600080fd5b8860051b9150818a602083013781810191505060208101600081526020848303016040850152611bf881888a611ad6565b6060850196909652505050608001529695505050505050565b60008219821115611c2457611c24611aa5565b500190565b60005b83811015611c44578181015183820152602001611c2c565b83811115611c53576000848401525b50505050565b7f416363657373436f6e74726f6c3a206163636f756e7420000000000000000000815260008351611c91816017850160208801611c29565b7001034b99036b4b9b9b4b733903937b6329607d1b6017918401918201528351611cc2816028840160208801611c29565b01602801949350505050565b6020815260008251806020840152611ced816040850160208701611c29565b601f01601f19169190910160400192915050565b6020808252602a908201527f54696d656c6f636b436f6e74726f6c6c65723a206f7065726174696f6e206973604082015269206e6f7420726561647960b01b606082015260800190565b8183823760009101908152919050565b6000816000190483118215151615611d7557611d75611aa5565b500290565b600081611d8957611d89611aa5565b50600019019056fea26469706673582212207308c08d71a71078b32d879f762c30dbcf4157a4e3d0e70eb493ed403b19d9d764736f6c634300080900335f58e3a2316349923ce3780f8d587db2d72378aed66a8261c916544fa6846ca5b09aa5aeb3702cfd50b6b62bc4532604938f21248a27a1d5ca736082b6819cc1d8aa0f3194971a2a116679f7c2090f6939c8d4e01a2a8d7e41d55e5351469e63fd643c72710c63c0180259aba6b2d05451e3591a24e58b62239378085726f783";

    public static final String FUNC_CANCELLER_ROLE = "CANCELLER_ROLE";

    public static final String FUNC_DEFAULT_ADMIN_ROLE = "DEFAULT_ADMIN_ROLE";

    public static final String FUNC_EXECUTOR_ROLE = "EXECUTOR_ROLE";

    public static final String FUNC_PROPOSER_ROLE = "PROPOSER_ROLE";

    public static final String FUNC_TIMELOCK_ADMIN_ROLE = "TIMELOCK_ADMIN_ROLE";

    public static final String FUNC_CANCEL = "cancel";

    public static final String FUNC_EXECUTE = "execute";

    public static final String FUNC_EXECUTEBATCH = "executeBatch";

    public static final String FUNC_GETMINDELAY = "getMinDelay";

    public static final String FUNC_GETROLEADMIN = "getRoleAdmin";

    public static final String FUNC_GETTIMESTAMP = "getTimestamp";

    public static final String FUNC_GRANTROLE = "grantRole";

    public static final String FUNC_HASROLE = "hasRole";

    public static final String FUNC_HASHOPERATION = "hashOperation";

    public static final String FUNC_HASHOPERATIONBATCH = "hashOperationBatch";

    public static final String FUNC_ISOPERATION = "isOperation";

    public static final String FUNC_ISOPERATIONDONE = "isOperationDone";

    public static final String FUNC_ISOPERATIONPENDING = "isOperationPending";

    public static final String FUNC_ISOPERATIONREADY = "isOperationReady";

    public static final String FUNC_ONERC1155BATCHRECEIVED = "onERC1155BatchReceived";

    public static final String FUNC_ONERC1155RECEIVED = "onERC1155Received";

    public static final String FUNC_ONERC721RECEIVED = "onERC721Received";

    public static final String FUNC_RENOUNCEROLE = "renounceRole";

    public static final String FUNC_REVOKEROLE = "revokeRole";

    public static final String FUNC_SCHEDULE = "schedule";

    public static final String FUNC_SCHEDULEBATCH = "scheduleBatch";

    public static final String FUNC_SUPPORTSINTERFACE = "supportsInterface";

    public static final String FUNC_UPDATEDELAY = "updateDelay";

    public static final Event CALLEXECUTED_EVENT = new Event("CallExecuted", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Uint256>(true) {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<DynamicBytes>() {}));
    ;

    public static final Event CALLSCHEDULED_EVENT = new Event("CallScheduled", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Uint256>(true) {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<DynamicBytes>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event CANCELLED_EVENT = new Event("Cancelled", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}));
    ;

    public static final Event MINDELAYCHANGE_EVENT = new Event("MinDelayChange", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event ROLEADMINCHANGED_EVENT = new Event("RoleAdminChanged", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Bytes32>(true) {}, new TypeReference<Bytes32>(true) {}));
    ;

    public static final Event ROLEGRANTED_EVENT = new Event("RoleGranted", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event ROLEREVOKED_EVENT = new Event("RoleRevoked", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    @Deprecated
    protected TimelockController(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected TimelockController(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected TimelockController(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected TimelockController(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<CallExecutedEventResponse> getCallExecutedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(CALLEXECUTED_EVENT, transactionReceipt);
        ArrayList<CallExecutedEventResponse> responses = new ArrayList<CallExecutedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            CallExecutedEventResponse typedResponse = new CallExecutedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.id = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.index = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.target = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<CallExecutedEventResponse> callExecutedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, CallExecutedEventResponse>() {
            @Override
            public CallExecutedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(CALLEXECUTED_EVENT, log);
                CallExecutedEventResponse typedResponse = new CallExecutedEventResponse();
                typedResponse.log = log;
                typedResponse.id = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.index = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.target = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<CallExecutedEventResponse> callExecutedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CALLEXECUTED_EVENT));
        return callExecutedEventFlowable(filter);
    }

    public static List<CallScheduledEventResponse> getCallScheduledEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(CALLSCHEDULED_EVENT, transactionReceipt);
        ArrayList<CallScheduledEventResponse> responses = new ArrayList<CallScheduledEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            CallScheduledEventResponse typedResponse = new CallScheduledEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.id = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.index = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.target = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.predecessor = (byte[]) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.delay = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<CallScheduledEventResponse> callScheduledEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, CallScheduledEventResponse>() {
            @Override
            public CallScheduledEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(CALLSCHEDULED_EVENT, log);
                CallScheduledEventResponse typedResponse = new CallScheduledEventResponse();
                typedResponse.log = log;
                typedResponse.id = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.index = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.target = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.predecessor = (byte[]) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse.delay = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<CallScheduledEventResponse> callScheduledEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CALLSCHEDULED_EVENT));
        return callScheduledEventFlowable(filter);
    }

    public static List<CancelledEventResponse> getCancelledEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(CANCELLED_EVENT, transactionReceipt);
        ArrayList<CancelledEventResponse> responses = new ArrayList<CancelledEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            CancelledEventResponse typedResponse = new CancelledEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.id = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<CancelledEventResponse> cancelledEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, CancelledEventResponse>() {
            @Override
            public CancelledEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(CANCELLED_EVENT, log);
                CancelledEventResponse typedResponse = new CancelledEventResponse();
                typedResponse.log = log;
                typedResponse.id = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<CancelledEventResponse> cancelledEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CANCELLED_EVENT));
        return cancelledEventFlowable(filter);
    }

    public static List<MinDelayChangeEventResponse> getMinDelayChangeEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(MINDELAYCHANGE_EVENT, transactionReceipt);
        ArrayList<MinDelayChangeEventResponse> responses = new ArrayList<MinDelayChangeEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            MinDelayChangeEventResponse typedResponse = new MinDelayChangeEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.oldDuration = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.newDuration = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<MinDelayChangeEventResponse> minDelayChangeEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, MinDelayChangeEventResponse>() {
            @Override
            public MinDelayChangeEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(MINDELAYCHANGE_EVENT, log);
                MinDelayChangeEventResponse typedResponse = new MinDelayChangeEventResponse();
                typedResponse.log = log;
                typedResponse.oldDuration = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.newDuration = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<MinDelayChangeEventResponse> minDelayChangeEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(MINDELAYCHANGE_EVENT));
        return minDelayChangeEventFlowable(filter);
    }

    public static List<RoleAdminChangedEventResponse> getRoleAdminChangedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(ROLEADMINCHANGED_EVENT, transactionReceipt);
        ArrayList<RoleAdminChangedEventResponse> responses = new ArrayList<RoleAdminChangedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            RoleAdminChangedEventResponse typedResponse = new RoleAdminChangedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.role = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.previousAdminRole = (byte[]) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.newAdminRole = (byte[]) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<RoleAdminChangedEventResponse> roleAdminChangedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, RoleAdminChangedEventResponse>() {
            @Override
            public RoleAdminChangedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ROLEADMINCHANGED_EVENT, log);
                RoleAdminChangedEventResponse typedResponse = new RoleAdminChangedEventResponse();
                typedResponse.log = log;
                typedResponse.role = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.previousAdminRole = (byte[]) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.newAdminRole = (byte[]) eventValues.getIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<RoleAdminChangedEventResponse> roleAdminChangedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ROLEADMINCHANGED_EVENT));
        return roleAdminChangedEventFlowable(filter);
    }

    public static List<RoleGrantedEventResponse> getRoleGrantedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(ROLEGRANTED_EVENT, transactionReceipt);
        ArrayList<RoleGrantedEventResponse> responses = new ArrayList<RoleGrantedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            RoleGrantedEventResponse typedResponse = new RoleGrantedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.role = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.account = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.sender = (String) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<RoleGrantedEventResponse> roleGrantedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, RoleGrantedEventResponse>() {
            @Override
            public RoleGrantedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ROLEGRANTED_EVENT, log);
                RoleGrantedEventResponse typedResponse = new RoleGrantedEventResponse();
                typedResponse.log = log;
                typedResponse.role = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.account = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.sender = (String) eventValues.getIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<RoleGrantedEventResponse> roleGrantedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ROLEGRANTED_EVENT));
        return roleGrantedEventFlowable(filter);
    }

    public static List<RoleRevokedEventResponse> getRoleRevokedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(ROLEREVOKED_EVENT, transactionReceipt);
        ArrayList<RoleRevokedEventResponse> responses = new ArrayList<RoleRevokedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            RoleRevokedEventResponse typedResponse = new RoleRevokedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.role = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.account = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.sender = (String) eventValues.getIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<RoleRevokedEventResponse> roleRevokedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, RoleRevokedEventResponse>() {
            @Override
            public RoleRevokedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ROLEREVOKED_EVENT, log);
                RoleRevokedEventResponse typedResponse = new RoleRevokedEventResponse();
                typedResponse.log = log;
                typedResponse.role = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.account = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.sender = (String) eventValues.getIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<RoleRevokedEventResponse> roleRevokedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ROLEREVOKED_EVENT));
        return roleRevokedEventFlowable(filter);
    }

    public RemoteFunctionCall<byte[]> CANCELLER_ROLE() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_CANCELLER_ROLE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<byte[]> DEFAULT_ADMIN_ROLE() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_DEFAULT_ADMIN_ROLE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<byte[]> EXECUTOR_ROLE() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_EXECUTOR_ROLE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<byte[]> PROPOSER_ROLE() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_PROPOSER_ROLE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<byte[]> TIMELOCK_ADMIN_ROLE() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_TIMELOCK_ADMIN_ROLE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<TransactionReceipt> cancel(byte[] id) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_CANCEL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(id)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> execute(String target, BigInteger value, byte[] payload, byte[] predecessor, byte[] salt, BigInteger weiValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_EXECUTE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, target), 
                new org.web3j.abi.datatypes.generated.Uint256(value), 
                new org.web3j.abi.datatypes.DynamicBytes(payload), 
                new org.web3j.abi.datatypes.generated.Bytes32(predecessor), 
                new org.web3j.abi.datatypes.generated.Bytes32(salt)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<TransactionReceipt> executeBatch(List<String> targets, List<BigInteger> values, List<byte[]> payloads, byte[] predecessor, byte[] salt, BigInteger weiValue) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_EXECUTEBATCH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(targets, org.web3j.abi.datatypes.Address.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(values, org.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.DynamicBytes>(
                        org.web3j.abi.datatypes.DynamicBytes.class,
                        org.web3j.abi.Utils.typeMap(payloads, org.web3j.abi.datatypes.DynamicBytes.class)), 
                new org.web3j.abi.datatypes.generated.Bytes32(predecessor), 
                new org.web3j.abi.datatypes.generated.Bytes32(salt)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<BigInteger> getMinDelay() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETMINDELAY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<byte[]> getRoleAdmin(byte[] role) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETROLEADMIN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(role)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<BigInteger> getTimestamp(byte[] id) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETTIMESTAMP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(id)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> grantRole(byte[] role, String account) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_GRANTROLE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(role), 
                new org.web3j.abi.datatypes.Address(160, account)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> hasRole(byte[] role, String account) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_HASROLE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(role), 
                new org.web3j.abi.datatypes.Address(160, account)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<byte[]> hashOperation(String target, BigInteger value, byte[] data, byte[] predecessor, byte[] salt) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_HASHOPERATION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, target), 
                new org.web3j.abi.datatypes.generated.Uint256(value), 
                new org.web3j.abi.datatypes.DynamicBytes(data), 
                new org.web3j.abi.datatypes.generated.Bytes32(predecessor), 
                new org.web3j.abi.datatypes.generated.Bytes32(salt)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<byte[]> hashOperationBatch(List<String> targets, List<BigInteger> values, List<byte[]> payloads, byte[] predecessor, byte[] salt) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_HASHOPERATIONBATCH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(targets, org.web3j.abi.datatypes.Address.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(values, org.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.DynamicBytes>(
                        org.web3j.abi.datatypes.DynamicBytes.class,
                        org.web3j.abi.Utils.typeMap(payloads, org.web3j.abi.datatypes.DynamicBytes.class)), 
                new org.web3j.abi.datatypes.generated.Bytes32(predecessor), 
                new org.web3j.abi.datatypes.generated.Bytes32(salt)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<Boolean> isOperation(byte[] id) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ISOPERATION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(id)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<Boolean> isOperationDone(byte[] id) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ISOPERATIONDONE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(id)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<Boolean> isOperationPending(byte[] id) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ISOPERATIONPENDING, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(id)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<Boolean> isOperationReady(byte[] id) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ISOPERATIONREADY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(id)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> onERC1155BatchReceived(String param0, String param1, List<BigInteger> param2, List<BigInteger> param3, byte[] param4) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ONERC1155BATCHRECEIVED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, param0), 
                new org.web3j.abi.datatypes.Address(160, param1), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(param2, org.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(param3, org.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.web3j.abi.datatypes.DynamicBytes(param4)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> onERC1155Received(String param0, String param1, BigInteger param2, BigInteger param3, byte[] param4) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ONERC1155RECEIVED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, param0), 
                new org.web3j.abi.datatypes.Address(160, param1), 
                new org.web3j.abi.datatypes.generated.Uint256(param2), 
                new org.web3j.abi.datatypes.generated.Uint256(param3), 
                new org.web3j.abi.datatypes.DynamicBytes(param4)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> onERC721Received(String param0, String param1, BigInteger param2, byte[] param3) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ONERC721RECEIVED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, param0), 
                new org.web3j.abi.datatypes.Address(160, param1), 
                new org.web3j.abi.datatypes.generated.Uint256(param2), 
                new org.web3j.abi.datatypes.DynamicBytes(param3)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> renounceRole(byte[] role, String account) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_RENOUNCEROLE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(role), 
                new org.web3j.abi.datatypes.Address(160, account)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> revokeRole(byte[] role, String account) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_REVOKEROLE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(role), 
                new org.web3j.abi.datatypes.Address(160, account)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> schedule(String target, BigInteger value, byte[] data, byte[] predecessor, byte[] salt, BigInteger delay) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SCHEDULE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, target), 
                new org.web3j.abi.datatypes.generated.Uint256(value), 
                new org.web3j.abi.datatypes.DynamicBytes(data), 
                new org.web3j.abi.datatypes.generated.Bytes32(predecessor), 
                new org.web3j.abi.datatypes.generated.Bytes32(salt), 
                new org.web3j.abi.datatypes.generated.Uint256(delay)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> scheduleBatch(List<String> targets, List<BigInteger> values, List<byte[]> payloads, byte[] predecessor, byte[] salt, BigInteger delay) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SCHEDULEBATCH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(targets, org.web3j.abi.datatypes.Address.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(values, org.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.DynamicBytes>(
                        org.web3j.abi.datatypes.DynamicBytes.class,
                        org.web3j.abi.Utils.typeMap(payloads, org.web3j.abi.datatypes.DynamicBytes.class)), 
                new org.web3j.abi.datatypes.generated.Bytes32(predecessor), 
                new org.web3j.abi.datatypes.generated.Bytes32(salt), 
                new org.web3j.abi.datatypes.generated.Uint256(delay)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> supportsInterface(byte[] interfaceId) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_SUPPORTSINTERFACE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes4(interfaceId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> updateDelay(BigInteger newDelay) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_UPDATEDELAY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(newDelay)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static TimelockController load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new TimelockController(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static TimelockController load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new TimelockController(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static TimelockController load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new TimelockController(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static TimelockController load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new TimelockController(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<TimelockController> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, BigInteger minDelay, List<String> proposers, List<String> executors, String admin) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(minDelay), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(proposers, org.web3j.abi.datatypes.Address.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(executors, org.web3j.abi.datatypes.Address.class)), 
                new org.web3j.abi.datatypes.Address(160, admin)));
        return deployRemoteCall(TimelockController.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<TimelockController> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, BigInteger minDelay, List<String> proposers, List<String> executors, String admin) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(minDelay), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(proposers, org.web3j.abi.datatypes.Address.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(executors, org.web3j.abi.datatypes.Address.class)), 
                new org.web3j.abi.datatypes.Address(160, admin)));
        return deployRemoteCall(TimelockController.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<TimelockController> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger minDelay, List<String> proposers, List<String> executors, String admin) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(minDelay), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(proposers, org.web3j.abi.datatypes.Address.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(executors, org.web3j.abi.datatypes.Address.class)), 
                new org.web3j.abi.datatypes.Address(160, admin)));
        return deployRemoteCall(TimelockController.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<TimelockController> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger minDelay, List<String> proposers, List<String> executors, String admin) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(minDelay), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(proposers, org.web3j.abi.datatypes.Address.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(executors, org.web3j.abi.datatypes.Address.class)), 
                new org.web3j.abi.datatypes.Address(160, admin)));
        return deployRemoteCall(TimelockController.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class CallExecutedEventResponse extends BaseEventResponse {
        public byte[] id;

        public BigInteger index;

        public String target;

        public BigInteger value;

        public byte[] data;
    }

    public static class CallScheduledEventResponse extends BaseEventResponse {
        public byte[] id;

        public BigInteger index;

        public String target;

        public BigInteger value;

        public byte[] data;

        public byte[] predecessor;

        public BigInteger delay;
    }

    public static class CancelledEventResponse extends BaseEventResponse {
        public byte[] id;
    }

    public static class MinDelayChangeEventResponse extends BaseEventResponse {
        public BigInteger oldDuration;

        public BigInteger newDuration;
    }

    public static class RoleAdminChangedEventResponse extends BaseEventResponse {
        public byte[] role;

        public byte[] previousAdminRole;

        public byte[] newAdminRole;
    }

    public static class RoleGrantedEventResponse extends BaseEventResponse {
        public byte[] role;

        public String account;

        public String sender;
    }

    public static class RoleRevokedEventResponse extends BaseEventResponse {
        public byte[] role;

        public String account;

        public String sender;
    }
}
