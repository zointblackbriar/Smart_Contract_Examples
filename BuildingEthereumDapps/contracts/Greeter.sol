//SPDX-License-Identifier: MIT

pragma solidity >=0.8.7; 


contract Greeter {
    string private greeting; 
    address private owner;

    constructor(string memory _greeting) {
        greeting = _greeting;
        owner = msg.sender;
    }

    function getGreeting() external view returns(string memory) {
        return greeting;
    }

    function setGreeting(string memory _greeting) external  {
        greeting = _greeting; 
    }

    function getOwner() external view returns(address) {
        return owner;
    }
}