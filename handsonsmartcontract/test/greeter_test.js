const GreeterContract = artifacts.require("Greeter")

contract("Greeter", (accounts) => {
    describe("deployment", () => {
        it("it has been deployed successfully", async() => {
            const greeter = await GreeterContract.deployed(); 
            assert (greeter, "contract has been deployed");
        });
    });

    describe("greet()", () => {
        it("returns Sample Message", async() => {
            const greeter = await GreeterContract.deployed();
            const expected = "Sample Message"; 
            const actual = await greeter.greet();
            assert.equal(actual, expected, "message has been confirmed");
        }); 
    });

    //Inheritance from the Ownable contract
    describe("owner()", () => {
        it("returns the address of the owner", async() => {
            const greeter = await GreeterContract.deployed(); 
            const owner = await greeter.owner(); 
            assert(owner, "the current owner");
        })
    })
});

