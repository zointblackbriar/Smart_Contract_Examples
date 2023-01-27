const AuthenticationNFT = artifacts.require("AuthenticationNFT");

module.exports = function (deployer) {
  deployer.deploy(AuthenticationNFT);
};
