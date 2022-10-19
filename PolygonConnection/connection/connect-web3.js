//Javascript
const Web3 = require('Web3')
const express = require('express');
const application = express()
let solc = require('solc');
let fs = require('fs');

require('dotenv').config()
const privateKey = process.env.PRIVATE_KEY;
console.log("privateKey: " + privateKey);

//Sample server initialization
let port = process.env.PORT 

const source = fs.readFileSync('contracts/Incrementer.sol', 'utf8');

const input = {
    language: 'Solidity',
    sources: {
        'Incrementer.sol' : {
            content: source, 
        },
    },
    settings: {
        outputSelection: {
            '*': {
                '*': ['*'],
            },
        },
    },
};


console.log("Compilation has been completed");

const tempFile = JSON.parse(solc.compile(JSON.stringify(input)));
const contractFile = tempFile.contracts['Incrementer.sol']['Incrementer'];
// console.log("contractFile: ", contractFile);

const bytecode = contractFile.evm.bytecode.object; //bytecode address
const abi = contractFile.abi; 
console.log("bytecode:", bytecode);


// application.get('/', (req, res) => {
//     console.log("hello server"); 
//     res.writeHead(200, {'Content-Type': 'text/plain'}); 
//     res.end('Rockebye');
// });

// application.listen(port, () => {
//     console.log(`Example application is listened on ${port}`)
// });

