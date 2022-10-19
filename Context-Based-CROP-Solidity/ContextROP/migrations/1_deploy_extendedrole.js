const { ethers, upgrades } = require("hardhat");
const {globalConfigurationTestProxy} = require("./global-configuration.js");

const STORAGEVARIABLE = 8;
async function main() {
  const extendedRole = await ethers.getContractFactory("ExtendedRole");

  console.log("Deploying Proxy Test Contract...");

  const objectextendedRole = await upgrades.deployProxy(extendedRole, [STORAGEVARIABLE], {
    initializer: "initialize",
  });
  await objectextendedRole.deployed();

  console.log("objectextendedRole deployed to:", objectextendedRole.address);
  globalConfigurationTestProxy.PROXYAddressTest = objectextendedRole.address;

  console.log("Proxy: ", globalConfigurationTestProxy.PROXYAddressTest);
  const updatedRoleV2Contract = await ethers.getContractFactory("UpdatedRoleV2");
  console.log("Upgrading updatedRoleV2Contract...");
  await upgrades.upgradeProxy(globalConfigurationTestProxy.PROXYAddressTest, updatedRoleV2Contract);
  console.log("updatedRoleV2Contract Contract upgraded successfully");

}

main().catch((error) => {
  console.error(error); 
  process.exitCode = 1;
});
