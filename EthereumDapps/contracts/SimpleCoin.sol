//SPDX-License-Identifier: UNLICENSED
pragma solidity >=0.4.22 <0.9.0;


contract SimpleCoin {
    mapping (address => uint256 ) public balanceOfTheCoin; 

    constructor() {
        //address of the balanced coin
        balanceOfTheCoin[0xdDDd207a94a527446C1e9AC5f5009F8515Dea8f1] = 1000; 
    }

    function transfer(address toSomewhere, uint256 predefinedAmount) public {
        balanceOfTheCoin[msg.sender] -= predefinedAmount; 
        balanceOfTheCoin[toSomewhere] += predefinedAmount; 
    }
}