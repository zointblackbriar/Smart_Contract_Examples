//server.js is basically a oracle communicator

// Fetch url contents. Supports gzipped content for quicker download, 
// redirects (with automatic cookie handling, so no eternal redirect loops), streaming and piping etc.
var fetch = require('fetch');
var OracleContract = require('./build/contracts/OracleContract.json');
var contract = require('truffle-contract');

var Web3 = require('Web3');
var web3 = new Web3(new Web3.providers.HttpProvider('http://localhost:8545'));

var oraclize = contract(OracleContract);
oraclize.setProvider(web3.currentProvider);

//web3.currentProvider.sendAsync is depricated in Web3 v1.0 and it is replaced with web3.currentProvider.send
if(typeof oraclize.currentProvider.sendAsync !== "function"){
    console.log("true");
    oraclize.currentProvider.sendAsync = function() {
        return oraclize.currentProvider.send.apply(
            oraclize.currentProvider, arguments
        );
    };
} else 
{
    console.log("it is a function");
}

web3.eth.getAccounts((err, accounts) => {
    oraclize.deployed()
        .then((oracleInstance) => {
        oracleInstance.callbackMarketPrice()
        .watch((err, event) => {
            fetch.fetchUrl('https://blockchain.info/ticker', (err, m, b) => {
                //Blockchain price will be taken -- last price
                const result = JSON.parse(b.toString());
                console.log(result.USD.last);
                // const priceList = parseInt(result);

                //Send data back to the chain
                // oraclize.setMarketPrice(priceList, {from: accounts[0]});
            });
        });
    }).catch((err) => {
        console.log(err);
    });
});
