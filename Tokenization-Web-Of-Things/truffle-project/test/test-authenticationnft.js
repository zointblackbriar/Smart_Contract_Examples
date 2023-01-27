//First of all, run the following command
const { assert } = require("console");

const AuthenticationNFT = artifacts.require("AuthenticationNFT"); 
// console.log(AuthenticationNFT);

contract("AuthenticationNFT", (accounts) => {
    it("should deploy in a correct way", async() => {
        const authenticationNFTInstance = await AuthenticationNFT.deployed();
        const balance = authenticationNFTInstance.getBalance.call(accounts[0]);
        assert.equal(balance.valueOf(), 10000, "10000 was not in the first account");  
    });
});