const ContractFactory = artifacts.require("ContractFactory");

contract("ContractFactory", () => {
    it("...should deploy and successfully call reference", async() => {
        const contractFactoryInstance = await ContractFactory.new(); 
        const gasEstimate = await contractFactoryInstance.createInstance.estimateGas();
        //Gas estimation has been made here
        console.log("gasEstimate: ", gasEstimate);
        const tx = await contractFactoryInstance.createInstance({
            gas: gasEstimate
        });
        assert(tx);
    });
});