var assert = require('assert'); 
const { isTypedArray } = require('util/types');
const fs = require('fs'); 
const solc = require('solc'); 
const Web3 = require('web3');
const web3 = new Web3(new Web3.providers.HttpProvider("http://localhost:8545"));

// Only works with solidity version 0.4.25, not higher version
// const source = fs.readFileSync('/media/zoint/D0F4-36FA/AllFiles/Projeler/zointblackbriar/Smart_Contract_Examples/BuildingEthereumDapps/contracts/SimpleCoin.sol', 'utf-8');
// const compiledContract = solc.compile(source, 1); 
// console.log("compiledContract: " + JSON.stringify(compiledContract));
// const abi = compiledContract.contracts[':SimpleCoin']; 
// console.log("abi: " + abi);

//Instead
const contract = JSON.parse(fs.readFileSync("./client/src/contracts/SimpleCoin.json", "utf-8")); 
console.log(JSON.stringify(contract.abi));
// console.log(JSON.stringify(contract.bytecode));
const SimpleCoinContractFactory =  new web3.eth.Contract(JSON.parse(JSON.stringify(contract.abi)));


describe('String', function() {
    describe('#length()', function() {
        it('the length of the string "Ethereum" should be 8', function() {
            assert.equal(8, 'Ethereum'.length);
        });
    });
});

describe('SimpleCoin', function() {
    this.timeout(5000);
    describe('SimpleCoin constructor', function() {
        it('Constructor owner is sender', function(done) {
            //arrange 
            let sender = web3.eth.accounts[1];
            let initialSupply = 10000; 

            //act 
            let simpleCoinInstance = SimpleCoinContractFactory.new(initialSupply, {
                from: sender, data: contract.bytecode, gas: web3.eth.estimateGas()},
                function (e, contract) {
                    if(typeof contract.address != 'undefined') {
                        console.log("contract owner address: " + contract.owner()); 
                        console.log("sender address: " + sender);
                        assert.equal(contract.owner(), sender);
                        done(); 
                    }
                });
            });
        });
    });
// });

