pragma solidity ^0.5.0; 

import "./Contract.sol";

contract ContractFactory {
    function createInstance() public {
        new Contract(); 
    }
}

