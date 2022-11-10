const GreeterContract = artifacts.require("Greeter")
const FundraiserContract = artifacts.require("Fundraiser");

module.exports = function(deployer) {
    deployer.deploy(GreeterContract);
}

module.exports = function(deployer) {
    deployer.deploy(FundraiserContract, "hello", "world", "http://www.sample.com", "sample description");
}