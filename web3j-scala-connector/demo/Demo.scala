package demo

import java.math.BigInteger
import com.micronautics.web3j.{Cmd, Ether, EthereumSynchronous, Web3JScala}
import Cmd.{isMac, isWindows}
import org.web3j.crypto.{Credentials, WalletUtils}
import org.web3j.protocol.Web3j
import org.web3j.protocol.ipc.{UnixIpcService, WindowsIpcService}

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext, Promise}
import org.web3j.protocol.core.DefaultBlockParameterName._

object Demo {
  val gasPrice: Ether = Ether(41000000)
  val gasLimit: BigInteger = BigInt(5000000).bigInteger

  val walletDir: String = Cmd.home(
    if (isWindows) s"${ sys.props("user.home") }\\AppData\\Roaming\\Ethereum\\"
    else if (isMac) "~/Library/Ethereum/rinkeby/"
    else "~/.ethereum/rinkeby/"
  )

  val walletFile: String = walletDir + "keystore/UTC--2022-02-16T20-33-01.238251000Z--803017d9fc99d965c1d8adc4717ba1d97cb3a103"

  val credentials: Credentials = WalletUtils.loadCredentials("password", walletFile)
}

class Demo(implicit ec: ExecutionContext) {
  // Setup for running command lines from Scala
  val cmd = new Cmd()

  // Instantiate an instance of the underlying Web3J library:
  val web3j: Web3j = Web3JScala.fromHttp()  // defaults to http://localhost:8545/
  val web3jScala: Web3JScala = new Web3JScala(web3j)

  // Example of a synchronous request:
  val web3ClientVersion1: String = web3jScala.sync.versionWeb3J
  println(s"Web3J version = $web3ClientVersion1")

  // Contrived example of an asynchronous request, which provides no benefit over using a synchronous request:
  val web3ClientVersion2: String = Await.result(web3jScala.async.versionWeb3J, Duration.Inf)
  println(s"Web3J version = $web3ClientVersion2")

  // Better example of an asynchronous request:
  private val promise: Promise[String] = Promise[String]
  web3jScala.async.versionWeb3J.foreach { web3ClientVersion =>
    println(s"Web3J version = $web3ClientVersion")
    promise.complete(scala.util.Success("Done"))
  }
  Await.ready(promise.future, Duration.Inf) // pause while the async request completes

  val eSync: EthereumSynchronous = web3jScala.sync
  eSync.accounts match {
    case Nil => println("No accounts found.")
    case accounts =>
      accounts.foreach {
        account => println(s"The balance of $account is ${ eSync.balance(account, LATEST) } Wei")
      }
  }

  val ethereumDir: String = Cmd.home(
    if (isWindows) "~/AppData/Roaming/Ethereum"
    else if (isMac) "~/Library/Ethereum/"
    else "~/.ethereum/"
  ) + "rinkeby/" // todo discover the ethereum name at runtime

  // Web3J supports fast inter-process communication (IPC) via file sockets to clients running on the same host as Web3J.
  // To connect simply use the relevant IpcService implementation instead of HttpService when you create your service:
  val web3J3: Web3j = try {
    if (isWindows)
      Web3j.build(new WindowsIpcService(ethereumDir))
    else
      Web3j.build(new UnixIpcService(ethereumDir + "geth.ipc"))
  } catch {
    case e: Throwable =>
      System.err.println(e.getMessage)
      web3j
  }
}
