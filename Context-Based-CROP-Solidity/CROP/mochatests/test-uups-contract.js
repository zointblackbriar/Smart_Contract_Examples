const assert = require("assert"); 

console.log(assert);

before('fetch artifacts', async function() {
    this.updatedRoleV1 = await hre.ethers.getContractFactory("UpdatedRole");
    this.sampleVariable = "10"; 
    this.proxyContract = await hre.upgrades.deployProxy(this.updatedRoleV1, [this.sampleVariable]);
    this.updatedRoleV2 = await hre.ethers.getContractFactory("UpdatedRoleV2");
});
