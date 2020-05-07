const MultiAgents  = artifacts.require("MultiAgents");

module.exports = function(deployer) {
  deployer.deploy(MultiAgents);
};

const RoleOriented = artifacts.require("RoleOriented");

module.exports = function(deployer) {
  deployer.deploy(RoleOriented);
}
