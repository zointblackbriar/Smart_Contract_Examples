const OwnableConcept = artifacts.require("OwnableConcept"); 

contract("OwnableConcept", (accounts) => {
    it("should check balance first", async() => {
        const ownableconceptinstance = await OwnableConcept.deployed();
        const balance = await ownableconceptinstance.getBalance.call(accounts[0]);

        assert.equal(balance.valueOf(), 10000, "there is no balance like that");
    }); 

    
})