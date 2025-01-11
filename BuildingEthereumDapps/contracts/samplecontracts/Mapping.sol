//SPDX-License-Identifier: MIT

pragma solidity >=0.8.7; 

contract Mapping {
    mapping(address => uint) public myMap;

    function updateBalance(uint _sampleUint) public {
        myMap[msg.sender] = _sampleUint;
    }
}