const assert = require('assert'); 
// const { bytecodeToBytecodeRegex } = require('eth-gas-reporter/lib/utils');
// const ganache = require('ganache-cli'); 
const Web3 = require('web3'); 
const web3 = new Web3(ganache.provider()); //provider interceptor
const {interface, bytecode} = require('../compile');

//Mocha functions

//it --> Run a test and make an assertion

//describe --> Groups together 'it' functions

//beforeEach --> Execute some general setup code.
let car;
class Car {
    drive() {
        return 'drive'; 
    }

    stop() {
        return 'stop';
    }
}

describe('Car testing', async() => {
    beforeEach('Installation', async() => {
        car = new Car();
    });
    it("Car drive function testing", async() => {
        assert.equal(car.drive(), 'drive'); 
    });

    it("Car stop() testing", async() => {
        assert.equal(car.stop(), 'stop');
    });
});


// describe('Real contract functions', async() => {
// });


describe('Inbox', async() => {
    beforeEach(async() => {
        // web3.eth.getAccounts().then(fetchedAccounts => { //promised way
        //     console.log(fetchedAccounts);
        // });
        accounts = await web3.eth.getAccounts(); 
        console.log(accounts);

        inbox = await new web3.eth.Contract(JSON.parse(interface)) //teaches web3 about what methods an Inbox contract has
            .deploy({data: bytecode, arguments: ['Hi, there']}) //Tells web3 that we want to deploy a new copy of this contract.
            .send({from: accounts[0], gas: '1000000'}); //Instructs web3 to send out a transaction that creates this contract
    });

    it('deploys a contract', () => {
        console.log("deployment of the contract has been processed");
        console.log(inbox);
    })
});

