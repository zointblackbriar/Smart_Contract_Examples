const {assert} = require("chai"); 
const truffleAssert = require('truffle-assertions');
// const { isTypedArray } = require("util/types");
const SampleDelegateCall = artifacts.require("SampleDelegateCall");
const CallerContract = artifacts.require("CallerContract");

contract("callerObject should be integrated", (accounts) => {
    beforeEach(async() =>{
        sampleAddress = await SampleDelegateCall.deployed();
        callerObject = await CallerContract.deployed();

        // sampleObject = await SampleDelegateCall.new();
    });
    
    it("it should return accounts in the ganache-cli", async() => {
        // console.log(accounts); 
        assert(accounts);
    });
    it("it should be deployed for callerObject", async() => {
        assert(CallerContract); 
    }); 
    it("it should be deployed for SampleDelegateCall", async() => {
        assert(SampleDelegateCall);
    });
    it("call testDelegateCall function", function() {
        // CallerContract.deployed().then(function() {
        // });
        // console.log(sampleAddress);
        // console.log(sampleObject);
        // assert.isTrue(callerObject.testDelegateCall("testing library", sampleAddress));
        let txResult = callerObject.testDelegateCall("testing library", sampleAddress); 
        truffleAssert.eventEmitted(txResult, 'Error', (ev) => {
            return ev.error == "Function must be invoked";
        });
    });
});



