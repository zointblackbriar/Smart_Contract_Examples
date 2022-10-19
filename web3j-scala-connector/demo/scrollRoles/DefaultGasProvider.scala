package scrollRoles

import demo.Demo.{gasLimit, gasPrice}
import org.web3j.tx.gas.ContractGasProvider
import java.math.BigInteger

class DefaultGasProvider extends ContractGasProvider {
  override def getGasPrice(contractFunc: String): BigInteger = gasPrice.bigInteger
  override def getGasPrice: BigInteger = gasPrice.bigInteger
  override def getGasLimit(contractFunc: String): BigInteger = gasLimit
  override def getGasLimit: BigInteger = gasLimit
}
