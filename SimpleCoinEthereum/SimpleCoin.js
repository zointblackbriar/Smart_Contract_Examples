const fs = require('fs');
const solc = require('solc');
const Web3 = require('web3');
const web3 = new Web3(new Web3.providers.HttpProvider("http://localhost:8545"));

var assert = require('assert');

const source = fs.readFileSync('filepath', 'utf8');

const compiledContract = solc.compile(source, 1); 
const abi = compiledContract.contracts[':SimpleCoin'].interface; 

const bytecode = '0x' + compiledContract.contracts[':SimpleCoin'].bytecode;

const gasEstimate = web3.eth.estimateGas({data: bytecode}) + 100000; 
console.log("gasEstimate: " + gasEstimate);
const SimpleCoinContractFactory = web3.eth.contract(JSON.parse(abi));
console.log("simple coin contract factory: " + SimpleCoinContractFactory);