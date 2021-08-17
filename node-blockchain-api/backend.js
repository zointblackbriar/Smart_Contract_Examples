const web3 = require('web3');
const express = require('express');
const Tx = require('ethereumjs-tx');

// We need to have manufacturer, delivery company, import customs, shipping company, export customs, delivery company, insurance, supplier,
// and Invoicing system (Electronic invoicing)

const app = express();

//Main Ethereum Provider
// web3js = new web3(new web3.providers.HttpProvider("https://https://mainnet.infura.io/v3/a63f69b8ada5413e8afc2dd41eef444a"));

//local Ethereum Provider
web3js = new web3(new web3.providers.HttpProvider("http://localhost:8545")); 
// if you have infura account this could be valuable for you
app.get('/sendSigned', function(req, res){
    var initialAddress = "the address of the transaction";
    var privateKey = Buffer.from('private key of the account', 'hex');
    var endAddress = "endpoint address for ethereum eth transaction";

    // we need to insert a contract abi
    var contractABI = "The contract abi in JSON Array Format";
    var contractAddress = "YOUR CONTRACT ADDRESS";
    var contract = new web3js.eth.Contract(contractABI, contractAddress);

    var count;
    //get transaction count, later will used as nonce
    // Use fake transaction
    // account is a simple the number of counts
    web3js.eth.getTransactionCount(myAddress).then(function(account){ //async call
       console.log("Count" + account);
       count = account;
       var rawTransaction = {"from":myAddress, 
                            "gasPrice":web3js.utils.toHex(20* 1e9),
                            "gasLimit":web3js.utils.toHex(210000),
                            "to":contractAddress,"value":"0x0",
                            "data":contract.methods.transfer(toAddress, amount).encodeABI(),
                            "nonce":web3js.utils.toHex(count)}

        console.log(rawTransaction);

    });
}); // finish /sendSigned request