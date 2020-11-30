pragma solidity ^0.5.8;

contract Simple {
    uint public val;

    constructor(uint _val) public {
        val = _val;
    }

    function setValue(uint _val) public {
        val = _val;
    }
}