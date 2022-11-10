//SPDX-License-Identifier: MIT
pragma solidity >=0.8.7.0; 

import "@openzeppelin/contracts/access/Ownable.sol";

contract Greeter is Ownable{
    string private _greeting = "Sample Message"; 

    function getGreeting() external view returns (string memory) {
        return _greeting; 
    }

    function setGreeting(string calldata greeting) external onlyOwner {
        _greeting = greeting; 
    } 
}