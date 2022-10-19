//SPDX-License-Identifier: MIT
pragma solidity >=0.8.7; 

//This contract is just for Logging and Monitoring for entire system
contract CellMaintenanceAgent {
    event Logging(string description, string problemDefinition); 

    function assignLogging(string memory _description, string memory _problemDefinition) public {
        emit Logging(_description, _problemDefinition);
    }
}