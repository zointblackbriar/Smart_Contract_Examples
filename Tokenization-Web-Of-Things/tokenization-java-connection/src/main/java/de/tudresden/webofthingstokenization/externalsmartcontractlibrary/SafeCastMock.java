package de.tudresden.webofthingstokenization.externalsmartcontractlibrary;

import java.math.BigInteger;
import java.util.Arrays;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Int104;
import org.web3j.abi.datatypes.generated.Int112;
import org.web3j.abi.datatypes.generated.Int120;
import org.web3j.abi.datatypes.generated.Int128;
import org.web3j.abi.datatypes.generated.Int136;
import org.web3j.abi.datatypes.generated.Int144;
import org.web3j.abi.datatypes.generated.Int152;
import org.web3j.abi.datatypes.generated.Int16;
import org.web3j.abi.datatypes.generated.Int160;
import org.web3j.abi.datatypes.generated.Int168;
import org.web3j.abi.datatypes.generated.Int176;
import org.web3j.abi.datatypes.generated.Int184;
import org.web3j.abi.datatypes.generated.Int192;
import org.web3j.abi.datatypes.generated.Int200;
import org.web3j.abi.datatypes.generated.Int208;
import org.web3j.abi.datatypes.generated.Int216;
import org.web3j.abi.datatypes.generated.Int224;
import org.web3j.abi.datatypes.generated.Int232;
import org.web3j.abi.datatypes.generated.Int24;
import org.web3j.abi.datatypes.generated.Int240;
import org.web3j.abi.datatypes.generated.Int248;
import org.web3j.abi.datatypes.generated.Int256;
import org.web3j.abi.datatypes.generated.Int32;
import org.web3j.abi.datatypes.generated.Int40;
import org.web3j.abi.datatypes.generated.Int48;
import org.web3j.abi.datatypes.generated.Int56;
import org.web3j.abi.datatypes.generated.Int64;
import org.web3j.abi.datatypes.generated.Int72;
import org.web3j.abi.datatypes.generated.Int8;
import org.web3j.abi.datatypes.generated.Int80;
import org.web3j.abi.datatypes.generated.Int88;
import org.web3j.abi.datatypes.generated.Int96;
import org.web3j.abi.datatypes.generated.Uint104;
import org.web3j.abi.datatypes.generated.Uint112;
import org.web3j.abi.datatypes.generated.Uint120;
import org.web3j.abi.datatypes.generated.Uint128;
import org.web3j.abi.datatypes.generated.Uint136;
import org.web3j.abi.datatypes.generated.Uint144;
import org.web3j.abi.datatypes.generated.Uint152;
import org.web3j.abi.datatypes.generated.Uint16;
import org.web3j.abi.datatypes.generated.Uint160;
import org.web3j.abi.datatypes.generated.Uint168;
import org.web3j.abi.datatypes.generated.Uint176;
import org.web3j.abi.datatypes.generated.Uint184;
import org.web3j.abi.datatypes.generated.Uint192;
import org.web3j.abi.datatypes.generated.Uint200;
import org.web3j.abi.datatypes.generated.Uint208;
import org.web3j.abi.datatypes.generated.Uint216;
import org.web3j.abi.datatypes.generated.Uint224;
import org.web3j.abi.datatypes.generated.Uint232;
import org.web3j.abi.datatypes.generated.Uint24;
import org.web3j.abi.datatypes.generated.Uint240;
import org.web3j.abi.datatypes.generated.Uint248;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint32;
import org.web3j.abi.datatypes.generated.Uint40;
import org.web3j.abi.datatypes.generated.Uint48;
import org.web3j.abi.datatypes.generated.Uint56;
import org.web3j.abi.datatypes.generated.Uint64;
import org.web3j.abi.datatypes.generated.Uint72;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.abi.datatypes.generated.Uint80;
import org.web3j.abi.datatypes.generated.Uint88;
import org.web3j.abi.datatypes.generated.Uint96;
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
public class SafeCastMock extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50612265806100206000396000f3fe608060405234801561001057600080fd5b50600436106103d05760003560e01c8063809fdd33116101ff578063c81932551161011a578063e5feca77116100ad578063eaeff4e51161007c578063eaeff4e514610d55578063f136dc0214610d7b578063fb7f3c7914610da1578063fdcf791b14610dca57600080fd5b8063e5feca7714610cbd578063e6a6f6f814610ce3578063e87167c314610d09578063ea4b667414610d2f57600080fd5b8063dd2a0316116100e9578063dd2a031614610c25578063dfbe873b14610c4b578063dfef6beb14610c6c578063e46ea12014610c9757600080fd5b8063c819325514610b83578063cbff595f14610bab578063cf65b4d314610bd9578063d6bd32aa14610bff57600080fd5b80639c6f59be11610192578063b936bfb311610161578063b936bfb314610adc578063bb33fe0814610b07578063c3cd16b514610b32578063c4b4298c14610b5857600080fd5b80639c6f59be14610a3b578063ad4b458a14610a61578063b012db6f14610a8c578063b0a9408714610ab657600080fd5b80638c48fc22116101ce5780638c48fc221461099d5780639374068f146109c857806395cb3ec6146109ee578063971bcc2214610a1557600080fd5b8063809fdd33146108f0578063821bedfa1461091b578063839838381461094157806385bb6ae11461097257600080fd5b80633b703090116102ef5780635badd405116102825780636d6d9e4b116102515780636d6d9e4b14610845578063720ad6741461086b578063785de9bf146108965780637ef90ce0146108c157600080fd5b80635badd405146107a85780635bb79860146107ce57806368048346146107f95780636c5048531461081f57600080fd5b806353b916f1116102be57806353b916f11461070657806354c23feb1461072c578063564121c71461075757806358d421eb1461078257600080fd5b80633b7030901461065f5780633fd726721461068a57806341d2aa64146106b557806343710f46146106e057600080fd5b80631cf887fc116103675780632665fad0116103365780632665fad0146105ba5780632c81868d146105e6578063316fcbbd1461060c57806338d8e45a1461063957600080fd5b80631cf887fc146105135780631d1131e2146105435780631e07d036146105695780631e4e4bad1461058f57600080fd5b80630cc4681e116103a35780630cc4681e146104775780630d4a7bdb1461049c57806311e867ff146104c757806318a359ec146104ed57600080fd5b806301b49217146103d557806305752e511461040057806305b131011461042657806307f841be14610451575b600080fd5b6103e86103e3366004611ac4565b610ddd565b604051601e9190910b81526020015b60405180910390f35b61041361040e366004611ac4565b610dee565b604051601c9190910b81526020016103f7565b610439610434366004611ac4565b610df9565b6040516001600160b01b0390911681526020016103f7565b61046461045f366004611ac4565b610e04565b60405160179190910b81526020016103f7565b61048a610485366004611ac4565b610e0f565b60405160ff90911681526020016103f7565b6104af6104aa366004611ac4565b610e1a565b6040516001600160e81b0390911681526020016103f7565b6104da6104d5366004611ac4565b610e25565b60405160189190910b81526020016103f7565b6105006104fb366004611ac4565b610e30565b60405160059190910b81526020016103f7565b610526610521366004611ac4565b610e3b565b6040516bffffffffffffffffffffffff90911681526020016103f7565b610556610551366004611ac4565b610e46565b604051600b9190910b81526020016103f7565b61057c610577366004611ac4565b610e51565b604051600c9190910b81526020016103f7565b6105a261059d366004611ac4565b610e5c565b6040516001600160781b0390911681526020016103f7565b6105cd6105c8366004611ac4565b610e67565b60405167ffffffffffffffff90911681526020016103f7565b6105f96105f4366004611ac4565b610e72565b60405160099190910b81526020016103f7565b61061f61061a366004611ac4565b610e7d565b60405168ffffffffffffffffff90911681526020016103f7565b61064c610647366004611ac4565b610e88565b604051601b9190910b81526020016103f7565b61067261066d366004611ac4565b610e93565b6040516001600160f01b0390911681526020016103f7565b61069d610698366004611ac4565b610e9e565b6040516001600160f81b0390911681526020016103f7565b6106c86106c3366004611ac4565b610ea9565b6040516001600160701b0390911681526020016103f7565b6106f36106ee366004611ac4565b610eb4565b60405160069190910b81526020016103f7565b610719610714366004611ac4565b610ebf565b604051601d9190910b81526020016103f7565b61073f61073a366004611ac4565b610eca565b6040516001600160a81b0390911681526020016103f7565b61076a610765366004611ac4565b610ed5565b6040516001600160b81b0390911681526020016103f7565b610795610790366004611ac4565b610ee0565b604051600d9190910b81526020016103f7565b6107bb6107b6366004611ac4565b610eeb565b60405160129190910b81526020016103f7565b6107e16107dc366004611ac4565b610ef6565b6040516001600160e01b0390911681526020016103f7565b61080c610807366004611ac4565b610f01565b60405160139190910b81526020016103f7565b61083261082d366004611ac4565b610f0c565b60405160169190910b81526020016103f7565b610858610853366004611ac4565b610f17565b60405160119190910b81526020016103f7565b61087e610879366004611ac4565b610f22565b6040516001600160c81b0390911681526020016103f7565b6108a96108a4366004611ac4565b610f2d565b6040516001600160c01b0390911681526020016103f7565b6108d46108cf366004611ac4565b610f38565b6040516affffffffffffffffffffff90911681526020016103f7565b6109036108fe366004611ac4565b610f43565b6040516001600160801b0390911681526020016103f7565b61092e610929366004611ac4565b610f4e565b60405160159190910b81526020016103f7565b61095461094f366004611ac4565b610f59565b6040516cffffffffffffffffffffffffff90911681526020016103f7565b610985610980366004611ac4565b610f64565b6040516001600160d81b0390911681526020016103f7565b6109b06109ab366004611ac4565b610f6f565b6040516001600160981b0390911681526020016103f7565b6109db6109d6366004611ac4565b610f7a565b60405161ffff90911681526020016103f7565b610a016109fc366004611ac4565b610f85565b60405162ffffff90911681526020016103f7565b610a28610a23366004611ac4565b610f90565b604051600a9190910b81526020016103f7565b610a4e610a49366004611ac4565b610f9b565b60405160039190910b81526020016103f7565b610a74610a6f366004611ac4565b610fa6565b6040516001600160881b0390911681526020016103f7565b610a9f610a9a366004611ac4565b610fb1565b60405165ffffffffffff90911681526020016103f7565b610ac9610ac4366004611ac4565b610fbc565b60405160109190910b81526020016103f7565b610aef610aea366004611ac4565b610fc7565b6040516001600160901b0390911681526020016103f7565b610b1a610b15366004611ac4565b610fd2565b6040516001600160d01b0390911681526020016103f7565b610b45610b40366004611ac4565b610fdd565b60405160049190910b81526020016103f7565b610b6b610b66366004611ac4565b610fe8565b60405166ffffffffffffff90911681526020016103f7565b610b96610b91366004611ac4565b610ff3565b60405163ffffffff90911681526020016103f7565b610bbe610bb9366004611ac4565b610ffe565b60405169ffffffffffffffffffff90911681526020016103f7565b610bec610be7366004611ac4565b611009565b60405160019190910b81526020016103f7565b610c12610c0d366004611ac4565b611014565b60405160079190910b81526020016103f7565b610c38610c33366004611ac4565b61101f565b604051600f9190910b81526020016103f7565b610c5e610c59366004611ac4565b61102a565b6040519081526020016103f7565b610c7f610c7a366004611ac4565b611035565b6040516001600160a01b0390911681526020016103f7565b610caa610ca5366004611ac4565b611040565b60405160089190910b81526020016103f7565b610cd0610ccb366004611ac4565b61104b565b60405160029190910b81526020016103f7565b610cf6610cf1366004611ac4565b611056565b60405160149190910b81526020016103f7565b610d1c610d17366004611ac4565b611061565b604051601a9190910b81526020016103f7565b610d42610d3d366004611ac4565b61106c565b604051600e9190910b81526020016103f7565b610d68610d63366004611ac4565b611077565b60405160199190910b81526020016103f7565b610d8e610d89366004611ac4565b611082565b60405160009190910b81526020016103f7565b610db4610daf366004611ac4565b61108d565b60405164ffffffffff90911681526020016103f7565b610c5e610dd8366004611ac4565b611098565b6000610de8826110a3565b92915050565b6000610de8826110d5565b6000610de8826110f9565b6000610de882611126565b6000610de88261114a565b6000610de88261116d565b6000610de882611196565b6000610de8826111ba565b6000610de8826111de565b6000610de88261120c565b6000610de882611230565b6000610de882611254565b6000610de88261127d565b6000610de8826112a7565b6000610de8826112cb565b6000610de8826112f6565b6000610de88261131a565b6000610de882611343565b6000610de88261136c565b6000610de882611395565b6000610de8826113b9565b6000610de8826113dd565b6000610de882611406565b6000610de88261142f565b6000610de882611453565b6000610de882611477565b6000610de8826114a0565b6000610de8826114c4565b6000610de8826114e8565b6000610de88261150c565b6000610de882611535565b6000610de88261155e565b6000610de88261158b565b6000610de8826115b4565b6000610de8826115d8565b6000610de882611607565b6000610de882611630565b6000610de882611659565b6000610de88261167d565b6000610de8826116a2565b6000610de8826116c6565b6000610de8826116ea565b6000610de882611713565b6000610de88261173b565b6000610de88261175f565b6000610de882611788565b6000610de8826117b1565b6000610de8826117d5565b6000610de8826117fe565b6000610de882611824565b6000610de882611850565b6000610de882611874565b6000610de882611898565b6000610de8826118bc565b6000610de882611926565b6000610de88261194f565b6000610de882611973565b6000610de882611997565b6000610de8826119bb565b6000610de8826119df565b6000610de882611a03565b6000610de882611a27565b6000610de882611a4b565b6000610de882611a72565b80601e81900b81146110d05760405162461bcd60e51b81526004016110c790611add565b60405180910390fd5b919050565b80601c81900b81146110d05760405162461bcd60e51b81526004016110c790611b12565b60006001600160b01b038211156111225760405162461bcd60e51b81526004016110c790611b47565b5090565b80601781900b81146110d05760405162461bcd60e51b81526004016110c790611b7c565b600060ff8211156111225760405162461bcd60e51b81526004016110c790611bb1565b60006001600160e81b038211156111225760405162461bcd60e51b81526004016110c790611b12565b80601881900b81146110d05760405162461bcd60e51b81526004016110c790611bf6565b80600581900b81146110d05760405162461bcd60e51b81526004016110c790611c2b565b60006bffffffffffffffffffffffff8211156111225760405162461bcd60e51b81526004016110c790611c71565b80600b81900b81146110d05760405162461bcd60e51b81526004016110c790611c71565b80600c81900b81146110d05760405162461bcd60e51b81526004016110c790611cb7565b60006001600160781b038211156111225760405162461bcd60e51b81526004016110c790611cec565b600067ffffffffffffffff8211156111225760405162461bcd60e51b81526004016110c790611d21565b80600981900b81146110d05760405162461bcd60e51b81526004016110c790611d67565b600068ffffffffffffffffff8211156111225760405162461bcd60e51b81526004016110c790611dad565b80601b81900b81146110d05760405162461bcd60e51b81526004016110c790611df3565b60006001600160f01b038211156111225760405162461bcd60e51b81526004016110c790611e28565b60006001600160f81b038211156111225760405162461bcd60e51b81526004016110c790611add565b60006001600160701b038211156111225760405162461bcd60e51b81526004016110c790611e5d565b80600681900b81146110d05760405162461bcd60e51b81526004016110c790611e92565b80601d81900b81146110d05760405162461bcd60e51b81526004016110c790611e28565b60006001600160a81b038211156111225760405162461bcd60e51b81526004016110c790611ed8565b60006001600160b81b038211156111225760405162461bcd60e51b81526004016110c790611f0d565b80600d81900b81146110d05760405162461bcd60e51b81526004016110c790611e5d565b80601281900b81146110d05760405162461bcd60e51b81526004016110c790611f42565b60006001600160e01b038211156111225760405162461bcd60e51b81526004016110c790611df3565b80601381900b81146110d05760405162461bcd60e51b81526004016110c790611f77565b80601681900b81146110d05760405162461bcd60e51b81526004016110c790611f0d565b80601181900b81146110d05760405162461bcd60e51b81526004016110c790611fac565b60006001600160c81b038211156111225760405162461bcd60e51b81526004016110c790611bf6565b60006001600160c01b038211156111225760405162461bcd60e51b81526004016110c790611b7c565b60006affffffffffffffffffffff8211156111225760405162461bcd60e51b81526004016110c790611fe1565b60006001600160801b038211156111225760405162461bcd60e51b81526004016110c790612027565b80601581900b81146110d05760405162461bcd60e51b81526004016110c790611b47565b60006cffffffffffffffffffffffffff8211156111225760405162461bcd60e51b81526004016110c790611cb7565b60006001600160d81b038211156111225760405162461bcd60e51b81526004016110c79061205c565b60006001600160981b038211156111225760405162461bcd60e51b81526004016110c790611f42565b600061ffff8211156111225760405162461bcd60e51b81526004016110c790612091565b600062ffffff8211156111225760405162461bcd60e51b81526004016110c7906120c5565b80600a81900b81146110d05760405162461bcd60e51b81526004016110c790611fe1565b80600381900b81146110d05760405162461bcd60e51b81526004016110c7906120f9565b60006001600160881b038211156111225760405162461bcd60e51b81526004016110c79061213f565b600065ffffffffffff8211156111225760405162461bcd60e51b81526004016110c790611c2b565b80601081900b81146110d05760405162461bcd60e51b81526004016110c79061213f565b60006001600160901b038211156111225760405162461bcd60e51b81526004016110c790611fac565b60006001600160d01b038211156111225760405162461bcd60e51b81526004016110c790612174565b80600481900b81146110d05760405162461bcd60e51b81526004016110c7906121a9565b600066ffffffffffffff8211156111225760405162461bcd60e51b81526004016110c790611e92565b600063ffffffff8211156111225760405162461bcd60e51b81526004016110c7906120f9565b600069ffffffffffffffffffff8211156111225760405162461bcd60e51b81526004016110c790611d67565b80600181900b81146110d05760405162461bcd60e51b81526004016110c790612091565b80600781900b81146110d05760405162461bcd60e51b81526004016110c790611d21565b80600f81900b81146110d05760405162461bcd60e51b81526004016110c790612027565b60006001600160ff1b038211156111225760405162461bcd60e51b815260206004820152602860248201527f53616665436173743a2076616c756520646f65736e27742066697420696e2061604482015267371034b73a191a9b60c11b60648201526084016110c7565b60006001600160a01b038211156111225760405162461bcd60e51b81526004016110c790611f77565b80600881900b81146110d05760405162461bcd60e51b81526004016110c790611dad565b80600281900b81146110d05760405162461bcd60e51b81526004016110c7906120c5565b80601481900b81146110d05760405162461bcd60e51b81526004016110c790611ed8565b80601a81900b81146110d05760405162461bcd60e51b81526004016110c79061205c565b80600e81900b81146110d05760405162461bcd60e51b81526004016110c790611cec565b80601981900b81146110d05760405162461bcd60e51b81526004016110c790612174565b80600081900b81146110d05760405162461bcd60e51b81526004016110c790611bb1565b600064ffffffffff8211156111225760405162461bcd60e51b81526004016110c7906121a9565b6000808212156111225760405162461bcd60e51b815260206004820181905260248201527f53616665436173743a2076616c7565206d75737420626520706f73697469766560448201526064016110c7565b600060208284031215611ad657600080fd5b5035919050565b60208082526027908201526000805160206122108339815191526040820152663438206269747360c81b606082015260800190565b60208082526027908201526000805160206122108339815191526040820152663332206269747360c81b606082015260800190565b60208082526027908201526000805160206121f08339815191526040820152663736206269747360c81b606082015260800190565b60208082526027908201526000805160206121f08339815191526040820152663932206269747360c81b606082015260800190565b60208082526025908201527f53616665436173743a2076616c756520646f65736e27742066697420696e2038604082015264206269747360d81b606082015260800190565b60208082526027908201526000805160206122108339815191526040820152663030206269747360c81b606082015260800190565b60208082526026908201527f53616665436173743a2076616c756520646f65736e27742066697420696e203460408201526538206269747360d01b606082015260800190565b60208082526026908201527f53616665436173743a2076616c756520646f65736e27742066697420696e203960408201526536206269747360d01b606082015260800190565b60208082526027908201526000805160206121f08339815191526040820152663034206269747360c81b606082015260800190565b60208082526027908201526000805160206121f08339815191526040820152663230206269747360c81b606082015260800190565b60208082526026908201527f53616665436173743a2076616c756520646f65736e27742066697420696e203660408201526534206269747360d01b606082015260800190565b60208082526026908201527f53616665436173743a2076616c756520646f65736e27742066697420696e203860408201526530206269747360d01b606082015260800190565b60208082526026908201527f53616665436173743a2076616c756520646f65736e27742066697420696e203760408201526532206269747360d01b606082015260800190565b60208082526027908201526000805160206122108339815191526040820152663234206269747360c81b606082015260800190565b60208082526027908201526000805160206122108339815191526040820152663430206269747360c81b606082015260800190565b60208082526027908201526000805160206121f08339815191526040820152663132206269747360c81b606082015260800190565b60208082526026908201527f53616665436173743a2076616c756520646f65736e27742066697420696e203560408201526536206269747360d01b606082015260800190565b60208082526027908201526000805160206121f08339815191526040820152663638206269747360c81b606082015260800190565b60208082526027908201526000805160206121f08339815191526040820152663834206269747360c81b606082015260800190565b60208082526027908201526000805160206121f08339815191526040820152663532206269747360c81b606082015260800190565b60208082526027908201526000805160206121f08339815191526040820152663630206269747360c81b606082015260800190565b60208082526027908201526000805160206121f08339815191526040820152663434206269747360c81b606082015260800190565b60208082526026908201527f53616665436173743a2076616c756520646f65736e27742066697420696e203860408201526538206269747360d01b606082015260800190565b60208082526027908201526000805160206121f08339815191526040820152663238206269747360c81b606082015260800190565b60208082526027908201526000805160206122108339815191526040820152663136206269747360c81b606082015260800190565b60208082526026908201526000805160206121f083398151915260408201526536206269747360d01b606082015260800190565b602080825260269082015260008051602061221083398151915260408201526534206269747360d01b606082015260800190565b60208082526026908201527f53616665436173743a2076616c756520646f65736e27742066697420696e203360408201526532206269747360d01b606082015260800190565b60208082526027908201526000805160206121f08339815191526040820152663336206269747360c81b606082015260800190565b60208082526027908201526000805160206122108339815191526040820152663038206269747360c81b606082015260800190565b60208082526026908201527f53616665436173743a2076616c756520646f65736e27742066697420696e203460408201526530206269747360d01b60608201526080019056fe53616665436173743a2076616c756520646f65736e27742066697420696e203153616665436173743a2076616c756520646f65736e27742066697420696e2032a26469706673582212203b9d861142ee6740cf67c567ea72d5508e10aaaa601ecd2d165fe207406fc8cc64736f6c63430008090033";

    public static final String FUNC_TOINT104 = "toInt104";

    public static final String FUNC_TOINT112 = "toInt112";

    public static final String FUNC_TOINT120 = "toInt120";

    public static final String FUNC_TOINT128 = "toInt128";

    public static final String FUNC_TOINT136 = "toInt136";

    public static final String FUNC_TOINT144 = "toInt144";

    public static final String FUNC_TOINT152 = "toInt152";

    public static final String FUNC_TOINT16 = "toInt16";

    public static final String FUNC_TOINT160 = "toInt160";

    public static final String FUNC_TOINT168 = "toInt168";

    public static final String FUNC_TOINT176 = "toInt176";

    public static final String FUNC_TOINT184 = "toInt184";

    public static final String FUNC_TOINT192 = "toInt192";

    public static final String FUNC_TOINT200 = "toInt200";

    public static final String FUNC_TOINT208 = "toInt208";

    public static final String FUNC_TOINT216 = "toInt216";

    public static final String FUNC_TOINT224 = "toInt224";

    public static final String FUNC_TOINT232 = "toInt232";

    public static final String FUNC_TOINT24 = "toInt24";

    public static final String FUNC_TOINT240 = "toInt240";

    public static final String FUNC_TOINT248 = "toInt248";

    public static final String FUNC_TOINT256 = "toInt256";

    public static final String FUNC_TOINT32 = "toInt32";

    public static final String FUNC_TOINT40 = "toInt40";

    public static final String FUNC_TOINT48 = "toInt48";

    public static final String FUNC_TOINT56 = "toInt56";

    public static final String FUNC_TOINT64 = "toInt64";

    public static final String FUNC_TOINT72 = "toInt72";

    public static final String FUNC_TOINT8 = "toInt8";

    public static final String FUNC_TOINT80 = "toInt80";

    public static final String FUNC_TOINT88 = "toInt88";

    public static final String FUNC_TOINT96 = "toInt96";

    public static final String FUNC_TOUINT104 = "toUint104";

    public static final String FUNC_TOUINT112 = "toUint112";

    public static final String FUNC_TOUINT120 = "toUint120";

    public static final String FUNC_TOUINT128 = "toUint128";

    public static final String FUNC_TOUINT136 = "toUint136";

    public static final String FUNC_TOUINT144 = "toUint144";

    public static final String FUNC_TOUINT152 = "toUint152";

    public static final String FUNC_TOUINT16 = "toUint16";

    public static final String FUNC_TOUINT160 = "toUint160";

    public static final String FUNC_TOUINT168 = "toUint168";

    public static final String FUNC_TOUINT176 = "toUint176";

    public static final String FUNC_TOUINT184 = "toUint184";

    public static final String FUNC_TOUINT192 = "toUint192";

    public static final String FUNC_TOUINT200 = "toUint200";

    public static final String FUNC_TOUINT208 = "toUint208";

    public static final String FUNC_TOUINT216 = "toUint216";

    public static final String FUNC_TOUINT224 = "toUint224";

    public static final String FUNC_TOUINT232 = "toUint232";

    public static final String FUNC_TOUINT24 = "toUint24";

    public static final String FUNC_TOUINT240 = "toUint240";

    public static final String FUNC_TOUINT248 = "toUint248";

    public static final String FUNC_TOUINT256 = "toUint256";

    public static final String FUNC_TOUINT32 = "toUint32";

    public static final String FUNC_TOUINT40 = "toUint40";

    public static final String FUNC_TOUINT48 = "toUint48";

    public static final String FUNC_TOUINT56 = "toUint56";

    public static final String FUNC_TOUINT64 = "toUint64";

    public static final String FUNC_TOUINT72 = "toUint72";

    public static final String FUNC_TOUINT8 = "toUint8";

    public static final String FUNC_TOUINT80 = "toUint80";

    public static final String FUNC_TOUINT88 = "toUint88";

    public static final String FUNC_TOUINT96 = "toUint96";

    @Deprecated
    protected SafeCastMock(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected SafeCastMock(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected SafeCastMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected SafeCastMock(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<BigInteger> toInt104(BigInteger a) {
        final Function function = new Function(FUNC_TOINT104, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int104>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toInt112(BigInteger a) {
        final Function function = new Function(FUNC_TOINT112, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int112>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toInt120(BigInteger a) {
        final Function function = new Function(FUNC_TOINT120, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int120>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toInt128(BigInteger a) {
        final Function function = new Function(FUNC_TOINT128, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int128>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toInt136(BigInteger a) {
        final Function function = new Function(FUNC_TOINT136, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int136>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toInt144(BigInteger a) {
        final Function function = new Function(FUNC_TOINT144, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int144>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toInt152(BigInteger a) {
        final Function function = new Function(FUNC_TOINT152, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int152>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toInt16(BigInteger a) {
        final Function function = new Function(FUNC_TOINT16, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int16>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toInt160(BigInteger a) {
        final Function function = new Function(FUNC_TOINT160, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int160>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toInt168(BigInteger a) {
        final Function function = new Function(FUNC_TOINT168, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int168>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toInt176(BigInteger a) {
        final Function function = new Function(FUNC_TOINT176, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int176>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toInt184(BigInteger a) {
        final Function function = new Function(FUNC_TOINT184, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int184>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toInt192(BigInteger a) {
        final Function function = new Function(FUNC_TOINT192, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int192>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toInt200(BigInteger a) {
        final Function function = new Function(FUNC_TOINT200, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int200>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toInt208(BigInteger a) {
        final Function function = new Function(FUNC_TOINT208, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int208>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toInt216(BigInteger a) {
        final Function function = new Function(FUNC_TOINT216, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int216>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toInt224(BigInteger a) {
        final Function function = new Function(FUNC_TOINT224, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int224>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toInt232(BigInteger a) {
        final Function function = new Function(FUNC_TOINT232, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int232>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toInt24(BigInteger a) {
        final Function function = new Function(FUNC_TOINT24, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int24>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toInt240(BigInteger a) {
        final Function function = new Function(FUNC_TOINT240, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int240>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toInt248(BigInteger a) {
        final Function function = new Function(FUNC_TOINT248, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int248>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toInt256(BigInteger a) {
        final Function function = new Function(FUNC_TOINT256, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toInt32(BigInteger a) {
        final Function function = new Function(FUNC_TOINT32, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int32>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toInt40(BigInteger a) {
        final Function function = new Function(FUNC_TOINT40, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int40>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toInt48(BigInteger a) {
        final Function function = new Function(FUNC_TOINT48, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int48>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toInt56(BigInteger a) {
        final Function function = new Function(FUNC_TOINT56, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int56>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toInt64(BigInteger a) {
        final Function function = new Function(FUNC_TOINT64, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int64>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toInt72(BigInteger a) {
        final Function function = new Function(FUNC_TOINT72, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int72>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toInt8(BigInteger a) {
        final Function function = new Function(FUNC_TOINT8, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toInt80(BigInteger a) {
        final Function function = new Function(FUNC_TOINT80, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int80>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toInt88(BigInteger a) {
        final Function function = new Function(FUNC_TOINT88, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int88>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toInt96(BigInteger a) {
        final Function function = new Function(FUNC_TOINT96, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int96>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toUint104(BigInteger a) {
        final Function function = new Function(FUNC_TOUINT104, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint104>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toUint112(BigInteger a) {
        final Function function = new Function(FUNC_TOUINT112, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint112>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toUint120(BigInteger a) {
        final Function function = new Function(FUNC_TOUINT120, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint120>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toUint128(BigInteger a) {
        final Function function = new Function(FUNC_TOUINT128, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint128>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toUint136(BigInteger a) {
        final Function function = new Function(FUNC_TOUINT136, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint136>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toUint144(BigInteger a) {
        final Function function = new Function(FUNC_TOUINT144, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint144>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toUint152(BigInteger a) {
        final Function function = new Function(FUNC_TOUINT152, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint152>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toUint16(BigInteger a) {
        final Function function = new Function(FUNC_TOUINT16, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint16>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toUint160(BigInteger a) {
        final Function function = new Function(FUNC_TOUINT160, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint160>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toUint168(BigInteger a) {
        final Function function = new Function(FUNC_TOUINT168, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint168>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toUint176(BigInteger a) {
        final Function function = new Function(FUNC_TOUINT176, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint176>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toUint184(BigInteger a) {
        final Function function = new Function(FUNC_TOUINT184, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint184>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toUint192(BigInteger a) {
        final Function function = new Function(FUNC_TOUINT192, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint192>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toUint200(BigInteger a) {
        final Function function = new Function(FUNC_TOUINT200, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint200>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toUint208(BigInteger a) {
        final Function function = new Function(FUNC_TOUINT208, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint208>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toUint216(BigInteger a) {
        final Function function = new Function(FUNC_TOUINT216, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint216>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toUint224(BigInteger a) {
        final Function function = new Function(FUNC_TOUINT224, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint224>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toUint232(BigInteger a) {
        final Function function = new Function(FUNC_TOUINT232, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint232>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toUint24(BigInteger a) {
        final Function function = new Function(FUNC_TOUINT24, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint24>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toUint240(BigInteger a) {
        final Function function = new Function(FUNC_TOUINT240, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint240>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toUint248(BigInteger a) {
        final Function function = new Function(FUNC_TOUINT248, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint248>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toUint256(BigInteger a) {
        final Function function = new Function(FUNC_TOUINT256, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Int256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toUint32(BigInteger a) {
        final Function function = new Function(FUNC_TOUINT32, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint32>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toUint40(BigInteger a) {
        final Function function = new Function(FUNC_TOUINT40, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint40>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toUint48(BigInteger a) {
        final Function function = new Function(FUNC_TOUINT48, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint48>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toUint56(BigInteger a) {
        final Function function = new Function(FUNC_TOUINT56, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint56>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toUint64(BigInteger a) {
        final Function function = new Function(FUNC_TOUINT64, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint64>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toUint72(BigInteger a) {
        final Function function = new Function(FUNC_TOUINT72, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint72>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toUint8(BigInteger a) {
        final Function function = new Function(FUNC_TOUINT8, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toUint80(BigInteger a) {
        final Function function = new Function(FUNC_TOUINT80, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint80>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toUint88(BigInteger a) {
        final Function function = new Function(FUNC_TOUINT88, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint88>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> toUint96(BigInteger a) {
        final Function function = new Function(FUNC_TOUINT96, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint96>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static SafeCastMock load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new SafeCastMock(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static SafeCastMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new SafeCastMock(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static SafeCastMock load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new SafeCastMock(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static SafeCastMock load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new SafeCastMock(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<SafeCastMock> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(SafeCastMock.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<SafeCastMock> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SafeCastMock.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<SafeCastMock> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(SafeCastMock.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<SafeCastMock> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SafeCastMock.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
