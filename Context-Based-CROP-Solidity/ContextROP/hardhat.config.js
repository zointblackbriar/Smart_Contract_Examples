require("@nomiclabs/hardhat-waffle");
require('@nomiclabs/hardhat-truffle5');
require("@nomiclabs/hardhat-ethers");
require("@openzeppelin/hardhat-upgrades");
// require("@nomiclabs/hardhat-etherscan");
require("hardhat-gas-reporter");


// This is a sample Hardhat task. To learn how to create your own go to
// https://hardhat.org/guides/create-task.html
task("accounts", "Prints the list of accounts", async (taskArgs, hre) => {
  const accounts = await hre.ethers.getSigners();

  for (const account of accounts) {
    console.log(account.address);
  }
});

 module.exports = {
  defaultNetwork: "localhost",
  networks: {
    hardhat: {
    },
    rinkeby: {
      url: "https://eth-rinkeby.alchemyapi.io/v2/123abc123abc123abc123abc123abcde",
    },
    localhost: {
      url: "http://localhost:8545"
    }
  },
  solidity: {
    version: "0.8.7",
    settings: {
      optimizer: {
        enabled: true,
        runs: 200
      }
    }
  },
  paths: {
    sources: "./contracts",
    tests: "./mochatests",
    // cache: "./cache",
    // artifacts: "./artifacts"
  },
  mocha: {
    timeout: 40000
  }
};
