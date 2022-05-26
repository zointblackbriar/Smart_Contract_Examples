//SPDX-License-Identifier: MIT
pragma solidity ^0.8.4; 

contract HelloWorld {
    event SampleEvent( string _oldString, string _newString); 

    string public message; 
    constructor(string memory _message) {
        message = _message; 
    }

    function update(string memory _message) public {
        string memory messageLocal = message; 
        message = _message; //new message for storage variable
        emit SampleEvent(messageLocal, message);
    }
}