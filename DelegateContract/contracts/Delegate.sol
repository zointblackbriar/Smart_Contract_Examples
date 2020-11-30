pragma solidity ^0.5.8;
import "./Simple.sol";

contract Delegate{
    Simple public store;

    constructor(Simple _addr) public {
        store = _addr;
        
    }

    function saveValue(uint _x) public returns (bool)
    {
        store.setValue(_x);
        return true; //if it is set
    }

    function getValue() public view returns (uint){
        return store.val();
    }
}