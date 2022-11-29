package de.tudresden.webofthingstokenization.externalsmartcontractlibrary;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
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
public class MerkleProofWrapper extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50610d9d806100206000396000f3fe608060405234801561001057600080fd5b50600436106100885760003560e01c80637ffe9d8c1161005b5780637ffe9d8c146100fc578063862aac961461010f5780638633381614610122578063ea5d3eb61461013557600080fd5b806332712d221461008d57806353b0f85f146100b35780635a9a49c7146100c657806362702a6b146100e9575b600080fd5b6100a061009b3660046108ed565b610148565b6040519081526020015b60405180910390f35b6100a06100c1366004610980565b610163565b6100d96100d43660046109cb565b61017a565b60405190151581526020016100aa565b6100a06100f7366004610a18565b610187565b6100d961010a366004610a5c565b610193565b6100d961011d366004610aac565b6101a1565b6100d9610130366004610bbe565b6101bc565b6100a0610143366004610c4f565b6101ca565b600061015786868686866101d7565b90505b95945050505050565b600061017084848461045a565b90505b9392505050565b60006101708484846104a6565b600061017383836104bc565b600061015a85858585610509565b60006101b1878787878787610521565b979650505050505050565b600061015a8585858561053d565b6000610170848484610547565b8051600090838060016101ea8985610cec565b6101f49190610d04565b146102465760405162461bcd60e51b815260206004820152601f60248201527f4d65726b6c6550726f6f663a20696e76616c6964206d756c746970726f6f660060448201526064015b60405180910390fd5b6000816001600160401b0381111561026057610260610819565b604051908082528060200260200182016040528015610289578160200160208202803683370190505b5090506000806000805b858110156103e25760008785106102ce5785846102af81610d1b565b9550815181106102c1576102c1610d36565b60200260200101516102f4565b89856102d981610d1b565b9650815181106102eb576102eb610d36565b60200260200101515b905060008c8c8481811061030a5761030a610d36565b905060200201602081019061031f9190610d4c565b61034c578e8e8561032f81610d1b565b965081811061034057610340610d36565b905060200201356103a3565b88861061037d57868561035e81610d1b565b96508151811061037057610370610d36565b60200260200101516103a3565b8a8661038881610d1b565b97508151811061039a5761039a610d36565b60200260200101515b90506103af828261079f565b8784815181106103c1576103c1610d36565b602002602001018181525050505080806103da90610d1b565b915050610293565b50841561041a57836103f5600187610d04565b8151811061040557610405610d36565b6020026020010151965050505050505061015a565b8515610433578760008151811061040557610405610d36565b8b8b600081811061044657610446610d36565b90506020020135965050505050505061015a565b600081815b8481101561049d576104898287878481811061047d5761047d610d36565b9050602002013561079f565b91508061049581610d1b565b91505061045f565b50949350505050565b6000826104b385846104bc565b14949350505050565b600081815b8451811015610501576104ed828683815181106104e0576104e0610d36565b602002602001015161079f565b9150806104f981610d1b565b9150506104c1565b509392505050565b60008261051786868561045a565b1495945050505050565b60008261053188888888876101d7565b14979650505050505050565b6000826105178686855b805182518451600092919081906001906105619085610cec565b61056b9190610d04565b146105b85760405162461bcd60e51b815260206004820152601f60248201527f4d65726b6c6550726f6f663a20696e76616c6964206d756c746970726f6f6600604482015260640161023d565b6000816001600160401b038111156105d2576105d2610819565b6040519080825280602002602001820160405280156105fb578160200160208202803683370190505b5090506000806000805b8581101561073b57600087851061064057858461062181610d1b565b95508151811061063357610633610d36565b6020026020010151610666565b898561064b81610d1b565b96508151811061065d5761065d610d36565b60200260200101515b905060008b838151811061067c5761067c610d36565b60200260200101516106b2578c8461069381610d1b565b9550815181106106a5576106a5610d36565b60200260200101516106fc565b8886106106d65786856106c481610d1b565b9650815181106106a5576106a5610d36565b8a866106e181610d1b565b9750815181106106f3576106f3610d36565b60200260200101515b9050610708828261079f565b87848151811061071a5761071a610d36565b6020026020010181815250505050808061073390610d1b565b915050610605565b508415610773578361074e600187610d04565b8151811061075e5761075e610d36565b60200260200101519650505050505050610173565b851561078c578760008151811061075e5761075e610d36565b8960008151811061075e5761075e610d36565b60008183106107bb576000828152602084905260409020610173565b6000838152602083905260409020610173565b60008083601f8401126107e057600080fd5b5081356001600160401b038111156107f757600080fd5b6020830191508360208260051b850101111561081257600080fd5b9250929050565b634e487b7160e01b600052604160045260246000fd5b604051601f8201601f191681016001600160401b038111828210171561085757610857610819565b604052919050565b60006001600160401b0382111561087857610878610819565b5060051b60200190565b600082601f83011261089357600080fd5b813560206108a86108a38361085f565b61082f565b82815260059290921b840181019181810190868411156108c757600080fd5b8286015b848110156108e257803583529183019183016108cb565b509695505050505050565b60008060008060006060868803121561090557600080fd5b85356001600160401b038082111561091c57600080fd5b61092889838a016107ce565b9097509550602088013591508082111561094157600080fd5b61094d89838a016107ce565b9095509350604088013591508082111561096657600080fd5b5061097388828901610882565b9150509295509295909350565b60008060006040848603121561099557600080fd5b83356001600160401b038111156109ab57600080fd5b6109b7868287016107ce565b909790965060209590950135949350505050565b6000806000606084860312156109e057600080fd5b83356001600160401b038111156109f657600080fd5b610a0286828701610882565b9660208601359650604090950135949350505050565b60008060408385031215610a2b57600080fd5b82356001600160401b03811115610a4157600080fd5b610a4d85828601610882565b95602094909401359450505050565b60008060008060608587031215610a7257600080fd5b84356001600160401b03811115610a8857600080fd5b610a94878288016107ce565b90989097506020870135966040013595509350505050565b60008060008060008060808789031215610ac557600080fd5b86356001600160401b0380821115610adc57600080fd5b610ae88a838b016107ce565b90985096506020890135915080821115610b0157600080fd5b610b0d8a838b016107ce565b9096509450604089013593506060890135915080821115610b2d57600080fd5b50610b3a89828a01610882565b9150509295509295509295565b80358015158114610b5757600080fd5b919050565b600082601f830112610b6d57600080fd5b81356020610b7d6108a38361085f565b82815260059290921b84018101918181019086841115610b9c57600080fd5b8286015b848110156108e257610bb181610b47565b8352918301918301610ba0565b60008060008060808587031215610bd457600080fd5b84356001600160401b0380821115610beb57600080fd5b610bf788838901610882565b95506020870135915080821115610c0d57600080fd5b610c1988838901610b5c565b9450604087013593506060870135915080821115610c3657600080fd5b50610c4387828801610882565b91505092959194509250565b600080600060608486031215610c6457600080fd5b83356001600160401b0380821115610c7b57600080fd5b610c8787838801610882565b94506020860135915080821115610c9d57600080fd5b610ca987838801610b5c565b93506040860135915080821115610cbf57600080fd5b50610ccc86828701610882565b9150509250925092565b634e487b7160e01b600052601160045260246000fd5b60008219821115610cff57610cff610cd6565b500190565b600082821015610d1657610d16610cd6565b500390565b6000600019821415610d2f57610d2f610cd6565b5060010190565b634e487b7160e01b600052603260045260246000fd5b600060208284031215610d5e57600080fd5b61017382610b4756fea2646970667358221220436683705a0daddda3821bfbe69c8d843d5372f9cbe3777c1161affac4d2175664736f6c63430008090033";

    public static final String FUNC_MULTIPROOFVERIFY = "multiProofVerify";

    public static final String FUNC_MULTIPROOFVERIFYCALLDATA = "multiProofVerifyCalldata";

    public static final String FUNC_PROCESSMULTIPROOF = "processMultiProof";

    public static final String FUNC_PROCESSMULTIPROOFCALLDATA = "processMultiProofCalldata";

    public static final String FUNC_PROCESSPROOF = "processProof";

    public static final String FUNC_PROCESSPROOFCALLDATA = "processProofCalldata";

    public static final String FUNC_VERIFY = "verify";

    public static final String FUNC_VERIFYCALLDATA = "verifyCalldata";

    @Deprecated
    protected MerkleProofWrapper(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected MerkleProofWrapper(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected MerkleProofWrapper(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected MerkleProofWrapper(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<Boolean> multiProofVerify(List<byte[]> proofs, List<Boolean> proofFlag, byte[] root, List<byte[]> leaves) {
        final Function function = new Function(FUNC_MULTIPROOFVERIFY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(proofs, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Bool>(
                        org.web3j.abi.datatypes.Bool.class,
                        org.web3j.abi.Utils.typeMap(proofFlag, org.web3j.abi.datatypes.Bool.class)), 
                new org.web3j.abi.datatypes.generated.Bytes32(root), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(leaves, org.web3j.abi.datatypes.generated.Bytes32.class))), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<Boolean> multiProofVerifyCalldata(List<byte[]> proofs, List<Boolean> proofFlag, byte[] root, List<byte[]> leaves) {
        final Function function = new Function(FUNC_MULTIPROOFVERIFYCALLDATA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(proofs, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Bool>(
                        org.web3j.abi.datatypes.Bool.class,
                        org.web3j.abi.Utils.typeMap(proofFlag, org.web3j.abi.datatypes.Bool.class)), 
                new org.web3j.abi.datatypes.generated.Bytes32(root), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(leaves, org.web3j.abi.datatypes.generated.Bytes32.class))), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<byte[]> processMultiProof(List<byte[]> proofs, List<Boolean> proofFlag, List<byte[]> leaves) {
        final Function function = new Function(FUNC_PROCESSMULTIPROOF, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(proofs, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Bool>(
                        org.web3j.abi.datatypes.Bool.class,
                        org.web3j.abi.Utils.typeMap(proofFlag, org.web3j.abi.datatypes.Bool.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(leaves, org.web3j.abi.datatypes.generated.Bytes32.class))), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<byte[]> processMultiProofCalldata(List<byte[]> proofs, List<Boolean> proofFlag, List<byte[]> leaves) {
        final Function function = new Function(FUNC_PROCESSMULTIPROOFCALLDATA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(proofs, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Bool>(
                        org.web3j.abi.datatypes.Bool.class,
                        org.web3j.abi.Utils.typeMap(proofFlag, org.web3j.abi.datatypes.Bool.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(leaves, org.web3j.abi.datatypes.generated.Bytes32.class))), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<byte[]> processProof(List<byte[]> proof, byte[] leaf) {
        final Function function = new Function(FUNC_PROCESSPROOF, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(proof, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.generated.Bytes32(leaf)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<byte[]> processProofCalldata(List<byte[]> proof, byte[] leaf) {
        final Function function = new Function(FUNC_PROCESSPROOFCALLDATA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(proof, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.generated.Bytes32(leaf)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<Boolean> verify(List<byte[]> proof, byte[] root, byte[] leaf) {
        final Function function = new Function(FUNC_VERIFY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(proof, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.generated.Bytes32(root), 
                new org.web3j.abi.datatypes.generated.Bytes32(leaf)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<Boolean> verifyCalldata(List<byte[]> proof, byte[] root, byte[] leaf) {
        final Function function = new Function(FUNC_VERIFYCALLDATA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(proof, org.web3j.abi.datatypes.generated.Bytes32.class)), 
                new org.web3j.abi.datatypes.generated.Bytes32(root), 
                new org.web3j.abi.datatypes.generated.Bytes32(leaf)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    @Deprecated
    public static MerkleProofWrapper load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new MerkleProofWrapper(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static MerkleProofWrapper load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new MerkleProofWrapper(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static MerkleProofWrapper load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new MerkleProofWrapper(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static MerkleProofWrapper load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new MerkleProofWrapper(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<MerkleProofWrapper> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(MerkleProofWrapper.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<MerkleProofWrapper> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(MerkleProofWrapper.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<MerkleProofWrapper> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(MerkleProofWrapper.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<MerkleProofWrapper> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(MerkleProofWrapper.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
