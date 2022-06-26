const BankContract = artifacts.require("Bank");

module.exports = function(deployer) {
  deployer.deploy(BankContract);
};

