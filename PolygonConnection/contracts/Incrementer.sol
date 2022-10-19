//SPDX-License-Identifier: MIT

pragma solidity ^0.8.9; 

contract Incrementer {
    uint public storageVariable; 

    constructor(uint _initialNumber) {
        storageVariable = _initialNumber; 
    }

    function increment(uint _value) public {
        storageVariable = _value;
    }

    function reset() public {
        storageVariable = 0; 
    }

    function getNumber() public view returns(uint) {
        return storageVariable;
    }
}