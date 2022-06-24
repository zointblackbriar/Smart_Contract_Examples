

const { assert } = require("chai");
const { web3 } = require("hardhat");

const BoxedFactory = artifacts.require("BoxedFactory"); 

describe("BoxedFactory", () => {
    let accounts; 
    before(async function() {
        accounts = web3.eth.getAccounts()
    }); 

    it("sample test for getCompanyName", async() => {
        const boxedFactoryObject = await BoxedFactory.new(12); 
        try {
            const companyName = "Production Incorporate";
            await boxedFactoryObject.setCompanyName("Production Incorporate");
            assert.equal(companyName, boxedFactoryObject.getCompanyName() );
        } catch(err)
        {
            console.log("Error occurred in the transaction");
        }
    }); 
}); 