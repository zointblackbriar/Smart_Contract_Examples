var HDWalletProvider = require("@truffle/hdwallet-provider");
const MNEMONIC = 'db23db8d5c5f47bc9782ec351144f867';
const MNEMONICGANACHE = 'april cricket flee basket fix near eight repeat enemy cause curious brain';

module.exports = {
  networks: {
    development: {  //ganache
      host: "127.0.0.1",
      port: 8545,
      network_id: "*"
    },
    ropsten: {
      provider: function() {
        return new HDWalletProvider(MNEMONIC, "https://ropsten.infura.io/v3/a63f69b8ada5413e8afc2dd41eef444a", 2);
      },
      network_id: 3,
      //gas: 4000000      //make sure this gas allocation isn't over 4M, which is the max
    }
  }
};
