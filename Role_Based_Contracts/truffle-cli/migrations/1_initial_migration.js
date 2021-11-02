const Migrations = artifacts.require("./Migrations.sol");


module.exports = function(deployer)  {
  //network, accounts
  deployer.deploy(Migrations);
  // {from: accounts[0]}
  //Additional contracts can be deployed here
};
