//SPDX-License-Identifier: MIT
pragma solidity >=0.7.0 <0.9.0;

// Example taken from https://www.ethereum.org/greeter, also used in
// https://github.com/ethereum/go-ethereum/wiki/Contract-Tutorial#your-first-citizen-the-greeter

contract Mortal {
    /* Define variable owner of the type address*/
    address owner;

    /* this function is executed at initialization and sets the owner of the contract */
    constructor() { owner = msg.sender; }

    /* Function to recover the funds on the contract */
    function kill() public  { if (msg.sender == owner) selfdestruct(payable(owner)); }
}