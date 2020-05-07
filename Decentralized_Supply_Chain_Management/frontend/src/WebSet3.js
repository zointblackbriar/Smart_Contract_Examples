import Web3 from 'web3';
let supplierFullContract = require('./build/contracts/Supplier.json')
let retailerFullContract = require('./build/contracts/Retailer.json');
let supplierABI = JSON.parse(JSON.stringify(supplierFullContract)).abi;
let retailerABI = JSON.parse(JSON.stringify(retailerFullContract)).abi;

const web3 = new Web3(new Web3.providers.HttpProvider("http://localhost:7545"));
const networkId = web3.version.network;
web3.eth.defaultAccount = web3.eth.accounts[0];
const deployedAddressSupplier = JSON.parse(JSON.stringify(supplierFullContract)).networks[networkId].address;
const deployedAddressRetailer = JSON.parse(JSON.stringify(retailerFullContract)).networks[networkId].address;

const supplierContract = web3.eth.contract(supplierABI).at(deployedAddressSupplier);
const retailerContract = web3.eth.contract(retailerABI).at(deployedAddressRetailer);

export {
    supplierContract,
    retailerContract,
    web3
};