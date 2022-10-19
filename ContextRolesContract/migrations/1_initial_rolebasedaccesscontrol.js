const RoleBasedAccessControl = artifacts.require("RoleBasedAccessControl");

module.exports = function(deployer) {
  deployer.deploy(RoleBasedAccessControl);
}
