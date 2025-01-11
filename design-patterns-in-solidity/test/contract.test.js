const ContractItself = artifacts.require("Contract");

contract("Contract", accounts => {
    let contractItself; 

    describe("initialization", () => {
        it("contract creation", async() => {
            contractItself = await ContractItself.new();
            assert(contractItself);
        });
    });
}); 