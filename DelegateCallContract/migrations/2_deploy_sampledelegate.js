const SampleDelegateCall = artifacts.require("SampleDelegateCall");

module.exports = function(deployer) {
  deployer.deploy(SampleDelegateCall);
};
