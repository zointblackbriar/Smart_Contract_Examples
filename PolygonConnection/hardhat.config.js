require("@nomicfoundation/hardhat-toolbox");
require('dotenv').config();
require("@nomiclabs/hardhat-ethers");
require("@nomiclabs/hardhat-etherscan");
require('dotenv').config()
// console.log(process.env) // remove this after you've confirmed it is working
console.log(process.env.PRIVATE_KEY)

/** @type import('hardhat/config').HardhatUserConfig */
module.exports = {
  defaultNetwork: "matic",
  networks: {
    hardhat: {
    },
    matic: {
      url: "https://rpc-mumbai.maticvigil.com",
      accounts: [process.env.PRIVATE_KEY]
    },
    mumbai: {
      url: "https://rpc-mumbai.maticvigil.com/v1/c351672acc79d35048bfa6264113dfdacf66e950",
      accounts: [process.env.PRIVATE_KEY]
    }
  },
  etherscan: {
    apiKey: process.env.POLYGONSCAN_API_KEY
  },
  solidity: {
    version: "0.8.9",
    settings: {
      optimizer: {
        enabled: true,
        runs: 200
      }
    }
  },
}

