import Web3 from 'web3';
// var Net = require('web3-net');
// var net = new Net(Net.givenProvider || 'http://127.0.0.1:8545');
// console.log("net: " + net.getId() );
// let supplierFullContract = require('./build/contracts/Supplier.json');
// let retailerFullContract = require('./build/contracts/Retailer.json');
let supplierFullContract = require('./build/contracts/Supplier.json');
let retailerFullContract = require('./build/contracts/Retailer.json');
// console.log(JSON.parse(JSON.stringify(supplierFullContract)).abi);

let supplierABI = JSON.parse(JSON.stringify(supplierFullContract)).abi;
let retailerABI = JSON.parse(JSON.stringify(retailerFullContract)).abi;

// console.log(supplierABI);
// console.log(retailerABI);

const web3 = new Web3(new Web3.providers.HttpProvider("http://localhost:8545"));
const networkId = web3.version.network;
// const networkId = web3.eth.net.getId().then(console.log);
web3.eth.defaultAccount = web3.eth.accounts[0];
console.log("networkId: " + networkId);
console.log("abi of contract: " + JSON.parse(JSON.stringify(supplierFullContract)).networks);
// console.log("hello world1: " + JSON.parse(JSON.stringify(supplierFullContract)).networks["1648107973172"].address);
// console.log("hello world2: " + JSON.parse(JSON.stringify(retailerFullContract)).networks["1648107973172"].address);

// const deployedAddressSupplier = JSON.parse(JSON.stringify(supplierFullContract)).networks[networkId].address;
// const deployedAddressRetailer = JSON.parse(JSON.stringify(retailerFullContract)).networks[networkId].address;
const deployedAddressSupplier = JSON.parse(JSON.stringify(supplierFullContract)).networks["3227"].address;
const deployedAddressRetailer = JSON.parse(JSON.stringify(retailerFullContract)).networks["3227"].address;

const supplierContract = web3.eth.contract(supplierABI).at(deployedAddressSupplier);
const retailerContract = web3.eth.contract(retailerABI).at(deployedAddressRetailer);
// const supplierContract = new web3.eth.Contract(supplierABI, deployedAddressSupplier);
// const retailerContract = new web3.eth.Contract(retailerABI, deployedAddressRetailer);


export {
    supplierContract,
    retailerContract,
    web3
};