const { assert } = require("chai");
const { contract, web3 } = require("hardhat");

const SimpleCoin = artifacts.require("SimpleCoin");

describe("SimpleCoin Contract", () => {
    let accounts; 
    before(async function() {
        accounts = web3.eth.getAccounts();
    }); 

    it("transfer action is completed or not", async() => {
        const simpleCoinContractObject = await SimpleCoin.new(12);
        try {
            assert.isTrue(simpleCoinContractObject.transfer(accounts[0], 12));
        } catch(err) 
        {
            const errorMessage = "Problem with the transaction"; 
            assert.equal(err.reason, errorMessage, "SimpleCoin contract failed");
            return;
        }
    });
    
});