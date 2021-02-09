var OracleContract = artifacts.require("./OracleContract.sol");

module.exports = function(_deployer) {
  // Use deployer to state migration tasks.
  _deployer.deploy(OracleContract);
};
