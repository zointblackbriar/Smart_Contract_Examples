//SPDX-License-Identifier: MIT
pragma solidity >=0.8.7; 


struct Money {
    string id; 
    string name;
}

interface Person {
    function name() public virtual returns (string memory) ; 
    function name(string memory newName) public virtual;
    function salary() public returns (Money); 
}

interface Engineer is Person {

}

contract RoleSubtyping {

}