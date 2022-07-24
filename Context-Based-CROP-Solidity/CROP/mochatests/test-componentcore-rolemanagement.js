
const { assert } = require("assert");
const {expect} = require("chai");

const ComponentCoreContract = artifacts.require("ComponentCore");
const InterfaceLibrary = artifacts.require("InterfaceIds");
// const TestComponentCore = artifacts.require("build/contracts/soliditytests/TestComponentCore_ERC165");
const TeamContract = artifacts.require("Team"); 

beforeEach(async() => {
  ComponentCoreInstance = await ComponentCoreContract.deployed();
  InterfaceIds = await InterfaceLibrary.deployed();
  // TestComponentInstance = await TestComponentCore.deployed(); 
}); 
   

contract("ComponentCore test functions", (accounts) => {
  it("it should return accounts in the ganache-cli", async () => {
    console.log(accounts);
    assert(accounts);
  });
  it("should return the param of deployable", async() => {
    assert(ComponentCoreInstance);
  });
  it("should return interface ID", async() => {
    const result = await ComponentCoreContract.testAddRoleDoesNotAddANewRoleIfItHasAZeroAddress(); 
    truffleAssert.eventEmitted(result, 'Logging');
  });
  it("interface deployment  test", async() => {
    //console.log("InterfaceIds.COMPONENT_ID: " + InterfaceIds.COMPONENT_ID); 
    assert(InterfaceIds);
  }); 
});