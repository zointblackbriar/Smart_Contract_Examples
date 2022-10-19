//SPDX-License-Identifier: MIT
pragma solidity >=0.8.7; 

import "./FactoryBoxRoles.sol";


//This contract is just for Logging and Monitoring for entire system
contract CellMaintenanceAgent is FactoryBoxRoles {
    event Logging(string description, string problemDefinition); 

    constructor() {
        emit Logging("constructor has been called", "");
    }

    function assignLogging(string memory _description, string memory _problemDefinition) public {
        emit Logging(_description, _problemDefinition);
    }

    function getType() public pure override returns(Constants.ClassType) {
        return Constants.ClassType.CellMaintenanceAgent;
    }

}