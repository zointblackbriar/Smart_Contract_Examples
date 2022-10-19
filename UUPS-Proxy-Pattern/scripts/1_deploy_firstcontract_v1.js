const { ethers, upgrades } = require("hardhat");

const STORAGEVARIABLE = 8;
async function main() {
  const firstContract = await ethers.getContractFactory("FirstContract");

  console.log("Deploying FirstContract...");

  const objectFirstContract = await upgrades.deployProxy(firstContract, [STORAGEVARIABLE], {
    initializer: "initialize",
  });
  await objectFirstContract.deployed();

  console.log("objectFirstContract deployed to:", objectFirstContract.address);
}

main().catch((error) => {
  console.error(error); 
  process.exitCode = 1;
});
