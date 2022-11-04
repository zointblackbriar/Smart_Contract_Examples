//SPDX-Licence-Identifier: MIT
pragma solidity >=0.8.7; 


struct Money {
    string id; 
    string name;
}

interface MainRole {
    function name() external virtual returns (string memory); 
    function name(string memory newName) external virtual;
    function salary() external virtual returns (Money memory); 
    function budget(Money memory value) external virtual; 
    function numberOfSales(uint value) external virtual; 
}

interface Role1 is MainRole {
    function numberofPatents(uint value) external virtual; 
    function numberOfPatents(uint value) external virtual returns (uint result); 
}

interface Role2 is MainRole {
    function numberOfSales(uint numberOfSales) external override;
}

interface Role3 is MainRole {
    function budget(Money memory value) external override;
}

abstract contract RoleImplementationFlag is MainRole, Role1, Role2, Role3 {
    //Implementing role 2
    function newSalesman(string memory name) public returns (Role1) {
        RoleImplementationFlag sampleObject; 
        
    }
}

contract RoleSubtyping {

}