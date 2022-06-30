

const { expect } = require("chai");
const { web3 } = require("hardhat");

const CellConfigurator = artifacts.require("CellConfigurator"); 
describe("CellConfigurator", async () => {
    let accounts; 
    beforeEach(async () => {
        accounts = web3.eth.getAccounts()
        configuratorObject = await CellConfigurator.new(12);
    }); 

    it("sample test for getCompanyName", async() => {
         
        // try {
        //     const companyName = "Production Incorporate";
        //     await boxedFactoryObject.setCompanyName("Production Incorporate");
        //     assert.equal(companyName, boxedFactoryObject.getCompanyName() );
        // } catch(err)
        // {
        //     console.log("Error occurred in the transaction");
        // }
        await configuratorObject.setCompanyName("Production Incorporate");
        expect.expect(await configuratorObject.companyName()).to.equal("Production Incorporate");

    }); 

    it("getting ID of the company", async() => {
        // try {
        //     const companyID = "21"; 
        //     await boxedFactoryObject.setCompanyId("21"); 
        //     console.log(boxedFactoryObject.getCompanyId());
        //     assert.equal(companyID, boxedFactoryObject.getCompanyId());
        // } catch(err)
        // {
        //     console.log("Error occurred in the function of getID"); 
        // }
        await configuratorObject.setCompanyId("21"); 
        console.log(configuratorObject.companyId());
        assert.equal(await configuratorObject.companyId()).to.equal("21");
    });
});
