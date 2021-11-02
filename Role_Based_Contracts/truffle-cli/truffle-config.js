var HDWalletProvider = require("@truffle/hdwallet-provider");
const MNEMONIC = 'db23db8d5c5f47bc9782ec351144f867';
const GANACHE_MNEMONIC = 'blast rally own enact autumn cloud trial expect tool portion fever gap';

module.exports = {
  networks: {
    development: {
      host: "127.0.0.1",
      port: 7545,
      network_id: "*",
      provider: function() {
        return new HDWalletProvider(GANACHE_MNEMONIC, "http://127.0.0.1:7545");
      },
    },
    ropsten: {
      provider: function() {
        return new HDWalletProvider(MNEMONIC, "https://ropsten.infura.io/v3/a63f69b8ada5413e8afc2dd41eef444a")
      },
      network_id: "3",
      gas: 4000000,      //make sure this gas allocation isn't over 4M, which is the max
      from: "172.16.20.21"
      //172.16.20.21
    },
    hyperledger_fabric: {
      host: "127.0.0.1",
      port: 5000, 
      network_id: "*",
      type: "fabric-evm"
    }
  },

  // Configure your compilers
  compilers: {
    solc: {
      version: "0.5.2",    // Fetch exact version from solc-bin (default: truffle's version)
      docker: false,        // Use "0.5.1" you've installed locally with docker (default: false)
      settings: {          // See the solidity docs for advice about optimization and evmVersion
       optimizer: {
         enabled: false,
         runs: 200
       },
       evmVersion: "byzantium"
      }
    }
  }
  

};
