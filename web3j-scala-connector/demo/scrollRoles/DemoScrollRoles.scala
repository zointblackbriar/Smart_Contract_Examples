package scrollRoles

import demo.Demo
import org.web3j.protocol.core.RemoteCall
import com.micronautics.web3j.Web3JScala.{solc, wrapAbi}

object RunDemoScrollRoles extends App {
  import scala.concurrent.ExecutionContext.Implicits.global
  new DemoScrollRoles(new Demo)
}

class DemoScrollRoles(demo: Demo) {

  // Compile the smart contract
  solc("src/test/resources/sample_contract.sol")

  // Generate the wrapper code from the compiled smart contract using web3j’s command-line tools
  wrapAbi("sample_contract")

  try {
    // deploy the smart contract
    val deploySampleContractCall: RemoteCall[RoleAwareSampleContract] = RoleAwareSampleContract.deploy(demo.web3j)

    // retrieve the smart contract object, now containing the deploy address
    val sampleContract: RoleAwareSampleContract = deploySampleContractCall.send

    val ownAddress: String = sampleContract.getContractOwnAddress.send()
    println(s"sampleContract.getContractOwnAddress = $ownAddress")

    new UserCompartment {
      // first attempt: should not succeed
      try {
        sampleContract.donate()
      } catch {
        case e: Throwable =>
          System.err.println(e.getMessage)
      }

      sampleContract play new OwnerRole

      // second attempt: should succeed
      try {
        sampleContract.donate()
      } catch {
        case e: Throwable =>
          System.err.println(e.getMessage)
      }
    }
  } catch {
    case e: Throwable =>
      System.err.println(e.getMessage)
  }
}
