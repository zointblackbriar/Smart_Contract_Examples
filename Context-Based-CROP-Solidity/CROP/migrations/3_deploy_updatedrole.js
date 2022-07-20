const {ethers, upgrades} = require("hardhat"); 

STORAGEVARIABLE = 10; 
async function main() {
    //Deploying 
    const box = await ethers.getContractFactory("UpdatedRole"); 

    console.log("Deploying updated role");
    const instance = await upgrades.deployProxy(box, [STORAGEVARIABLE]); 
    await instance.deployed();

    console.log("UpdatedRole contract is deployed to: " + instance.address); 
}

main().catch((error) => {
    console.error(error); 
    process.exitCode = 1; 
});