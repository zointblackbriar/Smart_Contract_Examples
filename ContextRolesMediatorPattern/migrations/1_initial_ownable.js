const OwnableConcept = artifacts.require("OwnableConcept");

module.exports = function(deployer) {
  deployer.deploy(OwnableConcept);
}
