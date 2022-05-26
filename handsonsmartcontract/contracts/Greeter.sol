pragma solidity >=0.4.0 <= 0.8.13; 

import "@openzeppelin/contracts/access/Ownable.sol";

contract Greeter is Ownable{
    string private _greeting = "Sample Message"; 

    function greet() external view returns (string memory) {
        return _greeting; 
    }

    function setGreeting(string calldata greeting) external onlyOwner {
        _greeting = greeting; 
    } 
}