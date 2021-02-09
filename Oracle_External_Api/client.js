//Take the contract abi and bin -- for web3 it is json format
var oracleContract = require('./build/contracts/OracleContract.json');
//truffle-contract -- Better Ethereum contract abstraction, for Node and the browser.
var contract = require('truffle-contract')

var Web3 = require('web3');
var web3 = new Web3(new Web3.providers.HttpProvider('http://localhost:8545'));
console.log("web3: " + web3);


//Truffle interaction with the contract
var oraclize = contract(oracleContract);
oraclize.setProvider(web3.currentProvider);
console.log("oraclize: " + oraclize);

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

web3.eth.getAccounts((err, accounts)=> {
    oraclize.deployed().then((instance) => {
        const oraclePromises = [
            instance.getMarketPrice(), //get current price
            instance.updatePrice({from: accounts[0]}) //Request oracle to update the information 
        ]

        Promise.all(oraclePromises).then((result) => {
            console.log('Market price: ' + result);  //before opening the server.js, there will be no market price.
            console.log('Requesting Oracle to update the information');
        });
    }).catch((err) =>  {
        console.log(err);
    });
});



// https://blockchain.info/ticker
// {
//     "USD": {
//         "15m": 46522.31,
//         "last": 46522.31,
//         "buy": 46522.31,
//         "sell": 46522.31,
//         "symbol": "$"
//     },
//     "AUD": {
//         "15m": 60291.98,
//         "last": 60291.98,
//         "buy": 60291.98,
//         "sell": 60291.98,
//         "symbol": "$"
//     },
//     "BRL": {
//         "15m": 252136.95,
//         "last": 252136.95,
//         "buy": 252136.95,
//         "sell": 252136.95,
//         "symbol": "R$"
//     },
//     "CAD": {
//         "15m": 59356.23,
//         "last": 59356.23,
//         "buy": 59356.23,
//         "sell": 59356.23,
//         "symbol": "$"
//     },
//     "CHF": {
//         "15m": 41575.64,
//         "last": 41575.64,
//         "buy": 41575.64,
//         "sell": 41575.64,
//         "symbol": "CHF"
//     },
//     "CLP": {
//         "15m": 3.406829543E7,
//         "last": 3.406829543E7,
//         "buy": 3.406829543E7,
//         "sell": 3.406829543E7,
//         "symbol": "$"
//     },
//     "CNY": {
//         "15m": 299459.44,
//         "last": 299459.44,
//         "buy": 299459.44,
//         "sell": 299459.44,
//         "symbol": "¥"
//     },
//     "DKK": {
//         "15m": 285975.98,
//         "last": 285975.98,
//         "buy": 285975.98,
//         "sell": 285975.98,
//         "symbol": "kr"
//     },
//     "EUR": {
//         "15m": 38461.16,
//         "last": 38461.16,
//         "buy": 38461.16,
//         "sell": 38461.16,
//         "symbol": "€"
//     },
//     "GBP": {
//         "15m": 33766.08,
//         "last": 33766.08,
//         "buy": 33766.08,
//         "sell": 33766.08,
//         "symbol": "£"
//     },
//     "HKD": {
//         "15m": 360633.95,
//         "last": 360633.95,
//         "buy": 360633.95,
//         "sell": 360633.95,
//         "symbol": "$"
//     },
//     "INR": {
//         "15m": 3391657.68,
//         "last": 3391657.68,
//         "buy": 3391657.68,
//         "sell": 3391657.68,
//         "symbol": "₹"
//     },
//     "ISK": {
//         "15m": 5926011.58,
//         "last": 5926011.58,
//         "buy": 5926011.58,
//         "sell": 5926011.58,
//         "symbol": "kr"
//     },
//     "JPY": {
//         "15m": 4859736.59,
//         "last": 4859736.59,
//         "buy": 4859736.59,
//         "sell": 4859736.59,
//         "symbol": "¥"
//     },
//     "KRW": {
//         "15m": 5.181275182E7,
//         "last": 5.181275182E7,
//         "buy": 5.181275182E7,
//         "sell": 5.181275182E7,
//         "symbol": "₩"
//     },
//     "NZD": {
//         "15m": 64405.62,
//         "last": 64405.62,
//         "buy": 64405.62,
//         "sell": 64405.62,
//         "symbol": "$"
//     },
//     "PLN": {
//         "15m": 172150.26,
//         "last": 172150.26,
//         "buy": 172150.26,
//         "sell": 172150.26,
//         "symbol": "zł"
//     },
//     "RUB": {
//         "15m": 3446657.52,
//         "last": 3446657.52,
//         "buy": 3446657.52,
//         "sell": 3446657.52,
//         "symbol": "RUB"
//     },
//     "SEK": {
//         "15m": 388058.62,
//         "last": 388058.62,
//         "buy": 388058.62,
//         "sell": 388058.62,
//         "symbol": "kr"
//     },
//     "SGD": {
//         "15m": 61783.35,
//         "last": 61783.35,
//         "buy": 61783.35,
//         "sell": 61783.35,
//         "symbol": "$"
//     },
//     "THB": {
//         "15m": 1392407.28,
//         "last": 1392407.28,
//         "buy": 1392407.28,
//         "sell": 1392407.28,
//         "symbol": "฿"
//     },
//     "TRY": {
//         "15m": 329862.05,
//         "last": 329862.05,
//         "buy": 329862.05,
//         "sell": 329862.05,
//         "symbol": "₺"
//     },
//     "TWD": {
//         "15m": 1302508.32,
//         "last": 1302508.32,
//         "buy": 1302508.32,
//         "sell": 1302508.32,
//         "symbol": "NT$"
//     }
// }