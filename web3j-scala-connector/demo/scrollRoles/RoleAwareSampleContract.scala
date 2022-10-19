package scrollRoles

import com.micronautics.solidity.SampleContract
import demo.Demo.credentials
import org.web3j.protocol.Web3j
import org.web3j.protocol.core.methods.response.TransactionReceipt
import org.web3j.protocol.core.{RemoteCall, RemoteFunctionCall}
import org.web3j.tx.Contract.deployRemoteCall
import org.web3j.tx.gas.ContractGasProvider
import org.web3j.tx.{RawTransactionManager, TransactionManager, Transfer}
import org.web3j.utils.Convert.Unit.ETHER
import scrollRoles.RoleAwareSampleContract.{DONATION_ADDRESS, DONATION_AMOUNT_ETHER}

object RoleAwareSampleContract {

  val DONATION_ADDRESS = "0x7299192CD862c9c5345cC47a2Ef24807436009b0"
  val DONATION_AMOUNT_ETHER: java.math.BigDecimal = BigDecimal.valueOf(0.0123).bigDecimal

  def deploy(web3j: Web3j): RemoteCall[RoleAwareSampleContract] = {
    val tm = new RawTransactionManager(web3j, credentials)
    deployRemoteCall(classOf[RoleAwareSampleContract], web3j, tm, new DefaultGasProvider(), SampleContract.BINARY, "")
  }
}

class RoleAwareSampleContract(
  contractAddress: String,
  web3j: Web3j,
  transactionManager: TransactionManager,
  contractGasProvider: ContractGasProvider
) extends SampleContract(
  contractAddress,
  web3j,
  transactionManager,
  contractGasProvider
) {

  // contract function
  override def kill(): RemoteFunctionCall[TransactionReceipt] = {
    new UserCompartment {
      assert((+this).isPlaying[OwnerRole], "Error: Owner role required to perform this action.")
    }
    super.kill()
  }

  // scala-wrapper-only function
  def donate(): TransactionReceipt = {
    new UserCompartment {
      assert((+this).isPlaying[OwnerRole], "Error: Owner role required to perform this action.")
    }
    Transfer.sendFunds(web3j, credentials, DONATION_ADDRESS, DONATION_AMOUNT_ETHER, ETHER).send
  }
}