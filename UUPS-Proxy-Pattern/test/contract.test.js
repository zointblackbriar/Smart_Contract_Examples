const assert = require("assert");

before("fetch artifacts", async function () {
  this.firstcontract = await hre.ethers.getContractFactory("FirstContract");
  this.storageValue = "8";
  this.firstcontractObject = await hre.upgrades.deployProxy(this.firstcontract, [this.storageValue]);

  this.UpdatedContract = await hre.ethers.getContractFactory("UpdatedContract");
});

it("sets storageValue", async function () {
  assert((await this.firstcontractObject.storageValue()).toString() == this.storageValue);
});

it("eats storageVariable", async function () {
  await this.firstcontractObject.eatSlice();
  assert((await this.firstcontractObject.storageValue()).toString() == this.storageValue - 1);
});

it("refills pizza - upgrade", async function () {
  const updateContractObject = await hre.upgrades.upgradeProxy(this.firstcontractObject, this.UpdatedContract);

  await updateContractObject.refillSlice();

  assert((await updateContractObject.contractVersion()).toString() == 2);
  assert((await updateContractObject.storageValue()).toString() == this.storageValue);
});
