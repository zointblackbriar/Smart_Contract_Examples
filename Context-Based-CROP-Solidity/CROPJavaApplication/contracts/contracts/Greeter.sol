//SPDX-License-Identifier: MIT
pragma solidity >=0.7.0 <0.9.0;

import "./Mortar.sol";

contract Greeter is Mortal {
    /* define variable greeting of the type string */
    string greeting;

    /* this runs when the contract is executed */
    constructor(string memory _greeting) {
        greeting = _greeting;
    }

    function newGreeting(string memory _greeting) public {
        greeting = _greeting;
    }

    /* main function */
    function greet() public view returns (string memory) {
        return greeting;
    }
}