"SPDX-License-Identifier: UNLICENSED"
pragma solidity ^0.8.0; 

import "./Token.sol";

contract TokenRecipient {
    event receivedEther(address sender, uint amount); 
    event receivedTokens(address _fromAddress, address _toAddress, bytes _data); 

    function receiveApproval(address _from, uint256 _value, address _token, bytes _data) {
        Token token = Token(_token); 
    }
}
