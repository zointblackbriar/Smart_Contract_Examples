const assert = requrie("assert"); 

console.log(assert);

before('fetch artifacts', async function() {
    await hre.ethers.getContractFactory("UpdateRole");
});
