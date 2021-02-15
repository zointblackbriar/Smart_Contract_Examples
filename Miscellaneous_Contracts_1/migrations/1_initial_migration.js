const Migrations = artifacts.require("Migrations");
const depositLoanSimulator = artifacts.require('DepositLoanSimulator');
const ABIEncoding = artifacts.require("ABIEncoding");
const acceptEtherWithLog = artifacts.require('AcceptEtherWithLog');

module.exports = function(deployer) {
  deployer.deploy(Migrations);
  deployer.deploy(depositLoanSimulator);
  deployer.deploy(ABIEncoding);
  deployer.deploy(acceptEtherWithLog);
};
