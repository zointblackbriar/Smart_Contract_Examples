pragma solidity >= 0.4.0 <=0.8.0;

import "openzeppelin-solidity/contracts/access/Ownable.sol"; //Install the library

contract Greeter is Ownable {
    string private _greeting = "Hello, World"; 

    function greet() external view returns(string memory) {
        return _greeting; 
    }

    function setGreeting(string calldata greeting) external onlyOwner {
        _greeting = greeting; 
    }
}