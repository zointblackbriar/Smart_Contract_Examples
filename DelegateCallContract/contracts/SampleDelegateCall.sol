// The most important difference in the behavior to call is the context. With delegatecall, the target contract works in the same context as the calling contract. This means it can access variables of the calling contract 
// and it sees the same global variables like msg.sender and msg.value.

//SPDX-License-Identifier: MIT
pragma solidity >=0.8.7; 

contract SampleDelegateCall {
    uint256 public value; 
    address public sender; 
    string public name; 


    function functionToBeCalled(string memory _nameTarget) public payable {
        value  = msg.value; 
        sender = msg.sender; 
        name = _nameTarget;
    }
}

