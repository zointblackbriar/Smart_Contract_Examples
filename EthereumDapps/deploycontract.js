const Web3 = require('web3'); 
const solc = require('solc'); 
const fs = require('fs'); 
const config = require('./config.json'); 

web3 = new Web3(new Web3.providers.HttpProvider(config.ETHRPC_IP_PORT)); 
console.log('Web3 version = ' + web3.version); 