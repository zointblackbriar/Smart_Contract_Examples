const { ethers, upgrades } = require("hardhat");
const {globalConfigurationRolesProxy} = require("./global-configuration.js");


// const STORAGEVARIABLE = 8;

async function main() {
  const UUPSProxyRole = await ethers.getContractFactory("UUPSProxyRole");

  console.log("Deploying UUPSProxyRole Contract...");

  const objectUUPSProxyRole = await upgrades.deployProxy(UUPSProxyRole, [], {
    initializer: "initialize",
  });
  await objectUUPSProxyRole.deployed();

  console.log("objectUUPSProxyRole deployed to:", objectUUPSProxyRole.address);
  globalConfigurationRolesProxy.PROXYAddressRoleApplication = objectUUPSProxyRole.address;
  console.log("result address: ", globalConfigurationRolesProxy.PROXYAddressRoleApplication);


  //UUPSBorrower
  const UUPSBorrower = await ethers.getContractFactory("UUPSBorrower");
  console.log("Upgrading UUPSBorrowerContract...");
  await upgrades.upgradeProxy(globalConfigurationRolesProxy.PROXYAddressRoleApplication, UUPSBorrower);
  console.log("UUPSBorrower Contract upgraded successfully");

  // //UUPSInvestor
  const UUPSInvestor = await ethers.getContractFactory("UUPSInvestor");
  console.log("Upgrading UUPSInvestorContract...");
  await upgrades.upgradeProxy(globalConfigurationRolesProxy.PROXYAddressRoleApplication, UUPSInvestor);
  console.log("UUPSInvestor Contract upgraded successfully");

}

main().catch((error) => {
  console.error(error); 
  process.exitCode = 1;
});
