1. install geth: `brew tap ethereum/ethereum && brew install ethereum`
2. clone the repo: `git clone https://github.com/arblitroshani/web3j-scala.git`
3. update macos to latest and Xcode to latest (current: 13.2.1)
4. install boost 1.6
    - since solidity v0.4.x does not work with boost 1.7 (latest on homebrew), we need to manually install boost 1.6
    - we can't install v1.6 through homebrew, because it's an unsupported version -> use an external tap.
    - `brew tap bitshares/homebrew-boost https://github.com/bitshares/homebrew-boost.git`
    - `brew style --fix /usr/local/Homebrew/Library/Taps/bitshares/homebrew-boost/Formula/`
    - verify installation using `brew search boost@1.69`
    - install boost@1.69: `brew install boost@1.69`
5. 
    install solidity@4: 
    - change dependency of solidity@4.rb: 
        - open `/usr/local/Homebrew/Library/Taps/ethereum/homebrew-ethereum/solidity@4.rb`
        - change `depends_on "boost" => "1.60"` to `depends_on "boost@1.69"`
    - install solidity@4: `brew install solidity@4 -v`
    - Note: if installation fails because of cmake, install solidity from source (instructions below
    - verify installation: `solc --version`
6.  Alternative approach (easier way)
    - install the following tool:
        - `pip3 install solc-select`
    - check your solidity version with the following command: 
        - `solc --version`
    - change the version of solc compiler as below: 
        - `solc-select install 0.4.24`

7. start geth: `cd web3j-scala && bin/runGeth rinkeby`
8. create new ethereum account on rinkeby
    - `geth attach http://localhost:8545`
    - in the geth shell, run `personal.newAccount("password")`
    - unlock your new account `personal.unlockAccount("your_new_address_here", "password", 604800)`
    - check balance `web3.fromWei(eth.getBalance(eth.coinbase), "ether")`. It should initially be 0.
    - check your wallet address by running `personal.listWallets`
    - topup with 0.1 ETH by putting your wallet address in `https://rinkebyfaucet.com/`
    - recheck your new wallet balance
    - optionally, check balance and transactions in `https://rinkeby.etherscan.io/address/{wallet-address-here}`
    - replace your keystore file path in Demo.scala, in the value of `walletFile`.
9. in a new tab, run `sbt "test:runMain demo.CreateSmartContracts"`
10. run the demo program: `sbt "test:runMain demo.Main"` or just one of the parts `bin/demo DemoTransaction`.
----------------

### Installing solidity from source. ([src](https://docs.soliditylang.org/en/v0.4.26/installing-solidity.html))
Steps:
1. `git clone --recursive https://github.com/ethereum/solidity.git && cd solidity`
2. `git checkout v0.4.26`
3. `git submodule update --init --recursive`
4. `./scripts/install_deps.sh`
5. open `cmake/EthCompilerSettings.cmake` and remove line `add_compile_options(-Werror)`
6. open `CMakeLists.txt` and add after first line:
```shell
SET(BOOST_ROOT "/usr/local/Cellar/boost@1.60")
SET(BOOST_INCLUDEDIR "/usr/local/Cellar/boost@1.60/1.60.0/include")
SET(BOOST_LIBRARYDIR "/usr/local/Cellar/boost@1.60/1.60.0/lib")
set (Boost_NO_BOOST_CMAKE ON)
include_directories(${Boost_INCLUDE_DIRS})
link_directories(${Boost_LIBRARY_DIRS})
```
7. `mkdir build && cd build && cmake .. && make`
----------------

Related issues and tutorials:
1. exact issue described here: https://github.com/ethereum/solidity/issues/7529
    - proposed solution is not working.
2. https://github.com/chao-peng/SIF/issues/6#issuecomment-850451592
3. https://github.com/ethereum/solidity/issues/5139