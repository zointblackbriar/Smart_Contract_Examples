const storageContract = artifacts.require("./StorageContract")

module.exports = function(_deployer) {
  // Use deployer to state migration tasks.
  _deployer.deploy(storageContract)
};
