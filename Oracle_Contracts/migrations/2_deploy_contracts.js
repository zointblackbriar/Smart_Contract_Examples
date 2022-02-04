var OracleContract = artifacts.require("OracleContract.sol");

module.exports = function(deployer)
{
    deployer.deploy(OracleContract);
}