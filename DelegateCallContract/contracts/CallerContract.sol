//SPDX-License-Identifier: MIT
pragma solidity >=0.8.7; 

import "./SampleDelegateCall.sol";

contract CallerContract {
    uint256 public value; 
    address public sender; 
    string public name; 
    bool public callSuccess; 
    event Logging(string description, bytes data); 

    constructor() payable {

    }

    function testDelegateCall(string memory _name, SampleDelegateCall _sdc) public payable returns(bool) {
        value = msg.value; 
        sender = msg.sender; 
        name = _name; 
        (bool success, bytes memory data) = payable(address(_sdc)).delegatecall(
            abi.encodeWithSignature("functionToBeCalled(string)", "TestCall"));
        callSuccess = success;
        emit Logging("data in the Caller Contract", data);
        return success;
    }
}