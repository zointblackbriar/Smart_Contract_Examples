//SPDX-License-Identifier: MIT
pragma solidity >=0.8.0;


contract SelectInterfaceID{
    bytes4 internal constant SELECTINTERFACE_ID = 0x75b24222;


}

abstract contract SelectInterface is SelectInterfaceID {
    function getValue() external virtual view returns(uint); 
    function setValue(uint sample) external virtual ;
}