const {ethers, upgrades} = require("hardhat"); 

const PROXY_ADDRESS = "0xc82752F9F4077C067a8c88411b1dED9F702C6CAf";

async function main() {
    const updatedContractV2 = await ethers.getContractFactory("UpdatedRoleV2"); 
    console.log("Upgrading the contract..."); 
    await upgrades.upgradeProxy(PROXY_ADDRESS, updatedContractV2); 
    console.log("Contract upgraded successfully"); 
}

main().catch((error) => {
    console.error(error); 
    process.exitCode=1
})