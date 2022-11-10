const { expect } = require("chai");
const { assert } = require("console");
require('chai').use(require('chai-as-promised')).should();

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
            const actual = await greeter.getGreeting();
            actual.toString().should.equal(expected);
        }); 
    });

    //Inheritance from the Ownable contract
    describe("owner()", () => {
        it("returns the address of the owner", async() => {
            const greeter = await GreeterContract.deployed(); 
            const owner = await greeter.owner(); 
            assert(owner, "the current owner");
        }); 

        it("matches the address for deployed contract", async() => {
            const greeterContract = await GreeterContract.deployed(); 
            const ownerAddress = await greeterContract.owner(); 
            const expectedAddress = accounts[0]; //first account
            console.log("first account: " + expectedAddress);
            ownerAddress.toString().should.equal(expectedAddress);
        });
    });
});

contract("Greeting: Update greeting", (accounts) => {
    describe("setGreeting(string)", () => {
        describe("when message is sent by the owner ", () =>{
            it("checking for the string", async() => {
                const greeter = await GreeterContract.deployed(); 
                const expected = "The owner changed the message"; 

                await greeter.setGreeting(expected); 
                const actual = await greeter.getGreeting();
                actual.toString().should.equal(expected);
            });
        });
    }); 
    describe("when message is sent by another account", () => {
        it("does not set the greeting", async() => {
            const greeterContract = await GreeterContract.deployed(); 
            const expected = await greeterContract.getGreeting();
            try {
                await greeterContract.setGreeting(expected, { from : accounts[1]});
            } catch(err) {
                const errorMessage = "Ownable: caller is not the owner"; 
                // errorMessage.toString().should.notequal("Returned error: execution error: revert");
                expect(errorMessage).to.not.equal("Returned error: execution error: revert");
                return;
            }
            assert(false, "greeting message should not be updated");
        });
    });
});