var Supplier = artifacts.require("./Supplier.sol");
var Retailer = artifacts.require("./Retailer.sol");

module.exports = function(deployer) {

    deployer.deploy(Supplier, {gas: 1000000}).then(function(){
      return deployer.deploy(Retailer, {gas: 1000000}).then(function(){
      });
    });
  };
  