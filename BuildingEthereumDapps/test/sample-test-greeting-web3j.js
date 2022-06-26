const { assert } = require("chai");
const { contract, web3 } = require("hardhat");

const GreeterContract = artifacts.require("Greeter"); 

contract("Greeter", (accounts) => {
    it("Should return a new greeting instance once it is changed", async function() {
        const greeterObject = await GreeterContract.new("Hello Contract!"); 
        assert.equal(await greeterObject.getGreeting(), "Hello Contract!");
        await greeterObject.setGreeting("el mundo"); 
        assert.equal(await greeterObject.getGreeting(), "el mundo");
    });
    it("has been returned true value", async() => {
        const sampleContract = await GreeterContract.new("Hello World"); 
        const expected = "Hello World"; 
        const actual = await sampleContract.getGreeting();
        assert.equal(actual, expected, "greeted with Hello World");
    });
    // it("contract was deployed", asyconst { assert } = require("chai");
const { contract, web3 } = require("hardhat");

const GreeterContract = artifacts.require("Greeter"); 

contract("Greeter", (accounts) => {
    it("Should return a new greeting instance once it is changed", async function() {
        const greeterObject = await GreeterContract.new("Hello Contract!"); 
        assert.equal(await greeterObject.getGreeting(), "Hello Contract!");
        await greeterObject.setGreeting("el mundo"); 
        assert.equal(await greeterObject.getGreeting(), "el mundo");
    });
    it("has been returned true value", async() => {
        const sampleContract = await GreeterContract.new("Hello World"); 
        const expected = "Hello World"; 
        const actual = await sampleContract.getGreeting();
        assert.equal(actual, expected, "greeted with Hello World");
    });
    // it("contract was deployed", async() => {
    //     const sampleDeployment = await GreeterContract.deployed(); 
    //     console.log(sampleDeployment);
    //     assert(sampleDeployment, true);
    // })
});

contract("Update Greeting", (accounts) => {
    describe("setGreeting(string)", () => {
        it("setting something in string to be passed", async() => {
            const greeterObject = await GreeterContract.new("Hi, there");
            const expected = "Hi, there";
            await greeterObject.setGreeting(expected); 
            const actual = await greeterObject.getGreeting(); 
            assert.equal(expected, actual, "strings are equal");
    
        });
    });
});

//Vanilla Mocha Test. Increased compatibility with tool has been represented
describe("Greeter contract", function()  {
    let accounts; 

    before(async function() {
        accounts = await web3.eth.getAccounts(); 

    });

    describe("Deployment", function() {
        it("Should deploy with the right greeting", async function() {
            const greeterObject = await GreeterContract.new("Sample message"); 
            assert.equal(await greeterObject.getGreeting(), "Sample message"); 
            const greeterSecondObject = await GreeterContract.new("Sample message 2"); 
            assert.equal(await greeterSecondObject.getGreeting(), "Sample message 2");
        });
    });
});

describe("getOwner()", () => {
    let accountSamples; 
    before(async function() {
        accountSamples = await web3.eth.getAccounts();
    });
    it("returns the address of the owner", async() => {
        const greeterObject = await GreeterContract.new("sample string"); 
        const ownerAddress = await greeterObject.getOwner(); 
        console.log("ownerAddress: " + ownerAddress);
        assert(ownerAddress, "the current owner");
    });
    it("matches the address that originally deployed the contract ", async() => {
        const greeterObject = await GreeterContract.new("sample message"); 
        const ownerAddress = await greeterObject.getOwner(); 
        const expectedAddress = accountSamples[0]; 

        assert.equal(ownerAddress, expectedAddress, "adress were matched in contract call.");
    });
})

});

contract("Update Greeting", (accounts) => {
    describe("setGreeting(string)", () => {
        it("setting something in string to be passed", async() => {
            const greeterObject = await GreeterContract.new("Hi, there");
            const expected = "Hi, there";
            await greeterObject.setGreeting(expected); 
            const actual = await greeterObject.getGreeting(); 
            assert.equal(expected, actual, "strings are equal");
    
        });
    });
});

//Vanilla Mocha Test. Increased compatibility with tool has been represented
describe("Greeter contract", function()  {
    let accounts; 

    before(async function() {
        accounts = await web3.eth.getAccounts(); 

    });

    describe("Deployment", function() {
        it("Should deploy with the right greeting", async function() {
            const greeterObject = await GreeterContract.new("Sample message"); 
            assert.equal(await greeterObject.getGreeting(), "Sample message"); 
            const greeterSecondObject = await GreeterContract.new("Sample message 2"); 
            assert.equal(await greeterSecondObject.getGreeting(), "Sample message 2");
        });
    });
});

describe("getOwner()", () => {
    let accountSamples; 
    before(async function() {
        accountSamples = await web3.eth.getAccounts();
    });
    it("returns the address of the owner", async() => {
        const greeterObject = await GreeterContract.new("sample string"); 
        const ownerAddress = await greeterObject.getOwner(); 
        console.log("ownerAddress: " + ownerAddress);
        assert(ownerAddress, "the current owner");
    });
    it("matches the address that originally deployed the contract ", async() => {
        const greeterObject = await GreeterContract.new("sample message"); 
        const ownerAddress = await greeterObject.getOwner(); 
        const expectedAddress = accountSamples[0]; 

        assert.equal(ownerAddress, expectedAddress, "adress were matched in contract call.");
    });
});

describe("when message is sent by another account", () => {
    let accounts;
    before(async function() {
        accounts = web3.eth.getAccounts();
    });
    it("does not set the greeting", async() => {
        const greeterObject = await GreeterContract.new("greeting message"); 
        // const expected = await greeterObject.getGreeting();

        try {
            await greeterObject.setGreeting("Not the owner", {from: accounts[0]}); 
            //console.log(greeterObject.getOwner()); 
            console.log(accounts[1]);
            assert.notEqual(greeterObject.getOwner(), accounts[1]);
            // assert(false, "greeting should not update because of the ownership principle");
        } catch(err) {
            const errorMessage = "Ownable: caller is not the owner";
            assert.equal(err.reason, errorMessage, "greeting should not update");
            return;
        }
    });
});
