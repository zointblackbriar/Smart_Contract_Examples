//SPDX-License-Identifier: MIT
pragma solidity >=0.8.7;


import "@openzeppelin/contracts/access/Ownable.sol"; 

contract OwnableConcept is Ownable{
    //Define Role Types

    function getNormalThing() public onlyOwner{

    }

    function specialThing() public onlyOwner {

    }
}