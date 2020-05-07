var http = require('http'), port = 4000;
var fs = require('fs');
var Web3 = require('web3');
//var jquery = require('jquery')

// const express = require('express');
// const app = new express();

var server = http.createServer(function(req, res) {
    fs.readFile('index.html', function(err, data) {
        res.writeHead(200, {'Content-type': 'text/html', 'Content-Length':data.length});
        res.write(data)
        res.end();
    });
});

server.listen(port);
console.log("Listening on <insert your favourite ip>:" + port);


if(typeof web3 != 'undefined') 
{
    web3 = new Web3(web3.currentProvider);
}
else 
{
  //set the provider you want from Web3.providers -- web3.js library 1.0
  web3 = new Web3(new Web3.providers.HttpProvider("http://localhost:8545"))
}


console.log("web3 version: " + web3.version);
console.log("web3 account address:"  + web3.eth.personal.accounts[0]);
console.log("web3 net module for interacting with network properties: " + web3.eth.net);
console.log("web3 abi: " + web3.eth.abi);
//console.log("web3 graceful connection to the contract: " + ethers.Contract)
//console.log("web3 eth: " + JSON.parse(JSON.stringify(web3)).eth);
//let abi = web3.eth.abi;
//console.log("abi is: " + JSON.stringify(abi));

web3.eth.getAccounts(function(error, response){
    // this will wait for the response asynchronously 
    if(!error) { // error == 0, so let's process the response
        console.log(response); // print it
        accounts = response;  // remember it
        defaultAccount = accounts[0]; // do something with it
        console.log("default account: " + defaultAccount);
        // carry on
     } else {
        console.error(error); // there was an error, so let's see it.
     }
}) // notice how } marks the end of the function we passed IN to web3.personal.listAccounts() and ) marks the end of the request.


//web3.eth.defaultAccount = web3.eth.personal;
let _accountAddress = web3.eth.personal.accounts[0];
_accountAddress = web3.utils.toChecksumAddress(_accountAddress);
console.log("account address: " + _accountAddress);
const _abi = JSON.parse(JSON.stringify(web3.eth.abi));
let _hardcopyabi = [
	{
		"inputs": [
			{
				"internalType": "string",
				"name": "_fName",
				"type": "string"
			},
			{
				"internalType": "uint256",
				"name": "_age",
				"type": "uint256"
			}
		],
		"name": "setInstructor",
		"outputs": [],
		"stateMutability": "nonpayable",
		"type": "function"
	},
	{
		"inputs": [],
		"name": "getInstructor",
		"outputs": [
			{
				"internalType": "string",
				"name": "",
				"type": "string"
			},
			{
				"internalType": "uint256",
				"name": "",
				"type": "uint256"
			}
		],
		"stateMutability": "view",
		"type": "function"
	}
]




//console.log("web3.eth.default account is: " + web3.eth.defaultAccount);
//const deployedAddressSupplier = JSON.parse(JSON.stringify(supplierFullContract)).networks[networkId].address;

//const _contractAddress = '0x55F62A4fEb26776938d40754855bb9c93D57c82e';
//The **web3.eth.Contract object makes it easy to interact with smart contracts on the ethereum blockchain.
//var CoursesContract = new web3.eth.Contract(_hardcopyabi);
//var Courses = CoursesContract.at(_accountAddress)
//Courses = new web3.eth.Contract(_hardcopyabi, _accountAddress, {from: _accountAddress})
var Courses = new web3.eth.Contract(_hardcopyabi, '0x2751B6dE379DE1E2641A7bBaf9B2360cE3f723b3', {
    from: _accountAddress, // default from address
    gasPrice: '3000000' // default gas price in wei, 20 gwei in this case
});
// get Token balance
Courses.methods.balanceOf(_accountAddress).call()
    .then(function(result){
    //the result holds your Token Balance that you can assign to a var
    var myTokenBalance = result;
    return result;
});

//var contractImplementor = new web3.eth.Contract(_hardcopyabi, _accountAddress);
//Courses.setInstructor('Orcun Oruc', 76);
//Courses.getInstructor();

//console.log(contractImplementor);

// Courses.getInstructor(function(error, result) {
//     if(!error) 
//     {
//         $("#instructor").html(result[0] + ' (' + result[1] + ' years old');
//         console.log(result);
//     }
//     else 
//     {
//         console.log(error);
//     }
// });

// $("#button").click(function() {
//     contractImplementor.setInstructor($("#name").val(), $("#age").val());
// });


