const { ethers, upgrades } = require("hardhat");

const PROXY = "0xCf7Ed3AccA5a467e9e704C703E8D87F634fB0Fc9"; //This address should be 
//changed for each deployment

async function main() {
  const UpdatedContract = await ethers.getContractFactory("UpdatedContract");
  console.log("Upgrading FirstContract...");
  await upgrades.upgradeProxy(PROXY, UpdatedContract);
  console.log("FirstContract upgraded successfully");
}

main().catch((error) => {
  console.error(error); 
  process.exitCode = 1;
});
