const ComponentCore = artifacts.require("ComponentCore");
// const Customer = artifacts.require("Customer");
// const CustomerCore = artifacts.require("CustomerCore");
// const CustomerRole = artifacts.require("CustomerRole");
// const Investor = artifacts.require("Investor");
// const MyTeam = artifacts.require("MyTeam");
// const Team = artifacts.require("Team");
// const Migrations = artifacts.require("Migrations");

console.log(ComponentCore);

contract("Customer test functions", accounts => {
  let sampleCustomerObject;
  describe("deployment", () => {
    it("has been deployed successfully", async () => {
      const customer = await ComponentCore.deployed();
      assert(customer, "Customer contract failed to deploy");
    });
    beforeEach("contract constructor has been called", async() => {
      sampleCustomer = await ComponentCore.new();
    })
    it("It should have an address", async() => {
      assert(sampleCustomerObject.address);
    });
  });
});