const GreeterContract = artifacts.require("Greeter"); 

contract("Greeter", () => {
    it("has been deployed successfully", async () => {
        const greeter = await GreeterContract.deployed();
        assert(greeter, "contract was not deployed");
    });
}); 

describe("greet()", () => {
    it("returns a test string", async() => {
        const greeter = await GreeterContract.deployed();
        const expected =  "Test String!"; 
        const actual = await greeter.greet();
        assert.equal(actual, expected, "Return value is matched");
    });
});

//Dynamic contract
contract("Greeter: update greeting", () => {
    describe("setGreeting(string)", () => {
        it("sets greeting to passed in string", async() => {
            const greeter = await GreeterContract.deployed()
            const expected = "Hi there!";
            
            await greeter.setGreeting(expected); 
            const actual = await greeter.greet();
            assert.equal(actual, expected, "greeting was not updated");
        });
    });
});

describe("ownerOfContract()", () => {
    it("returns the address of the owner", async() => {
        const greeter = await GreeterContract.deployed();
        const owner = await greeter.ownerOfContract();
        assert(owner, "the current owner must be");
    });
});
