const SimpleCoin = artifacts.require("SimpleCoin"); 

module.exports = function(_deployer) {
  // Use deployer to state migration tasks.
  _deployer.deploy(SimpleCoin); 
};
