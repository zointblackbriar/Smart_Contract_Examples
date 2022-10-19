const CellConfigurator = artifacts.require("CellConfigurator");

module.exports = function (deployer) {
  deployer.deploy(CellConfigurator);
};
