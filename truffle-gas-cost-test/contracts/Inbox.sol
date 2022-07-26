pragma solidity ^0.5.0; 

contract Inbox {
    string public message; 

    function setInboxMessage(string memory initialMessage) public {
        message = initialMessage; 
    }

    function setMessage(string memory newMessage) public {
        message = newMessage;
    }
}