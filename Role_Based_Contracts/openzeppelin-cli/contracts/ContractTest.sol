// pragma solidity >=0.4.21 <0.6.0;
pragma solidity ^0.5.17; 

import "@openzeppelin/contracts/ownership/Ownable.sol";


contract ContractTest {
    uint256 public value; 

    //This contract stores a numeric value that is 
    // increased by one every time we send a transaction to the increase() function.
    function increase() public {
        value++;
    }
}

contract Storage is Ownable {
    uint256 private value; 

    function setValue(uint256 _value) public onlyOwner {
        value = _value; 
    }

    function getValue() public returns (uint256) {
        return value; 
    }
}