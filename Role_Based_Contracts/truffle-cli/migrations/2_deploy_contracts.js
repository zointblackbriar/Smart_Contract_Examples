
const Person = artifacts.require("./Person.sol");
const Company = artifacts.require("./Company.sol");

module.exports = function(deployer) {
    deployer.deploy(Person) //async deploy 
        .then( () => {
            return deployer.deploy(Company, Person.address); 
             })
        .catch(function(error) {
            console.log(error);
        });
};