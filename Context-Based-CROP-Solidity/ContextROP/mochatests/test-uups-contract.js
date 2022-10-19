const { throws } = require("assert");
const assert = require("assert"); 
const { ethers } = require("hardhat");
const { isTypedArray } = require("util/types");
// const { isTypedArray } = require("util/types");

// console.log(assert);

this.borrowAmount = "0"; 
let updatedRoleObject1; 
let updatedRoleObject2;
before('fetch artifacts', async function() {
    const [owner] = await ethers.getSigners();
    console.log(owner);
    this.updatedRoleV1 = await hre.ethers.getContractFactory("UUPSProxyRole");
    
    // this.proxyContract = await hre.upgrades.deployProxy(this.updatedRoleV1, [this.sampleVariable]);
    this.proxyContract = await hre.upgrades.deployProxy(this.updatedRoleV1, []);
    this.updatedRole1 = await hre.ethers.getContractFactory("UUPSBorrower");
    this.updatedRole2 = await hre.ethers.getContractFactory("UUPSInvestor");
    updatedRoleObject1 = await this.updatedRole1.deploy();
    updatedRoleObject2 = await this.updatedRole2.deploy();

    // const ownerBalance = await updatedRoleObject1.balanceOf(owner.address);
    // console.log("deployment value of updatedRoleObject2", updatedRoleObject2);
});

it("null testing", async function() {
    assert(12, 12);
});

it("checking the variable is equal to state variable", async function () {
    // const updatedRoleObject1 = await this.updatedRole1.deploy();
    console.log("is this a value?: ", updatedRoleObject1);
    // console.log("is this a value?: ", updatedRoleObject1.repay("10"));

    assert((await this.updatedRole1.functions.borrow("12")).toString() == this.borrowAmount);
    assert((await this.updatedRole1.functions.repay("10")).toString() == "2");

});
  
// it("change state variable", async function () {
//   await this.updatedRoleV1.changeStateVariable();
//   assert((await this.updatedRoleV1.sampleVariable()).toString() == this.sampleVariable - 1);
// });
  