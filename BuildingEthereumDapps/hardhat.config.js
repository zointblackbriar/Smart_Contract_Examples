require("@nomiclabs/hardhat-waffle");
require('@nomiclabs/hardhat-truffle5');

// This is a sample Hardhat task. To learn how to create your own go to
// https://hardhat.org/guides/create-task.html
task("accounts", "Prints the list of accounts", async (taskArgs, hre) => {
  const accounts = await hre.ethers.getSigners();

  for (const account of accounts) {
    console.log(account.address);
  }
});

// You need to export an object to set up your config
// Go to https://hardhat.org/config/ to learn more

/**
 * @type import('hardhat/config').HardhatUserConfig
 */
module.exports = {
  solidity: {
    version: "0.8.7", 
    settings: {
      optimizer: {
        enabled: true,
        runs : 200
      }
    }
  },

  networks:  {
    hardhat: {
      forking: {
        url: "https://eth-ropsten.alchemyapi.io/v2/nmDHfxR_yoF00D3ZwH_Y6bFc5Jate7gF"
      }
    },
    localhost: {
      url: "http://127.0.0.1:8545"
    },
    hardhat: {
      
    }
  }
};
