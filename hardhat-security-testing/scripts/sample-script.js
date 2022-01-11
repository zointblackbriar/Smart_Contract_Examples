// We require the Hardhat Runtime Environment explicitly here. This is optional
// but useful for running the script in a standalone fashion through `node <script>`.
//
// When running the script with `npx hardhat run <script>` you'll find the Hardhat
// Runtime Environment's members available in the global scope.
const hre = require("hardhat");
const config = require("../config");

async function main() {
  // Hardhat always runs the compile task when running scripts with its command
  // line interface.
  //
  // If this script is run directly using `node` you may want to call compile
  // manually to make sure everything is compiled
  // await hre.run('compile');

  await hre.network.provider.request({
    method: "hardhat_reset", 
    params: [{
      forking: {
        jsonRpcUrl: config.web.apikey,
        blockNumber: 12350000 
      }
    }]  
  })

  // We get the contract to deploy
  const Greeter = await hre.ethers.getContractFactory("Greeter");
  const greeter = await Greeter.deploy("Hello, Hardhat!");

  await greeter.deployed();
  //Greeter deployed to: 0x09635F643e140090A9A8Dcd712eD6285858ceBef
  console.log("Greeter deployed to:", greeter.address);


  //We will use the greeter contract
  // const WETH = await hre.enters.getContractAt("Greeter", "0xC02aaA39b223FE8D0A0e5C4F27eAD9083C756Cc2"); 
  // //Deploy the PoC contract
  // const Exploit = await hre.enters.getContractFactory("Explot")
}

// We recommend this pattern to be able to use async/await everywhere
// and properly handle errors.
main()
  .then(() => process.exit(0))
  .catch((error) => {
    console.error(error);
    process.exit(1);
  });
